<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Line</title>
		<meta http-equiv="Content-type" content="text/html;charset=UTF8"/>
		<style type="text/css">
			html, body, div, span, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, address, big, cite, code, del, em,  img, ins, small, strong, var, b, i,  dl, dt, dd, ol, ul, li, fieldset, form, label, legend
			{
				margin: 0;
				padding: 0;
			}
			a
			{
				text-decoration:none;
			}
			ul,ol
			{
				list-style: none;
			}
			.page
			{
				width: 1200px;
				margin: 0 auto;
				overflow: hidden;
			}
			.head-0,.head-0 ul
			{
				height: 30px;
				background-color: #F7F7F7;
			}
			.head-0 li
			{
				display: inline;
			}
			.head-ad
			{
				height: 100px;
			}
			.md
			{
				overflow: hidden;
			}
			.nav
			{
				width: 1000px;
				margin: 0 auto;
				float: left;
			}
			.categorys
			{
				width:200px;
				text-align: center;
				float: left;
				background-color: #F7F7F7;
			}
			.nav,.l_cat_til
			{
				background-color:#99CC66;
				z-index: -1;
				font-size: 12px;
			}
			
			.nav ul
			{
				font-size: 20px;
				font-family: serif;
				padding: 0px;
				margin: 0px;
			}
			.nav ul li
			{
				width: 83px;
				display: inline-block;
				
			}
			.nav a
			{
				display: block;
			}
			.nav a:hover
			{
				background-color: #669900;
			}
			.nav,.nav li,.nav li a
			{
				height: 40px;
			}
			.nav li a,.l_cat_til a
			{
				width: 85px;
				color: #fff;
				text-align: center;
				line-height: 40px;
			}
			.l_cat_til a:hover
			{
				text-decoration: underline;
			}
			.category-bd
			{
				position: absolute;
				border:2px solid #99cc66;
				border-top: none;
				height: 300px;
			}
			.category-item
			{
				width: 198px;
				height:25px;
				margin: 0px 0px 4px 0px;
				border-bottom: 1px solid #dedede;
			}
			.category-item h3:hover
			{
				box-shadow: 0 0 10px #DDD;
				-webkit-box-shadow:0 0 10px #DDD;
				background-color: #fff;
			}
			.category-item a
			{
				display: inline;
				color: #333;
				font-size: 16px;
			}
			.category-item div
			{
				display: none;
				text-align: left;
				position: absolute;
				left: 198px;
				top: 0px;
				width: 700px;
				border:1px solid #99cc66;
				border-top:0px;
				z-index: 14;
				background-color: #fff;
			}
			.l-subitem,.r-subitem
			{
				display: inline-block;
				margin-right: 10px;
				padding: 20px 0px 10px 10px;
				width: 327px;
			}
			.l-subitem
			{
				border-right: 1px solid #eee;
			}
			.category-item li
			{
				margin: 10px;
				border-bottom: 1px solid #eee;
			}
			.category-item ul a
			{
				display: inline-block;
				margin: 10px 8px;
			}
			
			#mask
			{
				display: none;
				z-index: 100;
				top:0;
				bottom:0;
				right: 0;
				left: 0;
				position: absolute;
				background: #fff;
				opacity: 0.5;
				-moz-opacity:0.5;
				filter:alpha(opacity=50);
			}
			#login-box
			{
				z-index: 101;
				position: absolute;
				display: none;
				width: 400px;
				height: 150px;
				background-color: #fff;
				border: 2px solid #eee;
				text-align: center;
			}
			#login-box form
			{
				margin: 35px auto;
			}
			#close
			{
				float: right;
			}

		</style>

		<script src="source/jquery-1.11.0.js">
		</script>
	</head>
	<body>
	<c:if test="${userName == \"\"" var="">
	<c:out value="sdddd"/>
	</c:if>
	
		<div class="page">
			<div class="head-0">
				<ul>
					<li><a id="login" href="#">登陆</a></li>
					<li><a id="" href="#">注册</a></li>
				</ul>
			</div>
			<div class="head-ad">

			</div>
			<div class="md">
				<div class="categorys">
					<div class="l_cat_til">
						<h2><a href="">全部商品分类</a></h2>
					</div>
					<div class="category-bd">
						<div class="category-item">
							<h3>
								<a href="">商品</a>
								<a href="">商品</a>
								<a href="">商品</a>
							</h3>
							<div>
								<ul class="l-subitem">
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
								</ul>
								<ul class="r-subitem">
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
								</ul>
							</div>
						</div>
						<div class="category-item">
							<h3>
								<a href="">商品</a>
								<a href="">商品</a>
								<a href="">商品</a>
							</h3>
							<div>
								<ul class="l-subitem">
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电sdsd</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
								</ul>
								<ul class="r-subitem">
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
									<li>
										<h4>彩电</h4>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
										<a href="">冰箱</a>
									</li>
								</ul>
							</div>
						</div>

					</div>
				</div>
				<div class="nav">
					<ul>
						<li><a href="">商品</a></li>
						<li><a href="">食品</a></li>
						<li><a href="">家具</a></li>
						<li><a href="">电器</a></li>
						<li><a href="">数码</a></li>
					</ul>
				</div>
				<div id="slid" style="margin-left: 200px;float:left"><img src="ad.jpg"/></div>
			</div>
		</div>
		<div id="mask">
		</div>
		<div id="login-box">
			<span id="close">X</span>
			<form action="user/login.do" method="POST">
				<p id="error-msg" style="color:red;text-align:center;margin:5px,0px;display:none">sdhj</p>
				密码: <input type="text" name="account" onfocus="true"/><br/>
				账号: <input type="password" name="password"/><br/>
				<input class="btn-submit" type="submit" value="sigin in"/>
			</form>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				var bdWidth = document.body.clientWidth;
				var bdHeight = document.body.clientHeight;
				$("#mask").css({
					"height":bdHeight,
					"width":bdWidth
				});
				var left = ( bdWidth / 2 ) - 200;
				var top = (bdHeight / 2) - 75;
				$("#login-box").css({
					"left": left + "px",
					"top" : top + "px"
				})
			});
			$(".category-item").hover(function(){
				var source = this.childNodes[3];
				source.style.display = "block";
			});
			$('.category-item').mouseleave(function(){
				var source = this.childNodes[3];
				source.style.display = "none";
			});
			$("#login").click(function(){
				$("#mask").css("display","block");
				$("#login-box").css("display","block");
			});
			$("#close").click(function(){
				$("#mask").css("display","none");
				$("#login-box").css("display","none");
			})
		</script>
	</body>
</html>