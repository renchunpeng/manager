<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
	<link href="${ctx}/lib/plugins/jqgrid/ui.jqgrid.css" rel="stylesheet"type="text/css" media="print"/>
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
						
	                    <div class="textalign1" style="width:110px">疫苗名称：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="productName" name="productName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1" style="width:85px">规格：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="规格" maxlength="50" />
	                    </div>
						
					</div>
					<div class="input">
						<div class="textalign1" style="width:85px">采购单位：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="hospitalName" name="hospitalName"  placeholder="采购单位" maxlength="50" />
	                    </div>
	                    <div class="textalign1" style="width:110px">订单执行状态：</div>
	                    <div class="boxinput">
	                    	<select class="textinput"  id="confirmState" name="confirmState" style="width:40%"> 
	                        	 <option value="">请选择</option>
								<c:forEach items="${enum:getEnumValues('com.hsnn.medstgmini.util.enums.orderDetailStatus')}" var="items" >
                                    <c:if test="${items.key==0||items.key==1||items.key==5}">
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

						<div id="advanceSearch" class="advanceSearch"></div>
	                 </div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
			<button id="save" type="button" class="btn btn-primary btn-sm" onclick="saveAll();">提 交</button>
			<button type="button" onclick="exportExcel();" class="btn btn-success btn-sm">导 出</button>
			<%--<button type="button" onclick="orderPrint();" class="btn btn-success btn-sm">打 印</button>--%>
            <a href="${ctx}/yimiaoOrderdetail/toYimiaoOrderPrint.html" class="btn btn-success btn-sm" target="_blank">打 印</a>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript" src="${ctx}/lib/js/jQuery.print.js"></script>
