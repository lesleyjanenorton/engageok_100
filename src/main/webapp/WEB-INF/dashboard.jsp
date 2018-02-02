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
		    <h1><c:out value="${loggedUser.first_name}" /> <c:out value="${loggedUser.last_name}" /> </h1>
		</div>
	
		<div id="nav_bar">
		    	<a href="">Voter's Guide</a>
		    	<a href="">Partners</a>
			<a href="/about">About</a>
			<a href="/profile/${loggedUser.getId()}">Profile</a>
		    	<hr>
	    </div>
	</div>
	
	<div id="issue_areas">
		<div class="issuearea_heading"><h2>Issue Areas</h2></div>
		<div class="blockrow_1">
		    <div class="topicblock">
		    		<p> Education</p>
		    </div>
		    <div class="topicblock">
		    		<p> Criminal Justice</p>
		    </div>
	    </div>
	    <div class="blockrow_2">
		    <div class="topicblock">
		    		<p> Criminal Justice</p>
		    </div>
		    <div class="topicblock">
		    		<p> Local Development</p>
		    </div>
	    </div>
	    <div class="blockrow_2">
		    	<div class="topicblock">
			    		<p> Healthcare </p>
			</div>
			<div class="topicblock">
		    		<p> Legislative Advocacy</p>
		    </div>
	    </div>
	</div>
	
	<div class = "upcomingevents">
		<div class="upcomingevents_heading">
			<h2>Upcoming Events</h2>
			<table>
				<thead>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
				</thead>
				<tbody>
					<c:forEach items="${events }" var="event">
					<tr>
						<td>
							<c:out value="${event.name}"/>
						</td>
						<td>
							<c:out value="${event.date}"/>
						</td>
						<td>
							<c:out value="${event.location}"/>
						</td>
						<td>
							<a href="/eventpage/${event.getId()}">Event Page</a>
						</td>
					</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
		
	</div>
</div>
</body>
</html>