<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h5>${username}Welcome</h5>
	<h4>
		<a href="${contextPath}/logout">Logout</a>
	</h4>
	<ol>
		<c:forEach items="${product.files}" var="image">
			<li>${image.originalFilename}<img width="100"
				src="<c:url value="/image/"/>${image.originalFilename}" />
			</li>
		</c:forEach>
	</ol>
	<h4>
		<a href="${contextPath}/addproduct">新增租借商品</a>
	</h4>
</body>
</html>