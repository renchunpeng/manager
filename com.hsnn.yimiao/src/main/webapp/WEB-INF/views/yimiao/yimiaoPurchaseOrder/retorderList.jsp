<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title><spring:message code="退货单管理"/></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="退货单管理"/></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#"><spring:message code="退货管理"/></a></li>
			<li class="active"><a href="#"><spring:message code="退货单管理"/></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/purOrderpack/getretPurOrderpackData.html" id="searchForm" method="post" >
					<div class="input">
						<div class="textalign1"><spring:message code="疫苗编号"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsId" name="goodsId"  placeholder="疫苗编号" maxlength="50" />
	                    </div>
	                    <div class="textalign1">疫苗名称<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="productName" name="productName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="规格"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="规格" maxlength="50" />
	                    </div>
					</div>
					<div class="input">
						<div class="textalign1">生产企业<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="生产企业" maxlength="50" />
	                    </div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<input type="hidden" id="searchType" name="searchType">
			<button id="savee" type="button" onclick="save();" class="btn btn-success btn-sm">加入退货单</button>
			<button id="toedit" type="button" onclick="toEdit();" class="btn btn-success btn-sm">添加完成</button>
			<button id="backe" type="button" onclick="back();" class="btn btn-success btn-sm">返回</button>
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
		    '订单明细编号',
		    '采购单编号',
			 '<spring:message code="message.jqGrid.cz"/>',
			 '',
			 '',
			'可退货数量',
			 '申请退货数量',
			 '申请退货原因',
			 '疫苗编号',
			 '疫苗名称',
            '制剂规格（申报剂型）',
            '生产企业（投标企业）',
		     '最小制剂单位中标价格（元）',
			 '最小制剂单位',
             '到货数量',
			 '已退货数量',
			 '退货金额',
			 '备注'
        ],
        "model": [
            {name: 'orderdetailId', width: 80, align: 'left',hidden:true,sortable: false},
			{name: 'orderId', width: 80, align: 'left',hidden:true,sortable: false},
			{ name: 'operate', width: 80, align: 'left',hidden:true,sortable: false,
            	formatter:function(val, opts, rowdata){
					var str="";
                	 return str;
                }
        	},
        	{ name: "procurecatalogId", width: 100, align: 'center' ,sortable: false, hidden:true},
        	{ name: "companyIdSc", width: 100, align: 'center' ,sortable: false, hidden:true},
            { name: "mayCanReturnCount", width: 100, align: 'center' ,sortable: false,
					formatter:function(val, opts, rowdata){
					return Number(rowdata.totalWarehouseCount)-Number(rowdata.totalReturnCount);
				}
            },
        	{ name: "lastPurchaseCount",align: 'center',width: 90, sortable: false,
	        	formatter:function(val, opts, rowdata){
	        		var sb="";
        			if(rowdata.companyNameSc!=null){
        			    var rowId = '' + opts.rowId;
        				sb= "<input type=\"text\" maxlength=\"9\"  id=\"count"+rowdata.procurecatalogId+rowId+"\"  style=\"width:99%;text-align:right;\"  onkeyup=\"countUp(event,'"+rowdata.bidPrice+"','"+rowdata.lastPurchaseCount+"','"+rowdata.procurecatalogId+"','"+rowId+"','"+rowdata.totalWarehouseCount+"')\" />";
        			}else{
        				sb="";
        			}
        			return sb;
			    }	
	        },
	        { name: "returnReason",align: 'center',width: 90, sortable: false,
	        	formatter:function(val, opts, rowdata){
	        		var sbf="";
        			if(rowdata.companyNameSc!=null){
                        var rowId = '' + opts.rowId;
        				sbf= "<input type='text' maxlength='50' value=''  id='returnReason"+rowdata.procurecatalogId+rowId+"'  style='width:99%;text-align:right;' />";
        			}else{
        				sbf="";
        			}
        			return sbf;
			    }	
	        },
	        { name: "goodsId", width: 100, align: 'center' ,sortable: false},
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
            { name: "totalWarehouseCount", sortable: false,align: 'center'},
	        { name: "totalReturnCount", sortable: false,align: 'center'},
            { name: "totalReturnAmount", sortable: false,align: 'center'},
	        { name: "remark",align: 'center',width: 90, sortable: false,
	        	formatter:function(val, opts, rowdata){
	        		var sbf="";
        			if(rowdata.companyNameSc!=null){
        				sbf= "<input type='text' maxlength='50' value=''  id='remark"+rowdata.procurecatalogId+"'  style='width:99%;text-align:right;' />";
        			}else{
        				sbf="";
        			}
        			return sbf;
			    }	
	        },
        ]      
	};
					
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoPurchaseOrder/getYimiaoOrderDetailList.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            postData:{"orderId":"${orderId}"},
            caption: "退货疫苗列表",
            viewrecords: true
        });
        $(window).trigger("resize");
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoPurchaseOrder/getYimiaoOrderDetailList.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
	
