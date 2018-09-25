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
				<form action="${ctx }/yimiaoPurchaseOrder/getYimiaoOrderdetailData.html" id="searchForm" method="post" >
					<div class="input">
					 <input type="text" class="textinput"  id="orderId" name="orderId" value="${orderId}" placeholder="查询条件1" maxlength="50" hidden="true" />
						<div class="textalign1">疫苗名称<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="procurecatalogId" name="procurecatalogId"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign">生产企业名称<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="生产企业名称" maxlength="50" />
	                    </div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
			<button id="toadd" type="button" class="btn btn-success btn-sm" onclick="goAdd();">新增</button>
			<button id="godelete" type="button" class="btn btn-success btn-sm" onclick="goDelete();">删除</button>
			<button id="back" type="button" class="btn btn-success btn-sm" onclick="goback();">返回</button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var obj ={
		"names": [
			'操作',
			'订单时间',
			'订单明细编号',
			'订单号',
			'疫苗编号',
			'采购单位',
			'疫苗名称',
			/* '<spring:message code="yimiaoOrderdetail.productSpelName"/>',
			'<spring:message code="yimiaoOrderdetail.productWbName"/>',*/
			'商品名',
			'剂型',
			'生产企业名称',	
			'规格',
			'最小制剂单位',
			'采购价格',
			'采购数量',
			'采购总金额',
			'备注',
/* 			'<spring:message code="yimiaoOrderdetail.splitCompanyName"/>',
			'<spring:message code="yimiaoOrderdetail.trustCompanyName"/>',
			'<spring:message code="yimiaoOrderdetail.companyIdTb"/>',<!-- 投标企业编号 -->
			'<spring:message code="yimiaoOrderdetail.companyNameTb"/>',<!-- 投标企业名称 -->
			'<spring:message code="yimiaoOrderdetail.middlePack"/>',<!-- 中包装 -->
			'<spring:message code="yimiaoOrderdetail.maxPack"/>',<!-- 大包装 -->
			'<spring:message code="yimiaoOrderdetail.isBaseDrug"/>',<!-- 是否基药(0:否,1:是) -->
			'<spring:message code="yimiaoOrderdetail.qualityLevel"/>',<!-- 质量层次 -->
			'<spring:message code="yimiaoOrderdetail.purchaseType"/>',<!-- 采购类别(0:中标药品，1：廉价药品，2：紧张药品，3：低价药品，4：备案药品) -->
			'<spring:message code="yimiaoOrderdetail.sourceId"/>',<!-- 来源id -->
			'<spring:message code="yimiaoOrderdetail.sourceName"/>',<!-- 来源名称 -->
			'<spring:message code="yimiaoOrderdetail.bidPrice"/>',<!-- 中标价格(采购类别为中标类的,写入.其他的写0) -->
			'<spring:message code="yimiaoOrderdetail.usingRang"/>',<!-- 使用范围（0：县上，1：基层，2：全省） -->
			'<spring:message code="yimiaoOrderdetail.hospitalId"/>',<!-- 医疗机构编号 -->
			'<spring:message code="yimiaoOrderdetail.hospitalDepartmentId"/>',<!-- 医疗机构部门编号 -->
			'<spring:message code="yimiaoOrderdetail.hospitalDepartmentName"/>',<!-- 医疗机构部门名称 -->
			'<spring:message code="yimiaoOrderdetail.adminAreaIdStatisticsDrug"/>',<!-- 药品行政区域id统计 -->
			'<spring:message code="yimiaoOrderdetail.adminAreaNameDrug"/>',<!-- 药品行政区域名称 -->
			'<spring:message code="yimiaoOrderdetail.adminAreaIdDrug"/>',<!-- 药品行政区域id -->
			'<spring:message code="yimiaoOrderdetail.belongOrgName"/>',<!-- 所属行政机构名称 -->
			'<spring:message code="yimiaoOrderdetail.orderType"/>',<!-- 订单类型（0：正常订单，1：急救药品临时订单） -->
			'<spring:message code="yimiaoOrderdetail.orderName"/>',<!-- 订单名称 -->
			'<spring:message code="yimiaoOrderdetail.filingId"/>',<!-- 备案编号(单内删除时,还原相应记录为未采购) -->
			'<spring:message code="yimiaoOrderdetail.companyIdPs"/>',<!-- 配送企业编号 -->
			'<spring:message code="yimiaoOrderdetail.companyNamePs"/>',<!-- 配送企业名称 -->
			'<spring:message code="yimiaoOrderdetail.purchasePrice"/>',<!-- 采购价格 -->
			'<spring:message code="yimiaoOrderdetail.purchaseCount"/>',<!-- 采购数量 -->
			'<spring:message code="yimiaoOrderdetail.purchaseAmount"/>',<!-- 采购总金额 -->
			'<spring:message code="yimiaoOrderdetail.isRead"/>',<!-- 是否已阅读 -->
			'<spring:message code="yimiaoOrderdetail.readUserId"/>',<!-- readUserId -->
			'<spring:message code="yimiaoOrderdetail.readUserName"/>',<!-- 阅读人 -->
			'<spring:message code="yimiaoOrderdetail.readTime"/>',<!-- 阅读时间 -->
			'<spring:message code="yimiaoOrderdetail.confirmUserId"/>',<!-- 确认人Id -->
			'<spring:message code="yimiaoOrderdetail.confirmUserName"/>',<!-- 确认人 -->
			'<spring:message code="yimiaoOrderdetail.confirmTime"/>',<!-- 确认时间 -->
			'<spring:message code="yimiaoOrderdetail.confirmState"/>',<!-- 确认状态 0 - 待处理 1 - 供货 2 - 不供货 -->
			'<spring:message code="yimiaoOrderdetail.orderdetailState"/>',<!-- 采购明细状态（0 已保存待提交 1已提交待确认 2已确认待配送 3 拒绝确认4 已配送待收货5 拒绝配送 6 未及时配送 7 收货中 8 已收货 9 已撤单 ） -->
			'<spring:message code="yimiaoOrderdetail.refuseReason"/>',<!-- 拒绝理由 -->
			'<spring:message code="yimiaoOrderdetail.detailDistributeAddress"/>',<!-- 订单明细配送地址 -->
			'<spring:message code="yimiaoOrderdetail.totalDistributeCount"/>',<!-- 总配送数量 -->
			'<spring:message code="yimiaoOrderdetail.totalDistributeAmount"/>',<!-- 总配送金额 -->
			'<spring:message code="yimiaoOrderdetail.totalWarehouseCount"/>',<!-- 总收货数量 -->
			'<spring:message code="yimiaoOrderdetail.totalWarehouseAmount"/>',<!-- 总收货金额 -->
			'<spring:message code="yimiaoOrderdetail.totalReturnAmount"/>',<!-- 总退货金额 -->
			'<spring:message code="yimiaoOrderdetail.totalReturnCount"/>',<!-- 总退货数量 -->
			'<spring:message code="yimiaoOrderdetail.isUsing"/>',<!-- 是否启用 -->
			'<spring:message code="yimiaoOrderdetail.compRatio"/>',<!-- 完成率 -->
			'<spring:message code="yimiaoOrderdetail.addUserId"/>',<!-- 记录添加人id -->
			'<spring:message code="yimiaoOrderdetail.addUserName"/>',<!-- 记录添加人 -->
			'<spring:message code="yimiaoOrderdetail.addTime"/>',<!-- 记录添加时间 -->
			'<spring:message code="yimiaoOrderdetail.lastUpdateUserId"/>',<!-- 最后一次更新记录人id -->
			'<spring:message code="yimiaoOrderdetail.lastUpdateUserName"/>',<!-- 最后一次更新记录人 -->
			'<spring:message code="yimiaoOrderdetail.lastUpdateTime"/>',<!-- 最后一次更新记录时间 --> */
        ],
        "model": [
				{ name: 'operate', width: 80,key:true,sortable: false,
            	formatter:function(val, opts, rowdata){
            		var str =  "<a href='${ctx }/yimiaoOrderdetail/getDelete.html?orderdetailId=" + rowdata.orderdetailId + "' >删除</a>";
                	return str;
           	     }
        		},
        		{ name: "submitTime", sortable: false},
		        { name: "orderdetailId", key:true, sortable: false,hidden:true},
		        { name: "orderId", sortable: false,hidden:true},
		        { name: "goodsId", sortable: false,hidden:true},
		        { name: "hospitalName", sortable: false},
		        { name: "productName", sortable: false},
		   /*   { name: "productSpelName", sortable: false},<!-- 通用名拼音码 -->
		        { name: "productWbName", sortable: false},<!-- 通用名五笔码 --> */
		        { name: "goodsName", sortable: false},
		        { name: "medicinemodel", sortable: false,hidden:true},
		        { name: "outlook", sortable: false},
		        { name: "companyNameSc", sortable: false},
		        { name: "unit", sortable: false},
		        { name: "purchasePrice", sortable: false},
		        { name: "purchaseCount", sortable: false},
		        { name: "purchaseAmount", sortable: false},
		        { name: "orderCustomInfo", sortable: false},
		    /*  { name: "splitCompanyName", sortable: false},<!-- 分包装企业 -->
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
		        { name: "hospitalDepartmentId", sortable: false},<!-- 医疗机构部门编号 -->
		        { name: "hospitalDepartmentName", sortable: false},<!-- 医疗机构部门名称 -->
		        { name: "adminAreaIdStatisticsDrug", sortable: false},<!-- 药品行政区域id统计 -->
		        { name: "adminAreaNameDrug", sortable: false},<!-- 药品行政区域名称 -->
		        { name: "adminAreaIdDrug", sortable: false},<!-- 药品行政区域id -->
		        { name: "belongOrgName", sortable: false},<!-- 所属行政机构名称 -->
		        { name: "orderType", sortable: false},<!-- 订单类型（0：正常订单，1：急救药品临时订单） -->
		        { name: "orderName", sortable: false},<!-- 订单名称 -->
		        { name: "filingId", sortable: false},<!-- 备案编号(单内删除时,还原相应记录为未采购) -->
		        { name: "companyIdPs", sortable: false},<!-- 配送企业编号 -->
		        { name: "companyNamePs", sortable: false},<!-- 配送企业名称 -->
		        { name: "purchasePrice", sortable: false},<!-- 采购价格 -->
		        { name: "purchaseCount", sortable: false},<!-- 采购数量 -->
		        { name: "purchaseAmount", sortable: false},<!-- 采购总金额 -->
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
		        { name: "compRatio", sortable: false},<!-- 完成率 -->
		        { name: "addUserId", sortable: false},<!-- 记录添加人id -->
		        { name: "addUserName", sortable: false},<!-- 记录添加人 -->
		        { name: "addTime", sortable: false},<!-- 记录添加时间 -->
		        { name: "lastUpdateUserId", sortable: false},<!-- 最后一次更新记录人id -->
		        { name: "lastUpdateUserName", sortable: false},<!-- 最后一次更新记录人 -->
		        { name: "lastUpdateTime", sortable: false},<!-- 最后一次更新记录时间 --> */
        ]      
	};
	
	
	
	$(function(){
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html",
            colNames: obj.names,
            colModel: obj.model,
            postData: queryData,
            multiselect: true,
             caption: "订单详情" 
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
		
		
		
	});
	function goback(){
		window.location.href="${ctx}/yimiaoPurchaseOrder/toList.html";
	}
	function goAdd(){
		window.location.href="${ctx}/yimiaoPurchaseOrder/getNotProcureList.html?orderId=${orderId}";
	}
	
		
	
	function goDelete(){
	var gridlist=  $("#gridlist");
	var rowIds =gridlist.jqGrid("getGridParam", "selarrrow") || [];
	var list = [];
	for (var i=0; i<rowIds.length; i++) {
		var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
       
        var orderdetailId=rowdata['orderdetailId'];
       
        list.push({
			"orderdetailId": orderdetailId
		});
	}
	
	
	if (rowIds.length <= 0) {
    	top.$.HN.message.alert("请至少选择一个疫苗！", "消息", "warn");
        return;
	}
	
	
	$.HN.message.confirm('确定要删除选中疫苗吗？', '', '').on(function (e) {
		if (e) {
				$.ajax({
					url:'${ctx }/yimiaoPurchaseOrder/getDelete.html',
					type:"post",
					dataType : "json",
					data:{"str":JSON.stringify(list)},
             		timeout: 10000,
               		success: function(result) {
                   		if(result.success){
           	     			$.alert("删除成功！", "success", function() {
           	     				updatePurOrderPack("${orderId}");
							});
                   		}else{
                   			$.alert(result.msg || "删除失败", "error");
                   		}
					}
				});
			}
	});
}
</script>
</html>