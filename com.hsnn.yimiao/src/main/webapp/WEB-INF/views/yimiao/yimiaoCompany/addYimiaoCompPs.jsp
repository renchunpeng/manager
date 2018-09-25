<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<style type="text/css">
	div.divatab{
		width:100px;height:40px;float:left;border:2px solid #C6C9C9;border-radius:5px;text-align:center;line-height:35px;
		cursor:pointer;font-weight:900;
	}
	div.divchecked{
		background-color:#3C8DBC;color:#fff;
	}
	div.divnochecked{
		background-color:#E0E5ED;color:#777;
	}
</style>
<title>添加配送企业</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	
		
	<section class="content" style="padding-top:0;">
		<div class="input">
			<div class="textalign"><font color="red">*</font> 配送企业名称：</div>
			<div class="boxinput" style="width:85%;">
				<input type="text" class="textinput" id="companyNamePs" name="companyNamePs" placeholder="配送企业名称" maxlength="100" />
			</div>
		</div>
		<div class=" box box-warning bottongroup"	style="margin-top: 20px;">
			<button  type="button" id="save" class="btn btn-primary btn-sm" >保存</button>
		</div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
     /* 归档号	企业名称 企业类型 	录入人	资质状态	复核人	审核人	初始化状态 */

	$("#save").click(function(){
		var companyNamePs = $("#companyNamePs").val();

        if (typeof companyNamePs == "undefined" || companyNamePs == null || companyNamePs == "") {
            top.$.HN.message.alert("请填写配送企业名称！", "消息", "warn");
            return false;
        }
        $.HN.message.confirm('确定要保存吗？', '', '').on(function (e) {
            if(e){
                $.ajax({
                    url: "${ctx}/yimiaoCompany/addYimiaoCompanyPs.html",
                    type: "post",
                    dataType: "json",
                    data:{"yimiaoCompanyPs":companyNamePs},
                    success:function (result) {
                        if(result.success){
                            $.alert("添加成功！", "success", function() {
                                closeDialog();
                            });
                        }else{
                            $.alert(result.msg || "<spring:message code="message.HN.alert.baoCunBai"/>", "error");
                        }
                    }
                });
            }
        });
    });

     function closeDialog() {
         var dialog = top.dialog.get(window);
         dialog.close();
     }
</script>
</html>