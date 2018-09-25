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
				<form role="form" id="addForm" class="form-horizontal" action="addYimiaoOrderdetailRetlog.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
										<!-- order_detail_id（有序guid编号） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.logId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="logId" name="logId"
	                            			value="${yimiaoOrderdetailRetlogForm.logId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.logId"/>" type="text">
			                        </td>
									<th>
										<!-- order_detail_id（有序guid编号） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.orderdetailRetId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderdetailRetId" name="orderdetailRetId"
	                            			value="${yimiaoOrderdetailRetlogForm.orderdetailRetId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.orderdetailRetId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- order_id（有序guid编号） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.orderId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderId" name="orderId"
	                            			value="${yimiaoOrderdetailRetlogForm.orderId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.orderId"/>" type="text">
			                        </td>
									<th>
										<!-- 商品Id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.procurecatalogId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="procurecatalogId" name="procurecatalogId"
	                            			value="${yimiaoOrderdetailRetlogForm.procurecatalogId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.procurecatalogId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 产品代码 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.goodsId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="goodsId" name="goodsId"
	                            			value="${yimiaoOrderdetailRetlogForm.goodsId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.goodsId"/>" type="text">
			                        </td>
									<th>
										<!-- 通用名 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.productName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productName" name="productName"
	                            			value="${yimiaoOrderdetailRetlogForm.productName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.productName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 通用名拼音码 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.productSpelName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productSpelName" name="productSpelName"
	                            			value="${yimiaoOrderdetailRetlogForm.productSpelName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.productSpelName"/>" type="text">
			                        </td>
									<th>
										<!-- 通用名五笔码 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.productWbName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productWbName" name="productWbName"
	                            			value="${yimiaoOrderdetailRetlogForm.productWbName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.productWbName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 商品名 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.goodsName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="goodsName" name="goodsName"
	                            			value="${yimiaoOrderdetailRetlogForm.goodsName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.goodsName"/>" type="text">
			                        </td>
									<th>
										<!-- 剂型 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.medicinemodel"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="medicinemodel" name="medicinemodel"
	                            			value="${yimiaoOrderdetailRetlogForm.medicinemodel}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.medicinemodel"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 规格 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.outlook"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="outlook" name="outlook"
	                            			value="${yimiaoOrderdetailRetlogForm.outlook}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.outlook"/>" type="text">
			                        </td>
									<th>
										<!-- 转换比 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.factor"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="factor" name="factor"
	                            			value="${yimiaoOrderdetailRetlogForm.factor}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.factor"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 包装材质 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.materialName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="materialName" name="materialName"
	                            			value="${yimiaoOrderdetailRetlogForm.materialName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.materialName"/>" type="text">
			                        </td>
									<th>
										<!-- 单位 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.unit"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="unit" name="unit"
	                            			value="${yimiaoOrderdetailRetlogForm.unit}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.unit"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 生产企业名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.companyNameSc"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNameSc" name="companyNameSc"
	                            			value="${yimiaoOrderdetailRetlogForm.companyNameSc}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.companyNameSc"/>" type="text">
			                        </td>
									<th>
										<!-- 分包装企业 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.splitCompanyName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="splitCompanyName" name="splitCompanyName"
	                            			value="${yimiaoOrderdetailRetlogForm.splitCompanyName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.splitCompanyName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 委托加工企业 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.trustCompanyName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="trustCompanyName" name="trustCompanyName"
	                            			value="${yimiaoOrderdetailRetlogForm.trustCompanyName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.trustCompanyName"/>" type="text">
			                        </td>
									<th>
										<!-- 投标企业编号 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.companyIdTb"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyIdTb" name="companyIdTb"
	                            			value="${yimiaoOrderdetailRetlogForm.companyIdTb}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.companyIdTb"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 投标企业名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.companyNameTb"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNameTb" name="companyNameTb"
	                            			value="${yimiaoOrderdetailRetlogForm.companyNameTb}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.companyNameTb"/>" type="text">
			                        </td>
									<th>
										<!-- 中包装 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.middlePack"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="middlePack" name="middlePack"
	                            			value="${yimiaoOrderdetailRetlogForm.middlePack}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.middlePack"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 大包装 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.maxPack"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="maxPack" name="maxPack"
	                            			value="${yimiaoOrderdetailRetlogForm.maxPack}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.maxPack"/>" type="text">
			                        </td>
									<th>
										<!-- 是否基药(0:否,1:是) -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.isBaseDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isBaseDrug" name="isBaseDrug"
	                            			value="${yimiaoOrderdetailRetlogForm.isBaseDrug}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.isBaseDrug"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 质量层次 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.qualityLevel"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="qualityLevel" name="qualityLevel"
	                            			value="${yimiaoOrderdetailRetlogForm.qualityLevel}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.qualityLevel"/>" type="text">
			                        </td>
									<th>
										<!-- 采购类别(0:中标药品，1：廉价药品，2：紧张药品，3：低价药品，4：备案药品) -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.purchaseType"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchaseType" name="purchaseType"
	                            			value="${yimiaoOrderdetailRetlogForm.purchaseType}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.purchaseType"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 来源id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.sourceId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sourceId" name="sourceId"
	                            			value="${yimiaoOrderdetailRetlogForm.sourceId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.sourceId"/>" type="text">
			                        </td>
									<th>
										<!-- 来源名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.sourceName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sourceName" name="sourceName"
	                            			value="${yimiaoOrderdetailRetlogForm.sourceName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.sourceName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 中标价格(采购类别为中标类的,写入.其他的写0) -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.bidPrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="bidPrice" name="bidPrice"
	                            			value="${yimiaoOrderdetailRetlogForm.bidPrice}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.bidPrice"/>" type="text">
			                        </td>
									<th>
										<!-- 使用范围（0：县上，1：基层，2：全省） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.usingRang"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="usingRang" name="usingRang"
	                            			value="${yimiaoOrderdetailRetlogForm.usingRang}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.usingRang"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 医疗机构编号 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.hospitalId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalId" name="hospitalId"
	                            			value="${yimiaoOrderdetailRetlogForm.hospitalId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.hospitalId"/>" type="text">
			                        </td>
									<th>
										<!-- 医疗机构名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.hospitalName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalName" name="hospitalName"
	                            			value="${yimiaoOrderdetailRetlogForm.hospitalName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.hospitalName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 医疗机构部门编号 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.hospitalDepartmentId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalDepartmentId" name="hospitalDepartmentId"
	                            			value="${yimiaoOrderdetailRetlogForm.hospitalDepartmentId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.hospitalDepartmentId"/>" type="text">
			                        </td>
									<th>
										<!-- 医疗机构部门名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.hospitalDepartmentName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalDepartmentName" name="hospitalDepartmentName"
	                            			value="${yimiaoOrderdetailRetlogForm.hospitalDepartmentName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.hospitalDepartmentName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 药品行政区域id统计 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.adminAreaIdStatisticsDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="adminAreaIdStatisticsDrug" name="adminAreaIdStatisticsDrug"
	                            			value="${yimiaoOrderdetailRetlogForm.adminAreaIdStatisticsDrug}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.adminAreaIdStatisticsDrug"/>" type="text">
			                        </td>
									<th>
										<!-- 药品行政区域名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.adminAreaNameDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="adminAreaNameDrug" name="adminAreaNameDrug"
	                            			value="${yimiaoOrderdetailRetlogForm.adminAreaNameDrug}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.adminAreaNameDrug"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 药品行政区域id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.adminAreaIdDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="adminAreaIdDrug" name="adminAreaIdDrug"
	                            			value="${yimiaoOrderdetailRetlogForm.adminAreaIdDrug}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.adminAreaIdDrug"/>" type="text">
			                        </td>
									<th>
										<!-- 所属行政机构名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.belongOrgName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="belongOrgName" name="belongOrgName"
	                            			value="${yimiaoOrderdetailRetlogForm.belongOrgName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.belongOrgName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 订单类型（0：正常订单，1：急救药品临时订单） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.orderType"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderType" name="orderType"
	                            			value="${yimiaoOrderdetailRetlogForm.orderType}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.orderType"/>" type="text">
			                        </td>
									<th>
										<!-- 订单名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.orderName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderName" name="orderName"
	                            			value="${yimiaoOrderdetailRetlogForm.orderName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.orderName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 提交时间 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.submitTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitTime" name="submitTime"
	                            			value="${yimiaoOrderdetailRetlogForm.submitTime}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.submitTime"/>" type="text">
			                        </td>
									<th>
										<!-- 备案编号(单内删除时,还原相应记录为未采购) -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.filingId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="filingId" name="filingId"
	                            			value="${yimiaoOrderdetailRetlogForm.filingId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.filingId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 配送企业编号 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.companyIdPs"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyIdPs" name="companyIdPs"
	                            			value="${yimiaoOrderdetailRetlogForm.companyIdPs}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.companyIdPs"/>" type="text">
			                        </td>
									<th>
										<!-- 配送企业名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.companyNamePs"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNamePs" name="companyNamePs"
	                            			value="${yimiaoOrderdetailRetlogForm.companyNamePs}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.companyNamePs"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 采购价格 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.purchasePrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchasePrice" name="purchasePrice"
	                            			value="${yimiaoOrderdetailRetlogForm.purchasePrice}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.purchasePrice"/>" type="text">
			                        </td>
									<th>
										<!-- 采购数量 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.purchaseCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchaseCount" name="purchaseCount"
	                            			value="${yimiaoOrderdetailRetlogForm.purchaseCount}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.purchaseCount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- purchaseAmount -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.purchaseAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchaseAmount" name="purchaseAmount"
	                            			value="${yimiaoOrderdetailRetlogForm.purchaseAmount}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.purchaseAmount"/>" type="text">
			                        </td>
									<th>
										<!-- 是否已阅读 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.isRead"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isRead" name="isRead"
	                            			value="${yimiaoOrderdetailRetlogForm.isRead}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.isRead"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- readUserId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.readUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="readUserId" name="readUserId"
	                            			value="${yimiaoOrderdetailRetlogForm.readUserId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.readUserId"/>" type="text">
			                        </td>
									<th>
										<!-- 阅读人 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.readUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="readUserName" name="readUserName"
	                            			value="${yimiaoOrderdetailRetlogForm.readUserName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.readUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 阅读时间 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.readTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="readTime" name="readTime"
	                            			value="${yimiaoOrderdetailRetlogForm.readTime}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.readTime"/>" type="text">
			                        </td>
									<th>
										<!-- 确认人Id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.confirmUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmUserId" name="confirmUserId"
	                            			value="${yimiaoOrderdetailRetlogForm.confirmUserId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.confirmUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 确认人 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.confirmUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmUserName" name="confirmUserName"
	                            			value="${yimiaoOrderdetailRetlogForm.confirmUserName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.confirmUserName"/>" type="text">
			                        </td>
									<th>
										<!-- 确认时间 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.confirmTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmTime" name="confirmTime"
	                            			value="${yimiaoOrderdetailRetlogForm.confirmTime}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.confirmTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 确认状态 0 - 待处理 1 - 供货 2 - 不供货 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.confirmState"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmState" name="confirmState"
	                            			value="${yimiaoOrderdetailRetlogForm.confirmState}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.confirmState"/>" type="text">
			                        </td>
									<th>
										<!-- 采购明细状态（0 已保存待提交 1已提交待确认 2已确认待配送 3 拒绝确认4 已配送待收货5 拒绝配送 6 未及时配送 7 收货中 8 已收货 9 已撤单 ） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.orderdetailState"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderdetailState" name="orderdetailState"
	                            			value="${yimiaoOrderdetailRetlogForm.orderdetailState}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.orderdetailState"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 拒绝理由 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.refuseReason"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="refuseReason" name="refuseReason"
	                            			value="${yimiaoOrderdetailRetlogForm.refuseReason}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.refuseReason"/>" type="text">
			                        </td>
									<th>
										<!-- 订单明细配送地址 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.detailDistributeAddress"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="detailDistributeAddress" name="detailDistributeAddress"
	                            			value="${yimiaoOrderdetailRetlogForm.detailDistributeAddress}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.detailDistributeAddress"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 总配送数量 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.totalDistributeCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalDistributeCount" name="totalDistributeCount"
	                            			value="${yimiaoOrderdetailRetlogForm.totalDistributeCount}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.totalDistributeCount"/>" type="text">
			                        </td>
									<th>
										<!-- 总配送金额 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.totalDistributeAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalDistributeAmount" name="totalDistributeAmount"
	                            			value="${yimiaoOrderdetailRetlogForm.totalDistributeAmount}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.totalDistributeAmount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 总收货数量 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.totalWarehouseCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalWarehouseCount" name="totalWarehouseCount"
	                            			value="${yimiaoOrderdetailRetlogForm.totalWarehouseCount}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.totalWarehouseCount"/>" type="text">
			                        </td>
									<th>
										<!-- 总收货金额 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.totalWarehouseAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalWarehouseAmount" name="totalWarehouseAmount"
	                            			value="${yimiaoOrderdetailRetlogForm.totalWarehouseAmount}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.totalWarehouseAmount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 总退货金额 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.totalReturnAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalReturnAmount" name="totalReturnAmount"
	                            			value="${yimiaoOrderdetailRetlogForm.totalReturnAmount}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.totalReturnAmount"/>" type="text">
			                        </td>
									<th>
										<!-- 总退货数量 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.totalReturnCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalReturnCount" name="totalReturnCount"
	                            			value="${yimiaoOrderdetailRetlogForm.totalReturnCount}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.totalReturnCount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 是否启用 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.isUsing"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isUsing" name="isUsing"
	                            			value="${yimiaoOrderdetailRetlogForm.isUsing}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.isUsing"/>" type="text">
			                        </td>
									<th>
										<!-- 处理原因 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.compRatio"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="compRatio" name="compRatio"
	                            			value="${yimiaoOrderdetailRetlogForm.compRatio}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.compRatio"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 订单自定义信息 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.orderCustomInfo"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderCustomInfo" name="orderCustomInfo"
	                            			value="${yimiaoOrderdetailRetlogForm.orderCustomInfo}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.orderCustomInfo"/>" type="text">
			                        </td>
									<th>
										<!-- 记录添加人id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.addUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserId" name="addUserId"
	                            			value="${yimiaoOrderdetailRetlogForm.addUserId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.addUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 记录添加人 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.addUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserName" name="addUserName"
	                            			value="${yimiaoOrderdetailRetlogForm.addUserName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.addUserName"/>" type="text">
			                        </td>
									<th>
										<!-- 记录添加时间 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.addTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addTime" name="addTime"
	                            			value="${yimiaoOrderdetailRetlogForm.addTime}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.addTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 最后一次更新记录人id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.lastUpdateUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserId" name="lastUpdateUserId"
	                            			value="${yimiaoOrderdetailRetlogForm.lastUpdateUserId}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.lastUpdateUserId"/>" type="text">
			                        </td>
									<th>
										<!-- 最后一次更新记录人 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.lastUpdateUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserName" name="lastUpdateUserName"
	                            			value="${yimiaoOrderdetailRetlogForm.lastUpdateUserName}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.lastUpdateUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 最后一次更新记录时间 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.lastUpdateTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateTime" name="lastUpdateTime"
	                            			value="${yimiaoOrderdetailRetlogForm.lastUpdateTime}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.lastUpdateTime"/>" type="text">
			                        </td>
									<th>
										<!-- companyIdSc -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRetlog.companyIdSc"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyIdSc" name="companyIdSc"
	                            			value="${yimiaoOrderdetailRetlogForm.companyIdSc}" placeholder="<spring:message code="yimiaoOrderdetailRetlog.companyIdSc"/>" type="text">
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
	});
	
	function init() {
		$("#addForm").validate(${validate});
	}
	
	function save() {
		if(!$('#addForm').valid()) {
			return;
		}
		$.HN.message.confirm('确定要保存吗？', '', '').on(function (e) {
			if (e) {
				$("#addForm").ajaxSubmit({
					dataType : "json",
             		timeout: 10000,
               		success: function(result,statusText) {
                   		if(result.success){
           	     			$.alert("添加成功！", "success", function() {
           	     				document.location.href="${ctx }/yimiaoOrderdetailRetlog/toList.html";
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
		document.location.href="${ctx }/yimiaoOrderdetailRetlog/toList.html";
	}
</script>
</html>