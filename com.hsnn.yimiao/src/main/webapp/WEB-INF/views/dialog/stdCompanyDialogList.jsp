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
						<div class="textalign1"><spring:message code="配送企业"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyName" name="companyName"  placeholder="<spring:message code="配送企业名称"/>" maxlength="50" />
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
	var purchaseType=${purchaseType};
	$("#gridlist").jqGrid({
		url: "${ctx}/drugpurHospitalProcurecatalog/getDgRelationshipInfo.html",
		colNames: [
					 '配送企业id',
					 '配送企业'
					  ,'是否启用type'
					  ,'是否启用'
	            ],
	         	colModel: [
			{ name: 'companyId', width: 10, align:"center",hidden:true, sortable: false},
            { name: 'companyName', align:"center", sortable: false}
		   ,{name:'isUsing', sortable: false,hidden:true}
		   ,{name:'isUsingDesc',width:50,align:"center", sortable: false,formatter:function(val,opts,rowdata){
			   var isUsing=rowdata.isUsing;
			   return isUsing==null?"":${enum:getEnumJSON('com.hsnn.medstgmini.base.sys.enums.YesOrNo')}[isUsing];
		   }}
        ],
        multiselect: false,
        caption: "<spring:message code='配送企业列表'/>",
        postData: {"purchaseType":${purchaseType}},
        gridComplete:function(){
            autoRNWidth("gridlist");
        },
    	onSelectRow: function (rowId, status, e) {
    		 var curRow=this;
    		 var rowData = $("#gridlist").jqGrid('getRowData',rowId);
    		 closeMyDialog(rowData);
	    },
    });
	$(window).trigger("resize");
	
	$("#search").click(function(){
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid("setGridParam", {
			url: "${ctx}/drugpurHospitalProcurecatalog/getDgRelationshipInfo.html",
			postData: queryData,//发送查询条件 
		}).trigger("reloadGrid");//重新载入
	});
}); 

function closeMyDialog(rowdata) {
	 var dialog = top.dialog.get(window);
	dialog.close(rowdata);
	return false;
} 
</script>
</html>