<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<style type="text/css">
	.content {
		min-height: 0px;
	}
</style>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-success">
	    	<div class="box-body">
		        <form role="form" id="addForm" class="form-horizontal" action="${ctx }/drugpurRefuseResponseReason/addDrugpurRefuseResponseReason.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
			                            <label class="control-label "><spring:message code="drugpurRefuseResponseReason.refuseReason"/>：</label>
			                        </th>
			                        <td colspan="3">
			                        	<textarea rows="5" id="refuseReason" name="refuseReason" maxlength="320" style="width: 100%;" placeholder="<spring:message code="drugpurRefuseResponseReason.refuseReason"/>">${drugpurRefuseResponseReasonForm.refuseReason}</textarea>
			                        </td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- form end -->
					<div class="box-footer text-center">
	                    <button type="button" onclick="save();" class="btn btn-success btn-sm"><spring:message code="message.button.save"/></button>
	                    <button type="button" onclick="back();" class="btn btn-primary btn-sm"><spring:message code="message.button.getBack"/></button>
	                </div>
				</form>
	    	</div>
		</div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	$(function () {
		
	}); 
	// 保存
	function save() {
		var refuseReason = $("#refuseReason").val();
		if(refuseReason) {
			$.HN.message.confirm('<spring:message code="message.HN.alert.queDingYaoBaoCunMa"/>', '', '').on(function (e) {
				if (e) {
					$("#addForm").ajaxSubmit({
						dataType : "json",
	             		timeout: 10000,
	               		success: function(result, statusText) {
	                   		if(result.success){
	           	     			$.alert('<spring:message code="message.HN.alert.baoCunCheng"/>', "success", function() {
	           	     				closeMyDialog(result.success);
								});
	                   		}else{
	                   			$.alert(result.msg || "<spring:message code='message.HN.alert.baoCunBai'/>", "error");
	                   		}
						}
					});
				}
			});
		} else {
			$.alert('<spring:message code="message.yanZheng.qingShuRu"/><spring:message code="drugpurRefuseResponseReason.refuseReason"/>');
		}
	}
	
	function closeMyDialog(rowdata) {
		var dialog = top.dialog.get(window);
		dialog.close(rowdata);
		$("#addForm")[0].reset();
	    return false;
	} 
	// 返回
	function back() {
		closeMyDialog(true);
	}
</script>
</html>