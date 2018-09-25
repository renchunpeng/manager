<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>企业管理</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
    <section class="content-header">
        <h1>企业管理</h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.html"><i class="fa fa-home"></i>首页</a></li>
            <li class="active"><a href="#">疫苗交易</a></li>
			<li class="active"><a href="#">企业管理</a></li>
        </ol>
    </section>
	<section class="content">
		<div class=" box box-primary">
	    	<div class="box-body">
		        <form id="searchForm" method="post">
		            <div class="input">
	                    <div class="textalign1"><spring:message code="企业名称"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyName" name="companyName"  placeholder="企业名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1" style="width:180px">企业类型：</div>
                    	<div class="boxinput">                         
                        	<select class="textinput"  id="companyType" name="companyType" style="width:40%"> 
				            	<option value=''>请选择</option>	
				            	<option value='0'>生产</option>	
				            	<option value='1'>配送</option>	
				        	</select>
                    	</div>
	                    <div class="textalign1" style="width:60px">企业状态：</div>
                    	<div class="boxinput">                         
                        	<select class="textinput"  id="isUsing" name="isUsing" style="width:40%"> 
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
			'企业名称',
			'企业类型',
			'状态',
        ],
        "model": [
			{ name: "companyId", key:true, width: 100, align: 'center' ,sortable: false, hidden:true},
 			{ name: 'operate', width: 50, align: 'center',sortable: false,
				formatter:function(val, opts, rowdata){
            		var str ='';
             		if (rowdata.isUsing==1) {
                		str += "<a href=\"javascript:void(0);\" onclick=\"disable('"+ rowdata.companyId +"','"+ rowdata.companyType +"');\" class=\"opIcon detailIcon\" title=\"停用\">停用</a>";	
					} else {
            			str += "<a href=\"javascript:void(0);\" onclick=\"start('"+ rowdata.companyId +"','"+ rowdata.companyType +"');\" class=\"opIcon detailIcon\" title=\"启用\">启用</a>";
					} 
            		return str;
			    }
			},
	        { name: "companyName", width: 150, align: 'center' ,sortable: false},
	        { name: "companyType", width: 50, align: 'center' ,sortable: false,
	        	formatter:function(val, opts, rowdata){
	        		var str = val == 1 ?"配送":"生产";
	        		return str;
	        	}
	        },
	        { name: "isUsing", width:50,sortable: false,align: 'center',formatter:function(val, opts, rowdata){
	        	var str =  val == 1 ?"启用":"停用";
                return str;
	        }}
        ]      
	};
	$(function () {
    	$("#gridlist").jqGrid({
    		url: "${ctx}/yimiaoCompany/getYimiaoCompanyManagerData.html",
    		colNames: obj.names,
	        colModel: obj.model,
            multiselect: true,
            caption: "企业列表",
            rowNum: 20,
        });
    	$(window).trigger("resize");
	}); 
	// 查询
	function search() {
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid("setGridParam", {
			url: "${ctx}/yimiaoCompany/getYimiaoCompanyManagerData.html",
			postData: queryData,//发送查询条件 
		}).trigger("reloadGrid");//重新载入 
	}
	//启用
    function start(id,companyType){
		$.HN.message.confirm('确定要启用吗？', '', '').on(function (e) {
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoCompany/updateStart.html?companyId=" + id+"&companyType="+companyType,
				type: "post",
             	dataType: "json",
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("企业启用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoCompany/getYimiaoCompanyManagerData.html",
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
    function disable(id,companyType){
    	$.HN.message.confirm('确定要停用吗？', '', '').on(function (e) {	
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoCompany/updateDisable.html?companyId=" + id+"&companyType="+companyType,
				type: "post",
             	dataType: "json",
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("企业停用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoCompany/getYimiaoCompanyManagerData.html",
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
        	top.$.HN.message.alert("请至少选择一个企业！", "消息", "warn");
            return false;
		}
		var list = [];
		for (var i=0; i<rowIds.length; i++) {
			var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            list.push({
    			"companyId": rowdata.companyId,
    			"isUsing": rowdata.isUsing
    		});
		}
		for (var i=0; i<rowIds.length; i++) {
			if (list[i].isUsing=="启用") {
				top.$.HN.message.alert("企业已经被启用了！", "消息", "warn");
	            return false;
			}
		}
		$.HN.message.confirm('确定要全部启用吗？', '', '').on(function (e) {
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoCompany/updateStartAll.html",
				type: "post",
             	dataType: "json",
             	data:{"str":JSON.stringify(list)},
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("企业全部启用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoCompany/getYimiaoCompanyManagerData.html",
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
        	top.$.HN.message.alert("请至少选择一个企业！", "消息", "warn");
            return false;
		}
		var list = [];
		for (var i=0; i<rowIds.length; i++) {
			var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            list.push({
    			"companyId": rowdata.companyId,
    			"isUsing": rowdata.isUsing
    		});
		}
		for (var i=0; i<rowIds.length; i++) {
			if (list[i].isUsing=="停用") {
				top.$.HN.message.alert("企业已经被停用了！", "消息", "warn");
	            return false;
			}
		}
		$.HN.message.confirm('确定要全部停用吗？', '', '').on(function (e) {
		if(e){
			$.ajax({
				url: "${ctx}/yimiaoCompany/updateDisableAll.html",
				type: "post",
             	dataType: "json",
             	data:{"str":JSON.stringify(list)},
             	success: function (result) {
             		console.log(result);
					if (result.success){
						$.alert("企业全部停用成功！", "success");
						$("#gridlist").jqGrid('setGridParam',{
    				    	mtype: "post",
    	                	url: "${ctx}/yimiaoCompany/getYimiaoCompanyManagerData.html",
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
    	$.StandardPost("${ctx}/yimiaoCompany/exportDataToExcel.html",postData);
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