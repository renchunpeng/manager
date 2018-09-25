<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title><spring:message code="目录dialog"/></title>
<%@include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-primary width-control">
			<div class="box-body search-box">
				<form id="searchForm" action="" method="post">
					<div class="input">
						<div class="textalign1">疫苗名称：</div>
						<div class="boxinput">
							<input type="text" class="textinput" id="productName" name="productName"  maxlength="50" placeholder="疫苗名称"/>
						</div>
						<div class="textalign">规格：</div>
						<div class="boxinput">
							<input type="text" class="textinput" id="outlook" name="outlook"  maxlength="50" placeholder="规格"/>
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
	    '操作',
	    '',
		'疫苗id',
		'疫苗名称',
		'规格'
	],
	"model":[
        { name: "oper",  width: 30, align: 'center' ,sortable: false,
            formatter:function(val, opts, rowdata){
                return "<a href=\"javascript:void(0);\" onclick=\"selectId('"+opts.rowId+"')\" >选择</a>";
            }
        },
		{name:'sortId',hidden:true, width:10, align:"center", sortable:false, key:true},
        {name:'productId', width:10, align:"center",hidden:true, sortable:false},
		{name:'productName', width:100, align:"center", sortable:false},
        {name:'outlook', width:100, align:"center", sortable:false}
	]
};

$(function(){
	$("#gridlist").jqGrid({
		url:"${ctx}/yimiaoProcurecatalog/getSortData.html",
		colNames:obj.names,
		colModel:obj.model,
		multiselect:false,
		caption:"疫苗名称规格列表",

        onSelectRow : function(id) {
            if (id) {
                jQuery('#gridlist').jqGrid('editRow', id, true);
            }
        }
	});
    $("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
    $(window).trigger("resize");
    $("#gridlist").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden","height" : "230px" });
}); 
 
$("#search").click(function(){
	var queryData = $("#searchForm").serializeJSON();
	$("#gridlist").jqGrid("setGridParam", {
		url: "${ctx}/yimiaoProcurecatalog/getSortData.html",
		postData: queryData//发送查询条件 
	}).trigger("reloadGrid");//重新载入
});

function selectId(rowId){
    var rowdata = $("#gridlist").jqGrid('getRowData', rowId);
    var dialog = top.dialog.get(window);
    dialog.close(rowdata); // 关闭（隐藏）对话框
    dialog.remove();				 //
}
</script>
</html>