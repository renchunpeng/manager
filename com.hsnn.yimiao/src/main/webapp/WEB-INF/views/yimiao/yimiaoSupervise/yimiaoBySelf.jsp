<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
	<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
	<title>疫苗采购情况</title>
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
	<h1><spring:message code="疫苗采购情况"/></h1>
	<ol class="breadcrumb">
		<li><a href="${ctx }/home.html"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
		<li class="active"><a href="#"><spring:message code="监管系统"/></a></li>
		<li class="active"><a href="#"><spring:message code="疫苗采购情况"/></a></li>
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
			<form id="searchForm" method="post" >
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
				<div class="textalign">产品名称<spring:message code="message.yanZheng.maoHao"/></div>
				<div class="boxinput">
					<input type="text" class="textinput" id="drugName" name="drugName"
						   placeholder="产品名称" maxlength="100"/>
				</div>
				<div class="textalign">
					<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
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
			'产品编号',
			'疫苗通用名',
			'产品名称',
			'制剂规格（申报剂型）',
			'生产企业（投标企业）',
            '采购金额(元)',
            '入库金额(元)',
            '入库率(%)'
        ],
        "model": [
            {name:'oper',index:'formName', width:100, align:"center", sortable:false,formatter:function(val,option,rowdata){
                    var date = new Date(rowdata.addTime).format('yyyy-MM');
                    var str ="<a href='javascript:void(0)' onclick='toAnaDruginfoTotal(\""+rowdata.purchaseAmount+"\",\""+rowdata.purchaseAmount+"\",\""+rowdata.totalWarehouseAmount+"\",\""+rowdata.goodsId+"\",\""+rowdata.goodsName+"\",\""+date+"\",\"mon\",\"1\");'  style='background:url(${ctx}/lib/img/icon/icon.png) no-repeat -20px -120px' class='opIcon' title='医院采购详情'></a>";
                    str+="<a href='javascript:void(0)'  onclick='toAnaDruginfoTotal(\""+rowdata.purchaseAmount+"\",\""+rowdata.purchaseAmount+"\",\""+rowdata.totalWarehouseAmount+"\",\""+rowdata.goodsId+"\",\""+rowdata.goodsName+"\",\""+date+"\",\"mon\",\"3\");'  style='background:url(${ctx}/lib/img/icon/icon.png) no-repeat -120px -60px' class='opIcon' title='配送企业采购详情'></a>";
                    return str;
                }},
            { name: 'addTime', width: 80, align:"center", sortable: false,
                formatter : function(val, opts, rowdata){
                    return new Date(val).format('yyyy-MM');
                }
            },
            { name: "goodsId", key:true, width: 100, align: 'center' ,sortable: false},
            { name: "productName", width: 150, align: 'center' ,sortable: false},
            { name: "goodsName", width: 150, align: 'center' ,sortable: false},
            { name: "outlook", width: 150, align: 'center' ,sortable: false,
                formatter : function(val, opts, rowdata){
                    return rowdata.outlook+"（"+rowdata.medicinemodel+"）";
                }
            },
            { name: "companyNameSc", width: 150, align: 'center' ,sortable: false,
                formatter : function(val, opts, rowdata){
                    return rowdata.companyNameSc+"（"+rowdata.companyNameTb+"）";
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

    $(function(){
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
            url: "${ctx}/yimiaoSupervise/getDataBySelf.html",
            mtype: "post",
            datatype: "json",
            height: 310,
            autowidth: true,
            colNames: obj.names,
            colModel: obj.model,
            multiselect: false,
            caption: "疫苗采购情况列表",
            rowNum: 20,
            rowList: [10, 20, 50,100],
            viewrecords: true,
            pager: "#gridpage",
            gridComplete:function(){
                autoRNWidth("gridlist");
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
                        data: ['采购金额(万元)', '入库金额(万元)']
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

        $(window).trigger("resize");
        // 查询
        $("#search").click(function(){
            var queryData = $("#searchForm").serializeJSON();
            $("#gridlist").jqGrid("setGridParam", {
                url: "${ctx}/yimiaoSupervise/getDataBySelf.html",
                postData: queryData,//发送查询条件
            }).trigger("reloadGrid");//重新载入
        });
    });

    function toAnaDruginfoTotal(totalAmount,delAmount,recpAmount,drugCode,drugName,date,time,type){
        var postData = {totalAmount:totalAmount,delAmount:delAmount,recpAmount:recpAmount,drugCode:drugCode,drugName:drugName,date:date,time:time,type:type};
        $.StandardPost("${ctx}/yimiaoSupervise/toAnaDruginfoTotal.html",postData);
    }

    //导出
    function exportExcel(){
        var postData = $("#searchForm").serializeJSON();
        gridParam(postData);
        $.StandardPost("${ctx}/yimiaoSupervise/exportExcelWithSelf.html",postData);

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