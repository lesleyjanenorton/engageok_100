<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/dashboard.css">
<title>User Profile</title>
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
		    <h1>About EON</h1>
		</div>
	
		<div id="nav_bar">
		    	<a href="/">Back To Dashboard</a>
		    	<a href="">Partners</a>
			<a href="/profile/${loggedUser.getId()}">Profile</a>
		    	<hr>
	    </div>
	</div>
	<div class="missionStatement">
		<h2>Our goal is to become a central conduit for passionate individuals that want to become involved in their community</h2>
	</div>
	<hr>
	<div class="body">
		<p>By invigorating the way Tulsa and the greater Oklahoma community approaches civic engagement, we can change the political atmosphere of Oklahoma through a comprehensive development strategy which includes fundraising, volunteerism, digital media, and partnerships with existing nonprofits.</p>
		<hr>
		<p>Civic engagement culminates through voter education and we hope to act as a central location for non-partisan, up-to-date information on local and state elections and candidates.</p>
		<hr>
		<p></p>
	</div>
	
	
</div>
</body>
</html>