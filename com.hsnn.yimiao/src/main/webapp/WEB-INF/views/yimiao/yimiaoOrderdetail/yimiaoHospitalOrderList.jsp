<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>未完成采购记录</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="未完成采购记录"/></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.html"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#"><spring:message code="采购记录"/></a></li>
			<li class="active"><a href="#"><spring:message code="未完成采购记录"/></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form id="searchForm" method="post" >
					<div class="input">
						<div class="textalign1"><spring:message code="疫苗编号"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsId" name="goodsId"  placeholder="疫苗编号" maxlength="50" />
	                    </div>
	                    <div class="textalign1">疫苗名称：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsName" name="goodsName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                   	<div class="textalign1">规格：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="规格" maxlength="50" />
	                    </div>
					</div>
 					<div class="input">
 						<div class="textalign1" style="width:85px">生产企业：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="生产企业" maxlength="50" />
	                    </div>
                        <div class="textalign1"><spring:message code="疫苗通用名"/><spring:message code="message.yanZheng.maoHao"/></div>
                        <div class="boxinput">
                            <input type="text" class="textinput"  id="productName" name="productName"  placeholder="疫苗通用名" maxlength="50" />
                        </div>
                        <div class="textalign1">配送企业：</div>
                        <div class="boxinput">
                            <input type="text" class="textinput"  id="companyNamePs" name="companyNamePs"  placeholder="配送企业" maxlength="50" />
                        </div>
	                 </div>
	                 <div class="input">
                         <div class="textalign1">订单执行状态：</div>
                         <div class="boxinput">
                             <select class="textinput"  id="confirmState" name="confirmState" style="width:40%">
                                 <option value="">请选择</option>
                                 <c:forEach items="${enum:getEnumValues('com.hsnn.medstgmini.util.enums.orderDetailStatus')}" var="items" >
                                     <c:if test="${items.key == 1 || items.key == 5}">
                                         <option value="${items.key }">${items.value}</option>
                                     </c:if>
                                 </c:forEach>
                                 <!-- <option value="b">供货完成</option> -->
                             </select>
                         </div>
	                 	<div class="textalign1">订单提交日期：</div>                    
						<div class="boxinput">
	                        <table style="width:100%" >
                                     <tr>
                                        <td style="width:50%;">
                                             <input class="textinput" id="startTime" name="startTime"  readonly="readonly"  placeholder="开始日期"  
                                       onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})"  />
                                        </td>
                                        <td>&nbsp;-&nbsp;</td>
                                        <td style="width:50%;">
                                           <input class="textinput" id="endTime" name="endTime"   type="text" readonly="readonly"   placeholder="结束日期" 
                                      onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}'})"  />
                                        </td>
                                     </tr>
                             </table> 
	                    </div>
	                 </div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
			<button id="save" type="button" class="btn btn-primary btn-sm" onclick="saveAll();">到货</button> 
			<button type="button" onclick="exportExcel();" class="btn btn-success btn-sm">导 出</button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
