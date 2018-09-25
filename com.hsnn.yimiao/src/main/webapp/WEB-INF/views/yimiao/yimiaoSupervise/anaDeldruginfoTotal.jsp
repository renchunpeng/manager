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
    <h1>配送企业采购情况</h1>
    <ol class="breadcrumb">
        <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
        <li><a href="#">监管系统</a></li>
        <li><a href="#">药品采购情况</a></li>
    </ol>
</section>

<section class="content">
    <div class=" box box-success">
        <div class="box-body">
            <form id="form" method="post" action=''>
                <div class="input">
                    <div class="textalign">配送企业<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="delCompName" name="delCompName" placeholder="配送企业" maxlength="100"/>
                    </div>&nbsp;
                    <div class="textalign">
                        <button id="selectSpec" type="button" onclick="search();" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
                    </div>
                    <div class="textalign1">
                        <button id="exportExcel" type="button" class="btn btn-success btn-sm">导 出</button>
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
        colNames: [
            '配送企业',
            '采购总金额(万元)',
            '配送金额(万元)',
            '入库金额(万元)',
            '配送率',
            '入库率'
        ],
        colModel: [
            {name: 'companyNamePs', width: 200, align: "center", sortable: false},
            {name: 'purchaseAmount', width: 80, align: "center", sortable: false},
            {name: 'del_amount', width: 80, align: "center", sortable: false, hidden: true},
            {name: 'totalWarehouseAmount', width: 80, align: "center", sortable: false},
            {name: 'del_ratio', width: 80, align: "center", sortable: false, hidden: true},
            {
                name: 'compRatio', width: 75, align: "center", sortable: false,
                formatter: function (val, opts, rowdata) {
                    return val.toString().substring(0, 5);
                }
            }
        ]
    }
    $(function () {
        $('#form :input').bind('keydown', function (event) {
            if (event.keyCode == "13") {
                event.preventDefault();
                search();
            }
        }).eq(0).focus();
        $("#gridlist").jqGrid({
            url: "${ctx}/yimiaoSupervise/getAnaHospTotalMon.html",
            postData: {date: "${date}", drugCode: "${drugCode}", time: "${time}", type: "${type}"},
            mtype: "post",
            datatype: "json",
            autowidth: true,
            height: 310,
            colNames: obj.colNames,
            colModel: obj.colModel,
            rowNum: 20,
            rowList: [10, 20, 50, 100],
            rownumbers: true,
            pager: "#gridpage",
            multiselect: false,
            viewrecords: true,
            caption: "配送企业列表 ${date}/${drugName}/采购金额(万元)：${totalAmount}/配送金额(万元)：${delAmount}/入库金额(万元)：${recpAmount}",
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

        $('#exportExcel').bind('click', function () {
            var postData = {date: "${date}", drugCode: "${drugCode}", time: "${time}", type: "${type}"};
            postData['delCompName'] = $.trim($("#delCompName").val());
            gridParam(postData);
            $.StandardPost("${ctx}/yimiaoSupervise/exportExcelByAllTz.html", postData);
        });
    });

    function search(page) {
        var data = formatForm("form");
        $("#gridlist").jqGrid('setGridParam', {
            datatype: 'json',
            postData: data,
            page: (page || 1)
        }).trigger("reloadGrid"); //重新载入
    }

    var objTemp = null;

    function gridParam(postData) {
        if (!objTemp) {
            objTemp = $.extend(true, {}, obj);
        }
        var namesTemp = objTemp.colNames;
        var modelTemp = objTemp.colModel;
        var colModelStr = "";
        for (var mod in modelTemp) {
            colModelStr += modelTemp[mod].name + ",";
        }
        objTemp = obj;
        postData['colNames'] = namesTemp.toString();
        postData['colModel'] = colModelStr.substring(0, colModelStr.length - 1);
        //return "?colNames="+namesTemp.toString()+"&colModel="+colModelStr.substring(0,colModelStr.length-1);
    }
</script>
</body>
</html> 
                          
                  
                  