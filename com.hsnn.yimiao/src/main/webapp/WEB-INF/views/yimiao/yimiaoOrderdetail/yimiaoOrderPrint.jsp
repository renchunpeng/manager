<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="订单打印"/></title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <style type="text/css">
        body {
            font-size: 62.5%;
        }

        .main {
            /*height: 21cm;
                    width: 29.7cm;*/
            font-size: 1.1em;
        }

        .title {
            text-align: center;
            font-size: 2em;
            font-weight: bold;
            margin-bottom: 4px;
            margin-top: 4px;
        }

        .headtdwidth {
            width: 8em;
        }

        .content {
            width: 100%;
            text-align: center;
            border-collapse: collapse;
        }

        .content td {
            border: 1px solid;
        }

        .content thead {
            font-size: 1.1em;
        }

        .content tbody td {
            word-wrap: break-word;
        }

        @media print {
            .Noprint {
                display: none;
            }

            .PageNext {
                page-break-after: always;
            }
        }

        @media print {
            img {
                display: none;
            }
        }
    </style>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
<section class="content">
    <div class=" box box-success">
        <div class="box-body">
            <div class="main">
                <c:choose>
                    <c:when test="${empty orderDetailList}">
                        <p class="title">还没有未完成采购记录！</p>
                    </c:when>
                    <c:otherwise>
                        <%--<p class="title" style="margin-top: 100px">
                            <span id="labOrderName">【${orderPackId }】随货联</span>
                        </p>--%>
                        <%--<div class="head" style="margin-bottom: 10px;">
                            <table class="content" cellpadding="0" cellspacing="0" style="table-layout: fixed;">
                                <tbody>
                                <tr>
                                    <td class="headtdwidth">配送单位：</td>
                                    <td style="text-align: left">
                                        <span id="labHospitalName">${orderPack.delComName }</span>
                                    </td>
                                    <td class="headtdwidth">配送地址：</td>
                                    <td style="text-align: left">
                                        <span id="labcompanyName">${orderPack.hospArFullname }--${orderPack.recpAddr}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="headtdwidth">收货单位：</td>
                                    <td style="text-align: left">
                                        <span>${orderPack.hospName}</span>&nbsp;
                                    </td>
                                    <td class="headtdwidth">确认配送时间：</td>
                                    <td style="text-align: left">
                                        <span>${orderPack.orderConfirmTime}</span>&nbsp;
                                    </td>
                                </tr>
                                <tr>
                                    <td>备注：</td>
                                    <td colspan="3" style="text-align: left"><span>${remarks}</span></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>--%>
                        <table class="content" cellpadding="0" cellspacing="0" style="table-layout: fixed;">
                            <thead>
                            <th style="text-align: center" colspan="12">未完成采购单</th>
                            <tr>
                                <td style="width: 1em;">序号</td>
                                <td style="width: 5em;">订单名称</td>
                                <td style="width: 4em;">采购单位</td>
                                <td style="width: 5em;">疫苗编号</td>
                                <td style="width: 5em;">疫苗通用名</td>
                                <td style="width: 5em;">疫苗名称</td>
                                <td style="width: 5em;">剂型</td>
                                <td style="width: 6em;">规格</td>
                                <td style="width: 8em;">生产企业</td>
                                <td style="width: 8em;">投标企业</td>
                                <td style="width: 6em;">最小制剂单位</td>
                                <td style="width: 5em;">采购数量</td>
                                <td style="width: 5em;">最小制剂单位中标价格（元）</td>
                                <td style="width: 5em;">采购金额</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orderDetailList }" var="orderDetail" varStatus="i">
                                <tr>
                                    <td>${i.index + 1 }</td>
                                    <td>${orderDetail.orderName }</td>
                                    <td>${orderDetail.hospitalName }</td>
                                    <td>${orderDetail.goodsId }</td>
                                    <td>${orderDetail.productName }</td>
                                    <td>${orderDetail.goodsName }</td>
                                    <td>${orderDetail.medicinemodel }</td>
                                    <td>${orderDetail.outlook }</td>
                                    <td>${orderDetail.companyNameSc }</td>
                                    <td>${orderDetail.companyNameTb }</td>
                                    <td>${orderDetail.unit }</td>
                                    <td>${orderDetail.purchaseCount }</td>
                                    <td>${orderDetail.purchasePrice }</td>
                                    <td>${orderDetail.purchaseAmount }</td>
                                </tr>
                            </c:forEach>
                            <%--<tr style="height: 45px">
                                <td style="text-align: left; border-left-style:none;border-right-style:none" colspan="13">
                                    金额合计： <strong><span id="labTotalAmount1"></span></strong>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    打印日期：
                                    <%
                                        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                                        out.println(datetime);
                                    %></td>
                                </td>
                            </tr>--%>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>
<script src="${ctx}/lib/js/jquery.qrcode.min.js" type="text/javascript"></script>
<script src="${ctx}/lib/js/numberoperate.wufeng.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        /*$("#labTotalAmount1").text(numberDHCut('${orderPack.amount}'));*/
        window.print();
    });

</script>
</html>