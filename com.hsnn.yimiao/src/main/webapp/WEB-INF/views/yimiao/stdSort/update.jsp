<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="二级目录表更新-待修改"/></title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="二级目录表更新-待修改"/></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#"><spring:message code="二级目录表管理-待修改"/></a></li>
			<li class="active"><a href="#"><spring:message code="二级目录表更新-待修改"/></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">     
				<form role="form" id="updateForm" class="form-horizontal" action="updateStdSort.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
										<!-- 主键id -->
			                            <label class="control-label "><spring:message code="stdSort.sortId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sortId" name="sortId"
	                            			value="${stdSortForm.sortId}" placeholder="<spring:message code="stdSort.sortId"/>" type="text">
			                        </td>
									<th>
										<!-- sortName -->
			                            <label class="control-label "><spring:message code="stdSort.sortName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sortName" name="sortName"
	                            			value="${stdSortForm.sortName}" placeholder="<spring:message code="stdSort.sortName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- belongAreaId -->
			                            <label class="control-label "><spring:message code="stdSort.belongAreaId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="belongAreaId" name="belongAreaId"
	                            			value="${stdSortForm.belongAreaId}" placeholder="<spring:message code="stdSort.belongAreaId"/>" type="text">
			                        </td>
									<th>
										<!-- belongAreaName -->
			                            <label class="control-label "><spring:message code="stdSort.belongAreaName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="belongAreaName" name="belongAreaName"
	                            			value="${stdSortForm.belongAreaName}" placeholder="<spring:message code="stdSort.belongAreaName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 添加人id -->
			                            <label class="control-label "><spring:message code="stdSort.addUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserId" name="addUserId"
	                            			value="${stdSortForm.addUserId}" placeholder="<spring:message code="stdSort.addUserId"/>" type="text">
			                        </td>
									<th>
										<!-- 添加人 -->
			                            <label class="control-label "><spring:message code="stdSort.addUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserName" name="addUserName"
	                            			value="${stdSortForm.addUserName}" placeholder="<spring:message code="stdSort.addUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 添加时间 -->
			                            <label class="control-label "><spring:message code="stdSort.addTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addTime" name="addTime"
	                            			value="${stdSortForm.addTime}" placeholder="<spring:message code="stdSort.addTime"/>" type="text">
			                        </td>
									<th>
										<!-- lastUpdateUserId -->
			                            <label class="control-label "><spring:message code="stdSort.lastUpdateUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserId" name="lastUpdateUserId"
	                            			value="${stdSortForm.lastUpdateUserId}" placeholder="<spring:message code="stdSort.lastUpdateUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- lastUpdateUserName -->
			                            <label class="control-label "><spring:message code="stdSort.lastUpdateUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserName" name="lastUpdateUserName"
	                            			value="${stdSortForm.lastUpdateUserName}" placeholder="<spring:message code="stdSort.lastUpdateUserName"/>" type="text">
			                        </td>
									<th>
										<!-- lastUpdateTime -->
			                            <label class="control-label "><spring:message code="stdSort.lastUpdateTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateTime" name="lastUpdateTime"
	                            			value="${stdSortForm.lastUpdateTime}" placeholder="<spring:message code="stdSort.lastUpdateTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- oldSortId -->
			                            <label class="control-label "><spring:message code="stdSort.oldSortId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="oldSortId" name="oldSortId"
	                            			value="${stdSortForm.oldSortId}" placeholder="<spring:message code="stdSort.oldSortId"/>" type="text">
			                        </td>
									<th>
										<!-- 一级目录id -->
			                            <label class="control-label "><spring:message code="stdSort.productId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productId" name="productId"
	                            			value="${stdSortForm.productId}" placeholder="<spring:message code="stdSort.productId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 一级目录名称 -->
			                            <label class="control-label "><spring:message code="stdSort.productName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productName" name="productName"
	                            			value="${stdSortForm.productName}" placeholder="<spring:message code="stdSort.productName"/>" type="text">
			                        </td>
									<th>
										<!-- 二级目录 -->
			                            <label class="control-label "><spring:message code="stdSort.outlook"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="outlook" name="outlook"
	                            			value="${stdSortForm.outlook}" placeholder="<spring:message code="stdSort.outlook"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
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
           	     				document.location.href="${ctx }/stdSort/toList.html";
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
		document.location.href="${ctx }/stdSort/toList.html";
	}
</script>
</html>