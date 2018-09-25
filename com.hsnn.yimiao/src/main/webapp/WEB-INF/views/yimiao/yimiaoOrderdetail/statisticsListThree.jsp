<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	
	<section class="content-header">
		<h1>采购记录</h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#">采购记录</a></li>
			
		
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/yimiaoOrderdetail/getYimiaoOrderdetailData.html" id="searchForm" method="post" >
					<div class="input">
						<div class="textalign1">疫苗编号:</div>
	                    <div class="boxinput">
	                        <input type="text" value="${goodsId}" class="textinput"  id="goodsId" name="goodsId"  placeholder="疫苗编号" maxlength="50" />
	                    </div>
	                    <div class="textalign">疫苗名称:</div>
	                    <div class="boxinput">
	                        <input type="text" value="${productName}" class="textinput"  readonly="readonly"    id="productName" name="productName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1">规格:</div>
	                    <div class="boxinput">
	                        <input type="text" value="${outlook}" class="textinput"  readonly="readonly"    id="outlook" name="outlook"  placeholder="规格" maxlength="50" />
	                    </div>
					</div>
					
					<div class="input">
						<div class="textalign">采购单位:</div>
	                    <div class="boxinput">
	                        <input type="text" value="${hospitalName}" class="textinput"  readonly="readonly"  id="hospitalName" name="hospitalName"  placeholder="采购单位" maxlength="50" />
	                    </div>
						<div class="textalign">生产企业:</div>
	                    <div class="boxinput">
	                        <input type="text" value="${companyNameSc}" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="生产企业" maxlength="50" />
	                    </div>
						<div class="textalign1">订单时间:</div>
	                    <div class="boxinput">
                         <table style="width: 100%">
								<tr>
									<td style="width: 50%"><input class="textinput"
										id="startTime" name="startTime" type="text"
										readonly="readonly" placeholder="开始时间" value="${startTime}"
										 />
									</td>
									<td>&nbsp;-&nbsp;</td>
									<td style="width: 50%"><input class="textinput"
										id="endTime" name="endTime" type="text" readonly="readonly"
										placeholder="结束时间" value="${endTime}"
										/>
									</td>
								</tr>
							</table>
	                        
	                    </div>
	                    
					</div>
					 <div class="input">
					<div class="textalign1"><spring:message code="message.stdHospital.stdHospitalForm.areaId"></spring:message>:</div>
					<div class="boxinput"  style=" width: auto;">
						<select class="textinput" id="area1"  name="area1"  style="pointer-events: none;"><option value="${province}">${provinceName}</option></select>
						<select class="textinput" id="area2" name="area2"  style="pointer-events: none;"></select>
						<select class="textinput" id="area3" name="area3"   style="pointer-events: none;"></select>
					</div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
			<button type="button" onclick="exportExcel();" class="btn btn-success btn-sm">导 出</button>
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
			'疫苗名称',
			'采购数量',
			'采购金额',
		 	'到货数量',
			'到货金额',
			'到货平均完成率(%)',
			'退货数量',
			'退货金额',
			'退货平均完成率(%)',
			'州市',
			'采购单位',
			'订单时间',
			'退货单时间',
			'规格',
			'疫苗编号',
			'生产企业',
			'最小制剂单位'
        ],
        "model": [
			{ name: 'operate', width: 120,key:true,align: 'center',sortable: false,
				formatter:function(val, opts, rowdata){
						var str =  "<a href='${ctx }/yimiaoOrderdetail/tostatisticsListTwo.html?' >上一级</a>";
			    	return str;
				    }
			},
			{ name: "productName", width: 150, align: 'center' ,sortable: false},
			{ name: "purchaseCount", width: 150, align: 'center' ,sortable: false},
			{ name: "purchaseAmount", width:150, align: 'center' ,sortable: false},
			{ name: "wcountOne", width: 150, align: 'center' ,sortable: false},
			{ name: "wamountOne", width: 150, align: 'center' ,sortable: false},
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
			{ name: "wamountTwo", width: 150, align: 'center' ,sortable: false},
			{ name: "cratioTwo", width: 150, align: 'center' ,sortable: false,
				formatter:function(val, opts, rowdata){	
	        		if(val!=null){
						return (val*100).toString().substring(0,5);
	        		}else{
	        			return "";
	        		}
			    }		
			},
			{ name: "tjareaName", width: 150, align: 'center' ,sortable: false},
			{ name: "cghospitalName", width: 150, align: 'center' ,sortable: false},
			{ name: "cgsubmitTime", width: 150,hidden:true, align: 'center' ,sortable: false},
			{ name: "thsubmitTime", width: 150,hidden:true, align: 'center' ,sortable: false},
			{ name: "outlook", width: 150, align: 'center' ,sortable: false},
			{ name: "goodsId", width: 150, align: 'center' ,sortable: false},
			{ name: "companyNameSc", width: 150, align: 'center' ,sortable: false},
			{ name: "unit", width: 150, align: 'center' ,sortable: false},
        ]
	};
	
	
	
	$(function(){
		$("#startTime").on('focus',function(){
			WdatePicker({maxDate:'#F{$dp.$D(endTime)}'});
		});
		$("#endTime").on('focus',function(){
			WdatePicker({minDate:'#F{$dp.$D(startTime)}'});
		});
		
		//解绑时间点击事件
			$("#startTime").off();
			$("#endTime").off();
		
		
		 var areaId = $("#area3").val();
         if("" == areaId){
             areaId = $("#area2").val();
				if("" == areaId){
					areaId = $("#area1").val();
				}
         } 
         $('#areaId').val(areaId);
		
		
		
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoOrderdetail/getStatisticsThree.html",
            colNames: obj.names,
            colModel: obj.model,
            rowNum: 20,
            multiselect: false,
            shrinkToFit :false,
            caption: "统计目录" 
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var areaId = $("#area3").val();
            if("" == areaId){
                areaId = $("#area2").val();
				if("" == areaId){
					areaId = $("#area1").val();
				}
            } 
            $('#areaId').val(areaId);
			var startDate = $.trim($("#startTime").val());
		     var endDate = $.trim($("#endTime").val());
				if(endDate.length > 0 && startDate.length == 0) {
					$("#startDate").trigger("focus");
		         $.alert("请选择开始月份！", "warn");
					return;
			}
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoOrderdetail/getStatisticsThree.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
	
	 var city ='${areaIdParent}';//传入市
	 var county='${areaId}';//传入地区
	  $("#area1").HNSelect({
          url: "${pageContext.request.contextPath}/selectController/getArea.html", 
          data: { ID: '000000' }, 
          defaultselect: '${province}',
          defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
          func: function () {
              $("#area2").HNSelect({
                  parent_selector: "#area1", 
                  url: "${pageContext.request.contextPath}/selectController/getArea.html", 
                  dataid: "ID", 
                  defaultselect: city,
                  defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
                  func: function () {
                      $("#area3").HNSelect({
                          parent_selector: "#area2", 
                          url: "${pageContext.request.contextPath}/selectController/getArea.html", 
                          dataid: "ID", 
                          defaultselect: county,
                          defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
                          func:function(){
                              
                          }
                      });
                  }
              });
          }
});
	//导出
	    function exportExcel(){
	    	var postData = $("#searchForm").serializeJSON();
	    	$.StandardPost("${ctx}/yimiaoOrderdetail/exportDataToExcelMLTJThree.html",postData);
	    	
		}
	/* function area(){
		 $("#area2").HNSelect({
             url: "${pageContext.request.contextPath}/selectController/getArea.html",
             data: { ID: '${province}' },
             defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
             func: function () {
                 $("#area3").HNSelect({
                     parent_selector: "#area2",
                     url: "${pageContext.request.contextPath}/selectController/getArea.html",
                     dataid: "ID", 
                     defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
                 });
             }
         });
    }  */
</script>
</html>