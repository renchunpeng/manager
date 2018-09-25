<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
<section class="content-header">

    <ol class="breadcrumb">
        <li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>

    </ol>
</section>
<section class="content">
    <div class=" box box-primary">
        <div class="box-body">
            <form action="${ctx }/yimiaoPurchaseOrder/getYimiaoOrderdetailData.html" id="searchForm" method="post">
                <div class="input">
                    <input type="text" class="textinput" id="orderId" name="orderId" value="${orderId }" hidden="true" maxlength="50"/>
                    <div class="textalign1"><spring:message code="疫苗编号"/><spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="goodsId" name="goodsId" placeholder="疫苗编号" maxlength="50"/>
                    </div>
                    <div class="textalign1"><spring:message code="疫苗名称"/><spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="goodsName" name="goodsName" placeholder="疫苗名称" maxlength="50"/>
                    </div>
                    <div class="textalign1"><spring:message code="规格"/><spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="outlook" name="outlook" placeholder="规格" maxlength="50"/>
                    </div>
                    <input style="display:none;"/><!-- 防止回车表单自动提交 -->
                </div>
                <div class="input">
                    <div class="textalign1"><spring:message code="生产企业"/><spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="companyNameSc" name="companyNameSc" placeholder="生产企业" maxlength="100"/>
                    </div>
                    <div class="textalign1"><spring:message code="疫苗通用名"/><spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="productName" name="productName" placeholder="疫苗通用名" maxlength="50"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="btn-control-box">
        <button id="search" type="button" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
        <button id="save" type="button" class="btn btn-success btn-sm" onclick="save();">修改采购数量</button>
        <button id="add" type="button" class="btn btn-success btn-sm" onclick="goAdd();">新增疫苗</button>
        <button id="delete" type="button" class="btn btn-success btn-sm" onclick="goDelete();">删除疫苗</button>
        <button id="back" type="button" class="btn btn-success btn-sm" onclick="goback();">返回</button>
        <button id="submit" type="button" class="btn btn-success btn-sm" onclick="submit();">提交</button>
    </div>
    <table class="jqgrid" id="gridlist"></table>
    <div id="gridpage"></div>
