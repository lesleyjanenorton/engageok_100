<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Organization Creation</title>
</head>
<body>
<div class="container">
	<div class="header">
		<div class="forms">
			<form:form method="POST" action="event_creation" modelAttribute="event">
				<p>
					<form:label path="name">Event Name: </form:label>
					<form:input path="name"/>
				</p>
				<p>
					<form:label path="description">Description (mandatory): </form:label>
					<form:input path="description"/>
				</p>
				
				<input type="submit" value="Create"/>
			</form:form>
		</div>
		<div	 class="errorMessage">
			<c:if test="${errorMessage != null}">
       			<c:out value="${errorMessage}"></c:out>
    			</c:if>
		</div>
	</div>
</div>
</body>
</html>