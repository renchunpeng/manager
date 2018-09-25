<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title></title>
<style>
	.disabledRolw{
		border: 1px solid #E6E4E4;
	    background: #E6E4E4!important;
	    color: #363636;
	 }
</style>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-success">
	    	<div class="box-body">
		        <form id="searchForm" method="post">
		            <div class="input">
						<div class="textalign1"><spring:message code="地市名称"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="cityName" name="cityName"  placeholder="<spring:message code="配送企业名称"/>" maxlength="50" />
	                        <input style="display: none" />
	                    </div>                  
					</div>
			    </form>
	    	</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-primary btn-sm navbar-right"><spring:message code="message.button.seachSpacing"/></button>
		</div>
		<table  class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">

$(function () {
	//var purchaseType=${purchaseType};
	$("#gridlist").jqGrid({
		url: "${ctx}/drugpurProcurecatalog/getSupplyAreaData.html",
		colNames: [
					 'id',
					 '商品id',
					 '地市名称',
					 '使用范围'
	            ],
       	colModel: [
		{ name: 'id', width: 10, align:"center",hidden:true, sortable: false},
			{name:'procurecatalogId',width: 10, align:"center",hidden:true, sortable: false},
	        { name: 'cityName', align:"center", sortable: false},
	        { name: 'drugPurchaseProperty', align:"center", sortable: false,
	        	formatter:function(val,opts,rowData){
	        		if(rowData.drugPurchaseProperty == 0) return "县及县以上";
	        		return "基层";
	        	}},
        ],
        multiselect: false,
        caption: "<spring:message code='供货区域表'/>",
        postData: {"procurecatalogId":${procurecatalogId}},
        gridComplete:function(){
            autoRNWidth("gridlist");
        },
	
    });
	$(window).trigger("resize");
	
	$("#search").click(function(){
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid("setGridParam", {
			url: "${ctx}/drugpurProcurecatalog/getSupplyAreaData.html",
			postData: queryData,//发送查询条件 
		}).trigger("reloadGrid");//重新载入
	});
	
	$("#closeBtn").click(function(){
		
	});
	
	$("#addRelation").click(function() {
		var companyIds = $("#gridlist").jqGrid("getGridParam", "selarrrow");
		
	});
}); 

function closeMyDialog(rowdata) {
	 var dialog = top.dialog.get(window);
	dialog.close(rowdata);
	return false;
} 
</script>
</html>