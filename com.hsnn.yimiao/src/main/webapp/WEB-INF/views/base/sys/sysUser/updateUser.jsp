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
    <h1>信息维护</h1>
        <ol class="breadcrumb">
            <li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
            <li class="active"><a href="#"><spring:message code="信息维护"/></a></li>
        </ol>
    </section>
    <section class="content">
        <div class=" box box-success ">
            <form id="updateForm" role="form"  class="form-horizontal" action="changeUser.html" method="post">
                <!-- <div class="box-body" style="background:url(${ctx}/lib/img/checkpassword.png);background-repeat: no-repeat;background-position: 115px 65px "> -->
                    <div class="form-group form-group-xs" style="margin-left:200px">
                        <label for="userName" class="col-sm-2 text-right"><spring:message code='用户账号'/><spring:message code="message.yanZheng.maoHao"/></label>
                        <div class="col-sm-5 text-left">
                            <label> ${sysUserForm.userName}</label>
                        </div>
                    </div>
                    
                    <div class="form-group form-group-xs" style="margin-left:200px">
                        <label for="name" class="col-sm-2 text-right"><spring:message code='账号名称'/><spring:message code="message.yanZheng.maoHao"/></label>
                        <div class="col-sm-5 text-left">
                             <label>${sysUserForm.name}</label>
                        </div>
                    </div>
					
					<div class="form-group form-group-xs" style="margin-left:200px">
                       <label for="phone" class="col-sm-2 text-right"> <label style="color:red;position:relative;top:2px;left:-2px;">*</label><spring:message code='手机号码'/><spring:message code="message.yanZheng.maoHao"/></label>
                        <div class="col-sm-5 text-left">
                            <input class="form-control" id="phone" name="phone"  type="text" value="${sysUserForm.phone}" maxlength="127">
                        </div>
                    </div>

                    <div class="form-group form-group-xs" style="margin-left:200px">
                        <label for="email" class="col-sm-2 text-right"><label style="color:red;position:relative;top:2px;left:-2px;">*</label><spring:message code='邮箱'/><spring:message code="message.yanZheng.maoHao"/></label>
                        <div class="col-sm-5 text-left">
                            <input class="form-control" id="email" name="email"  type="text" value="${sysUserForm.email}" maxlength="127">
                        </div>
                    </div>
               		<!-- <div>
               			<label style="color:red;position:relative;left:422px;">注意:红色为必填项</label>
               		</div> -->
              
					<div  class="box-footer text-center">
	                    <button type="button" onclick="save();"  class="btn btn-success btn-sm"><spring:message code="message.button.save"/></button>
	                  
	                </div>
            </form>
        </div>
    </section>
    <%@ include file="/WEB-INF/component/commonJS.jsp" %>
    <script type="text/javascript">
    	

    	function save() {
    		
    		//手机号正则
    		var phoneReg = /^0?(13[0-9]|15[012356789]|18[0-9]|17[0-9])[0-9]{8}$/;
    		//邮箱正则
    		var emailReg = new RegExp("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");

    		var phone = $.trim($("#phone").val());
    		var email = $.trim($("#email").val());

    		if(phone == null|| phone ==""){
    			$.HN.message.alert("手机号码不能为空", "", "warn");
				return;
    		}

    		if(email == null|| email ==""){
    			$.HN.message.alert("邮箱不能为空", "", "warn");
				return;
    		}

    		if(!(phoneReg.test(phone))){
    			$.HN.message.alert("手机号码格式不正确", "", "warn");
				return;
    		}

    		if(!(emailReg.test(email))){
    			$.HN.message.alert("邮箱格式不正确", "", "warn");
				return;
    		}

    		$.HN.message.confirm('确定要保存吗？', '', '').on(function (e) {


			if (e) {
				$("#updateForm").ajaxSubmit({
					dataType : "json",
             		timeout: 10000,
               		success: function(result,statusText) {
                   		if(result.success){
           	     			$.alert("保存成功！", "success", function() {
           	     				document.location.href="${ctx }/sysUser/toUpdateUser.html";
							});
                   		}else{
                   			$.alert(result.msg || "<spring:message code="message.HN.alert.baoCunBai"/>", "error");
                   		}
					}
				});
			}
		});
	    	 /* $.HN.message.confirm("确定要保存吗？", '', '').on(function (e) {
	              if (e) {
	            		$.post("${ctx}/sysUser/changeUser.html", {}, function(result) {
	            			$("#form")[0].reset();
	            			if (result.success) {
	            				$.HN.message.alert("保存成功", "", "success");
	            				  setTimeout(function(){ location.href = "${ctx}";}, 1000) ; 
	            			} else {
	            				$.HN.message.alert(result.msg || "保存失败", "", "error");
	            			}
	            		}, "json");
	    		}
	       	  });*/
    	}
    
    </script>
    
</body>
</html>