function countUp(event,price,count,procurecatalogId,rowId,totalWarehouseCount){
		//shlar keyCode = event.keyCode?event.keyCode:event.which?event.which:event.charCode;
			// 此处处理回车动作
			var returnCount=document.getElementById("count"+procurecatalogId+rowId);

			var aa=Number(price);
			var bb=Number(returnCount.value);
			if(bb > Number(totalWarehouseCount)){
				$(returnCount).val("");
				$(returnCount).parents("tr").find("td:last").prev().text("");
				$.alert("申请退货数量不能大于可退货数量！","warn");
			}
			if(!isNaN(parseInt(returnCount.value))){

			}else{
				$(returnCount).val("");
				$(returnCount).parents("tr").find("td:last").prev().text("");
				$.alert("请输入正确的数量！","warn");
			}

}
function save(){
	var gridlist=  $("#gridlist");
	var rowIds =gridlist.jqGrid("getGridParam", "selarrrow") || [];
	var list = [];
	for (var i=0; i<rowIds.length; i++) {
		var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
		var rowId = ''+rowIds[i];
        var count = $.trim($("#count"+rowdata.procurecatalogId+rowId).val());//申请退货数量
		var mayCanReturnCount = rowdata['mayCanReturnCount'];
        if (Number(count) > Number(mayCanReturnCount)) {
            top.$.HN.message.alert("申请退货数量不能大于可退货数量！", "消息", "warn");
            return false;
        }
        var remark = $.trim($("#remark"+rowdata.procurecatalogId).val());//备注
        var returnReason = $.trim($("#returnReason"+rowdata.procurecatalogId+rowId).val());//申请退货原因
        var yimiaoOrderdetailId = rowdata['orderdetailId'];
        list.push({
			"yimiaoOrderdetailId":yimiaoOrderdetailId,
			"lastPurchaseCount":count,
			"returnReason":returnReason,
			"remark":remark
		});
	}

	if (rowIds.length <= 0) {
    	top.$.HN.message.alert("请至少选择一个需要退货疫苗！", "消息", "warn");
        return false;
	}
	if (count.length <= 0||count==0) {
    	top.$.HN.message.alert("申请退货数量必须大于0！", "消息", "warn");
        return false;
	}
    if (!/^\+?[1-9][0-9]*$/.test(count)) {
        top.$.HN.message.alert("退货数量必须是正整数！", "消息", "warn");
        return false;
    }
	if (returnReason.length <= 0) {
    	top.$.HN.message.alert("请填写申请退货原因！", "消息", "warn");
        return false;
	}
	$.HN.message.confirm('确定要加入退货单吗？', '', '').on(function (e) {
		if (e) {
				$.ajax({
					url:'${ctx }/yimiaoPurchaseOrder/addretPurOrderpack.html',
					type:"post",
					dataType : "json",
					data:{"str":JSON.stringify(list),"orderId":"${orderId}","orderName":"${orderName}"},
             		timeout: 10000,
               		success: function(result) {
                   		if(result.success){
           	     			$.alert("加入退货单成功！", "success");
                            $("#search").click();
                   		}else{
                   			$.alert(result.msg || "<spring:message code="message.HN.alert.baoCunBai"/>", "error");
                   		}
					}
				});
			}
		
	});
}
	
	function change(val,spid){
		if(val==2){
			$('#cwss'+spid).css('display','block');
		}else{
			$('#cwss'+spid).css('display','none');
		}
	}
	function back(){
        window.location.href="${ctx}/yimiaoPurchaseOrder/toretList.html";
	}
	function toEdit() {
		document.location.href="${ctx }/yimiaoPurchaseOrder/toretdetails.html?orderId=${orderId}";
	}

</script>
</html>