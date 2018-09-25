<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<style>
	html body.skin-blue.sidebar-mini.fixed.skin-blue-light-frame{
		background: #fff;

	}
	html body.skin-blue.sidebar-mini.fixed.skin-blue-light-frame div.container{
		position:relative;
		height:200px;
		top:-70px;
		width:200px;
		margin-left: 160px;

	}
</style>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
<div class="container" style="margin-top:100px;width:250%;">
	<form class="form-horizontal" id="updateForm" action="submitUpdate.html" role="form" >
		<input id="userId" name="userId" value="${userId}" hidden>
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">用户名称</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" disabled="disabled" style="width:250px;" id="userName" name="userName" value="${userName}">
			</div>
		</div>
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">账号名称</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" disabled="disabled" style="width:250px;" id="name" name="name" value="${name}">
			</div>
		</div>

		<div class="form-group">
			<label for="userPassword" class="col-sm-2 control-label">新密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" style="width:250px;" id="userPassword" name="userPassword" placeholder="请输入密码">
			</div>
		</div>
		<div class="form-group">
			<label for="newUserPassword" class="col-sm-2 control-label">再次确认新密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" style="width:250px;" id="newUserPassword" name="newUserPassword" placeholder="请再次输入密码">
			</div>
		</div>

	</form>
</div>
</body>
<div class="modal-footer" style="padding-top: 5px;padding-bottom: 5px;">
	<button type="submit" class="btn btn-primary" onclick="submitUpdate()" id="submit" style="text-align:center;">确认修改</button>
	<button type="button" class="btn btn-danger"  style="text-align:center;" onclick="closeDialog();">关闭弹窗</button>
</div>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">


    function closeDialog() {
        var dialog = top.dialog.get(window);
        dialog.remove(); // 主动销毁对话框
    }
    function afferCloseDialog() {
        var dialog = top.dialog.get(window);
        dialog.close();
        dialog.remove(); // 主动销毁对话框

    }

    function submitUpdate() {
        var userPassword = $(" input[ name='userPassword' ] ").val();
        var newUserPassword = $(" input[ name='newUserPassword' ] ").val();
        if(userPassword == "" || userPassword == null){
        	$.alert("请输入新密码！","error");
        	return;
        }
        if(newUserPassword == "" || newUserPassword == null){
        	$.alert("请再次确认新密码！","error");
        	return;
        }
        if(userPassword!=newUserPassword){
            $.alert("两次输入的密码不一致!", "error");
            return;
		}
        $.HN.message.confirm('确定修改吗？', '', '').on(function (e) {
            if (e) {
                    $("#updateForm").ajaxSubmit({
                        dataType : "json",
                        timeout: 10000,
                        success: function(result,statusText) {
                            if(result.success){
                                $.alert("密码修改成功！", "success", function() {
                                    closeDialog();
                                });
                            }else{
                                $.alert(result.msg || "<spring:message code="密码修改失败"/>", "error");
                            }
                        }
                    });
            }
        });
    }
</script>
</html>