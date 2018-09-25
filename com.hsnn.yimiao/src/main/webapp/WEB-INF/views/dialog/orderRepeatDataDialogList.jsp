<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<table id="gridlist" class="jqgrid"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
var obj ={
		"names": [
			'<spring:message code="order_detail_id（有序guid编号）"/>',
			'<spring:message code="order_id（有序guid编号）"/>',
			'',
			'<spring:message code="采购数量"/>',
			'<spring:message code="配送企业名称"/>',
			'<spring:message code="采购价"/>',
			'<spring:message code="产品Id"/>',
			'商品信息',
			'<spring:message code="订单明细配送地址"/>',
        ], //采购数量 配送企业 采购价 产品Id 商品信息 订单明细配送地址
        "model": [
                { name: "orderDetailId",hidden:true, width: 10, align: 'center' ,sortable: false},
  		        { name: "orderId", width: 10,hidden:true, align: 'center' ,sortable: false},
  		        { name: "procurecatalogId", width: 10,hidden:true, align: 'center' ,sortable: false},
				{ name: "purchaseCount", width: 10, align: 'center' ,sortable: false},
			    { name: "companyNamePs", width: 10, align: 'center' ,sortable: false},
				{ name: "purchasePrice", width: 10, align: 'center' ,sortable: false},
		        { name: "goodsId", width: 10, align: 'center' ,sortable: false},
		        { name: "goodsInfo", sortable: false,width: 30, align: 'left' ,
		        	formatter:function(val, opts, rowdata){
			           var goodsInfo="<spring:message code='message.fuhao.zhongkuohao.before'/>"+rowdata.goodsName+"<spring:message code='message.fuhao.zhongkuohao.after'/>"+"&nbsp;"+rowdata.productName+"<br/>"+rowdata.medicinemodel+"&nbsp;"+rowdata.outlook+"&nbsp;"+rowdata.factor+"&nbsp;"+rowdata.unit+"&nbsp;"+rowdata.materialName;
	      		   	   return goodsInfo;
			        }
			    },
		        { name: "detailDistributeAddress", width: 10, align: 'center' ,sortable: false},
        ]      
	};
$(function(){
	$("#gridlist").jqGrid({
        url: "${ctx }/drugpurPurchaseOrderdetailRecent/getOrderRepeatData.html",
        colNames: obj.names,
        colModel: obj.model,
        postData:{"orderId":"${orderId}"},
        caption: "<spring:message code="列表-单内重复数据"/>"
    });
    $(window).trigger("resize");
});

</script>
</html>