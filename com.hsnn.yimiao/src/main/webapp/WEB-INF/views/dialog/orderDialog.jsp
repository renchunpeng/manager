<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title><spring:message code="订单dialog"/></title>
<%@include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-primary width-control">
			<div class="box-body search-box">
				<form id="searchForm" action="" method="post">
					<div class="input">
						<div class="textalign1"><spring:message code="订单名称" /><spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input type="text" class="textinput" id="orderName" name="orderName" placeholder="订单名称" maxlength="50" />
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
var obj={
	"names":[
		'<spring:message code="orderId" />',
		'<spring:message code="订单名称" />',
	],
	"model":[
		{name:'orderId', width:10, align:"center",hidden:true, sortable:false, key:true},
		{name:'orderName', width:10, align:"center", sortable:false}
	]
};

$(function(){
	$("#gridlist").jqGrid({
		url:"${ctx}/dialog/getInfosup.html",
		colNames:obj.names,
		colModel:obj.model,
		multiselect:false,
		caption:"订单信息",
		postData:{"beanName":"yimiaoPurchaseOrderManager"},
		onSelectRow:function(rowId){
		var rowdata = $("#gridlist").jqGrid('getRowData',rowId);
			closeMyDialog(rowdata);
		}
	});
	$(window).trigger("resize");
}); 
 
$("#search").click(function(){
	var queryData = $("#searchForm").serializeJSON();
	$("#gridlist").jqGrid("setGridParam", {
		url: "${ctx}/dialog/getInfosup.html",
		postData: queryData//发送查询条件 
	}).trigger("reloadGrid");//重新载入
});

function closeMyDialog(rowdata) {
	var dialog = top.dialog.get(window);
	dialog.close(rowdata);
	$("#searchForm")[0].reset();
	return false;
} 
</script>
</html>