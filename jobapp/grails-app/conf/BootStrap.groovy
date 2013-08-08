import com.acme.Job
import com.acme.DraftJob
import com.acme.JobService

class BootStrap {

  //  07/10/2013  05:53 AM         1,455,076 Draft_CSRs_Block1_2jul13tab.txt
  //  07/11/2013  06:42 AM           441,524 Draft_CSRs_Block1_2jul13.xlsx
  //  07/11/2013  06:42 AM           205,531 Draft_CSRs_block2_3jul13.xlsx
  //  07/11/2013  06:43 AM           607,149 Draft CSRs 10Jul13.xlsx
  //  07/11/2013  06:46 AM         1,455,076 Draft_CSRs_Block1_2jul13.txt
  //  07/11/2013  06:47 AM           646,099 Draft_CSRs_block2_3jul13.txt
  //  07/11/2013  06:48 AM         2,282,670 Draft_CSRs_10Jul13.txt
  //  07/22/2013  06:30 PM         1,429,560 i2S CSRs July 22 2013.xlsx
  //  07/22/2013  06:38 PM         4,192,881 i2S_CSRs_July_22_2013.txt
  //  07/31/2013  05:32 AM         4,173,303 Updated i2S CSRs Dates July 29, 2013.xlsx
  //  07/31/2013  05:37 AM         5,623,446 Updated_i2S_CSRs_Dates_July_29_2013.txt
  //  08/07/2013  06:56 AM           178,619 Final CSRs grp3 5aug13.xlsx
  //  08/07/2013  06:59 AM           606,282 Final_CSRs_grp3_5aug13.txt

  def jobService

  def draftCsrDelim = "DRAFT"
  def finalCsrDelim = "2013-"
  def draftExpectedNumberOfFields = 23 // was 23 in first set of "draft" data (3 files)
  def finalExpectedNumberOfFields = 26 // was 26 in more recent set of "final" data (2 files)
  def draftSourcePrefix = "draftfile"
  def finalSourcePrefix = "finalfile"


  def init = { servletContext ->
    if (Job.count() == 0) {
      //initJobFromTabDelimitedFiles()

      initDraftJobFromTabDelimitedFiles(["/LocalApps/Draft_CSRs_Block1_2jul13.txt",
        "/LocalApps/Draft_CSRs_block2_3jul13.txt", "/LocalApps/Draft_CSRs_10Jul13.txt"],
      draftCsrDelim, draftSourcePrefix, draftExpectedNumberOfFields)

      //      initFinalJobFromTabDelimitedFiles(["/LocalApps/i2S_CSRs_July_22_2013.txt"],
      //      finalCsrDelim, finalExpectedNumberOfFields)

      //      initFinalJobFromTabDelimitedFiles(["/LocalApps/Updated_i2S_CSRs_Dates_July_29_2013.txt"],
      //      finalCsrDelim, finalExpectedNumberOfFields)

      //      initFinalJobFromTabDelimitedFiles(["/LocalApps/Final_CSRs_grp3_5aug13.txt"],
      //      finalCsrDelim, finalExpectedNumberOfFields)

      initFinalJobFromTabDelimitedFiles(["/LocalApps/Updated_i2S_CSRs_Dates_July_29_2013.txt",
        "/LocalApps/Final_CSRs_grp3_5aug13.txt"],
      finalCsrDelim, finalSourcePrefix, finalExpectedNumberOfFields)
    }
  }

  def destroy = {
  }

