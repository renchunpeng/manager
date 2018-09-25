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
			margin-left:20px;
            margin-top:30px;
		}

		div.container p.title{
            font-size:30px;
            color:#dd4b39;
		}

		div.content{
			position:absolute;
			margin-top:120px;
            margin-left:370px;
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
        <img src="${ctx}/lib/img/noPermissionImg.png">
        <div class="content">
            <p class="title">此地址访问受限</p>
	        <p style="font-size:14px;margin-top:15px;">
	                        您没有权限访问此页面，请与管理员联系以查明您是否有访问权限
	        </p>
	        <div class="resetButton">
                <a href="javascript:top.location='${ctx}/index.html';">返回首页</a>
            </div>
       </div>
</div>
<div class="footDiv">
   <strong>Copyright © 2014-2015 <span style="color:#3c8dbc">HSNN</span>.</strong> All rights reserved. 
</div>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>


</body>
</html>