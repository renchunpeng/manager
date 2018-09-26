<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>用户书籍列表</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">

	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/stdProduct/getStdProductData.html" id="searchForm" method="post" >
					<div class="input">
						<div class="textalign1">书名</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="name" name="name"  placeholder="书名" maxlength="50" />
	                    </div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-success btn-sm">查询</button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var obj ={
		"names": [
            '编号',
			'书名'
        ],
        "model": [
		        { name: "id", key:true, sortable: false},
		        { name: "name", sortable: false}
        ]      
	};
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/webbook/getUserBookList.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            caption: "用户书籍列表"
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/webbook/getUserBookList.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
</script>
</html>