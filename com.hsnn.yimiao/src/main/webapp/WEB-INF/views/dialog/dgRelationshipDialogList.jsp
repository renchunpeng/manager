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
	                        <input type="text" class="textinput"  id="companyNamePs" name="companyNamePs"  placeholder="<spring:message code="配送企业名称"/>" maxlength="50" />
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
	var purchaseType=${purchaseType};
	var bidDrug='<spring:eval expression="T(com.hsnn.medstgmini.drug.enums.PurchaseType).getKeyByItemName('BID_DRUG')"></spring:eval>';//中标
	var isDisabled='<spring:eval expression="T(com.hsnn.medstgmini.base.sys.enums.YesOrNo).getKeyByItemName('NO')"></spring:eval>';//禁用
	$("#gridlist").jqGrid({
		url: "${ctx}/drugpurHospitalProcurecatalog/getDgRelationshipInfo.html",
		colNames: [
					 '配送企业id',
					 '商品id',
					 '配送企业'
					 <c:if test="${purchaseType ne 0}">
					   ,'是否启用type'
					   ,'是否启用'
					   ,'<spring:message code="message.label.disabledReason"/>'
					 </c:if>
	            ],
	         	colModel: [
			{ name: 'companyIdPs', width: 10, align:"center",hidden:true, sortable: false},
			{name:'procurecatalogId',width: 10, align:"center",hidden:true, sortable: false},
            { name: 'companyNamePs', align:"center", sortable: false}
			<c:if test="${purchaseType ne 0}">
			   ,{name:'isUsing', sortable: false,hidden:true}
			   ,{name:'isUsingDesc',width:50,align:"center", sortable: false,formatter:function(val,opts,rowdata){
				   var isUsing=rowdata.isUsing;
				   return isUsing==null?"":${enum:getEnumJSON('com.hsnn.medstgmini.base.sys.enums.YesOrNo')}[isUsing];
			   }}
			   ,{name:'dealReason', sortable: false,hidden:true}
			</c:if>
        ],
        multiselect: false,
        caption: "<spring:message code='配送企业列表'/>",
        postData: {"procurecatalogId":${procurecatalogId},"purchaseType":${purchaseType}},
        gridComplete:function(){
            autoRNWidth("gridlist");
        },
        loadComplete:function(data) {
          if(Number(purchaseType)!=Number(bidDrug)){
    		 //如果是议价的(廉价、紧张、低价)，且状态为禁用的配送企业显示为灰色且不可选择...
    		 var rowNumber=data.rows.length;
    		 if(rowNumber>0){
    			var rowObjs=data.rows;
    			$.each(rowObjs,function(i,o){
    				var rowId=rowObjs[i].id;
    				var rowIsUsing=rowObjs[i].isUsing;
    				if(Number(isDisabled)==Number(rowIsUsing)){
    					$("#gridlist").jqGrid('setRowData', rowId, false, { color: '#BDBDBD' });
    				}
    			});
    		 }
           }
		},
    	onSelectRow: function (rowId, status, e) {
    		 var curRow=this;
    		 var rowData = $("#gridlist").jqGrid('getRowData',rowId);
    		 if(Number(purchaseType)!=Number(bidDrug)){
    			 //如果是议价的(廉价、紧张、低价)，且状态为禁用的配送企业显示为灰色且不可选择...
    			 var isUsing=rowData.isUsing;
    			 if(Number(isUsing)==Number(isDisabled)){
    				 top.$.HN.message.alert("状态为禁用的配送企业不可选择！", "消息", "warn");
    				 $("#gridlist").resetSelection();//防止单击行后，高亮显示!
    				 return false;
    			 }
    			 closeMyDialog(rowData);
    		 }
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