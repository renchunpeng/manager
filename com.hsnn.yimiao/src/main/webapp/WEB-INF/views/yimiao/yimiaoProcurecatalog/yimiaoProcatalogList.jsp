<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>疫苗管理</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
    <section class="content-header">
        <h1>疫苗管理</h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.html"><i class="fa fa-home"></i>首页</a></li>
            <li class="active"><a href="#">疫苗交易</a></li>
			<li class="active"><a href="#">疫苗管理</a></li>
        </ol>
    </section>
	<section class="content">
		<div class=" box box-primary">
	    	<div class="box-body">
		        <form id="searchForm" method="post">
		            <div class="input">
		            	<div class="textalign1"><spring:message code="疫苗编号"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsId" name="goodsId"  placeholder="疫苗编号" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="疫苗名称"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="productName" name="productName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="规格"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="规格" maxlength="50" />
	                    </div>
                    	<input style="display:none;"/><!-- 防止回车表单自动提交 -->
					</div>
					<div class="input">
						<div class="textalign1"><spring:message code="生产企业"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="生产企业" maxlength="100" />
	                    </div>
	                    <div class="textalign1">疫苗状态：</div>
                    	<div class="boxinput">                         
                         <select class="textinput" id="isUsing" name="isUsing" style="width:40%" >
				            	<option value=''>请选择</option>		
				            	<option value='1'>启用</option>	
				            	<option value='0'>停用</option>                     	 
				            </select>
                    	</div>
					</div>
			    </form>
	    	</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
			<button type="button" class="btn btn-primary btn-sm" onclick="startAll();">启用</button>
			<button type="button" class="btn btn-primary btn-sm" onclick="disableAll();">停用</button>
			<button type="button" onclick="exportExcel();" class="btn btn-success btn-sm">导 出</button>
		</div>
		<table  class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var obj ={
		"names": [
		    '',
 			'<spring:message code="message.jqGrid.cz"/>',
 			'疫苗编号',
			'疫苗名称',
			'规格',
			'生产企业',
		    '最小制剂单位中标价格（元）',
			'最小制剂单位',
			'年份',
			'疫苗状态'
        ],
        "model": [
			{ name: "procurecatalogId", key:true, width: 100, align: 'center' ,sortable: false, hidden:true},
 			{ name: 'operate', width: 50, align: 'center',sortable: false,
				formatter:function(val, opts, rowdata){
            		var str ='';
             		if (rowdata.isUsing==1) {
                		str += "<a href=\"javascript:void(0);\" onclick=\"disable('"+ rowdata.procurecatalogId +"');\" class=\"opIcon detailIcon\" title=\"停用\">停用</a>";	
					} else {
            			str += "<a href=\"javascript:void(0);\" onclick=\"start('"+ rowdata.procurecatalogId +"');\" class=\"opIcon detailIcon\" title=\"启用\">启用</a>";
					} 
            		return str;
			    }
			},
			{ name: "goodsId", key:true, width: 100, align: 'center' ,sortable: false},
	        { name: "productName", width: 150, align: 'center' ,sortable: false},
	        { name: "outlook", width: 150, align: 'center' ,sortable: false},
	        { name: "companyNameSc", width: 150, align: 'center' ,sortable: false},
			{ name: "bidPrice", width: 60, align: 'center' ,sortable: false,
            	formatter : function(val, opts, rowdata){
					//return formatAmount(val, opts, rowdata);
					if (val!=null) {
						return val.toFixed(3);
					} else {
						return "暂无";
					}
				}	
			},
	        { name: "unit", width: 50, align: 'center' ,sortable: false},
	        { name: "yimiaoYear", width: 50, align: 'center' ,sortable: false},
	        { name: "isUsing", width: 50, align: 'center' ,sortable: false,
	        	formatter : function(val, opts, rowdata){
					if (parseInt(val) == 0) {
						return "停用";
					} else if (parseInt(val) == 1) {
						return "启用";
					} else {
						return "";
					}
				}
	        }
        ]      
	};
	$(function () {
    	$("#gridlist").jqGrid({
    		url: "${ctx}/yimiaoProcurecatalog/getYimiaoProcurecatalogData.html",
    		colNames: obj.names,
	        colModel: obj.model,
            multiselect: true,
            caption: "疫苗列表",
            rowNum: 20,
        });
    	$(window).trigger("resize");
    	// 查询
    	$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx}/yimiaoProcurecatalog/getYimiaoProcurecatalogData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	}); 
	
	//启用
    function start(id){
		$.HN.message.confirm('确定要启用吗？', '', '').on(function (e) {
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoProcurecatalog/updateStart.html?procurecatalogId=" + id,
				type: "post",
             	dataType: "json",
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("启用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoProcurecatalog/getYimiaoProcurecatalogData.html",
    	             	}).trigger("reloadGrid"); 
					} else {
						$.alert("<spring:message code="message.HN.alert.fail"/>", "error");
					}
				}
			});
		  }
	  });
	}
    // 停用
    function disable(id){
    	$.HN.message.confirm('确定要停用吗？', '', '').on(function (e) {	
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoProcurecatalog/updateDisable.html?procurecatalogId=" + id,
				type: "post",
             	dataType: "json",
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("停用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoProcurecatalog/getYimiaoProcurecatalogData.html",
    	             	}).trigger("reloadGrid"); 
					} else {
						$.alert("<spring:message code="message.HN.alert.fail"/>", "error");
					}
				}
			});
		  }
	  });
    }
    // 批量启用
    function startAll(){
    	var gridlist=  $("#gridlist");
		var rowIds =gridlist.jqGrid("getGridParam", "selarrrow") || [];
		if (rowIds.length <= 0) {
        	top.$.HN.message.alert("请至少选择一个商品！", "消息", "warn");
            return false;
		}
		var list = [];
		for (var i=0; i<rowIds.length; i++) {
			var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            list.push({
    			"procurecatalogId": rowdata.procurecatalogId,
    			"isUsing": rowdata.isUsing
    		});
		}
		for (var i=0; i<rowIds.length; i++) {
			if (list[i].isUsing=="启用") {
				top.$.HN.message.alert("商品已经被启用了！", "消息", "warn");
	            return false;
			}
		}
		$.HN.message.confirm('确定要全部启用吗？', '', '').on(function (e) {
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoProcurecatalog/updateStartAll.html",
				type: "post",
             	dataType: "json",
             	data:{"str":JSON.stringify(list)},
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("商品全部启用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoProcurecatalog/getYimiaoProcurecatalogData.html",
    	             	}).trigger("reloadGrid"); 
					} else {
						$.alert("<spring:message code="message.HN.alert.fail"/>", "error");
					}
				}
			});
		  }
		});
	}
    // 批量停用
    function disableAll(){
    	var gridlist=  $("#gridlist");
		var rowIds =gridlist.jqGrid("getGridParam", "selarrrow") || [];
		if (rowIds.length <= 0) {
        	top.$.HN.message.alert("请至少选择一个商品！", "消息", "warn");
            return false;
		}
		var list = [];
		for (var i=0; i<rowIds.length; i++) {
			var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            list.push({
    			"procurecatalogId": rowdata.procurecatalogId,
    			"isUsing": rowdata.isUsing
    		});
		}
		for (var i=0; i<rowIds.length; i++) {
			if (list[i].isUsing=="停用") {
				top.$.HN.message.alert("商品已经被停用了！", "消息", "warn");
	            return false;
			}
		}
		$.HN.message.confirm('确定要全部停用吗？', '', '').on(function (e) {
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoProcurecatalog/updateDisableAll.html",
				type: "post",
             	dataType: "json",
             	data:{"str":JSON.stringify(list)},
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("商品全部停用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoProcurecatalog/getYimiaoProcurecatalogData.html",
    	             	}).trigger("reloadGrid"); 
					} else {
						$.alert("<spring:message code="message.HN.alert.fail"/>", "error");
					}
				}
			});
		  }
	  });
	}
    
  //导出
    function exportExcel(){
    	var postData = $("#searchForm").serializeJSON();
    	gridParam(postData);
    	$.StandardPost("${ctx}/yimiaoProcurecatalog/exportDataToExcel.html",postData);
    	
	}
    var objTemp = null;
    function gridParam(postData){
    	if(!objTemp){
    		objTemp = $.extend(true, {}, obj);
    	}
    	var namesTemp = objTemp.names;
    	var modelTemp = objTemp.model;
		if($.inArray('操作',namesTemp) >= 0) {
			namesTemp.splice($.inArray('操作',namesTemp),1);
			modelTemp.splice(0,1);
		}
		var colModelStr =""; 
    	for(var mod in modelTemp){
    		colModelStr+=modelTemp[mod].name+",";
    	}
    	
		postData['colNames'] = namesTemp.toString();
    	postData['colModel'] = colModelStr.substring(0,colModelStr.length-1);
	}
</script>
</html>