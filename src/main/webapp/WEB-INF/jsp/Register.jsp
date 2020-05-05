<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Register</title>
</head>
<body>
	<h2>Register</h2>
	<form:form method="POST" action="${contextPath}/register"
		modelAttribute="user" class="form-signin">
		<p></p>
		<spring:bind path="username">
			<form:input type="text" path="username" class="form-control"
				placeholder="Username" autofocus="true"></form:input>
			<p></p>
			<form:errors path="username"></form:errors>
		</spring:bind>
		<p></p>
		<spring:bind path="password">
			<form:input type="password" path="password" class="form-control"
				placeholder="Password"></form:input>
			<p></p>
			<form:errors path="password"></form:errors>
		</spring:bind>
		<p></p>
		<form:input type="text" path="name" class="form-control"
			placeholder="name"></form:input>
		<p></p>
		<spring:bind path="email">
			<form:input type="email" path="email" class="form-control"
				placeholder="email"></form:input>
			<p></p>
			<form:errors path="email"></form:errors>
		</spring:bind>
		<p></p>
		<form:input type="date" path="birth" class="form-control"
			placeholder="birth"></form:input>
		<p></p>
		<form:input type="test" path="address" class="form-control"
			placeholder="address"></form:input>
		<p></p>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>