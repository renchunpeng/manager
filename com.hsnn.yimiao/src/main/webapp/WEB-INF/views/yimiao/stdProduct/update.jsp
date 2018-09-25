<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="一级目录表更新-待修改"/></title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="一级目录表更新-待修改"/></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#"><spring:message code="一级目录表管理-待修改"/></a></li>
			<li class="active"><a href="#"><spring:message code="一级目录表更新-待修改"/></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">     
				<form role="form" id="updateForm" class="form-horizontal" action="updateStdProduct.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
										<!-- 一级目录id -->
			                            <label class="control-label "><spring:message code="stdProduct.productId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productId" name="productId"
	                            			value="${stdProductForm.productId}" placeholder="<spring:message code="stdProduct.productId"/>" type="text">
			                        </td>
									<th>
										<!-- 一级目录名称 -->
			                            <label class="control-label "><spring:message code="stdProduct.productName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productName" name="productName"
	                            			value="${stdProductForm.productName}" placeholder="<spring:message code="stdProduct.productName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- productSpelName -->
			                            <label class="control-label "><spring:message code="stdProduct.productSpelName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productSpelName" name="productSpelName"
	                            			value="${stdProductForm.productSpelName}" placeholder="<spring:message code="stdProduct.productSpelName"/>" type="text">
			                        </td>
									<th>
										<!-- productWbName -->
			                            <label class="control-label "><spring:message code="stdProduct.productWbName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productWbName" name="productWbName"
	                            			value="${stdProductForm.productWbName}" placeholder="<spring:message code="stdProduct.productWbName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- medicinemodel -->
			                            <label class="control-label "><spring:message code="stdProduct.medicinemodel"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="medicinemodel" name="medicinemodel"
	                            			value="${stdProductForm.medicinemodel}" placeholder="<spring:message code="stdProduct.medicinemodel"/>" type="text">
			                        </td>
									<th>
										<!-- medicinemodelSpel -->
			                            <label class="control-label "><spring:message code="stdProduct.medicinemodelSpel"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="medicinemodelSpel" name="medicinemodelSpel"
	                            			value="${stdProductForm.medicinemodelSpel}" placeholder="<spring:message code="stdProduct.medicinemodelSpel"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- outlook -->
			                            <label class="control-label "><spring:message code="stdProduct.outlook"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="outlook" name="outlook"
	                            			value="${stdProductForm.outlook}" placeholder="<spring:message code="stdProduct.outlook"/>" type="text">
			                        </td>
									<th>
										<!-- factor -->
			                            <label class="control-label "><spring:message code="stdProduct.factor"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="factor" name="factor"
	                            			value="${stdProductForm.factor}" placeholder="<spring:message code="stdProduct.factor"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- levelDay -->
			                            <label class="control-label "><spring:message code="stdProduct.levelDay"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="levelDay" name="levelDay"
	                            			value="${stdProductForm.levelDay}" placeholder="<spring:message code="stdProduct.levelDay"/>" type="text">
			                        </td>
									<th>
										<!-- remark -->
			                            <label class="control-label "><spring:message code="stdProduct.remark"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="remark" name="remark"
	                            			value="${stdProductForm.remark}" placeholder="<spring:message code="stdProduct.remark"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- status -->
			                            <label class="control-label "><spring:message code="stdProduct.status"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="status" name="status"
	                            			value="${stdProductForm.status}" placeholder="<spring:message code="stdProduct.status"/>" type="text">
			                        </td>
									<th>
										<!-- auditUserName -->
			                            <label class="control-label "><spring:message code="stdProduct.auditUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditUserName" name="auditUserName"
	                            			value="${stdProductForm.auditUserName}" placeholder="<spring:message code="stdProduct.auditUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- auditRemark -->
			                            <label class="control-label "><spring:message code="stdProduct.auditRemark"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditRemark" name="auditRemark"
	                            			value="${stdProductForm.auditRemark}" placeholder="<spring:message code="stdProduct.auditRemark"/>" type="text">
			                        </td>
									<th>
										<!-- auditTime -->
			                            <label class="control-label "><spring:message code="stdProduct.auditTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditTime" name="auditTime"
	                            			value="${stdProductForm.auditTime}" placeholder="<spring:message code="stdProduct.auditTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- isUsing -->
			                            <label class="control-label "><spring:message code="stdProduct.isUsing"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isUsing" name="isUsing"
	                            			value="${stdProductForm.isUsing}" placeholder="<spring:message code="stdProduct.isUsing"/>" type="text">
			                        </td>
									<th>
										<!-- addUserId -->
			                            <label class="control-label "><spring:message code="stdProduct.addUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserId" name="addUserId"
	                            			value="${stdProductForm.addUserId}" placeholder="<spring:message code="stdProduct.addUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- addUserName -->
			                            <label class="control-label "><spring:message code="stdProduct.addUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserName" name="addUserName"
	                            			value="${stdProductForm.addUserName}" placeholder="<spring:message code="stdProduct.addUserName"/>" type="text">
			                        </td>
									<th>
										<!-- addTime -->
			                            <label class="control-label "><spring:message code="stdProduct.addTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addTime" name="addTime"
	                            			value="${stdProductForm.addTime}" placeholder="<spring:message code="stdProduct.addTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- lastUpdateUserId -->
			                            <label class="control-label "><spring:message code="stdProduct.lastUpdateUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserId" name="lastUpdateUserId"
	                            			value="${stdProductForm.lastUpdateUserId}" placeholder="<spring:message code="stdProduct.lastUpdateUserId"/>" type="text">
			                        </td>
									<th>
										<!-- lastUpdateUserName -->
			                            <label class="control-label "><spring:message code="stdProduct.lastUpdateUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserName" name="lastUpdateUserName"
	                            			value="${stdProductForm.lastUpdateUserName}" placeholder="<spring:message code="stdProduct.lastUpdateUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- lastUpdateTime -->
			                            <label class="control-label "><spring:message code="stdProduct.lastUpdateTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateTime" name="lastUpdateTime"
	                            			value="${stdProductForm.lastUpdateTime}" placeholder="<spring:message code="stdProduct.lastUpdateTime"/>" type="text">
			                        </td>
									<th>
										<!-- 药品分类 -->
			                            <label class="control-label "><spring:message code="stdProduct.drugClassification"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="drugClassification" name="drugClassification"
	                            			value="${stdProductForm.drugClassification}" placeholder="<spring:message code="stdProduct.drugClassification"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 主成分 -->
			                            <label class="control-label "><spring:message code="stdProduct.component"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="component" name="component"
	                            			value="${stdProductForm.component}" placeholder="<spring:message code="stdProduct.component"/>" type="text">
			                        </td>
									<th>
										<!-- 药品类别 -->
			                            <label class="control-label "><spring:message code="stdProduct.drugCategory"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="drugCategory" name="drugCategory"
	                            			value="${stdProductForm.drugCategory}" placeholder="<spring:message code="stdProduct.drugCategory"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- productCode -->
			                            <label class="control-label "><spring:message code="stdProduct.productCode"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productCode" name="productCode"
	                            			value="${stdProductForm.productCode}" placeholder="<spring:message code="stdProduct.productCode"/>" type="text">
			                        </td>
									<th>
										<!-- sortId -->
			                            <label class="control-label "><spring:message code="stdProduct.sortId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sortId" name="sortId"
	                            			value="${stdProductForm.sortId}" placeholder="<spring:message code="stdProduct.sortId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- sortName -->
			                            <label class="control-label "><spring:message code="stdProduct.sortName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sortName" name="sortName"
	                            			value="${stdProductForm.sortName}" placeholder="<spring:message code="stdProduct.sortName"/>" type="text">
			                        </td>
									<th>
										<!-- belongAreaId -->
			                            <label class="control-label "><spring:message code="stdProduct.belongAreaId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="belongAreaId" name="belongAreaId"
	                            			value="${stdProductForm.belongAreaId}" placeholder="<spring:message code="stdProduct.belongAreaId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- belongAreaName -->
			                            <label class="control-label "><spring:message code="stdProduct.belongAreaName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="belongAreaName" name="belongAreaName"
	                            			value="${stdProductForm.belongAreaName}" placeholder="<spring:message code="stdProduct.belongAreaName"/>" type="text">
			                        </td>
									<th>
										<!-- productNameFirst -->
			                            <label class="control-label "><spring:message code="stdProduct.productNameFirst"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productNameFirst" name="productNameFirst"
	                            			value="${stdProductForm.productNameFirst}" placeholder="<spring:message code="stdProduct.productNameFirst"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- productNameSecond -->
			                            <label class="control-label "><spring:message code="stdProduct.productNameSecond"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productNameSecond" name="productNameSecond"
	                            			value="${stdProductForm.productNameSecond}" placeholder="<spring:message code="stdProduct.productNameSecond"/>" type="text">
			                        </td>
									<th>
										<!-- submitState -->
			                            <label class="control-label "><spring:message code="stdProduct.submitState"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitState" name="submitState"
	                            			value="${stdProductForm.submitState}" placeholder="<spring:message code="stdProduct.submitState"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- submitUserId -->
			                            <label class="control-label "><spring:message code="stdProduct.submitUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitUserId" name="submitUserId"
	                            			value="${stdProductForm.submitUserId}" placeholder="<spring:message code="stdProduct.submitUserId"/>" type="text">
			                        </td>
									<th>
										<!-- submitUserName -->
			                            <label class="control-label "><spring:message code="stdProduct.submitUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitUserName" name="submitUserName"
	                            			value="${stdProductForm.submitUserName}" placeholder="<spring:message code="stdProduct.submitUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- submitTime -->
			                            <label class="control-label "><spring:message code="stdProduct.submitTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitTime" name="submitTime"
	                            			value="${stdProductForm.submitTime}" placeholder="<spring:message code="stdProduct.submitTime"/>" type="text">
			                        </td>
									<th>
										<!-- auditState -->
			                            <label class="control-label "><spring:message code="stdProduct.auditState"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditState" name="auditState"
	                            			value="${stdProductForm.auditState}" placeholder="<spring:message code="stdProduct.auditState"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- auditorUserId -->
			                            <label class="control-label "><spring:message code="stdProduct.auditorUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditorUserId" name="auditorUserId"
	                            			value="${stdProductForm.auditorUserId}" placeholder="<spring:message code="stdProduct.auditorUserId"/>" type="text">
			                        </td>
									<th>
										<!-- auditor -->
			                            <label class="control-label "><spring:message code="stdProduct.auditor"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditor" name="auditor"
	                            			value="${stdProductForm.auditor}" placeholder="<spring:message code="stdProduct.auditor"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- isCanAddGoods -->
			                            <label class="control-label "><spring:message code="stdProduct.isCanAddGoods"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isCanAddGoods" name="isCanAddGoods"
	                            			value="${stdProductForm.isCanAddGoods}" placeholder="<spring:message code="stdProduct.isCanAddGoods"/>" type="text">
			                        </td>
									<th>
										<!-- oldProductId -->
			                            <label class="control-label "><spring:message code="stdProduct.oldProductId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="oldProductId" name="oldProductId"
	                            			value="${stdProductForm.oldProductId}" placeholder="<spring:message code="stdProduct.oldProductId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- oldSortId -->
			                            <label class="control-label "><spring:message code="stdProduct.oldSortId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="oldSortId" name="oldSortId"
	                            			value="${stdProductForm.oldSortId}" placeholder="<spring:message code="stdProduct.oldSortId"/>" type="text">
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
           	     				document.location.href="${ctx }/stdProduct/toList.html";
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
		document.location.href="${ctx }/stdProduct/toList.html";
	}
</script>
</html>