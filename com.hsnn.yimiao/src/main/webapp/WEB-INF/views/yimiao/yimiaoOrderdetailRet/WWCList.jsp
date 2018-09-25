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
		<h1>未完成退货记录</h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#">退货记录</a></li>
			<li class="active"><a href="#">未完成退货记录</a></li>
			
		
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html" id="searchForm" method="post" >
					<div class="input">
						<div class="textalign1">疫苗编号：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsId" name="goodsId"  placeholder="疫苗编号" maxlength="50" />
	                    </div>
	                    <div class="textalign1">疫苗名称：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="productName" name="productName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1">规格：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="规格" maxlength="50" />
	                    </div>
					</div>
					<div class="input">
						<div class="textalign1">退货单位：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="hospitalName" name="hospitalName"  placeholder="退货单位" maxlength="50" />
	                    </div>
	                    <div class="textalign1">订单执行状态：</div>
	                    <div class="boxinput">
							<select class="textinput" name="orderdetailState">
								<option value="">请选择</option>
								<option value="2">待处理</option>
							</select>
	                    </div>
	                    <div class="textalign1">申请单日期：</div>
	                    <div class="boxinput">
	                    
                         <table style="width: 100%">
								<tr>
									<td style="width: 50%"><input class="textinput"
										id="startTime" name="startTime" type="text"
										readonly="readonly" placeholder="开始时间"
										onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})" />
									</td>
									<td>&nbsp;-&nbsp;</td>
									<td style="width: 50%"><input class="textinput"
										id="endTime" name="endTime" type="text" readonly="readonly"
										placeholder="结束时间"
										onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}'})" />
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
			<button id="saveAll" type="button" class="btn btn-primary btn-sm" onclick="saveAll()">确认</button>
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
            '完成率隐藏',
            '是否退货隐藏',
            '配送企业隐藏',
		    '操作',
		    'orderdetail_ret_id',
            'order_id',
			'订单明细id',
		    '订单执行状态',
			'未退货原因',
            '申请退货数量',
            '申请退货原因',
            '退货单价',
            '已退货金额',
            '配送企业',
			'申请单日期',
			'申请单名称',
			'退货单位',
			'疫苗编号',
			'疫苗名称',
            '制剂规格（申报剂型）',
            '生产企业（投标企业）',
			'最小制剂单位',
			'备注',
			'完成率(%)'
        ],
        "model": [
				{ name: "compRatio", sortable: false,hidden:true,align:'center'},
				{ name: "orderdetailState", sortable: false,hidden:true,align:'center'},
				{ name: "companyNamePs", sortable: false,hidden:true,align:'center'},
                { name: "oper",sortable: false,hidden:false,align:'center',width:80,//
                	formatter:function(val, opts, rowdata){
                		var str = "";
                        str +=
							"<a href='javascript:void(0)' onclick='saveStepTwo(\""+rowdata.orderdetailRetId+"\", \""+rowdata.orderId+"\", \""+rowdata.totalReturnCount+"\",\""+rowdata.orderDetailId+"\")'>确认</a>";

                        str += "<input type='hidden' id='type"+rowdata.orderdetailRetId+"'>";
                		return str;
				    }	
                },
                { name: "orderdetailRetId",key:true ,sortable: false,hidden:true,align:'center'},//
                { name: "orderId", sortable: false,hidden:true,align:'center'},
            	{ name: "orderDetailId", sortable: false,hidden:true,align:'center'},
                { name: "confirmStateY", sortable: false,hidden:false,align:'center',// '订单执行状态',
                    formatter:function(val, opts, rowdata){
		        		if(rowdata.orderdetailState==2){
		        			return "<select id=\"confirmState"+rowdata.orderdetailRetId+"\" style=\"color:black\" onchange=\"stateChange('"+rowdata.orderdetailRetId+"')\"><option value=\"0\">待处理</option><option value=\"4\">同意退货</option><option value=\"5\">不退货</option></select>";
		        		}else if(rowdata.orderdetailState==5){
		        			return "<span style=\"color:black\" id=\"WC"+rowdata.orderdetailRetId+"\">不退货</span>";
		        		}else{
		        			return "<span style=\"color:black\"  id=\"WC"+rowdata.orderdetailRetId+"\">同意退货</span>";
		        		}
				    }		
		        },
		        { name: "refuseReason", sortable: false,hidden:false,align:'center',// '未退货原因',
                    formatter:function(val, opts, rowdata){
		        		if(rowdata.orderdetailState==2){
		        			return "<input  type=\"text\" id=\"refuseReason"+rowdata.orderdetailRetId+"\" style=\"color:black\" disabled=\"disabled\"/>";
		        		}else if (val != null){
		        			return rowdata.refuseReason;
		        		}else {
		        			return "";
		        		}
				    }	
		        },
            { name: "totalReturnCount", sortable: false,hidden:false,align:'center'},// '申请退货数量',
            { name: "returnReason", sortable: false,hidden:false,align:'center'},//'申请退货原因',
            { name: "purchasePrice", sortable: false,hidden:false,align:'center',// '退货单价',
                formatter:function(val, opts, rowdata){
                    if(val!=null){
                        return val.toFixed(2);
                    }else{
                        return "0.00";
                    }
                }
            },
            { name: "totalReturnAmount", sortable: false  ,align:'center'   ,// '已退货金额',
                formatter:function(val, opts, rowdata){
                    if(val!=null){
                        return val.toFixed(2);
                    }else{
                        return "0.00";
                    }
                }
            },
			{ name: "companyNamePs", sortable: false,hidden:false,align:'center',//'配送企业',
			 },
				//{ name: "orderCustomInfo", sortable: false,hidden:false,align:'center'},//'退货原因'
				{ name: "submitTime", sortable: false,align:'center',// '申请单日期',
					formatter:function(val, opts, rowdata){	
						if (val != null) {
							return new Date(val).format('yyyy-MM-dd');
						} else {
							return "暂未设置";
						}
				    }	
				},
		        { name: "orderName", sortable: false,hidden:false,align:'center'},//'申请单名称',

		        { name: "hospitalName", sortable: false,align:'center'},//'退货单位'
		        { name: "goodsId", sortable: false,align:'center'},//'疫苗编号'
		        { name: "productName", sortable: false,align:'center'},//'疫苗名称'
            { name: "outlook", width: 150, align: 'center' ,sortable: false,
                formatter : function(val, opts, rowdata){
                    return rowdata.outlook+"（"+rowdata.medicinemodel+"）";
                }
            },//'规格'
            { name: "companyNameSc", width: 150, align: 'center' ,sortable: false,
                formatter : function(val, opts, rowdata){
                    return rowdata.companyNameSc+"（"+rowdata.companyNameTb+"）";
                }
            },//'生产企业',
		        { name: "unit", sortable: false,align:'center'},//'最小制剂单位',
		        { name: "orderCustomInfo", sortable: false,align:'center'},//'备注',

		        { name: "compRatioY", sortable: false,hidden:true,align:'center',// '完成率(%)
		        	formatter:function(val, opts, rowdata){	
		        		if(rowdata.compRatio!=null){
							return ((rowdata.compRatio)*100).toFixed(2);
		        		}else{
		        			return "0.00";
		        		}
				    }	
		        },
        ]      
	};
	
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoOrderdetailRet/getYimiaoOrderdetailRetData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            shrinkToFit :false,
             caption: "未完成退货记录列表" ,
             gridComplete: function () {
                 var ids = $("#gridlist").getDataIDs();
               //完成率为空的用红色，完成率小于100的用蓝色，完成率为100的用黑色
                 for (var i = 0; i < ids.length; i++) {
                     var rowData = $("#gridlist").getRowData(ids[i]);
                  //   $('#' + ids[i]).find("td").css("color","white");
                     if(rowData.compRatioY=='0.00'){
                     	$('#' + ids[i]).find("td").css("color","red");
                     }  else if (rowData.compRatioY =='100.00') {
                         $('#' + ids[i]).find("td").css("color","black");
                     }else if (rowData.compRatioY!='0.00'&&rowData.compRatioY!='100.00') {
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
			var startDate = $.trim($("#startTime").val());
		     var endDate = $.trim($("#endTime").val());
				if(endDate.length > 0 && startDate.length == 0) {
					$("#startDate").trigger("focus");
		         	$.alert("请选择开始月份！", "warn");
					return;
			}
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoOrderdetailRet/getYimiaoOrderdetailRetData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
	

	
	function saveStepTwo(orderdetailRetId,orderId,totalReturnCount,orderdetailId) {
        var select = $("#confirmState"+orderdetailRetId).val();
        var refuseReason = "";
        var orderDetailId = 0;
        if(select ==5){//不退货
            refuseReason =$.trim($("#refuseReason"+orderdetailRetId).val());
            orderDetailId = orderdetailId;
        }else if(select ==0){
            $("#returnCount"+orderdetailRetId).prop("disabled","disabled");
            $("#psqy"+orderdetailRetId).prop("disabled","disabled");
            $("#psqy"+orderdetailRetId).val("");
            $("#psqy"+orderdetailRetId).next().text("");
            $("#type"+orderdetailRetId).val("");
            $("#refuseReason"+orderdetailRetId).prop("disabled","disabled");
            $("#refuseReason"+orderdetailRetId).val("");
        }
		var list = [];
        var WC=$.trim($("#WC"+orderdetailRetId).text());
        if(WC=="不退货"){
            top.$.HN.message.alert("该退货记录不可再修改！", "消息", "warn");
            return;
        }else if (select==0) {
            top.$.HN.message.alert("请选择是否退货！", "消息", "warn");
            return;
        }else if (select==5 && (refuseReason==null || refuseReason=="")) {
            top.$.HN.message.alert("请填写不退货原因！", "消息", "warn");
            return;
        }
	    list.push({
            "orderdetailRetId": orderdetailRetId,
            "orderdetailState": select,
			"orderId":orderId,
            "refuseReason": refuseReason,
			"totalReturnCount": totalReturnCount,
			"orderDetailId": orderDetailId
		});
	  //确认
		$.ajax({
			url: "${ctx}/yimiaoOrderdetailRet/updateYimiaoOrderdetailRet.html",
			type: "post",
         	dataType: "json",
         	data:{"str":JSON.stringify(list)},
         	success: function (result) {
         		console.log(result);
				if (result.success){
					$.alert("操作成功！", "success");
                    $("#search").click();
				} else {
                    top.$.HN.message.alert(result.msg, "消息", "error");
				}
			}
		});
	}
	
	
	function saveAll(){
		var gridlist=  $("#gridlist");
		var list = [];
		var rowIds =gridlist.jqGrid("getGridParam", "selarrrow") || [];
		if (rowIds.length <= 0) {
        	top.$.HN.message.alert("请至少选择一条记录！", "消息", "warn");
            return;
		}
		for (var i=0; i<rowIds.length; i++) {
			var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
			var orderdetailState=$("#confirmState"+rowdata.orderdetailRetId).val();
			var orderdetailRetId = rowdata.orderdetailRetId;
            var orderId = rowdata.orderId;
		    var totalReturnCount=rowdata.totalReturnCount;
            var select = $("#confirmState"+orderdetailRetId).val();
            var refuseReason = "";
            var orderDetailId = 0;
            if(select ==5){//不退货
                refuseReason =$.trim($("#refuseReason"+orderdetailRetId).val());
                orderDetailId = rowdata.orderDetailId;
            }
		    if (orderdetailState == null || orderdetailState == "undefined") {
                orderdetailState = rowdata.orderdetailState;
		    }
            var WC=$.trim($("#WC"+orderdetailRetId).text());
		    if(WC=="不退货"){
		    	top.$.HN.message.alert("勾选的第"+(i+1)+"个不退货，请取消勾选！", "消息", "warn");
	            return;
		    }else if (orderdetailState==0) {
				top.$.HN.message.alert("请选择是否退货！", "消息", "warn");
	            return;
			}else if (orderdetailState==5 && (refuseReason==null || refuseReason=="")) {
				top.$.HN.message.alert("请填写不退货原因！", "消息", "warn");
	            return;
			}
		    list.push({
		    	"orderdetailRetId":orderdetailRetId,
    			"orderdetailState": orderdetailState,
                "orderId":orderId,
    			"refuseReason": refuseReason,
                "totalReturnCount": totalReturnCount,
                "orderDetailId": orderDetailId
    		});
		}
		//确认
		$.ajax({
			url: "${ctx}/yimiaoOrderdetailRet/updateYimiaoOrderdetailRet.html",
			type: "post",
			dataType: "json",
			data:{"str":JSON.stringify(list)},
			success: function (result) {
				console.log(result);
				if (result.success){
					$.alert("操作成功！", "success");
                    $("#search").click();
				} else {
					top.$.HN.message.alert(result.msg, "消息", "error");
				}
			}
		});
	}
	
	function stateChange(orderdetailRetId){
		var select = $("#confirmState"+orderdetailRetId).val();
		if(select ==4){//同意退货
			$("#psqy"+orderdetailRetId).removeProp("disabled");
			$("#refuseReason"+orderdetailRetId).prop("disabled","disabled");
			$("#returnCount"+orderdetailRetId).removeProp("disabled");
			$("#refuseReason"+orderdetailRetId).val("");
		}else if(select ==5){// 不同意退货
			$("#refuseReason"+orderdetailRetId).removeProp("disabled");
			$("#returnCount"+orderdetailRetId).prop("disabled","disabled");
			$("#psqy"+orderdetailRetId).prop("disabled","disabled");
			$("#psqy"+orderdetailRetId).val("");
			$("#psqy"+orderdetailRetId).next().text("");
			$("#type"+orderdetailRetId).val("");
		}else if(select ==0){
			$("#returnCount"+orderdetailRetId).prop("disabled","disabled");
			$("#psqy"+orderdetailRetId).prop("disabled","disabled");
			$("#psqy"+orderdetailRetId).val("");
			$("#psqy"+orderdetailRetId).next().text("");
			$("#type"+orderdetailRetId).val("");
			$("#refuseReason"+orderdetailRetId).prop("disabled","disabled");
			$("#refuseReason"+orderdetailRetId).val("");
		}
	}
	
	// 输入退货数量计算退货金额和完成率
	function countUp(event,price,count,orderdetailRetId,countPs){
		
		//var keyCode = event.keyCode?event.keyCode:event.which?event.which:event.charCode;
			var returnCount=document.getElementById("returnCount"+orderdetailRetId);
			if(!isNaN(parseInt(returnCount.value))){
				if(parseInt(returnCount.value)<=countPs){
					var returnTotal=(parseInt(returnCount.value)*price).toFixed(3);
					var compRatio=(parseInt(returnCount.value)/count*100).toFixed(4);
					$(returnCount).parents("tr").find("td:last").prev().text(returnTotal);
					$(returnCount).parents("tr").find("td:last").text(compRatio);
					
				}else{
					$(returnCount).val("");
					$(returnCount).parents("tr").find("td:last").prev().text("");
					$(returnCount).parents("tr").find("td:last").text("");
					$.alert("退货数量必须小于等于申请退货数量！","warn");
                    return false;
				}
			}else{
				$(returnCount).val("");
				$(returnCount).parents("tr").find("td:last").prev().text("");
				$(returnCount).parents("tr").find("td:last").text("");
				$.alert("请输入正确的数量！","warn");
				return false;
			}
		
	}
	
	function psBtn(rowId){
		 $.HN.dialog.open({
	            "id": "showPsCompInfo", 
	            "title": "选择配送企业", 
	            "url": "${ctx}/yimiaoOrderdetailRet/toYimiaoPSList.html",
	            "data": {}, 
	            "width": 800, 
	            "height": 500, 
				"closefunc":function(params) {
					/* alert(params.delCompCode);
					alert(params.delCompName); */
					
					//$("#gridlist").jqGrid('setCell',rowId,"companyNamePs",params.delCompName);
					var psqy=document.getElementById("psqy"+rowId);
					if(params.delCompName!=null&&params.delCompCode!=null){				
						psqy.value=params.delCompName;
						$(psqy).next().text(params.delCompCode);
					}
					var type=document.getElementById("type"+rowId);
					type.value="step1";
					/* $("#gridlist").jqGrid("setGridParam", {
						mtype: "post",
						url: "${ctx}/yimiaoOrderdetail/getYimiaoOrderData.html",
					}).trigger("reloadGrid");//重新载入 */
				}
	            
	       });  
	}
	//导出
    function exportExcel(){
    	var postData = $("#searchForm").serializeJSON();
    	gridParam(postData);
    	$.StandardPost("${ctx}/yimiaoOrderdetail/exportDataToExcelNoSC.html",postData);
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