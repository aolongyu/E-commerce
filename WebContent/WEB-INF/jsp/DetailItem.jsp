<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理员界面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/bootstrap-admin.css" />
</head>
<body>
	<!--导航-->
	<nav class="navbar navbar-default">
		<div class="container">
			<!--小屏幕导航按钮和logo-->
			<div class="navbar-header">
				<button class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="main_admin.html" class="navbar-brand">管理员页面</a>
			</div>
			<!--小屏幕导航按钮和logo-->
			<!--导航-->
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="main_admin.html">&nbsp;&nbsp;商品管理</a></li>
					<li><a href="ItemType_admin.html">&nbsp;&nbsp;类型管理</a>
					<li>
					<li><a href="User_admin.html">&nbsp;&nbsp;用户管理</a></li>
					<li><a href="order_admin.html">&nbsp;&nbsp;订单管理</a>
					<li>
					<li><a href="announce_admin.html">&nbsp;&nbsp;公告管理</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath }/logout.html">${userSession.adminId}&nbsp;&nbsp;<span
							class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出
					</a></li>
				</ul>
			</div>
			<!--导航-->

		</div>
	</nav>
	<!--导航-->
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<c:forEach items="${list}" var="Item">
					<h2 style="text-align: center">${Item.itemId}</h2>
					<p style="text-align: center">${Item.itemName}</p>
					<p style="text-align: center">${Item.priceNow}</p>
					<p style="text-align: center">${Item.stock}</p>
					<p style="text-align: center">
						<img src="${pageContext.request.contextPath }/statics/images/logo/${Item.picture}" height="200"
							width="200">
					</p>
					<br>
					<br>
				</c:forEach>
			</div>
		</div>
	</div>

	<!--footer-->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<p align="center">Copyright&nbsp;©&nbspFuJian University of
						Technology&nbsp;&nbsp;www.fjut.edu.cn&nbsp;&nbsp;闽ICP备10022194号-1
					</p>
				</div>
			</div>
		</div>
	</footer>
	<!--footer-->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/bootstrap.js"></script>

</body>
</html>