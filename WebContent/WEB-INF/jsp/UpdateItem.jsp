<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="statics/js/ajaxfileupload.js"></script>

<script>
	function ajaxFileUpload() {
		
		$.ajaxFileUpload({
					url : 'upImage',//用于文件上传的服务器端请求地址
					type : 'post',
					secureuri : false,//一般设置为false
					fileElementId : 'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
					dataType : 'text',//返回值类型 一般设置为json
					success : function(data) //服务器成功响应处理函数  message
					{
						$("#cname5").val(data);
						$("#file").remove();
						$("#button").remove();
						var txt = "<input type='text' id='fileName' name='scan' value='"+data+"' style='display: inline'/><input id = 'fileButton' type='button' onclick='ReplacePhoto()' value='更换文件' style='display: inline'/>";
						$("#show").append(txt);
						if (typeof (data.error) != 'undefined') {
							if (data.error != '') {
								alert(data.error);
							} else {
								alert(data.message);
							}
						}
					},
					error : function(data, status, e)//服务器响应失败处理函数
					{
						alert(e);
					}
				})
	}
	function ReplacePhoto() {
		var txt = "<input type='file' id ='file' name='scan'style='display:inline' /><input style='display:inline' type='button' id='button' value='上传' onclick='ajaxFileUpload()'>";
		$("#fileName").remove();
		$("#fileButton").remove();
		$("#show").append(txt);
	}
</script>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加商品</title>
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
					<a href="${pageContext.request.contextPath}/itemTypeAdd.html" class="list-group-item active">添加商品</a>
				</div>
			</div>
			<div class="col-md-10">
				<div class="page-header">
					<h1>更改商品</h1>
				</div>

				<form action="${pageContext.request.contextPath }/UpdateItem.html"
					method="post">
					
					<div class="form-group">
						<label for="title">商品Id</label> <input type="text" id="cnameId"
							name="cnameId" class="form-control"  value = "${Id}" readonly>
					</div>
					<div class="form-group">
						<label for="title">商品名称</label> <input type="text" id="cname1"
							name="cname1" class="form-control" placeholder="商品名称"  required>
					</div>
					<div class="form-group">
						<label for="title">商品价格</label> <input type="text" id="cname2"
							name="cname2" class="form-control" placeholder="商品价格" required>
					</div>

					<div class="form-group">
						<label for="title">库存</label> <input type="text" id="cname3"
							name="cname3" class="form-control" placeholder="库存" required>
					</div>

					<div class="form-group">
						<label for="title">商品类型</label> <select id='cname4' name="cname4">
							<c:forEach items="${itemClasses}" var="item">
								<option value="${item.itemId}">${item.itemType}</option>
							</c:forEach>
						</select>
					</div>

					<div>
						<button type="submit" class="btn btn-default pull-right">更改</button>
					</div>
					<input id='cname5' name='cname5' style="display:none" >
				</form>
				<div id="show" style="margin: auto 0;float: left;">
           图片<input type="file" id="file" name="scan" style="display:inline-block"><input  type="button" id="button" value="上传" onclick="ajaxFileUpload()" style="display:inline-block">
         </div>
			</div>
		</div>
	</div>
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