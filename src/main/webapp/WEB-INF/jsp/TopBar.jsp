<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${contextPath}/resources/css/flaticon.css" rel="stylesheet">
<script src="${contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script>
	function search() {
		var values = document.getElementById("searchTerm").value;
		console.log(values);
		if (values) {
			window.location = '${contextPath}' + "/search/" + values;
		}

	}
</script>
<!-- Header section -->
<header class="header-section">
	<div class="header-top">
		<div class="container">
			<div class="row">
				<div class="col-lg-2 text-center text-lg-left">
					<a href="${contextPath}/" class="site-logo"> <img
						src="/image/logo.jpg" alt="">
					</a>

				</div>
				<div class="col-xl-6 col-lg-5">
					<div class="header-search-form">
						<input id="searchTerm" type="text" placeholder="搜尋">
						<button onclick="search()">
							<i class="flaticon-search"></i>
						</button>
					</div>
				</div>
				<div class="col-xl-4 col-lg-5">
					<div class="user-panel">
						<c:choose>
							<c:when test="${not empty sessionScope.login}">
								<div class="up-item">
									<nav style="display: inline-block">
										<ul class="main-menu">
											<li><i class="flaticon-profile"></i><a
												href="${contextPath}/profile">${sessionScope.login}</a>
												<ul class="sub-menu">
													<li><a href="${contextPath}/profile">我的資料</a></li>
													<li><a href="${contextPath}/uploadproduct">新增租借商品</a></li>
													<li><a href="${contextPath}/logout">登出</a></li>
												</ul></li>
										</ul>
									</nav>
								</div>
								<div class="up-item">
									<i class="flaticon-profile"></i> <a
										href="${contextPath}/logout">Sign out</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="up-item">
									<i class="flaticon-profile"></i> <a href="${contextPath}/login">Sign
										in</a>
								</div>
								<div class="up-item">
									<i class="flaticon-profile"></i> <a
										href="${contextPath}/register">Create Account</a>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
	<nav class="main-navbar">
		<div class="container">
			<!-- menu -->
			<ul class="main-menu">
				<li><a href="${contextPath}/type/transport">交通</a></li>
				<li><a href="${contextPath}/type/videogame">電玩</a></li>
				<li><a href="${contextPath}/type/travel">旅遊</a></li>
				<li><a href="${contextPath}/type/dress">服飾 </a></li>
				<li><a href="${contextPath}/type/audiovideo">影音</a></li>
				<li><a href="${contextPath}/type/book">書籍</a></li>
				<li><a href="${contextPath}/type/3c">3C電子</a></li>
				<li><a href="${contextPath}/type/other">其他</a></li>
			</ul>
		</div>
	</nav>
</header>
