package com.acme

class Job {
  String csrRefNo
  String laborCat
  String performanceLevel
  String positionType
  //String fullTimeOrPartTime // now positionType
  String requiredClearanceType
  String workLocation
  String workDescription
  String otherRequiredQualifications
  String optionalQualifications
  String certificationRequirements
  String conusTravel
  String oconusTravel
  String hoursPerYear
  String scheduleComments
  String missionCritical
  String nightWork
  String pov
  String pagerDuty
  String pagerDutyComments
  String holidayWork
  String weekendWork
  String shiftWork
  String warzoneTravel
  String coopRequirements

  //  LABOR CATEGORY
  //  PERFORMANCE LEVEL
  //  POSITION TYPE
  //  CLEARANCE REQUIRED
  //  WORK LOCATION
  //  WORK DESCRIPTION
  //  MANDATORY SKILLS
  //  DESIRED SKILLS
  //  CERTIFICATION REQUIREMENTS
  //  CONUS TRAVEL
  //  OCONUS TRAVEL
  //  REGULAR HOURS PER YEAR
  //  SCHEDULE COMMENTS
  //  MISSION CRITICAL
  //  NIGHT WORK
  //  LOCAL TRAVEL USING A POV
  //  PAGER DUTY
  //  PAGER DUTY COMMENTS
  //  WORK ON HOLIDAYS
  //  WORK ON WEEKENDS
  //  SHIFT WORK
  //  WARZONE
  //  COOP
  //  DATE OF STATUS
  //  CHANGE UPDATE DATE

  static searchable = true              // <-- Make Job searchable

  static constraints = {
    csrRefNo (nullable:true)
    laborCat (nullable:true)
    performanceLevel (nullable:true)
    positionType (nullable:true) // now positionType
    // fullTimeOrPartTime (nullable:true)
    requiredClearanceType (nullable:true)
    workLocation (nullable:true)
    workDescription (nullable:true, maxSize:8000) // might need to be a clob
    otherRequiredQualifications (nullable:true, maxSize:5000) // might need to be a clob
    optionalQualifications (nullable:true, maxSize:5000) // might need to be a clob
    certificationRequirements (nullable:true, maxSize:500)
    conusTravel (nullable:true, maxSize:500)
    oconusTravel (nullable:true, maxSize:500)
    hoursPerYear (nullable:true, maxSize:500)
    scheduleComments (nullable:true, maxSize:500)
    missionCritical (nullable:true, maxSize:500)
    nightWork (nullable:true, maxSize:500)
    pov (nullable:true, maxSize:500)
    pagerDuty (nullable:true, maxSize:500)
    pagerDutyComments (nullable:true, maxSize:500)
    holidayWork (nullable:true, maxSize:500)
    weekendWork (nullable:true, maxSize:500)
    shiftWork (nullable:true, maxSize:500)
    warzoneTravel (nullable:true, maxSize:500)
    coopRequirements (nullable:true, maxSize:500)
  }

}

