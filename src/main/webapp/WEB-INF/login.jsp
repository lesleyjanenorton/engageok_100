<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Login</title>
</head>
<body>
	<div class="header">
	<c:if test="${logoutMessage != null}">
        <c:out value="${logoutMessage}"></c:out>
    </c:if>
    <div class="registration">
    <h1>Register!</h1>
    
    <p class="errors"><form:errors path="user.*"/></p>
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="email">Email :</form:label>
            <form:input path="email"/>
        </p>
        <p>
            <form:label path="first_name">First Name :</form:label>
            <form:input path="first_name"/>
        </p>
        <p>
            <form:label path="last_name">Last Name :</form:label>
            <form:input path="last_name"/>
        </p>
        <p>
            <form:label path="username">Username :</form:label>
            <form:input path="username"/>
        </p>
        <p>
            <form:label path="password">Password :</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation :</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>

    <c:if test="${regSuc != null}">

    		<p class="success"> <c:out value="${regSuc}"/> </p>

    </c:if>
    </div>

<h1>Login</h1>
	<div class="login">
    <form method="POST" action="/login">
        <p>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login!"/>
    </form>
    <p></p>
	<p class="errorMessage">
	<c:if test="${errorMessage != null}">
        <c:out value="${errorMessage}"></c:out>
    </c:if>
    </p>
    </div>
	</div>
</body>

</html>