<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
    <section class="content-header">
        <h1><spring:message code='message.lable.miMaXiuGai'/></h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i><spring:message code='message.lable.first'/></a></li>
            <li class="active"><a href="#"><spring:message code='message.lable.miMaXiuGai'/></a></li>
        </ol>
    </section>
    <section class="content">
        <div class=" box box-success ">
                <div class="box-body" >
                    <div class="form-group form-group-xs" style="margin-left:200px;margin-top:40px">
                    	<div class="col-sm-5 text-right" style="color:red" >重置密码时间已超过有效24小时，请联系管理员！</div>
                    </div>
                    <div style="height:40px"></div>
                </div>
        </div>
    </section>
</body>
</html>

