<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="statics/js/ajaxfileupload.js"></script>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加商品类型</title>
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
			<div class="col-md-2">
				<div class="list-group">
					 <a href="${pageContext.request.contextPath }/AnnounceAdd.html" class="list-group-item active">新增公告</a>
				</div>
			</div>
			<div class="col-md-10">
				<div class="page-header">
					<h1>添加公告</h1>
				</div>

				<form action="${pageContext.request.contextPath }/AnnounceAdddo.html"
					method="post">

					<div class="form-group">
						<label for="title">公告标题</label> <input type="text" id="cname1"
							name="cname1" class="form-control" placeholder="公告标题" required>
					</div>
					<div class="form-group">
                    <label for="content">公告内容</label>
                    <textarea id="cname2" name="cname2" class="form-control" rows="15" cols="10" placeholder="公告内容" required></textarea>
               		 </div>
					
					<div>
						<button type="submit" class="btn btn-default pull-right">添加</button>
					</div>
				</form>

	<br>
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
		src="${pageContext.request.contextPath }/statics/js/bootstrap.js"></script>


</body>
</html>