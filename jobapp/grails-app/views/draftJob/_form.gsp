<%@ page import="com.acme.DraftJob" %>



<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'source', 'error')} ">
	<label for="source">
		<g:message code="draftJob.source.label" default="Source" />
		
	</label>
	<g:textField name="source" value="${draftJobInstance?.source}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'csrRefNo', 'error')} ">
	<label for="csrRefNo">
		<g:message code="draftJob.csrRefNo.label" default="Csr Ref No" />
		
	</label>
	<g:textField name="csrRefNo" value="${draftJobInstance?.csrRefNo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'laborCat', 'error')} ">
	<label for="laborCat">
		<g:message code="draftJob.laborCat.label" default="Labor Cat" />
		
	</label>
	<g:textField name="laborCat" value="${draftJobInstance?.laborCat}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'fullTimeOrPartTime', 'error')} ">
	<label for="fullTimeOrPartTime">
		<g:message code="draftJob.fullTimeOrPartTime.label" default="Full Time Or Part Time" />
		
	</label>
	<g:textField name="fullTimeOrPartTime" value="${draftJobInstance?.fullTimeOrPartTime}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'requiredClearanceType', 'error')} ">
	<label for="requiredClearanceType">
		<g:message code="draftJob.requiredClearanceType.label" default="Required Clearance Type" />
		
	</label>
	<g:textField name="requiredClearanceType" value="${draftJobInstance?.requiredClearanceType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'workLocation', 'error')} ">
	<label for="workLocation">
		<g:message code="draftJob.workLocation.label" default="Work Location" />
		
	</label>
	<g:textField name="workLocation" value="${draftJobInstance?.workLocation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'workDescription', 'error')} ">
	<label for="workDescription">
		<g:message code="draftJob.workDescription.label" default="Work Description" />
		
	</label>
	<g:textArea name="workDescription" cols="40" rows="5" maxlength="8000" value="${draftJobInstance?.workDescription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'otherRequiredQualifications', 'error')} ">
	<label for="otherRequiredQualifications">
		<g:message code="draftJob.otherRequiredQualifications.label" default="Other Required Qualifications" />
		
	</label>
	<g:textArea name="otherRequiredQualifications" cols="40" rows="5" maxlength="5000" value="${draftJobInstance?.otherRequiredQualifications}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'optionalQualifications', 'error')} ">
	<label for="optionalQualifications">
		<g:message code="draftJob.optionalQualifications.label" default="Optional Qualifications" />
		
	</label>
	<g:textArea name="optionalQualifications" cols="40" rows="5" maxlength="5000" value="${draftJobInstance?.optionalQualifications}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'certificationRequirements', 'error')} ">
	<label for="certificationRequirements">
		<g:message code="draftJob.certificationRequirements.label" default="Certification Requirements" />
		
	</label>
	<g:textArea name="certificationRequirements" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.certificationRequirements}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'conusTravel', 'error')} ">
	<label for="conusTravel">
		<g:message code="draftJob.conusTravel.label" default="Conus Travel" />
		
	</label>
	<g:textArea name="conusTravel" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.conusTravel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'oconusTravel', 'error')} ">
	<label for="oconusTravel">
		<g:message code="draftJob.oconusTravel.label" default="Oconus Travel" />
		
	</label>
	<g:textArea name="oconusTravel" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.oconusTravel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'hoursPerYear', 'error')} ">
	<label for="hoursPerYear">
		<g:message code="draftJob.hoursPerYear.label" default="Hours Per Year" />
		
	</label>
	<g:textArea name="hoursPerYear" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.hoursPerYear}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'scheduleComments', 'error')} ">
	<label for="scheduleComments">
		<g:message code="draftJob.scheduleComments.label" default="Schedule Comments" />
		
	</label>
	<g:textArea name="scheduleComments" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.scheduleComments}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'missionCritical', 'error')} ">
	<label for="missionCritical">
		<g:message code="draftJob.missionCritical.label" default="Mission Critical" />
		
	</label>
	<g:textArea name="missionCritical" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.missionCritical}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'nightWork', 'error')} ">
	<label for="nightWork">
		<g:message code="draftJob.nightWork.label" default="Night Work" />
		
	</label>
	<g:textArea name="nightWork" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.nightWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'pov', 'error')} ">
	<label for="pov">
		<g:message code="draftJob.pov.label" default="Pov" />
		
	</label>
	<g:textArea name="pov" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.pov}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'pagerDuty', 'error')} ">
	<label for="pagerDuty">
		<g:message code="draftJob.pagerDuty.label" default="Pager Duty" />
		
	</label>
	<g:textArea name="pagerDuty" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.pagerDuty}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'pagerDutyComments', 'error')} ">
	<label for="pagerDutyComments">
		<g:message code="draftJob.pagerDutyComments.label" default="Pager Duty Comments" />
		
	</label>
	<g:textArea name="pagerDutyComments" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.pagerDutyComments}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'holidayWork', 'error')} ">
	<label for="holidayWork">
		<g:message code="draftJob.holidayWork.label" default="Holiday Work" />
		
	</label>
	<g:textArea name="holidayWork" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.holidayWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'weekendWork', 'error')} ">
	<label for="weekendWork">
		<g:message code="draftJob.weekendWork.label" default="Weekend Work" />
		
	</label>
	<g:textArea name="weekendWork" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.weekendWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'shiftWork', 'error')} ">
	<label for="shiftWork">
		<g:message code="draftJob.shiftWork.label" default="Shift Work" />
		
	</label>
	<g:textArea name="shiftWork" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.shiftWork}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'warzoneTravel', 'error')} ">
	<label for="warzoneTravel">
		<g:message code="draftJob.warzoneTravel.label" default="Warzone Travel" />
		
	</label>
	<g:textArea name="warzoneTravel" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.warzoneTravel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: draftJobInstance, field: 'coopRequirements', 'error')} ">
	<label for="coopRequirements">
		<g:message code="draftJob.coopRequirements.label" default="Coop Requirements" />
		
	</label>
	<g:textArea name="coopRequirements" cols="40" rows="5" maxlength="500" value="${draftJobInstance?.coopRequirements}"/>
</div>

