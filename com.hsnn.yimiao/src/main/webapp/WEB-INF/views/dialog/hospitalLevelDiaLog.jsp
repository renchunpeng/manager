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
		<table  class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">

$(function () {
	//var purchaseType=${purchaseType};
	$("#gridlist").jqGrid({
		url: "${ctx}/drugpurFilingLimit/getDrugpurFilingLimitData.html",
		colNames: [
					 'id',
					 '是否需要申请',
					 '医院等级要求',
	            ],
       	colModel: [
		    { name: 'id', width: 10, align:"center",hidden:true, sortable: false},
			{name:'isDirectPurchase',align:"center", sortable: false,hidden:true,
		       formatter:function(val, opts, rowdata){
	 	    	  return val==null?"":${enum:getEnumJSON('com.hsnn.medstgmini.base.sys.enums.YesOrNo')}[val]; 
	 		    }	
			},
	        { name: 'hospitalLevel', align:"center", sortable: false},
        ],
        multiselect: false,
        caption: "<spring:message code='医院等级'/>",
        postData: {"procurecatalogId":${procurecatalogId}},
        gridComplete:function(){
            autoRNWidth("gridlist");
        },
	
    });
	$(window).trigger("resize");
	
	$("#closeBtn").click(function(){
	});
}); 

function closeMyDialog(rowdata) {
	 var dialog = top.dialog.get(window);
	dialog.close(rowdata);
	return false;
} 
</script>
</html>