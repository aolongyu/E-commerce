<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!-- Google Fonts -->
<link href='http://fonts.useso.com/css?family=Arimo:400,700'
	rel='stylesheet' type='text/css'>
<title>宝贝详情</title>

<script type="text/javascript">
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");// 构造一个含有目标参数的正则表达式对象
		r = window.location.search.substr(1).match(reg); // 匹配目标参数
		if (r != null)
			return decodeURI(r[2]); // 返回参数值
		return null; // 如果不存在，返回null
	}

	var petId;
	var petName;
	var petPrice;

	$(function() {
		var url = "http://localhost:8080/experiment_07/GetAllPet";
		petId = getUrlParam("id");
		var parm = {
			id : petId
		};
		$.post(url, parm, result, "json");
	});

	function result(datas) {
		for (var i = 0; i < datas.length; i++) {
			petName = '<span>' + datas[i].petName + '</span>';
			var $dom = $(petName);
			$dom.appendTo("#getName");

			petPrice = '<span>' + '$' + datas[i].petPrice + '</span>';
			var $dom = $(petPrice);
			$dom.appendTo("#getPrice");

			var petPic = '<img class=\'etalage_source_image\' src=\''+datas[i].petPic+'\' style=\'width:250px; height:auto\' />';
			var $dom = $(petPic);
			$dom.appendTo("#getPic");

			var petIntro = '<span>' + datas[i].petIntro + '</span>';
			var $dom = $(petIntro);
			$dom.appendTo("#getIntro");
		}
	}

	function toCart() {
		var options = $("#selectId option:selected");
		var num = options.text();

		var url = "CartAdd?" + "id=" + petId + "&price=" + petPrice + "&num="
				+ petNum + "&name=" + petName;

		$(location).attr('href', url);

	}
</script>
</head>
<body>
	<!-- Header Starts Here -->
	<div class="container">
		<div class="header">
			<div class="logo">
				<a href="index.html"><h1>311神奇宝贝商城</h1></a>
			</div>
			<span class="menu"></span>
			<script>
				$("span.menu").click(function() {
					$(".navigation").slideToggle("slow", function() {
						// Animation complete.
					});
				});
			</script>
			<div class="cleary"></div>
			<div class="navigation">
				<ul class="navig">
					<li><a href="index.jsp">首页</a></li>
					<li><a href="pet.jsp">宠物</a></li>
					<li><a href="surround.jsp">周边</a></li>
					<li><a href="service.jsp">服务</a></li>
				</ul>
			</div>
			<div class="search-bar">
				<input type="submit" value="" />
				<div class="text">
					<input type="text" placeholder="Search.." required=" 	" />
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- Header Part Ends Here -->
	<!-- Singel Page Starts Here -->
	<div class="container">
		<div class="brand">
			<!-- Content --- Bar -->
			<div class="brand-content-bar product-cointent-bar">
				<ul class="path">
					<li><a href="index.html">首页</a>&nbsp; ></li>
					<li><a href="men.html">宠物</a>&nbsp; ></li>
					<li class="actev">宝贝详情&nbsp;</li>
				</ul>

				<div class="details-left">
					<div class="details-left-slider">
						<ul id="etalage" style="list-style: none">
							<li id="getPic">
								<!-- picpicpicpicpicpicpicpic --> <!--<img class="etalage_source_image" src="images/pet/001.png" /> -->
							</li>
						</ul>
					</div>
					<div class="details-left-info">
						<div class="details-right-head">
							<h1 class="title" id="getName">
								<!-- namenamenamenamenamename -->
							</h1>
							<ul class="pro-rate">
								<li><a class="product-rate" href="#"> <label> </label></a>
									<span> </span></li>
							</ul>
							<p class="product-detail-info" id="getIntro">
								<!-- introintrointrointrointrointro -->
							</p>
							<div class="product-more-details">
								<ul class="price-avl">
									<li id="getPrice">
										<!-- pricepricepricepricepriceprice -->
									</li>
									<div class="clearfix"></div>
								</ul>
								<ul class="prosuct-qty">
									<span>购买数量</span>
									<select id="selectId">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
									</select>
								</ul>
								<input type="button" onclick="toCart()" value="加入购物车" />
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
					<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
					<script type="text/javascript">
						$(document).ready(function() {
							$('#horizontalTab').easyResponsiveTabs({
								type : 'default', //Types: default, vertical, accordion           
								width : 'auto', //auto or any width like 600px
								fit : true
							// 100% fit in a container
							});
						});
					</script>
					<!-- Bags Portal -->
				</div>
			</div>
			<!-- Bags Portal -->
			<!-- Content --- Bar -->
			<!-- Side Bar-->
			<div class="brand-side-bar">
				<div class="top-brand">
					<h3>镇店之宝</h3>
					<img src="images/pet/show.png" alt="">
					<div class="discount">
						<a href="pet.jsp">Buy</a>
					</div>
				</div>

			</div>
		</div>

		<!-- Singel Page Ends Here -->
	</div>
</body>
</html>