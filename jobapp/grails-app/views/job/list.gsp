
<%@ page import="com.acme.Job" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'job.label', default: 'Job')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-job" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-job" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="csrRefNo" title="${message(code: 'job.csrRefNo.label', default: 'Csr Ref No')}" />
					
						<g:sortableColumn property="laborCat" title="${message(code: 'job.laborCat.label', default: 'Labor Cat')}" />
					
						<g:sortableColumn property="fullTimeOrPartTime" title="${message(code: 'job.fullTimeOrPartTime.label', default: 'Full Time Or Part Time')}" />
					
						<g:sortableColumn property="requiredClearanceType" title="${message(code: 'job.requiredClearanceType.label', default: 'Required Clearance Type')}" />
					
						<g:sortableColumn property="workLocation" title="${message(code: 'job.workLocation.label', default: 'Work Location')}" />
					
						<g:sortableColumn property="workDescription" title="${message(code: 'job.workDescription.label', default: 'Work Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${jobInstanceList}" status="i" var="jobInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${jobInstance.id}">${fieldValue(bean: jobInstance, field: "csrRefNo")}</g:link></td>
					
						<td>${fieldValue(bean: jobInstance, field: "laborCat")}</td>
					
						<td>${fieldValue(bean: jobInstance, field: "fullTimeOrPartTime")}</td>
					
						<td>${fieldValue(bean: jobInstance, field: "requiredClearanceType")}</td>
					
						<td>${fieldValue(bean: jobInstance, field: "workLocation")}</td>
					
						<td>${fieldValue(bean: jobInstance, field: "workDescription")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${jobInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
