<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title><spring:message code="医院月采购统计分析"/></title>
<%@include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="医院月采购统计分析" /></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx}/home.html"><i class="fa fa-home"></i><spring:message code="message.lable.first" /></a></li>
			<li class="active"><a href="#"><spring:message code="医院月采购统计分析" /></a></li>
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
						<div class="textalign">生产企业<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input type="text" class="textinput" id="companyNameSc" name="companyNameSc" onclick="toCompanyDialog('sc')" value="${queryMap.companyNameSc}" readonly="readonly" />
							<input type="hidden" id="companyIdSc" name="companyIdSc" value="${queryMap.companyIdSc}" />
						</div>
						<div class="textalign">配送企业<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input type="text" class="textinput" id="companyNamePs" name="companyNamePs" onclick="toCompanyDialog('ps')" value="${queryMap.companyNamePs}" readonly="readonly" />
							<input type="hidden" id="companyIdPs" name="companyIdPs" value="${queryMap.companyIdPs}" />
						</div>
					</div>
					<div class="input">
						<div class="textalign1">所属地区<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input type="hidden" id="adminAreaIdDrug" name="adminAreaIdDrug" value="${queryMap.adminAreaIdDrug}" />
							<select class="textinput" id="area1" name="" disabled="disabled" style="width:32%;"><option value="530000">云南省</option></select>
							<select class="textinput" id="area2" name="" style="width:32%;"></select>
							<select class="textinput" id="area3" name="" style="width:32%;"></select>
						</div>
						<div class="textalign">采购时间<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input style="width:46%;" class="textinput" id="submitTimeBefore" name="submitTimeBefore" type="text" value="${queryMap.submitTimeBefore}" readonly="readonly" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'submitTimeAfter\')}'})" placeholder="yyyy-mm-dd"/>
							<span style="width:8%; text-align:center;">&nbsp;-&nbsp;</span>
							<input style="width:46%;" class="textinput" id="submitTimeAfter" name="submitTimeAfter" type="text" value="${queryMap.submitTimeAfter}" readonly="readonly" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'submitTimeBefore\')}'})" placeholder="yyyy-mm-dd"/>
						</div>
						<div class="textalign">排序方式<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<select style="width:46%" class="textinput" id="sortColumn" name="sortColumn">
								<option value="purchaseAmount">采购金额</option>
								<option value="wamountTwo">退货金额</option>
								<option value="wamountOne">到货金额</option>
								<option value="cratioOne">到货平均完成率</option>
							</select>
							<span style="width:8%; text-align:center;">&nbsp;-&nbsp;</span>
							<select style="width:46%" class="textinput" id="sortMode" name="sortMode">
								<option value="ASC" selected="selected">升序</option>
								<option value="DESC">降序</option>
							</select>
						</div>
					</div>
					<div class="input">
						<div class="textalign1">通用名<spring:message code="message.yanZheng.maoHao" /></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput" id="productName" name="productName" onclick="toProductDialog()" value="${queryMap.productName}" readonly="readonly" />
	                    	<input type="hidden" id="procurecatalogId" name="procurecatalogId" value="${queryMap.procurecatalogId}"/>
	                    </div>
						<div class="textalign">采购月份<spring:message code="message.yanZheng.maoHao" /></div>
						<div class="boxinput">
							<input class="textinput" id="submitMonth" name="submitMonth" type="text" value="${queryMap.submitMonth}" readonly="readonly" onFocus="WdatePicker({dateFmt:'yyyyMM',isShowToday:false})" placeholder="yyyy-mm"/>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box width-control">
        	<button id="search" type="button" class="btn btn-primary btn-sm navbar-right"><spring:message code="message.button.seachSpacing"/></button>
			<button id="clearBtn" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.clear" /></button>
			<button id="exportExcel" type="button" class="btn btn-primary btn-sm">导 出</button>
			<button id="back" type="button" class="btn btn-primary btn-sm" onclick="javascript:history.back();">返回</button>
		</div>
		<div class="btn-control-box width-control" style="margin-top:2px;">
        	说明：<span style="color:red;">查询前请先选择采购时间，点击查询。</span>
		</div>
		<div id="countDiv" class="btn-control-box width-control" style="margin-top:2px; display:none;">
			统计：采购金额为<span id="purchaseAmountSpan" style="color:red;"></span>元，到货金额为<span id="wamountOneSpan" style="color:red;"></span>元，退货金额为<span id="wamountTwoSpan" style="color:red;"></span>元
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
	//用户所属地区
	var adminAreaId = '${queryMap.adminAreaId}';
	//存入cookie
	$.cookie("adminAreaId",adminAreaId);
	if($.cookie("adminAreaId") != null && $.cookie("adminAreaId") != ""){
		$("#area2").attr("disabled","disabled");
	}else{
		$("#area3").append('<option value="">请选择</option>');
	}
	//后台传过来的地区查询条件
	var area_id = '${queryMap.adminAreaIdDrug}';
	if(area_id != null && area_id != ""){
		$("#adminAreaIdDrug").val(area_id);
		initAreaId(area_id);
	}else{
		$("#adminAreaIdDrug").val($.cookie("adminAreaId"));
		initAreaId($.cookie("adminAreaId"));
	}
	//地区级联加载初始化	
	if(queryInit()==true){
		initGrid();
		queryCount();
	}
});