<script type="text/javascript" src="${ctx}/lib/js/jquery.PrintArea.js"></script>
<script type="text/javascript">
	var obj ={
		"names": [
		    '',
			'<spring:message code="message.jqGrid.cz"/>',
			'订单执行状态',
			'未供货原因',
			'配送企业',
			'订单日期',
			'订单名称',
			'采购单位',
			'疫苗编号',
			'疫苗名称',
            '制剂规格（申报剂型）',
            '生产企业（投标企业）',
			'最小制剂单位',
			'采购数量',
			'最小制剂单位中标价格（元）',
			'采购金额',
			'要求备注',
			'到货数量',
			'到货金额',
			'完成率(%)',
        ],
        "model": [
			{ name: "orderdetailId", key:true, width: 250, align: 'center' ,sortable: false, hidden: true},
      		{ name: 'operate', width: 60, align: 'center',sortable: false,
    			formatter:function(val, opts, rowdata){
    				if (rowdata.confirmState==0) {
	    				return "<a href=\"javascript:void(0)\" onclick=\"save('"+rowdata.orderdetailId+"');\" class=\"opIcon detailIcon\" title=\"提交\">提交</a>";	
    				} else {
    					return "";
    				}
                }
            },
			{ name: "confirmState", width: 90, align: 'center', sortable: false,
				formatter:function(val, opts, rowdata){
					var str="";
					if (rowdata.confirmState==1) {
						str+="<span id=\"gonghuo"+rowdata.orderdetailId+"\">供货</span>";
					} else if(rowdata.confirmState==5) {
						str+="<span id=\"gonghuo"+rowdata.orderdetailId+"\">收货中</span>";
					} else {
						str+="<select id=\"confirmState"+rowdata.orderdetailId+"\" name=\"confirmState\" style=\"color: black\" class=\"textinput\" onchange=\"stateChange('"+rowdata.orderdetailId+"');\">"; 
	                    str+="<option value=\"0\">待处理</option>";
	                    str+="<option value=\"1\">供货</option>";
	                    str+="<option value=\"2\">不供货</option>";
	                    str+="</select>";
					}         
                    return str;
				}
			},
			{ name: "refuseReason", width: 160, align: 'center', sortable: false,
				formatter:function(val, opts, rowdata){
					var str="";
					if (rowdata.confirmState==2 || rowdata.confirmState==1) {
						str+="<span id=\"refuseReason"+rowdata.orderdetailId+"\">"+(val==null?"":val)+"</span>";
					} else {
						str+="<input id=\"refuseReason"+rowdata.orderdetailId+"\" name=\"refuseReason\" type=\"text\" class=\"textinput\" style=\"color: black\" disabled=\"disabled\" />";
					}
					return str;
				}
			},
			{ name: "companyNamePs", width: 200, align: 'center', sortable: false,
				formatter:function(val, opts, rowdata){
			    	var companyName = rowdata.wtCompanyNamePs;
                    var strs= new Array();
                    var companyNamePs = '${companyNamePs}';
                    strs=companyName.split(",");
                    var str="<select id='companyNamePs"+rowdata.orderdetailId+"' name='companyNamePs' style='color:black'>";
                    for (var i=0;i<strs.length ;i++ )
                    {
                        str+="<option value="+strs[i]+">"+strs[i]+"</option>"; //分割后的字符输出
                    }
                    str+="<option value="+companyNamePs+">"+companyNamePs+"</option>";
                    str +="</select>";
                    if(rowdata.confirmState==1 || rowdata.confirmState==5){
                        return val;
                    }else{
                        return str;
                    }
				}
			},
        	{ name: "submitTime", width: 130, align: 'center', sortable: false,
				formatter:function(val, opts, rowdata){         	
					return val!=null?new Date(val).format("yyyy-MM-dd HH:mm:ss"):'';
				}
			},
			{ name: "orderName", width: 250, align: 'center' ,sortable: false, hidden: false},
			{ name: "hospitalName", width: 180, align: 'center', sortable: false},
			{ name: "goodsId", width: 100, align: 'center', sortable: false},
			{ name: "productName", width: 200, align: 'center', sortable: false},
			{ name: "outlook", width: 140, align: 'center', sortable: false,
                formatter : function(val, opts, rowdata){
                    return rowdata.outlook+"（"+rowdata.medicinemodel+"）";
                }
			},
			{ name: "companyNameSc", width: 260, align: 'center', sortable: false,
                formatter : function(val, opts, rowdata){
                    return rowdata.companyNameSc+"（"+rowdata.companyNameTb+"）";
                }
			},
			{ name: "unit", width: 60, align: 'center', sortable: false},
			{ name: "purchaseCount", width: 60, align: 'center', sortable: false},
			{ name: "purchasePrice", width: 60, align: 'center', sortable: false,
				formatter:function(val, opts, rowdata){
					if (val != null) {
						return val.toFixed(2);
					} else {
						return "0.00";
					}
				}
			},
			{ name: "purchaseAmount", width: 60, align: 'center', sortable: false,
				formatter:function(val, opts, rowdata){
					if (val != null) {
						return val.toFixed(2);
					} else {
						return "0.00";
					}
				}
			},
			{ name: "orderCustomInfo", width: 100, align: 'center', sortable: false,
				formatter:function(val, opts, rowdata){
					return val!=null?val:"无";
				}	
			},
			{ name: "totalWarehouseCount", width: 60, align: 'center', sortable: false},
			{ name: "totalWarehouseAmount", width: 60, align: 'center', sortable: false,
				formatter:function(val, opts, rowdata){
					if (val != null) {
						return val.toFixed(2);
					} else {
						return "0.00";
					}
				}
			},
			{ name: "compRatio", width: 70, align: 'center', sortable: false,
				formatter:function(val, opts, rowdata){         	
					if(val!=null){
						return (val*100).toString().substring(0,5);
					}else{
						return "0.00";
					}
				}},
        ]      
	};
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx}/yimiaoOrderdetail/getYimiaoOrderData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            caption: "未完成采购记录列表",
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
				url: "${ctx}/yimiaoOrderdetail/getYimiaoOrderData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});

        showHideCol("gridlist", "advanceSearch");
        initAdvanceSearch("searchTypeButton", "searchType");
	});
	//选择配送企业
	function psBtn(rowId){
		 $.HN.dialog.open({
	            "id": "showPsCompInfo", 
	            "title": "配送企业列表", 
	            "url": "${ctx}/yimiaoOrderdetail/toYimiaoPSList.html",
	            "data": {}, 
	            "width": 800, 
	            "height": 500, 
				"closefunc":function(params) {
					if (params.delCompName!=null) {
						$("#companyNamePs" + rowId).next().text(params.delCompCode);
						$("#companyNamePs" + rowId).val(params.delCompName);
					}
				}
	       });  
	}
	//提交
	function save(orderdetailId){
        var select = $("#confirmState"+orderdetailId).val();
		var confirmState=$.trim($("#confirmState"+orderdetailId).val());
	    var refuseReason=$.trim($("#refuseReason"+orderdetailId).val());
	    var companyIdPs=$.trim($("#companyNamePs"+orderdetailId).next().text());
	    var companyNamePs=$.trim($("#companyNamePs"+orderdetailId).val());
	    var gonghuo=$.trim($("#gonghuo"+orderdetailId).text());

        var list = [];

        if (select==0) {
            top.$.HN.message.alert("请选择是否供货！", "消息", "warn");
            return;
        }
	    if (gonghuo=="供货") {
			top.$.HN.message.alert("订单已经供货了！", "消息", "warn");
            return false;
		}
	    if (confirmState==2 && (refuseReason==null || refuseReason=="")) {
			top.$.HN.message.alert("请填写未供货原因！", "消息", "warn");
            return false;
		}
	    if (confirmState==1 && (companyNamePs==null || companyNamePs=="")) {
			top.$.HN.message.alert("请选择配送企业！", "消息", "warn");
            return false;
		}

        list.push({
            "orderdetailId": orderdetailId,
            "confirmState": confirmState,
            "refuseReason": refuseReason,
            "companyIdPs": companyIdPs,
            "companyNamePs": companyNamePs
        });

		$.HN.message.confirm('确定要提交吗？', '', '').on(function (e) {
			if(e){
				$.ajax({
					url: "${ctx}/yimiaoOrderdetail/updateAllOrderdetail.html",
					type: "post",
					data: {"str":JSON.stringify(list)},
	             	dataType: "json",
	             	success: function (result) {
	             		console.log(result);
						if (result.success){
							$.alert("订单提交成功！", "success");
							$("#gridlist").jqGrid("setGridParam", {
								mtype: "post",

								url: "${ctx}/yimiaoOrderdetail/getYimiaoOrderData.html"
							}).trigger("reloadGrid");  //重新载入
						} else {
							$.alert("<spring:message code="message.HN.alert.fail"/>", "error");
						}
					}
				});
			}
		});		
	}
	//批量提交
	function saveAll(){
		var gridlist=  $("#gridlist");
		var list = [];
		var rowIds =gridlist.jqGrid("getGridParam", "selarrrow") || [];
		for (var i=0; i<rowIds.length; i++) {
			var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            var confirmState=$.trim($("#confirmState"+rowdata.orderdetailId).val());
		    var refuseReason=$.trim($("#refuseReason"+rowdata.orderdetailId).val());
		    var companyIdPs=$.trim($("#companyNamePs"+rowdata.orderdetailId).next().text());
		    var companyNamePs=$.trim($("#companyNamePs"+rowdata.orderdetailId).val());
		    var gonghuo=$.trim($("#gonghuo"+rowdata.orderdetailId).text());
		    if (gonghuo=="供货") {
				top.$.HN.message.alert("订单已经供货了！", "消息", "warn");
	            return false;
			}
		    if (confirmState==0) {
				top.$.HN.message.alert("请选择是否供货！", "消息", "warn");
	            return false;
			}else if (confirmState==1 && (companyNamePs==null || companyNamePs=="")) {
				top.$.HN.message.alert("请选择配送企业！", "消息", "warn");
	            return false;
			}else if (confirmState==2 && (refuseReason==null || refuseReason=="")) {
				top.$.HN.message.alert("请填写未供货原因！", "消息", "warn");
	            return false;
			}
		    list.push({
		    	"orderdetailId": rowdata.orderdetailId,
    			"confirmState": confirmState,
    			"refuseReason": refuseReason,
    			"companyIdPs": companyIdPs,
    			"companyNamePs": companyNamePs
    		});
		}
		if (rowIds.length <= 0) {
        	top.$.HN.message.alert("请至少选择一个订单！", "消息", "warn");
            return false;
		}
		$.HN.message.confirm('确定要全部提交吗？', '', '').on(function (e) {
			if(e){
				$.ajax({
					url: "${ctx}/yimiaoOrderdetail/updateAllOrderdetail.html",
					type: "post",
	             	dataType: "json",
	             	data:{"str":JSON.stringify(list)},
	             	success: function (result) {
	             		console.log(result);
						if (result.success){
							$.alert("状态修改成功！", "success");
							$("#gridlist").jqGrid('setGridParam',{
								mtype: "post",
								url: "${ctx}/yimiaoOrderdetail/getYimiaoOrderData.html"
	    	             	}).trigger("reloadGrid");
						} else {
							$.alert("<spring:message code="message.HN.alert.fail"/>", "error");
						}
					}
				});
			}
		});
	}
	
	//导出
    function exportExcel(){
    	var postData = $("#searchForm").serializeJSON();
    	gridParam(postData);
    	$.StandardPost("${ctx}/yimiaoOrderdetail/exportDataToExcelNCGSC.html",postData);
	}

	// 打印
	/*function orderPrint(){
        /!*$('.ui-jqgrid-bdiv').parent('.ui-jqgrid-view').print();*!/
        window.location.href = "${ctx}/yimiaoOrderdetail/toYimiaoOrderPrint.html";
	}*/

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

            $.ajax({
                "url": "${ctx}/yimiaoOrderdetail/getYimiaoPSData.html",
                "data": {},
                "dataType": 'json',
                success: function (result) {
                    console.log(result);
                    var rows = result.rows;
                    var size = rows.length;

                    if (size==1){
                        $(companyNamePs).val(rows[size-1].delCompName);
//                        $(companyNamePs).prop("placeholder",rows[size-1].delCompName);
                    }
                    if(size==2){
                        $(companyNamePs).val(rows[size-1].delCompName);
//                        $(companyNamePs).prop("placeholder",rows[size-1].delCompName);
                    }
                    if(size > 2){
                        $(companyNamePs).prop("placeholder","请选择配送企业");
                    }
                }
			});
			$(companyNamePs).removeProp("disabled");
			$(refuseReason).prop("disabled","disabled");
//			$(companyNamePs).prop("placeholder","请选择配送企业");
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
</script>
</html>