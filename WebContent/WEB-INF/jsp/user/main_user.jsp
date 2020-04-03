<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电子商务</title>
<link href="../statics/css/bootstrap.css" rel='stylesheet' type='text/css' />
<script type="text/javascript">
	function ale(str){
		alert("商品“"+ str +"”已成功加入购物车，进入购物车可查看");
	}
</script>
</head>
<body style="background-image:url('../statics/images/bg.jpg')">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-8"><h2>电子商务平台</h2></div>
		<div class="col-md-3">
			<h3>您好：${userSession.userId}</h3>
			<h4>
				<a href="${pageContext.request.contextPath }/user/user_center.html">用户中心</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/user/logout.html">退出登录</a>
			</h4>
		</div>
	</div>
	<hr/>
	<div class="row" style="padding-top: 30px">
		<div class="col-md-1"></div>
		<div class="col-md-1"><h4><a href="#">服装</a></h4></div>
		<div class="col-md-1"><h4><a href="#">孕婴</a></h4></div>
		<div class="col-md-1"><h4><a href="#">家电</a></h4></div>
		<div class="col-md-1"><h4><a href="#">水果</a></h4></div>
		<div class="col-md-1"><h4><a href="#">建材</a></h4></div>
		<div class="col-md-1"><h4><a href="#">电脑配件</a></h4></div>
		<div class="col-md-1"><h4><a href="#">办公用品</a></h4></div>
		<div class="col-md-1"><h4><a href="#">耗材</a></h4></div>
		<div class="col-md-1"><h4><a href="#">食品</a></h4></div>
		<div class="col-md-2"><h2><a href="${pageContext.request.contextPath }/user/cartList.html">购物车</a></h2></div>
	</div>
	<div class="row" style="padding-top: 30px">
		<div class="col-md-1"></div>
		<div class="col-md-3">
			<div class="row"><h3>公告</h3></div>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<table>
						<tr style="height:50px">
							<form action="${pageContext.request.contextPath }/user/main_user.html"  name="name" id="name"  method="post" >
								<input type="text" placeholder="按标题查询" name="title" id="title" />
								<input type="submit" value="查询" />
							</form>
						</tr>
						<tr style="height:30px">
							<th width="30px">标题</th>
							<th width="150px">时间</th>
						</tr>
						<c:forEach var="anno" items="${annoList }" varStatus="status">
							<tr style="height:70px">
								<td><span>${anno.announTitle }</span></td>
								<td><span>${anno.annountTime }</span></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-7">
			<div class="row"><h3>商品</h3></div>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<table>
						<tr style="height:50px">
							<form action="${pageContext.request.contextPath }/user/main_user.html"  name="name2" id="name2"  method="post" >
								<input type="text" placeholder="按类型查询" name="type" id="type" />
								<input type="text" placeholder="按商品名查询" name="name_item" id="name_item" />
								<input type="submit" value="查询" />
							</form>
						</tr>
						<tr>
							<th width="250px">图片</th>
							<th width="150px">类型</th>
							<th width="150px">商品名称</th>
							<th width="150px">原价</th>
							<th width="150px">现价</th>
							<th width="150px">库存</th>
						</tr>
						<c:forEach var="item" items="${itemList }" varStatus="status">
							<tr>
								<td><span><img width="150" height="150" src="${pageContext.request.contextPath }/statics/images/logo/${item.picture}" /></span></td>
								<td><span>${item.itemType }</span></td>
								<td><span><a onclick="ale(${item.itemName})" href="${pageContext.request.contextPath }/user/addCart.html?itemId=${item.itemId }" title="将商品“${item.itemName }”加入购入车">${item.itemName }</a></span></td>
								<td><span>${item.priceOld }</span></td>
								<td><span>${item.priceNow }</span></td>
								<td><span>${item.stock }</span></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>