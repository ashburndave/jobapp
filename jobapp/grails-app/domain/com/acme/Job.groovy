package com.acme

class Job {
	String csrRefNo
	String laborCat
	String fullTimeOrPartTime
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
	
	static constraints = {
		csrRefNo (nullable:true)
		laborCat (nullable:true)
		fullTimeOrPartTime (nullable:true)
		requiredClearanceType (nullable:true)
		workLocation (nullable:true)
		workDescription (nullable:true, maxSize:8000) // might need to be a clob
		otherRequiredQualifications (nullable:true, maxSize:5000) // might need to be a clob
		optionalQualifications (nullable:true, maxSize:5000) // might need to be a clob
		certificationRequirements (nullable:true)
		conusTravel (nullable:true)
		oconusTravel (nullable:true)
		hoursPerYear (nullable:true)
		scheduleComments (nullable:true)
		missionCritical (nullable:true)
		nightWork (nullable:true)
		pov (nullable:true)
		pagerDuty (nullable:true)
		pagerDutyComments (nullable:true)
		holidayWork (nullable:true)
		weekendWork (nullable:true)
		shiftWork (nullable:true)
		warzoneTravel (nullable:true)
		coopRequirements (nullable:true)
	}

}

