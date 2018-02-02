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
		    <h1>Hey <c:out value="${user.first_name}" />! </h1>
		</div>
		
		<p></p>
		<div id="nav_bar">
		    	<a href="/editProfile/${user.getId() }">Review Profile</a>
			<a href="">Preferences</a>
			<a href="/organization_creation">Organizations</a>
			<a href="/">Back to Dashboard</a>
		    	<hr>
	    </div>
	</div>
	
	<div id="myOrgs">
		<div class="issuearea_heading"><h2>Organizations Seeking Volunteers</h2></div>
		<table>
			<thead>
				<th>Name</th>
				<th>HQ</th>
				<th>Upcoming Events</th>
			</thead>
			<tbody>
				<c:forEach items="${userOrgs }" var="userOrgs">
				<tr>
					<td>
						
							<c:out value="${userOrgs.name}"/>
						
					</td>
					<td>
						
							<c:out value="${userOrgs.location}"/>
						
					</td>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<hr>
	<div id="myAdmins">
	<c:choose>
		<c:when test="${userOrg.local_admin != user.getId()}">
		<div class="issuearea_heading"><h2>Pages I Admin</h2></div>
		<table>
			<thead>
				<th>Name</th>
				<th>HQ</th>
				<th>Total Activists</th>
				<th>Create an Event</th>
			</thead>
			<tbody>
				<c:forEach items="${userOrgs }" var="userOrg">
				<tr>
					<td>
						<c:choose>
							<c:when test="${userOrg.local_admin == user.getId()}">
								<c:out value="${userOrg.name}"/>
							</c:when>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${userOrg.local_admin == user.getId()}">
								<c:out value="${userOrg.location}"/>
							</c:when>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${userOrg.local_admin == user.getId()}">
								- <c:out value="${userOrg.numberOfActivists}"/>
							</c:when>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${userOrg.local_admin == user.getId()}">
								<a href="/event_creation/${userOrg.getId()}"><span>Start</span></a>
							</c:when>
						</c:choose>
					</td>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:when>
	</c:choose>
	</div>
	<hr>
	
		
			
			<div class="upcomingevents_heading">
			<h2>Upcoming Events</h2>
			<table>
				<thead>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
				</thead>
				<tbody>
					<c:forEach items="${userEvents }" var="event">
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
					</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
		
		
	
</div>
</body>
</html>