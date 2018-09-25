<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>未完成退货记录</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="未完成退货记录"/></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.html"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#"><spring:message code="退货记录"/></a></li>
			<li class="active"><a href="#"><spring:message code="未完成退货记录"/></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form id="searchForm" method="post" >
					<div class="input">
	                    <div class="textalign1">疫苗编号：</div>
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
 						<div class="textalign1">生产企业：</div>
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
							 <select class="textinput"  id="orderdetailState" name="orderdetailState" style="width:40%">
								 <option value="">请选择</option>
								 <c:forEach items="${enum:getEnumValues('com.hsnn.medstgmini.util.enums.ReturnOrderStatus')}" var="items" >
									 <c:if test="${items.key==1||items.key==2||items.key==3}">
										 <option value="${items.key }">${items.value}</option>
									 </c:if>
								 </c:forEach>
							 </select>
						 </div>
	                 	<div class="textalign1">订单日期：</div>                    
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
		    '订单执行状态',
			'已退数量',
			'已退金额',
			'订单日期',
			'订单编号',
			'采购单位',
			'疫苗编号',
			'疫苗名称',
			'疫苗通用名',
			'制剂规格（申报剂型）',
			'生产企业（投标企业）',
			'配送企业',
			'最小制剂单位',
			'退货数量',
			'退货单价',
			'退货金额',
			'要求备注',
			'拒绝退货原因',
			'完成率(%)'
        ],
        "model": [
				{ name: "orderdetailRetId",key:true, sortable: false,hidden:true,align:'center'},
            { name: "orderdetailState", width: 60, align: 'center', sortable: false,
                formatter : function(val, opts, rowdata) {
                    return val==null?"":${enum:getEnumJSON('com.hsnn.medstgmini.util.enums.ReturnOrderDetailStatus')}[val];
                }
            },
                { name: "totalReturnCount", sortable: false,align:'center'},
                { name: "totalReturnAmount", sortable: false,align:'center',
		        	formatter:function(val, opts, rowdata){	
		        		if(val!=null){
							return val.toFixed(2);
		        		}else{
		        			return "0.00";
		        		}
				    }		
		        },
				{ name: "submitTime", sortable: false,align:'center',
					formatter:function(val, opts, rowdata){	
						if (val != null) {
							return new Date(val).format('yyyy-MM-dd');
						} else {
							return "暂未设置";
						}
				    }	
				},
		        { name: "orderId", sortable: false,hidden:true,align:'center'},
		        { name: "hospitalName", sortable: false,align:'center'},
		        { name: "goodsId", sortable: false,align:'center'},
		        { name: "goodsName", sortable: false,align:'center'},
		        { name: "productName", sortable: false,align:'center'},
		        { name: "outlook", sortable: false,align:'center',
                    formatter : function(val, opts, rowdata){
                        return rowdata.outlook+"（"+rowdata.medicinemodel+"）";
                    }
                },
		        { name: "companyNameSc", sortable: false,align:'center',
                    formatter : function(val, opts, rowdata){
                        return rowdata.companyNameSc+"（"+rowdata.companyNameTb+"）";
                    }
                },
		        { name: "companyNamePs", sortable: false,align:'center'},
		        { name: "unit", sortable: false,align:'center'},
		        { name: "purchaseCount", sortable: false,hidden:false,align:'center'},
		        { name: "purchasePrice", sortable: false,hidden:false,align:'center',
		        	formatter:function(val, opts, rowdata){	
		        		if(val!=null){
							return val.toFixed(2);
		        		}else{
		        			return "";
		        		}
				    }
		        },
		        { name: "purchaseAmount", sortable: false,hidden:false,align:'center',
		        	formatter:function(val, opts, rowdata){	
		        		if(val!=null){
							return val.toFixed(2);
		        		}else{
		        			return "";
		        		}
				    }	
		        },
		        { name: "orderCustomInfo", sortable: false,hidden:false,align:'center'},
		        
		        { name: "refuseReason", sortable: false,hidden:false,align:'center'},
		        { name: "compRatio", sortable: false,hidden:false,align:'center',hidden:true,
		        	formatter:function(val, opts, rowdata){	
		        		if(val!=null){
							return (val*100).toString().substring(0,5);
		        		}else{
		        			return "";
		        		}
				    }	
		        },
        ]      
	};
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx}/yimiaoOrderdetail/getYimiaoHospitalOrderDataret.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: false,
            caption: "未完成退货记录列表",
            rowNum: 20,
            shrinkToFit :false,
            gridComplete: function () {
                var ids = $("#gridlist").getDataIDs();
                var str="";
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
				url: "${ctx}/yimiaoOrderdetail/getYimiaoHospitalOrderDataret.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
	
	
	
	// 输入收货数量计算总收货金额和完成率
	function countUp(event,price,count,orderdetailId){
		
		//var keyCode = event.keyCode?event.keyCode:event.which?event.which:event.charCode;
			var warehouseCount=document.getElementById("Warehouse"+orderdetailId);
			if(!isNaN(parseInt(warehouseCount.value))){
				if(parseInt(warehouseCount.value)<=count){
					var returnTotal=(parseInt(warehouseCount.value)*price).toFixed(3);
					var compRatio=(parseInt(warehouseCount.value)/count*100).toFixed(4);
					$(warehouseCount).parents("tr").find("td:last").prev().text(returnTotal);
					$(warehouseCount).parents("tr").find("td:last").text(compRatio);
					
				}else{
					$(warehouseCount).val("");
					$(warehouseCount).parents("tr").find("td:last").prev().text("0");
					$(warehouseCount).parents("tr").find("td:last").text("0.0000");
					$.alert("退货数量必须小于等于申请退货数量！","warn");
					
				}
			}else{
				$(warehouseCount).val("");
				$(warehouseCount).parents("tr").find("td:last").prev().text("0");
				$(warehouseCount).parents("tr").find("td:last").text("0.0000");
				$.alert("请输入正确的数量！","warn");
				
			}
		
	}
	
	//导出
    function exportExcel(){
    	var postData = $("#searchForm").serializeJSON();
    	gridParam(postData);
    	$.StandardPost("${ctx}/yimiaoOrderdetail/exportDataToExcelNo.html",postData);
    	
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