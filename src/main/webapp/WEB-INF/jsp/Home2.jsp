<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="${contextPath}/bootstrap/css/bootstrap.min.css" />
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<script src="${contextPath}/bootstrap/js/bootstrap.min.js"></script>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${not empty sessionScope.login}">
				<a href="${contextPath}/logout">Logout</a>
			</c:when>
			<c:otherwise>
				<a href="${contextPath}/register">register</a>
				<a href="${contextPath}/login">login</a>
			</c:otherwise>
		</c:choose>



		<h5>${sessionScope.login}Welcome</h5>
		<div style="display: flex; flex-wrap: wrap">
			<div style="width: 25%;">
				<a href="${contextPath}/type/transport"> <img width="200"
					height="200" src="<c:url value="/image/"/>transport.jpg" /> <br>
					<span>交通</span>
				</a>
			</div>
			<div style="width: 25%;">
				<a href="${contextPath}/type/videogame"> <img width="200"
					height="200" src="<c:url value="/image/"/>videogame.jpg" /> <br>
					<span>電玩</span>
				</a>
			</div>
		</div>
		<h4>
			<a href="${contextPath}/uploadproduct">新增租借商品</a>
		</h4>
	</div>
</body>
</html>