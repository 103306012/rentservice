<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料</title>
<link rel="stylesheet"
	href="${contextPath}/bootstrap/css/bootstrap.min.css" />
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<script src="${contextPath}/bootstrap/js/bootstrap.min.js"></script>
<body>
	<jsp:include page="TopBar.jsp"></jsp:include>
	<div class="container">
		<div class="form-signin">
			<h5>${user.getUsername()}</h5>
			<h5>${user.getName()}</h5>
			<h5>${user.getEmail()}</h5>
			<h5>${user.getAddress()}</h5>
			<h5>${user.getBirth()}</h5>
		</div>
	</div>
</body>
</html>