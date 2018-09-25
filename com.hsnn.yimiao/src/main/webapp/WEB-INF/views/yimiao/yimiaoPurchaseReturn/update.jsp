<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
		
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">     
				<form role="form" id="updateForm" class="form-horizontal" action="updateYimiaoPurchaseReturn.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
										<!-- order_id（有序guid编号） -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.retOrderId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="retOrderId" name="retOrderId"
	                            			value="${yimiaoPurchaseReturnForm.retOrderId}" placeholder="<spring:message code="yimiaoPurchaseReturn.retOrderId"/>" type="text">
			                        </td>
									<th>
										<!-- 医疗机构编号 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.hospitalId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalId" name="hospitalId"
	                            			value="${yimiaoPurchaseReturnForm.hospitalId}" placeholder="<spring:message code="yimiaoPurchaseReturn.hospitalId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 医疗机构名称 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.hospitalName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalName" name="hospitalName"
	                            			value="${yimiaoPurchaseReturnForm.hospitalName}" placeholder="<spring:message code="yimiaoPurchaseReturn.hospitalName"/>" type="text">
			                        </td>
									<th>
										<!-- 医疗机构部门编号 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.hospitalDepartmentId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalDepartmentId" name="hospitalDepartmentId"
	                            			value="${yimiaoPurchaseReturnForm.hospitalDepartmentId}" placeholder="<spring:message code="yimiaoPurchaseReturn.hospitalDepartmentId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 医疗机构部门名称 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.hospitalDepartmentName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalDepartmentName" name="hospitalDepartmentName"
	                            			value="${yimiaoPurchaseReturnForm.hospitalDepartmentName}" placeholder="<spring:message code="yimiaoPurchaseReturn.hospitalDepartmentName"/>" type="text">
			                        </td>
									<th>
										<!-- 订单类型（0：正常订单，1：急救药品临时订单） -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.orderType"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderType" name="orderType"
	                            			value="${yimiaoPurchaseReturnForm.orderType}" placeholder="<spring:message code="yimiaoPurchaseReturn.orderType"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 订单名称 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.orderName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderName" name="orderName"
	                            			value="${yimiaoPurchaseReturnForm.orderName}" placeholder="<spring:message code="yimiaoPurchaseReturn.orderName"/>" type="text">
			                        </td>
									<th>
										<!-- 订单金额 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.orderAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderAmount" name="orderAmount"
	                            			value="${yimiaoPurchaseReturnForm.orderAmount}" placeholder="<spring:message code="yimiaoPurchaseReturn.orderAmount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 订单备注 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.orderRamarks"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderRamarks" name="orderRamarks"
	                            			value="${yimiaoPurchaseReturnForm.orderRamarks}" placeholder="<spring:message code="yimiaoPurchaseReturn.orderRamarks"/>" type="text">
			                        </td>
									<th>
										<!-- 提交时间 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.submitTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitTime" name="submitTime"
	                            			value="${yimiaoPurchaseReturnForm.submitTime}" placeholder="<spring:message code="yimiaoPurchaseReturn.submitTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 提交人 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.subminter"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="subminter" name="subminter"
	                            			value="${yimiaoPurchaseReturnForm.subminter}" placeholder="<spring:message code="yimiaoPurchaseReturn.subminter"/>" type="text">
			                        </td>
									<th>
										<!-- 是否自动提交 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.isAutoSubmint"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isAutoSubmint" name="isAutoSubmint"
	                            			value="${yimiaoPurchaseReturnForm.isAutoSubmint}" placeholder="<spring:message code="yimiaoPurchaseReturn.isAutoSubmint"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 自动提交时间 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.autoSubmitTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="autoSubmitTime" name="autoSubmitTime"
	                            			value="${yimiaoPurchaseReturnForm.autoSubmitTime}" placeholder="<spring:message code="yimiaoPurchaseReturn.autoSubmitTime"/>" type="text">
			                        </td>
									<th>
										<!-- 完成进度(0:待提交,1:已提交) -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.orderState"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderState" name="orderState"
	                            			value="${yimiaoPurchaseReturnForm.orderState}" placeholder="<spring:message code="yimiaoPurchaseReturn.orderState"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- defaultDistributeAddr -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.defaultDistributeAddr"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="defaultDistributeAddr" name="defaultDistributeAddr"
	                            			value="${yimiaoPurchaseReturnForm.defaultDistributeAddr}" placeholder="<spring:message code="yimiaoPurchaseReturn.defaultDistributeAddr"/>" type="text">
			                        </td>
									<th>
										<!-- 记录添加人id -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.addUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserId" name="addUserId"
	                            			value="${yimiaoPurchaseReturnForm.addUserId}" placeholder="<spring:message code="yimiaoPurchaseReturn.addUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 记录添加人 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.addUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserName" name="addUserName"
	                            			value="${yimiaoPurchaseReturnForm.addUserName}" placeholder="<spring:message code="yimiaoPurchaseReturn.addUserName"/>" type="text">
			                        </td>
									<th>
										<!-- 记录添加时间 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.addTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addTime" name="addTime"
	                            			value="${yimiaoPurchaseReturnForm.addTime}" placeholder="<spring:message code="yimiaoPurchaseReturn.addTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 最后一次更新记录人id -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.lastUpdateUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserId" name="lastUpdateUserId"
	                            			value="${yimiaoPurchaseReturnForm.lastUpdateUserId}" placeholder="<spring:message code="yimiaoPurchaseReturn.lastUpdateUserId"/>" type="text">
			                        </td>
									<th>
										<!-- 最后一次更新记录人 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.lastUpdateUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserName" name="lastUpdateUserName"
	                            			value="${yimiaoPurchaseReturnForm.lastUpdateUserName}" placeholder="<spring:message code="yimiaoPurchaseReturn.lastUpdateUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 最后一次更新记录时间 -->
			                            <label class="control-label "><spring:message code="yimiaoPurchaseReturn.lastUpdateTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateTime" name="lastUpdateTime"
	                            			value="${yimiaoPurchaseReturnForm.lastUpdateTime}" placeholder="<spring:message code="yimiaoPurchaseReturn.lastUpdateTime"/>" type="text">
			                        </td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- form end -->
					<div class="null-line"></div>
					<div class="modal-footer">
	                    <button type="button" onclick="save();" class="btn btn-success btn-sm"><spring:message code="message.button.save"/></button>
	                    <button type="button" onclick="back();" class="btn btn-danger btn-sm"><spring:message code="message.button.getBack"/></button>
	                </div>
				</form>
			</div>
		</div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script src="${ctx }/lib/js/validate/jquery.validate.js"></script>
<script src="${ctx }/lib/js/validate.expand.js"></script>
<script type="text/javascript">
	$(function(){
		init();//页面加载完毕了，做点什么呢？
	})
	
	function init() {
		$("#updateForm").validate(${validate});
	}
	
	function save() {
		if(!$('#updateForm').valid()) {
			return;
		}
		$.HN.message.confirm('确定要保存吗？', '', '').on(function (e) {
			if (e) {
				$("#updateForm").ajaxSubmit({
					dataType : "json",
             		timeout: 10000,
               		success: function(result,statusText) {
                   		if(result.success){
           	     			$.alert("添加成功！", "success", function() {
           	     				document.location.href="${ctx }/yimiaoPurchaseReturn/toList.html";
							});
                   		}else{
                   			$.alert(result.msg || "<spring:message code="message.HN.alert.baoCunBai"/>", "error");
                   		}
					}
				});
			}
		});
	}
	
	function back() {
		document.location.href="${ctx }/yimiaoPurchaseReturn/toList.html";
	}
</script>
</html>