var obj ={
		"names": [
		    '明细编号',
			'订单编号',
            '订单名称',
            '疫苗编号',
            '疫苗名称',
            '疫苗通用名',
            '制剂规格（申报剂型）',
            '最小制剂单位',
            '采购数量',
            '到货数量',
            '已到货数量',
            '到货金额',
            '采购金额',
            '最小制剂单位中标价格（元）',
            '生产企业（投标企业）',
            '配送企业',
            '订单提交日期',
		    '订单执行状态',
			'要求备注',
			'未供货原因',
			'完成率(%)'
        ],
        "model": [
				{ name: "orderdetailId",key:true, sortable: false,hidden:true,align:'center'},
				{ name: "orderId",key:true, sortable: false,hidden:true,align:'center'},
                { name: "orderName", sortable: false,hidden:false,align:'center'},<!-- order_id（有序guid编号） -->
                { name: "goodsId", sortable: false,align:'center'},<!-- 医疗机构名称 -->
                { name: "goodsName", sortable: false,align:'center'},<!-- 名称 -->
                { name: "productName", sortable: false,align:'center'},<!-- 通用名 -->
                { name: "outlook", sortable: false,align:'center',
                    formatter : function(val, opts, rowdata){
                        return rowdata.outlook+"（"+rowdata.medicinemodel+"）";
                    }
				},<!-- 规格 -->
                { name: "unit", sortable: false,align:'center'},<!-- 单位 -->
                { name: "purchaseCount", sortable: false,hidden:false,align:'center'},<!-- 采购数量 -->
                { name: "warehouseCount", sortable: false,align:'center',
                    formatter:function(val, opts, rowdata){
                        if(rowdata.confirmState=="1" || rowdata.confirmState=="5"){
                            var count = rowdata.purchaseCount -rowdata.totalWarehouseCount;
                            return "<input  type=\"text\" id=\"Warehouse"+rowdata.orderdetailId+"\" value=\""+0+"\"  onkeyup=\"countUp(event,'"+rowdata.purchasePrice+"','"+rowdata.purchaseCount+"','"+rowdata.orderdetailId+"','"+count+"')\" />";
                        }else{
                            return "0";
                        }
                    }
                },
                { name: "totalWarehouseCount", sortable: false,align:'center'},
                { name: "totalWarehouseAmount", sortable: false,align:'center',
                    formatter:function(val, opts, rowdata){
                        if(val!=null){
                            return val.toFixed(2);
                        }else{
                            return "0.00";
                        }
                    }
                },
                { name: "purchasePrice", sortable: false,hidden:false,align:'center',
                    formatter:function(val, opts, rowdata){
                        if(val!=null){
                            return val.toFixed(2);
                        }else{
                            return "0.00";
                        }
                    }
                },<!-- 最小制剂单位中标价格（元）-->
                { name: "purchaseAmount", sortable: false,hidden:false,align:'center',
                    formatter:function(val, opts, rowdata){
                        if(val!=null){
                            return val.toFixed(2);
                        }else{
                            return "0.00";
                        }
                    }
                },<!-- 采购金额-->
                { name: "companyNameSc", sortable: false,align:'center',
                    formatter : function(val, opts, rowdata){
                        return rowdata.companyNameSc+"（"+rowdata.companyNameTb+"）";
                    }
                },<!-- 生产企业名称 -->
                { name: "companyNamePs", sortable: false,align:'center'},<!-- 配送企业名称 -->
				{ name: "submitTime", sortable: false,align:'center',
					formatter:function(val, opts, rowdata){	
						if (val != null) {
							return new Date(val).format('yyyy-MM-dd');
						} else {
							return "暂未设置";
						}
				    }	
				},<!-- 提交时间 -->
                { name: "confirmState", sortable: false,hidden:false,align:'center',
                    formatter:function(val, opts, rowdata){
                        return val == null?"":${enum:getEnumJSON('com.hsnn.medstgmini.util.enums.orderDetailStatus')}[val];
                    }
                },
		        { name: "orderCustomInfo", sortable: false,hidden:false,align:'center'},<!-- 要求备注 -->
		        { name: "refuseReason", sortable: false,hidden:false,align:'center',hidden:true},<!-- 拒绝理由 -->
		        { name: "compRatio", sortable: false,hidden:false,align:'center',
		        	formatter:function(val, opts, rowdata){	
		        		if(val!=null){
							return (val*100).toString().substring(0,5);
		        		}else{
		        			return "0.00";
		        		}
				    }	
		        },<!-- 完成率 -->
        ]      
	};
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx}/yimiaoOrderdetail/getYimiaoHospitalOrderData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            caption: "未完成采购记录列表",
            rowNum: 20,
            shrinkToFit :false,
            gridComplete: function () {
                var ids = $("#gridlist").getDataIDs();
              //完成率为空的用红色，完成率小于100的用蓝色，完成率为100的用黑色
                for (var i = 0; i < ids.length; i++) {
                    var rowData = $("#gridlist").getRowData(ids[i]);
                   // $('#' + ids[i]).find("td").css("color","white");
                    if(rowData.compRatio=='0.00'){
                    	$('#' + ids[i]).find("td").css("color","red");
                    }  else if (rowData.compRatio =='100.00') {
                        $('#' + ids[i]).find("td").css("color","black");
                    }else if (rowData.compRatio!='0.00'&&rowData.compRatio!='100.00') {
                        $('#' + ids[i]).find("td").css("color","blue");
                    }  
                }
            },
         loadComplete :function(xhr){
    		$("#gridlist").setCaption(xhr.msg);
        	}
        });
        $(window).trigger("resize");
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx}/yimiaoOrderdetail/getYimiaoHospitalOrderData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
	
	
	
	// 输入收货数量计算总收货金额和完成率
	function countUp(event,price,count,orderdetailId,countTwo){
		
		//var keyCode = event.keyCode?event.keyCode:event.which?event.which:event.charCode;
			var warehouseCount=document.getElementById("Warehouse"+orderdetailId);
			if(!isNaN(parseInt(warehouseCount.value))){
				if(parseInt(warehouseCount.value)<=countTwo){
					var returnTotal=(parseInt(warehouseCount.value)*price).toFixed(3);
					var compRatio=(parseInt(warehouseCount.value)/count*100).toFixed(4);
					$(warehouseCount).parents("tr").find("td:last").prev().text(returnTotal);
					$(warehouseCount).parents("tr").find("td:last").text(compRatio);
					
				}else{
					$(warehouseCount).val("");
					$(warehouseCount).parents("tr").find("td:last").prev().text("0");
					$(warehouseCount).parents("tr").find("td:last").text("0.0000");
					$.alert("到货数量必须小于等于采购数量！","warn");
                    return false;
				}
			}else{
				$(warehouseCount).val("");
				$(warehouseCount).parents("tr").find("td:last").prev().text("0");
				$(warehouseCount).parents("tr").find("td:last").text("0.0000");
				$.alert("请输入正确的数量！","warn");
				return false;
			}
		
	}
	//批量提交
	function saveAll(){
		var gridlist=  $("#gridlist");
		var list = [];
		var rowIds =gridlist.jqGrid("getGridParam", "selarrrow") || [];
		if (rowIds.length <= 0) {
        	top.$.HN.message.alert("请至少选择一个订单！", "消息", "warn");
            return false;
		}
        var reg = /^[1-9]\d*$/;
		for (var i=0; i<rowIds.length; i++) {
			var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
		    var totalWarehouseCount=$.trim($("#Warehouse"+rowdata.orderdetailId).val());
            var total=rowdata['totalWarehouseCount'];
            var purchaseCount=rowdata['purchaseCount'];
            var str=parseInt(totalWarehouseCount)+parseInt(total);
            if(parseInt(str)>parseInt(purchaseCount)){
                $.alert("到货数量大于采购数量！请重新输入","warn");
                return false;
			}
		    var totalWarehouseAmount=$.trim($("#Warehouse"+rowdata.orderdetailId).parents("tr").find("td:last").prev().text());
		    var compRatio=$.trim($("#Warehouse"+rowdata.orderdetailId).parents("tr").find("td:last").text());
		    var gonghuo=rowdata['confirmState'];
		    if(!reg.test(totalWarehouseCount)){
                $.alert("请输入正确的数量！","warn");
                return false;
			}
		    if (parseInt(totalWarehouseCount) == 0) {
				top.$.HN.message.alert("勾选的第"+(i+1)+"个到货数量必须大于0！", "消息", "warn");
	            return;
			}
		    list.push({
		    	"orderdetailId": rowdata.orderdetailId,
                "orderId":rowdata.orderId,
    			"warehouseCount": totalWarehouseCount,
    			"totalWarehouseAmount": totalWarehouseAmount,
    			"compRatio": compRatio
    		});
		}
		
		$.HN.message.confirm('确定要到货吗？', '', '').on(function (e) {
			if(e){
                $.ajax({
                    beforeSend:function () {
                        $("#save").attr("disabled", true);
                    },
					url: "${ctx}/yimiaoOrderdetail/updateOrderdetailsx.html",
					type: "post",
	             	dataType: "json",
	             	data:{"str":JSON.stringify(list)},
	             	success: function (result) {
	             		console.log(result);
                        $("#save").attr("disabled", false);
						if (result.success){
							$.alert("操作成功！", "success");
                            $("#search").click();
						} else {
							$.alert(result.msg, "error");
						}
					},
                    error:function () {
                        $("#save").attr("disabled", false);
                    }
				});
			}
		});
	}
	//是否供货下拉列表验证
	function stateChange(orderdetailId){
		var confirmState=$.trim($("#confirmState"+orderdetailId).val());
		var companyNamePs=$("#companyNamePs"+orderdetailId);
		var refuseReason=$("#refuseReason"+orderdetailId);
		if (confirmState==0) {
			$(companyNamePs).prop("disabled","disabled");
			$(refuseReason).prop("disabled","disabled");
			$(companyNamePs).prop("placeholder","");
			$(companyNamePs).prop("value","");
			$(refuseReason).prop("placeholder","");
			$(refuseReason).prop("value","");
		}
		if (confirmState==1) {
			$(companyNamePs).removeProp("disabled");
			$(refuseReason).prop("disabled","disabled");
			$(companyNamePs).prop("placeholder","请选择配送企业");
			$(refuseReason).prop("value","");
			$(refuseReason).prop("placeholder","");
			$(companyNamePs).focus();
		}
		if (confirmState==2) {
			$(refuseReason).removeProp("disabled");
			$(companyNamePs).prop("disabled","disabled");
			$(refuseReason).prop("placeholder","请输入未供货原因");
			$(companyNamePs).prop("placeholder","");
			$(companyNamePs).prop("value","");
			$(refuseReason).focus();
		}
	}
	
	
	//导出
    function exportExcel(){
    	var postData = $("#searchForm").serializeJSON();
    	gridParam(postData);
    	$.StandardPost("${ctx}/yimiaoOrderdetail/exportDataToExcelNCG.html",postData);
    	
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