<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RentService</title>
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
					<a href="${contextPath}/viewproduct/${product.getProduct_id()}">
						<img width="200" height="200"
						src="<c:url value="/image/"/>${product.getFiles().get(0)}" /> <br>
						<h6 style="text-align: center;">${product.getName()}</h6>
						<h6 style="text-align: center;">35元</h6>
					</a>
					<p></p>
				</div>
			</c:forEach>
		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<c:choose>
					<c:when test="${currentPage != 1}">
						<li class="page-item"><a class="page-link"
							href="${contextPath}/home/${currentPage - 1}" tabindex="-1"
							aria-disabled="true">Previous</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link"
							href="${contextPath}/home/${currentPage - 1}" tabindex="-1"
							aria-disabled="true">Previous</a></li>
					</c:otherwise>
				</c:choose>

				<c:forEach begin="1" end="${noOfPages}" var="i">
					<c:choose>
						<c:when test="${currentPage eq i}">
							<li class="page-item active" aria-current="page"><a
								class="page-link" href="${contextPath}/home/${i}">${i}<span
									class="sr-only">(current)</span></a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
							<li class="page-item"><a class="page-link"
								href="${contextPath}/home/${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${currentPage lt noOfPages}">
						<li class="page-item"><a class="page-link"
							href="${contextPath}/home/${currentPage + 1}" tabindex="-1"
							aria-disabled="true">Next</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link"
							href="${contextPath}/home/${currentPage + 1}" tabindex="-1"
							aria-disabled="true">Next</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</nav>
	</div>
</body>
</html>