<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增商品</title>
<link rel="stylesheet"
	href="${contextPath}/bootstrap/css/bootstrap.min.css" />
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function updateList() {
		var input = document.getElementById('files');
		if (input.files.length == 0) {
			alert('無上傳圖片');
			return;
		}
		if (input.files.length > 5) {
			input.value = '';
			alert('上傳圖片數量不得穿過5張')
			return;
		}
		var output = document.getElementById('fileList');
		var children = "";
		for (var i = 0; i < input.files.length; ++i) {
			children += '<li>' + input.files.item(i).name + '</li>';
		}
		output.innerHTML = '<ul style="list-style:none;">' + children + '</ul>';
	}
</script>
<body>
	<jsp:include page="TopBar.jsp"></jsp:include>
	<div class="container">
		<h2 style="text-align: center;">新增商品</h2>
		<form:form method="POST" action="${contextPath}/uploadproduct"
			enctype="multipart/form-data" modelAttribute="upload"
			class="form-signin">
			<spring:bind path="name">
				<div
					class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
					<form:input type="text" path="name" class="form-control"
						placeholder="名稱" autofocus="true"></form:input>

					<form:errors path="name"></form:errors>
				</div>
			</spring:bind>
			<p></p>
			<spring:bind path="type">
				<div
					class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
					<form:select path="type" class="form-control">
						<form:option value="null" label="請選擇類型" />
						<form:option value="transport" label="交通" />
						<form:option value="game" label="電玩" />
						<form:option value="travel" label="旅遊" />
						<form:option value="cloth" label="服飾" />
						<form:option value="video" label="影音" />
						<form:option value="book" label="書籍" />
						<form:option value="3c" label="3c電子" />
						<form:option value="other" label="其他" />
					</form:select>

					<form:errors path="type"></form:errors>
				</div>
			</spring:bind>
			<p></p>
			<spring:bind path="price">
				<div
					class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
					<form:input type="text" path="price" class="form-control"
						placeholder="價格/每日"></form:input>
					<form:errors path="price"></form:errors>
				</div>
			</spring:bind>
			<p></p>
			<spring:bind path="address">
				<div
					class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
					<form:input type="text" path="address" class="form-control"
						placeholder="地址"></form:input>
					<form:errors path="price"></form:errors>
				</div>
			</spring:bind>
			<p></p>
			<form:textarea path="detail" style="width: 470px;" />
			<p></p>
			<form:errors path="detail"></form:errors>

			<p></p>
			<form:label path="files" class="btn btn-sm btn-dark">選擇商品圖片</form:label>
			<spring:bind path="files">
				<div
					class="${status.error ? 'invalid-feedback d-block' : 'form-group'}">
					<form:input type="file" path="files" multiple="multiple"
						accept="image/*" onchange="updateList()"
						style="visibility:hidden;"></form:input>

					<form:errors path="files"></form:errors>
				</div>
			</spring:bind>
			<p>圖片:</p>
			<div id="fileList"></div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">新增</button>

		</form:form>
	</div>
</body>
</html>