<%@ page import="com.acme.Job" %>



<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'csrRefNo', 'error')} ">
	<label for="csrRefNo">
		<g:message code="job.csrRefNo.label" default="Csr Ref No" />
		
	</label>
	<g:textField name="csrRefNo" value="${jobInstance?.csrRefNo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'laborCat', 'error')} ">
	<label for="laborCat">
		<g:message code="job.laborCat.label" default="Labor Cat" />
		
	</label>
	<g:textField name="laborCat" value="${jobInstance?.laborCat}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'fullTimeOrPartTime', 'error')} ">
	<label for="fullTimeOrPartTime">
		<g:message code="job.fullTimeOrPartTime.label" default="Full Time Or Part Time" />
		
	</label>
	<g:textField name="fullTimeOrPartTime" value="${jobInstance?.fullTimeOrPartTime}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'requiredClearanceType', 'error')} ">
	<label for="requiredClearanceType">
		<g:message code="job.requiredClearanceType.label" default="Required Clearance Type" />
		
	</label>
	<g:textField name="requiredClearanceType" value="${jobInstance?.requiredClearanceType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'workLocation', 'error')} ">
	<label for="workLocation">
		<g:message code="job.workLocation.label" default="Work Location" />
		
	</label>
	<g:textField name="workLocation" value="${jobInstance?.workLocation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'workDescription', 'error')} ">
	<label for="workDescription">
		<g:message code="job.workDescription.label" default="Work Description" />
		
	</label>
	<g:textArea name="workDescription" cols="40" rows="5" maxlength="8000" value="${jobInstance?.workDescription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'otherRequiredQualifications', 'error')} ">
	<label for="otherRequiredQualifications">
		<g:message code="job.otherRequiredQualifications.label" default="Other Required Qualifications" />
		
	</label>
	<g:textArea name="otherRequiredQualifications" cols="40" rows="5" maxlength="5000" value="${jobInstance?.otherRequiredQualifications}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'optionalQualifications', 'error')} ">
	<label for="optionalQualifications">
		<g:message code="job.optionalQualifications.label" default="Optional Qualifications" />
		
	</label>
	<g:textArea name="optionalQualifications" cols="40" rows="5" maxlength="5000" value="${jobInstance?.optionalQualifications}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'certificationRequirements', 'error')} ">
	<label for="certificationRequirements">
		<g:message code="job.certificationRequirements.label" default="Certification Requirements" />
		
	</label>
	<g:textField name="certificationRequirements" value="${jobInstance?.certificationRequirements}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'conusTravel', 'error')} ">
	<label for="conusTravel">
		<g:message code="job.conusTravel.label" default="Conus Travel" />
		
	</label>
	<g:textField name="conusTravel" value="${jobInstance?.conusTravel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'oconusTravel', 'error')} ">
	<label for="oconusTravel">
		<g:message code="job.oconusTravel.label" default="Oconus Travel" />
		
	</label>
	<g:textField name="oconusTravel" value="${jobInstance?.oconusTravel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'hoursPerYear', 'error')} ">
	<label for="hoursPerYear">
		<g:message code="job.hoursPerYear.label" default="Hours Per Year" />
		
	</label>
	<g:textField name="hoursPerYear" value="${jobInstance?.hoursPerYear}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'scheduleComments', 'error')} ">
	<label for="scheduleComments">
		<g:message code="job.scheduleComments.label" default="Schedule Comments" />
		
	</label>
	<g:textField name="scheduleComments" value="${jobInstance?.scheduleComments}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'missionCritical', 'error')} ">
	<label for="missionCritical">
		<g:message code="job.missionCritical.label" default="Mission Critical" />
		
	</label>
	<g:textField name="missionCritical" value="${jobInstance?.missionCritical}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'nightWork', 'error')} ">
	<label for="nightWork">
		<g:message code="job.nightWork.label" default="Night Work" />
		
	</label>
	<g:textField name="nightWork" value="${jobInstance?.nightWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'pov', 'error')} ">
	<label for="pov">
		<g:message code="job.pov.label" default="Pov" />
		
	</label>
	<g:textField name="pov" value="${jobInstance?.pov}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'pagerDuty', 'error')} ">
	<label for="pagerDuty">
		<g:message code="job.pagerDuty.label" default="Pager Duty" />
		
	</label>
	<g:textField name="pagerDuty" value="${jobInstance?.pagerDuty}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'pagerDutyComments', 'error')} ">
	<label for="pagerDutyComments">
		<g:message code="job.pagerDutyComments.label" default="Pager Duty Comments" />
		
	</label>
	<g:textField name="pagerDutyComments" value="${jobInstance?.pagerDutyComments}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'holidayWork', 'error')} ">
	<label for="holidayWork">
		<g:message code="job.holidayWork.label" default="Holiday Work" />
		
	</label>
	<g:textField name="holidayWork" value="${jobInstance?.holidayWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'weekendWork', 'error')} ">
	<label for="weekendWork">
		<g:message code="job.weekendWork.label" default="Weekend Work" />
		
	</label>
	<g:textField name="weekendWork" value="${jobInstance?.weekendWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'shiftWork', 'error')} ">
	<label for="shiftWork">
		<g:message code="job.shiftWork.label" default="Shift Work" />
		
	</label>
	<g:textField name="shiftWork" value="${jobInstance?.shiftWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'warzoneTravel', 'error')} ">
	<label for="warzoneTravel">
		<g:message code="job.warzoneTravel.label" default="Warzone Travel" />
		
	</label>
	<g:textField name="warzoneTravel" value="${jobInstance?.warzoneTravel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'coopRequirements', 'error')} ">
	<label for="coopRequirements">
		<g:message code="job.coopRequirements.label" default="Coop Requirements" />
		
	</label>
	<g:textField name="coopRequirements" value="${jobInstance?.coopRequirements}"/>
</div>

