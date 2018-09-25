<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>调价计划明细</title>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
</head>
<body class="skin-blue-light sidebar-mini fixed skin-blue-light-frame">
<section class="content-header">
    <h1>调价计划明细</h1>
    <ol class="breadcrumb">
        <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i>首页</a></li>
        <li class="active"><a href="#">交易</a></li>
        <li class="active"><a href="#">药品调价</a></li>
        <li class="active"><a href="#">未处理调价计划</a></li>
    </ol>
</section>

<section class="content">
    <form id="searchForm" method="post" class="form-horizontal">
        <div class=" box box-success">
            <div class="box-body">
                <div class="input">
                    <div class="textalign1">通用名：</div>
                    <div class="boxinput">
                        <input id="productName" name="productName" class="textinput" type="text" placeholder="通用名" />
                    </div>

                    <div class="textalign">商品ID：</div>
                    <div class="boxinput">
                        <input id="procurecatalogId" name="procurecatalogId" class="textinput" type="text" placeholder="商品ID" />
                    </div>

                    <div class="textalign">生产企业：</div>
                    <div class="boxinput">
                        <input id="companyNameSc" name="companyNameSc" class="textinput" type="text" placeholder="生产企业" />
                    </div>

                </div>

            </div>
        </div>
        <div id="advanceSearch" class="advanceSearch"></div>
    </form>
    <div class="btn-control-box">
        <button type="button" class="btn btn-primary btn-sm"  id="search">查&nbsp;询 </button>
    </div>
    <table class="jqgrid" id="gridlist"></table>
    <div id="gridpage"></div>
    <div class=" box box-warning bottongroup">

        <a href="${ctx}/yimiaoPriceadjplan/toPricePlanAddDrug.html?priceAdjPlanId=${pricePlan.priceAdjPlanId}" class="btn btn-primary btn-sm">添&nbsp;加</a>
        <label id="save" class="btn btn-primary btn-sm" onclick="batchEditDrug();">保&nbsp;存</label>
        <label id="make" class="btn btn-primary btn-sm" onclick="runChangePlan();">执&nbsp;行</label>
        <label id="batchDelete" class="btn btn-danger btn-sm" onclick="batchDeleteDrug();">删&nbsp;除</label>
        <a href="toUnChangePlan.html" class="btn btn-danger btn-sm">返&nbsp;回</a>
    </div>

