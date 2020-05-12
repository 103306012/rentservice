<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
	function search() {
		var values = document.getElementById("searchTerm").value;
		if (values) {
			window.location = '${contextPath}' + "/search/" + values;
		}

	}
</script>

<div style="float: right;">
	<div class="search">
		<input type="text" class="searchTerm" id="searchTerm"
			placeholder="What are you looking for?">
		<button type="submit" class="searchButton" onclick=search()>
			<i class="fa fa-search"></i>
		</button>
	</div>
	<c:choose>
		<c:when test="${not empty sessionScope.login}">
			<a href="${contextPath}/profile">My profile</a>
			<a href="${contextPath}/logout">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="${contextPath}/register">register</a>
			<a href="${contextPath}/login">login</a>
		</c:otherwise>
	</c:choose>
</div>