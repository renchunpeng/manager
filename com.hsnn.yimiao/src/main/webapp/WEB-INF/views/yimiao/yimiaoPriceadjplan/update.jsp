<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="调价表更新-待修改"/></title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="调价表更新-待修改"/></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#"><spring:message code="调价表管理-待修改"/></a></li>
			<li class="active"><a href="#"><spring:message code="调价表更新-待修改"/></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">     
				<form role="form" id="updateForm" class="form-horizontal" action="updateYimiaoPriceadjplan.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
										<!-- 调价计划id -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.priceAdjPlanId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="priceAdjPlanId" name="priceAdjPlanId"
	                            			value="${yimiaoPriceadjplanForm.priceAdjPlanId}" placeholder="<spring:message code="yimiaoPriceadjplan.priceAdjPlanId"/>" type="text">
			                        </td>
									<th>
										<!-- 调价计划名称 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.priceAdjPlanName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="priceAdjPlanName" name="priceAdjPlanName"
	                            			value="${yimiaoPriceadjplanForm.priceAdjPlanName}" placeholder="<spring:message code="yimiaoPriceadjplan.priceAdjPlanName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 调价计划类型 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.priceAdjPlanCat"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="priceAdjPlanCat" name="priceAdjPlanCat"
	                            			value="${yimiaoPriceadjplanForm.priceAdjPlanCat}" placeholder="<spring:message code="yimiaoPriceadjplan.priceAdjPlanCat"/>" type="text">
			                        </td>
									<th>
										<!-- 执行类型：1立刻执行2定时执行 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.executeCat"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="executeCat" name="executeCat"
	                            			value="${yimiaoPriceadjplanForm.executeCat}" placeholder="<spring:message code="yimiaoPriceadjplan.executeCat"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 创建时间 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.createDatetime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="createDatetime" name="createDatetime"
	                            			value="${yimiaoPriceadjplanForm.createDatetime}" placeholder="<spring:message code="yimiaoPriceadjplan.createDatetime"/>" type="text">
			                        </td>
									<th>
										<!-- 创建人 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.createUser"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="createUser" name="createUser"
	                            			value="${yimiaoPriceadjplanForm.createUser}" placeholder="<spring:message code="yimiaoPriceadjplan.createUser"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- createOrgId -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.createOrgId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="createOrgId" name="createOrgId"
	                            			value="${yimiaoPriceadjplanForm.createOrgId}" placeholder="<spring:message code="yimiaoPriceadjplan.createOrgId"/>" type="text">
			                        </td>
									<th>
										<!-- 执行时间 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.executeDatetime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="executeDatetime" name="executeDatetime"
	                            			value="${yimiaoPriceadjplanForm.executeDatetime}" placeholder="<spring:message code="yimiaoPriceadjplan.executeDatetime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 调价依据 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.priceAdjAccord"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="priceAdjAccord" name="priceAdjAccord"
	                            			value="${yimiaoPriceadjplanForm.priceAdjAccord}" placeholder="<spring:message code="yimiaoPriceadjplan.priceAdjAccord"/>" type="text">
			                        </td>
									<th>
										<!-- 备注 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.remark"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="remark" name="remark"
	                            			value="${yimiaoPriceadjplanForm.remark}" placeholder="<spring:message code="yimiaoPriceadjplan.remark"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 状态0未执行1已执行 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.status"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="status" name="status"
	                            			value="${yimiaoPriceadjplanForm.status}" placeholder="<spring:message code="yimiaoPriceadjplan.status"/>" type="text">
			                        </td>
									<th>
										<!-- 更新时间 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.updDatetime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="updDatetime" name="updDatetime"
	                            			value="${yimiaoPriceadjplanForm.updDatetime}" placeholder="<spring:message code="yimiaoPriceadjplan.updDatetime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 更新人 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplan.updUser"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="updUser" name="updUser"
	                            			value="${yimiaoPriceadjplanForm.updUser}" placeholder="<spring:message code="yimiaoPriceadjplan.updUser"/>" type="text">
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
           	     				document.location.href="${ctx }/yimiaoPriceadjplan/toList.html";
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
		document.location.href="${ctx }/yimiaoPriceadjplan/toList.html";
	}
</script>
</html>