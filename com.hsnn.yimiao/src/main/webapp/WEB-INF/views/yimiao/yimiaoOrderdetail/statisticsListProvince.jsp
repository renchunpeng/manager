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
		<h1>目录统计</h1>
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
	                    <div class="textalign1">疫苗名称:</div>
	                    <div class="boxinput">
	                        <input type="text" value="${productName}" class="textinput" <c:if test="${judgment>=2}"> readonly="readonly" </c:if> id="productName" name="productName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1">采购单位:</div>
	                    <div class="boxinput">
	                        <input type="text" value="${hospitalName}" class="textinput" <c:if test="${judgment>=2}"> readonly="readonly" </c:if> id="hospitalName" name="hospitalName"  placeholder="采购单位" maxlength="50" />
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
							<input type="hidden" id="areaId" name="areaId" value="${province}">
							<input type="hidden" id="areaType" name="areaType" value="2">
							<select class="textinput" id="area1"  name="area1"  style="pointer-events: none;"><option value="${province}">${provinceName}</option></select>
							<select class="textinput" id="area2" name="area2"  <c:if test="${areaIdpd>=2 or judgment>=2}"> style="pointer-events: none;"</c:if>></select>
							<select class="textinput" id="area3" name="area3"  <c:if test="${areaIdpd>=3 or judgment>=2}"> style="pointer-events: none;"</c:if>></select>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
			<button id="next" type="button" class="btn btn-primary btn-sm">下一级</button>
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
			'疫苗名称',
			'采购数量',
			'采购金额',
		 	'到货数量',
			'到货金额',
			'到货平均完成率(%)',
			'退货数量',
			'退货金额',
            '退货到货数量',
            '退货到货金额',
			'退货平均完成率(%)'
        ],
        "model": [
			{ name: "productName", width: 150, align: 'center' ,sortable: false},
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
            { name: "retArrCount", width: 150, align: 'center' ,sortable: false},
            { name: "retArrAmount", width: 150, align: 'center' ,sortable: false,
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
        ]
	};
	
	
	
	$(function(){
		$("#startTime").on('focus',function(){
			WdatePicker({maxDate:'#F{$dp.$D(endTime)}'});
		});
		$("#endTime").on('focus',function(){
			WdatePicker({minDate:'#F{$dp.$D(startTime)}'});
		});
		var area2Id = '${area2Id}';
		var area3Id = '${area3Id}';
		
		if (area3Id != "") {
			$('#areaId').val(area3Id);
			$('#areaType').val("3");
		} else if (area2Id != "") {
			$('#areaId').val(area2Id);
			$('#areaType').val("2");
		} else {
			$('#areaId').val($("#area1").val());
			$('#areaType').val("1");
		}
			
	      var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid({
	         url: "${ctx }/yimiaoOrderdetail/getStatisticsOne.html",
	         colNames: obj.names,
	         colModel: obj.model,
	         rowNum: 20,
	         postData: queryData,
	         multiselect: false,
	         shrinkToFit :false,
	         caption: "统计目录" 
	     });
	     $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			if ($("#area3").val() != "") {
				$('#areaId').val($("#area3").val());
				$('#areaType').val("3");
			} else if ($("#area2").val() != "") {
				$('#areaId').val($("#area2").val());
				$('#areaType').val("2");
			} else {
				$('#areaId').val($("#area1").val());
				$('#areaType').val("1");
			}
			var startDate = $.trim($("#startTime").val());
		     var endDate = $.trim($("#endTime").val());
				if(endDate.length > 0 && startDate.length == 0) {
					$("#startDate").trigger("focus");
		         $.alert("请选择开始月份！", "warn");
					return;
			}
				var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/yimiaoOrderdetail/getStatisticsOne.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
		
		$("#next").click(function(){
			var queryData = $("#searchForm").serialize();
			window.location='${ctx }/yimiaoOrderdetail/tostatisticsListProvinceTwo.html?'+queryData;
		});
		
		var city ='${areaIdParent}';//传入市
		 if (area2Id != null) {
			 city = area2Id;
		 }
		 var county='${areaId}';//传入地区
		 if (area3Id != null) {
			 county = area3Id;
		 }
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
	});
	  
		//导出
	    function exportExcel(){
	    	var postData = $("#searchForm").serializeJSON();
	    	gridParam(postData);
	    	$.StandardPost("${ctx}/yimiaoOrderdetail/exportDataToExcelMLTJ.html",postData);
	    	
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