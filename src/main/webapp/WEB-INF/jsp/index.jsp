<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
</head>
<body>
	<h2>Login in</h2>
	<form:form method="POST" action="/login" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><spring:bind path="username">
						<form:input type="text" path="username" autofocus="true"></form:input>
						<form:errors path="username"></form:errors>
					</spring:bind></td>

			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><spring:bind path="password">
						<form:input type="password" path="password"></form:input>
						<form:errors path="password"></form:errors>
					</spring:bind></td>
			</tr>
			<tr>
				<td>
					<button type="submit">Submit</button>
				</td>
			</tr>
		</table>
	</form:form>

</body>

</html>