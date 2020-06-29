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
<title>Login</title>
<link rel="stylesheet"
	href="${contextPath}/bootstrap/css/bootstrap.min.css" />
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<script src="${contextPath}/bootstrap/js/bootstrap.min.js"></script>

<body>
	<div class="container">
		<div class="form-signin-heading">
			<a href="${contextPath}/"> <img src="/images/logo.jpg">
			</a>
		</div>
		<form:form method="POST" action="${contextPath}/login"
			modelAttribute="login" class="form-signin">
			<spring:bind path="username">
				<div
					class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
					<form:input type="text" path="username" class="form-control"
						placeholder="帳號" autofocus="true"></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="password">
				<div
					class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
					<form:input type="password" path="password" class="form-control"
						placeholder="密碼"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>
			<br>
			<a href="${contextPath}/register"><button
					class="btn btn-lg btn-primary btn-block" type="button">註冊</button></a>
		</form:form>



	</div>
</body>

</html>