  def initDraftJobFromTabDelimitedFiles(def filenames, def csrDelim, def sourcePrefix, def expectedNumberOfFields) {
    //    def file = new File("C:\\LocalApps\\jobstabdelim.txt")
    //    def filenames = ["C:\\LocalApps\\Draft_CSRs_Block1_2jul13.txt",
    //      "C:\\LocalApps\\Draft_CSRs_block2_3jul13.txt",
    //      "C:\\LocalApps\\Draft_CSRs_10Jul13.txt"]
    //    def filenames = ["/LocalApps/Draft_CSRs_Block1_2jul13.txt",
    //      "/LocalApps/Draft_CSRs_block2_3jul13.txt",
    //      "/LocalApps/Draft_CSRs_10Jul13.txt"]
    //    def filenames = ["/LocalApps/i2S_CSRs_July_22_2013.txt"]
    def linenum = 0
    def divider = "----------"
    def maxSize = new int[100];
    for (int i = 0 ; i < maxSize.length ; i++) {
      maxSize[i] = 0;
    }
    def filejobs = [:]
    def problems = []
    def failures = []
    def successes = []
    def job = null
    //for (String filename : filenames) {}
    filenames.eachWithIndex {filename, index ->
      def source = "${sourcePrefix}${index+1}"
      println "${filename} = ${source}"
      def buffer = ""
      def file = new File(filename)
      def joblist = []
      filejobs[filename] = joblist
      file.eachLine{line ->
        linenum++
        // if (linenum < 100) { // during testing, only parse first 100 lines
        if (line.startsWith(csrDelim)) {
          divider = "--------------------------------------------------------------------------------"
          // println divider
          // println buffer
          // println divider
          if (buffer && buffer.startsWith(csrDelim)) {
            updateMaxSize(buffer, expectedNumberOfFields, maxSize, filename, problems)
            job = processDraftJobBuffer(buffer)
            if (job && job.csrRefNo) {
              job.source = source
              joblist.add(job.csrRefNo)
              if (!job.save(flush: true)) {
                failures.add(job.csrRefNo)
                job.errors.allErrors.each {
                  println ">>>>> ${job.csrRefNo} $it"
                }
              } else {
                successes.add(job.csrRefNo)
              }
            }
          }
          buffer = ""
        } else {
          divider = "----------"
        }
        if (!buffer) {
          buffer = line
        } else {
          buffer = buffer + "\n" + line
        }
      }
      if (buffer && buffer.startsWith(csrDelim)) {
        updateMaxSize(buffer, expectedNumberOfFields, maxSize, filename, problems)
        job = processDraftJobBuffer(buffer)
        if (job && job.csrRefNo) {
          job.source = source
          joblist.add(job.csrRefNo)
          if (!job.save(flush: true)) {
            failures.add(job.csrRefNo)
            job.errors.allErrors.each {
              println ">>>>> ${job.csrRefNo} $it"
            }
          } else {
            successes.add(job.csrRefNo)
          }
        }
      }
    }
    for (int i = 0 ; i < 50 ; i++) {
      if (maxSize[i] > 0) {
        println "   i = $i   maxSize[i] = ${maxSize[i]}"
      }
    }
    // problems.each{println it}
    def grandTotal = 0
    filejobs.each{key, value ->
      println "$key   ${value.size()}   ${value.sort()}"
      grandTotal += value.size()
    }
    println "grandTotal = $grandTotal"
    println "failures.size() = ${failures.size()}"
    println "successes.size() = ${successes.size()}"
  }


  def initFinalJobFromTabDelimitedFiles(def filenames, def csrDelim, def sourcePrefix, def expectedNumberOfFields) {
    //    def file = new File("C:\\LocalApps\\jobstabdelim.txt")
    //    def filenames = ["C:\\LocalApps\\Draft_CSRs_Block1_2jul13.txt",
    //      "C:\\LocalApps\\Draft_CSRs_block2_3jul13.txt",
    //      "C:\\LocalApps\\Draft_CSRs_10Jul13.txt"]
    //    def filenames = ["/LocalApps/Draft_CSRs_Block1_2jul13.txt",
    //      "/LocalApps/Draft_CSRs_block2_3jul13.txt",
    //      "/LocalApps/Draft_CSRs_10Jul13.txt"]
    //    def filenames = ["/LocalApps/i2S_CSRs_July_22_2013.txt"]
    def linenum = 0
    def divider = "----------"
    def maxSize = new int[100];
    for (int i = 0 ; i < maxSize.length ; i++) {
      maxSize[i] = 0;
    }
    def filejobs = [:]
    def problems = []
    def failures = []
    def successes = []
    def job = null
    //for (String filename : filenames) {}
    filenames.eachWithIndex {filename, index ->
      def source = "${sourcePrefix}${index+1}"
      println "${filename} = ${source}"
      def buffer = ""
      def file = new File(filename)
      def joblist = []
      filejobs[filename] = joblist
      file.eachLine{line ->
        linenum++
        // if (linenum < 100) { // during testing, only parse first 100 lines
        if (line.startsWith(csrDelim)) {
          divider = "--------------------------------------------------------------------------------"
          //           println divider
          //           println buffer
          //           println divider
          if (buffer && buffer.startsWith(csrDelim)) {
            updateMaxSize(buffer, expectedNumberOfFields, maxSize, filename, problems)
            job = processFinalJobBuffer(buffer)
            if (job && job.csrRefNo) {
              job.source = source
              joblist.add(job.csrRefNo)
              if (job?.updateDate && job?.updateDate?.size() > 20) {
                println "${job.csrRefNo} ${job?.updateDate?.size()} >>>>>${job?.updateDate}<<<<<"
              }
              if (!job.save(flush: true)) {
                failures.add(job.csrRefNo)
                job.errors.allErrors.each {
                  println ">>>>> ${job.csrRefNo} $it"
                }
              } else {
                successes.add(job.csrRefNo)
              }
            }
          }
          buffer = ""
        } else {
          divider = "----------"
        }
        if (!buffer) {
          buffer = line
        } else {
          buffer = buffer + "\n" + line
        }
      }
      if (buffer && buffer.startsWith(csrDelim)) {
        updateMaxSize(buffer, expectedNumberOfFields, maxSize, filename, problems)
        job = processFinalJobBuffer(buffer)
        if (job && job.csrRefNo) {
          job.source = source
          joblist.add(job.csrRefNo)
          if (job?.updateDate && job?.updateDate?.size() > 20) {
            println "${job.csrRefNo} ${job?.updateDate?.size()} >>>>>${job?.updateDate}<<<<<"
          }

          if (!job.save(flush: true)) {
            failures.add(job.csrRefNo)
            job.errors.allErrors.each {
              println ">>>>> ${job.csrRefNo} $it"
            }
          } else {
            successes.add(job.csrRefNo)
          }
        }
      }
    }
    for (int i = 0 ; i < 50 ; i++) {
      if (maxSize[i] > 0) {
        println "   i = $i   maxSize[i] = ${maxSize[i]}"
      }
    }
    // problems.each{println it}
    def grandTotal = 0
    filejobs.each{key, value ->
      println "$key   ${value.size()}   ${value.sort()}"
      grandTotal += value.size()
    }
    println "grandTotal = $grandTotal"
    println "failures.size() = ${failures.size()}"
    println "successes.size() = ${successes.size()}"
  }

