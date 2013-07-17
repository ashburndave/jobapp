package com.acme

class JobService {

  public Job processBuffer(String buffer) {
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
      job.save(flush:true)
      // println ("job.count() = ${job.count()}")
    }
    job
  }

}
