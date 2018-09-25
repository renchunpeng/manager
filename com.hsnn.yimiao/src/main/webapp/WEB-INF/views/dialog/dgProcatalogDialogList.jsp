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
		        <form id="searchForm" method="post">
					<div class="input">
						<div class="textalign1"><spring:message code="drugpurProcurecatalog.productName"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="productName" name="productName"  placeholder="<spring:message code="drugpurProcurecatalog.productName"/>" maxlength="170" />
	                    </div>
						<div class="textalign"><spring:message code="drugpurProcurecatalog.medicinemodel"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="medicinemodel" name="medicinemodel"  placeholder="<spring:message code="drugpurProcurecatalog.medicinemodel"/>" maxlength="85" />
	                    </div>
	                    <div class="textalign"><spring:message code="drugpurProcurecatalog.outlook"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="outlook" name="outlook"  placeholder="<spring:message code="drugpurProcurecatalog.outlook"/>" maxlength="85" />
	                    </div>
					</div>
					<div class="input">
						<div class="textalign1"><spring:message code="drugpurProcurecatalog.factor"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="factor" name="factor"  placeholder="<spring:message code="drugpurProcurecatalog.factor"/>" maxlength="4" />
	                    </div>
						<div class="textalign"><spring:message code="drugpurProcurecatalog.unit"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="unit" name="unit"  placeholder="<spring:message code="drugpurProcurecatalog.unit"/>" maxlength="12" />
	                    </div>
	                    <div class="textalign"><spring:message code="drugpurProcurecatalog.materialName"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="materialName" name="materialName"  placeholder="<spring:message code="drugpurProcurecatalog.materialName"/>" maxlength="12" />
	                    </div>
					</div>
					<div class="input">
						<div class="textalign1"><spring:message code="drugpurProcurecatalog.companyNameSc"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameSc" name="companyNameSc"  placeholder="<spring:message code="drugpurProcurecatalog.companyNameSc"/>" maxlength="170" />
	                    </div>
						<div class="textalign"><spring:message code="drugpurProcurecatalog.companyNameTb"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyNameTb" name="companyNameTb"  placeholder="<spring:message code="drugpurProcurecatalog.companyNameTb"/>" maxlength="170" />
	                    </div>
	                    <div class="textalign"><spring:message code="drugpurProcurecatalog.source"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
						      <select class="textinput" id="sourceId" name="sourceId"  style="width:228px;">
						             <option value="" >----------------全部----------------</option>
						             <c:forEach items="${enum:getEnumValues('com.hsnn.medstgmini.drug.enums.SourceName')}" var="items" >
								        <option value="${items.key }">${items.value}</option>
									</c:forEach>
						      </select>
						</div>
					</div>
					<div class="input">
						<div class="textalign1"><spring:message code="message.lable.status"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="auditStatus" name="auditStatus"  placeholder="<spring:message code="message.lable.status"/>" maxlength="170" />
	                    </div>
						<div class="textalign"><spring:message code="drugpurGoods.goodsId"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="goodsId" name="goodsId"  placeholder="<spring:message code="drugpurGoods.goodsId"/>" maxlength="170" />
	                    </div>
					</div>
			    </form>
	    	</div>
		</div>
		<div class="btn-control-box width-control">
			<button id="search" type="button" class="btn btn-primary btn-sm navbar-right"><spring:message code="message.button.seachSpacing"/></button>
		</div>
		<table  class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
		<!-- 页面备注信息 -->
	<div class="well well-sm text-info width-control" style="margin-bottom: 0px;">
		<h4>本页面备注：</h4>
	    <div>1. 议价类显示已挂牌信息；备案药品显示已申请备案信息；中标类显示已中标药品信息；</div>
	</div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script src="${ctx}/lib/js/moreAndMore.js" type="text/javascript"></script>