  def updateMaxSize = {buffer, expectedNumberOfFields, maxSize, filename, problems ->
    // code to process the buffer
    def value = buffer.split("\t")
    def n = value.length
    if (n != expectedNumberOfFields) { // this should not happen, but what if tabs are present in spreadsheet cells
      // in the first set of jobs, DRAFT188 apparently has tabs in one of the spreadsheet cells
      problems.add "$filename  ${value[0]}  $n"
      //      for (int i = 0 ; i < n ; i++) {
      //        if (value[i] && value[i].size() > 0) {
      //          println "   i = $i   size = ${value[i].size()}   value = ${value[i]}"
      //        }
      //      }
    }
    def maxSizeLen = maxSize.length
    if (n > 0) {
      for (int i = 0 ; i < n ; i++) {
        if (i < maxSizeLen && maxSize[i] < value[i].size()) {
          maxSize[i] = value[i].size()
        }
      }
    }
  }

  public Job processFinalJobBuffer(String buffer) {
    def job = null
    // code to process the buffer
    def value = buffer.split("\t")
    def n = value.length
    if (n > 0) {
      job = new Job()
      //job.csrRefNo = value[0]
      int fieldIndex = 0
      def fieldValue = ""
      boolean fieldQuoted = false
      for (int i = 0 ; i < n ; i++) {
        if (!fieldQuoted && value[i].startsWith("\"")) {
          fieldQuoted = true
          fieldValue = ""
        }
        if (fieldQuoted) {
          fieldValue = fieldValue + " " + value[i]
          //println "   i = $i   size = ${value[i].size()}   value = ${value[i]}"
        } else {
          fieldValue = value[i]
        }
        if (fieldQuoted && value[i].endsWith("\"")) {
          fieldQuoted = false
        }
        // println "   i = $i   size = ${value[i].size()}   value = ${value[i]}"
        if (fieldValue) {
          fieldValue = fieldValue.trim()
        }
        switch (fieldIndex) {
          case 0: job.csrRefNo = fieldValue; break;
          case 1: job.laborCat = fieldValue; break;
          case 2: job.performanceLevel = fieldValue; break;
          case 3: job.positionType = fieldValue; break;
          case 4: job.requiredClearanceType = fieldValue; break;
          case 5: job.workLocation = fieldValue; break;
          case 6: job.workDescription = fieldValue; break;
          case 7: job.otherRequiredQualifications = fieldValue; break;
          case 8: job.optionalQualifications = fieldValue; break;
          case 9: job.certificationRequirements = fieldValue; break;
          case 10: job.conusTravel = fieldValue; break;
          case 11: job.oconusTravel = fieldValue; break;
          case 12: job.hoursPerYear = fieldValue; break;
          case 13: job.scheduleComments = fieldValue; break;
          case 14: job.missionCritical = fieldValue; break;
          case 15: job.nightWork = fieldValue; break;
          case 16: job.pov = fieldValue; break;
          case 17: job.pagerDuty = fieldValue; break;
          case 18: job.pagerDutyComments = fieldValue; break;
          case 19: job.holidayWork = fieldValue; break;
          case 20: job.weekendWork = fieldValue; break;
          case 21: job.shiftWork = fieldValue; break;
          case 22: job.warzoneTravel = fieldValue; break;
          case 23: job.coopRequirements = fieldValue; break;
          case 24: job.dateOfStatusChange = fieldValue; break;
          case 25: job.updateDate = fieldValue;
        }
        if (!fieldQuoted) {
          fieldIndex++
        }
      }
      //  println ("job.csrRefNo = ${job.csrRefNo}")
      //  println ("job.laborCat = ${job.laborCat}")
      //  println ("job.fullTimeOrPartTime = ${job.fullTimeOrPartTime}")
      //  println ("job.workLocation = ${job.workLocation}")
      //  println ("job.coopRequirements = ${job.coopRequirements}")

      // job.save(flush:true) // just for unit testing, comment out the save()

      // println ("job.count() = ${job.count()}")
    }
    job
  }

