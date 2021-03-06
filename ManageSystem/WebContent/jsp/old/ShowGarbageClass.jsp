<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<% 
String name = (String)session.getAttribute("username"); 
String P = (String)session.getAttribute("pagenum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>ChairC's Blog - 垃圾分类查询</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Index/index_main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/flat-ui.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/swiper.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css" type="text/css">
<script src="${pageContext.request.contextPath}/js/swiper.min.js"
	type="text/javascript"></script>
<link type="text/css" rel="stylesheet" charset="UTF-8"
	href="https://translate.googleapis.com/translate_static/css/translateelement.css">
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Index/index_main.js"></script>

</head>
<body>



	<!--******************************下面是导航栏导航栏******************************-->

	<div>
		<header id="header"
			class="header header--fixed hide-from-print animated slideDown"
			role="banner">
			<div class="container">
				<nav id="nav" class="nav-wrapper" role="navigation">
					<ul class="nav nav--main">
						<li class="nav__item ">
							<!--这是名字1的链接地址--> <a class="header__link subdued"
							href="<%=basePath%>jsp/picture/Picture_Index.jsp"> <!--这是图标1（可根据从网上下载的图标中引用类型  注：请将类型写在main.css中）-->
								<span aria-hidden="true" class="icon-pic iconfont"></span> <!--这是名字1-->
								<span class="complimentary push--left">图片</span>
						</a>
						</li>
						<li class="nav__item ">
							<!--这是名字2的链接地址--> <a class="header__link subdued"
							href="<%=basePath%>MessageIndexServlet"> <!--这是图标2（可根据从网上下载的图标中引用类型  注：请将类型写在main.css中）-->
								<span aria-hidden="true" class="icon-comments iconfont"></span>
								<!--这是名字2--> <span class="complimentary push--left">留言板</span>
						</a>
						</li>
						<li class="nav__item ">
							<!--这是名字3的链接地址--> <a class="header__link subdued"
							href="<%=basePath%>LoginBackstageServlet"> <!--这是图标3（可根据从网上下载的图标中引用类型  注：请将类型写在main.css中）-->
								<span aria-hidden="true" class="icon-denglu iconfont"></span> <!--这是名字3-->
								<span class="complimentary push--left">个人</span>
						</a>
						</li>
					</ul>
				</nav>
				<a href="<%=basePath%>ChairC_Index.jsp" class="brand header__link">
					<!--这是主页标签--> <b class="brand__forename" style="color: #34495e">ChairC's
						Blog</b><b class="brand__surname"></b>
				</a>
			</div>
		</header>
	</div>

	<!--******************************上面是导航栏导航栏******************************-->



	<!--******************************下面是主页内容******************************-->
	<div
		style="width: 100%; height: 2500px; padding-top: 75px; background-color: #fff;">
		<div style="text-align: center; padding-left: 5%; padding-right: 5%;">
			<div>
				<div style="padding-top: 75px;">
					<c:forEach var="G" items="${searchgarbage}">
						<div style="border: 1px solid #dddddd; padding-top: 10px;">
							<div>
								<p>${G.garbagename}属于<font color="red">${G.garbageclass}</font>
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
				<div>					
					<p>查询不到？请为我们添加分类吧！</p>
					<input type="button" onclick="location.href='<%=basePath%>jsp/garbageclass/SearchGarbageClass.jsp'" 
					class="btn btn-primary"	value="返回查询" style="cursor:pointer;">
					<input type="button" onclick="location.href='<%=basePath%>jsp/garbageclass/AddGarbage.jsp'" 
					class="btn btn-primary"	value="添加分类" style="cursor:pointer;">
					<article>
						<header>垃圾分类可以这么记：</header><br>
						猪能吃的是湿垃圾，猪不能吃的是干垃圾，<br>
						猪吃了会死的是有害垃圾，卖了能买猪的是可回收垃圾！
					</article>		
				</div>
			</div>			
		</div>
	</div>
	<div
		style="position: fixed; right: 10px; bottom: 80px; width: 50px; z-index: 1999;">
		<button id="backtop" class="btn btn-info navguide">返回头部</button>
	</div>
</body>


<script>
    //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓下面是导航栏隐藏↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    (function () {
        var header = new Headroom(document.querySelector("#header"), {
            tolerance: 5,
            offset: 205,
            classes: {
                initial: "animated", //动画效果
                pinned: "slideDown", //固定时向下滑动
                unpinned: "slideUp" //取消固定时向上滑动
            }
        });
        header.init();

        //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓下面是按钮隐藏↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

        //    var bttHeadroom = new Headroom(document.getElementById("btt"), {
        //        tolerance : 0,
        //        offset : 500,
        //        classes : {
        //            initial : "slide",
        //            pinned : "slide--reset",
        //            unpinned : "slide--down"
        //        }
        //    });
        //    bttHeadroom.init();
    }());
</script>

<!--******************************上面是导航栏方法******************************-->

<script src="${pageContext.request.contextPath}/js/Index/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/js/Index/h.js"
	type="text/javascript"></script>

<!--下面是h.js的备份-->
<script
	src="${pageContext.request.contextPath}/js/Index/h.js(备份用时删掉括号内容)"
	type="text/javascript"></script>
<!--上面是h.js的备份-->


<!--下面是图标-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Index/index_iconfont.css">
<script
	src="${pageContext.request.contextPath}/js/Index/index_iconfont.js"></script>
<!--上面是图标-->
<script type="text/javascript">
	var btn = document.getElementById('backtop');
	//var scrollTop  = document.documentElement.scrollTop||document.body.scrollTop;//兼容性写法，并且在滚动事件内可以实时获得滚动条距顶部的距离 ;

	btn.onclick = function(){

 	$('body,html').animate({scrollTop:0},300)

}
 
</script>
</html>