var obj={
	"names":['采购月份',
			'采购数量',
			'采购金额',
	 		'到货数量',
			'到货金额',
			'到货平均完成率(%)',
			'退货数量',
			'退货金额',
			'退货平均完成率(%)',
			'操作',
			],
	"model":[
		{ name: "submitMonth", width: 150, align: 'center' ,sortable: false},
		{ name: "purchaseCount", width: 150, align: 'center' ,sortable: false},
		{ name: "purchaseAmount", width:150, align: 'center' ,sortable: false,
			formatter:function(val, opts, rowdata){
				if (val != null) {
					return val.toFixed(3);
				} else {
					return "";
				}
			}
		},
		{ name: "wcountOne", width: 150, align: 'center' ,sortable: false},
		{ name: "wamountOne", width: 150, align: 'center' ,sortable: false,
			formatter:function(val, opts, rowdata) {
				if (val != null) {
					return parseFloat(val).toFixed(3);
				} else {
					return "";
				}
			}
		},
		{ name: "cratioOne", width: 150, align: 'center' ,sortable: false,
			formatter:function(val, opts, rowdata){	
        		if(val!=null){
        			if(val==1){
        				return 100;
        			}else{
        			return (val*100).toString().substring(0,5);
        			}
        		}else{
        			return "";
        		}
		    }	
		},
		{ name: "wcountTwo", width: 150, align: 'center' ,sortable: false},
		{ name: "wamountTwo", width: 150, align: 'center' ,sortable: false,
			formatter:function(val, opts, rowdata) {
				if (val != null) {
					return parseFloat(val).toFixed(3);
				} else {
					return "";
				}
			}
		},
		{ name: "cratioTwo", width: 150, align: 'center' ,sortable: false,
			formatter:function(val, opts, rowdata){	
        		if(val!=null){
					return (val*100).toString().substring(0,5);
        		}else{
        			return "";
        		}
		    }		
		},
		{name:"operate", width: 350, align: 'center',sortable: false, align:'center',
			formatter:function(val, opts, rowdata){
				var str = "";
				str += "<a href='javascript:void(0);' onclick='toOtherList(\""+rowdata.submitMonth+"\",\"stdHospital\")' class='opIcon' title='相关医院'>相关医院</a>";
				str += "<a href='javascript:void(0);' onclick='toOtherList(\""+rowdata.submitMonth+"\",\"stdArea\")' class='opIcon' title='相关地区'>相关地区</a>";
				str += "<a href='javascript:void(0);' onclick='toOtherList(\""+rowdata.submitMonth+"\",\"stdCompanyPs\")' class='opIcon' title='相关配送企业'>相关配送企业</a>";
				str += "<a href='javascript:void(0);' onclick='toOtherList(\""+rowdata.submitMonth+"\",\"stdCompanySc\")' class='opIcon' title='相关生产企业'>相关生产企业</a>";
				return str;
			}
    	},
    	
	]
};

