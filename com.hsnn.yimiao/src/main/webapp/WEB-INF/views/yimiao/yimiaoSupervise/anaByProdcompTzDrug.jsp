<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="message.lable.drugqualityspecSeeStd"/></title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
    <!--[if lt IE 9]>
    <script src="${ctx}/lib/js/html5shiv.min.js"></script>
    <script src="${ctx}/lib/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-blue-light sidebar-mini fixed skin-blue-light-frame">

<section class="content-header">
    <h1>药品采购情况</h1>
    <ol class="breadcrumb">
        <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
        <li><a href="#">监管系统</a></li>
        <li><a href="#">生产企业采购情况</a></li>
    </ol>
</section>

<section class="content">
    <div class=" box box-success">
        <div class="box-body">
            <form id="form" method="post">
                <div class="input">
                    <div class="textalign">产品名称<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="drugName" name="drugName" placeholder="产品名称" maxlength="100"/>
                    </div>
                    <div class="textalign">
                        <button id="selectSpec" type="button" onclick="search();" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
                    </div>
                    <div class="textalign1">
                        <button type="button" onclick="exportExcel();" class="btn btn-success btn-sm">导 出</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <table class="jqgrid" id="gridlist"></table>
    <div id="gridpage"></div>
    <div class=" box box-warning bottongroup">
        <a href="javascript:history.go(-1)" class="btn btn-danger btn-sm">返 回</a>
    </div>
</section>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>
<script type="text/javascript">
    var obj = {
        "names": [
            '产品编号',
            '疫苗通用名',
            '产品名称',
            '制剂规格（申报剂型）',
            '生产企业（投标企业）',
            '采购金额(万元)',
            '入库金额(万元)',
            '入库率(%)'
        ],
        "model": [
            {name: "goodsId", key: true, width: 100, align: 'center', sortable: false},
            {name: "productName", width: 150, align: 'center', sortable: false},
            {name: "goodsName", width: 150, align: 'center', sortable: false},
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
            {name: 'purchaseAmount', width: 75, align: "center", sortable: false},
            {name: 'totalWarehouseAmount', width: 75, align: "center", sortable: false},
            {
                name: 'compRatio', width: 75, align: "center", sortable: false,
                formatter: function (val, opts, rowdata) {
                    return val.toString().substring(0, 5);
                }
            }
        ]
    };

    $(function () {
        $('#form :input').bind('keydown', function (event) {
            if (event.keyCode == "13") {
                event.preventDefault();
                search();
            }
        });
        $("#gridlist").jqGrid({
            url: "${ctx}/yimiaoSupervise/getAnaByProdcompTz.html",
            postData: {date: "${date}", dateType: "${dateType}", type: "${type}", prodCode: "${prodCode}"},
            mtype: "post",
            datatype: "json",
            autowidth: true,
            height: 310,
            colNames: obj.names,
            colModel: obj.model,
            rowNum: 20,
            rowList: [10, 20, 50, 100],
            rownumbers: true,
            pager: "#gridpage",
            multiselect: false,
            viewrecords: true,
            caption: "药品列表  月度:${date}/生产企业:${prodName}/采购金额(万元):${total}/配送金额(万元):${delA}/入库金额(万元):${recpA}",
            gridComplete: function () {
                autoRNWidth("gridlist");
            },
            jsonReader: {
                repeatitems: false,
                id: "qualitySpecId"
            }
        });
        $("#gridlist").jqGrid('navGrid', '#gridpage', {add: false, edit: false, del: false, search: false, refresh: false});
        $(window).trigger("resize");
    });

    function search(page) {
        var data = formatForm("form");
        $("#gridlist").jqGrid('setGridParam', {
            datatype: 'json',
            postData: data,
            page: (page || 1)
        }).trigger("reloadGrid"); //重新载入
    }


    function exportExcel() {

        var postData = {date: "${date}", dateType: "${dateType}", type: "${type}", prodCode: "${prodCode}", drugName: $.trim($("#drugName").val())};
        gridParam(postData);
        $.StandardPost("${ctx}/yimiaoSupervise/exportExcelByAllTz.html", postData);
    }

    var objTemp = null;

    function gridParam(postData) {
        if (!objTemp) {
            objTemp = $.extend(true, {}, obj);
        }
        var namesTemp = objTemp.names;
        var modelTemp = objTemp.model;
        if ($.inArray('操作', namesTemp) >= 0) {
            namesTemp.splice($.inArray('操作', namesTemp), 1);
            modelTemp.splice(0, 1);
        }
        var colModelStr = "";
        for (var mod in modelTemp) {
            colModelStr += modelTemp[mod].name + ",";
        }

        postData['colNames'] = namesTemp.toString();
        postData['colModel'] = colModelStr.substring(0, colModelStr.length - 1);
    }

    function xgTz(drugCode, total, delA, recpA, type) {
        var url = encodeURI(encodeURI("${ctx}/anaDruginfo/toAnaByProdcompTzThree.html?dateType=mon&date=" + "${date}" + "&total=" + total + "&type=" + type + "&prodCode=${prodCode}&drugCode=" + drugCode + "&delA=" + delA + "&recpA=" + recpA));
        //type 1医疗机构2药品3配送企业
        window.location.href = url;
    }
</script>
</body>
</html> 
                          
                  
                  