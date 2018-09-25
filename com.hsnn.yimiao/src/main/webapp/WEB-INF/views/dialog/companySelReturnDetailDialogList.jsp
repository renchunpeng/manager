<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<title>${title}</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<style>
.box-primary+.ui-jqgrid .ui-jqgrid-bdiv {
	height: 180px !important;
}
</style>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-success">
			<div class="box-body">
				<form action="#" id="searchForm" method="post">
					<div class="input">
						<div class="input">
							<div class="textalign1">
								<spring:message code="drugpurProcurecatalog.goodsName" />
								<spring:message code="message.yanZheng.maoHao" />
							</div>
							<div class="boxinput">
								<input type="text" class="textinput" id="goodsName"
									name="goodsName" placeholder="商品名称" maxlength="50" />
							</div>
							<div class="textalign1">
								<spring:message code="drugpurProcurecatalog.productName" />
								<spring:message code="message.yanZheng.maoHao" />
							</div>
							<div class="boxinput">
								<input type="text" class="textinput" id="productName"
									name="productName" placeholder="通用名" maxlength="50" />
							</div>
							<div class="textalign1">
								<spring:message code="drugpurProcurecatalog.medicinemodel" />
								<spring:message code="message.yanZheng.maoHao" />
							</div>
							<div class="boxinput">
								<input type="text" class="textinput" id="medicinemodel"
									name="medicinemodel" placeholder="剂型" maxlength="50" />
							</div>

						</div>
						<div class="input">
							<div class="textalign1">
								<spring:message code="drugpurProcurecatalog.outlook" />
								<spring:message code="message.yanZheng.maoHao" />
							</div>
							<div class="boxinput">
								<input type="text" class="textinput" id="outlook" name="outlook"
									placeholder="规格" maxlength="50" />
							</div>
							<div class="textalign1">
								<spring:message code="drugpurProcurecatalog.factor" />
								<spring:message code="message.yanZheng.maoHao" />
							</div>
							<div class="boxinput">
								<input type="text" class="textinput" id="factor" name="factor"
									placeholder="转换比" maxlength="50" />
							</div>
							<div class="textalign1">
								<spring:message code="drugpurProcurecatalog.materialName" />
								<spring:message code="message.yanZheng.maoHao" />
							</div>
							<div class="boxinput">
								<input type="text" class="textinput" id="materialName"
									name="materialName" placeholder="包装材质" maxlength="50" />
							</div>

						</div>
						<div class="input" style="position: relative;top:-8px;height:25px;">
						<div class="textalign1"><spring:message code="drugpurProcurecatalog.unit"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="unit" name="unit"  placeholder="单位" maxlength="50" />
	                    </div>
						<div class="textalign1">收货日期<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput" style="position: relative;top:8px;">
		                       <table style="width:100%;top:0" >
	                                     <tr>
	                                        <td style="width:50%">
	                                             <input class="textinput" id="startTime" name="startTime"   type="text" readonly="readonly"  placeholder="yyyy-MM-dd"  
	                                       onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})"  />
	                                        </td>
	                                        <td>&nbsp;-&nbsp;</td>
	                                        <td style="width:50%">
	                                           <input class="textinput" id="endTime" name="endTime"   type="text" readonly="readonly"   placeholder="yyyy-MM-dd" 
	                                      onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}'})"  />
	                                        </td>
	                                     </tr>
	                                  </table> 
	                    </div>
	                    <div class="textalign1"><spring:message code="payDetail.realAmount"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput" style="position: relative;top:8px;">
	                        <table style="width:100%;top:0" >
	                                     <tr>
	                                        <td style="width:50%">
	                                             <input class="textinput" id="startAmount" name="startAmount" onkeyup="this.value=this.value.replace(/[^\d\.]/g, '')"  type="text"  placeholder=""/>
	                                        </td>
	                                        <td>&nbsp;-&nbsp;</td>
	                                        <td style="width:50%">
	                                           <input class="textinput" id="endAmount" name="endAmount" onkeyup="this.value=this.value.replace(/[^\d\.]/g, '')"  type="text" placeholder="" />
	                                        </td>
	                                     </tr>
	                                  </table> 
	                    </div>
					</div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
			<button id="batchCancel" type="button" class="btn btn-success btn-sm">批量取消</button>
			<button id="btnClose" type="button" class="btn btn-sm btn-danger">关闭</button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var obj ={
			"names": [
			          '',
				'<spring:message code="message.jqGrid.cz"/>',
				'<spring:message code="drugpurProcurecatalog.goodsInfo"/>',<!-- 商品信息 -->
				'收货日期',
				'结算数量',<!-- 支付订单总金额 -->
				'结算金额'
	        ],
	        "model": [
				{ name: "storageId",hidden:true, align: 'center',sortable: false},
				{ name: 'operate', width: 60, align: 'center',sortable: false,
	            	formatter:function(val, opts, rowdata){
	            		var str =  "<a href='#' onclick=\"showDetail('"+rowdata.storageId+"')\">详情</a>";
	                	 str +=  "<a href='#' onclick=\"cancelOne('"+rowdata.storageId+"','"+rowdata.realAmount+"')\">取消</a>";
	                	return str;
	                }
	        	},
	        	{ name: "goodsInfo", width: 230,align: 'left',sortable: false, 
	            	formatter:function(val, opts, rowdata){
	        		 var goodsInfo="【"+rowdata.payDrugDetail.goodsName+"】"+"&nbsp;"+rowdata.payDrugDetail.productName+"<br/>"+rowdata.payDrugDetail.medicinemodel+"&nbsp;"+rowdata.payDrugDetail.outlook+"&nbsp;"+rowdata.payDrugDetail.factor+"&nbsp;"+rowdata.payDrugDetail.unit+"&nbsp;"+rowdata.payDrugDetail.materialName;
	 		   		 return goodsInfo;
	            	}
	        	},	
	        	{ name: "storageDate", align: 'center',sortable: false,
			    	formatter:function(val,opts, rowdata) {
	                	return new Date(val).format("yyyy-MM-dd HH:mm:ss") ;
	                }
	        	},
			    { name: "realQuantity",align: 'center', sortable: false},
			    { name: "realAmount", align: 'center',sortable: false}
	        ]      
	};
	
	
	
	$(function(){
		$('#searchForm :input').bind('keydown', function(event) {if (event.keyCode == "13") {event.preventDefault();$("#search").click();}})[0].focus();
		
		var payOrderData = JSON.parse(sessionStorage.payOrderData);
		$("#gridlist").jqGrid({
            url: "${ctx }/payOrder/getReturnDetailChoosed.html",
            colNames: obj.names,
            colModel: obj.model,
            postData: {"payOrderCode":payOrderData.payOrderCode},
            multiselect: true,
            caption: "" 
        });
        $(window).trigger("resize");
		
     // 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/payOrder/getReturnDetailChoosed.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
     
		// 批量取消
		$("#batchCancel").click(function(){
			cancel(2,"","");
		});
		// 关闭
		$("#btnClose").click(function(){
			closeDialog();
		});
	});
		
	function closeDialog() {
		 window.top.dialog({id:'returnDetail'}).close();
		 window.top.dialog({id:'returnDetail'}).remove();
	}
	
	//单个取消
	function cancelOne(storageId,realAmount) {
		cancel(1,storageId,realAmount);
	}
	
	//取消
	function cancel(type,storageId,realAmount) {
		var str = '';
		var title = '';
		var succM = '';
		var errorM = '';
		var strAmounts = '';
		if(type == 2) {//批量取消
			var rowIds = $("#gridlist").jqGrid("getGridParam", "selarrrow") || [];
	        if (rowIds.length <= 0) {
	        	top.$.HN.message.alert("请选择退款订单明细！", "消息", "warn");
	            return;
	        }
	        
	        for (var i=0; i<rowIds.length; i++) {
	            var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
	            str+=rowdata.storageId+',';
	            strAmounts+=rowdata.realAmount+',';
	        }
	        title = '确定要取消所选的退款订单明细？';
	        succM = '批量取消成功！';
			errorM = '批量取消失败！';
		} else if(type == 1) {//单个取消
			str = storageId;
			strAmounts = realAmount;
			title = '确定要取消该退款订单明细？';
	        succM = '取消成功！';
			errorM = '取消失败！';
		}
		
        $.HN.message.confirm(title, '', '').on(function (e) {
        	  if (e) {
        		  var payOrderData = JSON.parse(sessionStorage.payOrderData);
        		  
        		  var postData = {"payOrderCode":payOrderData.payOrderCode,"storageIds":str,"strAmounts":strAmounts};
        		   $.post("${ctx }/payOrder/cancelComPanyReturn.html",postData, function(result) {
                       if (result.success) {
                       	   top.$.HN.message.alert(succM, "消息", "success");
                       		$("#search").click();
                       } else {
                           top.$.HN.message.alert(result.msg | errorM, "消息", "error");
                       }
                   }, "json")

              }
        });
	}
	
	//显示详情
	function showDetail(storageId) {
		$.HN.dialog.open({
			"id" : "payDrugDetail",
			"title" : "详情",
			"url" : "${ctx}/payDrugDetail/toPayDrugDetail.html?storageId="+storageId,
			"data" : {},
			"width" : 1000,
			"height" : 500,
			"closefunc" : function(params) {
			}
		});
	}
</script>
</html>