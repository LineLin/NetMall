<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
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
				width: 196px;
				height:30px;
				border-bottom: 1px solid #dedede;
			}
			.category-item h3
			{
				line-height: 2em;
				height: 30px;
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
				display: inline-table;
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
			
			#slider
			{
				display: inline-block;
				position: relative;
				width:700px;
				height: 302px;
				margin-left: 204px;
				overflow: hidden;
			}
			#slider ul
			{
				width: 3000px;
				position: absolute;
				float: left;
				left: 0px;
			}
			#slider ul li
			{
				display: inline;
				list-style: none;
				float: left;
			}
			#slider a
			{
				display: block;
			}
			#slider img
			{
				margin-top:4px; 
				display: block;
				width: 700px;
				height: 298px;
			}
			.sibd
			{
				position: absolute;
				left: 600px;
				top:280px;
				z-index: 10;
			}
			.btn-imgSel
			{
				cursor: pointer;
				text-align: center;
				width: 20px;
				height: 20px;
				display: inline-block;
				background-color: #DDD;
				border-radius: 15px;
			}
			.sibd .cur
			{
				background: #99CC66;
			}
			#news
			{
				display: inline-block;
				position: absolute;
				float:right;
				margin-left: 4px;
				width: 292px;
			}
			#news h3
			{
				height: 29px;
				line-height: 30px;
				border-bottom: 2px solid #eee;
				color: #666;
				font-size: 16px;
			}
			#news ol
			{
				width: 290px;
				height: 265px;
				border:1px solid #eee;
				border-top: 0px;
			}
			#news ol li
			{
				height: 30px;
				margin-top: 5px;
				text-align: left;
			}
			#news a
			{
				color: #666;
				display: block;
				text-overflow:ellipsis;
				overflow: hidden;
				white-space: nowrap;
			}
			.cm-b
			{
				height: 580px;
				position: relative;
				margin: 20px 0;
				overflow: hidden;
				background-color: #fff;
			}
			.cm-nav
			{
				color: #666;
				font-family: 微软雅黑 "serif";
				border-bottom: 2px solid #60a42c;
			}
			.cm-nav a
			{
				color: #666;
				font-family: 微软雅黑 "serif"; 
			}
			.cm-nav h2
			{
				text-align: center;
				width: 228px;
				height: 45px;
				line-height: 30px;
				font-size: 22px;
				display: inline-block;
			}
			.cm-nav ul
			{
				display: inline-block;
			}
			.cm-nav li
			{
				cursor: pointer;
				text-align: center;
				width: 120px;
				display: inline-block;
				margin-right: 5px;
				height: 40px;
				padding-top:5px; 
			}
			.cm-nav .cur
			{
				border:1px solid #99cc66;
			}
			.cm-det ul
			{
				width: 908px;
				display: none;
			}
			.cm-det ul.cur
			{
				display: block;
			}
			.cm-det ul li
			{	
				width: 214px;
				display: inline-block;
				margin: 4px;
				
			}
			.cm-det ul a
			{
				display: block;
				color: #666;
			}
			.cm-det ul img
			{
				border:1px solid #eee;
				width:100%;
				height: 200px;
			}
			.cm-det ul span
			{
				height: 20px;
				padding-top: 5px;
				display: block;
				white-space: nowrap;
				overflow: hidden;
				text-overflow:ellipsis;
			}











			#mask
			{
				position: absolute;
				display: none;
				top:0px;
				height: 100%;
				background: rgba(255, 255, 255, 0.5);
			}
			#login-box
			{
				z-index: 10;
				display: none;
				margin: auto;
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
			#error-msg
			{
				margin: 8px 0;
				display:none;
			}
		</style>

		<script src="resource/js/jquery-1.11.0.js">
		</script>
	</head>
	<body>
		<div class="page">
			<div class="head-0">
				<ul>
					<li><a id="user" href="#">${userName}</a></li>
					<c:if test="${userName == null }">
					<li><a id="login" href="#">登陆</a></li>
					<li><a id="regist" href="#">注册</a></li>
					</c:if>
				</ul>
			</div>
			<div class="head-ad"></div>
			<div class="md">
				<div class="categorys">
					<div class="l_cat_til">
						<h2><a href="">全部商品分类</a></h2>
					</div>
					<div class="category-bd">
						<c:forEach items="${pLists}" var="p">
						<div class="category-item">
							<h3>
								<a href="plate/itemlist/${p.linkPath}/${p.plate.id}">${p.plate.name}</a>
							</h3>
							<div>
								<ul class="l-subitem">
								<c:forEach items="${p.subPlates}" var="sp" begin="0" end="${p.listSize/2-1+0.5}">
									<li>
										<h4><a href="plate/itemlist/${sp.linkPath}/${sp.plate.id}">${sp.plate.name}</a></h4>
										<c:forEach items="${sp.subPlates}" var="tp">
										<a href="plate/itemlist/${tp.linkPath}/${tp.plate.id}">${tp.plate.name}</a>
										</c:forEach>
									</li>
								</c:forEach>
								</ul>
								<ul class="r-subitem">
								<c:forEach items="${p.subPlates}" var="sp" begin="${p.listSize/2+0.5}">
									<li>
										<h4><a href="${sp.linkPath}/${sp.plate.id}">${sp.plate.name}</a></h4>
										<c:forEach items="${sp.subPlates}" var="tp">
										<a href="${tp.linkPath}/${tp.plate.id}">${tp.plate.name}</a>
										</c:forEach>
									</li>
								</c:forEach>
								</ul>
							</div>
						</div>
						</c:forEach>
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
				<div id="slider">
					<ul id="slider-list">
						<li><a href="#"><img src="resource/img/ad.jpg"/></a></li>
						<li><a href="#"><img src="resource/img/003.png"/></a></li>
						<li><a href="#"><img src="resource/img/ad.jpg"/></a></li>
						<li><a href="#"><img src="resource/img/003.png"/></a></li>
					</ul>
					<div class="sibd">
						<span class="btn-imgSel cur">1</span>
						<span class="btn-imgSel">2</span>
						<span class="btn-imgSel">3</span>
						<span class="btn-imgSel">4</span>
					</div>
				</div>
				<div id="news">
					<div>
						<h3>Line商城快报</h3>
						<ol>
							<li><a href="#">大减价是看见的萨克的的撒kdj萨克斯就是大家</a></li>
							<li><a href="#">大减价</a></li>
							<li><a href="#">大减价</a></li>
							<li><a href="#">大减价</a></li>
							<li><a href="#">大减价</a></li>
							<li><a href="#">大减价</a></li>
							<li><a href="#">大减价</a></li>
							<li><a href="#">大减价</a></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="comm-show">
			<c:forEach items="${pLists}" var="p">
				<div class="cm-b">
					<div class="cm-nav">
						<h2>${p.plate.name}</h2>
						<ul>
							<c:forEach items="${p.subPlates}" var="sp" begin="0" end="4" varStatus="status">
								<c:if test="${status.count == 1}">
								<li class="cm-title${status.count} cur"><a href="plate/itemlist/${sp.linkPath}/${sp.plate.id}">${sp.plate.name}</a></li>
								</c:if>
								<c:if test="${status.count != 1}">
								<li class="cm-title${status.count}"><a href="plate/itemlist/${sp.linkPath}/${sp.plate.id}">${sp.plate.name}</a></li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
					<div class="cm-det">
						<c:forEach items="${ p.subPlates }" var="sp" varStatus="status">
							<ul class="foot${status.count} ${status.count == 1 ? 'cur':''}">
								<c:forEach items="${sp.commodities}" var ="commodity">
									<li>
										<a href="#"><img src="resource/img/${commodity.image}"/></a>
										<a href="#"><span>${commodity.description}</span></a>
										<span style="color:#E4393C">￥${commodity.price}</span>
									</li>
								</c:forEach>
							</ul>
						</c:forEach>
					</div>
				</div>
				</c:forEach>
			</div>
			<div id="mask">
				<div id="login-box">
					<a id="close" href="#">X</a>
					<div class="lg-form">
						<p id="error-msg" style="color:red;text-align:center;"></p>
						账号: <input id="lg-account" type="text" name="account" onfocus="true"/><br/>
						密码: <input id="lg-psw" type="password" name="password"/><br/>
						<input id="lg-submit" class="btn-submit" type="submit" value="登陆"/>
					</div>
				</div>
			</div>
		</div>
		

		<script type="text/javascript">
			startImagePlay();
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
				$("#error-msg").css("display","none");
			});

			//----------------------图片轮播-----------------------------
			var i=0;
			var frequence = 25.0/1000;
			var count = 4;
			var timeTaskId;
			function setCurBtn(){
				var btnList = $(".btn-imgSel");
				for(var j = 0;j<count;j++){
					if(j == i){
						$(btnList[j]).attr("class","btn-imgSel cur");
					}else{
						$(btnList[j]).attr("class","btn-imgSel");
					}
				};
			}
			function changeImage(step,interval,isAuto){
			
				var left = -(i*700.0);
				i = isAuto ? (i +1)%count : i;
				var distance = interval/step;
				for(var j=0;j<step;j++){
					
					if(i == 0){
						$($("#slider-list").children()[0]).css({
								position:"relative",
								left: 700*(count)+"px"
							});
						setTimeout(function(){
							$($("#slider-list").children()[0]).css({
								position:"static",
								left: "0px"
							});
							$("#slider-list").css("left","0px");
						},(1/frequence)*step+1);
					}/*else{
						$($("#slider-list").children()[0]).css({
								position:"static",
								left:"0px"
							});
					}*/
					setTimeout(function(){
						left-= distance;	
						$("#slider-list").css("left",left+"px");
					},(1/frequence)*(j+1));
				}
				setCurBtn();
			}
			function startImagePlay(){
				timeTaskId = setInterval("changeImage(20,700,true)",5000);
			}
			function stopImagePlay(){
				clearInterval(timeTaskId);
			}
			

			$(".btn-imgSel").click(function(){
				stopImagePlay();
				var flag = false;
				var to = $(this).text()-1;
				var interval = (to - i)*700;
				if(i==0){
					flag = true;
				}
				changeImage(20,interval,flag);
				i = to;
				setCurBtn();
				startImagePlay();
			});
			//------------------------------商品展示栏tag切换---------------
			$(".cm-nav li").mouseover(function(){
			
				var cIndex = $(this).attr("class").substring(8,10);
				var pNode = $(this).siblings(".cur")[0];
				if(pNode){
					var pIndex = $(pNode).attr("class").substring(8,10);			
					$(pNode).attr("class","cm-title"+pIndex);
					$(this).attr("class","cm-title"+cIndex+" cur");

					var parentN = $(this).parents(".cm-nav")[0];
					var detDiv = $(parentN).next();
					
					var pDetNode = $(detDiv).find(".cur")[0];
					var cDetNode = $(detDiv).find(".foot"+cIndex)[0];
					$(pDetNode).attr("class","foot"+pIndex);
					$(cDetNode).attr("class","foot"+cIndex+" cur");
				}
			});
			//Ajax 登陆
			$("#lg-submit").click(
				function (){
					$.ajax({
						url: "user/login",
						type:"POST",
						cache:false,
						headers:{
							'Content-Type':'application/json',
							'Accept':'application/json'
						},
						dataType:"json",
						data: JSON.stringify({
							'account' : $("#lg-account").val(),
							'password' : $("#lg-psw").val()
						}),
						error: function(){
							$("#error-msg").innerHTML="服务器繁忙，请重新试过。";
						},
						success: function(data){
							if(data.flag == true){
								$("#mask").css("display","none");
								$("#login-box").css("display","none");
								$("#error-msg").css("display","none");
								$("#login").innerHTML = $("#regist").innerHTML = "";
								$("#user").innerHTML = data.user.userName;
							}else{
								$("#error-msg").css("display","block");
								$("#error-msg").text(data.errorMsg);
							}
						}
					});
				}
			);
		</script>
	</body>
</html>
