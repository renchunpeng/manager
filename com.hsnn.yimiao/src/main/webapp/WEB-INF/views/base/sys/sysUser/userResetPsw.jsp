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
            <li><a href="${ctx}/home.html"><i class="fa fa-home"></i><spring:message code='message.lable.first'/></a></li>
            <li class="active"><a href="#">信息维护</a></li>
            <li class="active"><a href="#"><spring:message code='message.lable.miMaXiuGai'/></a></li>
        </ol>
    </section>
    <section class="content">
        <div class=" box box-success ">
            <form id="form" class="form-horizontal" action="changePassword.html" method="post">
            <input type='password'  maxlength="127" hidden />
                <div class="box-body" style="background:url(${ctx}/lib/img/checkpassword.png);background-repeat: no-repeat;background-position: 115px 65px ">
                    <div class="form-group form-group-xs" style="margin-left:200px">
                        <label for="newpassword" class="col-sm-2 text-right"><spring:message code='旧密码'/><spring:message code="message.yanZheng.maoHao"/></label>
                        <div class="col-sm-5 text-left">
                            <input class="form-control" id="oldpassword" name="oldpassword" placeholder="<spring:message code='旧密码'/>" type="password" maxlength="127">
                        </div>
                    </div>
                    
                    <div class="form-group form-group-xs" style="margin-left:200px">
                        <label for="newpassword" class="col-sm-2 text-right"><spring:message code='message.lable.newPWD'/><spring:message code="message.yanZheng.maoHao"/></label>
                        <div class="col-sm-5 text-left">
                            <input class="form-control" id="newpassword" name="newpassword" placeholder="<spring:message code='message.lable.newPWD'/>" type="password" maxlength="127">
                        </div>
                    </div>
                    
                    
                    <div class="form-group form-group-xs" style="margin-left:200px">
                        <label for="passwordRepeat" class="col-sm-2 text-right"><spring:message code='message.lable.confirmPWD'/><spring:message code="message.yanZheng.maoHao"/></label>
                        <div class="col-sm-5 text-left">
                            <input class="form-control" id="passwordRepeat" name="passwordRepeat" placeholder="<spring:message code='message.lable.confirmPWD'/>" type="password" maxlength="127">
                        </div>
                    </div>
                    <div style="height:20px"></div>
                     <div class="form-group form-group-xs">
                          <label for="newpassword" class="col-sm-3 text-right"><i class="fa fa-exclamation-circle fa-lg" style="color:#dd4b39;"></i>&nbsp;<span style="color:#dd4b39;font-weight:600"><spring:message code="message.lable.tiShi" /><spring:message code="message.yanZheng.maoHao"/></span></label>					        
						    <div class="col-sm-7 text-left" style="color:#dd4b39">
						         <spring:message code="message.lable.PWDhint" />
						    </div>
                    </div>
                </div>
                <div class="box-footer text-center">
                    <%-- <ms:btn url="/sysUser/updateSysUserPassword.html"><button type="button" class="btn btn-success btn-sm" onclick="submitPassword();"><spring:message code="message.button.saveSpacing"/></button></ms:btn>  --%>
                    <button type="button" class="btn btn-success btn-sm" onclick="submitPassword();"><spring:message code="message.button.saveSpacing"/></button>
                </div>
            </form>
        </div>
    </section>
    <%@ include file="/WEB-INF/component/commonJS.jsp" %>
    <script type="text/javascript">
    	function submitPassword() {
		    var parn =new RegExp("^[0-9]{6}$");
			
		    var oldpassword = $.trim($("#oldpassword").val());
			if (oldpassword == null || oldpassword == "") {
				$.HN.message.alert("<spring:message code='请输入旧密码!'/>", "", "warn");
				return;
			}
			
    		var newpassword = $.trim($("#newpassword").val());
			if (newpassword == null || newpassword == "") {
				$.HN.message.alert("<spring:message code='message.HN.noPWD'/>", "", "warn");
				return;
			}
			if(!(parn.test(newpassword))){
				 $.HN.message.alert("<spring:message code='message.lable.PWDhint'/>", "", "warn");
		         return ;
			}
			var passwordRepeat = $.trim($("#passwordRepeat").val());
			if (passwordRepeat == null || passwordRepeat == "") {
				$.HN.message.alert("<spring:message code='message.HN.noConfirmPWD'/>", "", "warn");
				return;
			}
			
			if (newpassword != passwordRepeat) {
				$.HN.message.alert("<spring:message code='message.HN.notSamePWD'/>", "", "warn");
				return;
			} 

	    	  $.HN.message.confirm("<spring:message code='message.HN.alert.queDingTiJiaoMa'/>", '', '').on(function (e) {
	              if (e) {
	            		$.post("${ctx}/sysUser/updateSysUserPassword.html", {
	            			"userId" : "${userId}",
	            			"userPassword" : newpassword,
	            			"oldPassword" : oldpassword
	            		}, function(result) {
	            			$("#form")[0].reset();
	            			if (result.success) {
	            				$.HN.message.alert("密码重置成功", "", "success");
	            				location.href = "${ctx}/home.html";
	            			} else {
	            				$.HN.message.alert(result.msg 
	            						|| "<spring:message code='message.HN.alert.fail'/>", "", "error");
	            			}
	            		}, "json");
	    		}
	       	  });
    	}
    
    </script>
    
</body>
</html>
