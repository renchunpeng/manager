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
        <li><a href="#">统计与查询</a></li>
        <li><a href="#">药品采购情况</a></li>
    </ol>
</section>
<section class="content">
    <div class=" box box-success">
        <div class="box-body">
            <form id="form" action='${ctx}/anaDruginfo/exportExcelWithMon.html' method="post">
                <div class="input">
                    <div class="textalign1">医疗机构名称<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="hospName" name="hospName" placeholder="医疗机构名称" maxlength="100"/>
                    </div>
                    <%-- <div class="textalign1">月度<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <table style="width:100%">
                                <tr>
                                    <td style="width:50%">
                                        <input id="startDate" type="datetime" name="starttime" class="textinput" placeholder="yyyy-MM" />
                                    </td>
                                    <td>&nbsp;-&nbsp;</td>
                                    <td style="width:50%">
                                        <input id="endDate"  type="datetime" name="endtime" class="textinput"  placeholder="yyyy-MM" /> 
                                    </td> 
                                </tr>
                         </table>
                    </div>
                    <div class="textalign1">药品分类<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <select class="textinput" id='drugCat' name='drugCat'>
                            <option value=''>请选择</option>
                            <option value='1'>西药</option>
                            <option value='2,3'>中药</option>
                        </select>
                    </div> --%>
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
    $(function () {
        var datetime = $("input[type='datetime']");
        var start = datetime.eq(0);
        var end = datetime.eq(1);
        start.on('focus', function () {
            WdatePicker({maxDate: "#F{$dp.$D('" + end.attr("id") + "')}", dateFmt: "yyyy-MM"});
        })
        end.on('focus', function () {
            WdatePicker({minDate: "#F{$dp.$D('" + start.attr("id") + "')}", dateFmt: "yyyy-MM"});
        });
        var obj = {
            "names": [
                '疾控中心名称',
                '所属地区',
                '采购总金额(万元)',
                '入库金额(万元)',
                '入库率'
            ],
            "model": [
                {name: 'hospitalName', width: 200, align: "center", sortable: false},
                {name: 'areaName', width: 200, align: "center", sortable: false},
                {name: 'purchaseAmount', width: 120, align: "center", sortable: false},
                {name: 'totalWarehouseAmount', width: 120, align: "center", sortable: false},
                { name: 'compRatio', width: 75, align:"center", sortable: false,
                    formatter : function(val, opts, rowdata){
                        return val.toString().substring(0,5);
                    }
                }

            ]
        };
        $("#gridlist").jqGrid({
            url: "${ctx}/yimiaoSupervise/getAnaHospTotalMon.html",
            postData: {date: "${date}", time: "mon", type: "${type}", drugCode: "${drugCode}"},
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
            caption: "<c:out value='${hospName}'></c:out>采购药品列表  月度:${date},医疗机构:${hospName},采购金额:${totalamount}",
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

        loadChart("<fmt:formatDate value='${lastMonth2}' pattern='yyyy-MM' />")

        $('#exportExcel').bind('click', function () {
            var postData = {date: "${date}", drugCode: "${drugCode}", time: "${time}", type: "${type}"};
            postData['hospName'] = $.trim($("#hospName").val());
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
    }
</script>
</body>
</html> 
                          
                  
                  