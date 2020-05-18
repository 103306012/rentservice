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
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<link href="resources/css/style.css" rel="stylesheet">
</head>
<script src="bootstrap/js/bootstrap.min.js"></script>
<body>
	<div class="form-signin-heading">
		<a href="${contextPath}/"> <img src="/image/logo.jpg">
		</a>
	</div>
	<form:form method="POST" action="${contextPath}/register"
		modelAttribute="user" class="form-signin">
		<p></p>
		<spring:bind path="username">
			<div
				class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
				<form:input type="text" path="username" class="form-control"
					placeholder="帳號" autofocus="true"></form:input>
				<form:errors path="username"></form:errors>
			</div>
		</spring:bind>
		<p></p>
		<spring:bind path="password">
			<div
				class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
				<form:input type="password" path="password" class="form-control"
					placeholder="密碼"></form:input>
				<form:errors path="password"></form:errors>
			</div>
		</spring:bind>
		<p></p>
		<spring:bind path="name">
			<div
				class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
				<form:input type="text" path="name" class="form-control"
					placeholder="姓名"></form:input>
				<form:errors path="name"></form:errors>
			</div>
		</spring:bind>
		<p></p>
		<spring:bind path="email">
			<div
				class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
				<form:input type="email" path="email" class="form-control"
					placeholder="email"></form:input>
				<form:errors path="email"></form:errors>
			</div>
		</spring:bind>
		<p></p>
		<spring:bind path="birth">
			<div
				class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
				<form:input type="text" path="birth" class="form-control"
					placeholder="出生日期" onfocus="(this.type='date')"
					onblur="(this.type='text')"></form:input>
				<form:errors path="birth"></form:errors>
			</div>
		</spring:bind>
		<p></p>
		<spring:bind path="address">
			<div
				class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
				<form:input type="text" path="address" class="form-control"
					placeholder="地址"></form:input>
				<form:errors path="address"></form:errors>
			</div>
		</spring:bind>
		<p></p>
		<button class="btn btn-lg btn-primary btn-block" type="submit">註冊</button>
	</form:form>
</body>
</html>