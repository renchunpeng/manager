<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>导入导出测试</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx }/lib/plugins/uploadify/uploadify.css"/>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1>导入导出测试</h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.html"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#">导入导出测试</a></li>
			<li class="active"><a href="#">导入导出测试</a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/testImportExport/getTestImportExportData.html" id="searchForm" method="post" >
					<div class="input">
						<div class="textalign1">姓名<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="name" name="name"  placeholder="姓名" maxlength="50" />
	                    </div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="import" type="button" class="btn btn-success btn-sm" importObj='{"file_types":"*.xls;*.xlsx", "post_params":{"actionPath":"/testImportExport", "productId":"1", "goodsId":"2"}}'>导入</button>
			<!-- <button id="import" type="button" class="btn btn-success btn-sm">导入</button> -->
			<button id="export" type="button" class="btn btn-success btn-sm">导出</button>
			<button id="search" type="button" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript" src="${ctx }/lib/plugins/uploadify/jquery.uploadify.js"></script>
<script type="text/javascript">
	var obj ={
		"names": [
			//'<spring:message code="message.jqGrid.cz"/>',
			'编号',<!-- 主键ID -->
			'姓名',
			'创建时间',<!-- 创建时间 -->
        ],
        "model": [
			/* { name: 'operate', align: 'center', sortable: false,
            	formatter:function(val, opts, rowdata){
                	var str =  "<a href='${ctx }/testImportExport/toUpdate.html?id=" + rowdata.id + "' style='background:url(${ctx }/lib/img/icon/icon.png) no-repeat 0px 0px' class='opIcon' title='更新'></a>";
                	return str;
                }
        	}, */
	        { name: "id", align: 'center', key:true, sortable: false},<!-- 主键ID -->
	        { name: "firstName", align: 'center', sortable: false, formatter:function(val, opts, rowdata){
	        	return val + rowdata.name;
	        }},
	        { name: "addTime", align: 'center', sortable: false, formatter:function(val){
	        	return new Date(val).format("yyyy-MM-dd HH:mm:ss");
	        }},<!-- 创建时间 -->
        ]      
	};
	
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/testImportExport/getTestImportExportData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            caption: "导入导出测试列表"
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/testImportExport/getTestImportExportData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
		
		// 导出
		$("#export").click(function(){
			$('#searchForm').attr("action","${ctx}/testImportExport/exportData.html");
			$("#searchForm").submit();
		});
		
		// 导入
		/* $("#import").click(function(){
			var url = "${ctx}/dialog/toImportTipsDialogList.html";
			$.HN.dialog.open({
		          "id": "tips" + new Date().getTime(),
		          "title": "温馨提示", 
		          "url": url, 
		          "data": {}, 
		          "width": 1000, 
		          "height": 540, 
		          "closefunc":function(params) {
		              if (params) {
		            	  
		              }
		          }
		      }); 
		}); */
	});
</script>
</html>