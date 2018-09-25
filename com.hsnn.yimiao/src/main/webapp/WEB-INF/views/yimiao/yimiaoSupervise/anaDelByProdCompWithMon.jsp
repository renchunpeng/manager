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
    <h1>生产企业采购情况</h1>
    <ol class="breadcrumb">
        <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
        <li><a href="#">监管系统</a></li>
        <li><a href="#">配送企业采购情况</a></li>
    </ol>
</section>

<section class="content">
    <div class=" box box-success">
        <div class="box-body">
            <form id="form" method="post" action='${ctx}/yimiaoSupervise/exportExcelByAllTz.html?delCompName=${delCompName}&date=${date}&type=${type}'>
                <div class="input">
                    <div class="textalign">生产企业名称<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="prodCompName" name="prodCompName" placeholder="生产企业" maxlength="100"/>
                    </div>
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
    //绑定回车
    $('#prodCompName').bind('keydown', function (event) {
        if (event.keyCode == "13") {        //13 位电脑上回车键的位置代码
            event.preventDefault();
            $('#selectSpec').click();
        }
    });
    $("#prodCompName").focus();//加载页面光标在第一个查询框内


    $(function () {
        $("#gridlist").jqGrid({
            url: "${ctx}/yimiaoSupervise/getAnaDelWithMon.html",
            postData: {date: "${date}", dateType: "${dateType}", type: "${type}", delCompName: "${delCompName}"},
            mtype: "post",
            datatype: "json",
            autowidth: true,
            height: 310,
            colNames: [
                '生产企业',
                '采购总金额(万元)',
                '配送金额(万元)',
                '入库金额(万元)',
                '配送率',
                '入库率'
            ],
            colModel: [
                { name: 'companyNameSc', width: 200, align:"center", sortable: false},
                { name: 'purchaseAmount', width: 80, align:"center", sortable: false},
                { name: 'del_amount', width: 80, align:"center", sortable: false,hidden:true},
                { name: 'totalWarehouseAmount', width: 80, align:"center", sortable: false},
                { name: 'del_ratio', width: 80, align:"center", sortable: false,hidden:true},
                { name: 'compRatio', width: 75, align:"center", sortable: false,
                    formatter : function(val, opts, rowdata){
                        return val.toString().substring(0,5);
                    }
                }
            ],
            rowNum: 20,
            rowList: [10, 20, 50, 100],
            rownumbers: true,
            pager: "#gridpage",
            multiselect: false,
            viewrecords: true,
            caption: "生产企业列表&nbsp;&nbsp;${date}/${delCompName}/采购金额(万元):${total}/配送金额(万元):${del}/入库金额(万元):${recp}",
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
            $('#form').submit();
        });
    });

    function search(page) {
        var prodCompName = $.trim($("#prodCompName").val());
        $("#gridlist").jqGrid('setGridParam', {
            datatype: 'json',
            postData: {
                "prodCompName": prodCompName
            },
            page: (page || 1)
        }).trigger("reloadGrid"); //重新载入
    }

    function toDrug(delCompCode, date, delCompName, prodCompName, total, del, recp, prodCompCode) {
        window.location.href = "${ctx}/anaDruginfo/toAnaDelByProdCompDrugWithMon.html?dateType=mon&delCompCode=" + delCompCode + "&date=" + date + "&delCompName=" + delCompName + "&total=" + total + "&del=" + del + "&recp=" + recp + "&prodCompName=" + prodCompName + "&prodCompCode=" + prodCompCode;
    }
</script>
</body>
</html> 
                          
                  
                  