<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="statics/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="statics/css/bootstrap-admin.css"/>
</head>
<body background="statics/images/AdminBackground.png" >

<div class="container">
    <div class="row">
        <div class="col-md-5">
        </div>
        <div class="col-md-8">
            <br>
            <br><br>
            
            <form action="${pageContext.request.contextPath }/dologin.html" name = "loginForm" method="post">
                <div class="form-group">
                    <label for="userId">用户名</label>
                    <input type="text" id="userId" name="userId" class="form-control" placeholder="请输入用户名" style="width:200px" required>
                    <label for="userPwd">密码</label>
                    <input type="password" id="userPwd" name="userPwd" class="form-control" placeholder="请输入密码" style="width:200px" required>
                	<br>
                </div>
                <div class="lgD">
                <input type="text" size="10" name="code" id="code" placeholder="输入验证码" required>
					<img  name="imgValidate" src="code.jsp"
						onClick="refresh()">
				</div>
                <br>
                <div style="float:left">
                    <button type="submit" class="btn btn-default pull-right" style="width:200px">登入<div class="info">${error }</div></button>
                </div>
            </form>
            
        </div>
        <div class="col-md-5">
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="statics/js/bootstrap.js"></script>
<script type="text/javascript" language="JavaScript">
	function refresh() {
		loginForm.imgValidate.src = "code.jsp?" + Math.random();//new Date(); 此处必须加上Math.random()或new Date()，否则无法刷新验证码
	}
</script>
</body>
</html>