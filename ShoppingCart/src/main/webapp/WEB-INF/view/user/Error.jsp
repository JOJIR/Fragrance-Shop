<%@ include file="Header.jsp"%>
	<div style="text-align: center; height: 400px;">
	<h1>HTTP Error - Access Denied</h1>
	<c:if test="${not empty pageContext.request.userPrincipal}">
	    	User: <c:out value="${pageContext.request.userPrincipal.name}" />
		</c:if>
	</div>
	<%@ include file="Footer.jsp"%>