function initGrid(){
	var queryData = $("#searchForm").serializeJSON();
	$("#gridlist").jqGrid({
		url:"${ctx}/yimiaoOrderdetail/getHospitalMonthStatistics.html",
		mtype:"post",
		datatype:"json",
		autowidth:true,
		shrinkToFit:false,
		colNames:obj.names,
		colModel:obj.model,
		rowNum:20,
		rowList:[10,20,50,100],
		rownumbers:true,
		pager:"#gridpage",
		viewrecords:true,
		caption:"医院月采购统计分析",
		postData:queryData,
		gridComplete:function(){
			autoRNWidth("gridlist");  
		}
	});
	$(window).trigger("resize");
}

//跳转页面
function toOtherList(submitMonth,type){
	$("#submitMonth").val(submitMonth);
	if(type == 'stdCompanySc'){
		$("#searchForm").attr('action',"${ctx}/yimiaoOrderdetail/toCompanyScStatistics.html");
	}
	if(type == 'stdCompanyPs'){
		$("#searchForm").attr('action',"${ctx}/yimiaoOrderdetail/toCompanyPsStatistics.html");
	}
	if(type == 'stdHospital'){
		$("#searchForm").attr('action',"${ctx}/yimiaoOrderdetail/toHospitalStatistics.html");
	}
	if(type == 'stdArea'){
		$("#searchForm").attr('action',"${ctx}/yimiaoOrderdetail/toAdminAreaStatistics.html");
	}
	$("#searchForm").submit();
}

//ajax查询统计数据
function queryCount(){
	$("#purchaseAmountSpan").html("0");
	$("#wamountOneSpan").html("0");
	$("#wamountTwoSpan").html("0");
	var queryData = $("#searchForm").serializeJSON();
	$.ajax({
		url:"${ctx}/yimiaoOrderdetail/getYimiaoHospitalMonthCount.html",
		data:queryData,
		dataType:'json', 
		success:function(result){
	    	$("#purchaseAmountSpan").html(result.PURCHASEAMOUNT);
	    	$("#wamountOneSpan").html(result.WAMOUNTONE);
	    	$("#wamountTwoSpan").html(result.WAMOUNTTWO);
	    	$("#countDiv").css("display","block");
		},
		error:function(){
			$("#purchaseAmountSpan").html("0");
	    	$("#wamountOneSpan").html("0");
	    	$("#wamountTwoSpan").html("0");
	    	$("#countDiv").css("display","none");
		} 
	});
}

//查询按钮
$("#search").click(function(){
	if(queryInit()==false){
		$.alert("请选择选择采购时间范围！","warn");
	}else{
		initGrid();
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid('setGridParam',{  
			url:"${ctx}/yimiaoOrderdetail/getHospitalMonthStatistics.html",
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
	$("#sortColumn").val('purchaseAmount');
	$("#sortMode").val('ASC');
	$("#area1").val('530000');
	if($.cookie("adminAreaId") != null && $.cookie("adminAreaId") != ""){
		$("#area2").val($.cookie("adminAreaId"));
	}
});

//导出按钮
$("#exportExcel").click(function(){
	if(queryInit()==false){
		$.alert("请选择选择采购时间范围！","warn");
	}else{
		$("#exportExcel").css("display","none");
		var queryData = $("#searchForm").serializeJSON();
		$.StandardPost("${ctx}/yimiaoOrderdetail/exportDataHospitalMonth.html",queryData);
	}
});
</script>
</html>