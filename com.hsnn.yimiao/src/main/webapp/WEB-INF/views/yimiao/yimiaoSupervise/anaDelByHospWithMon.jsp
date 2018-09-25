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
        <li><a href="#">配送企业采购情况</a></li>
    </ol>
</section>

<section class="content">
    <div class=" box box-success">
        <div class="box-body">
            <form id="form" method="post" action='${ctx}/yimiaoSupervise/exportExcelByAllTz.html?delCompName=${delCompName}&date=${date}&type=${type}'>
                <div class="input">
                    <div class="textalign">医疗机构名称<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="hospName" name="hospName" placeholder="医疗机构" maxlength="100"/>
                    </div>
                    <%-- <div class="textalign">地区：</div>
                   <div class="boxinput">
                      <table style="width:100%;">
                          <tr>
                             <td style="width:33%">
                               <select class="textinput" id="area1" disabled="disabled"  name="area1">
                               <option value="${province }">${provinceName }</option>
                               </select>
                             </td>
                             <td style="width:33%">
                               <select class="textinput" id="area2" name="area2" ></select>
                               </td>
                               <td style="width:33%">
                               <select class="textinput" id="area3" name="area3" ></select>
                               </td>
                          </tr>
                       </table>
                   </div>
                    <div class="textalign">地区：</div>
                    <div class="boxinput">
                        <table style="width:100%;">
                            <tr>
                                <td style="width:33%">
                                    <select class="textinput" id="area1" disabled="disabled" name="area1">
                                        <option value="${province }">${provinceName }</option>
                                    </select>
                                </td>
                                <td style="width:33%">
                                    <c:if test="${province2 != '' && province2 != null}">
                                        <select class="textinput" id="area2" disabled="disabled" name="area2">
                                            <option value="${province2 }">${provinceName2 }</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${province2 == '' || province2 == null}">
                                        <select class="textinput" id="area2" name="area2">
                                        </select>
                                    </c:if>
                                </td>
                                <td style="width:33%">
                                    <select class="textinput" id="area3" name="area3"></select>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="textalign">是否零差率医院：</div>
                    <div class="boxinput">
                        <select class="textinput" id="hospClassify" name="hospClassify">
                            <option value="">请选择</option>
                            <option value="2">是</option>
                            <option value="1">否</option>
                        </select>
                    </div>
                </div>
                <div class="input">
                    <div class="textalign"><spring:message code="message.lable.yiLiaoJiGouDengJi"/>：</div>
                    <div class="boxinput">
                        <select class="textinput" id="hospLevelId" name="hospLevelId">
                            <option value="">请选择</option>
                            <c:forEach var='leve' items="${list}">
                                <option value="${leve.text}">${leve.text}</option>
                            </c:forEach>
                        </select>
                    </div>--%>
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
    $('#hospName,#hospClassify,#hospLevelId').bind('keydown', function (event) {
        if (event.keyCode == "13") {        //13 位电脑上回车键的位置代码
            event.preventDefault();
            $('#selectSpec').click();
        }
    });
    $("#hospName").focus();//加载页面光标在第一个查询框内 

    if (${province2 != '' && province2 != null}) {
        $("#area3").HNSelect({
            url: "${pageContext.request.contextPath}/selectController/getArea.html", data: {ID: '${province2}'}, defaultText: "<option value=''><spring:message code="message.select.option"/></option>"
        });
    } else {
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
    }


    $(function () {
        $("#gridlist").jqGrid({
            url: "${ctx}/yimiaoSupervise/getAnaDelWithMon.html",
            postData: {date: "${date}", dateType: "${dateType}", type: "${type}", delCompName: "${delCompName}"},
            mtype: "post",
            datatype: "json",
            autowidth: true,
            shrinkToFit: false,
            height: 310,
            colNames: [
                '疾控中心名称',
                '所属地区',
                '采购总金额(万元)',
                '入库金额(万元)',
                '入库率'
            ],
            colModel: [
                {name: 'hospitalName', width: 200, align: "center", sortable: false},
                {name: 'areaName', width: 200, align: "center", sortable: false},
                {name: 'purchaseAmount', width: 120, align: "center", sortable: false},
                {name: 'totalWarehouseAmount', width: 120, align: "center", sortable: false},
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
            caption: "医院列表&nbsp;&nbsp;${date}/${delCompName}/采购金额(万元):${total}/配送金额(万元):${del}/入库金额(万元):${recp}",
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
        var hospName = $.trim($("#hospName").val());
        var area1 = $.trim($("#area1").val());
        var area2 = $.trim($("#area2").val());
        var area3 = $.trim($("#area3").val());
        var hospClassify = $.trim($("#hospClassify").val());
        var hospLevelId = $.trim($("#hospLevelId").val());
        $("#gridlist").jqGrid('setGridParam', {
            datatype: 'json',
            postData: {
                "hospName": hospName,
                "area1": area1,
                "area2": area2,
                "area3": area3,
                "hospClassify": hospClassify,
                "hospLevelId": hospLevelId
            },
            page: (page || 1)
        }).trigger("reloadGrid"); //重新载入
    }

    function toDrug(delCompCode, date, delCompName, hospName, total, del, recp, hospCode) {
        window.location.href = "${ctx}/anaDruginfo/toAnaDelByHospDrugWithMon.html?dateType=mon&delCompCode=" + delCompCode + "&date=" + date + "&delCompName=" + delCompName + "&total=" + total + "&del=" + del + "&recp=" + recp + "&hospName=" + hospName + "&hospCode=" + hospCode;
    }
</script>
</body>
</html> 
                          
                  
                  