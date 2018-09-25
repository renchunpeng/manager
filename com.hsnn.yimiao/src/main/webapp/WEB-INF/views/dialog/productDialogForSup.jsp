<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title><spring:message code="通用名dialog"/></title>
<%@include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-primary width-control">
			<div class="box-body search-box">
				<form id="searchForm" action="" method="post">
					<div class="input">
						<div class="textalign1">通用名<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input type="text" class="textinput" id="productName" name="productName" maxlength="140" />
						</div>
					</div>
					<input type="hidden" id="type" name="type" value="通用名" />
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
	"names":['通用名'],
	"model":[
		{name:'productName', width:80, align:"center", sortable:false}
	]
};

$(function(){
	var queryData = $("#searchForm").serializeJSON();
	$("#gridlist").jqGrid({
		url:"${ctx}/dialog/getProductInfoForSup.html",
		colNames:obj.names,
		colModel:obj.model,
		postData: queryData,
		multiselect:false,
		caption:"通用名信息",
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
		url: "${ctx}/dialog/getProductInfoForSup.html",
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