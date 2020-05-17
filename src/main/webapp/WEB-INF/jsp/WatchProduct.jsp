<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>瀏覽商品</title>
<link rel="stylesheet"
	href="${contextPath}/bootstrap/css/bootstrap.min.css" />
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<script src="${contextPath}/bootstrap/js/bootstrap.min.js"></script>
<body>
	<jsp:include page="TopBar.jsp"></jsp:include>
	<div class="container">
		<div class="form-signin">
			<h5>${product.getType()}</h5>
			<h5>${product.getName()}</h5>
			<h5>${product.getPrice()}元/1天</h5>
			<h5>${product.getDetail()}</h5>
			<c:forEach items="${product.getFiles()}" var="file">
				<div>
					<img width="200" height="200" src="<c:url value="/image/"/>${file}" />
				</div>
				<br>
			</c:forEach>
		</div>
	</div>
</body>
</html>