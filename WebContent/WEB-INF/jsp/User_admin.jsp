<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理员界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/bootstrap-admin.css"/>
</head>
<body>
<!--导航-->
<nav class="navbar navbar-default">
    <div class="container">
        <!--小屏幕导航按钮和logo-->
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
             <a href="main_admin.html" class="navbar-brand">管理员页面</a>
        </div>
        <!--小屏幕导航按钮和logo-->
        <!--导航-->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="main_admin.html">&nbsp;&nbsp;商品管理</a></li>
                <li><a href="ItemType_admin.html">&nbsp;&nbsp;类型管理</a><li>
                <li><a href="User_admin.html">&nbsp;&nbsp;用户管理</a></li>
                <li><a href="order_admin.html">&nbsp;&nbsp;订单管理</a><li>
                <li><a href="announce_admin.html">&nbsp;&nbsp;公告管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
 					<li><a href="${pageContext.request.contextPath }/logout.html">${userSession.adminId}&nbsp;&nbsp;<span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
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
                
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>用户管理</h1>
            </div>
            <form action="${pageContext.request.contextPath }/FindUser.html" method="post">
            <div>
                <button type="submit" class="btn btn-default pull-right">查找用户</button>
            </div>
            <div style="float:right">
                <input type="text" id="search" name="search" class="form-control" style="width:200px" placeholder="请输入要查找的相关信息">
            </div>
            </form>
            <br style="clear:right">
            <br>
            <table class="table">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>用户E-Mail</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
<c:forEach items="${users}" var="user">
                <tr>
                    <th scope="row">${user.userId}</th>
                    <td>${user.email}</td>
                     <td>
                        <div role="presentation" class="dropdown">
                            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                操作<span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">	
                                <li><a href="${pageContext.request.contextPath }/DeleteUserId?UserId=${user.userId}">删除</a></li>
                            </ul>
                        </div>
                    </td>
                </tr>
                 </c:forEach>
                </tbody>
            </table>
           
        </div>
    </div>
</div>
<!--footer-->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p align="center">
                    Copyright&nbsp;©&nbspFuJian University of Technology&nbsp;&nbsp;www.fjut.edu.cn&nbsp;&nbsp;闽ICP备10022194号-1
                </p>
            </div>
        </div>
    </div>
</footer>
<!--footer-->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/bootstrap.js"></script>

</body>
</html>