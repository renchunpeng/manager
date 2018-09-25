<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"></a></li>
			<li class="active"></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">     
				<form role="form" id="updateForm" class="form-horizontal" action="updateYimiaoProcurecatalog.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
										<!-- procurecatalogId -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.procurecatalogId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="procurecatalogId" name="procurecatalogId"
	                            			value="${yimiaoProcurecatalogForm.procurecatalogId}" placeholder="<spring:message code="yimiaoProcurecatalog.procurecatalogId"/>" type="text">
			                        </td>
									<th>
										<!-- 产品代码 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.goodsId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="goodsId" name="goodsId"
	                            			value="${yimiaoProcurecatalogForm.goodsId}" placeholder="<spring:message code="yimiaoProcurecatalog.goodsId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 通用名 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.productName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productName" name="productName"
	                            			value="${yimiaoProcurecatalogForm.productName}" placeholder="<spring:message code="yimiaoProcurecatalog.productName"/>" type="text">
			                        </td>
									<th>
										<!-- 通用名拼音码 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.productSpelName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productSpelName" name="productSpelName"
	                            			value="${yimiaoProcurecatalogForm.productSpelName}" placeholder="<spring:message code="yimiaoProcurecatalog.productSpelName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 通用名五笔码 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.productWbName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productWbName" name="productWbName"
	                            			value="${yimiaoProcurecatalogForm.productWbName}" placeholder="<spring:message code="yimiaoProcurecatalog.productWbName"/>" type="text">
			                        </td>
									<th>
										<!-- 商品名 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.goodsName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="goodsName" name="goodsName"
	                            			value="${yimiaoProcurecatalogForm.goodsName}" placeholder="<spring:message code="yimiaoProcurecatalog.goodsName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 剂型 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.medicinemodel"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="medicinemodel" name="medicinemodel"
	                            			value="${yimiaoProcurecatalogForm.medicinemodel}" placeholder="<spring:message code="yimiaoProcurecatalog.medicinemodel"/>" type="text">
			                        </td>
									<th>
										<!-- 规格 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.outlook"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="outlook" name="outlook"
	                            			value="${yimiaoProcurecatalogForm.outlook}" placeholder="<spring:message code="yimiaoProcurecatalog.outlook"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 转换比 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.factor"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="factor" name="factor"
	                            			value="${yimiaoProcurecatalogForm.factor}" placeholder="<spring:message code="yimiaoProcurecatalog.factor"/>" type="text">
			                        </td>
									<th>
										<!-- 包装材质 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.materialName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="materialName" name="materialName"
	                            			value="${yimiaoProcurecatalogForm.materialName}" placeholder="<spring:message code="yimiaoProcurecatalog.materialName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 单位 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.unit"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="unit" name="unit"
	                            			value="${yimiaoProcurecatalogForm.unit}" placeholder="<spring:message code="yimiaoProcurecatalog.unit"/>" type="text">
			                        </td>
									<th>
										<!-- 中包装 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.middlePack"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="middlePack" name="middlePack"
	                            			value="${yimiaoProcurecatalogForm.middlePack}" placeholder="<spring:message code="yimiaoProcurecatalog.middlePack"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 大包装 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.maxPack"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="maxPack" name="maxPack"
	                            			value="${yimiaoProcurecatalogForm.maxPack}" placeholder="<spring:message code="yimiaoProcurecatalog.maxPack"/>" type="text">
			                        </td>
									<th>
										<!-- 生产企业编号 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.companyIdSc"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyIdSc" name="companyIdSc"
	                            			value="${yimiaoProcurecatalogForm.companyIdSc}" placeholder="<spring:message code="yimiaoProcurecatalog.companyIdSc"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 生产企业名称 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.companyNameSc"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNameSc" name="companyNameSc"
	                            			value="${yimiaoProcurecatalogForm.companyNameSc}" placeholder="<spring:message code="yimiaoProcurecatalog.companyNameSc"/>" type="text">
			                        </td>
									<th>
										<!-- 分包装企业 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.splitCompanyName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="splitCompanyName" name="splitCompanyName"
	                            			value="${yimiaoProcurecatalogForm.splitCompanyName}" placeholder="<spring:message code="yimiaoProcurecatalog.splitCompanyName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 委托加工企业 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.trustCompanyName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="trustCompanyName" name="trustCompanyName"
	                            			value="${yimiaoProcurecatalogForm.trustCompanyName}" placeholder="<spring:message code="yimiaoProcurecatalog.trustCompanyName"/>" type="text">
			                        </td>
									<th>
										<!-- 投标企业编号 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.companyIdTb"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyIdTb" name="companyIdTb"
	                            			value="${yimiaoProcurecatalogForm.companyIdTb}" placeholder="<spring:message code="yimiaoProcurecatalog.companyIdTb"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 投标企业名称 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.companyNameTb"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNameTb" name="companyNameTb"
	                            			value="${yimiaoProcurecatalogForm.companyNameTb}" placeholder="<spring:message code="yimiaoProcurecatalog.companyNameTb"/>" type="text">
			                        </td>
									<th>
										<!-- 是否基药(0:否,1:是) -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.isBaseDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isBaseDrug" name="isBaseDrug"
	                            			value="${yimiaoProcurecatalogForm.isBaseDrug}" placeholder="<spring:message code="yimiaoProcurecatalog.isBaseDrug"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- qualityLevel -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.qualityLevel"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="qualityLevel" name="qualityLevel"
	                            			value="${yimiaoProcurecatalogForm.qualityLevel}" placeholder="<spring:message code="yimiaoProcurecatalog.qualityLevel"/>" type="text">
			                        </td>
									<th>
										<!-- 采购类别(0:中标药品，1：廉价药品，2：紧张药品，3：低价药品，4：备案药品) -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.purchaseType"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchaseType" name="purchaseType"
	                            			value="${yimiaoProcurecatalogForm.purchaseType}" placeholder="<spring:message code="yimiaoProcurecatalog.purchaseType"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 来源id -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.sourceId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sourceId" name="sourceId"
	                            			value="${yimiaoProcurecatalogForm.sourceId}" placeholder="<spring:message code="yimiaoProcurecatalog.sourceId"/>" type="text">
			                        </td>
									<th>
										<!-- 来源名称 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.sourceName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sourceName" name="sourceName"
	                            			value="${yimiaoProcurecatalogForm.sourceName}" placeholder="<spring:message code="yimiaoProcurecatalog.sourceName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 中标价格（医院端看到为“采购价”，配送企业端为“供应价”） -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.bidPrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="bidPrice" name="bidPrice"
	                            			value="${yimiaoProcurecatalogForm.bidPrice}" placeholder="<spring:message code="yimiaoProcurecatalog.bidPrice"/>" type="text">
			                        </td>
									<th>
										<!-- 临时零售价 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.temporaryRetailPrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="temporaryRetailPrice" name="temporaryRetailPrice"
	                            			value="${yimiaoProcurecatalogForm.temporaryRetailPrice}" placeholder="<spring:message code="yimiaoProcurecatalog.temporaryRetailPrice"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 最高零售价 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.maxRetailPrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="maxRetailPrice" name="maxRetailPrice"
	                            			value="${yimiaoProcurecatalogForm.maxRetailPrice}" placeholder="<spring:message code="yimiaoProcurecatalog.maxRetailPrice"/>" type="text">
			                        </td>
									<th>
										<!-- 最高采购价 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.maxPurchasePrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="maxPurchasePrice" name="maxPurchasePrice"
	                            			value="${yimiaoProcurecatalogForm.maxPurchasePrice}" placeholder="<spring:message code="yimiaoProcurecatalog.maxPurchasePrice"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 参照价 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.referencePrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="referencePrice" name="referencePrice"
	                            			value="${yimiaoProcurecatalogForm.referencePrice}" placeholder="<spring:message code="yimiaoProcurecatalog.referencePrice"/>" type="text">
			                        </td>
									<th>
										<!-- 最高挂网价 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.maxListingPrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="maxListingPrice" name="maxListingPrice"
	                            			value="${yimiaoProcurecatalogForm.maxListingPrice}" placeholder="<spring:message code="yimiaoProcurecatalog.maxListingPrice"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 使用范围（0：县上，1：基层，2：全省） -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.usingRang"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="usingRang" name="usingRang"
	                            			value="${yimiaoProcurecatalogForm.usingRang}" placeholder="<spring:message code="yimiaoProcurecatalog.usingRang"/>" type="text">
			                        </td>
									<th>
										<!-- 备注 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.remark"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="remark" name="remark"
	                            			value="${yimiaoProcurecatalogForm.remark}" placeholder="<spring:message code="yimiaoProcurecatalog.remark"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 提交状态（0：保存待提交，1：提交待审核） -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.submitStatus"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitStatus" name="submitStatus"
	                            			value="${yimiaoProcurecatalogForm.submitStatus}" placeholder="<spring:message code="yimiaoProcurecatalog.submitStatus"/>" type="text">
			                        </td>
									<th>
										<!-- 提交人id -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.submitUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitUserId" name="submitUserId"
	                            			value="${yimiaoProcurecatalogForm.submitUserId}" placeholder="<spring:message code="yimiaoProcurecatalog.submitUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 提交人 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.submitUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitUserName" name="submitUserName"
	                            			value="${yimiaoProcurecatalogForm.submitUserName}" placeholder="<spring:message code="yimiaoProcurecatalog.submitUserName"/>" type="text">
			                        </td>
									<th>
										<!-- 提交时间 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.submitTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitTime" name="submitTime"
	                            			value="${yimiaoProcurecatalogForm.submitTime}" placeholder="<spring:message code="yimiaoProcurecatalog.submitTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 审核状态（0：待审核，1：审核通过，2：审核不通过） -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.auditStatus"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditStatus" name="auditStatus"
	                            			value="${yimiaoProcurecatalogForm.auditStatus}" placeholder="<spring:message code="yimiaoProcurecatalog.auditStatus"/>" type="text">
			                        </td>
									<th>
										<!-- 审核人id -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.auditUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditUserId" name="auditUserId"
	                            			value="${yimiaoProcurecatalogForm.auditUserId}" placeholder="<spring:message code="yimiaoProcurecatalog.auditUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 审核人 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.auditUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditUserName" name="auditUserName"
	                            			value="${yimiaoProcurecatalogForm.auditUserName}" placeholder="<spring:message code="yimiaoProcurecatalog.auditUserName"/>" type="text">
			                        </td>
									<th>
										<!-- 审核时间 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.auditTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditTime" name="auditTime"
	                            			value="${yimiaoProcurecatalogForm.auditTime}" placeholder="<spring:message code="yimiaoProcurecatalog.auditTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- auditRemark -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.auditRemark"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="auditRemark" name="auditRemark"
	                            			value="${yimiaoProcurecatalogForm.auditRemark}" placeholder="<spring:message code="yimiaoProcurecatalog.auditRemark"/>" type="text">
			                        </td>
									<th>
										<!-- 是否有效(0:禁用,1:启用) -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.isUsing"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isUsing" name="isUsing"
	                            			value="${yimiaoProcurecatalogForm.isUsing}" placeholder="<spring:message code="yimiaoProcurecatalog.isUsing"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 处理人编号 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.dealPersonId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="dealPersonId" name="dealPersonId"
	                            			value="${yimiaoProcurecatalogForm.dealPersonId}" placeholder="<spring:message code="yimiaoProcurecatalog.dealPersonId"/>" type="text">
			                        </td>
									<th>
										<!-- 处理人 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.dealPerson"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="dealPerson" name="dealPerson"
	                            			value="${yimiaoProcurecatalogForm.dealPerson}" placeholder="<spring:message code="yimiaoProcurecatalog.dealPerson"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 处理时间 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.dealTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="dealTime" name="dealTime"
	                            			value="${yimiaoProcurecatalogForm.dealTime}" placeholder="<spring:message code="yimiaoProcurecatalog.dealTime"/>" type="text">
			                        </td>
									<th>
										<!-- 处理原因 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.dealReason"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="dealReason" name="dealReason"
	                            			value="${yimiaoProcurecatalogForm.dealReason}" placeholder="<spring:message code="yimiaoProcurecatalog.dealReason"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 记录添加人id -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.addUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserId" name="addUserId"
	                            			value="${yimiaoProcurecatalogForm.addUserId}" placeholder="<spring:message code="yimiaoProcurecatalog.addUserId"/>" type="text">
			                        </td>
									<th>
										<!-- 记录添加人 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.addUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserName" name="addUserName"
	                            			value="${yimiaoProcurecatalogForm.addUserName}" placeholder="<spring:message code="yimiaoProcurecatalog.addUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 记录添加时间 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.addTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addTime" name="addTime"
	                            			value="${yimiaoProcurecatalogForm.addTime}" placeholder="<spring:message code="yimiaoProcurecatalog.addTime"/>" type="text">
			                        </td>
									<th>
										<!-- 最后一次更新记录人id -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.lastUpdateUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserId" name="lastUpdateUserId"
	                            			value="${yimiaoProcurecatalogForm.lastUpdateUserId}" placeholder="<spring:message code="yimiaoProcurecatalog.lastUpdateUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 最后一次更新记录人 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.lastUpdateUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserName" name="lastUpdateUserName"
	                            			value="${yimiaoProcurecatalogForm.lastUpdateUserName}" placeholder="<spring:message code="yimiaoProcurecatalog.lastUpdateUserName"/>" type="text">
			                        </td>
									<th>
										<!-- 最后一次更新记录时间 -->
			                            <label class="control-label "><spring:message code="yimiaoProcurecatalog.lastUpdateTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateTime" name="lastUpdateTime"
	                            			value="${yimiaoProcurecatalogForm.lastUpdateTime}" placeholder="<spring:message code="yimiaoProcurecatalog.lastUpdateTime"/>" type="text">
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
           	     				document.location.href="${ctx }/yimiaoProcurecatalog/toList.html";
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
		document.location.href="${ctx }/yimiaoProcurecatalog/toList.html";
	}
</script>
</html>