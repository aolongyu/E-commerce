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
		<div class="col-md-2"><h1><a href="">购物车</a></h1></div>
		<div class="col-md-2"><h1><a href="${pageContext.request.contextPath }/user/orderList.html">订单</a></h1></div>
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
				<tr>
					<th width="150px">购物编号</th>
					<th width="150px">类型</th>
					<th width="150px">商品名</th>
					<th width="250px">图片</th>
					<th width="150px">原价</th>
					<th width="150px">现价</th>
					<th width="150px">数量</th>
					<th width="150px">操作</th>
					<th width="150px">购买</th>
				</tr>
				<c:forEach var="cart" items="${cartList }" varStatus="status">
					
					<tr>
					
						<td><span>${cart.cartId }</span></td>
						<td><span>${cart.itemType }</span></td>
						<td><span>${cart.itemName }</span></td>
						<td><span><img width="150" height="150" src="${pageContext.request.contextPath }/statics/images/logo/${cart.picture}" /></span></td>
						<td><span>${cart.priceOld }</span></td>
						<td><span>${cart.priceNow}</span></td>
						<td><span>
						<form action="${pageContext.request.contextPath }/user/modifyBuyNum.html?cartId=${cart.cartId}" method='post'>
							<input type="number" value="${cart.buyNum}" id="num" name="num" style="width: 56px" />
						</span></td>
							
						 <td><span>
							<input type="submit" value="修改" /></span>
						</form>
						
							<a
								href="${pageContext.request.contextPath }/user/deleteCart.html?cartId=${cart.cartId}">
									<img
									src="${pageContext.request.contextPath }/statics/images/schu.png"
									alt="删除" title="删除" />
							</a>
						</span></td>
						<td><a href="${pageContext.request.contextPath }/user/addOrder.html?cartId=${cart.cartId}&orderPrice=${cart.priceNow}&buyNum=${cart.buyNum}">买它</a></td>
					
					</tr>
						
				</c:forEach>
			</table>

			<div class="page-bar">
				<ul class="page-num-ul clearfix">
					<li>共${totalCount }条记录&nbsp;&nbsp; ${currentPageNo }/${totalPageCount }页</li>
					<c:if test="${currentPageNo > 1}">
						<a href="${pageContext.request.contextPath }/user/cartList.html?pageIndex=1">首页</a>
						<a href="${pageContext.request.contextPath }/user/cartList.html?pageIndex=${currentPageNo - 1}">上一页</a>
					</c:if>
					<c:if test="${currentPageNo < totalPageCount }">
						<a href="${pageContext.request.contextPath }/user/cartList.html?pageIndex=${currentPageNo + 1}">下一页</a>
						<a href="${pageContext.request.contextPath }/user/cartList.html?pageIndex=${totalPageCount }">最后一页</a>
					</c:if>
					&nbsp;&nbsp;
				</ul>
				<form action="${pageContext.request.contextPath }/user/cartList.html">
					<span><label>跳转至</label>
					<input type="number" id="pageIndex" name="pageIndex"/>
					<span><label>页</label>
					<input type="submit" value="GO" />
				</form>
			</div>
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