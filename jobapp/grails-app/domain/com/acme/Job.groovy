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
	
	static searchable = true              // <-- Make Job searchable

	static constraints = {
		csrRefNo (nullable:true)
		laborCat (nullable:true)
		fullTimeOrPartTime (nullable:true)
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

