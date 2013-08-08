
<%@ page import="com.acme.Job" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'job.label', default: 'Job')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-job" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-job" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list job">
			
				<g:if test="${jobInstance?.source}">
				<li class="fieldcontain">
					<span id="source-label" class="property-label"><g:message code="job.source.label" default="Source" /></span>
					
						<span class="property-value" aria-labelledby="source-label"><g:fieldValue bean="${jobInstance}" field="source"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.csrRefNo}">
				<li class="fieldcontain">
					<span id="csrRefNo-label" class="property-label"><g:message code="job.csrRefNo.label" default="Csr Ref No" /></span>
					
						<span class="property-value" aria-labelledby="csrRefNo-label"><g:fieldValue bean="${jobInstance}" field="csrRefNo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.laborCat}">
				<li class="fieldcontain">
					<span id="laborCat-label" class="property-label"><g:message code="job.laborCat.label" default="Labor Cat" /></span>
					
						<span class="property-value" aria-labelledby="laborCat-label"><g:fieldValue bean="${jobInstance}" field="laborCat"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.performanceLevel}">
				<li class="fieldcontain">
					<span id="performanceLevel-label" class="property-label"><g:message code="job.performanceLevel.label" default="Performance Level" /></span>
					
						<span class="property-value" aria-labelledby="performanceLevel-label"><g:fieldValue bean="${jobInstance}" field="performanceLevel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.positionType}">
				<li class="fieldcontain">
					<span id="positionType-label" class="property-label"><g:message code="job.positionType.label" default="Position Type" /></span>
					
						<span class="property-value" aria-labelledby="positionType-label"><g:fieldValue bean="${jobInstance}" field="positionType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.requiredClearanceType}">
				<li class="fieldcontain">
					<span id="requiredClearanceType-label" class="property-label"><g:message code="job.requiredClearanceType.label" default="Required Clearance Type" /></span>
					
						<span class="property-value" aria-labelledby="requiredClearanceType-label"><g:fieldValue bean="${jobInstance}" field="requiredClearanceType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.workLocation}">
				<li class="fieldcontain">
					<span id="workLocation-label" class="property-label"><g:message code="job.workLocation.label" default="Work Location" /></span>
					
						<span class="property-value" aria-labelledby="workLocation-label"><g:fieldValue bean="${jobInstance}" field="workLocation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.workDescription}">
				<li class="fieldcontain">
					<span id="workDescription-label" class="property-label"><g:message code="job.workDescription.label" default="Work Description" /></span>
					
						<span class="property-value" aria-labelledby="workDescription-label"><g:fieldValue bean="${jobInstance}" field="workDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.otherRequiredQualifications}">
				<li class="fieldcontain">
					<span id="otherRequiredQualifications-label" class="property-label"><g:message code="job.otherRequiredQualifications.label" default="Other Required Qualifications" /></span>
					
						<span class="property-value" aria-labelledby="otherRequiredQualifications-label"><g:fieldValue bean="${jobInstance}" field="otherRequiredQualifications"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.optionalQualifications}">
				<li class="fieldcontain">
					<span id="optionalQualifications-label" class="property-label"><g:message code="job.optionalQualifications.label" default="Optional Qualifications" /></span>
					
						<span class="property-value" aria-labelledby="optionalQualifications-label"><g:fieldValue bean="${jobInstance}" field="optionalQualifications"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.certificationRequirements}">
				<li class="fieldcontain">
					<span id="certificationRequirements-label" class="property-label"><g:message code="job.certificationRequirements.label" default="Certification Requirements" /></span>
					
						<span class="property-value" aria-labelledby="certificationRequirements-label"><g:fieldValue bean="${jobInstance}" field="certificationRequirements"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.conusTravel}">
				<li class="fieldcontain">
					<span id="conusTravel-label" class="property-label"><g:message code="job.conusTravel.label" default="Conus Travel" /></span>
					
						<span class="property-value" aria-labelledby="conusTravel-label"><g:fieldValue bean="${jobInstance}" field="conusTravel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.oconusTravel}">
				<li class="fieldcontain">
					<span id="oconusTravel-label" class="property-label"><g:message code="job.oconusTravel.label" default="Oconus Travel" /></span>
					
						<span class="property-value" aria-labelledby="oconusTravel-label"><g:fieldValue bean="${jobInstance}" field="oconusTravel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.hoursPerYear}">
				<li class="fieldcontain">
					<span id="hoursPerYear-label" class="property-label"><g:message code="job.hoursPerYear.label" default="Hours Per Year" /></span>
					
						<span class="property-value" aria-labelledby="hoursPerYear-label"><g:fieldValue bean="${jobInstance}" field="hoursPerYear"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.scheduleComments}">
				<li class="fieldcontain">
					<span id="scheduleComments-label" class="property-label"><g:message code="job.scheduleComments.label" default="Schedule Comments" /></span>
					
						<span class="property-value" aria-labelledby="scheduleComments-label"><g:fieldValue bean="${jobInstance}" field="scheduleComments"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.missionCritical}">
				<li class="fieldcontain">
					<span id="missionCritical-label" class="property-label"><g:message code="job.missionCritical.label" default="Mission Critical" /></span>
					
						<span class="property-value" aria-labelledby="missionCritical-label"><g:fieldValue bean="${jobInstance}" field="missionCritical"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.nightWork}">
				<li class="fieldcontain">
					<span id="nightWork-label" class="property-label"><g:message code="job.nightWork.label" default="Night Work" /></span>
					
						<span class="property-value" aria-labelledby="nightWork-label"><g:fieldValue bean="${jobInstance}" field="nightWork"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.pov}">
				<li class="fieldcontain">
					<span id="pov-label" class="property-label"><g:message code="job.pov.label" default="Pov" /></span>
					
						<span class="property-value" aria-labelledby="pov-label"><g:fieldValue bean="${jobInstance}" field="pov"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.pagerDuty}">
				<li class="fieldcontain">
					<span id="pagerDuty-label" class="property-label"><g:message code="job.pagerDuty.label" default="Pager Duty" /></span>
					
						<span class="property-value" aria-labelledby="pagerDuty-label"><g:fieldValue bean="${jobInstance}" field="pagerDuty"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.pagerDutyComments}">
				<li class="fieldcontain">
					<span id="pagerDutyComments-label" class="property-label"><g:message code="job.pagerDutyComments.label" default="Pager Duty Comments" /></span>
					
						<span class="property-value" aria-labelledby="pagerDutyComments-label"><g:fieldValue bean="${jobInstance}" field="pagerDutyComments"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.holidayWork}">
				<li class="fieldcontain">
					<span id="holidayWork-label" class="property-label"><g:message code="job.holidayWork.label" default="Holiday Work" /></span>
					
						<span class="property-value" aria-labelledby="holidayWork-label"><g:fieldValue bean="${jobInstance}" field="holidayWork"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.weekendWork}">
				<li class="fieldcontain">
					<span id="weekendWork-label" class="property-label"><g:message code="job.weekendWork.label" default="Weekend Work" /></span>
					
						<span class="property-value" aria-labelledby="weekendWork-label"><g:fieldValue bean="${jobInstance}" field="weekendWork"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.shiftWork}">
				<li class="fieldcontain">
					<span id="shiftWork-label" class="property-label"><g:message code="job.shiftWork.label" default="Shift Work" /></span>
					
						<span class="property-value" aria-labelledby="shiftWork-label"><g:fieldValue bean="${jobInstance}" field="shiftWork"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.warzoneTravel}">
				<li class="fieldcontain">
					<span id="warzoneTravel-label" class="property-label"><g:message code="job.warzoneTravel.label" default="Warzone Travel" /></span>
					
						<span class="property-value" aria-labelledby="warzoneTravel-label"><g:fieldValue bean="${jobInstance}" field="warzoneTravel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.coopRequirements}">
				<li class="fieldcontain">
					<span id="coopRequirements-label" class="property-label"><g:message code="job.coopRequirements.label" default="Coop Requirements" /></span>
					
						<span class="property-value" aria-labelledby="coopRequirements-label"><g:fieldValue bean="${jobInstance}" field="coopRequirements"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.dateOfStatusChange}">
				<li class="fieldcontain">
					<span id="dateOfStatusChange-label" class="property-label"><g:message code="job.dateOfStatusChange.label" default="Date Of Status Change" /></span>
					
						<span class="property-value" aria-labelledby="dateOfStatusChange-label"><g:fieldValue bean="${jobInstance}" field="dateOfStatusChange"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${jobInstance?.updateDate}">
				<li class="fieldcontain">
					<span id="updateDate-label" class="property-label"><g:message code="job.updateDate.label" default="Update Date" /></span>
					
						<span class="property-value" aria-labelledby="updateDate-label"><g:fieldValue bean="${jobInstance}" field="updateDate"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${jobInstance?.id}" />
					<g:link class="edit" action="edit" id="${jobInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
