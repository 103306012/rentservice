<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>租借清單</title>
<link rel="stylesheet"
	href="${contextPath}/bootstrap/css/bootstrap.min.css" />
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<script src="${contextPath}/bootstrap/js/bootstrap.min.js"></script>
<body>
	<jsp:include page="TopBar.jsp"></jsp:include>
	<div class="container">
		<h2>出租商品</h2>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col" width="10%">名稱</th>
					<th scope="col" width="10%">類型</th>
					<th scope="col" width="10%">價格/1天</th>
					<th scope="col" width="20%">地址</th>
					<th scope="col" width="20%">明細</th>
					<th scope="col" width="10%">狀態</th>
					<th scope="col" width="10%">租借人</th>
					<th scope="col" width="10%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lend_list}" var="lend">
					<tr>
						<td width="10%">${lend.getProductName()}</td>
						<td width="10%">${lend.getType()}</td>
						<td width="10%">${lend.getPrice()}</td>
						<td width="20%">${lend.getAddress()}</td>
						<td width="20%">${lend.getDetail()}</td>
						<td width="10%">${lend.getStatus().getName()}</td>
						<td width="10%">${lend.getName()}</td>
						<c:choose>
							<c:when test="${lend.getStatus() == 'WATING'}">
								<td width="10%"><a
									href="${contextPath}/rentlist/remove/${lend.getProductId()}"><button>下架</button></a></td>
							</c:when>
						</c:choose>

					</tr>
				</c:forEach>

			</tbody>
		</table>
		<h2>租借項目</h2>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col" width="10%">名稱</th>
					<th scope="col" width="10%">類型</th>
					<th scope="col" width="10%">價格/1天</th>
					<th scope="col" width="10%">地址</th>
					<th scope="col" width="20%">明細</th>
					<th scope="col" width="10%">狀態</th>
					<th scope="col" width="10%">出租人</th>
					<th scope="col" width="10%"></th>
					<th scope="col" width="10%"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${borrow_list}" var="borrow">
					<tr>
						<td width="10%">${borrow.getProductName()}</td>
						<td width="10%">${borrow.getType()}</td>
						<td width="10%">${borrow.getPrice()}</td>
						<td width="10%">${borrow.getAddress()}</td>
						<td width="20%">${borrow.getDetail()}</td>
						<td width="10%">${borrow.getStatus().getName()}</td>
						<td width="10%">${borrow.getName()}</td>
						<c:choose>
							<c:when test="${borrow.getStatus() == 'GOING'}">
								<td width="10%"><a
									href="${contextPath}/rentlist/updatecancel/${borrow.getProductId()}"><button>取消</button></a></td>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${borrow.getStatus() == 'GOING'}">
								<td width="10%"><a
									href="${contextPath}/rentlist/updatefinish/${borrow.getProductId()}"><button>完成</button></a></td>
							</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>