  public DraftJob processDraftJobBuffer(String buffer) {
    def job = null
    // code to process the buffer
    def value = buffer.split("\t")
    def n = value.length
    if (n > 0) {
      job = new DraftJob()
      //job.csrRefNo = value[0]
      int fieldIndex = 0
      def fieldValue = ""
      boolean fieldQuoted = false
      for (int i = 0 ; i < n ; i++) {
        if (!fieldQuoted && value[i].startsWith("\"")) {
          fieldQuoted = true
          fieldValue = ""
        }
        if (fieldQuoted) {
          fieldValue = fieldValue + " " + value[i]
          //println "   i = $i   size = ${value[i].size()}   value = ${value[i]}"
        } else {
          fieldValue = value[i]
        }
        if (fieldQuoted && value[i].endsWith("\"")) {
          fieldQuoted = false
        }
        // println "   i = $i   size = ${value[i].size()}   value = ${value[i]}"
        if (fieldValue) {
          fieldValue = fieldValue.trim()
        }
        switch (fieldIndex) {
          case 0: job.csrRefNo = fieldValue; break;
          case 1: job.laborCat = fieldValue; break;
          case 2: job.fullTimeOrPartTime = fieldValue; break;
          case 3: job.requiredClearanceType = fieldValue; break;
          case 4: job.workLocation = fieldValue; break;
          case 5: job.workDescription = fieldValue; break;
          case 6: job.otherRequiredQualifications = fieldValue; break;
          case 7: job.optionalQualifications = fieldValue; break;
          case 8: job.certificationRequirements = fieldValue; break;
          case 9: job.conusTravel = fieldValue; break;
          case 10: job.oconusTravel = fieldValue; break;
          case 11: job.hoursPerYear = fieldValue; break;
          case 12: job.scheduleComments = fieldValue; break;
          case 13: job.missionCritical = fieldValue; break;
          case 14: job.nightWork = fieldValue; break;
          case 15: job.pov = fieldValue; break;
          case 16: job.pagerDuty = fieldValue; break;
          case 17: job.pagerDutyComments = fieldValue; break;
          case 18: job.holidayWork = fieldValue; break;
          case 19: job.weekendWork = fieldValue; break;
          case 20: job.shiftWork = fieldValue; break;
          case 21: job.warzoneTravel = fieldValue; break;
          case 22: job.coopRequirements = fieldValue;
        }
        if (!fieldQuoted) {
          fieldIndex++
        }
      }
      //  println ("job.csrRefNo = ${job.csrRefNo}")
      //  println ("job.laborCat = ${job.laborCat}")
      //  println ("job.fullTimeOrPartTime = ${job.fullTimeOrPartTime}")
      //  println ("job.workLocation = ${job.workLocation}")
      //  println ("job.coopRequirements = ${job.coopRequirements}")

      // job.save(flush:true) // just for unit testing, comment out the save()

      // println ("job.count() = ${job.count()}")
    }
    job
  }

}
