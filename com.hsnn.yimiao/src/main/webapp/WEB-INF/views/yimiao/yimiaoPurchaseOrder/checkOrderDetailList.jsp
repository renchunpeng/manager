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
				<form action="${ctx }/yimiaoPurchaseOrder/getYimiaoOrderdetailData.html" id="searchForm" method="post" >
					<div class="input">
		            	<div class="textalign1"><spring:message code="疫苗编号"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsId" name="goodsId"  placeholder="疫苗编号" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="疫苗名称"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsName" name="goodsName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="规格"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="规格" maxlength="50" />
	                        <input type="text" class="textinput"  id="orderId" name="orderId" value="${orderId }" hidden="true" maxlength="50" />
	                    </div>
                    	<input style="display:none;"/><!-- 防止回车表单自动提交 -->
					</div>
					<div class="input">
						<div class="textalign1"><spring:message code="生产企业"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="生产企业" maxlength="100" />
	                    </div>
						<div class="textalign1"><spring:message code="疫苗通用名"/><spring:message code="message.yanZheng.maoHao"/></div>
						<div class="boxinput">
							<input type="text" class="textinput"  id="productName" name="productName"  placeholder="疫苗通用名" maxlength="50" />
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
			<button id="back" type="button" class="btn btn-success btn-sm" onclick="goback();">返回</button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
var obj ={
		"names": [
			'采购数量',
			'采购总金额',
			'疫苗编号',
			'疫苗名称',
			'疫苗通用名',
			'制剂规格（申报剂型）',
			'生产企业（投标企业）',
		    '最小制剂单位中标价格（元）',
			'最小制剂单位',
			'备注',
        ],
        "model": [
				{ name: "purchaseCount", sortable: false, width: 50,},
				{ name: "purchaseAmount", sortable: false,width: 70,
					formatter : function(val, opts, rowdata){
						if (val!=null) {
							return val.toFixed(3);
						} else {
							return "";
						}
					}
				},
				{ name: "goodsId", key:true, width: 100, align: 'center' ,sortable: false},
		        { name: "goodsName", width: 150, align: 'center' ,sortable: false},
		        { name: "productName", width: 150, align: 'center' ,sortable: false},
		        { name: "outlook", width: 150, align: 'center' ,sortable: false,
                    formatter : function(val, opts, rowdata){
                        return rowdata.outlook+"（"+rowdata.medicinemodel+"）";
                    }
                },
		        { name: "companyNameSc", width: 150, align: 'center' ,sortable: false,
                    formatter : function(val, opts, rowdata){
                        return rowdata.companyNameSc+"（"+rowdata.companyNameTb+"）";
                    }
                },
				{ name: "bidPrice", width: 60, align: 'center' ,sortable: false,
	            	formatter : function(val, opts, rowdata){
						if (val!=null) {
							return val.toFixed(3);
						} else {
							return "暂无";
						}
					}	
				},
		        { name: "unit", width: 50, align: 'center' ,sortable: false},
		        { name: "orderCustomInfo",  align: 'center' ,sortable: false},
        ]      
	};
	
	
	
	
	$(function(){
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html",
            colNames: obj.names,
            colModel: obj.model,
            postData: queryData,
            multiselect: false,
             caption: "采购单详情"
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
		
		
		
	});
	function goback(){
		window.location.href="${ctx}/yimiaoPurchaseOrder/toOrderCheckList.html";
	}
	
</script>
</html>