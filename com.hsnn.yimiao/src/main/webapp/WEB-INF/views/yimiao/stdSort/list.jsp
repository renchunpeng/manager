<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title><spring:message code="二级目录表列表-待修改"/></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/stdSort/getStdSortData.html" id="searchForm" method="post" >
					<div class="input">
						<div class="textalign1">查询条件1<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="***" name="***"  placeholder="查询条件1" maxlength="50" />
	                    </div>
	                    <div class="textalign">查询条件2<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="***" name="***"  placeholder="查询条件2" maxlength="50" />
	                    </div>
	                    <div class="textalign">查询条件3<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="***" name="***"  placeholder="查询条件3" maxlength="50" />
	                    </div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var obj ={
		"names": [
			'<spring:message code="message.jqGrid.cz"/>',
			'<spring:message code="stdSort.sortId"/>',<!-- 主键id -->
			'<spring:message code="stdSort.sortName"/>',<!-- sortName -->
			'<spring:message code="stdSort.belongAreaId"/>',<!-- belongAreaId -->
			'<spring:message code="stdSort.belongAreaName"/>',<!-- belongAreaName -->
			'<spring:message code="stdSort.addUserId"/>',<!-- 添加人id -->
			'<spring:message code="stdSort.addUserName"/>',<!-- 添加人 -->
			'<spring:message code="stdSort.addTime"/>',<!-- 添加时间 -->
			'<spring:message code="stdSort.lastUpdateUserId"/>',<!-- lastUpdateUserId -->
			'<spring:message code="stdSort.lastUpdateUserName"/>',<!-- lastUpdateUserName -->
			'<spring:message code="stdSort.lastUpdateTime"/>',<!-- lastUpdateTime -->
			'<spring:message code="stdSort.oldSortId"/>',<!-- oldSortId -->
			'<spring:message code="stdSort.productId"/>',<!-- 一级目录id -->
			'<spring:message code="stdSort.productName"/>',<!-- 一级目录名称 -->
			'<spring:message code="stdSort.outlook"/>',<!-- 二级目录 -->
        ],
        "model": [
			{ name: 'operate', width: 40, align: 'center',sortable: false,
            	formatter:function(val, opts, rowdata){
                	var str =  "<a href='${ctx }/stdSort/toUpdate.html?sortId=" + rowdata.sortId + "' style='background:url(${ctx }/lib/img/icon/icon.png) no-repeat 0px 0px' class='opIcon' title='更新'></a>";
                	return str;
                }
        	},
		        { name: "sortId", key:true, sortable: false},<!-- 主键id -->
		        { name: "sortName", sortable: false},<!-- sortName -->
		        { name: "belongAreaId", sortable: false},<!-- belongAreaId -->
		        { name: "belongAreaName", sortable: false},<!-- belongAreaName -->
		        { name: "addUserId", sortable: false},<!-- 添加人id -->
		        { name: "addUserName", sortable: false},<!-- 添加人 -->
		        { name: "addTime", sortable: false},<!-- 添加时间 -->
		        { name: "lastUpdateUserId", sortable: false},<!-- lastUpdateUserId -->
		        { name: "lastUpdateUserName", sortable: false},<!-- lastUpdateUserName -->
		        { name: "lastUpdateTime", sortable: false},<!-- lastUpdateTime -->
		        { name: "oldSortId", sortable: false},<!-- oldSortId -->
		        { name: "productId", sortable: false},<!-- 一级目录id -->
		        { name: "productName", sortable: false},<!-- 一级目录名称 -->
		        { name: "outlook", sortable: false},<!-- 二级目录 -->
        ]      
	};
	
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/stdSort/getStdSortData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            caption: "<spring:message code="二级目录表列表-待修改"/>"
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/stdSort/getStdSortData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
</script>
</html>