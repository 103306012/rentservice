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
			<h2>商品名稱:${productWithImg.getName()}</h2>
			<h2>類型:${productWithImg.getType()}</h2>
			<h2>價格:${productWithImg.getPrice()}元/1天</h2>
			<h2>地址:${productWithImg.getAddress()}</h2>
			<h2>商品內容:${productWithImg.getDetail()}</h2>
			<c:forEach items="${productWithImg.getImgList()}" var="img">
				<div>
					<img width="200" height="200"
						src="<c:url value="/images/"/>${img.getUrl()}" />
				</div>
				<br>
			</c:forEach>
			<a
				href="${contextPath}/viewproduct/rent/${productWithImg.getProductId()}">
				<button class="btn btn-lg btn-primary btn-block" type="submit">租借</button>
			</a>
		</div>
	</div>
</body>
</html>