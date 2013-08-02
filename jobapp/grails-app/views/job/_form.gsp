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

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'performanceLevel', 'error')} ">
	<label for="performanceLevel">
		<g:message code="job.performanceLevel.label" default="Performance Level" />
		
	</label>
	<g:textField name="performanceLevel" value="${jobInstance?.performanceLevel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'positionType', 'error')} ">
	<label for="positionType">
		<g:message code="job.positionType.label" default="Position Type" />
		
	</label>
	<g:textField name="positionType" value="${jobInstance?.positionType}"/>
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
	<g:textArea name="certificationRequirements" cols="40" rows="5" maxlength="500" value="${jobInstance?.certificationRequirements}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'conusTravel', 'error')} ">
	<label for="conusTravel">
		<g:message code="job.conusTravel.label" default="Conus Travel" />
		
	</label>
	<g:textArea name="conusTravel" cols="40" rows="5" maxlength="500" value="${jobInstance?.conusTravel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'oconusTravel', 'error')} ">
	<label for="oconusTravel">
		<g:message code="job.oconusTravel.label" default="Oconus Travel" />
		
	</label>
	<g:textArea name="oconusTravel" cols="40" rows="5" maxlength="500" value="${jobInstance?.oconusTravel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'hoursPerYear', 'error')} ">
	<label for="hoursPerYear">
		<g:message code="job.hoursPerYear.label" default="Hours Per Year" />
		
	</label>
	<g:textArea name="hoursPerYear" cols="40" rows="5" maxlength="500" value="${jobInstance?.hoursPerYear}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'scheduleComments', 'error')} ">
	<label for="scheduleComments">
		<g:message code="job.scheduleComments.label" default="Schedule Comments" />
		
	</label>
	<g:textArea name="scheduleComments" cols="40" rows="5" maxlength="500" value="${jobInstance?.scheduleComments}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'missionCritical', 'error')} ">
	<label for="missionCritical">
		<g:message code="job.missionCritical.label" default="Mission Critical" />
		
	</label>
	<g:textArea name="missionCritical" cols="40" rows="5" maxlength="500" value="${jobInstance?.missionCritical}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'nightWork', 'error')} ">
	<label for="nightWork">
		<g:message code="job.nightWork.label" default="Night Work" />
		
	</label>
	<g:textArea name="nightWork" cols="40" rows="5" maxlength="500" value="${jobInstance?.nightWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'pov', 'error')} ">
	<label for="pov">
		<g:message code="job.pov.label" default="Pov" />
		
	</label>
	<g:textArea name="pov" cols="40" rows="5" maxlength="500" value="${jobInstance?.pov}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'pagerDuty', 'error')} ">
	<label for="pagerDuty">
		<g:message code="job.pagerDuty.label" default="Pager Duty" />
		
	</label>
	<g:textArea name="pagerDuty" cols="40" rows="5" maxlength="500" value="${jobInstance?.pagerDuty}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'pagerDutyComments', 'error')} ">
	<label for="pagerDutyComments">
		<g:message code="job.pagerDutyComments.label" default="Pager Duty Comments" />
		
	</label>
	<g:textArea name="pagerDutyComments" cols="40" rows="5" maxlength="500" value="${jobInstance?.pagerDutyComments}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'holidayWork', 'error')} ">
	<label for="holidayWork">
		<g:message code="job.holidayWork.label" default="Holiday Work" />
		
	</label>
	<g:textArea name="holidayWork" cols="40" rows="5" maxlength="500" value="${jobInstance?.holidayWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'weekendWork', 'error')} ">
	<label for="weekendWork">
		<g:message code="job.weekendWork.label" default="Weekend Work" />
		
	</label>
	<g:textArea name="weekendWork" cols="40" rows="5" maxlength="500" value="${jobInstance?.weekendWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'shiftWork', 'error')} ">
	<label for="shiftWork">
		<g:message code="job.shiftWork.label" default="Shift Work" />
		
	</label>
	<g:textArea name="shiftWork" cols="40" rows="5" maxlength="500" value="${jobInstance?.shiftWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'warzoneTravel', 'error')} ">
	<label for="warzoneTravel">
		<g:message code="job.warzoneTravel.label" default="Warzone Travel" />
		
	</label>
	<g:textArea name="warzoneTravel" cols="40" rows="5" maxlength="500" value="${jobInstance?.warzoneTravel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'coopRequirements', 'error')} ">
	<label for="coopRequirements">
		<g:message code="job.coopRequirements.label" default="Coop Requirements" />
		
	</label>
	<g:textArea name="coopRequirements" cols="40" rows="5" maxlength="500" value="${jobInstance?.coopRequirements}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'dateOfStatusChange', 'error')} ">
	<label for="dateOfStatusChange">
		<g:message code="job.dateOfStatusChange.label" default="Date Of Status Change" />
		
	</label>
	<g:textArea name="dateOfStatusChange" cols="40" rows="5" maxlength="500" value="${jobInstance?.dateOfStatusChange}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'updateDate', 'error')} ">
	<label for="updateDate">
		<g:message code="job.updateDate.label" default="Update Date" />
		
	</label>
	<g:textArea name="updateDate" cols="40" rows="5" maxlength="2000" value="${jobInstance?.updateDate}"/>
</div>

