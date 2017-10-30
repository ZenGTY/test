<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<style type="text/css">
<!--
@import url("${pageContext.request.contextPath }/resources/css/indexcss.css");

-->
@media screen and (max-width:1920px) {
	body {
		font-size: 20px;
	}
}

@media screen and (max-width:1680px) {
	body {
		font-size: 18px;
	}
}

@media screen and (max-width:1440px) {
	body {
		font-size: 17px;
	}
}
body{
	background: #4478c9;
}
* {
	font-family: 微软雅黑;
	margin: 0px;
	padding: 0px;
}

* ul {
	list-style: none;
}

.main {
	width: 100%;
	height:100%;
	position: absolute;
}
.title {
	width: 100%;
	height: 15%;
	margin: 0 auto;
	background: #4478c9;
	position:relative;
}
.titleText{
		position:absolute;
		margin:30px 0px 30px 30px;
	}
.Frame {
	width: 100%;
	height: 85%;
	margin: 0 auto;
	background: #4478c9;
	position:absolute;
}

.leftFrame {
	width: auto;
	height: auto;
	margin: 0px 0px 0px 10px;
	background: #dce8fb;
	float: left;
}

.middleFrame {
	width: 84%;
	height: 100%;
	position: absolute;
	top: 0px;
	left: 210px;
	background: #efefef;
}
.lefttitle {
	width: 100%;
	color: #1946bb;
	font-weight: bold;
}

.leftFrame ul {
	width: 100%;
}

.leftFrame ul li {
	width: 200px;
	color: #4369c9;
	margin: 0px;
	padding-top: 5px;
	padding-bottom: 5px;
	line-height: 40px;
	border-top: 2px solid #ccc;
	border-left: 2px solid #ccc;
	cursor: pointer;
}

	.imgCss{
		float: left;
	}
	.imgCss img{
		width:50px;
		height:50px;
		padding-left:10px;
		overflow:hidden;
	}
	.textCss{
		height:50px;
		line-height:50px;
		padding-left:10px;
		text-align: center;
	}
.tab{
	width:100%;
	height:45px;
	background:#393D49;
}
.tab ul{
	list-style:none;
	height:40px;
	width:100%;
	border-left:1px solid #ccc;
}
.tab ul li{
	float:left;
	width:auto;
	height:40px;
	line-height:40px;
	background:#009688;
	text-align:center;
	padding-left:10px;
	padding-right:10px;
	border-right:1px solid #ccc;
	border-bottom:1px solid #ccc;
	border-top:1px solid #ccc;
}
.tab ul li div{
	float:left;
}
.deleteTabimg{
	margin-top:6px;
	margin-left:3px;
}
.deleteTabimg img{
	width:35px;
	height:35px;
}
.iframes{
	width:100%;
	height:95%;
}
.iframe{
	width:100%; 
	height:100%;
}

