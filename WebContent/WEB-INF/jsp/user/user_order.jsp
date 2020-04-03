<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>电子商务</title>
<link href="../statics/css/bootstrap.css" rel='stylesheet'
	type='text/css' />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
</head>
<body style="background-image:url('../statics/images/bg.jpg')">
	<div class="row" style="margin-top: 50px">
		<div class="col-md-2"></div>
		<div class="col-md-9"><a href="${pageContext.request.contextPath }/user/main_user.html">回首页</a></div>
	</div>
	<div class="row" style="margin-top: 50px">
		<div class="col-md-2"></div>
		<div class="col-md-2"><h1><a href="${pageContext.request.contextPath }/user/cartList.html">购物车</a></h1></div>
		<div class="col-md-2"><h1><a href="">订单</a></h1></div>
	</div>
	<div class="row" style="margin-top: 40px">
		<div class="col-md-1"></div>
		<div class="col-md-9">
			<table>
				<tr>
					<form class="loginForm" action="${pageContext.request.contextPath }/user/cartList.html" name="name" id="name" method="post">
						<input type="text" placeholder="按照商品名查询" name="name" id="name" />
						<input type="submit" value="查询" />
					</form>
				</tr>
				<tr style="height:60px">
					<th width="150px">订单编号</th>
					<th width="150px">价格</th>
					<th width="350px">时间</th>
					<th width="150px">数量</th>
					<th width="150px">操作</th>
				</tr>
				<c:forEach var="order" items="${orderList }" varStatus="status">
					<tr style="height:60px">
						<td><span>${order.orderId }</span></td>
						<td><span>${order.orderPrice }</span></td>
						<td><span>${order.orderTime }</span></td>
						<td><span>${order.buynum }</span></td>
						<td><span>
						<a href="${pageContext.request.contextPath }/user/deleteOrder.html?orderId=${order.orderId}">
							<img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除" />
						</a>
						</span>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script type="text/javascript">
	function change(num, cartId){
		alert(num+"&&&&&&&&&"+cartId);
		var param={"num":num,"cartId":cartId};
		   $.ajax({
			  url:'${pageContext.request.contextPath }'+"/user/changeCartNum",
		      data:param,
		      type:'POST',
		      dataType:'json',
		      success:function(data){
		    	  alert("success");
		      },
		   })
	}
</script>
</body>
</html>