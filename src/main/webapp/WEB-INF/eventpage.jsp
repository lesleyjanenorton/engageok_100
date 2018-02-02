<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/dashboard.css">
<title>Event Page</title>
</head>
<body>
<div id="container">
	<div class="header">
		<div class="logout">
			<form id="logoutForm" method="POST" action="/logout">
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        <input id="logoutButton" type="submit" value="Logout!" />
		    </form>
		</div>
		<div class="username">
		    <h1><c:out value="${event.name}" /> </h1>
		</div>
	
		<div id="nav_bar">
		    	<a href="/">Back to Dashboard</a>
			<a href="/profile/${loggedUser.getId()}">Profile</a>
		    	<hr>
	    </div>
	</div>
	<div class="body">
	<p></p>
		Description: 
		<p> <c:out value="${event.description}"/></p>
		<hr>
		Location: 
		<p> <c:out value="${event.location}"/></p>
		<hr>
		Started By: 
		<p> <c:out value="${userStartedBy.first_name}"/> <c:out value="${userStartedBy.last_name}"/></p>
	</div>
</div>
</body>
</html>