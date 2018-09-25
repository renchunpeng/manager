<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title></title>
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
	                        <input type="text" class="textinput"  id="companyNamePs" name="companyNamePs"  placeholder="<spring:message code="配送企业名称"/>" maxlength="50" />
	                    </div>                  
	                    <input style="display:none;"/>
						<div class="textalign">
							<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
						</div>
					</div>
			    </form>
	    	</div>
		</div>
		<table  class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
		
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">

$(function () {
	$("#gridlist").jqGrid({
		url: "${ctx}/dialog/getInfo.html",
		colNames: [
					'companyIdPs', '企业名称'
	            ],
	         	colModel: [
			{ name: 'companyIdPs', width: 10, align:"center",hidden:true, sortable: false},
            { name: 'companyNamePs', width: 10, align:"center", sortable: false}
        ],
        multiselect: false,
        caption: "<spring:message code='配送企业列表'/>",
        postData: {"beanName":"drugpurAreaDistriPermissionManager",
        		   "basedrugDistributeAreaId":${basedrugDistributeAreaId},
        		   "groupById":true
        	       },
        gridComplete:function(){
            autoRNWidth("gridlist");
        },
        jsonReader: {
            id: "companyIdPs"
        },
        onSelectRow: function (rowId) {
       	 var rowdata = $("#gridlist").jqGrid('getRowData', rowId);
       	 closeMyDialog(rowdata);
       }, 
    });
	$(window).trigger("resize");
	
	$("#search").click(function(){
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid("setGridParam", {
			url: "${ctx}/dialog/getInfo.html",
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