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
		<jsp:include page="TopBar.jsp"></jsp:include>
		<span>${message}</span>
		<h5>${sessionScope.login}Welcome</h5>
		<h4>
			<a href="${contextPath}/uploadproduct">新增租借商品</a>
		</h4>
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
			<div style="width: 25%;">
				<a href="${contextPath}/type/travel"> <img width="200"
					height="200" src="<c:url value="/image/"/>travel.jpg" /> <br>
					<span>旅遊</span>
				</a>
			</div>
			<div style="width: 25%;">
				<a href="${contextPath}/type/dress"> <img width="200"
					height="200" src="<c:url value="/image/"/>dress.jpg" /> <br>
					<span>服飾</span>
				</a>
			</div>
			<div style="width: 25%;">
				<a href="${contextPath}/type/audiovideo"> <img width="200"
					height="200" src="<c:url value="/image/"/>audiovideo.jpg" /> <br>
					<span>影音</span>
				</a>
			</div>
			<div style="width: 25%;">
				<a href="${contextPath}/type/book"> <img width="200"
					height="200" src="<c:url value="/image/"/>book.jpg" /> <br> <span>書籍</span>
				</a>
			</div>
			<div style="width: 25%;">
				<a href="${contextPath}/type/3c"> <img width="200" height="200"
					src="<c:url value="/image/"/>3c.jpg" /> <br> <span>3C電子</span>
				</a>
			</div>
			<div style="width: 25%;">
				<a href="${contextPath}/type/other"> <img width="200"
					height="200" src="<c:url value="/image/"/>other.png" /> <br>
					<span>其他</span>
				</a>
			</div>
		</div>
	</div>
</body>
</html>