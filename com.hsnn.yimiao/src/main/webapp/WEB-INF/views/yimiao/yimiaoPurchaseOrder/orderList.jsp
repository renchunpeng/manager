<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title><spring:message code="采购订单"/></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="采购订单"/></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#"><spring:message code="采购订单"/></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/purOrderpack/getPurOrderpackData.html" id="searchForm" method="post" >
					<div class="input">
		            	<div class="textalign1"><spring:message code="疫苗编号"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsId" name="goodsId"  placeholder="疫苗编号" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="疫苗名称"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="productName" name="productName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="规格"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="规格" maxlength="50" />
	                    </div>
                    	<input style="display:none;"/><!-- 防止回车表单自动提交 -->
					</div>
					<div class="input">
						<div class="textalign1"><spring:message code="生产企业"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="生产企业" maxlength="100" />
	                    </div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<input type="hidden" id="searchType" name="searchType">
			<button id="savee" type="button" onclick="save();" class="btn btn-success btn-sm">加入采购单</button>
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
			'<spring:message code="message.jqGrid.cz"/>',
			'',
			'',
			'',
			'数量',
			'疫苗编号',
			'疫苗名称',
            '制剂规格（申报剂型）',
            '生产企业（投标企业）',
            '',
		    '最小制剂单位中标价格（元）',
			'最小制剂单位',
			'采购金额',
			'备注'

        ],
        "model": [
			{ name: 'operate', width: 80, align: 'left',hidden:true,sortable: false,
            	formatter:function(val, opts, rowdata){
					var str="";
                	 return str;
                }
        	},
        	{ name: "procurecatalogId", width: 100, align: 'center' ,sortable: false, hidden:true},
        	{ name: "companyIdSc", width: 100, align: 'center' ,sortable: false, hidden:true},
        	{ name: "companyIdTb", width: 100, align: 'center' ,sortable: false, hidden:true},
        	{ name: "lastPurchaseCount",align: 'center',width: 90, sortable: false,
	        	formatter:function(val, opts, rowdata){
	        		var sb="";
        			if(rowdata.companyNameSc!=null){
        				sb= "<input type=\"text\" maxlength=\"9\"  id=\"count"+rowdata.procurecatalogId+"\"  style=\"width:99%;text-align:right;\"  onkeyup=\"countUp(event,'"+rowdata.bidPrice+"','"+rowdata.lastPurchaseCount+"','"+rowdata.procurecatalogId+ "','"+opts.rowId+"')\" />";
        			}else{
        				sb="";
        			}
        			return sb;
			    }	
	        },
	        { name: "goodsId", key:true, width: 100, align: 'center' ,sortable: false},
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
	        { name: "companyNameTb", width: 150, align: 'center' ,sortable: false,hidden:true},
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
	        { name: "purchaseAmount", sortable: false,align: 'center'}, 
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
	        }
        ]      
	};
					
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoPurchaseOrder/getProcureList.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            postData:{"orderId":"${orderId}"},
            caption: "<spring:message code="采购疫苗列表"/>",
            viewrecords: true,
            onSelectRow:function(rowid,status){
                json[rowid] = status;
            }
        });
        $(window).trigger("resize");
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoPurchaseOrder/getProcureList.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
	
function countUp(event,price,count,procurecatalogId,rowId){
		//shlar keyCode = event.keyCode?event.keyCode:event.which?event.which:event.charCode;
			// 此处处理回车动作
			var returnCount=document.getElementById("count"+procurecatalogId);
			var aa=Number(price);
			var bb=Number(returnCount.value);

			$("#gridlist").setSelection(rowId, true);

			if(true == json[rowId]){
				$("#gridlist").setSelection(rowId, false);
			}
			$("#gridlist").setSelection(rowId, true);
			if(/^\+?[1-9][0-9]*$/.test(returnCount.value)){
					var returnTotal=aa*bb;
					$(returnCount).parents("tr").find("td:last").prev().text(returnTotal.toFixed(3));
			}else{
				$(returnCount).val("");
				$(returnCount).parents("tr").find("td:last").prev().text("");
				$.alert("采购数量必须是正整数！","warn");
			}

}
	function save(){
		var gridlist=  $("#gridlist");
		var rowIds =gridlist.jqGrid("getGridParam", "selarrrow") || [];
		var list = [];
		for (var i=0; i<rowIds.length; i++) {
			var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            var count = $.trim($("#count"+rowdata.procurecatalogId).val());
            var remark = $.trim($("#remark"+rowdata.procurecatalogId).val());
            var procurecatalogId = rowdata['procurecatalogId'];
            var purchaseAmount =rowdata['purchaseAmount'];
            list.push({
    			"procurecatalogId": procurecatalogId,
    			"lastPurchaseCount":count,
				"purchaseAmount":purchaseAmount,
				"remark":remark
    		});
		}
		
		
		if (rowIds.length <= 0) {
        	top.$.HN.message.alert("请至少选择一个疫苗！", "消息", "warn");
            return false;
		}
		if (count.length <= 0||count==0) {
        	top.$.HN.message.alert("采购数量必须大于0！", "消息", "warn");
            return false;
		}

		var url = "${ctx }/yimiaoPurchaseOrder/addPurOrderpack.html";

		$.HN.message.confirm('确定要加入采购单吗？', '', '').on(function (e) {
			if (e) {
					$.ajax({
						url:url,
						type:"post",
						dataType : "json",
						data:{"str":JSON.stringify(list),"orderName":"${orderName}","remarks":"${remarks}","orderId":"${orderId}"},
	               		success: function(result) {
	                   		if(result.success){
	           	     			$.alert("加入采购单成功！", "success");
                                $("#gridlist").jqGrid().trigger("reloadGrid");
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
		document.location.href="${ctx}/yimiaoPurchaseOrder/toList.html";
	}
	function toEdit() {
		document.location.href="${ctx }/yimiaoPurchaseOrder/todetails.html?orderId=${orderId}";
	}
	
</script>
</html>