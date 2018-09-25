<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
	<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
	<title>总体采购情况</title>
	<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
	<style>
		a.opIcon {
			display: inline-block;
			width: 20px;
			height: 20px;
		}
	</style>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
<section class="content-header">
	<h1><spring:message code="总体采购情况"/></h1>
	<ol class="breadcrumb">
		<li><a href="${ctx }/home.html"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
		<li class="active"><a href="#"><spring:message code="监管系统"/></a></li>
		<li class="active"><a href="#"><spring:message code="总体采购情况"/></a></li>
	</ol>
</section>
<section class="content">
	<div class="box box-success">
		<div class="box-header with-border">

			<div class="box-tools pull-right">
				<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
			</div><!-- /.box-tools -->
		</div>
		<div class="box-body mchart">
			<div id="mChart" style="height: 300px; width:98%; padding: 8px;"></div>
		</div>
	</div>
	<div class=" box box-primary">
		<div class="box-body">
			<form id="form" method="post" >
                <div class="textalign1">月度<spring:message code="message.yanZheng.maoHao"/></div>
                <div class="boxinput">
                    <table style="width:100%">
                        <tr>
							<td style="width:50%">
								<input id="startDate" type="datetime" name="starttime" class="textinput" placeholder="开始月份" />
							</td>
							<td>&nbsp;-&nbsp;</td>
							<td style="width:50%">
								<input id="endDate"  type="datetime" name="endtime" class="textinput"  placeholder="结束月份" />
							</td>
						</tr>
                    </table>
                </div>
                <div class="textalign">
					<button id="selectSpec" type="button" onclick="search();" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
                </div>
                <div class="textalign1">
                    <button type="button" onclick="exportExcel();" class="btn btn-success btn-sm">导 出</button>
                </div>

			</form>
		</div>
	</div>

	<table class="jqgrid" id="gridlist"></table>
	<div id="gridpage"></div>
