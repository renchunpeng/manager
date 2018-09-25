<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>下单管理</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
    <section class="content-header">
        <h1>下单管理</h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.html"><i class="fa fa-home"></i>首页</a></li>
            <li class="active"><a href="#">疫苗交易</a></li>
			<li class="active"><a href="#">下单管理</a></li>
        </ol>
    </section>
	<section class="content">
		<div class=" box box-primary">
	    	<div class="box-body">
		        <form id="searchForm" method="post">
		            <div class="input">
	                    <div class="textalign1">采购单位名称<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="hospitalName" name="hospitalName"  placeholder="采购单位名称" maxlength="50" />
	                    </div>
	                     <div class="textalign1" style="width:60px">下单权限：</div>
                    	<div class="boxinput">                         
                        	<select class="textinput"  id="orderControl" name="orderControl" style="width:40%"> 
				            	<option value=''>请选择</option>		
				            	<option value='1'>启用</option>	
				            	<option value='0'>停用</option>
				        	</select>
                    	</div>
                    	<input style="display:none;"/><!-- 防止回车表单自动提交 -->
					</div>
			    </form>
	    	</div>
		</div>
		<div class="btn-control-box">
			<button id="searchBtn" type="button" class="btn btn-primary btn-sm" onclick="search();"><spring:message code="message.button.seachSpacing"/></button>
			<button type="button" class="btn btn-primary btn-sm" onclick="startAll();">启用</button>
			<button type="button" class="btn btn-primary btn-sm" onclick="disableAll();">停用</button>
			<button type="button" class="btn btn-primary btn-sm" onclick="AllEnable();">全部启用</button>
			<button type="button" class="btn btn-primary btn-sm" onclick="AllDisable();">全部停用</button>
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
			'采购单位名称',
			'下单权限',
        ],
        "model": [
			{ name: "hospitalId", key:true, width: 100, align: 'center' ,sortable: false, hidden:true},
 			{ name: 'operate', width: 50, align: 'center',sortable: false,
				formatter:function(val, opts, rowdata){
            		var str ='';
             		if (rowdata.orderControl==1) {
                		str += "<a href=\"javascript:void(0);\" onclick=\"disable('"+ rowdata.hospitalId +"');\" class=\"opIcon detailIcon\" title=\"停用\">停用</a>";	
					} else {
            			str += "<a href=\"javascript:void(0);\" onclick=\"start('"+ rowdata.hospitalId +"');\" class=\"opIcon detailIcon\" title=\"启用\">启用</a>";
					} 
            		return str;
			    }
			},
	        { name: "hospitalName", width: 150, align: 'center' ,sortable: false},
	        { name: "orderControl", width:50,sortable: false,align: 'center',formatter:function(val, opts, rowdata){
	        	var str =  val == 1 ?"启用":"停用";
                return str;
	        }
	        }
        ]      
	};
	$(function () {
    	$("#gridlist").jqGrid({
    		url: "${ctx}/yimiaoCompany/getStdHospitalManagerData.html",
    		colNames: obj.names,
	        colModel: obj.model,
            multiselect: true,
            caption: "采购单位",
            rowNum: 20,
        });
    	$(window).trigger("resize");
	}); 
	// 查询
	function search() {
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid("setGridParam", {
			url: "${ctx}/yimiaoCompany/getStdHospitalManagerData.html",
			postData: queryData,//发送查询条件 
		}).trigger("reloadGrid");//重新载入 
	}
	//启用
    function start(id){
		$.HN.message.confirm('确定要启用吗？', '', '').on(function (e) {
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoCompany/OrderStart.html?hospitalId=" + id,
				type: "post",
             	dataType: "json",
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("下单启用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoCompany/getStdHospitalManagerData.html",
    	             	}).trigger("reloadGrid"); 
					} else {
						$.alert("下单启用失败", "error");
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
				url: "${ctx}/yimiaoCompany/OrderDisable.html?hospitalId=" + id,
				type: "post",
             	dataType: "json",
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("下单停用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoCompany/getStdHospitalManagerData.html",
    	             	}).trigger("reloadGrid"); 
					} else {
						$.alert("下单停用失败", "error");
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
        	top.$.HN.message.alert("请至少选择一个采购单位！", "消息", "warn");
            return false;
		}
		var list = [];
		for (var i=0; i<rowIds.length; i++) {
			var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            list.push({
    			"hospitalId": rowdata.hospitalId,
    			"orderControl":rowdata.orderControl
    		});
		}
		for (var i=0; i<rowIds.length; i++) {
			if (list[i].orderControl=="启用") {
				top.$.HN.message.alert("采购单位已经被启用了！", "消息", "warn");
	            return false;
			}
		}
		
		$.HN.message.confirm('确定要启用吗？', '', '').on(function (e) {
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoCompany/OrderStartAll.html",
				type: "post",
             	dataType: "json",
             	data:{"str":JSON.stringify(list)},
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("下单启用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoCompany/getStdHospitalManagerData.html",
    	             	}).trigger("reloadGrid"); 
					} else {
						$.alert("下单启用失败", "error");
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
        	top.$.HN.message.alert("请至少选择一个采购单位！", "消息", "warn");
            return false;
		}
		var list = [];
		for (var i=0; i<rowIds.length; i++) {
			var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            list.push({
    			"hospitalId": rowdata.hospitalId,
    			"orderControl":rowdata.orderControl
    		});
		}
		for (var i=0; i<rowIds.length; i++) {
			if (list[i].orderControl=="停用") {
				top.$.HN.message.alert("采购单位已经被停用了！", "消息", "warn");
	            return false;
			}
		}
		$.HN.message.confirm('确定要停用吗？', '', '').on(function (e) {
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoCompany/OrderDisableAll.html",
				type: "post",
             	dataType: "json",
             	data:{"str":JSON.stringify(list)},
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("下单停用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoCompany/getStdHospitalManagerData.html",
    	             	}).trigger("reloadGrid"); 
					} else {
						$.alert("下单停用失败", "error");
					}
				}
			});
		  }
	  });
	}
    
	//全部启用
    function AllEnable(id){
		$.HN.message.confirm('确定要全部启用吗？', '', '').on(function (e) {
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoCompany/AllEnable.html",
				type: "post",
             	dataType: "json",
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("下单启用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoCompany/getStdHospitalManagerData.html",
    	             	}).trigger("reloadGrid"); 
					} else {
						$.alert("下单启用失败", "error");
					}
				}
			});
		  }
	  });
	}
    // 全部停用
    function AllDisable(id){
    	$.HN.message.confirm('确定要全部停用吗？', '', '').on(function (e) {	
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoCompany/AllDisable.html",
				type: "post",
             	dataType: "json",
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("下单停用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoCompany/getStdHospitalManagerData.html",
    	             	}).trigger("reloadGrid"); 
					} else {
						$.alert("下单停用失败", "error");
					}
				}
			});
		  }
	  });
    }
    
</script>
</html>