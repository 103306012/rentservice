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
</head>
<script src="${contextPath}/bootstrap/js/bootstrap.min.js"></script>
<body>
	<jsp:include page="TopBar.jsp"></jsp:include>
	<p></p>
	<div class="container">
		<div style="display: flex; flex-wrap: wrap">
			<c:forEach items="${productlist}" var="product">
				<div style="width: 33%;">
					<a href="${contextPath}/watchproduct/${product.getId()}"> <img
						width="200" height="200"
						src="<c:url value="/image/"/>${product.getFiles().get(0)}" /> <br>
						<span>${product.getName()}</span>
					</a>
					<p></p>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>