</style>
<body>
	<div class="main">
		<div class="title">
			<div class="titleText">
				<span class="titleSpan1">会计之家KIS</span> <span class="titleSpan2">标准版</span>
			</div>
		</div>
		<div class="Frame">
			<div class="leftFrame">
				<span class="lefttitle">主功能选项</span>

				<ul>
					<li>
						<div class="imgCss">
							<img src="${pageContext.request.contextPath}/resources/img/mydesk.png">
						</div>
						<div class="textCss">首页<input type="hidden" value="datagram.jsp"></div>
					</li>
					<li>
						<div class="imgCss">
							<img
								src="${pageContext.request.contextPath}/resources/img/accounting.png">
						</div>
						<div class="textCss">业务处理<input type="hidden" value="Recordvoucher.jsp"></div>
					</li>
					<li>
						<div class="imgCss">
							<img
								src="${pageContext.request.contextPath}/resources/img/fixed assets.png">
						</div>
						<div class="textCss">固定资产</div>
					</li>
					<li>
						<div class="imgCss">
							<img
								src="${pageContext.request.contextPath}/resources/img/payroll control.png">
						</div>
						<div class="textCss">工资管理</div>
					</li>
					<li>
						<div class="imgCss">
							<img
								src="${pageContext.request.contextPath}/resources/img/import export.png">
						</div>
						<div class="textCss">往来管理</div>
					</li>
					<li>
						<div class="imgCss">
							<img
								src="${pageContext.request.contextPath}/resources/img/statement analysis.png">
						</div>
						<div class="textCss">报表与分析<input type="hidden" value="income.jsp"></div>
					</li>
					<li>
						<div class="imgCss">
							<img src="${pageContext.request.contextPath}/resources/img/cashier.png">
						</div>
						<div class="textCss">出纳管理</div>
					</li>
					<li>
						<div class="imgCss">
							<img src="${pageContext.request.contextPath}/resources/img/system.png">
						</div>
						<div class="textCss">系统维护</div>
					</li>

				</ul>
			</div>
			<div class="middleFrame">
				<div class="tab">
					<ul>
						<li><div class="tabName">首页<input type="hidden" value="income.jsp"></div></li>
					</ul>
				</div>
				<div class="iframes" id="1">
					<Iframe name="tt" class="iframe" src="${pageContext.request.contextPath }/view/datagram.jsp"scrolling="no" frameborder="0"></iframe> 
				</div>
			</div>

		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var clientheight=document.documentElement.clientHeight;	//获取浏览器body可用高度
		var tabNames = new Array();
		tabNames[0]="首页";
		$('.main').css({'height':clientheight});
		var fontsize=$('.lefttitle').css('fontSize');
		$('.leftFrame ul li').eq(0).css({
			'height' : '60px',
			'background' : '#fefeff'
		});
		$('.leftFrame ul li').eq(0).find('img').css({
			'width' : '65px',
			'height' : '65px'
		});
		$('.leftFrame ul li').eq(0).find('.textCss').css({
			'font-size' : '20px',
			'line-height' : '65px',
			'height' : '65px',
			'font-weight' : 'bold'
		});
		$('.tab').on('click','.tabName',function(){
			tab1=$(this).find("input").val();
			$('.iframes').hide();
			tab2=$(this).text();
			for(var l=0;l<tabNames.length;l++){
				if(tab2==tabNames[l]){
					$('.middleFrame').children("div").eq(l+1).show();
				}
			}
		});
		$('.tab').on('mouseenter','.deleteTabimg',function(){
			$(this).find("img").attr('src','${pageContext.request.contextPath}/resources/img/deleteTab2.png');
		});
		$('.tab').on('mouseleave','.deleteTabimg',function(){
			$(this).find("img").attr('src','${pageContext.request.contextPath}/resources/img/deleteTab.png');
		});
		$('.leftFrame ul li').click(
				function() {
					left1=$(this).text().trim();
					left2=$(this).find("input").val();
					left3=0;
					$('.iframes').hide();
					for(var i=0;i<tabNames.length;i++){
						if(left1==tabNames[i]){
							$('.middleFrame').children("div").eq(i+1).show();
							left3+=1;
						}
					}
					if(left3>0){
					}else{
						$('.middleFrame').append("<div class="+"iframes"+" id="+left1+"><Iframe src="+"${pageContext.request.contextPath }/view/"+left2+""+" width="+"100%"+" height="+"100%"+" scrolling="+"yes"+" frameborder="+"0"+"></iframe></div>");	
						$('.tab ul').append("<li><div class="+"tabName"+">"+left1+"<input type="+"hidden"+" value="+left2+"></div><div class="+"deleteTabimg"+"><img src="+"${pageContext.request.contextPath}/resources/img/deleteTab.png"+"></div></li>");
						tabNames.push(left1);
					}
				
					$(this).css({
						'height' : '60px',
						'background' : '#fefeff'
					});
					$(this).find('img').css({
						'width' : '65px',
						'height' : '65px'
					});
					$(this).find('.textCss').css({
						'font-size' : '20px',
						'line-height' : '65px',
						'height' : '65px',
						'font-weight' : 'bold'
					});
					$('.leftFrame ul li').not($(this)).css({
						'height' : '50px',
						'background' : '#dce8fb'
					});
					$('.leftFrame ul li').not($(this)).find('img').css({
						'width' : '50px',
						'height' : '50px'
					});
					$('.leftFrame ul li').not($(this)).find('.textCss').css({
						'font-size' : fontsize,
						'line-height' : '50px',
						'height' : '50px',
						'font-weight' : 'normal'
					});

				});
		$('.leftFrame ul li').eq(0).click(
				function() {
					v=$(this).index();
					$(this).css({
						'height' : '60px',
						'background' : '#fefeff'
					});
					$(this).find('img').css({
						'width' : '65px',
						'height' : '65px'
					});
					$(this).find('.textCss').css({
						'font-size' : '20px',
						'line-height' : '65px',
						'height' : '65px',
						'font-weight' : 'bold'
					});
					$('.leftFrame ul li').not($(this)).css({
						'height' : '50px',
						'background' : '#dce8fb'
					});
					$('.leftFrame ul li').not($(this)).find('img').css({
						'width' : '50px',
						'height' : '50px'
					});
					$('.leftFrame ul li').not($(this)).find('.textCss').css({
						'font-size' : fontsize,
						'line-height' : '50px',
						'height' : '50px',
						'font-weight' : 'normal'
					});
				});
		
	});
	
</script>
</html>