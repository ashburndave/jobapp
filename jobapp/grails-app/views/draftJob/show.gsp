
<%@ page import="com.acme.DraftJob" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'draftJob.label', default: 'DraftJob')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-draftJob" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-draftJob" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list draftJob">
			
				<g:if test="${draftJobInstance?.source}">
				<li class="fieldcontain">
					<span id="source-label" class="property-label"><g:message code="draftJob.source.label" default="Source" /></span>
					
						<span class="property-value" aria-labelledby="source-label"><g:fieldValue bean="${draftJobInstance}" field="source"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.csrRefNo}">
				<li class="fieldcontain">
					<span id="csrRefNo-label" class="property-label"><g:message code="draftJob.csrRefNo.label" default="Csr Ref No" /></span>
					
						<span class="property-value" aria-labelledby="csrRefNo-label"><g:fieldValue bean="${draftJobInstance}" field="csrRefNo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.laborCat}">
				<li class="fieldcontain">
					<span id="laborCat-label" class="property-label"><g:message code="draftJob.laborCat.label" default="Labor Cat" /></span>
					
						<span class="property-value" aria-labelledby="laborCat-label"><g:fieldValue bean="${draftJobInstance}" field="laborCat"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.fullTimeOrPartTime}">
				<li class="fieldcontain">
					<span id="fullTimeOrPartTime-label" class="property-label"><g:message code="draftJob.fullTimeOrPartTime.label" default="Full Time Or Part Time" /></span>
					
						<span class="property-value" aria-labelledby="fullTimeOrPartTime-label"><g:fieldValue bean="${draftJobInstance}" field="fullTimeOrPartTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.requiredClearanceType}">
				<li class="fieldcontain">
					<span id="requiredClearanceType-label" class="property-label"><g:message code="draftJob.requiredClearanceType.label" default="Required Clearance Type" /></span>
					
						<span class="property-value" aria-labelledby="requiredClearanceType-label"><g:fieldValue bean="${draftJobInstance}" field="requiredClearanceType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.workLocation}">
				<li class="fieldcontain">
					<span id="workLocation-label" class="property-label"><g:message code="draftJob.workLocation.label" default="Work Location" /></span>
					
						<span class="property-value" aria-labelledby="workLocation-label"><g:fieldValue bean="${draftJobInstance}" field="workLocation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.workDescription}">
				<li class="fieldcontain">
					<span id="workDescription-label" class="property-label"><g:message code="draftJob.workDescription.label" default="Work Description" /></span>
					
						<span class="property-value" aria-labelledby="workDescription-label"><g:fieldValue bean="${draftJobInstance}" field="workDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.otherRequiredQualifications}">
				<li class="fieldcontain">
					<span id="otherRequiredQualifications-label" class="property-label"><g:message code="draftJob.otherRequiredQualifications.label" default="Other Required Qualifications" /></span>
					
						<span class="property-value" aria-labelledby="otherRequiredQualifications-label"><g:fieldValue bean="${draftJobInstance}" field="otherRequiredQualifications"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.optionalQualifications}">
				<li class="fieldcontain">
					<span id="optionalQualifications-label" class="property-label"><g:message code="draftJob.optionalQualifications.label" default="Optional Qualifications" /></span>
					
						<span class="property-value" aria-labelledby="optionalQualifications-label"><g:fieldValue bean="${draftJobInstance}" field="optionalQualifications"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.certificationRequirements}">
				<li class="fieldcontain">
					<span id="certificationRequirements-label" class="property-label"><g:message code="draftJob.certificationRequirements.label" default="Certification Requirements" /></span>
					
						<span class="property-value" aria-labelledby="certificationRequirements-label"><g:fieldValue bean="${draftJobInstance}" field="certificationRequirements"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.conusTravel}">
				<li class="fieldcontain">
					<span id="conusTravel-label" class="property-label"><g:message code="draftJob.conusTravel.label" default="Conus Travel" /></span>
					
						<span class="property-value" aria-labelledby="conusTravel-label"><g:fieldValue bean="${draftJobInstance}" field="conusTravel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.oconusTravel}">
				<li class="fieldcontain">
					<span id="oconusTravel-label" class="property-label"><g:message code="draftJob.oconusTravel.label" default="Oconus Travel" /></span>
					
						<span class="property-value" aria-labelledby="oconusTravel-label"><g:fieldValue bean="${draftJobInstance}" field="oconusTravel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.hoursPerYear}">
				<li class="fieldcontain">
					<span id="hoursPerYear-label" class="property-label"><g:message code="draftJob.hoursPerYear.label" default="Hours Per Year" /></span>
					
						<span class="property-value" aria-labelledby="hoursPerYear-label"><g:fieldValue bean="${draftJobInstance}" field="hoursPerYear"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.scheduleComments}">
				<li class="fieldcontain">
					<span id="scheduleComments-label" class="property-label"><g:message code="draftJob.scheduleComments.label" default="Schedule Comments" /></span>
					
						<span class="property-value" aria-labelledby="scheduleComments-label"><g:fieldValue bean="${draftJobInstance}" field="scheduleComments"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.missionCritical}">
				<li class="fieldcontain">
					<span id="missionCritical-label" class="property-label"><g:message code="draftJob.missionCritical.label" default="Mission Critical" /></span>
					
						<span class="property-value" aria-labelledby="missionCritical-label"><g:fieldValue bean="${draftJobInstance}" field="missionCritical"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.nightWork}">
				<li class="fieldcontain">
					<span id="nightWork-label" class="property-label"><g:message code="draftJob.nightWork.label" default="Night Work" /></span>
					
						<span class="property-value" aria-labelledby="nightWork-label"><g:fieldValue bean="${draftJobInstance}" field="nightWork"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.pov}">
				<li class="fieldcontain">
					<span id="pov-label" class="property-label"><g:message code="draftJob.pov.label" default="Pov" /></span>
					
						<span class="property-value" aria-labelledby="pov-label"><g:fieldValue bean="${draftJobInstance}" field="pov"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.pagerDuty}">
				<li class="fieldcontain">
					<span id="pagerDuty-label" class="property-label"><g:message code="draftJob.pagerDuty.label" default="Pager Duty" /></span>
					
						<span class="property-value" aria-labelledby="pagerDuty-label"><g:fieldValue bean="${draftJobInstance}" field="pagerDuty"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.pagerDutyComments}">
				<li class="fieldcontain">
					<span id="pagerDutyComments-label" class="property-label"><g:message code="draftJob.pagerDutyComments.label" default="Pager Duty Comments" /></span>
					
						<span class="property-value" aria-labelledby="pagerDutyComments-label"><g:fieldValue bean="${draftJobInstance}" field="pagerDutyComments"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.holidayWork}">
				<li class="fieldcontain">
					<span id="holidayWork-label" class="property-label"><g:message code="draftJob.holidayWork.label" default="Holiday Work" /></span>
					
						<span class="property-value" aria-labelledby="holidayWork-label"><g:fieldValue bean="${draftJobInstance}" field="holidayWork"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.weekendWork}">
				<li class="fieldcontain">
					<span id="weekendWork-label" class="property-label"><g:message code="draftJob.weekendWork.label" default="Weekend Work" /></span>
					
						<span class="property-value" aria-labelledby="weekendWork-label"><g:fieldValue bean="${draftJobInstance}" field="weekendWork"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.shiftWork}">
				<li class="fieldcontain">
					<span id="shiftWork-label" class="property-label"><g:message code="draftJob.shiftWork.label" default="Shift Work" /></span>
					
						<span class="property-value" aria-labelledby="shiftWork-label"><g:fieldValue bean="${draftJobInstance}" field="shiftWork"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.warzoneTravel}">
				<li class="fieldcontain">
					<span id="warzoneTravel-label" class="property-label"><g:message code="draftJob.warzoneTravel.label" default="Warzone Travel" /></span>
					
						<span class="property-value" aria-labelledby="warzoneTravel-label"><g:fieldValue bean="${draftJobInstance}" field="warzoneTravel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${draftJobInstance?.coopRequirements}">
				<li class="fieldcontain">
					<span id="coopRequirements-label" class="property-label"><g:message code="draftJob.coopRequirements.label" default="Coop Requirements" /></span>
					
						<span class="property-value" aria-labelledby="coopRequirements-label"><g:fieldValue bean="${draftJobInstance}" field="coopRequirements"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${draftJobInstance?.id}" />
					<g:link class="edit" action="edit" id="${draftJobInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
