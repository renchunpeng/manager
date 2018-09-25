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
				<form role="form" id="updateForm" class="form-horizontal" action="updateYimiaoOrderdetail.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
										<!-- order_detail_id（有序guid编号） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.orderdetailId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderdetailId" name="orderdetailId"
	                            			value="${yimiaoOrderdetailForm.orderdetailId}" placeholder="<spring:message code="yimiaoOrderdetail.orderdetailId"/>" type="text">
			                        </td>
									<th>
										<!-- order_id（有序guid编号） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.orderId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderId" name="orderId"
	                            			value="${yimiaoOrderdetailForm.orderId}" placeholder="<spring:message code="yimiaoOrderdetail.orderId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 商品Id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.procurecatalogId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="procurecatalogId" name="procurecatalogId"
	                            			value="${yimiaoOrderdetailForm.procurecatalogId}" placeholder="<spring:message code="yimiaoOrderdetail.procurecatalogId"/>" type="text">
			                        </td>
									<th>
										<!-- 产品代码 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.goodsId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="goodsId" name="goodsId"
	                            			value="${yimiaoOrderdetailForm.goodsId}" placeholder="<spring:message code="yimiaoOrderdetail.goodsId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 通用名 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.productName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productName" name="productName"
	                            			value="${yimiaoOrderdetailForm.productName}" placeholder="<spring:message code="yimiaoOrderdetail.productName"/>" type="text">
			                        </td>
									<th>
										<!-- 通用名拼音码 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.productSpelName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productSpelName" name="productSpelName"
	                            			value="${yimiaoOrderdetailForm.productSpelName}" placeholder="<spring:message code="yimiaoOrderdetail.productSpelName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 通用名五笔码 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.productWbName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productWbName" name="productWbName"
	                            			value="${yimiaoOrderdetailForm.productWbName}" placeholder="<spring:message code="yimiaoOrderdetail.productWbName"/>" type="text">
			                        </td>
									<th>
										<!-- 商品名 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.goodsName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="goodsName" name="goodsName"
	                            			value="${yimiaoOrderdetailForm.goodsName}" placeholder="<spring:message code="yimiaoOrderdetail.goodsName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 剂型 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.medicinemodel"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="medicinemodel" name="medicinemodel"
	                            			value="${yimiaoOrderdetailForm.medicinemodel}" placeholder="<spring:message code="yimiaoOrderdetail.medicinemodel"/>" type="text">
			                        </td>
									<th>
										<!-- 规格 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.outlook"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="outlook" name="outlook"
	                            			value="${yimiaoOrderdetailForm.outlook}" placeholder="<spring:message code="yimiaoOrderdetail.outlook"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 转换比 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.factor"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="factor" name="factor"
	                            			value="${yimiaoOrderdetailForm.factor}" placeholder="<spring:message code="yimiaoOrderdetail.factor"/>" type="text">
			                        </td>
									<th>
										<!-- 包装材质 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.materialName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="materialName" name="materialName"
	                            			value="${yimiaoOrderdetailForm.materialName}" placeholder="<spring:message code="yimiaoOrderdetail.materialName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 单位 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.unit"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="unit" name="unit"
	                            			value="${yimiaoOrderdetailForm.unit}" placeholder="<spring:message code="yimiaoOrderdetail.unit"/>" type="text">
			                        </td>
									<th>
										<!-- 生产企业名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.companyNameSc"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNameSc" name="companyNameSc"
	                            			value="${yimiaoOrderdetailForm.companyNameSc}" placeholder="<spring:message code="yimiaoOrderdetail.companyNameSc"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 分包装企业 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.splitCompanyName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="splitCompanyName" name="splitCompanyName"
	                            			value="${yimiaoOrderdetailForm.splitCompanyName}" placeholder="<spring:message code="yimiaoOrderdetail.splitCompanyName"/>" type="text">
			                        </td>
									<th>
										<!-- 委托加工企业 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.trustCompanyName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="trustCompanyName" name="trustCompanyName"
	                            			value="${yimiaoOrderdetailForm.trustCompanyName}" placeholder="<spring:message code="yimiaoOrderdetail.trustCompanyName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 投标企业编号 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.companyIdTb"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyIdTb" name="companyIdTb"
	                            			value="${yimiaoOrderdetailForm.companyIdTb}" placeholder="<spring:message code="yimiaoOrderdetail.companyIdTb"/>" type="text">
			                        </td>
									<th>
										<!-- 投标企业名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.companyNameTb"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNameTb" name="companyNameTb"
	                            			value="${yimiaoOrderdetailForm.companyNameTb}" placeholder="<spring:message code="yimiaoOrderdetail.companyNameTb"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 中包装 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.middlePack"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="middlePack" name="middlePack"
	                            			value="${yimiaoOrderdetailForm.middlePack}" placeholder="<spring:message code="yimiaoOrderdetail.middlePack"/>" type="text">
			                        </td>
									<th>
										<!-- 大包装 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.maxPack"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="maxPack" name="maxPack"
	                            			value="${yimiaoOrderdetailForm.maxPack}" placeholder="<spring:message code="yimiaoOrderdetail.maxPack"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 是否基药(0:否,1:是) -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.isBaseDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isBaseDrug" name="isBaseDrug"
	                            			value="${yimiaoOrderdetailForm.isBaseDrug}" placeholder="<spring:message code="yimiaoOrderdetail.isBaseDrug"/>" type="text">
			                        </td>
									<th>
										<!-- 质量层次 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.qualityLevel"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="qualityLevel" name="qualityLevel"
	                            			value="${yimiaoOrderdetailForm.qualityLevel}" placeholder="<spring:message code="yimiaoOrderdetail.qualityLevel"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 采购类别(0:中标药品，1：廉价药品，2：紧张药品，3：低价药品，4：备案药品) -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.purchaseType"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchaseType" name="purchaseType"
	                            			value="${yimiaoOrderdetailForm.purchaseType}" placeholder="<spring:message code="yimiaoOrderdetail.purchaseType"/>" type="text">
			                        </td>
									<th>
										<!-- 来源id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.sourceId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sourceId" name="sourceId"
	                            			value="${yimiaoOrderdetailForm.sourceId}" placeholder="<spring:message code="yimiaoOrderdetail.sourceId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 来源名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.sourceName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sourceName" name="sourceName"
	                            			value="${yimiaoOrderdetailForm.sourceName}" placeholder="<spring:message code="yimiaoOrderdetail.sourceName"/>" type="text">
			                        </td>
									<th>
										<!-- 中标价格(采购类别为中标类的,写入.其他的写0) -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.bidPrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="bidPrice" name="bidPrice"
	                            			value="${yimiaoOrderdetailForm.bidPrice}" placeholder="<spring:message code="yimiaoOrderdetail.bidPrice"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 使用范围（0：县上，1：基层，2：全省） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.usingRang"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="usingRang" name="usingRang"
	                            			value="${yimiaoOrderdetailForm.usingRang}" placeholder="<spring:message code="yimiaoOrderdetail.usingRang"/>" type="text">
			                        </td>
									<th>
										<!-- 医疗机构编号 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.hospitalId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalId" name="hospitalId"
	                            			value="${yimiaoOrderdetailForm.hospitalId}" placeholder="<spring:message code="yimiaoOrderdetail.hospitalId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 医疗机构名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.hospitalName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalName" name="hospitalName"
	                            			value="${yimiaoOrderdetailForm.hospitalName}" placeholder="<spring:message code="yimiaoOrderdetail.hospitalName"/>" type="text">
			                        </td>
									<th>
										<!-- 医疗机构部门编号 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.hospitalDepartmentId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalDepartmentId" name="hospitalDepartmentId"
	                            			value="${yimiaoOrderdetailForm.hospitalDepartmentId}" placeholder="<spring:message code="yimiaoOrderdetail.hospitalDepartmentId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 医疗机构部门名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.hospitalDepartmentName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalDepartmentName" name="hospitalDepartmentName"
	                            			value="${yimiaoOrderdetailForm.hospitalDepartmentName}" placeholder="<spring:message code="yimiaoOrderdetail.hospitalDepartmentName"/>" type="text">
			                        </td>
									<th>
										<!-- 药品行政区域id统计 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.adminAreaIdStatisticsDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="adminAreaIdStatisticsDrug" name="adminAreaIdStatisticsDrug"
	                            			value="${yimiaoOrderdetailForm.adminAreaIdStatisticsDrug}" placeholder="<spring:message code="yimiaoOrderdetail.adminAreaIdStatisticsDrug"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 药品行政区域名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.adminAreaNameDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="adminAreaNameDrug" name="adminAreaNameDrug"
	                            			value="${yimiaoOrderdetailForm.adminAreaNameDrug}" placeholder="<spring:message code="yimiaoOrderdetail.adminAreaNameDrug"/>" type="text">
			                        </td>
									<th>
										<!-- 药品行政区域id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.adminAreaIdDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="adminAreaIdDrug" name="adminAreaIdDrug"
	                            			value="${yimiaoOrderdetailForm.adminAreaIdDrug}" placeholder="<spring:message code="yimiaoOrderdetail.adminAreaIdDrug"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 所属行政机构名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.belongOrgName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="belongOrgName" name="belongOrgName"
	                            			value="${yimiaoOrderdetailForm.belongOrgName}" placeholder="<spring:message code="yimiaoOrderdetail.belongOrgName"/>" type="text">
			                        </td>
									<th>
										<!-- 订单类型（0：正常订单，1：急救药品临时订单） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.orderType"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderType" name="orderType"
	                            			value="${yimiaoOrderdetailForm.orderType}" placeholder="<spring:message code="yimiaoOrderdetail.orderType"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 订单名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.orderName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderName" name="orderName"
	                            			value="${yimiaoOrderdetailForm.orderName}" placeholder="<spring:message code="yimiaoOrderdetail.orderName"/>" type="text">
			                        </td>
									<th>
										<!-- 提交时间 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.submitTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitTime" name="submitTime"
	                            			value="${yimiaoOrderdetailForm.submitTime}" placeholder="<spring:message code="yimiaoOrderdetail.submitTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 备案编号(单内删除时,还原相应记录为未采购) -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.filingId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="filingId" name="filingId"
	                            			value="${yimiaoOrderdetailForm.filingId}" placeholder="<spring:message code="yimiaoOrderdetail.filingId"/>" type="text">
			                        </td>
									<th>
										<!-- 配送企业编号 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.companyIdPs"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyIdPs" name="companyIdPs"
	                            			value="${yimiaoOrderdetailForm.companyIdPs}" placeholder="<spring:message code="yimiaoOrderdetail.companyIdPs"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 配送企业名称 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.companyNamePs"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNamePs" name="companyNamePs"
	                            			value="${yimiaoOrderdetailForm.companyNamePs}" placeholder="<spring:message code="yimiaoOrderdetail.companyNamePs"/>" type="text">
			                        </td>
									<th>
										<!-- 采购价格 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.purchasePrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchasePrice" name="purchasePrice"
	                            			value="${yimiaoOrderdetailForm.purchasePrice}" placeholder="<spring:message code="yimiaoOrderdetail.purchasePrice"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 采购数量 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.purchaseCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchaseCount" name="purchaseCount"
	                            			value="${yimiaoOrderdetailForm.purchaseCount}" placeholder="<spring:message code="yimiaoOrderdetail.purchaseCount"/>" type="text">
			                        </td>
									<th>
										<!-- purchaseAmount -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.purchaseAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchaseAmount" name="purchaseAmount"
	                            			value="${yimiaoOrderdetailForm.purchaseAmount}" placeholder="<spring:message code="yimiaoOrderdetail.purchaseAmount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 是否已阅读 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.isRead"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isRead" name="isRead"
	                            			value="${yimiaoOrderdetailForm.isRead}" placeholder="<spring:message code="yimiaoOrderdetail.isRead"/>" type="text">
			                        </td>
									<th>
										<!-- readUserId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.readUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="readUserId" name="readUserId"
	                            			value="${yimiaoOrderdetailForm.readUserId}" placeholder="<spring:message code="yimiaoOrderdetail.readUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 阅读人 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.readUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="readUserName" name="readUserName"
	                            			value="${yimiaoOrderdetailForm.readUserName}" placeholder="<spring:message code="yimiaoOrderdetail.readUserName"/>" type="text">
			                        </td>
									<th>
										<!-- 阅读时间 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.readTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="readTime" name="readTime"
	                            			value="${yimiaoOrderdetailForm.readTime}" placeholder="<spring:message code="yimiaoOrderdetail.readTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 确认人Id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.confirmUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmUserId" name="confirmUserId"
	                            			value="${yimiaoOrderdetailForm.confirmUserId}" placeholder="<spring:message code="yimiaoOrderdetail.confirmUserId"/>" type="text">
			                        </td>
									<th>
										<!-- 确认人 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.confirmUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmUserName" name="confirmUserName"
	                            			value="${yimiaoOrderdetailForm.confirmUserName}" placeholder="<spring:message code="yimiaoOrderdetail.confirmUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 确认时间 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.confirmTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmTime" name="confirmTime"
	                            			value="${yimiaoOrderdetailForm.confirmTime}" placeholder="<spring:message code="yimiaoOrderdetail.confirmTime"/>" type="text">
			                        </td>
									<th>
										<!-- 确认状态 0 - 待处理 1 - 供货 2 - 不供货 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.confirmState"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmState" name="confirmState"
	                            			value="${yimiaoOrderdetailForm.confirmState}" placeholder="<spring:message code="yimiaoOrderdetail.confirmState"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 采购明细状态（0 已保存待提交 1已提交待确认 2已确认待配送 3 拒绝确认4 已配送待收货5 拒绝配送 6 未及时配送 7 收货中 8 已收货 9 已撤单 ） -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.orderdetailState"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderdetailState" name="orderdetailState"
	                            			value="${yimiaoOrderdetailForm.orderdetailState}" placeholder="<spring:message code="yimiaoOrderdetail.orderdetailState"/>" type="text">
			                        </td>
									<th>
										<!-- 拒绝理由 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.refuseReason"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="refuseReason" name="refuseReason"
	                            			value="${yimiaoOrderdetailForm.refuseReason}" placeholder="<spring:message code="yimiaoOrderdetail.refuseReason"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 订单明细配送地址 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.detailDistributeAddress"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="detailDistributeAddress" name="detailDistributeAddress"
	                            			value="${yimiaoOrderdetailForm.detailDistributeAddress}" placeholder="<spring:message code="yimiaoOrderdetail.detailDistributeAddress"/>" type="text">
			                        </td>
									<th>
										<!-- 总配送数量 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.totalDistributeCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalDistributeCount" name="totalDistributeCount"
	                            			value="${yimiaoOrderdetailForm.totalDistributeCount}" placeholder="<spring:message code="yimiaoOrderdetail.totalDistributeCount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 总配送金额 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.totalDistributeAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalDistributeAmount" name="totalDistributeAmount"
	                            			value="${yimiaoOrderdetailForm.totalDistributeAmount}" placeholder="<spring:message code="yimiaoOrderdetail.totalDistributeAmount"/>" type="text">
			                        </td>
									<th>
										<!-- 总收货数量 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.totalWarehouseCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalWarehouseCount" name="totalWarehouseCount"
	                            			value="${yimiaoOrderdetailForm.totalWarehouseCount}" placeholder="<spring:message code="yimiaoOrderdetail.totalWarehouseCount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 总收货金额 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.totalWarehouseAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalWarehouseAmount" name="totalWarehouseAmount"
	                            			value="${yimiaoOrderdetailForm.totalWarehouseAmount}" placeholder="<spring:message code="yimiaoOrderdetail.totalWarehouseAmount"/>" type="text">
			                        </td>
									<th>
										<!-- 总退货金额 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.totalReturnAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalReturnAmount" name="totalReturnAmount"
	                            			value="${yimiaoOrderdetailForm.totalReturnAmount}" placeholder="<spring:message code="yimiaoOrderdetail.totalReturnAmount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 总退货数量 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.totalReturnCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalReturnCount" name="totalReturnCount"
	                            			value="${yimiaoOrderdetailForm.totalReturnCount}" placeholder="<spring:message code="yimiaoOrderdetail.totalReturnCount"/>" type="text">
			                        </td>
									<th>
										<!-- 是否启用 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.isUsing"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isUsing" name="isUsing"
	                            			value="${yimiaoOrderdetailForm.isUsing}" placeholder="<spring:message code="yimiaoOrderdetail.isUsing"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 处理原因 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.compRatio"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="compRatio" name="compRatio"
	                            			value="${yimiaoOrderdetailForm.compRatio}" placeholder="<spring:message code="yimiaoOrderdetail.compRatio"/>" type="text">
			                        </td>
									<th>
										<!-- 订单自定义信息 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.orderCustomInfo"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderCustomInfo" name="orderCustomInfo"
	                            			value="${yimiaoOrderdetailForm.orderCustomInfo}" placeholder="<spring:message code="yimiaoOrderdetail.orderCustomInfo"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 记录添加人id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.addUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserId" name="addUserId"
	                            			value="${yimiaoOrderdetailForm.addUserId}" placeholder="<spring:message code="yimiaoOrderdetail.addUserId"/>" type="text">
			                        </td>
									<th>
										<!-- 记录添加人 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.addUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserName" name="addUserName"
	                            			value="${yimiaoOrderdetailForm.addUserName}" placeholder="<spring:message code="yimiaoOrderdetail.addUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 记录添加时间 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.addTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addTime" name="addTime"
	                            			value="${yimiaoOrderdetailForm.addTime}" placeholder="<spring:message code="yimiaoOrderdetail.addTime"/>" type="text">
			                        </td>
									<th>
										<!-- 最后一次更新记录人id -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.lastUpdateUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserId" name="lastUpdateUserId"
	                            			value="${yimiaoOrderdetailForm.lastUpdateUserId}" placeholder="<spring:message code="yimiaoOrderdetail.lastUpdateUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 最后一次更新记录人 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.lastUpdateUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserName" name="lastUpdateUserName"
	                            			value="${yimiaoOrderdetailForm.lastUpdateUserName}" placeholder="<spring:message code="yimiaoOrderdetail.lastUpdateUserName"/>" type="text">
			                        </td>
									<th>
										<!-- 最后一次更新记录时间 -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetail.lastUpdateTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateTime" name="lastUpdateTime"
	                            			value="${yimiaoOrderdetailForm.lastUpdateTime}" placeholder="<spring:message code="yimiaoOrderdetail.lastUpdateTime"/>" type="text">
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
           	     				document.location.href="${ctx }/yimiaoOrderdetail/toList.html";
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
		document.location.href="${ctx }/yimiaoOrderdetail/toList.html";
	}
</script>
</html>