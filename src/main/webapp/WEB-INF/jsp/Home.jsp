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
		<h5>${sessionScope.login}Welcome</h5>
		<div style="display: flex; flex-wrap: wrap">
			<c:forEach items="${productlist}" var="product">
				<div style="width: 50%;">
					<a href="${contextPath}/watchproduct/${product.getId()}"> <img
						width="200" height="200"
						src="<c:url value="/image/"/>${product.getFiles().get(0)}" /> <br>
						<span>${product.getName()}</span>
					</a>
				</div>
			</c:forEach>
		</div>
		<h4>
			<a href="${contextPath}/uploadproduct">新增租借商品</a>
		</h4>
	</div>
</body>
</html>