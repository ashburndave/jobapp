import com.acme.Job
import com.acme.DraftJob
import com.acme.JobService


class BootStrap {

  // 07/11/2013  06:42 AM           441,524 Draft_CSRs_Block1_2jul13.xlsx
  // 07/11/2013  06:42 AM           205,531 Draft_CSRs_block2_3jul13.xlsx
  // 07/11/2013  06:43 AM           607,149 Draft CSRs 10Jul13.xlsx
  // 07/11/2013  06:46 AM         1,455,076 Draft_CSRs_Block1_2jul13.txt
  // 07/11/2013  06:47 AM           646,099 Draft_CSRs_block2_3jul13.txt
  // 07/11/2013  06:48 AM         2,282,670 Draft_CSRs_10Jul13.txt

  def jobService

  //def csrDelim = "DRAFT"
  //def csrDelim = "2013-"
  //def expectedNumberOfFields = 26 // was 23 in first set of data

  def init = { servletContext ->
    if (Job.count() == 0) {
      //initJobFromTabDelimitedFiles()

      initDraftJobFromTabDelimitedFiles(["/LocalApps/Draft_CSRs_Block1_2jul13.txt",
        "/LocalApps/Draft_CSRs_block2_3jul13.txt",
        "/LocalApps/Draft_CSRs_10Jul13.txt"],"DRAFT",23)

      initJobFromTabDelimitedFiles(["/LocalApps/i2S_CSRs_July_22_2013.txt"],"2013-",26)
    }
  }

  def destroy = {
  }

  def initDraftJobFromTabDelimitedFiles(def filenames, def csrDelim, def expectedNumberOfFields) {
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
    def job = null
    for (String filename : filenames) {
      def buffer = ""
      println filename
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
              joblist.add(job.csrRefNo)
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
          joblist.add(job.csrRefNo)
        }
      }
    }
    for (int i = 0 ; i < 50 ; i++) {
      println "   i = $i   maxSize[i] = ${maxSize[i]}"
    }
    problems.each{println it}
    def grandTotal = 0
    filejobs.each{key, value ->
      println "$key   ${value.size()}   ${value.sort()}"
      grandTotal += value.size()
    }
    println "grandTotal = $grandTotal"
  }


  def initJobFromTabDelimitedFiles(def filenames, def csrDelim, def expectedNumberOfFields) {
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
    def job = null
    for (String filename : filenames) {
      def buffer = ""
      println filename
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
            job = processJobBuffer(buffer)
            if (job && job.csrRefNo) {
              joblist.add(job.csrRefNo)
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
        job = processJobBuffer(buffer)
        if (job && job.csrRefNo) {
          joblist.add(job.csrRefNo)
        }
      }
    }
    for (int i = 0 ; i < 50 ; i++) {
      println "   i = $i   maxSize[i] = ${maxSize[i]}"
    }
    problems.each{println it}
    def grandTotal = 0
    filejobs.each{key, value ->
      println "$key   ${value.size()}   ${value.sort()}"
      grandTotal += value.size()
    }
    println "grandTotal = $grandTotal"
  }

  def updateMaxSize = {buffer, expectedNumberOfFields, maxSize, filename, problems ->
    // code to process the buffer
    def value = buffer.split("\t")
    def n = value.length
    if (n != expectedNumberOfFields) { // this should not happen, but what if tabs are present in spreadsheet cells
      // in the first set of jobs, DRAFT188 apparently has tabs in one of the spreadsheet cells
      problems.add "$filename  ${value[0]}  $n"
      for (int i = 0 ; i < n ; i++) {
        println "   i = $i   size = ${value[i].size()}   value = ${value[i]}"
      }
    }
    if (n > 0) {
      for (int i = 0 ; i < n ; i++) {
        if (maxSize[i] < value[i].size()) {
          maxSize[i] = value[i].size()
        }
      }
    }
  }

  public Job processJobBuffer(String buffer) {
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
          case 23: job.coopRequirements = fieldValue;
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

      job.save(flush:true) // just for unit testing, comment out the save()

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

      job.save(flush:true) // just for unit testing, comment out the save()

      // println ("job.count() = ${job.count()}")
    }
    job
  }

}
