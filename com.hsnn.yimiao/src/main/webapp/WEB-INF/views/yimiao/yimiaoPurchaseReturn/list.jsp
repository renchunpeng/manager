<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
	
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
		
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/yimiaoPurchaseReturn/getYimiaoPurchaseReturnData.html" id="searchForm" method="post" >
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
			'<spring:message code="yimiaoPurchaseReturn.retOrderId"/>',<!-- order_id（有序guid编号） -->
			'<spring:message code="yimiaoPurchaseReturn.hospitalId"/>',<!-- 医疗机构编号 -->
			'<spring:message code="yimiaoPurchaseReturn.hospitalName"/>',<!-- 医疗机构名称 -->
			'<spring:message code="yimiaoPurchaseReturn.hospitalDepartmentId"/>',<!-- 医疗机构部门编号 -->
			'<spring:message code="yimiaoPurchaseReturn.hospitalDepartmentName"/>',<!-- 医疗机构部门名称 -->
			'<spring:message code="yimiaoPurchaseReturn.orderType"/>',<!-- 订单类型（0：正常订单，1：急救药品临时订单） -->
			'<spring:message code="yimiaoPurchaseReturn.orderName"/>',<!-- 订单名称 -->
			'<spring:message code="yimiaoPurchaseReturn.orderAmount"/>',<!-- 订单金额 -->
			'<spring:message code="yimiaoPurchaseReturn.orderRamarks"/>',<!-- 订单备注 -->
			'<spring:message code="yimiaoPurchaseReturn.submitTime"/>',<!-- 提交时间 -->
			'<spring:message code="yimiaoPurchaseReturn.subminter"/>',<!-- 提交人 -->
			'<spring:message code="yimiaoPurchaseReturn.isAutoSubmint"/>',<!-- 是否自动提交 -->
			'<spring:message code="yimiaoPurchaseReturn.autoSubmitTime"/>',<!-- 自动提交时间 -->
			'<spring:message code="yimiaoPurchaseReturn.orderState"/>',<!-- 完成进度(0:待提交,1:已提交) -->
			'<spring:message code="yimiaoPurchaseReturn.defaultDistributeAddr"/>',<!-- defaultDistributeAddr -->
			'<spring:message code="yimiaoPurchaseReturn.addUserId"/>',<!-- 记录添加人id -->
			'<spring:message code="yimiaoPurchaseReturn.addUserName"/>',<!-- 记录添加人 -->
			'<spring:message code="yimiaoPurchaseReturn.addTime"/>',<!-- 记录添加时间 -->
			'<spring:message code="yimiaoPurchaseReturn.lastUpdateUserId"/>',<!-- 最后一次更新记录人id -->
			'<spring:message code="yimiaoPurchaseReturn.lastUpdateUserName"/>',<!-- 最后一次更新记录人 -->
			'<spring:message code="yimiaoPurchaseReturn.lastUpdateTime"/>',<!-- 最后一次更新记录时间 -->
        ],
        "model": [
			{ name: 'operate', width: 40, align: 'center',sortable: false,
            	formatter:function(val, opts, rowdata){
                	var str =  "<a href='${ctx }/yimiaoPurchaseReturn/toUpdate.html?retOrderId=" + rowdata.retOrderId + "' style='background:url(${ctx }/lib/img/icon/icon.png) no-repeat 0px 0px' class='opIcon' title='更新'></a>";
                	return str;
                }
        	},
		        { name: "retOrderId", key:true, sortable: false},<!-- order_id（有序guid编号） -->
		        { name: "hospitalId", sortable: false},<!-- 医疗机构编号 -->
		        { name: "hospitalName", sortable: false},<!-- 医疗机构名称 -->
		        { name: "hospitalDepartmentId", sortable: false},<!-- 医疗机构部门编号 -->
		        { name: "hospitalDepartmentName", sortable: false},<!-- 医疗机构部门名称 -->
		        { name: "orderType", sortable: false},<!-- 订单类型（0：正常订单，1：急救药品临时订单） -->
		        { name: "orderName", sortable: false},<!-- 订单名称 -->
		        { name: "orderAmount", sortable: false},<!-- 订单金额 -->
		        { name: "orderRamarks", sortable: false},<!-- 订单备注 -->
		        { name: "submitTime", sortable: false},<!-- 提交时间 -->
		        { name: "subminter", sortable: false},<!-- 提交人 -->
		        { name: "isAutoSubmint", sortable: false},<!-- 是否自动提交 -->
		        { name: "autoSubmitTime", sortable: false},<!-- 自动提交时间 -->
		        { name: "orderState", sortable: false},<!-- 完成进度(0:待提交,1:已提交) -->
		        { name: "defaultDistributeAddr", sortable: false},<!-- defaultDistributeAddr -->
		        { name: "addUserId", sortable: false},<!-- 记录添加人id -->
		        { name: "addUserName", sortable: false},<!-- 记录添加人 -->
		        { name: "addTime", sortable: false},<!-- 记录添加时间 -->
		        { name: "lastUpdateUserId", sortable: false},<!-- 最后一次更新记录人id -->
		        { name: "lastUpdateUserName", sortable: false},<!-- 最后一次更新记录人 -->
		        { name: "lastUpdateTime", sortable: false},<!-- 最后一次更新记录时间 -->
        ]      
	};
	
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoPurchaseReturn/getYimiaoPurchaseReturnData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
             caption: "" 
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoPurchaseReturn/getYimiaoPurchaseReturnData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
</script>
</html>