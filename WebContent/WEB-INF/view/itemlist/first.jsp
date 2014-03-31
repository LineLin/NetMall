<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf8"/>
		<title>liebiao</title>
		<style type="text/css">
		 	  消除默认的元素设置
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

			/* 设置头部登陆框和导航栏*/
			.top
			{
				background-color: #F7F7F7;
			}
			.lg
			{
				width: 1200px;
				margin: 0 auto;
			}
			.lg li
			{
				height: 30px;
				display: inline-block;
				margin-left: 5px;
			}
			.lg a
			{
				display: block;
			}
			.head-ad
			{
				height: 100px;
			}
			.main-nav
			{
				overflow: hidden;
				background-color:#99CC66;
			}
			.nav
			{
				width: 1200px;
				height: 40px;
				margin: 0 auto;
				z-index: -1;
			}
			.nav ul
			{
				display: inline-block;
			}	
			.nav li
			{
				width: 83px;
				height: 100%;
				display: inline-block;
				font-size: 20px;
			}
			.nav h2
			{
				width: 20%;
				height: 100%;
				display: inline-block;
				text-align: center;
				color: #67AA2B;
				line-height: 40px;
			}
			.nav a
			{
				display: block;
				color: #fff;
				text-align: center;
				line-height: 40px;
			}
			.nav li a:hover
			{
				background-color: #669900;
			}

			/*设置页面整体内容布局为左中右三大块 */
			.content
			{
				width: 1200px;
				margin: 10px auto;
			}
			.l-content
			{
				width: 20%;
				float: left;
			}
			.c-content
			{
				padding: 0px 10px;
				margin: 0 auto;
				width: 700px;
			}
			.r-content
			{
				width: 20%;
				float: right;
			}

			/* 左侧菜单*/
			.category
			{
				padding:0 4px;
				border:2px solid #dbebbc;
			}

			.category h2
			{
				border-top: 1px solid #dbebbc;
				font-size: 18px;
				color: #5b9630;
				height: 16px;
				line-height: 16px;
				padding-top:5px;
				padding-left: 5px;
				margin-top: 10px;
			}
			.category .first
			{
				border-top: none;
			}
			.category h2 a
			{
				color: #5b9630;
			}
			.category-sub-content
			{
				margin-top:5px;
				overflow: hidden;
			}
			.category-sub-content a
			{
				background: url(http://book.dangdang.com/project/book/hosts/images/index/bg_book2.png) no-repeat right 0;
				color: #666;
				height: 18px;
				padding: 1px 6px;
				float: left;
				white-space: nowrap;		
			}
			.category-sub-content a:hover
			{
				color: #FF6406;
			}

			/*左侧广告*/
			.ad-show
			{
				border-top: 2px solid #dbebbc;
				overflow: hidden;
			}
			.ad-brand li
			{
				margin-top:5px;
			}
			.ad-brand img
			{
				
				width: 100%;
			}

			/**************************中部内容*************************/

			/*活动*/
			.active
			{
				height: 600px;
				overflow: hidden;
				border-bottom: 1px solid #F7F7F7;
			}
			.active-left,.active-right
			{
				display: inline-block;
			}
			.active-left
			{
				width: 500px;
				float: left;
			}
			.active-left img 
			{
				vertical-align: top;
				width: 500px;
				height: 300px;
			}
			.active-right
			{
				width: 200px;
				height: 100%;
			}
			.active-right img
			{
				vertical-align: top;
				width: 200px;
				height: 300px;
			}
			/* 推荐 */
			.recoment
			{
				margin-top: 20px;
			}
			.recoment-nav
			{
				border-bottom: 2px solid #C200FF;
			}
			.recoment-nav h2
			{
				text-align: center;
				font-size: 16px;
				line-height: 30px;
				color: #fff;
				/*display: inline-block;*/
				background: #B80DCC;
				height: 30px;
				width: 100px;
			}

			.recoment .cm-del-bd:hover
			{
				border-color: #C200FF;
			}
			.recoment a:hover
			{
				color: #C200FF
			}

			/*商品列表的通用设置*/
			.content-list
			{
				display: none;
				position: absolute;
			}
			.content-list.cur
			{
				position: relative;
				display:block;
			}
			.cm-del
			{
				width: 700px;
				overflow: hidden;
			}
			.cm-del-bd
			{
				position: relative;
				float: left;
				display:  inline-block;
				border: 1px solid #eee; 
			}
			.cm-del-bd div
			{
				padding: 1px;
				margin-left: 1px;
			}
			.cm-del-bd a
			{
				color: #666;
				display: block;
			}
			.cm-del-bd img
			{
				width: 170px;
				height: 140px;
			}
			.cm-del-bd div
			{
				height: 180px;
			}
			.cm-del-bd p
			{
				color: #666;
				margin-top: 3px;
				height: 15px;
				overflow: hidden;
				white-space: nowrap;
			}

			/*分类商品设置*/
			.commodity-del
			{
				margin-top: 30px;
				
			}
			.commodity-nav
			{
				border-bottom: 2px solid #443BD9;
				overflow: hidden;
			}
			.commodity-nav h2
			{
				float: left;
				display: inline-block;	
				font-size: 16px;
				background: #6947EE;
				color: #fff;
				text-align: center;
				width: 100px;
				height: 30px;
				line-height: 30px;
			}
			.commodity-nav ul
			{
				display: inline;
			}
			.commodity-nav li
			{
				display: inline-block;
				margin:0 5px; 
				width: 80px;
				height: 30px;
				float: left;
				text-align: center;
				line-height: 30px;
			}
			.commodity-nav a 
			{
				color:#666;
			}
			.commodity-del .cm-del-bd:hover
			{
				border-color: #443BD9;
			}
			.commodity-del a:hover
			{
				color: #443BD9;
			}
		</style>
	</head>
	<body>
		<div class="head">
			<div class="top">
				<div class="lg">
					<ul>
						<li><a id="user" href="#">sjhj</a></li>
						<li><a id="login" href="#">登陆</a></li>
						<li><a id="regist" href="#">注册</a></li>
					</ul>
				</div>
			</div>
			<div class="head-ad"></div>
			<div class="main-nav">
				<div class="nav">
					<h2><a href="/index">Line 商城</a></h2>
					<ul>
						<li><a href="">sj</a></li>
						<li><a href="">食品</a></li>
						<li><a href="">家具</a></li>
						<li><a href="">电器</a></li>
						<li><a href="">数码</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="content">
			<!-- left content-->
			<div class="l-content">
				<div class="category">
				<c:forEach items="${ plates }" var="p" varStatus="status">
					<c:if test="${status.count == 1 }">
						<h2 class="first"><a href="plate/itemlist/${ p.linkPath }/${ p.plate.id }">${ p.plate.name }</a></h2>
					</c:if>
					<c:if test="${status.count != 1 }">
						<h2><a href="plate/itemlist/${ p.linkPath }/${ p.plate.id }">${ p.plate.name }</a></h2>
					</c:if>
					<div class="category-sub-content">
					<c:forEach items="${ p.subPlates }" var="sp">
						<a href="plate/itemlist/${ sp.linkPath }/${ sp.plate.id}">${ sp.plate.name }</a>
					</c:forEach>
					</div>
				</c:forEach>
				</div>
				<div class="ad-show">
					<div class="ad-brand">
						<ul>
							<li><a href="#"><img src="/NetMall/resource/img/brand.jpg"/></a></li>
							<li><a href="#"><img src="/NetMall/resource/img/brand.jpg"/></a></li>
							<li><a href="#"><img src="/NetMall/resource/img/brand.jpg"/></a></li>
							<li><a href="#"><img src="/NetMall/resource/img/brand.jpg"/></a></li>
							<li><a href="#"><img src="/NetMall/resource/img/brand.jpg"/></a></li>
							<li><a href="#"><img src="/NetMall/resource/img/brand.jpg"/></a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="c-content">
				<div class="active">
						<div class="active-left">
							<img src="/NetMall/resource/img/big.jpg"/>
							<img src="/NetMall/resource/img/big.jpg"/>
						</div>
						<div class="active-right">
							<img src="/NetMall/resource/img/middle.png"/>
							<img src="/NetMall/resource/img/middle.png"/>
						</div>
				</div>
				<div class="recoment">
					<div class="recoment-nav">
						<h2>小编推荐</h2>
					</div>
					<div>
						<div class="content-list rec-foot index1 cur">
							<div class="cm-del">
								<div class="cm-del-bd">
									<div>
										<a href=""><img src="/NetMall/resource/img/xie.jpg"></a>
										<p><a href="">超值优惠，耐克皮鞋</a></p>
										<p>$299</p>
									</div>
								</div>
								<div class="cm-del-bd">
									<div>
										<a href=""><img src="/NetMall/resource/img/xie.jpg"></a>
										<p><a href="">超值优惠，耐克皮鞋</a></p>
										<p>$299</p>
									</div>
								</div>
								<div class="cm-del-bd">
									<div>
										<a href=""><img src="/NetMall/resource/img/xie.jpg"></a>
										<p><a href="">超值优惠，耐克皮鞋</a></p>
										<p>$299</p>
									</div>
								</div>
								<div class="cm-del-bd">
									<div>
										<a href=""><img src="/NetMall/resource/img/xie.jpg"></a>
										<p><a href="">超值优惠，耐克皮鞋</a></p>
										<p>$299</p>
									</div>
								</div>
								<div class="cm-del-bd">
									<div>
										<a href=""><img src="/NetMall/resource/img/xie.jpg"></a>
										<p><a href="">超值优惠，耐克皮鞋</a></p>
										<p>$299</p>
									</div>
								</div>
								<div class="cm-del-bd">
									<div>
										<a href=""><img src="/NetMall/resource/img/xie.jpg"></a>
										<p><a href="">超值优惠，耐克皮鞋</a></p>
										<p>$299</p>
									</div>
								</div>
								<div class="cm-del-bd">
									<div>
										<a href=""><img src="/NetMall/resource/img/xie.jpg"></a>
										<p><a href="">超值优惠，耐克皮鞋</a></p>
										<p>$299</p>
									</div>
								</div>
								<div class="cm-del-bd">
									<div>
										<a href=""><img src="/NetMall/resource/img/xie.jpg"></a>
										<p><a href="">超值优惠，耐克皮鞋</a></p>
										<p>$299</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="commodity-del">
					<div class="commodity-nav">
						<h2>分类图书</h2>
						<ul>
							<c:forEach items="${ plates }" var="p" varStatus="status">
							<li class="com-tag index${ status.count }"><a href="../${ p.linkPath }/${ p.plate.id}">${ p.plate.name }</a></li>
							</c:forEach>
						</ul>
					</div>
					<div>
					<c:forEach items="${plates}" var="p" varStatus="status">
					<c:if test="${ status.count == 1}">
						<div class="content-list com-foot index${ status.count } cur">
					</c:if>
					<c:if test="${ status.count != 1}">
						<div class="content-list com-foot index${ status.count }">
					</c:if>
							<div class="cm-del">
							<c:forEach items="${ p.commodities }" var="c">
								<div class="cm-del-bd">
									<div>
										<a href=""><img src="/NetMall/resource/img/${ c.image }"/></a>
										<p><a href="">${c.description}</a></p>
										<p>$299</p>
									</div>
								</div>
							</c:forEach>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
			</div>
			<div class="r-content"></div>
		</div>
		<div>
			<ul>
			</ul>
		</div>
	</body>
	<script type="text/javascript" src="/NetMall/resource/js/TagPlugin.js"></script>
	<script type="text/javascript">
		var tag = new TagPlugin('com');
		tag.registHoverEven();
	</script>
</html>