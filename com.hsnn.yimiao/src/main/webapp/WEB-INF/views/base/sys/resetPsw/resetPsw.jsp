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
    <h1>密码找回</h1>
    </section>
    <section class="content">
        <div class=" box box-success ">
            <form id="form" class="form-horizontal" action="changePassword.html" method="post">
                <input type="password" name="password1"  style="display:none"/>
                <div class="box-body" style="background:url(${ctx}/lib/img/checkpassword.png);background-repeat: no-repeat;background-position: 115px 65px ">
                    <div class="form-group form-group-xs" style="margin-left:200px">
                        <label for="newpassword" class="col-sm-2 text-right"><spring:message code='message.lable.newPWD'/><spring:message code="message.yanZheng.maoHao"/></label>
                        <div class="col-sm-5 text-left">
                            <input class="form-control" id="newpassword" name="newpassword" placeholder="<spring:message code='message.lable.newPWD'/>" autocomplete="off" type="password" maxlength="127">
                        </div>
                    </div>
                    
                    <div class="form-group form-group-xs" style="margin-left:200px">
                        <label for="passwordRepeat" class="col-sm-2 text-right"><spring:message code='message.lable.confirmPWD'/><spring:message code="message.yanZheng.maoHao"/></label>
                        <div class="col-sm-5 text-left">
                            <input class="form-control" id="passwordRepeat" name="passwordRepeat" placeholder="<spring:message code='message.lable.confirmPWD'/>" autocomplete="off" type="password" maxlength="127">
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
                    <button type="button" class="btn btn-success btn-sm" onclick="submitPassword();"><spring:message code="message.button.saveSpacing"/></button>
                </div>
            </form>
        </div>
    </section>
    <%@ include file="/WEB-INF/component/commonJS.jsp" %>
    <script type="text/javascript">
    	function submitPassword() {
		    var parn =new RegExp("[0-9 | A-Z | a-z]{6,}");
			
    		var newpassword = $.trim($("#newpassword").val());
			if (newpassword == null || newpassword == "") {
				$.HN.message.alert("<spring:message code='message.HN.noPWD'/>", "", "warn");
				return;
			}
			if(newpassword.length < 6){
				$.HN.message.alert("密码长度至少6位<spring:message code="message.yanZheng.ganTanHao"/>", "", "warn");
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
	            		$.post("${ctx}/resetPsw/resetLink.html", {
	            			"userId" : "${userId}",
	            			"newpassword" : newpassword
	            		}, function(result) {
	            			$("#form")[0].reset();
	            			if (result.success) {
	            				$.HN.message.alert("密码重置成功", "", "success");
	            				  setTimeout(function(){ location.href = "${ctx}";}, 1000) ; 
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