</section>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>
<script type="text/javascript">
    var obj = {
        "names": [
            '','疫苗编号', '疫苗名称',  '规格', '最小制剂单位',  '生产企业',
            '年份','成交价', '新成交价'
        ],
        "model": [
            { name: 'priceAdjPalnDetailId', align: 'center',hidden:true,key:true, sortable:false },

            { name: 'yimiaoProcurecatalog.procurecatalogId', align: 'center', sortable:false },
            { name: 'yimiaoProcurecatalog.productName', align: 'center', sortable:false },
            { name: 'yimiaoProcurecatalog.outlook', align: 'center', sortable:false },
            { name: 'yimiaoProcurecatalog.unit', align: 'center', sortable:false },
            { name: 'yimiaoProcurecatalog.companyNameSc', align: 'center', sortable:false},
            { name: 'yimiaoProcurecatalog.yimiaoYear', align: 'center', sortable:false},
            { name: 'yimiaoProcurecatalog.bidPrice', align: 'center', sortable:false},
            { name: 'currProPriceLimit', align: "center", sortable:false, formatter : function(val, opts, rowdata) {
                    var str = formatAmount(val, opts, rowdata);
                    var sb = "<input type='text'  oninput=\"value=value.replace(/[^\\d{1,}\\.\\d{1,}|\\d{1,}]/g,'')\" id='currProPriceLimit" + rowdata.priceAdjPalnDetailId + "'  style='width: 80px;text-align: right' value='" + str + "' onchange='valuechange(this.id)'/>";
                    return sb;
               }
            },
        ]
    };


    $(function () {
        $("#gridlist").jqGrid({
            url: "${ctx}/yimiaoPriceadjplan/getPriceDurgList.html?priceAdjPlanId=${pricePlan.priceAdjPlanId}",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            rownumbers: true,
            autowidth: true,

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
                url: "${ctx}/yimiaoPriceadjplan/getPriceDurgList.html?priceAdjPlanId=${pricePlan.priceAdjPlanId}",
                postData: queryData,//发送查询条件
            }).trigger("reloadGrid");//重新载入
        });
    });


    var sta = 0;

    function runChangePlan() {
        var rowIds = $("#gridlist").jqGrid("getDataIDs")||[];
        if (rowIds.length <= 0) {
            $.HN.message.alert("请您添加调价明细！", "消息", "warn");
            return;
        }
        if(sta==1){
            $.HN.message.alert("请您先保存！", "消息", "warn");
            return;
        }
        $.HN.message.confirm("将为您执行所有的调价明细", "提示信息", "确定").on(function(bool) {
            if (bool) {
                $.ajax({
                    type:"POST",
                    url:"runChangePlan.html",
                    data:{"priceAdjPlanId":"${pricePlan.priceAdjPlanId}"},
                    dataType:"json",
                    success:function(returnData){
                        if (returnData.success != false) {
                            $.HN.message.alert("为您执行成功！", "消息", "success", function() {
                                document.location = "${ctx}/yimiaoPriceadjplan/toDataListJsp.html";
                            });
                        } else {
                            $.HN.message.alert("操作失败！", "消息", "error");
                        }
                    },
                    error:function() {
                        top.window.document.location = "${ctx}/login.html";
                    }
                });
            }
        });
    }






    function batchEditDrug() {
        var rowIds = $("#gridlist").jqGrid("getGridParam", "selarrrow") || [];
        if (rowIds.length <= 0) {
            $.HN.message.alert("请您添加调价明细！", "消息", "warn");
            return;
        }
        var list = [];
        var reg = new RegExp(/^[0-9]+(.[0-9]+)*$/);
        for (var i=0; i<rowIds.length; i++) {
            var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            var priceAdjPalnDetailId=$.trim(rowdata.priceAdjPalnDetailId);
            var currProPriceLimit = $.trim($("#currProPriceLimit"+priceAdjPalnDetailId).val());
            if (currProPriceLimit == null || currProPriceLimit == "") {
                $.HN.message.alert("请输入新采购限价！", "消息", "warn");
                return;
            }
            if(!reg.test(currProPriceLimit)){
                $.HN.message.alert("采购限价必须是数字！", "消息", "warn");
                return;
            }
            var index = currProPriceLimit.lastIndexOf(".");
            if (index > 0 && currProPriceLimit.substr(index).length > 4) {
                $.HN.message.alert("采购限价最多保留三位小数！请重新输入", "消息", "warn");
                return false;
            }


            list.push({
                "priceAdjPalnDetailId":priceAdjPalnDetailId,
                "currProPriceLimit": currProPriceLimit
            });
        }
        $.HN.message.confirm("您确定保存吗？", "提示信息", "确定").on(function(bool) {
            if (bool) {
                $.ajax({
                    type:"POST",
                    url:"batchSubmitPlanDrugEdit.html",
                    data:{"drugs":JSON.stringify(list)},
                    dataType:"json",
                    success:function(result){
                        if (result.success) {
                            sta = 0 ;
                            $.HN.message.alert("操作成功！", "消息", "");
                            location.reload();
                        } else {
                            $.HN.message.alert("操作失败！", "消息", "error");
                        }
                    },
                    error:function() {
                        top.window.document.location = "${ctx}/login.html";
                    }
                });
            }
        });
    }

    function batchDeleteDrug() {
        var rowIds = $("#gridlist").jqGrid("getGridParam", "selarrrow") || [];
        if (rowIds.length <= 0) {
            $.HN.message.alert("请您选择要删除的明细！", "消息", "warn");
            return;
        }
        var list = [];
        for (var i=0; i<rowIds.length; i++) {
            var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            var priceAdjPalnDetailId=$.trim(rowdata.priceAdjPalnDetailId);

            list.push({
                "priceAdjPalnDetailId":priceAdjPalnDetailId

            });
        }
        $.HN.message.confirm("您确定删除选中的调价明细吗？", "提示信息", "确定").on(function(bool) {
            if (bool) {
                $.post("batchDeleteDrug.html", {
                    "drugs" : json.jsonToString(list)
                }, function(result) {
                    if (result.success) {
                        sta=0;
                        $.HN.message.alert("操作成功！", "消息", "success");
                        location.reload();
                    } else {
                        $.HN.message.alert("操作失败！", "消息", "error");
                    }
                }, "json").error(function(err) {
                    top.window.document.location = "${ctx}/login.html";
                });
            }
        });

    }
    function valuechange(id){
        sta = 1;
    }

</script>
</body>
</html>