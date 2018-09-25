
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
     <title>密码修改</title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
    <!--[if lt IE 9]>
        <script src="${ctx}/lib/js/html5shiv.min.js"></script>
        <script src="${ctx}/lib/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
    <section class="content-header">
        <h1>
           	 请重新设置密码
            <!--<small>Control panel</small>-->
        </h1>
    </section>
    <section class="content">
    	<form id ="changePassword" action ="expertPasswordChange.html">
            <input display="none"/>
            <label>请输入旧密码：</label>
            <input type="password" id="oldPassword" name="oldPassword" maxlength="120" autocomplete="off"/><br>
            <label>请输入新密码：</label>
            <input type="password" id="newPassword" name="newPassword" maxlength="120" autocomplete="off"/><br>
            <label>请确认新密码：</label>
            <input type="password" id="comfirmPassword" name="comfirmPassword" maxlength="120" autocomplete="off"><br>
            <a href="javascript:save();" class="btn btn-default btn-sm">修&nbsp;&nbsp;改</a>
       	</form>
    </section>
  <%@ include file="/WEB-INF/component/commonJS.jsp"%>
   <script type="text/javascript">
       function save(){
    	   if(!validate()){
    		   return;
    	   } 
    	   var username = $("#username").val();
    	   var oldPassword = $("#oldPassword").val();
    	   var newPassword = $("#newPassword").val();
    	   $.HN.message.confirm('确定要保存吗？', '', '').on(function (e) {
               if (e) {
		    	   $.ajax({
						type : "POST",
						dataType:"json",
						url : "expertPasswordChange.html",
						data : {
				   			"username" : username,
				   			"oldPassword":oldPassword,
				   			"newPassword":newPassword
				   		},
						success : function(result) {
							if(result.success){
			   					var curpage = $("#gridlist").jqGrid('getGridParam', 'page');
			   					$.HN.message.confirm('密码修改成功，须重新登录', '', '确定').on(function (e) {
				   					 if (e) {
				   						document.location.href="toExpertLogout.html";
				   					 }
			   					})
							}else{
								$.HN.message.alert(result.msg, "消息", "error");
							}
						},
					});
               }
    	   });
       }
       function validate(){
    	   var oldPassword =$.trim($("#oldPassword").val());
    	   var newPassword= $("#newPassword").val();
    	   var comfirmPassword = $("#comfirmPassword").val();
    	   
    	   if (oldPassword == null || oldPassword == "") {
   			$.HN.message.alert("请输入原密码！", "消息", "warn");
   			  return false;
   		   }
			
			if (newPassword == null || newPassword == "") {
				$.HN.message.alert("请输入新密码！", "消息", "warn");
				return false;
			}
			/* if(newPassword.length < 6){
				$.HN.message.alert("密码长度为6-20位！", "消息", "warn");
				return false;
			} */
			if (comfirmPassword == null || comfirmPassword == "") {
				$.HN.message.alert("请输入确认密码！", "消息", "warn");
				return false;
			}	
			
			if (newPassword != comfirmPassword) {
				$.HN.message.alert("输入新密码和确认密码不一致！", "消息", "warn");
				return false;
			} 
			return true;
       }
    </script>
</body>
</html>
