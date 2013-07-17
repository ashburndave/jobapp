import com.acme.Job
import com.acme.JobService

class BootStrap {

  // 07/11/2013  06:42 AM           441,524 Draft_CSRs_Block1_2jul13.xlsx
  // 07/11/2013  06:42 AM           205,531 Draft_CSRs_block2_3jul13.xlsx
  // 07/11/2013  06:43 AM           607,149 Draft CSRs 10Jul13.xlsx
  // 07/11/2013  06:46 AM         1,455,076 Draft_CSRs_Block1_2jul13.txt
  // 07/11/2013  06:47 AM           646,099 Draft_CSRs_block2_3jul13.txt
  // 07/11/2013  06:48 AM         2,282,670 Draft_CSRs_10Jul13.txt

  def jobService

  def init = { servletContext ->
    if (Job.count() == 0) {
      initJobFromTabDelimitedFiles()
    }
  }

  def destroy = {
  }

  def initJobFromTabDelimitedFiles() {
    //def file = new File("C:\\LocalApps\\jobstabdelim.txt")
    //      def filenames = ["C:\\LocalApps\\Draft_CSRs_Block1_2jul13.txt",
    //        "C:\\LocalApps\\Draft_CSRs_block2_3jul13.txt",
    //        "C:\\LocalApps\\Draft_CSRs_10Jul13.txt"]
    def filenames = ["/LocalApps/Draft_CSRs_Block1_2jul13.txt",
      "/LocalApps/Draft_CSRs_block2_3jul13.txt",
      "/LocalApps/Draft_CSRs_10Jul13.txt"]
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
        if (line.startsWith("DRAFT")) {
          divider = "--------------------------------------------------------------------------------"
          // println divider
          // println buffer
          // println divider
          if (buffer && buffer.startsWith("DRAFT")) {
            updateMaxSize(buffer, maxSize, filename, problems)
            job = jobService.processBuffer(buffer)
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
      if (buffer && buffer.startsWith("DRAFT")) {
        updateMaxSize(buffer, maxSize, filename, problems)
        job = jobService.processBuffer(buffer)
        if (job && job.csrRefNo) {
          joblist.add(job.csrRefNo)
        }
      }
    }
    for (int i = 0 ; i < 40 ; i++) {
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

  def updateMaxSize = {buffer, maxSize, filename, problems ->
    // code to process the buffer
    def value = buffer.split("\t")
    def n = value.length
    if (n != 23) { // this should not happen, but what if tabs are present in spreadsheet cells
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

}
