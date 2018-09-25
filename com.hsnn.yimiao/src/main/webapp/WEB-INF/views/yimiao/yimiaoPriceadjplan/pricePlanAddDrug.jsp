<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<title>添加调价计划明细</title>
	<meta http-equiv="X-UA-Compatible" content="chrome=1">
	<%@ include file="/WEB-INF/component/commonCSS.jsp" %>
</head>
<body class="skin-blue-light sidebar-mini fixed skin-blue-light-frame">
<section class="content-header">
	<h1>添加调价计划明细</h1>
	<ol class="breadcrumb">
		<li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i>首页</a></li>
		<li class="active"><a href="#">交易</a></li>
		<li class="active"><a href="#">药品调价</a></li>
		<li class="active"><a href="#">未处理调价计划</a></li>
	</ol>
</section>

<section class="content">
	<div class=" box box-success">
		<div class="box-body">
			<form  action="${ctx }/drugpurPriceadjplan/getPriceChangeDurgList.html"  id="searchForm" method="post" >
				<div class="input">
					<div class="textalign1">通用名：</div>
					<div class="boxinput">
						<input id="productName" name="productName"  class="textinput" type="text" placeholder="通用名" />
					</div>
					<div class="textalign1">商品ID：</div>
					<div class="boxinput">
						<input id="procurecatalogId" name="procurecatalogId" class="textinput" type="text" placeholder="商品ID" />
					</div>
					<div class="textalign1">生产企业：</div>
					<div class="boxinput">
						<input id="companyNameSc" name="companyNameSc" class="textinput" type="text" placeholder="生产企业" />
					</div>
				</div>

				<div class="input">
					<div class="textalign1">项目名称：</div>
					<div class="boxinput">
						<input id="sourceName" name="sourceName"  class="textinput" type="text" placeholder="项目名称" />
					</div>

				</div>

			</form>
		</div>
	</div>
	<div class="btn-control-box">
		<button id="search" type="button" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
	</div>
	<table class="jqgrid" id="gridlist"></table>
	<div id="gridpage"></div>
	<div class=" box box-warning bottongroup">
		<label id="save" class="btn btn-primary btn-sm" onclick="addDrug()">加入调价计划</label>
		<a href="toPricePlanChange.html?priceAdjPlanId=${pricePlan.priceAdjPlanId}" class="btn btn-primary btn-sm">查看调价计划明细</a>
	</div>

