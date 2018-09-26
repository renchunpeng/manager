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
			'<spring:message code="stdProduct.productId"/>',<!-- 一级目录id -->
			'<spring:message code="stdProduct.productName"/>',<!-- 一级目录名称 -->
			'<spring:message code="stdProduct.productSpelName"/>',<!-- productSpelName -->
			'<spring:message code="stdProduct.productWbName"/>',<!-- productWbName -->
			'<spring:message code="stdProduct.medicinemodel"/>',<!-- medicinemodel -->
			'<spring:message code="stdProduct.medicinemodelSpel"/>',<!-- medicinemodelSpel -->
			'<spring:message code="stdProduct.outlook"/>',<!-- outlook -->
			'<spring:message code="stdProduct.factor"/>',<!-- factor -->
			'<spring:message code="stdProduct.levelDay"/>',<!-- levelDay -->
			'<spring:message code="stdProduct.remark"/>',<!-- remark -->
			'<spring:message code="stdProduct.status"/>',<!-- status -->
			'<spring:message code="stdProduct.auditUserName"/>',<!-- auditUserName -->
			'<spring:message code="stdProduct.auditRemark"/>',<!-- auditRemark -->
			'<spring:message code="stdProduct.auditTime"/>',<!-- auditTime -->
			'<spring:message code="stdProduct.isUsing"/>',<!-- isUsing -->
			'<spring:message code="stdProduct.addUserId"/>',<!-- addUserId -->
			'<spring:message code="stdProduct.addUserName"/>',<!-- addUserName -->
			'<spring:message code="stdProduct.addTime"/>',<!-- addTime -->
			'<spring:message code="stdProduct.lastUpdateUserId"/>',<!-- lastUpdateUserId -->
			'<spring:message code="stdProduct.lastUpdateUserName"/>',<!-- lastUpdateUserName -->
			'<spring:message code="stdProduct.lastUpdateTime"/>',<!-- lastUpdateTime -->
			'<spring:message code="stdProduct.drugClassification"/>',<!-- 药品分类 -->
			'<spring:message code="stdProduct.component"/>',<!-- 主成分 -->
			'<spring:message code="stdProduct.drugCategory"/>',<!-- 药品类别 -->
			'<spring:message code="stdProduct.productCode"/>',<!-- productCode -->
			'<spring:message code="stdProduct.sortId"/>',<!-- sortId -->
			'<spring:message code="stdProduct.sortName"/>',<!-- sortName -->
			'<spring:message code="stdProduct.belongAreaId"/>',<!-- belongAreaId -->
			'<spring:message code="stdProduct.belongAreaName"/>',<!-- belongAreaName -->
			'<spring:message code="stdProduct.productNameFirst"/>',<!-- productNameFirst -->
			'<spring:message code="stdProduct.productNameSecond"/>',<!-- productNameSecond -->
			'<spring:message code="stdProduct.submitState"/>',<!-- submitState -->
			'<spring:message code="stdProduct.submitUserId"/>',<!-- submitUserId -->
			'<spring:message code="stdProduct.submitUserName"/>',<!-- submitUserName -->
			'<spring:message code="stdProduct.submitTime"/>',<!-- submitTime -->
			'<spring:message code="stdProduct.auditState"/>',<!-- auditState -->
			'<spring:message code="stdProduct.auditorUserId"/>',<!-- auditorUserId -->
			'<spring:message code="stdProduct.auditor"/>',<!-- auditor -->
			'<spring:message code="stdProduct.isCanAddGoods"/>',<!-- isCanAddGoods -->
			'<spring:message code="stdProduct.oldProductId"/>',<!-- oldProductId -->
			'<spring:message code="stdProduct.oldSortId"/>',<!-- oldSortId -->
        ],
        "model": [
			{ name: 'operate', width: 40, align: 'center',sortable: false,
            	formatter:function(val, opts, rowdata){
                	var str =  "<a href='${ctx }/stdProduct/toUpdate.html?productId=" + rowdata.productId + "' style='background:url(${ctx }/lib/img/icon/icon.png) no-repeat 0px 0px' class='opIcon' title='更新'></a>";
                	return str;
                }
        	},
		        { name: "productId", key:true, sortable: false},<!-- 一级目录id -->
		        { name: "productName", sortable: false},<!-- 一级目录名称 -->
		        { name: "productSpelName", sortable: false},<!-- productSpelName -->
		        { name: "productWbName", sortable: false},<!-- productWbName -->
		        { name: "medicinemodel", sortable: false},<!-- medicinemodel -->
		        { name: "medicinemodelSpel", sortable: false},<!-- medicinemodelSpel -->
		        { name: "outlook", sortable: false},<!-- outlook -->
		        { name: "factor", sortable: false},<!-- factor -->
		        { name: "levelDay", sortable: false},<!-- levelDay -->
		        { name: "remark", sortable: false},<!-- remark -->
		        { name: "status", sortable: false},<!-- status -->
		        { name: "auditUserName", sortable: false},<!-- auditUserName -->
		        { name: "auditRemark", sortable: false},<!-- auditRemark -->
		        { name: "auditTime", sortable: false},<!-- auditTime -->
		        { name: "isUsing", sortable: false},<!-- isUsing -->
		        { name: "addUserId", sortable: false},<!-- addUserId -->
		        { name: "addUserName", sortable: false},<!-- addUserName -->
		        { name: "addTime", sortable: false},<!-- addTime -->
		        { name: "lastUpdateUserId", sortable: false},<!-- lastUpdateUserId -->
		        { name: "lastUpdateUserName", sortable: false},<!-- lastUpdateUserName -->
		        { name: "lastUpdateTime", sortable: false},<!-- lastUpdateTime -->
		        { name: "drugClassification", sortable: false},<!-- 药品分类 -->
		        { name: "component", sortable: false},<!-- 主成分 -->
		        { name: "drugCategory", sortable: false},<!-- 药品类别 -->
		        { name: "productCode", sortable: false},<!-- productCode -->
		        { name: "sortId", sortable: false},<!-- sortId -->
		        { name: "sortName", sortable: false},<!-- sortName -->
		        { name: "belongAreaId", sortable: false},<!-- belongAreaId -->
		        { name: "belongAreaName", sortable: false},<!-- belongAreaName -->
		        { name: "productNameFirst", sortable: false},<!-- productNameFirst -->
		        { name: "productNameSecond", sortable: false},<!-- productNameSecond -->
		        { name: "submitState", sortable: false},<!-- submitState -->
		        { name: "submitUserId", sortable: false},<!-- submitUserId -->
		        { name: "submitUserName", sortable: false},<!-- submitUserName -->
		        { name: "submitTime", sortable: false},<!-- submitTime -->
		        { name: "auditState", sortable: false},<!-- auditState -->
		        { name: "auditorUserId", sortable: false},<!-- auditorUserId -->
		        { name: "auditor", sortable: false},<!-- auditor -->
		        { name: "isCanAddGoods", sortable: false},<!-- isCanAddGoods -->
		        { name: "oldProductId", sortable: false},<!-- oldProductId -->
		        { name: "oldSortId", sortable: false},<!-- oldSortId -->
        ]      
	};
	
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/stdProduct/getStdProductData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            caption: "<spring:message code="一级目录表列表-待修改"/>"
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/stdProduct/getStdProductData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
</script>
</html>