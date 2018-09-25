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
		        <form role="form" id="addForm" class="form-horizontal" action="${ctx }/drugpurDistributeLogistics/maintainDistributeLogistics.html" method="post">
		        	<input type="hidden" name="distributeId" id="distributeId" value="${drugpurDistributeLogisticsForm.distributeId }" />
		        	<input type="hidden" name="twoDimensionCode" id="twoDimensionCode" value="${drugpurDistributeLogisticsForm.distributeId }" />
		        	<input type="hidden" name="optionType" id="optionType" value="${optionType }" />
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
			                            <label class="control-label "><spring:message code="drugpurDistributeLogistics.sendTime"/>：</label>
			                        </th>
			                        <td colspan="3">
			                        	<input type="text" class="textinput" name="sendTime" id="sendTime" placeholder="<spring:message code='drugpurDistributeLogistics.sendTime'/>"
			                        		onFocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'arriveTime\')}'})"
			                        		value='<fmt:formatDate value="${drugpurDistributeLogisticsForm.sendTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' />
			                        	
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
			                            <label class="control-label "><spring:message code="drugpurDistributeLogistics.logisticsInformation"/>：</label>
			                        </th>
			                        <td colspan="3">
			                        	<textarea rows="5" id="logisticsInformation" name="logisticsInformation" maxlength="320" style="width: 100%;" placeholder="<spring:message code="drugpurDistributeLogistics.logisticsInformation"/>">${drugpurDistributeLogisticsForm.logisticsInformation}</textarea>
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
			                            <label class="control-label "><spring:message code="drugpurDistributeLogistics.arriveTime"/>：</label>
			                        </th>
			                        <td colspan="3">
			                        	<input type="text" class="textinput" name="arriveTime" id="arriveTime" placeholder="<spring:message code='drugpurDistributeLogistics.arriveTime'/>"
			                        		onFocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'sendTime\')}'})"
			                        		value='<fmt:formatDate value="${drugpurDistributeLogisticsForm.arriveTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' />
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
			                            <label class="control-label "><spring:message code="drugpurDistributeLogistics.twoDimensionCode"/>：</label>
			                        </th>
			                        <td style="text-align: center;" colspan="3" id="showCode"></td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- form end -->
					<div class="box-footer text-center">
	                    <ms:btn url="/drugpurDistributeLogistics/maintainDistributeLogistics.html"><button type="button" onclick="save();" class="btn btn-success btn-sm"><spring:message code="message.button.maintain"/></button></ms:btn>
	                    <button type="button" onclick="back();" class="btn btn-primary btn-sm"><spring:message code="message.button.getBack"/></button>
	                </div>
				</form>
	    	</div>
		</div>
	</section>
	<!-- 页面备注信息 -->
	<div class="pagetip" style="text-align: left;">
		<h4>物流信息建议格式为:</h4>
		<div>2016-05-12 10:01 到达杭州市</div>
		<div>2016-05-12 10:20 到达余杭区</div>
		<div>2016-05-12 11:40 到达余杭区.莫干山路</div>
	</div>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script src="${ctx }/lib/js/validate/jquery.validate.js"></script>
<script src="${ctx }/lib/js/validate.expand.js?v=2"></script>
<script src="${ctx }/lib/js/jquery.qrcode.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#addForm").validate(${validate});
		$("#showCode").qrcode({ 
			//render: "canvas", //设置渲染方式 table canvas
		    width: 200, //宽度 
		    height:200, //高度 
		    text: '${drugpurDistributeLogisticsForm.distributeId }' //任意内容 
		}); 
	}); 
	
	// 保存
	function save() {
		if($('#addForm').valid()) {
			$.HN.message.confirm('<spring:message code="message.button.confirm"/><spring:message code="message.button.maintain"/><spring:message code="message.lable.ma"/>', '', '').on(function (e) {
				if (e) {
					$("#addForm").ajaxSubmit({
						dataType : "json",
	             		timeout: 10000,
	               		success: function(result, statusText) {
	                   		if(result.success){
	           	     			$.alert('<spring:message code="message.button.maintain"/><spring:message code="message.HN.alert.chengGong"/><spring:message code="message.yanZheng.ganTanHao"/>', "success", function() {
	           	     				closeMyDialog(result.success);
								});
	                   		}else{
	                   			$.alert(result.msg || "<spring:message code='message.button.maintain'/><spring:message code='message.HN.alert.shibai'/><spring:message code="message.yanZheng.ganTanHao"/>", "error");
	                   		}
						}
					});
				}
			});
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