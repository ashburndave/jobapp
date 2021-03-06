
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

        <g:form controller="jobQuery" action="list">
          <g:select name="querySource" from="${session.sourcePicklist}" value="${params.querySource}" noSelection="['':'-Choose a source-']"/>
          <g:select name="queryLaborCat" from="${session.laborCatPicklist}" value="${params.queryLaborCat}" noSelection="['':'-Choose a labor category-']"/>
          <g:select name="queryPerfLev" from="${session.perfLevelPicklist}" value="${params.queryPerfLev}" noSelection="['':'-Choose a performance level-']"/>
          <g:select name="queryWorkLoc" from="${session.workLocPicklist}" value="${params.queryWorkLoc}" noSelection="['':'-Choose a work location-']"/>
          <g:if test="${params.max}">
            <g:hiddenField name="max" value="${params.max}" />
          </g:if>         
          <g:if test="${params.offset}">
            <g:hiddenField name="offset" value="${params.offset}" />
          </g:if>         
          <g:if test="${params.sort}">
            <g:hiddenField name="sort" value="${params.sort}" />
          </g:if>          
          <g:if test="${params.order}">
            <g:hiddenField name="order" value="${params.order}" />
          </g:if>
          <input type="submit" value="Run Query" />
        </g:form>
        		
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
					
            <g:sortableColumn property="performanceLevel" title="${message(code: 'job.performanceLevel.label', default: 'Performance Level')}" />
          
            <g:sortableColumn property="positionType" title="${message(code: 'job.positionType.label', default: 'Position Type')}" />
          
						<g:sortableColumn property="requiredClearanceType" title="${message(code: 'job.requiredClearanceType.label', default: 'Required Clearance Type')}" />
					
						<g:sortableColumn property="workLocation" title="${message(code: 'job.workLocation.label', default: 'Work Location')}" />					
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${jobInstanceList}" status="i" var="jobInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${jobInstance.id}">${fieldValue(bean: jobInstance, field: "csrRefNo")}</g:link></td>
					
						<td>${fieldValue(bean: jobInstance, field: "laborCat")}</td>
					
            <td>${fieldValue(bean: jobInstance, field: "performanceLevel")}</td>
          
            <td>${fieldValue(bean: jobInstance, field: "positionType")}</td>
          
						<td>${fieldValue(bean: jobInstance, field: "requiredClearanceType")}</td>
					
						<td>${fieldValue(bean: jobInstance, field: "workLocation")}</td>					
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${jobInstanceTotal}" params="${params}" />
			</div>
		</div>
	</body>
</html>
