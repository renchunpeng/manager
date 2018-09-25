<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title><spring:message code="调价表列表-待修改"/></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/yimiaoPriceadjplan/getYimiaoPriceadjplanData.html" id="searchForm" method="post" >
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
			'<spring:message code="yimiaoPriceadjplan.priceAdjPlanId"/>',<!-- 调价计划id -->
			'<spring:message code="yimiaoPriceadjplan.priceAdjPlanName"/>',<!-- 调价计划名称 -->
			'<spring:message code="yimiaoPriceadjplan.priceAdjPlanCat"/>',<!-- 调价计划类型 -->
			'<spring:message code="yimiaoPriceadjplan.executeCat"/>',<!-- 执行类型：1立刻执行2定时执行 -->
			'<spring:message code="yimiaoPriceadjplan.createDatetime"/>',<!-- 创建时间 -->
			'<spring:message code="yimiaoPriceadjplan.createUser"/>',<!-- 创建人 -->
			'<spring:message code="yimiaoPriceadjplan.createOrgId"/>',<!-- createOrgId -->
			'<spring:message code="yimiaoPriceadjplan.executeDatetime"/>',<!-- 执行时间 -->
			'<spring:message code="yimiaoPriceadjplan.priceAdjAccord"/>',<!-- 调价依据 -->
			'<spring:message code="yimiaoPriceadjplan.remark"/>',<!-- 备注 -->
			'<spring:message code="yimiaoPriceadjplan.status"/>',<!-- 状态0未执行1已执行 -->
			'<spring:message code="yimiaoPriceadjplan.updDatetime"/>',<!-- 更新时间 -->
			'<spring:message code="yimiaoPriceadjplan.updUser"/>',<!-- 更新人 -->
        ],
        "model": [
			{ name: 'operate', width: 40, align: 'center',sortable: false,
            	formatter:function(val, opts, rowdata){
                	var str =  "<a href='${ctx }/yimiaoPriceadjplan/toUpdate.html?priceAdjPlanId=" + rowdata.priceAdjPlanId + "' style='background:url(${ctx }/lib/img/icon/icon.png) no-repeat 0px 0px' class='opIcon' title='更新'></a>";
                	return str;
                }
        	},
		        { name: "priceAdjPlanId", key:true, sortable: false},<!-- 调价计划id -->
		        { name: "priceAdjPlanName", sortable: false},<!-- 调价计划名称 -->
		        { name: "priceAdjPlanCat", sortable: false},<!-- 调价计划类型 -->
		        { name: "executeCat", sortable: false},<!-- 执行类型：1立刻执行2定时执行 -->
		        { name: "createDatetime", sortable: false},<!-- 创建时间 -->
		        { name: "createUser", sortable: false},<!-- 创建人 -->
		        { name: "createOrgId", sortable: false},<!-- createOrgId -->
		        { name: "executeDatetime", sortable: false},<!-- 执行时间 -->
		        { name: "priceAdjAccord", sortable: false},<!-- 调价依据 -->
		        { name: "remark", sortable: false},<!-- 备注 -->
		        { name: "status", sortable: false},<!-- 状态0未执行1已执行 -->
		        { name: "updDatetime", sortable: false},<!-- 更新时间 -->
		        { name: "updUser", sortable: false},<!-- 更新人 -->
        ]      
	};
	
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoPriceadjplan/getYimiaoPriceadjplanData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            caption: "<spring:message code="调价表列表-待修改"/>"
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoPriceadjplan/getYimiaoPriceadjplanData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
</script>
</html>