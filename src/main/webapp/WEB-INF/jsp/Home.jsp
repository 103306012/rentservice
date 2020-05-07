<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<link href="resources/css/common.css" rel="stylesheet">
</head>
<script src="bootstrap/js/bootstrap.min.js"></script>
<body>
	<div class="container">
		<h5>${sessionScope.login}Welcome</h5>
		<h4>
			<a href="${contextPath}/logout">Logout</a>
		</h4>
		<div style="display: flex; flex-wrap: wrap">
			<c:forEach items="${product.files}" var="image">
				<div style="width: 50%;">
					<a href="http://google.com.tw"> <img width="200"
						src="<c:url value="/image/"/>${image.originalFilename}" /> <br>
						<span>${image.originalFilename}</span>
					</a>
				</div>
			</c:forEach>
		</div>
		<h4>
			<a href="${contextPath}/addproduct">新增租借商品</a>
		</h4>
	</div>
</body>
</html>