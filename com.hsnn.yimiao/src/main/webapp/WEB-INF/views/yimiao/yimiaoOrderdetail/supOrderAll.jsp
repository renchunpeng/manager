<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title><spring:message code="医院汇总统计"/></title>
<%@include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="医院汇总统计" /></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx}/home.html"><i class="fa fa-home"></i><spring:message code="message.lable.first" /></a></li>
			<li class="active"><a href="#"><spring:message code="医院汇总统计" /></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary width-control">
			<div class="box-header with-border">
				<h3 class="box-title"><spring:message code="message.query.condition"/></h3>
				<div class="box-tools pull-right">
					<button class="btn btn-box-tool height-btn" data-widget="collapse" type="button">
						<i class="fa fa-minus"></i>
					</button>
				</div>
			</div>
			<div class="box-body search-box">
				<form id="searchForm" action="" method="post">
					<div class="input">
						<div class="textalign1">医疗机构<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input type="text" class="textinput" id="hospitalName" name="hospitalName" onclick="toHosptialDialog()" value="${queryMap.hospitalName}" readonly="readonly" />
							<input type="hidden" id="hospitalId" name="hospitalId" value="${queryMap.hospitalId}" />
						</div>
						<div class="textalign"><spring:message code="drugpurProcurecatalog.companyNameSc"/><spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input type="text" class="textinput" id="companyNameSc" name="companyNameSc" onclick="toCompanyDialog('sc')" value="${queryMap.companyNameSc}" readonly="readonly" />
							<input type="hidden" id="companyIdSc" name="companyIdSc" value="${queryMap.companyIdSc}" />
						</div>
						<div class="textalign"><spring:message code="message.model.peiSongQiYe"/><spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input type="text" class="textinput" id="companyNamePs" name="companyNamePs" onclick="toCompanyDialog('ps')" value="${queryMap.companyNamePs}" readonly="readonly" />
							<input type="hidden" id="companyIdPs" name="companyIdPs" value="${queryMap.companyIdPs}" />
						</div>
					</div>
					<div class="input">
						<div class="textalign1">订单名称<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input type="text" class="textinput" id="orderName" name="orderName" onclick="toOrderDialog()" value="${queryMap.orderName}" readonly="readonly" />
							<input type="hidden" id="orderId" name="orderId" value="${queryMap.orderId}" />
						</div>
						<div class="textalign">采购时间<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input style="width:46%;" class="textinput" id="submitTimeBefore" name="submitTimeBefore" type="text" value="${queryMap.submitTimeBefore}" readonly="readonly" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'submitTimeAfter\')}'})" placeholder="yyyy-MM-dd"/>
							<span style="width:8%; text-align:center;">&nbsp;-&nbsp;</span>
							<input style="width:46%;" class="textinput" id="submitTimeAfter" name="submitTimeAfter" type="text" value="${queryMap.submitTimeAfter}" readonly="readonly" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'submitTimeBefore\')}'})" placeholder="yyyy-MM-dd"/>
						</div>
						<div class="textalign">排序方式<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<select style="width:46%" class="textinput" id="sortColumn" name="sortColumn">
								<option value="area_id">地区</option>
								<option value="HOSPITAL_ID">医疗机构</option>
								<option value="purchaseAmount">采购金额</option>
								<option value="cancleAmount">撤废金额</option>
								<option value="retArrAmount">退货金额</option>

								<option value="wamountTwo">入库金额</option>
								<option value="cratioOne">入库率</option>
							</select>
							<span style="width:8%; text-align:center;">&nbsp;-&nbsp;</span>
							<select style="width:46%" class="textinput" id="sortMode" name="sortMode">
								<option value="ASC">升序</option>
								<option value="DESC">降序</option>
							</select>
						</div>
					</div>
					<div class="input">
						<div class="textalign1"><spring:message code="drugpurProcurecatalog.productName" /><spring:message code="message.yanZheng.maoHao" /></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput" id="productName" name="productName" onclick="toProductDialog()" value="${queryMap.productName}" readonly="readonly" />
	                    </div>
						<div class="textalign">地区<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input type="hidden" id="adminAreaIdDrug" name="adminAreaIdDrug" value="${queryMap.adminAreaIdDrug}" />
							<input type="hidden" id="areaId" name="areaId" value="${queryMap.adminAreaIdDrug}" />
							<input type="hidden" id="areaIds" name="areaIds" value="${areaIds}" />

							<select class="textinput" id="area1" name="" disabled="disabled" style="width:32%;"><option value="530000">云南省</option></select>
							<select class="textinput" id="area2" name="" style="width:32%;"></select>
							<select class="textinput" id="area3" name="" style="width:32%;"><option value=""><spring:message code="message.select.option"/></option></select>
						</div>
					</div>
					<input type="hidden" id="procurecatalogId" name="procurecatalogId" value="${queryMap.procurecatalogId}" />
					<input type="hidden" id="orderD" name="orderD" value="1" />
					<input type="hidden" id="orderAll" name="orderAll" value="1" />
				</form>
			</div>
		</div>
		<div class="btn-control-box width-control">
        	<button id="search" type="button" class="btn btn-primary btn-sm navbar-right"><spring:message code="message.button.seachSpacing"/></button>
			<button id="clearBtn" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.clear" /></button>
			<button id="exportExcel" type="button" class="btn btn-primary btn-sm">导 出</button>
		</div>
		<div id="countDiv" class="btn-control-box width-control" style="margin-top:2px; display:none;">
			统计：采购金额（未减去撤单金额与配送金额）为<span id="purchaseAmountSpan" style="color:red;"></span>元，撤废金额为<span id="totalcpan" style="color:red;"></span>元
		</div>
		<table id="gridlist" class="jqgrid"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@include file="/WEB-INF/component/commonJS.jsp"%>
