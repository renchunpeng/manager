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
        <li class="active"><a href="#">已处理调价计划</a></li>
    </ol>
</section>

<section class="content">
    <table class="infoBox">
        <tr>
            <td width="150px" class="infoBoxleft">
                <p style="color:#fff;font-size:20px;text-align:center;font-weight:600">调价信息</p>
            </td>
            <td>
                <div class="box-body" style="background:url('${ctx }/lib/img/infobg.png') no-repeat bottom right;">
                    <div class="form-group form-group-xs margintop-xs"  style="margin-top:5px;">
                        <label class="col-sm-2 text-right" style="text-align: left;width: 81px;">计划名称：</label>
                        <div class="col-sm-2 text-left" >
                            ${drugpurPriceadjplan.priceAdjPlanName }
                        </div>
                        <label class="col-sm-1 text-right margintop-xs" for="txtDrugForm">制定时间：</label>
                        <div class="col-sm-3 text-left" >
                            <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${drugpurPriceadjplan.createDatetime}" />
                        </div>
                        <label class="col-sm-1 text-right margintop-xs">执行时间：</label>
                        <div class="col-sm-3 text-left">
                            <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${drugpurPriceadjplan.executeDatetime}" />
                        </div>
                    </div>
                    <div class="form-group form-group-xs" style="margin-top:-10px">
                        <label class="col-sm-1 text-right margintop-xs">调价依据：</label>
                        <div class="col-sm-2 text-left">
                            ${drugpurPriceadjplan.priceAdjAccord }
                        </div>
                    </div>
                    <div class="form-group form-group-xs" style="margin-top:-10px;margin-bottom:-10px;">
                        <label class="col-sm-2 text-right margintop-xs" >备注：</label>
                        <div class="col-sm-10 text-left">
                            ${drugpurPriceadjplan.remark }
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <form id="searchForm" method="post" class="form-horizontal">
        <div class=" box box-success">
            <div class="box-body">
                <div class="input">
                    <div class="textalign1">疫苗名称：</div>
                    <div class="boxinput">
                        <input id="productName" name="productName" class="textinput" type="text" placeholder="疫苗名称" />
                    </div>
                    <div class="textalign">疫苗编号：</div>
                    <div class="boxinput">
                        <input id="procurecatalogId" name="procurecatalogId" class="textinput" type="text" placeholder="疫苗编号" />
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
         <button type="button" class="btn btn-danger btn-sm" onclick='history.go(-1)'>返 回</button>
    </div>
    <table class="jqgrid" id="gridlist"></table>
    <div id="gridpage"></div>

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
            { name: 'origProPriceLimit', align: 'center', sortable:false},
            { name: 'currProPriceLimit', align: "center", sortable:false},
        ]
    };


    $(function () {
        $("#gridlist").jqGrid({
            url: "${ctx}/yimiaoPriceadjplan/getPriceDurgList.html?priceAdjPlanId=${drugpurPriceadjplan.priceAdjPlanId}",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: false,
            rownumbers: true,
            autowidth: true,

            caption: "已处理调价计划",
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
                url: "${ctx}/yimiaoPriceadjplan/getPriceDurgList.html?priceAdjPlanId=${drugpurPriceadjplan.priceAdjPlanId}",
                postData: queryData,//发送查询条件
            }).trigger("reloadGrid");//重新载入
        });
    });




</script>
</body>
</html>