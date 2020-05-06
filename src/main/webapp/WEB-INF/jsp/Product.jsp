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
	<form:form method="POST" action="${contextPath}/addproduct" enctype="multipart/form-data"
		modelAttribute="product" class="form-signin">
		<spring:bind path="name">
			name:<form:input type="text" path="name" class="form-control"
				autofocus="true"></form:input>
			<p></p>
			<form:errors path="name"></form:errors>
		</spring:bind>
		<p></p>
		<spring:bind path="type">
			type:<form:input type="text" path="type" class="form-control"></form:input>
			<p></p>
			<form:errors path="type"></form:errors>
		</spring:bind>
		<p></p>
			detail:<form:textarea path="detail" />
		<p></p>
		<form:errors path="detail"></form:errors>

		<p></p>
		file:<form:input type="file" path="files" multiple="multiple"
			accept="image/*" onchange="updateList()"></form:input>
		<p>Selected files:</p>
		<div id="fileList"></div>
		<button type="submit">Submit</button>

	</form:form>
</body>
</html>