<script src="${ctx}/lib/js/moreAndMore.js" type="text/javascript"></script>
<script src="${ctx}/lib/js/commonAna.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
/*
//来源名称选择框加载
	var projList = eval('${bidList}');
	var source_id = '${queryMap.sourceId}';
	initSourceId(projList,source_id);

	//药品属性选择框默认值
	var is_base_drug = '${queryMap.isBaseDrug}';
	$("#isBaseDrug option[value='"+is_base_drug+"']").attr("selected",true);
*/

	//地区级联加载初始化
	var area_id = '${queryMap.adminAreaIdDrug}';
	initAreaId(area_id);
	
	if(queryInit()==true){
		initGrid();
		queryCount();
	}
});

var obj={
	"names":[ 's','订单名称','提交时间','医疗机构','采购金额(元)','撤废金额(元)','查看','其他','医院id'],
	"model":[
        {name:"x", sortable:false, align:'center',hidden:true},
		{name:"orderName", sortable:false, align:'center'},
        {name:"submitTime",  sortable:false, align:'center',formatter: function (cellvalue) {
            return new Date(cellvalue).format("yyyy-MM-dd HH:mm:ss");}},
        {name:"hospitalName", sortable:false, align:'center', },
		{name:"purchaseAmount", sortable:false, align:'center',
            formatter:function(val, opts, rowdata) {
                if (val != null) {
                    return parseFloat(val).toFixed(3);
                } else {
                    return "";
                }
            }},

        {name:"cancleAmount", sortable:false, align:'center',
            formatter:function(val, opts, rowdata) {
                if (val != null) {
                    return parseFloat(val).toFixed(3);
                } else {
                    return "";
                }
            }},

		{name:"operate", align: 'center',sortable: false, align:'center',width:250,
			formatter:function(val, opts, rowdata){
                var str = "";
                str += "<a href='javascript:void(0);' onclick='toOtherList(\""+rowdata.hospitalId+"\",\""+rowdata.hospitalName+"\",\"yimiaoOrderdetail\",\"toSupHosp\")' class='opIcon' title='相关医院'>相关医院</a>";
                str += "<a href='javascript:void(0);' onclick='toOtherList(\""+rowdata.hospitalId+"\",\""+rowdata.hospitalName+"\",\"yimiaoOrderdetail\",\"supGoodsList\")' class='opIcon' title='相关药品'>相关药品</a>";
                str += "<a href='javascript:void(0);' onclick='toOtherList(\""+rowdata.hospitalId+"\",\""+rowdata.hospitalName+"\",\"yimiaoOrderdetail\",\"supOrderList\")' class='opIcon' title='采购明细'>采购明细</a>";
                return str;
			}
    	},
        {name:"operate_other", width:80, sortable:false, align:'center',
            formatter:function(val, opts, rowdata){
                var str = "<select class='textinput' id='operateOther' name='operateOther' onchange='toOtherList1(\""+rowdata.hospitalId+"\",\""+rowdata.hospitalName+"\",this.options[this.options.selectedIndex].value)'>";
                str += "<option value=\"\">其他</option>";
                str += "<option value=\"yimiaoOrderdetail/supCompscDayList\">生产企业</option>";
                str += "<option value=\"yimiaoOrderdetail/supOrderAll\">订单查看</option>";
                str += "</select>";
                return str;
            }
        },
    	{name:"hospitalId", sortable:false, align:'center', hidden:true}
	]
};


    $("#areaId").val($("#adminAreaIdDrug").val());
	var queryData = $("#searchForm").serializeJSON();
	$("#gridlist").jqGrid({
        url: "${ctx }/yimiaoOrderdetail/getSupOrder.html",
		mtype:"post",
		datatype:"json",
		autowidth:true,
		colNames:obj.names,
		colModel:obj.model,
		rowNum:20,
		rowList:[10,20,50,100],
		rownumbers:true,
		pager:"#gridpage",
		viewrecords:true,
		caption:"医院汇总统计",
		postData:queryData,
		gridComplete:function(){
			autoRNWidth("gridlist");
            queryCount();
		}
	});
	$(window).trigger("resize");

