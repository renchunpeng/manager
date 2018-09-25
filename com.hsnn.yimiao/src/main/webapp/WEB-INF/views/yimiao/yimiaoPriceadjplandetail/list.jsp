<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title><spring:message code="调价明细表列表-待修改"/></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/yimiaoPriceadjplandetail/getYimiaoPriceadjplandetailData.html" id="searchForm" method="post" >
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
			'<spring:message code="yimiaoPriceadjplandetail.priceAdjPalnDetailId"/>',<!-- 计划明细id -->
			'<spring:message code="yimiaoPriceadjplandetail.priceAdjPlanId"/>',<!-- 调价计划id -->
			'<spring:message code="yimiaoPriceadjplandetail.goodsCode"/>',<!-- 商品号 -->
			'<spring:message code="yimiaoPriceadjplandetail.origProPriceLimit"/>',<!-- 原采购限价 -->
			'<spring:message code="yimiaoPriceadjplandetail.currProPriceLimit"/>',<!-- 新采购限价 -->
			'<spring:message code="yimiaoPriceadjplandetail.origRetailPriceLimit"/>',<!-- 原最高零售价 -->
			'<spring:message code="yimiaoPriceadjplandetail.currRetailPriceLlimit"/>',<!-- 新最高零售价 -->
			'<spring:message code="yimiaoPriceadjplandetail.addDatetime"/>',<!-- 加入计划时间 -->
			'<spring:message code="yimiaoPriceadjplandetail.addUser"/>',<!-- 加入计划操作人 -->
			'<spring:message code="yimiaoPriceadjplandetail.remarks"/>',<!-- 备注 -->
        ],
        "model": [
			{ name: 'operate', width: 40, align: 'center',sortable: false,
            	formatter:function(val, opts, rowdata){
                	var str =  "<a href='${ctx }/yimiaoPriceadjplandetail/toUpdate.html?priceAdjPalnDetailId=" + rowdata.priceAdjPalnDetailId + "' style='background:url(${ctx }/lib/img/icon/icon.png) no-repeat 0px 0px' class='opIcon' title='更新'></a>";
                	return str;
                }
        	},
		        { name: "priceAdjPalnDetailId", key:true, sortable: false},<!-- 计划明细id -->
		        { name: "priceAdjPlanId", sortable: false},<!-- 调价计划id -->
		        { name: "goodsCode", sortable: false},<!-- 商品号 -->
		        { name: "origProPriceLimit", sortable: false},<!-- 原采购限价 -->
		        { name: "currProPriceLimit", sortable: false},<!-- 新采购限价 -->
		        { name: "origRetailPriceLimit", sortable: false},<!-- 原最高零售价 -->
		        { name: "currRetailPriceLlimit", sortable: false},<!-- 新最高零售价 -->
		        { name: "addDatetime", sortable: false},<!-- 加入计划时间 -->
		        { name: "addUser", sortable: false},<!-- 加入计划操作人 -->
		        { name: "remarks", sortable: false},<!-- 备注 -->
        ]      
	};
	
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoPriceadjplandetail/getYimiaoPriceadjplandetailData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            caption: "<spring:message code="调价明细表列表-待修改"/>"
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoPriceadjplandetail/getYimiaoPriceadjplandetailData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
</script>
</html>