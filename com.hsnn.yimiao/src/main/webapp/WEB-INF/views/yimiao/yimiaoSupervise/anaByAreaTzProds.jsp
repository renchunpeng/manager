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
        <li><a href="#">医院采购情况</a></li>
    </ol>
</section>

<section class="content">
    <div class=" box box-success">
        <div class="box-body">
            <form id="form" method="post">
                <div class="input">
                    <div class="textalign">生产企业<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="prodCompName" name="prodCompName" placeholder="生产企业" maxlength="100"/>
                    </div>
                    <div class="textalign">
                        <button id="selectSpec" type="button" onclick="search();" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
                    </div>
                    <div class="textalign1">
                        <button type="button" id="exportExcel" class="btn btn-success btn-sm">导 出</button>
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
    <!--  <div class=" box box-warning bottongroup">
         <button type="button" onclick="toYearAnaByHosp();" class="btn btn-primary btn-sm">按年汇总</button>
         <button type="button" onclick="toSeaAnaByHosp ();" class="btn btn-primary btn-sm">按季度汇总</button>
     </div> -->
</section>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>
<script type="text/javascript">
    var obj = {
        "names": [
            '生产企业',
            '采购总金额(万元)',
            '配送金额(万元)',
            '入库金额(万元)',
            '配送率',
            '入库率'
        ],
        "model": [
            {name: 'companyNameSc', width: 200, align: "center", sortable: false},
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
    };

    $(function () {
        $('#form :input').bind('keydown', function (event) {
            if (event.keyCode == "13") {
                event.preventDefault();
                search();
            }
        }).eq(0).focus(); //回车绑定
        $("#prodCompName").focus();//加载页面光标在第一个查询框内

        $("#gridlist").jqGrid({
            url: "${ctx}/yimiaoSupervise/getAnaHospTotal.html",
            postData: {date: "${date}", time: "${dateType}", type: "${type}", hospCode: "${hospCode}"},
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
            caption: "生产企业列表  月度:${date}/医疗机构:${hospName}/采购金额(万元):${totalamount}/配送金额(万元):${delamount}/入库金额(万元):${recpamount}",
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

        /*  function exportExcel(){
             var postData = {date:"
        ${date}",time:"
        ${dateType}",type:"
        ${type}",hospCode:"
        ${hospCode}"};
            	gridParam(postData);
            	$.StandardPost("
        ${ctx}/anaDruginfo/exportExcelAnaHospTotal.html",postData);
            } */
        $('#exportExcel').bind('click', function () {
            var postData = {date: "${date}", time: "${dateType}", type: "${type}", hospCode: "${hospCode}"};
            postData['prodCompName'] = $.trim($("#prodCompName").val());
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
        var namesTemp = objTemp.names;
        var modelTemp = objTemp.model;
        var colModelStr = "";
        for (var mod in modelTemp) {
            colModelStr += modelTemp[mod].name + ",";
        }
        objTemp = obj;
        postData['colNames'] = namesTemp.toString();
        postData['colModel'] = colModelStr.substring(0, colModelStr.length - 1);
    }

</script>
</body>
</html> 
                          
                  
                  