<script type="text/javascript">
	var purchaseTypes= ${enum:getEnumKeyJSON('com.hsnn.medstgmini.drug.enums.PurchaseType')};//采购类别
	var bid=purchaseTypes['BID_DRUG'];//中标0
	var cheap=purchaseTypes['CHEAP_DRUG'];//廉价1
	var tense=purchaseTypes['TENSE_DRUG'];//紧张2
	var low=purchaseTypes['LOW_DRUG'];//低价 3
	var record=purchaseTypes['RECORD_DRUG'];//备案4
	
	/* 
		 议价类药品
		挂牌地区，挂牌价格，挂牌企业，挂牌状态
		数据来源（企业挂牌表yppur_company_listing）
	 */
	$(function () {
    	$("#gridlist").jqGrid({
    		url: "${ctx}/drugpurProcurecatalog/getDgProcatalogInfo.html",
    		colNames: [
					'<spring:message code="drugpurProcurecatalog.goodsId"/>',
					'<spring:message code="drugpurProcurecatalog.procurecatalogId"/>',
  					'<spring:message code="drugpurProcurecatalog.goodsInfo"/>',
  					'<spring:message code="drugpurProcurecatalog.companyNameSc"/>',
  					'<spring:message code="drugpurProcurecatalog.companyNameTb"/>',
  					'<spring:message code="drugpurProcurecatalog.qualityLevel"/>',
  					'<spring:message code="drugpurProcurecatalog.middleWithMaxPack"/>',
  					'<spring:message code="drugpurProcurecatalog.usingRang"/>'
  					<c:if test="${dgProcatalogForm.purchaseType == 0}">
					 ,'<spring:message code="drugpurProcurecatalog.bidPrice"/>'
					 ,'<spring:message code="drugpurProcurecatalog.auditStatus"/>'
					</c:if>
					<c:if test="${dgProcatalogForm.purchaseType == 1 or dgProcatalogForm.purchaseType ==2 or dgProcatalogForm.purchaseType ==3}">
					 ,'<spring:message code="drugpurProcurecatalog.drugpurCompanyListing.listAreaName"/>'
					 ,'<spring:message code="drugpurProcurecatalog.drugpurCompanyListing.listPrice"/>'
					 ,'<spring:message code="drugpurProcurecatalog.drugpurCompanyListing.companyNamePs"/>'
					 ,'<spring:message code="drugpurProcurecatalog.drugpurCompanyListing.listStatus"/>'
					</c:if>
					<c:if test="${dgProcatalogForm.purchaseType == 4}">
					 ,'<spring:message code="drugpurProcurecatalog.drugpurFilingApply.companyNamePs"/>'
					 ,'<spring:message code="drugpurProcurecatalog.drugpurFilingApply.applyPrice"/>'
					 ,'<spring:message code="drugpurProcurecatalog.drugpurFilingApply.hospitalName"/>'
					 ,'<spring:message code="drugpurProcurecatalog.auditStatus"/>'
					</c:if>
  	            ],
  	         	colModel: [
				  {name: "goodsId",align: 'center', width:80,sortable: false},
				  {name: "procurecatalogId", key:true,hidden:true, sortable: false,width:80},    
				  {name: "goodsInfo", align: 'left',width:184,sortable: false,formatter:function(val, opts, rowdata){return "【"+rowdata.goodsName+"】"+"&nbsp;"+rowdata.productName+"<br/>"+rowdata.medicinemodel+"&nbsp;"+rowdata.outlook+"&nbsp;"+rowdata.factor+"&nbsp;"+rowdata.unit+"&nbsp;"+rowdata.materialName;}},
				  { name: "companyNameSc", width:180, align: 'center' ,sortable: false,formatter:function(val, opts, rowdata){
			   			var companyNameSce=rowdata.companyNameSc;
			   			if(rowdata.splitCompanyName == null || ""==rowdata.splitCompanyName){
			   				return companyNameSce;
			   			}
			   			if(rowdata.splitCompanyName!=null || ""!=rowdata.splitCompanyName){
			   				companyNameSce += "(<"+rowdata.splitCompanyName+">分包装)";
			   				return companyNameSce;
			   			}
			   		}},
			      {name: "companyNameTb", align: 'center' , width:180, sortable: false},
			      {name: "qualityLevel", align: 'center', width:90, sortable: false,},
			      {name: "middleWithMaxPack",align: 'center', width:100, sortable: false,formatter:function(val, opts, rowdata){
			    	  var middlePack=Number(0)==Number(rowdata.middlePack)?"无":rowdata.middlePack;
		        	   var maxPack=Number(0)==Number(rowdata.maxPack)?"无":rowdata.maxPack;
			           var middleWithMaxPack=middlePack+"/"+maxPack;
	        		   return middleWithMaxPack;
			        }},
			      {name: "usingRang", sortable: false,align: 'center',width:100,formatter:function(val, opts, rowdata){ return val==null?"":${enum:getEnumJSON('com.hsnn.medstgmini.drug.enums.UsingRang')}[val]; }}
		        <c:if test="${dgProcatalogForm.purchaseType == 0}">
		         ,{name:"bidPrice", align: 'center', sortable: false,width:60}
    	   		 ,{name: "auditStatus", sortable: false,align: 'center',widht:60,formatter:function(val, opts, rowdata){return val==null?"":${enum:getEnumJSON('com.hsnn.medstgmini.drug.enums.AuditStatus')}[val]; }}
		        </c:if>
				<c:if test="${dgProcatalogForm.purchaseType == 1 or dgProcatalogForm.purchaseType ==2 or dgProcatalogForm.purchaseType ==3}">
		          ,{name: "listAreaName",align: 'center',widht:60, sortable: false}
 		     	  ,{name: "listPrice", align: 'center', widht:60, sortable: false}
 		     	  ,{name: "companyNamePs", align: 'center', widht:60,sortable: false}
 		     	  ,{name: "listStatus",widht:80, sortable: false,align: 'center',formatter:function(val, opts, rowdata){return val==null?"":${enum:getEnumJSON('com.hsnn.medstgmini.drug.enums.ListStatus')}[val]; }}
				</c:if>
				<c:if test="${dgProcatalogForm.purchaseType == 4}">
				 ,{name: "companyNamePs", align: 'center',widht:60, sortable: false}
				 ,{name: "applyPrice", align: 'center',widht:50, sortable: false}
				 ,{name: "hospitalName", align: 'center', widht:100, sortable: false}
				 ,{name: "auditStatus", align: 'center', sortable: false,widht:60,formatter:function(val, opts, rowdata){return val==null?"":${enum:getEnumJSON('com.hsnn.medstgmini.drug.enums.AuditStatus')}[val]; }}
				</c:if>
            ],
            multiselect: false,
            shrinkToFit:false,
            caption: "<spring:message code="drugpurProcurecatalog.goodsInfo"/>",
            postData: {"procurecatalogId":${dgProcatalogForm.procurecatalogId},"purchaseType":${dgProcatalogForm.purchaseType}},//商品id and 采购类别
            gridComplete:function(){
                autoRNWidth("gridlist");
            },
            jsonReader: {
                id: "hospitalId"
            }
        });
    	$(window).trigger("resize");
    	
    	$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx}/drugpurProcurecatalog/getDgProcatalogInfo.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
    	
	}); 
  	  	
	function closeMyDialog(rowdata) {
		var dialog = top.dialog.get(window);
		dialog.close(rowdata);
	    return false;
	} 
</script>
</html>