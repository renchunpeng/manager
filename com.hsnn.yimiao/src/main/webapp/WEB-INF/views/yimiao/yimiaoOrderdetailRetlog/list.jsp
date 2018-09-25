<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<form action="${ctx }/yimiaoOrderdetailRetlog/getYimiaoOrderdetailRetlogData.html" id="searchForm" method="post" >
					<div class="input">
						<div class="textalign1">查询条件1<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="***" name="***"  placeholder="查询条件1" maxlength="50" />
	                    </div>
	                    <div class="textalign">查询条件2<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="***" name="***"  placeholder="查询条件2" maxlength="50" />
	                    </div>
	                    <div class="textalign">查询条件3<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="***" name="***"  placeholder="查询条件3" maxlength="50" />
	                    </div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var obj ={
		"names": [
			'<spring:message code="message.jqGrid.cz"/>',
			'<spring:message code="yimiaoOrderdetailRetlog.logId"/>',<!-- order_detail_id（有序guid编号） -->
			'<spring:message code="yimiaoOrderdetailRetlog.orderdetailRetId"/>',<!-- order_detail_id（有序guid编号） -->
			'<spring:message code="yimiaoOrderdetailRetlog.orderId"/>',<!-- order_id（有序guid编号） -->
			'<spring:message code="yimiaoOrderdetailRetlog.procurecatalogId"/>',<!-- 商品Id -->
			'<spring:message code="yimiaoOrderdetailRetlog.goodsId"/>',<!-- 产品代码 -->
			'<spring:message code="yimiaoOrderdetailRetlog.productName"/>',<!-- 通用名 -->
			'<spring:message code="yimiaoOrderdetailRetlog.productSpelName"/>',<!-- 通用名拼音码 -->
			'<spring:message code="yimiaoOrderdetailRetlog.productWbName"/>',<!-- 通用名五笔码 -->
			'<spring:message code="yimiaoOrderdetailRetlog.goodsName"/>',<!-- 商品名 -->
			'<spring:message code="yimiaoOrderdetailRetlog.medicinemodel"/>',<!-- 剂型 -->
			'<spring:message code="yimiaoOrderdetailRetlog.outlook"/>',<!-- 规格 -->
			'<spring:message code="yimiaoOrderdetailRetlog.factor"/>',<!-- 转换比 -->
			'<spring:message code="yimiaoOrderdetailRetlog.materialName"/>',<!-- 包装材质 -->
			'<spring:message code="yimiaoOrderdetailRetlog.unit"/>',<!-- 单位 -->
			'<spring:message code="yimiaoOrderdetailRetlog.companyNameSc"/>',<!-- 生产企业名称 -->
			'<spring:message code="yimiaoOrderdetailRetlog.splitCompanyName"/>',<!-- 分包装企业 -->
			'<spring:message code="yimiaoOrderdetailRetlog.trustCompanyName"/>',<!-- 委托加工企业 -->
			'<spring:message code="yimiaoOrderdetailRetlog.companyIdTb"/>',<!-- 投标企业编号 -->
			'<spring:message code="yimiaoOrderdetailRetlog.companyNameTb"/>',<!-- 投标企业名称 -->
			'<spring:message code="yimiaoOrderdetailRetlog.middlePack"/>',<!-- 中包装 -->
			'<spring:message code="yimiaoOrderdetailRetlog.maxPack"/>',<!-- 大包装 -->
			'<spring:message code="yimiaoOrderdetailRetlog.isBaseDrug"/>',<!-- 是否基药(0:否,1:是) -->
			'<spring:message code="yimiaoOrderdetailRetlog.qualityLevel"/>',<!-- 质量层次 -->
			'<spring:message code="yimiaoOrderdetailRetlog.purchaseType"/>',<!-- 采购类别(0:中标药品，1：廉价药品，2：紧张药品，3：低价药品，4：备案药品) -->
			'<spring:message code="yimiaoOrderdetailRetlog.sourceId"/>',<!-- 来源id -->
			'<spring:message code="yimiaoOrderdetailRetlog.sourceName"/>',<!-- 来源名称 -->
			'<spring:message code="yimiaoOrderdetailRetlog.bidPrice"/>',<!-- 中标价格(采购类别为中标类的,写入.其他的写0) -->
			'<spring:message code="yimiaoOrderdetailRetlog.usingRang"/>',<!-- 使用范围（0：县上，1：基层，2：全省） -->
			'<spring:message code="yimiaoOrderdetailRetlog.hospitalId"/>',<!-- 医疗机构编号 -->
			'<spring:message code="yimiaoOrderdetailRetlog.hospitalName"/>',<!-- 医疗机构名称 -->
			'<spring:message code="yimiaoOrderdetailRetlog.hospitalDepartmentId"/>',<!-- 医疗机构部门编号 -->
			'<spring:message code="yimiaoOrderdetailRetlog.hospitalDepartmentName"/>',<!-- 医疗机构部门名称 -->
			'<spring:message code="yimiaoOrderdetailRetlog.adminAreaIdStatisticsDrug"/>',<!-- 药品行政区域id统计 -->
			'<spring:message code="yimiaoOrderdetailRetlog.adminAreaNameDrug"/>',<!-- 药品行政区域名称 -->
			'<spring:message code="yimiaoOrderdetailRetlog.adminAreaIdDrug"/>',<!-- 药品行政区域id -->
			'<spring:message code="yimiaoOrderdetailRetlog.belongOrgName"/>',<!-- 所属行政机构名称 -->
			'<spring:message code="yimiaoOrderdetailRetlog.orderType"/>',<!-- 订单类型（0：正常订单，1：急救药品临时订单） -->
			'<spring:message code="yimiaoOrderdetailRetlog.orderName"/>',<!-- 订单名称 -->
			'<spring:message code="yimiaoOrderdetailRetlog.submitTime"/>',<!-- 提交时间 -->
			'<spring:message code="yimiaoOrderdetailRetlog.filingId"/>',<!-- 备案编号(单内删除时,还原相应记录为未采购) -->
			'<spring:message code="yimiaoOrderdetailRetlog.companyIdPs"/>',<!-- 配送企业编号 -->
			'<spring:message code="yimiaoOrderdetailRetlog.companyNamePs"/>',<!-- 配送企业名称 -->
			'<spring:message code="yimiaoOrderdetailRetlog.purchasePrice"/>',<!-- 采购价格 -->
			'<spring:message code="yimiaoOrderdetailRetlog.purchaseCount"/>',<!-- 采购数量 -->
			'<spring:message code="yimiaoOrderdetailRetlog.purchaseAmount"/>',<!-- purchaseAmount -->
			'<spring:message code="yimiaoOrderdetailRetlog.isRead"/>',<!-- 是否已阅读 -->
			'<spring:message code="yimiaoOrderdetailRetlog.readUserId"/>',<!-- readUserId -->
			'<spring:message code="yimiaoOrderdetailRetlog.readUserName"/>',<!-- 阅读人 -->
			'<spring:message code="yimiaoOrderdetailRetlog.readTime"/>',<!-- 阅读时间 -->
			'<spring:message code="yimiaoOrderdetailRetlog.confirmUserId"/>',<!-- 确认人Id -->
			'<spring:message code="yimiaoOrderdetailRetlog.confirmUserName"/>',<!-- 确认人 -->
			'<spring:message code="yimiaoOrderdetailRetlog.confirmTime"/>',<!-- 确认时间 -->
			'<spring:message code="yimiaoOrderdetailRetlog.confirmState"/>',<!-- 确认状态 0 - 待处理 1 - 供货 2 - 不供货 -->
			'<spring:message code="yimiaoOrderdetailRetlog.orderdetailState"/>',<!-- 采购明细状态（0 已保存待提交 1已提交待确认 2已确认待配送 3 拒绝确认4 已配送待收货5 拒绝配送 6 未及时配送 7 收货中 8 已收货 9 已撤单 ） -->
			'<spring:message code="yimiaoOrderdetailRetlog.refuseReason"/>',<!-- 拒绝理由 -->
			'<spring:message code="yimiaoOrderdetailRetlog.detailDistributeAddress"/>',<!-- 订单明细配送地址 -->
			'<spring:message code="yimiaoOrderdetailRetlog.totalDistributeCount"/>',<!-- 总配送数量 -->
			'<spring:message code="yimiaoOrderdetailRetlog.totalDistributeAmount"/>',<!-- 总配送金额 -->
			'<spring:message code="yimiaoOrderdetailRetlog.totalWarehouseCount"/>',<!-- 总收货数量 -->
			'<spring:message code="yimiaoOrderdetailRetlog.totalWarehouseAmount"/>',<!-- 总收货金额 -->
			'<spring:message code="yimiaoOrderdetailRetlog.totalReturnAmount"/>',<!-- 总退货金额 -->
			'<spring:message code="yimiaoOrderdetailRetlog.totalReturnCount"/>',<!-- 总退货数量 -->
			'<spring:message code="yimiaoOrderdetailRetlog.isUsing"/>',<!-- 是否启用 -->
			'<spring:message code="yimiaoOrderdetailRetlog.compRatio"/>',<!-- 处理原因 -->
			'<spring:message code="yimiaoOrderdetailRetlog.orderCustomInfo"/>',<!-- 订单自定义信息 -->
			'<spring:message code="yimiaoOrderdetailRetlog.addUserId"/>',<!-- 记录添加人id -->
			'<spring:message code="yimiaoOrderdetailRetlog.addUserName"/>',<!-- 记录添加人 -->
			'<spring:message code="yimiaoOrderdetailRetlog.addTime"/>',<!-- 记录添加时间 -->
			'<spring:message code="yimiaoOrderdetailRetlog.lastUpdateUserId"/>',<!-- 最后一次更新记录人id -->
			'<spring:message code="yimiaoOrderdetailRetlog.lastUpdateUserName"/>',<!-- 最后一次更新记录人 -->
			'<spring:message code="yimiaoOrderdetailRetlog.lastUpdateTime"/>',<!-- 最后一次更新记录时间 -->
			'<spring:message code="yimiaoOrderdetailRetlog.companyIdSc"/>',<!-- companyIdSc -->
        ],
        "model": [
			{ name: 'operate', width: 40, align: 'center',sortable: false,
            	formatter:function(val, opts, rowdata){
                	var str =  "<a href='${ctx }/yimiaoOrderdetailRetlog/toUpdate.html?orderdetailRetId=" + rowdata.orderdetailRetId + "' style='background:url(${ctx }/lib/img/icon/icon.png) no-repeat 0px 0px' class='opIcon' title='更新'></a>";
                	return str;
                }
        	},
		        { name: "logId", sortable: false},<!-- order_detail_id（有序guid编号） -->
		        { name: "orderdetailRetId", key:true, sortable: false},<!-- order_detail_id（有序guid编号） -->
		        { name: "orderId", sortable: false},<!-- order_id（有序guid编号） -->
		        { name: "procurecatalogId", sortable: false},<!-- 商品Id -->
		        { name: "goodsId", sortable: false},<!-- 产品代码 -->
		        { name: "productName", sortable: false},<!-- 通用名 -->
		        { name: "productSpelName", sortable: false},<!-- 通用名拼音码 -->
		        { name: "productWbName", sortable: false},<!-- 通用名五笔码 -->
		        { name: "goodsName", sortable: false},<!-- 商品名 -->
		        { name: "medicinemodel", sortable: false},<!-- 剂型 -->
		        { name: "outlook", sortable: false},<!-- 规格 -->
		        { name: "factor", sortable: false},<!-- 转换比 -->
		        { name: "materialName", sortable: false},<!-- 包装材质 -->
		        { name: "unit", sortable: false},<!-- 单位 -->
		        { name: "companyNameSc", sortable: false},<!-- 生产企业名称 -->
		        { name: "splitCompanyName", sortable: false},<!-- 分包装企业 -->
		        { name: "trustCompanyName", sortable: false},<!-- 委托加工企业 -->
		        { name: "companyIdTb", sortable: false},<!-- 投标企业编号 -->
		        { name: "companyNameTb", sortable: false},<!-- 投标企业名称 -->
		        { name: "middlePack", sortable: false},<!-- 中包装 -->
		        { name: "maxPack", sortable: false},<!-- 大包装 -->
		        { name: "isBaseDrug", sortable: false},<!-- 是否基药(0:否,1:是) -->
		        { name: "qualityLevel", sortable: false},<!-- 质量层次 -->
		        { name: "purchaseType", sortable: false},<!-- 采购类别(0:中标药品，1：廉价药品，2：紧张药品，3：低价药品，4：备案药品) -->
		        { name: "sourceId", sortable: false},<!-- 来源id -->
		        { name: "sourceName", sortable: false},<!-- 来源名称 -->
		        { name: "bidPrice", sortable: false},<!-- 中标价格(采购类别为中标类的,写入.其他的写0) -->
		        { name: "usingRang", sortable: false},<!-- 使用范围（0：县上，1：基层，2：全省） -->
		        { name: "hospitalId", sortable: false},<!-- 医疗机构编号 -->
		        { name: "hospitalName", sortable: false},<!-- 医疗机构名称 -->
		        { name: "hospitalDepartmentId", sortable: false},<!-- 医疗机构部门编号 -->
		        { name: "hospitalDepartmentName", sortable: false},<!-- 医疗机构部门名称 -->
		        { name: "adminAreaIdStatisticsDrug", sortable: false},<!-- 药品行政区域id统计 -->
		        { name: "adminAreaNameDrug", sortable: false},<!-- 药品行政区域名称 -->
		        { name: "adminAreaIdDrug", sortable: false},<!-- 药品行政区域id -->
		        { name: "belongOrgName", sortable: false},<!-- 所属行政机构名称 -->
		        { name: "orderType", sortable: false},<!-- 订单类型（0：正常订单，1：急救药品临时订单） -->
		        { name: "orderName", sortable: false},<!-- 订单名称 -->
		        { name: "submitTime", sortable: false},<!-- 提交时间 -->
		        { name: "filingId", sortable: false},<!-- 备案编号(单内删除时,还原相应记录为未采购) -->
		        { name: "companyIdPs", sortable: false},<!-- 配送企业编号 -->
		        { name: "companyNamePs", sortable: false},<!-- 配送企业名称 -->
		        { name: "purchasePrice", sortable: false},<!-- 采购价格 -->
		        { name: "purchaseCount", sortable: false},<!-- 采购数量 -->
		        { name: "purchaseAmount", sortable: false},<!-- purchaseAmount -->
		        { name: "isRead", sortable: false},<!-- 是否已阅读 -->
		        { name: "readUserId", sortable: false},<!-- readUserId -->
		        { name: "readUserName", sortable: false},<!-- 阅读人 -->
		        { name: "readTime", sortable: false},<!-- 阅读时间 -->
		        { name: "confirmUserId", sortable: false},<!-- 确认人Id -->
		        { name: "confirmUserName", sortable: false},<!-- 确认人 -->
		        { name: "confirmTime", sortable: false},<!-- 确认时间 -->
		        { name: "confirmState", sortable: false},<!-- 确认状态 0 - 待处理 1 - 供货 2 - 不供货 -->
		        { name: "orderdetailState", sortable: false},<!-- 采购明细状态（0 已保存待提交 1已提交待确认 2已确认待配送 3 拒绝确认4 已配送待收货5 拒绝配送 6 未及时配送 7 收货中 8 已收货 9 已撤单 ） -->
		        { name: "refuseReason", sortable: false},<!-- 拒绝理由 -->
		        { name: "detailDistributeAddress", sortable: false},<!-- 订单明细配送地址 -->
		        { name: "totalDistributeCount", sortable: false},<!-- 总配送数量 -->
		        { name: "totalDistributeAmount", sortable: false},<!-- 总配送金额 -->
		        { name: "totalWarehouseCount", sortable: false},<!-- 总收货数量 -->
		        { name: "totalWarehouseAmount", sortable: false},<!-- 总收货金额 -->
		        { name: "totalReturnAmount", sortable: false},<!-- 总退货金额 -->
		        { name: "totalReturnCount", sortable: false},<!-- 总退货数量 -->
		        { name: "isUsing", sortable: false},<!-- 是否启用 -->
		        { name: "compRatio", sortable: false},<!-- 处理原因 -->
		        { name: "orderCustomInfo", sortable: false},<!-- 订单自定义信息 -->
		        { name: "addUserId", sortable: false},<!-- 记录添加人id -->
		        { name: "addUserName", sortable: false},<!-- 记录添加人 -->
		        { name: "addTime", sortable: false},<!-- 记录添加时间 -->
		        { name: "lastUpdateUserId", sortable: false},<!-- 最后一次更新记录人id -->
		        { name: "lastUpdateUserName", sortable: false},<!-- 最后一次更新记录人 -->
		        { name: "lastUpdateTime", sortable: false},<!-- 最后一次更新记录时间 -->
		        { name: "companyIdSc", sortable: false},<!-- companyIdSc -->
        ]      
	};
	
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoOrderdetailRetlog/getYimiaoOrderdetailRetlogData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
             caption: "" 
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoOrderdetailRetlog/getYimiaoOrderdetailRetlogData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
</script>
</html>