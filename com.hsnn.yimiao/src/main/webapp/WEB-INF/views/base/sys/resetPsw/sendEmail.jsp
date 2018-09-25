<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>
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
                <div class="box-footer text-center">
                    <button type="button" class="btn btn-success btn-sm" onclick="submitPassword();">重置密码（内置测试账号）</button>
                </div>
        </div>
    </section>
    <%@ include file="/WEB-INF/component/commonJS.jsp" %>
    <script type="text/javascript">
    	function submitPassword() {
    		  var username ='bbb';
    		  var email = '245387976@qq.com';
	    	  $.HN.message.confirm("确定为"+username+"重置密码吗？", '', '').on(function (e) {
	              if (e) {
	            		$.post("${ctx}/resetPsw/sendEmail.html", {
	            			"username" : username,
	            			"email" : email
	            		}, function(result) {
	            			if (result.success) {
	            				top.$.HN.message.alert(result.msg, "", "success");
	            			} else {
	            				top.$.HN.message.alert(result.msg || "<spring:message code='message.HN.alert.fail'/>", "", "error");
	            			}
	            		}, "json");
	    		}
	       	  });
    	}
    </script>
</body>
</html>