</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>
<script type="text/javascript">
    var obj = {
        "names": [
            '<spring:message code="message.jqGrid.cz"/>',
            '订单明细编号',
            '订单号',
            '采购数量',
            '采购总价',
            '疫苗编号',
            '疫苗名称',
            '疫苗通用名',
            '制剂规格（申报剂型）',
            '生产企业（投标企业）',
            '最小制剂单位中标价格（元）',
            '最小制剂单位',
            '备注'
        ],
        "model": [
            {
                name: 'operate', width: 80, align: 'center', sortable: false, hidden: true,
                formatter: function (val, opts, rowdata) {
                    var str = "<a href=\"javascript:void(0)\" onclick=\"goDelete('" + rowdata.orderdetailId + "')\" >删除</a>";
                    return str;
                }
            },
            {name: "orderdetailId", key: true, sortable: false, hidden: true},
            {name: "orderId", sortable: false, hidden: true},
            {
                name: "purchaseCount", sortable: false,
                formatter: function (val, opts, rowdata) {
                    var str = "<input id='purCount" + rowdata.orderdetailId + "' value=" + val + ">";
                    return str;
                }
            }, <!-- 采购数量 -->
            {
                name: "purchaseAmount", sortable: false,
                formatter: function (val, opts, rowdata) {
                    if (val != null) {
                        return val.toFixed(3);
                    } else {
                        return "0.000";
                    }
                }
            }, <!-- 采购总金额 -->
            {name: "goodsId", key: true, width: 100, align: 'center', sortable: false},
            {name: "goodsName", width: 150, align: 'center', sortable: false},
            {name: "productName", width: 150, align: 'center', sortable: false},
            {
                name: "outlook", width: 150, align: 'center', sortable: false,
                formatter: function (val, opts, rowdata) {
                    return rowdata.outlook + "（" + rowdata.medicinemodel + "）";
                }
            },
            {
                name: "companyNameSc", width: 150, align: 'center', sortable: false,
                formatter: function (val, opts, rowdata) {
                    return rowdata.companyNameSc + "（" + rowdata.companyNameTb + "）";
                }
            },
            {
                name: "purchasePrice", width: 60, align: 'center', sortable: false,
                formatter: function (val, opts, rowdata) {
                    //return formatAmount(val, opts, rowdata);
                    if (val != null) {
                        return val.toFixed(3);
                    } else {
                        return "暂无";
                    }
                }
            },
            {name: "unit", width: 50, align: 'center', sortable: false},
            {name: "orderCustomInfo", width: 150, align: 'center', sortable: false},
        ],
    };


    $(function () {
        var queryData = $("#searchForm").serializeJSON();
        $("#gridlist").jqGrid({
            url: "${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html",
            colNames: obj.names,
            colModel: obj.model,
            postData: queryData,
            multiselect: true,
            caption: "订单详情"
        });

//        加载完列表后获取被选中的checkbox的值及其属性值的做法如下：
        var checkedVals = new Array();
        var checkedTitles = new Array();
        $(":checkbox[name=checkboxname][checked]").each(function () {
            checkedVals.push($(this).val());
            checkedTitles.push($(this).attr("title"));
        });
        for (var p = 0; p < checkedVals.length; p++) {
            alert(checkedVals[p]);
            alert(checkedTitles[p]);
        }

        $(window).trigger("resize");

        // 查询
        $("#search").click(function () {
            var queryData = $("#searchForm").serializeJSON();
            $("#gridlist").jqGrid("setGridParam", {
                url: "${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html",
                postData: queryData,//发送查询条件
            }).trigger("reloadGrid");//重新载入
        });


    });

    function goback() {
        window.location.href = "${ctx}/yimiaoPurchaseOrder/toList.html";
    }

    function goAdd() {
        var url = "${ctx}/yimiaoPurchaseOrder/toOrderList.html?orderId=${orderId}";
        window.location.href = url;
    }


    function goDelete() {
        var gridlist = $("#gridlist");
        var rowIds = gridlist.jqGrid("getGridParam", "selarrrow") || [];
        var list = [];
        for (var i = 0; i < rowIds.length; i++) {
            var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);

            var orderdetailId = rowdata['orderdetailId'];
            var orderId = rowdata['orderId'];

            list.push({
                "orderdetailId": orderdetailId,
                "orderId": orderId
            });
        }


        if (rowIds.length <= 0) {
            top.$.HN.message.alert("请至少选择一个疫苗！", "消息", "warn");
            return false;
        }

        $.HN.message.confirm('确定要删除选中疫苗吗？', '', '').on(function (e) {
            if (e) {
                $.ajax({
                    url: '${ctx }/yimiaoPurchaseOrder/getDelete.html',
                    type: "post",
                    dataType: "json",
                    data: {"str": JSON.stringify(list)},
                    timeout: 10000,
                    success: function (result) {
                        if (result.success) {
                            $.alert("删除成功！", "success");
                            $("#search").click();
                        } else {
                            $.alert(result.msg || "删除失败", "error");
                        }
                    }
                });
            }
        });
    }

    function save() {
        var gridlist = $("#gridlist");
        var rowIds = gridlist.jqGrid("getGridParam", "selarrrow") || [];
        if (rowIds.length <= 0) {
            top.$.HN.message.alert("请至少选择一个疫苗！", "消息", "warn");
            return false;
        }
        var list = [];
        for (var i = 0; i < rowIds.length; i++) {
            var rowdata = $("#gridlist").jqGrid('getRowData', rowIds[i]);
            var orderdetailId = rowdata['orderdetailId'];
            var orderId = rowdata['orderId'];
            var purCount = $("#purCount" + orderdetailId).val();
            if (!/^\+?[1-9][0-9]*$/.test(purCount)) {
                top.$.HN.message.alert("勾选的第" + (i + 1) + "个采购数量必须是正整数！", "消息", "warn");
                return false;
            }
            var purPrice = rowdata['purchasePrice'];
            list.push({
                "orderdetailId": orderdetailId,
                "purCount": purCount,
                "orderId": orderId,
                "purPrice": purPrice
            });
        }

        $.HN.message.confirm('确定要保存选中的疫苗数量吗？', '', '').on(function (e) {
            if (e) {
                $.ajax({
                    url: '${ctx }/yimiaoPurchaseOrder/updateDetailCount.html',
                    type: "post",
                    dataType: "json",
                    data: {"str": JSON.stringify(list)},
                    timeout: 10000,
                    success: function (result) {
                        if (result.success) {
                            $.alert("保存成功！", "success");
                            $("#search").click();
                        } else {
                            $.alert(result.msg || "保存失败", "error");
                        }
                    }
                });
            }
        });
    }

    //提交按钮
    function submit() {
            var list = [];
            var rowIds = jQuery("#gridlist").jqGrid('getDataIDs');//获取jqgrid中所有数据行的id
            if (rowIds.length == 0) {
                top.$.HN.message.alert("不能提交空的订单!", "消息", "warn");
                return;
            }
            list.push({
                "orderId": "${orderId}"
            });

            $.HN.message.confirm('确定要提交采购单吗？', '', '').on(function (e) {
                if (e) {
                    $.ajax({
                        url: '${ctx }/yimiaoPurchaseOrder/toSubmit.html',
                        type: "post",
                        dataType: "json",
                        data: {"str": JSON.stringify(list)},
                        timeout: 10000,
                        success: function (result) {
                            if (result.success) {
                                $.alert("提交采购单成功！", "success");
                                goback();
                            } else {
                                $.alert(result.msg || "提交订单失败", "error");
                            }
                        }
                    });
                }
            });
    }


</script>
</html>