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
    <h1>医院采购情况</h1>
    <ol class="breadcrumb">
        <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
        <li><a href="#">监管系统</a></li>
        <li><a href="#">总体采购情况</a></li>
    </ol>
</section>

<section class="content">
    <div class=" box box-success">
        <div class="box-body">
            <form id="form" method="post">
                <div class="input">
                    <div class="textalign1">医疗机构名称<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="hospName" name="hospName" placeholder="医疗机构名称" maxlength="100"/>
                    </div>
                    <%--<div class="textalign">地区：</div>--%>
                    <%--<div class="boxinput">--%>
                        <%--<table style="width:100%;">--%>
                            <%--<tr>--%>
                                <%--<td style="width:33%">--%>
                                    <%--<select class="textinput" id="area1" disabled="disabled" name="area1">--%>
                                        <%--<option value="${province }">${provinceName }</option>--%>
                                    <%--</select>--%>
                                <%--</td>--%>
                                <%--<td style="width:33%">--%>
                                    <%--<select class="textinput" id="area2" name="area2"></select>--%>
                                <%--</td>--%>
                                <%--<td style="width:33%">--%>
                                    <%--<select class="textinput" id="area3" name="area3"></select>--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                        <%--</table>--%>
                    <%--</div>--%>
                </div>
                <div class="input" style="margin-top:3px">
                    <%-- <div class="textalign1"><spring:message code="message.listForm.yiLiaoJiGouFenLei"/>：</div>
                  <div class="boxinput">
                      <select class="textinput"  id="shospCl" name="shospCl">
                          <option value="">请选择</option>
                          <option  value="1">县级及县级以上医院</option>
                          <option  value="0">基层医院</option>
                           <c:forEach items="${clList}" var="cl">
                              <c:if test="${cl.dicCode==1 || cl.dicCode==2}">
                                  <option  value="${cl.dicCode}">${cl.dicName}</option>
                              </c:if>
                          </c:forEach>
                      </select>
                  </div> --%>

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
    <!--  <div class=" box box-warning bottongroup">
         <button type="button" onclick="toYearAnaByHosp();" class="btn bt n-primary btn-sm">按年汇总</button>
         <button type="button" onclick="toSeaAnaByHosp ();" class="btn btn-primary btn-sm">按季度汇总</button>
     </div> -->
</section>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>
<script type="text/javascript">

    var obj = {
        "names": [
            '疾控中心名称',
            '所属地区',
            '采购金额(元)',
            '入库金额(元)',
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

    $(function () {
        $("#area2").HNSelect({
            url: "${pageContext.request.contextPath}/selectController/getArea.html", data: {ID: '${province}'}, defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
            func: function () {
                $("#area3").HNSelect({
                    parent_selector: "#area2",
                    url: "${pageContext.request.contextPath}/selectController/getArea.html",
                    dataid: "ID",
                    defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
                });
            }
        });


        $('#form :input').bind('keydown', function (event) {
            if (event.keyCode == "13") {
                event.preventDefault();
                search();
            }
        }).eq(0).focus();
        $("#gridlist").jqGrid({
            url: "${ctx}/yimiaoSupervise/getAnaByAllTz.html",
            postData: {date: "${date}", dateType: "${dateType}", type: "${type}", del: "${del}", recp: "${recp}"},
            mtype: "post",
            datatype: "json",
            autowidth: true,
            shrinkToFit: true,
            height: 310,
            colNames: obj.names,
            colModel: obj.model,
            rowNum: 20,
            rowList: [10, 20, 50, 100],
            rownumbers: true,
            pager: "#gridpage",
            multiselect: false,
            viewrecords: true,
            caption: "医院列表  月度:${date}/采购金额(万元):${total}/配送金额(万元):${del}/入库金额(万元):${recp}",
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

        var postData = {
            date: "${date}",
            dateType: "${dateType}",
            type: "${type}",
            hospName: $.trim($("#hospName").val())
        };
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
                          
                  
                  