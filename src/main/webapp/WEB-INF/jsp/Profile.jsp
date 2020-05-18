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
			<h2>我的資料</h2>
			<h2>帳號:${user.getUsername()}</h2>
			<h2>姓名:${user.getName()}</h2>
			<h2>Email:${user.getEmail()}</h2>
			<h2>地址:${user.getAddress()}</h2>
			<h2>生日:${user.getBirth()}</h2>
		</div>
	</div>
</body>
</html>