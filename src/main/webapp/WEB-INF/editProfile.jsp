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
			<form:form method="POST" action="editProfile" modelAttribute="user">
			Current First Name : <c:out value="${loggedUser.getFirst_name() }"/>
				<p>
					<form:label path="first_name">Change First Name To : </form:label>
					<form:input path="first_name"/>
				</p>
					<hr>
			Current Last Name : <c:out value="${loggedUser.getLast_name() }"/>
				<p>
					<form:label path="last_name">Change Last Name To : </form:label>
					<form:input path="last_name"/>
				</p>
					<hr>
			Current Zip Code : <c:out value="${loggedUser.getZipcode() }"/>
				<p>
					<form:label path="zipcode">Change Zip Code To : </form:label>
					<form:input path="zipcode"/>
				</p>
					<hr>
			PASSWORD
				<p>
					<form:label path="password">Change Password To : </form:label>
					<form:input path="password"/>
				</p>
					<hr>
			Current Username : <c:out value="${loggedUser.getUsername() }"/>
				<p>
					<form:label path="username">Change Username To : </form:label>
					<form:input path="username"/>
				</p>
					<hr>
				
				<input type="submit" value="UPDATE"/>
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
</body>
</html>