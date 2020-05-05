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
</head>
<script type="text/javascript">
	function updateList() {
		var input = document.getElementById('files');
		if (input.files.length > 5) {
			input.value = '';
			alert('to many files')
			return;
		}
		var output = document.getElementById('fileList');
		var children = "";
		for (var i = 0; i < input.files.length; ++i) {
			children += '<li>' + input.files.item(i).name + '</li>';
		}
		output.innerHTML = '<ul>' + children + '</ul>';
	}
</script>
<body>
	<h2>Login In</h2>
	<form:form method="POST" action="${contextPath}/login"
		modelAttribute="login" class="form-signin">
		<span>${message}</span>
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

		<input type="file" id="files" name="files" multiple="multiple"
			accept="image/*" onchange="updateList()">
		<p>Selected files:</p>
		<div id="fileList"></div>
		<button type="submit">Submit</button>
		<h4>
			<a href="${contextPath}/register">Create an account</a>
		</h4>
	</form:form>
</body>
</html>