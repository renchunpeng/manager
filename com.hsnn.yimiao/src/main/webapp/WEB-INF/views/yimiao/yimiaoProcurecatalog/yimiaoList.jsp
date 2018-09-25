<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
    <section class="content-header">
        <h1>疫苗列表</h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.html"><i class="fa fa-home"></i>首页</a></li>
			<li class="active"><a href="#">疫苗列表</a></li>
        </ol>
    </section>
	<section class="content">
		<div class=" box box-primary">
	    	<div class="box-body">
		        <form id="searchForm" method="post" action="${ctx}/yimiaoProcurecatalog/exportDataToExcel.html">
		            <div class="input">
		            	<div class="textalign1"><spring:message code="疫苗编号"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsId" name="goodsId"  placeholder="疫苗编号" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="疫苗通用名"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="productName" name="productName"  placeholder="疫苗名称" maxlength="50" />
	                    </div>
	                    <div class="textalign1"><spring:message code="制剂规格"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="规格" maxlength="50" />
	                    </div>
                    	<input style="display:none;"/><!-- 防止回车表单自动提交 -->
					</div>
					<div class="input">
						<div class="textalign1"><spring:message code="生产企业"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="生产企业" maxlength="100" />
	                    </div>
                        <div class="textalign1"><spring:message code="投标企业"/><spring:message code="message.yanZheng.maoHao"/></div>
                        <div class="boxinput">
                            <input type="text" class="textinput"  id="companyNameTb" name="companyNameTb"  placeholder="投标企业" maxlength="100" />
                        </div>
	                    <%--<div class="textalign1">疫苗状态：</div>--%>
                    	<%--<div class="boxinput">                         --%>
                         <%--<select class="textinput" id="isUsing" name="isUsing" style="width:40%" >--%>
				            	<%--<option value=''>请选择</option>		--%>
				            	<%--<option value='1'>启用</option>	--%>
				            	<%--<option value='0'>停用</option>                     	 --%>
				            <%--</select>--%>
                    	<%--</div>--%>
					</div>
			    </form>
	    	</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
		 	<button type="button" onclick="exportExcel();" class="btn btn-success btn-sm">导 出</button>
		</div>
		
		<table  class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var obj ={
		"names": [
		    '采购目录编号',
		    '产品编号',
			'疫苗通用名',
			'产品名称',
			'制剂规格（申报剂型）',
			'批准文号',
			'生产企业（投标企业）',
		    '最小制剂单位中标价格（元）',
			'最小制剂单位',
			'年份',
			'疫苗状态'
        ],
        "model": [
            { name: "productId", width: 100, align: 'center' ,sortable: false},
			{ name: "goodsId", key:true, width: 100, align: 'center' ,sortable: false},
            { name: "productName", width: 150, align: 'center' ,sortable: false},
            { name: "goodsName", width: 150, align: 'center' ,sortable: false},
	        { name: "outlook", width: 150, align: 'center' ,sortable: false,
                formatter : function(val, opts, rowdata){
                        return rowdata.outlook+"（"+rowdata.medicinemodel+"）";
                }
			},
            { name: "sortId", width: 150, align: 'center' ,sortable: false},
	        { name: "companyNameSc", width: 150, align: 'center' ,sortable: false,
                formatter : function(val, opts, rowdata){
                    return rowdata.companyNameSc+"（"+rowdata.companyNameTb+"）";
                }
			},
			{ name: "bidPrice", width: 60, align: 'center' ,sortable: false,
            	formatter : function(val, opts, rowdata){
					//return formatAmount(val, opts, rowdata);
					if (val!=null) {
						return val.toFixed(3);
					} else {
						return "暂无";
					}
				}	
			},
	        { name: "unit", width: 50, align: 'center' ,sortable: false},
	        { name: "yimiaoYear", width: 50, align: 'center' ,sortable: false,hidden:true},
	        { name: "isUsing", width: 50, align: 'center' ,sortable: false,hidden:true,
	        	formatter : function(val, opts, rowdata){
					if (parseInt(val) == 0) {
						return "停用";
					} else if (parseInt(val) == 1) {
						return "启用";
					} else {
						return "";
					}
				}
	        }
        ]      
	};
	$(function () {
    	$("#gridlist").jqGrid({
    		url: "${ctx}/yimiaoProcurecatalog/getYimiaoData.html",
    		colNames: obj.names,
	        colModel: obj.model,
            multiselect: false,
            caption: "疫苗列表",
            rowNum: 20,
        });
    	$(window).trigger("resize");
    	// 查询
    	$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx}/yimiaoProcurecatalog/getYimiaoData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	}); 
	
	//导出
    function exportExcel(){
    	var postData = $("#searchForm").serializeJSON();
    	gridParam(postData);
    	$.StandardPost("${ctx}/yimiaoProcurecatalog/exportDataToExcel.html",postData);
    	
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