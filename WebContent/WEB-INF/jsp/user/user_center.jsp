<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户中心</title>
	<link href="../statics/css/bootstrap.css" rel='stylesheet' type='text/css' />
</head>
<body style="background-image:url('../statics/images/bg.jpg')">
	<div class="row" style="padding-top: 40px">
		<div class="col-md-2"></div>
		<div class="col-md-10"><h1>用户中心<small><a href="${pageContext.request.contextPath }/user/main_user.html">回首页</a></small></h1></div>
	</div>
	<hr/>
	<div class="row">

	</div>
	<div class="row">
		<div class="col-md-4">
			<br/>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-9">
					<h4>用户ID：${userSession.userId}</h4>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-9">
					<h4>用户E-Mail：${userSession.email}</h4>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-9">
					<h4>用户密码：*******</h4>
				</div>
			</div>
		</div>

		<div class="col-md-1"></div>

		<div class="col-md-3">
			<div class="row">
				<div class="col-md-12">
					<h3>更改E-mail</h3>
				</div>
			</div>
			<hr>
			<form action="${pageContext.request.contextPath }/user/user_modifyMail.html"  name="actionForm1" id="actionForm1"  method="post" >
				<div class="row">
					<div class="col-md-12"><h4>新E-Mail：</h4></div>
					<div class="col-md-12"><input type="email" name="newEmail" required></div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-12"><input type="submit" name="changeEmail" value="修改"></div>
				</div>
			</form>
		</div>

		<div class="col-md-3">
			<div class="row">
				<div class="col-md-12">
					<h3>更改密码</h3>
				</div>
			</div>
			<hr/>
			<form action="${pageContext.request.contextPath }/user/user_modifyPassword.html"  name="actionForm2" id="actionForm2"  method="post" >
				<div class="row">
					<div class="col-md-12"><h4>旧密码：</h4></div>
					<div class="col-md-12"><input type="password" name="pwd1" id="pwd1" required></div>
				</div>
				<div class="row">
					<div class="col-md-12"><h4>新密码：</h4></div>
					<div class="col-md-12"><input type="password" name="pwd2" id="pwd2" required></div>
				</div>
				<div class="row">
					<div class="col-md-12"><h4>重复新：</h4></div>
					<div class="col-md-12"><input type="password" name="pwd3" id="pwd3" required></div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-12"><input type="submit" name="changePwdl" value="修改"></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>