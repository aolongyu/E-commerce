<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/LoginStyle.css" />
</head>
<body>
	<div class="header" id="head">
		<div class="title">在这登录</div>
	</div>
	<div class="wrap" id="wrap">
		<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">登录</p>
			</div>
			<!-- 输入框 -->
			<form class="loginForm" action="${pageContext.request.contextPath }/user/dologin.html"  name="actionForm" id="actionForm"  method="post" >
				<div class="lgD">
					<img src="img/logName.png" width="20" height="20" alt="" /> <input
						type="text" name="username" id="username" placeholder="输入用户ID" required />
				</div>
				<div class="lgD">
					<img src="img/logPwd.png" width="20" height="20" alt="" /> <input
						type="password" name="userpwd" id="userpwd" placeholder="输入用户密码" required />
				</div>
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img style="algin-text: right" name="imgValidate" src="code.jsp"
						onClick="refresh()"> <a href="javascript:refresh();">看不清?换一张
					</a>
				</div>
				<div class="lgD">
					<img src="img/logName.png" width="20" height="20" alt="" /> <input
						type="text" size="10" name="code" id="code" placeholder="输入验证码" required>
				</div>
				<div class="logC">
					<a href="index.html" target="_self"><button>登 录<div class="info">${error }</div></button></a>
				</div>
			</form>
		</div>
	</div>

	<div class="footer" id="foot">
		<div class="copyright">
			<p><a href="${pageContext.request.contextPath }/login.html">Belongs to Ao Longyu</a></p>
		</div>
	</div>
</body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/LoginStyle.css" />
<script type="text/javascript" language="JavaScript">
	function refresh() {
		loginForm.imgValidate.src = "code.jsp?" + Math.random();//new Date(); 此处必须加上Math.random()或new Date()，否则无法刷新验证码
	}
</script>
</html>