</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
    var obj ={
        "names": [
            '操作',
            '月度',
            '采购金额(元)',
            '入库金额(元)',
            '入库率(%)'
        ],
        "model": [
            {name:'oper',index:'formName', width:100, align:"center", sortable:false,formatter:function(val,option,rowdata){
                    var date = new Date(rowdata.addTime).format('yyyy-MM');
                    var str = "<a href='javascript:void(0)' onclick=\"xgTz('"+date+"','"+rowdata.purchaseAmount+"','"+rowdata.purchaseAmount+"','"+rowdata.totalWarehouseAmount+"','2')\" style='background:url(${ctx}/lib/img/icon/icon.png) no-repeat -40px -80px' class='opIcon' title='采购药品'></a>";
                    str += "<a href='javascript:void(0)' onclick=\"xgTz('"+date+"','"+rowdata.purchaseAmount+"','"+rowdata.purchaseAmount+"','"+rowdata.totalWarehouseAmount+"','1')\" style='background:url(${ctx}/lib/img/icon/icon.png) no-repeat -20px -120px' class='opIcon' title='采购医院'></a>";
                    str += "<a href='javascript:void(0)' onclick=\"xgTz('"+date+"','"+rowdata.purchaseAmount+"','"+rowdata.purchaseAmount+"','"+rowdata.totalWarehouseAmount+"','3')\" style='background:url(${ctx}/lib/img/icon/icon.png) no-repeat -120px -60px' class='opIcon' title='采购配送企业'></a>";
                    str += "<a href='javascript:void(0)' onclick=\"xgTz('"+date+"','"+rowdata.purchaseAmount+"','"+rowdata.purchaseAmount+"','"+rowdata.totalWarehouseAmount+"','4')\" style='background:url(${ctx}/lib/img/icon/icon.png) no-repeat -40px -120px' class='opIcon' title='采购生产企业'></a>";
                    return str;
                }},
            { name: 'addTime', width: 80, align:"center", sortable: false,
                formatter : function(val, opts, rowdata){
                    return new Date(val).format('yyyy-MM');
                }
            },
            { name: 'purchaseAmount', width: 75, align:"center", sortable: false},
            { name: 'totalWarehouseAmount', width: 75, align:"center", sortable: false},
            { name: 'compRatio', width: 75, align:"center", sortable: false,
                formatter : function(val, opts, rowdata){
                    return val.toString().substring(0,5);
                }
            }
        ]
    };

    $(function () {
        var datetime =$("input[type='datetime']");
        var start = datetime.eq(0);
        var end = datetime.eq(1);
        start.on('focus',function(){
            WdatePicker({maxDate:"#F{$dp.$D('"+end.attr("id")+"')}",dateFmt:"yyyy-MM"});
        })
        end.on('focus',function(){
            WdatePicker({minDate:"#F{$dp.$D('"+start.attr("id")+"')}",dateFmt:"yyyy-MM"});
        });

        $("#gridlist").jqGrid({
            url: "${ctx}/yimiaoSupervise/getDataByAll.html",
            mtype: "post",
            datatype: "json",
            autowidth: true,
            height: 310,
            colNames: obj.names,
            colModel: obj.model,
            rowNum: 20,
            rowList: [10, 20, 50,100],
            rownumbers: true,
            pager: "#gridpage",
            multiselect: false,
            viewrecords: true,
            caption: "月度采购汇总列表",//品规列表
            gridComplete:function(){
                autoRNWidth("gridlist");
            },
            jsonReader: {
                repeatitems: false,
                id: "qualitySpecId"
            },
            loadComplete: function (data) { //完成服务器请求后，回调函数
                var option = {
                    tooltip: {
                        trigger: 'axis'
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            magicType: { show: true, type: ['line', 'bar'] },
                            restore: { show: true },
                            saveAsImage: { show: true }
                        }
                    },
                    calculable: true,
                    legend: {
                        data: ['采购金额(万元)', '配送金额(万元)', '入库金额(万元)']
                    },
                    xAxis: [
                        {
                            type: 'category',
                            data: eval(data.conditions.yTime)
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            name: '金额(万元)',
                            axisLabel: {
                                formatter: '{value}'
                            }
                        }
                    ],
                    series: [

                        {
                            name: '采购金额(万元)',
                            type: 'bar',
                            data: eval(data.conditions.total)
                        },
                        {
                            name: '配送金额(万元)',
                            type: 'bar',
                            data: eval(data.conditions.del)
                        },
                        {
                            name: '入库金额(万元)',
                            type: 'bar',
                            data: eval(data.conditions.recp)
                        }
                    ]
                };
                var myChart = echarts.init(document.getElementById('mChart'), theme);
                myChart.setOption(option);
            }
        });
        $("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
        $(window).trigger("resize");

    });
    function search(page) {
        var startDate = $.trim($("#startDate").val());
        var endDate = $.trim($("#endDate").val());
        if(endDate.length > 0 && startDate.length == 0) {
            $("#startDate").trigger("focus");
            $.alert("请选择开始月份！", "warn");
            return;
        }else if(startDate.length > 0 && endDate.length == 0) {
            $("#chartTitle").text(startDate.replace("-","年")+"月至<fmt:formatDate value='${lastMonth2}' pattern='yyyy年MM月' />总体采购情况");
        }else if(startDate.length > 0 && endDate.length > 0){
            $("#chartTitle").text(startDate.replace("-","年")+"月至"+endDate.replace("-","年")+"月总体采购情况");
        }else {

            $("#chartTitle").text("<fmt:formatDate value='${lastMonth}' pattern='yyyy年MM月' />至<fmt:formatDate value='${lastMonth2}' pattern='yyyy年MM月' />总体采购情况");
        }
        var data =formatForm("form");
        $("#gridlist").jqGrid('setGridParam',{
            datatype:'json',
            postData:data,
            page : (page || 1)
        }).trigger("reloadGrid"); //重新载入
    }

    function xgTz(date,total,del,recp,type) {
        //type 1医疗机构2药品3配送企业4生产企业5地区
        window.location.href="${ctx}/yimiaoSupervise/toAnaByAllTz.html?dateType=mon&date="+date+"&total="+total+"&del="+del+"&recp="+recp+"&type="+type;
    }

    function exportExcel(){

        var postData = $("#form").serializeJSON();
        gridParam(postData);
        $.StandardPost("${ctx}/yimiaoSupervise/exportExcelWithAllMon.html",postData);
    }
    var objTemp = null;
    function gridParam(postData){
        if(!objTemp){
            objTemp = $.extend(true, {}, obj);
        }
        var namesTemp = objTemp.names;
        var modelTemp = objTemp.model;
        if($.inArray('操作',namesTemp) >= 0) {
            namesTemp.splice($.inArray('操作',namesTemp),1);
            modelTemp.splice(0,1);
        }
        var colModelStr ="";
        for(var mod in modelTemp){
            colModelStr+=modelTemp[mod].name+",";
        }

        postData['colNames'] = namesTemp.toString();
        postData['colModel'] = colModelStr.substring(0,colModelStr.length-1);
    }
</script>
</html>