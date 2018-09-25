<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<title>系统登录</title>
	<%@ include file="/WEB-INF/component/commonCSS.jsp" %>
	<style type="text/css">
		html, body {
			width: 100%;
			height: 100%;
			margin: 0px;
			padding: 0px;
			overflow: hidden;
			background-color: #ecf0f5;
		}
		div.container {
			width:740px;
			height:400px;
			margin:100PX auto;
		}

		div.container img{
			float:left;
			margin-left:30px;
		}

		div.container p.title{
			font-family:Arial;
			font-size:70px;
			color:#000;
		}

		div.content{
			position:absolute;
			margin-top:100px;
			margin-left:380px;
			line-height:25px;
		}

		div.resetButton{
			margin-top:22px;
		}
		div.resetButton a,div.resetButton a:link,a:visited {
			text-decoration:none;
			font-size:14px;
			color:#fff;
			background-color:#3c8dbc;
			text-align:center;
			letter-spacing:5px;
			padding:7px 15px 7px 20px;
		}

		div.resetButton a:hover,a:active{
		    background-color:#367fa9;
		}
		div.footDiv {
		    font-family:Arial;
			font-size: 11px;
			position: absolute;
			width: 100%;
			text-align: center;
			bottom: 0px;
			height: 30px;
			line-height: 30px;
			left: 0px;
			z-index: 0px;
		}
   </style>
</head>

<body>
<div class="container">
        <img src="${ctx}/lib/img/404ErrorImg.png">
        <div class="content">
            <p class="title">Uh,oh...</p>
	        <p style="font-size:14px;margin-top:30px;">您访问的页面不存在
	        <br/>
	                        您要查看的网址可能已被删、名称已被更改，或者暂时不可用。
	        </p>
	        <div class="resetButton">
                <a href="javascript:top.location='${ctx}/index.html';">返回首页</a>
            </div>
       </div>
</div>

<%@ include file="/WEB-INF/component/commonJS.jsp" %>


</body>
</html>