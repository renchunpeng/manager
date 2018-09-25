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
				<form role="form" id="addForm" class="form-horizontal" action="addYimiaoOrderdetailRet.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
										<!-- orderdetailRetId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.orderdetailRetId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderdetailRetId" name="orderdetailRetId"
	                            			value="${yimiaoOrderdetailRetForm.orderdetailRetId}" placeholder="<spring:message code="yimiaoOrderdetailRet.orderdetailRetId"/>" type="text">
			                        </td>
									<th>
										<!-- orderId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.orderId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderId" name="orderId"
	                            			value="${yimiaoOrderdetailRetForm.orderId}" placeholder="<spring:message code="yimiaoOrderdetailRet.orderId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- procurecatalogId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.procurecatalogId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="procurecatalogId" name="procurecatalogId"
	                            			value="${yimiaoOrderdetailRetForm.procurecatalogId}" placeholder="<spring:message code="yimiaoOrderdetailRet.procurecatalogId"/>" type="text">
			                        </td>
									<th>
										<!-- goodsId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.goodsId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="goodsId" name="goodsId"
	                            			value="${yimiaoOrderdetailRetForm.goodsId}" placeholder="<spring:message code="yimiaoOrderdetailRet.goodsId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- productName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.productName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productName" name="productName"
	                            			value="${yimiaoOrderdetailRetForm.productName}" placeholder="<spring:message code="yimiaoOrderdetailRet.productName"/>" type="text">
			                        </td>
									<th>
										<!-- productSpelName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.productSpelName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productSpelName" name="productSpelName"
	                            			value="${yimiaoOrderdetailRetForm.productSpelName}" placeholder="<spring:message code="yimiaoOrderdetailRet.productSpelName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- productWbName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.productWbName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productWbName" name="productWbName"
	                            			value="${yimiaoOrderdetailRetForm.productWbName}" placeholder="<spring:message code="yimiaoOrderdetailRet.productWbName"/>" type="text">
			                        </td>
									<th>
										<!-- goodsName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.goodsName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="goodsName" name="goodsName"
	                            			value="${yimiaoOrderdetailRetForm.goodsName}" placeholder="<spring:message code="yimiaoOrderdetailRet.goodsName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- medicinemodel -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.medicinemodel"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="medicinemodel" name="medicinemodel"
	                            			value="${yimiaoOrderdetailRetForm.medicinemodel}" placeholder="<spring:message code="yimiaoOrderdetailRet.medicinemodel"/>" type="text">
			                        </td>
									<th>
										<!-- outlook -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.outlook"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="outlook" name="outlook"
	                            			value="${yimiaoOrderdetailRetForm.outlook}" placeholder="<spring:message code="yimiaoOrderdetailRet.outlook"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- factor -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.factor"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="factor" name="factor"
	                            			value="${yimiaoOrderdetailRetForm.factor}" placeholder="<spring:message code="yimiaoOrderdetailRet.factor"/>" type="text">
			                        </td>
									<th>
										<!-- materialName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.materialName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="materialName" name="materialName"
	                            			value="${yimiaoOrderdetailRetForm.materialName}" placeholder="<spring:message code="yimiaoOrderdetailRet.materialName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- unit -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.unit"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="unit" name="unit"
	                            			value="${yimiaoOrderdetailRetForm.unit}" placeholder="<spring:message code="yimiaoOrderdetailRet.unit"/>" type="text">
			                        </td>
									<th>
										<!-- companyNameSc -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.companyNameSc"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNameSc" name="companyNameSc"
	                            			value="${yimiaoOrderdetailRetForm.companyNameSc}" placeholder="<spring:message code="yimiaoOrderdetailRet.companyNameSc"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- splitCompanyName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.splitCompanyName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="splitCompanyName" name="splitCompanyName"
	                            			value="${yimiaoOrderdetailRetForm.splitCompanyName}" placeholder="<spring:message code="yimiaoOrderdetailRet.splitCompanyName"/>" type="text">
			                        </td>
									<th>
										<!-- trustCompanyName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.trustCompanyName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="trustCompanyName" name="trustCompanyName"
	                            			value="${yimiaoOrderdetailRetForm.trustCompanyName}" placeholder="<spring:message code="yimiaoOrderdetailRet.trustCompanyName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- companyIdTb -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.companyIdTb"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyIdTb" name="companyIdTb"
	                            			value="${yimiaoOrderdetailRetForm.companyIdTb}" placeholder="<spring:message code="yimiaoOrderdetailRet.companyIdTb"/>" type="text">
			                        </td>
									<th>
										<!-- companyNameTb -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.companyNameTb"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNameTb" name="companyNameTb"
	                            			value="${yimiaoOrderdetailRetForm.companyNameTb}" placeholder="<spring:message code="yimiaoOrderdetailRet.companyNameTb"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- middlePack -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.middlePack"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="middlePack" name="middlePack"
	                            			value="${yimiaoOrderdetailRetForm.middlePack}" placeholder="<spring:message code="yimiaoOrderdetailRet.middlePack"/>" type="text">
			                        </td>
									<th>
										<!-- maxPack -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.maxPack"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="maxPack" name="maxPack"
	                            			value="${yimiaoOrderdetailRetForm.maxPack}" placeholder="<spring:message code="yimiaoOrderdetailRet.maxPack"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- isBaseDrug -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.isBaseDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isBaseDrug" name="isBaseDrug"
	                            			value="${yimiaoOrderdetailRetForm.isBaseDrug}" placeholder="<spring:message code="yimiaoOrderdetailRet.isBaseDrug"/>" type="text">
			                        </td>
									<th>
										<!-- qualityLevel -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.qualityLevel"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="qualityLevel" name="qualityLevel"
	                            			value="${yimiaoOrderdetailRetForm.qualityLevel}" placeholder="<spring:message code="yimiaoOrderdetailRet.qualityLevel"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- purchaseType -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.purchaseType"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchaseType" name="purchaseType"
	                            			value="${yimiaoOrderdetailRetForm.purchaseType}" placeholder="<spring:message code="yimiaoOrderdetailRet.purchaseType"/>" type="text">
			                        </td>
									<th>
										<!-- sourceId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.sourceId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sourceId" name="sourceId"
	                            			value="${yimiaoOrderdetailRetForm.sourceId}" placeholder="<spring:message code="yimiaoOrderdetailRet.sourceId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- sourceName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.sourceName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="sourceName" name="sourceName"
	                            			value="${yimiaoOrderdetailRetForm.sourceName}" placeholder="<spring:message code="yimiaoOrderdetailRet.sourceName"/>" type="text">
			                        </td>
									<th>
										<!-- bidPrice -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.bidPrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="bidPrice" name="bidPrice"
	                            			value="${yimiaoOrderdetailRetForm.bidPrice}" placeholder="<spring:message code="yimiaoOrderdetailRet.bidPrice"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- usingRang -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.usingRang"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="usingRang" name="usingRang"
	                            			value="${yimiaoOrderdetailRetForm.usingRang}" placeholder="<spring:message code="yimiaoOrderdetailRet.usingRang"/>" type="text">
			                        </td>
									<th>
										<!-- hospitalId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.hospitalId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalId" name="hospitalId"
	                            			value="${yimiaoOrderdetailRetForm.hospitalId}" placeholder="<spring:message code="yimiaoOrderdetailRet.hospitalId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- hospitalName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.hospitalName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalName" name="hospitalName"
	                            			value="${yimiaoOrderdetailRetForm.hospitalName}" placeholder="<spring:message code="yimiaoOrderdetailRet.hospitalName"/>" type="text">
			                        </td>
									<th>
										<!-- hospitalDepartmentId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.hospitalDepartmentId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalDepartmentId" name="hospitalDepartmentId"
	                            			value="${yimiaoOrderdetailRetForm.hospitalDepartmentId}" placeholder="<spring:message code="yimiaoOrderdetailRet.hospitalDepartmentId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- hospitalDepartmentName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.hospitalDepartmentName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="hospitalDepartmentName" name="hospitalDepartmentName"
	                            			value="${yimiaoOrderdetailRetForm.hospitalDepartmentName}" placeholder="<spring:message code="yimiaoOrderdetailRet.hospitalDepartmentName"/>" type="text">
			                        </td>
									<th>
										<!-- adminAreaIdStatisticsDrug -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.adminAreaIdStatisticsDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="adminAreaIdStatisticsDrug" name="adminAreaIdStatisticsDrug"
	                            			value="${yimiaoOrderdetailRetForm.adminAreaIdStatisticsDrug}" placeholder="<spring:message code="yimiaoOrderdetailRet.adminAreaIdStatisticsDrug"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- adminAreaNameDrug -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.adminAreaNameDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="adminAreaNameDrug" name="adminAreaNameDrug"
	                            			value="${yimiaoOrderdetailRetForm.adminAreaNameDrug}" placeholder="<spring:message code="yimiaoOrderdetailRet.adminAreaNameDrug"/>" type="text">
			                        </td>
									<th>
										<!-- adminAreaIdDrug -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.adminAreaIdDrug"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="adminAreaIdDrug" name="adminAreaIdDrug"
	                            			value="${yimiaoOrderdetailRetForm.adminAreaIdDrug}" placeholder="<spring:message code="yimiaoOrderdetailRet.adminAreaIdDrug"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- belongOrgName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.belongOrgName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="belongOrgName" name="belongOrgName"
	                            			value="${yimiaoOrderdetailRetForm.belongOrgName}" placeholder="<spring:message code="yimiaoOrderdetailRet.belongOrgName"/>" type="text">
			                        </td>
									<th>
										<!-- orderType -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.orderType"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderType" name="orderType"
	                            			value="${yimiaoOrderdetailRetForm.orderType}" placeholder="<spring:message code="yimiaoOrderdetailRet.orderType"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- orderName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.orderName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderName" name="orderName"
	                            			value="${yimiaoOrderdetailRetForm.orderName}" placeholder="<spring:message code="yimiaoOrderdetailRet.orderName"/>" type="text">
			                        </td>
									<th>
										<!-- submitTime -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.submitTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="submitTime" name="submitTime"
	                            			value="${yimiaoOrderdetailRetForm.submitTime}" placeholder="<spring:message code="yimiaoOrderdetailRet.submitTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- filingId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.filingId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="filingId" name="filingId"
	                            			value="${yimiaoOrderdetailRetForm.filingId}" placeholder="<spring:message code="yimiaoOrderdetailRet.filingId"/>" type="text">
			                        </td>
									<th>
										<!-- companyIdPs -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.companyIdPs"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyIdPs" name="companyIdPs"
	                            			value="${yimiaoOrderdetailRetForm.companyIdPs}" placeholder="<spring:message code="yimiaoOrderdetailRet.companyIdPs"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- companyNamePs -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.companyNamePs"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="companyNamePs" name="companyNamePs"
	                            			value="${yimiaoOrderdetailRetForm.companyNamePs}" placeholder="<spring:message code="yimiaoOrderdetailRet.companyNamePs"/>" type="text">
			                        </td>
									<th>
										<!-- purchasePrice -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.purchasePrice"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchasePrice" name="purchasePrice"
	                            			value="${yimiaoOrderdetailRetForm.purchasePrice}" placeholder="<spring:message code="yimiaoOrderdetailRet.purchasePrice"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- purchaseCount -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.purchaseCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchaseCount" name="purchaseCount"
	                            			value="${yimiaoOrderdetailRetForm.purchaseCount}" placeholder="<spring:message code="yimiaoOrderdetailRet.purchaseCount"/>" type="text">
			                        </td>
									<th>
										<!-- purchaseAmount -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.purchaseAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="purchaseAmount" name="purchaseAmount"
	                            			value="${yimiaoOrderdetailRetForm.purchaseAmount}" placeholder="<spring:message code="yimiaoOrderdetailRet.purchaseAmount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- isRead -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.isRead"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isRead" name="isRead"
	                            			value="${yimiaoOrderdetailRetForm.isRead}" placeholder="<spring:message code="yimiaoOrderdetailRet.isRead"/>" type="text">
			                        </td>
									<th>
										<!-- readUserId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.readUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="readUserId" name="readUserId"
	                            			value="${yimiaoOrderdetailRetForm.readUserId}" placeholder="<spring:message code="yimiaoOrderdetailRet.readUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- readUserName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.readUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="readUserName" name="readUserName"
	                            			value="${yimiaoOrderdetailRetForm.readUserName}" placeholder="<spring:message code="yimiaoOrderdetailRet.readUserName"/>" type="text">
			                        </td>
									<th>
										<!-- readTime -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.readTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="readTime" name="readTime"
	                            			value="${yimiaoOrderdetailRetForm.readTime}" placeholder="<spring:message code="yimiaoOrderdetailRet.readTime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- confirmUserId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.confirmUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmUserId" name="confirmUserId"
	                            			value="${yimiaoOrderdetailRetForm.confirmUserId}" placeholder="<spring:message code="yimiaoOrderdetailRet.confirmUserId"/>" type="text">
			                        </td>
									<th>
										<!-- confirmUserName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.confirmUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmUserName" name="confirmUserName"
	                            			value="${yimiaoOrderdetailRetForm.confirmUserName}" placeholder="<spring:message code="yimiaoOrderdetailRet.confirmUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- confirmTime -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.confirmTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmTime" name="confirmTime"
	                            			value="${yimiaoOrderdetailRetForm.confirmTime}" placeholder="<spring:message code="yimiaoOrderdetailRet.confirmTime"/>" type="text">
			                        </td>
									<th>
										<!-- confirmState -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.confirmState"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="confirmState" name="confirmState"
	                            			value="${yimiaoOrderdetailRetForm.confirmState}" placeholder="<spring:message code="yimiaoOrderdetailRet.confirmState"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- orderdetailState -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.orderdetailState"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderdetailState" name="orderdetailState"
	                            			value="${yimiaoOrderdetailRetForm.orderdetailState}" placeholder="<spring:message code="yimiaoOrderdetailRet.orderdetailState"/>" type="text">
			                        </td>
									<th>
										<!-- refuseReason -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.refuseReason"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="refuseReason" name="refuseReason"
	                            			value="${yimiaoOrderdetailRetForm.refuseReason}" placeholder="<spring:message code="yimiaoOrderdetailRet.refuseReason"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- detailDistributeAddress -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.detailDistributeAddress"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="detailDistributeAddress" name="detailDistributeAddress"
	                            			value="${yimiaoOrderdetailRetForm.detailDistributeAddress}" placeholder="<spring:message code="yimiaoOrderdetailRet.detailDistributeAddress"/>" type="text">
			                        </td>
									<th>
										<!-- totalDistributeCount -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.totalDistributeCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalDistributeCount" name="totalDistributeCount"
	                            			value="${yimiaoOrderdetailRetForm.totalDistributeCount}" placeholder="<spring:message code="yimiaoOrderdetailRet.totalDistributeCount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- totalDistributeAmount -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.totalDistributeAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalDistributeAmount" name="totalDistributeAmount"
	                            			value="${yimiaoOrderdetailRetForm.totalDistributeAmount}" placeholder="<spring:message code="yimiaoOrderdetailRet.totalDistributeAmount"/>" type="text">
			                        </td>
									<th>
										<!-- totalWarehouseCount -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.totalWarehouseCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalWarehouseCount" name="totalWarehouseCount"
	                            			value="${yimiaoOrderdetailRetForm.totalWarehouseCount}" placeholder="<spring:message code="yimiaoOrderdetailRet.totalWarehouseCount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- totalWarehouseAmount -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.totalWarehouseAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalWarehouseAmount" name="totalWarehouseAmount"
	                            			value="${yimiaoOrderdetailRetForm.totalWarehouseAmount}" placeholder="<spring:message code="yimiaoOrderdetailRet.totalWarehouseAmount"/>" type="text">
			                        </td>
									<th>
										<!-- totalReturnAmount -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.totalReturnAmount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalReturnAmount" name="totalReturnAmount"
	                            			value="${yimiaoOrderdetailRetForm.totalReturnAmount}" placeholder="<spring:message code="yimiaoOrderdetailRet.totalReturnAmount"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- totalReturnCount -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.totalReturnCount"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="totalReturnCount" name="totalReturnCount"
	                            			value="${yimiaoOrderdetailRetForm.totalReturnCount}" placeholder="<spring:message code="yimiaoOrderdetailRet.totalReturnCount"/>" type="text">
			                        </td>
									<th>
										<!-- isUsing -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.isUsing"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="isUsing" name="isUsing"
	                            			value="${yimiaoOrderdetailRetForm.isUsing}" placeholder="<spring:message code="yimiaoOrderdetailRet.isUsing"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- compRatio -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.compRatio"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="compRatio" name="compRatio"
	                            			value="${yimiaoOrderdetailRetForm.compRatio}" placeholder="<spring:message code="yimiaoOrderdetailRet.compRatio"/>" type="text">
			                        </td>
									<th>
										<!-- orderCustomInfo -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.orderCustomInfo"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="orderCustomInfo" name="orderCustomInfo"
	                            			value="${yimiaoOrderdetailRetForm.orderCustomInfo}" placeholder="<spring:message code="yimiaoOrderdetailRet.orderCustomInfo"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- addUserId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.addUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserId" name="addUserId"
	                            			value="${yimiaoOrderdetailRetForm.addUserId}" placeholder="<spring:message code="yimiaoOrderdetailRet.addUserId"/>" type="text">
			                        </td>
									<th>
										<!-- addUserName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.addUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUserName" name="addUserName"
	                            			value="${yimiaoOrderdetailRetForm.addUserName}" placeholder="<spring:message code="yimiaoOrderdetailRet.addUserName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- addTime -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.addTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addTime" name="addTime"
	                            			value="${yimiaoOrderdetailRetForm.addTime}" placeholder="<spring:message code="yimiaoOrderdetailRet.addTime"/>" type="text">
			                        </td>
									<th>
										<!-- lastUpdateUserId -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.lastUpdateUserId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserId" name="lastUpdateUserId"
	                            			value="${yimiaoOrderdetailRetForm.lastUpdateUserId}" placeholder="<spring:message code="yimiaoOrderdetailRet.lastUpdateUserId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- lastUpdateUserName -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.lastUpdateUserName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateUserName" name="lastUpdateUserName"
	                            			value="${yimiaoOrderdetailRetForm.lastUpdateUserName}" placeholder="<spring:message code="yimiaoOrderdetailRet.lastUpdateUserName"/>" type="text">
			                        </td>
									<th>
										<!-- lastUpdateTime -->
			                            <label class="control-label "><spring:message code="yimiaoOrderdetailRet.lastUpdateTime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastUpdateTime" name="lastUpdateTime"
	                            			value="${yimiaoOrderdetailRetForm.lastUpdateTime}" placeholder="<spring:message code="yimiaoOrderdetailRet.lastUpdateTime"/>" type="text">
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
           	     				document.location.href="${ctx }/yimiaoOrderdetailRet/toList.html";
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
		document.location.href="${ctx }/yimiaoOrderdetailRet/toList.html";
	}
</script>
</html>