</section>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>
<script type="text/javascript">
    var obj = {
        "names": [
            '商品id',
            '通用名',
            '规格',
            '单位',
            '生产企业',
            '采购限价',
            '新采购限价',
            '备注'


        ],
        "model": [
            { name: 'procurecatalogId', width: 80,align: 'center',key:true, sortable:false },
            { name: 'productName', width: 200,align: 'center', sortable:false },
            { name: 'outlook', width: 80 ,align: 'center', sortable:false },
            { name: 'unit', width: 40 ,align: 'center', sortable:false },
            { name: 'companyNameSc', width: 180,align: 'center', sortable:false},
            { name: 'bidPrice', width: 80, align: "center", sortable:false,
                formatter:function(cellvalue, options, row){
                    if(cellvalue==null||cellvalue==""){
                        return "0";
                    }else{
                        return cellvalue;
                    }
                }
            },
            { name: 'newPurchasePrice', width: 80, align: "right", sortable:false,
                formatter : function(val, opts, rowdata) {
                    var str = "<input type='text' maxlength='10' oninput=\"value=value.replace(/[^\\d{1,}\\.\\d{1,}|\\d{1,}]/g,'')\" id='newPurchasePrice" + rowdata.procurecatalogId + "' style='width:99%;text-align:right;' />";
                    return str;
                }
            },
            { name: 'remark', width: 80, align: "right", sortable:false,
                formatter : function(val, opts, rowdata) {
                    var str = "<input type='text' maxlength='10'  id='remark" + rowdata.procurecatalogId + "' style='width:99%;text-align:right;' />";
                    return str;
                }
            }

        ]
    };


    $(function () {
        $("#gridlist").jqGrid({
            url: "${ctx }/yimiaoPriceadjplan/getPriceChangeDurgList.html?priceAdjPlanId=${pricePlan.priceAdjPlanId}",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            rownumbers: true,
            autowidth: true,
            rowNum: 20,
            caption: "未处理调价计划",
            gridComplete:function(){
                //序号列宽度自适应（参数为jqgridID）
                autoRNWidth("gridlist");
                //数据只有一条时默认选中（参数为jqgridID）
                selectByOneData("gridlist");
            }
        });
        $(window).trigger("resize");

        // 查询
        $("#search").click(function () {
            var queryData = $("#searchForm").serializeJSON();
            $("#gridlist").jqGrid("setGridParam", {
                url: "${ctx }/yimiaoPriceadjplan/getPriceChangeDurgList.html?priceAdjPlanId=${pricePlan.priceAdjPlanId}",
                postData: queryData,//发送查询条件
            }).trigger("reloadGrid");//重新载入
        });
    });



    function toUpdateReferencePriceDialog(procurecatalogId,goodsId){
        $.HN.dialog.open({
			/*"id": "procurecatalogId"+procurecatalogId, */
            "title": "参考价列表",
            "url": "${ctx}/drugpurReferencePrice/toDrugpurReferencePriceDialogUpdate.html?procurecatalogId="+procurecatalogId+"&goodsId="+goodsId,
            "data": {},
            "width": 800,
            "height": 400,
            "closefunc":function(params) {

            }
        })
    }

    function addDrug() {
        var rowIds = $("#gridlist").jqGrid("getGridParam", "selarrrow") || [];
        if (rowIds.length <= 0) {
            $.HN.message.alert("请您选择要加入调价计划的药品！", "消息", "warn");
            return;
        }
        var list = [];
        for (var i=0; i<rowIds.length; i++) {
            var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            var procurecatalogId=$.trim(rowdata.procurecatalogId);
            var newPurchasePrice = $("#newPurchasePrice"+procurecatalogId).val();
            var remark =$('#remark'+procurecatalogId).val();
            var bidPrice=rowdata.bidPrice;
            if (newPurchasePrice == null || newPurchasePrice == "") {
                $.HN.message.alert("请输入新采购限价！", "消息", "warn");
                return false;
            }

            if (!/^[0-9]+(.[0-9]+)*$/.test(newPurchasePrice)) {
                $.HN.message.alert("新采购限价应该大于0的正数！", "消息", "warn");
                return false;
            }

            var index = newPurchasePrice.lastIndexOf(".");
            if (index > 0 && newPurchasePrice.substr(index).length > 4) {
                $.HN.message.alert("新采购价最多保留三位小数！", "消息", "warn");
                return false;
            }

            list.push({
                "priceAdjPlanId":"${pricePlan.priceAdjPlanId}",
                "procurecatalogId":procurecatalogId,
                "origProPriceLimit": bidPrice,
                "currProPriceLimit": newPurchasePrice,
                "remark": remark,
                "bidPrice":bidPrice
            });
        }
        $.HN.message.confirm("您确定加入调价计划吗？", "提示信息", "确定").on(function(bool) {
            if (bool) {
                $.ajax({
                    type:"POST",
                    url:"batchSubmitDrugTOPlan.html",
                    data:{"drugs":JSON.stringify(list)},
                    dataType:"json",
                    success:function(result){
                        if (result.success) {
                            $.HN.message.alert("操作成功！", "消息", "success");
                            document.location = "${ctx}/yimiaoPriceadjplan/toPricePlanAddDrug.html?priceAdjPlanId=${pricePlan.priceAdjPlanId}";
                        } else {
                            $.HN.message.alert("操作失败！", "消息", "error");
                        }
                    },
                });
            }
        });
    }

    function test (procurecatalogId,price){
        $('#test'+procurecatalogId).val(price);
    }
</script>
</body>
</html>

