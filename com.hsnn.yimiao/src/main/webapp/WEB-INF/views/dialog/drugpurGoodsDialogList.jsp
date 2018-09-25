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
		            <div class="textalign1"><spring:message code="drugpurGoods.goodsId"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsId" name="goodsId"  placeholder="<spring:message code="drugpurGoods.goodsId"/>" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="drugpurGoods.productName"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="productName" name="productName"  placeholder="<spring:message code="drugpurGoods.productName"/>" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="drugpurProcurecatalog.companyNameSc"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="<spring:message code="drugpurProcurecatalog.companyNameSc"/>" maxlength="170" />
	                    </div>
					</div>
					<div class="input">
		                <div class="textalign1"><spring:message code="drugpurGoods.outlook"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="<spring:message code="drugpurGoods.outlook"/>" maxlength="50" />
	                    </div>
	                    <input style="display:none;"/><!-- 防止回车表单自动提交 -->
						<div class="textalign">
							<button id="search" type="button" class="btn btn-primary btn-sm" onclick="searchGoods();"><spring:message code="message.button.seachSpacing"/></button>
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
	var obj ={
		"names": [
			'<spring:message code="drugpurProcurecatalog.goodsId"/>',
			'<spring:message code="drugpurProcurecatalog.goodsInfo"/>',
			'<spring:message code="drugpurProcurecatalog.productName"/>',
			'<spring:message code="drugpurProcurecatalog.productSpelName"/>',
			'<spring:message code="drugpurProcurecatalog.productWbName"/>',
			'<spring:message code="drugpurProcurecatalog.goodsName"/>',
			'<spring:message code="drugpurProcurecatalog.medicinemodel"/>',
			'<spring:message code="drugpurProcurecatalog.outlook"/>',
			'<spring:message code="drugpurProcurecatalog.factor"/>',
			'<spring:message code="drugpurProcurecatalog.materialName"/>',
			'<spring:message code="drugpurProcurecatalog.unit"/>',
			'<spring:message code="drugpurProcurecatalog.middlePack"/>',
			'<spring:message code="drugpurProcurecatalog.maxPack"/>',
			'<spring:message code="drugpurProcurecatalog.middleWithMaxPack"/>',
			'<spring:message code="drugpurProcurecatalog.companyIdSc"/>',
			'<spring:message code="drugpurProcurecatalog.companyNameSc"/>',
			'<spring:message code="drugpurProcurecatalog.splitCompanyName"/>',
			'<spring:message code="drugpurProcurecatalog.trustCompanyName"/>',
			'<spring:message code="drugpurProcurecatalog.companyIdTb"/>',
			'<spring:message code="drugpurProcurecatalog.companyNameTb"/>',

        ],
        "model": [
	        { name: "goodsId", key:true, width: 60, align: 'center' ,sortable: false},
	        { name: "goodsInfo", width: 200, align: 'left' ,sortable: false, formatter:function(val, opts, rowdata){
		           var goodsInfo="<spring:message code='message.fuhao.zhongkuohao.before'/>"+rowdata.goodsName+"<spring:message code='message.fuhao.zhongkuohao.after'/>"+"&nbsp;"+rowdata.productName+"<br/>"+rowdata.medicinemodel+"&nbsp;"+rowdata.outlook+"&nbsp;"+rowdata.factor+"&nbsp;"+rowdata.unit+"&nbsp;"+rowdata.materialName;
     		   return goodsInfo;
		    }},
	        { name: "productName", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "productSpelName", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "productWbName", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "goodsName", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "medicinemodel", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "outlook", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "factor", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "materialName", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "unit", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "middlePack", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "maxPack", width: 1, align: 'center' ,sortable: false, hidden:true},
	        { name: "middleWithMaxPack", width: 90, align: 'center', sortable: false,formatter:function(val, opts, rowdata){
	        	var mid = rowdata.middlePack == null ? "<spring:message code='message.lable.tip.none'/>" : rowdata.middlePack;
	        	var max = rowdata.maxPack == null ? "<spring:message code='message.lable.tip.none'/>" : rowdata.maxPack;
				return mid + "/" + max;
	        }},
	        { name: "companyIdSc", width: 1, hidden:true,align: 'center' ,sortable: false},
	        { name: "companyNameSc", width: 200, align: 'center' ,sortable: false},
	        { name: "splitCompanyName", width: 200,hidden:true, align: 'center' ,sortable: false},
	        { name: "trustCompanyName", width: 200, align: 'center' ,sortable: false},
	        { name: "companyIdTb", width: 1, hidden:true,align: 'center' ,sortable: false},
	        { name: "companyNameTb", width: 200, align: 'center' ,sortable: false},
        ]      
	};
	$(function () {
    	$("#gridlist").jqGrid({
    		url: "${ctx}/dialog/getInfo.html",
    		colNames: obj.names,
	        colModel: obj.model,
            multiselect: false,
            caption: "<spring:message code='message.listForm.chanPinLieBiao'/>",
            postData: {"beanName":"drugpurGoodsManager"},
            gridComplete:function(){
                autoRNWidth("gridlist");
                $(".ui-jqgrid-bdiv table,.ui-jqgrid-htable").css("width",$(".ui-jqgrid-bdiv table").width()-1);
            },
            jsonReader: {
                id: "hospitalId"
            },
            onSelectRow: function (rowId) {
           		var rowdata = $("#gridlist").jqGrid('getRowData', rowId);
				closeMyDialog(rowdata);
			}, 
        });
    	$(window).trigger("resize");
	}); 
	
	function searchGoods() {
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid("setGridParam", {
			url: "${ctx}/dialog/getInfo.html",
			postData: queryData,//发送查询条件 
		}).trigger("reloadGrid");//重新载入
	}
  	  	
	function closeMyDialog(rowdata) {
		var dialog = top.dialog.get(window);
		dialog.close(rowdata);
		$("#searchForm")[0].reset();
    	searchGoods();
	    return false;
	} 
</script>
</html>