//跳转页面
function toOtherList1(hospitalId,hospitalName,url){

    $("#searchForm").attr('action',"${ctx}/"+url+".html");
    $("#searchForm").submit();
}
//跳转页面
function toOtherList(hospitalId,hospitalName,type,url){

    $("#searchForm").attr('action',"${ctx}/"+type+"/"+url+".html");
    $("#searchForm").submit();
}

//ajax查询统计数据
function queryCount(){
    $("#areaId").val($("#adminAreaIdDrug").val());
	var queryData = $("#searchForm").serializeJSON();
	$.ajax({
        url:"${ctx}/yimiaoOrderdetail/getHospDayCount.html",
		data:queryData,
		dataType:'json', 
		success:function(result){
            $("#purchaseAmountSpan").html(result.PURCHASEAMOUNT);
            $("#purchaseCountSpan").html(result.PURCHASECOUNT);
            $("#totaltdSpan").html(result.RETARRCOUNT)
            $("#totalWarehouseCountSpan").html(result.WCOUNTONE);
            $("#totalWarehouseAmountSpan").html(result.WAMOUNTONE);
            $("#totalcpan").html(result.CANCLEAMOUNT);
            $("#countDiv").css("display","block");
		},
		error:function(){
			$("#purchaseAmountSpan").html("0");
	    	$("#totalWarehouseAmountSpan").html("0");
	    	$("#countDiv").css("display","none");
		} 
	});
}

//查询按钮
$("#search").click(function(){
           $("#orderD").val(1);
    $("#orderAll").val(1);
	if(queryInit()==false){
		$.alert("请选择选择采购时间范围！","warn");
	}else{
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid('setGridParam',{
            url: "${ctx }/yimiaoOrderdetail/getSupOrder.html",
			datatype:'json',
			postData:queryData
		}).trigger("reloadGrid");
		queryCount();
		$("#exportExcel").css("display","block");
	}
});

//清空按钮
$("#clearBtn").click(function(){
	$(':input','#searchForm').val('');
	$("#sortColumn").val('ADMIN_AREA_ID_DRUG');
	$("#sortMode").val('ASC');
	$("#area1").val('530000');
});

//导出按钮
$("#exportExcel").click(function(){
    $("#orderD").val(1);
	if(queryInit()==false){
		$.alert("请选择选择采购时间范围！","warn");
	}else{
		$("#exportExcel").css("display","none");
		var queryData = $("#searchForm").serializeJSON();
        $.StandardPost("${ctx}/yimiaoOrderdetail/exportAllSup.html",queryData);
	}
});
</script>
</html>