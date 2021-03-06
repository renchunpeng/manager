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
		<h1>采购记录</h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#">采购记录</a></li>
			
		
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html" id="searchForm" method="post" >
					<div class="input">
						<div class="textalign1"><spring:message code="疫苗编号"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsId" name="goodsId"  placeholder="疫苗编号" maxlength="50" />
	                    </div>
	                    <div class="textalign">疫苗名称：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="productName" name="productName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1" style="width:85px">规格：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="规格" maxlength="50" />
	                    </div>
					</div>
					
					<div class="input">
						<div class="textalign1">生产企业：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="生产企业" maxlength="50" />
	                    </div>
	                    <div class="textalign">采购单位：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="hospitalName" name="hospitalName"  placeholder="采购单位" maxlength="50" />
	                    </div>
	                    <div class="textalign1">订单日期：</div>
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
					<div class="input">
						<div class="textalign1">是否完成：</div>
	                    <div class="boxinput">
	                        <select class="textinput" name="ratio">
	                        	<option value="">请选择</option>
	                        	<option value="0"  selected="selected">未完成</option>
	                        	<option value="1">已完成</option>
	                        
	                        </select>
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
			'订单日期',
			'订单名称',
			'采购单位',
			'疫苗编号',
			'疫苗名称',
			'规格',
			'生产企业',
			'最小制剂单位',
			'采购数量',
			'最小制剂单位中标价格（元）',
			'采购金额',
			'要求备注',
			'是否供货',
			'未供货原因',
			'配送企业',
			'到货数量',
			'到货金额',
			'完成率(%)'
        ],
        "model": [
				{ name: "submitTime", sortable: false,align:'center',
					formatter:function(val, opts, rowdata){	
						if (val != null) {
							return new Date(val).format('yyyy-MM-dd');
						} else {
							return "暂未设置";
						}
				    }	
				},
		        { name: "orderName", sortable: false,hidden:false,align:'center'},
		        { name: "hospitalName", sortable: false,align:'center'},
		        { name: "goodsId", sortable: false,align:'center'},
		        { name: "productName", sortable: false,align:'center'},
		        { name: "outlook", sortable: false,align:'center'},
		        { name: "companyNameSc", sortable: false,align:'center'},
		        { name: "unit", sortable: false,align:'center'},
		        { name: "purchaseCount", sortable: false,hidden:false,align:'center'},
		        { name: "purchasePrice", sortable: false,hidden:false,align:'center',
		        	formatter:function(val, opts, rowdata){	
		        		if(val!=null){
							return val.toFixed(2);
		        		}else{
		        			return "0.00";
		        		}
				    }
		        },
		        { name: "purchaseAmount", sortable: false,hidden:false,align:'center',
		        	formatter:function(val, opts, rowdata){	
		        		if(val!=null){
							return val.toFixed(2);
		        		}else{
		        			return "0.00";
		        		}
				    }	
		        },
		        { name: "orderCustomInfo", sortable: false,hidden:false,align:'center'},
		        { name: "confirmState", sortable: false,hidden:false,align:'center',
		        	formatter:function(val, opts, rowdata){	
		        		if(val!=null){
							return {0:"待处理",1:"供货",2:"不供货"}[val];
		        		}else{
		        			return "暂未设置";
		        		}
				    }		
		        },
		        { name: "refuseReason", sortable: false,hidden:false,align:'center'},
		        { name: "companyNamePs", sortable: false,hidden:true,align:'center'},
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
		        { name: "compRatio", sortable: false,hidden:false,align:'center',
		        	formatter:function(val, opts, rowdata){	
		        		if(val!=null){
							return (val*100).toString().substring(0,5);
		        		}else{
		        			return "0.00";
		        		}
				    }	
		        },
        ]      
	};
	
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html?ratio=0&confirmState=1&isUsing=1",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: false,
            shrinkToFit :false,
             caption: "采购记录列表",
             gridComplete: function () {
                 var ids = $("#gridlist").getDataIDs();
                 var str="";
               //完成率为空的用红色，完成率小于100的用蓝色，完成率为100的用黑色
                 for (var i = 0; i < ids.length; i++) {
                     var rowData = $("#gridlist").getRowData(ids[i]);
                   //  $('#' + ids[i]).find("td").css("color","white");
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
			var startDate = $.trim($("#startTime").val());
		     var endDate = $.trim($("#endTime").val());
				if(endDate.length > 0 && startDate.length == 0) {
					$("#startDate").trigger("focus");
		         $.alert("请选择开始月份！", "warn");
					return;
			}
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html?confirmState=1&isUsing=1",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
	//导出
    function exportExcel(){
    	var postData = $("#searchForm").serializeJSON();
    	gridParam(postData);
    	$.StandardPost("${ctx}/yimiaoOrderdetail/exportDataToExcelPS.html",postData);
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