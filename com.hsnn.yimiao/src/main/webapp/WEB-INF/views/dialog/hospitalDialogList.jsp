<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<style type="text/css">
div.textalign1{ width:110px;}
</style>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-success">
	    	<div class="box-body">
		        <form id="searchForm" method="post">
		            <div class="input">
	                    <div class="textalign"><spring:message code="message.stdHospital.stdHospitalForm.adminAreaIdDrug"></spring:message><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
		                    <table style="width:100%;">
		                       <tr>
		                          <td style="width:33%">
		                            <select class="textinput noClear" id="adminAreaIdDrug1" name="adminAreaIdDrug1">
		                        		<option value="${province}">${provinceName}</option>
		                    		</select>
		                          </td>
		                          <td style="width:33%">   
		                            <select class="textinput" id="adminAreaIdDrug2" name="adminAreaIdDrug2"></select>
		                            </td>
		                          <td style="width:33%">
		                            <select class="textinput" id="adminAreaIdDrug3" name="adminAreaIdDrug3"></select>
		                          </td>
		                       </tr> 
		                    </table>
						</div>	                    
	                    
	                    <div class="textalign1"><spring:message code="drugpurCompanyListingRelation.hospitalName"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="hospitalName" name="hospitalName"  placeholder="<spring:message code="drugpurCompanyListingRelation.hospitalName"/>" maxlength="50" />
	                    </div>
	                    
					</div>
			    </form>
	    	</div>
		</div>
		<div class="btn-control-box">
       		<button type="button" id="addRelation" class="btn btn-success btn-sm"><spring:message code="message.button.confirmAndSubmit"/></button>
			<button id="search" type="button" class="btn btn-primary btn-sm" onclick="searchHospital();"><spring:message code="message.button.seachSpacing"/></button>
			<button id="clear" type="button" class="btn btn-primary btn-sm">
								<spring:message code="message.button.clear" />
							</button>
		</div>
		<table  class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
		
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var verityPass = <spring:eval expression="T(com.hsnn.medstgmini.base.std.enums.StdHospitalInitializationState).getKeyByItemName('VERITY_PASS')"></spring:eval>;// 审核通过
	var yes = <spring:eval expression="T(com.hsnn.medstgmini.base.sys.enums.YesOrNo).getKeyByItemName('YES')"></spring:eval>;
	var listType = '${optType}'
		
	$(function () {
    	$("#gridlist").jqGrid({
    		url: "${ctx}/dialog/getInfo.html",
    		colNames: [
  					'hospitalId', '<spring:message code="drugpurBargain.hospitalName"/>', '<spring:message code="message.stdHospital.stdHospitalForm.adminAreaIdDrug"/>'
  	            ],
  	         	colModel: [
				{ name: 'hospitalId', width: 10, align:"center",hidden:true, sortable: false},
                { name: 'hospitalName', width: 10, align:"center", sortable: false},
                { name: 'adminAreaNameDrug', width: 10, align:"center", sortable: false}
            ],
            multiselect: true,
            caption: "<spring:message code='message.lable.yiLiaoJiGouLieBiao'/>",
            postData: {"initializationState": verityPass, "isUsing": yes, "beanName":"stdHospitalManager", "listType": listType},// 审核通过、有效
            gridComplete:function(){
                autoRNWidth("gridlist");
                $(".ui-jqgrid-bdiv table,.ui-jqgrid-htable").css("width",$(".ui-jqgrid-bdiv table").width()-1);
            },
            jsonReader: {
                id: "hospitalId"
            }
        });
    	$(window).trigger("resize");
    	
    	$("#addRelation").click(function() {
    		var hospitalIds = $("#gridlist").jqGrid("getGridParam", "selarrrow");
    		if(hospitalIds.length > 0) {
    			var hospitalInfos = new Array();
    			$.each(hospitalIds, function(i, v){
    				var rowdata = $("#gridlist").jqGrid("getRowData", v);
    				var obj = new companyListingRelation(v, rowdata.hospitalName);
    				hospitalInfos.push(obj);
    			});
    			$.HN.message.confirm('<spring:message code="message.HN.alert.queDingTiJiaoMa"/>', '', '').on(function (e) {
					if (e) {
						$.post("${ctx}/drugpurCompanyListingRelation/addDrugpurCompanyListingRelationBatch.html", {"hospitalInfos":serialize(hospitalInfos), "listType": listType}, function(result) {
	                       if (result.success) {
	                    	   closeMyDialog(result.success);
	                    	   $.alert('<spring:message code="message.jieSuan.tiJiaoChengGong"/>', '<spring:message code="message.HN.alert.type"/>', "success");
	                       } else {
	                    	   $.alert(result.msg || "<spring:message code="message.jieSuan.tiJiaoShiBai"/>", "error");
	                       }
	                   	}, "json");
		            }
		        });
    		} else {
				$.alert('<spring:message code="message.HN.alert.pleaseSelectLine"/>');
			}
		});
	}); 
	
	function companyListingRelation(hospitalId, hospitalName) {
		var obj = new Object();
		obj.hospitalId = hospitalId;
		obj.hospitalName = hospitalName;
		return obj;
	}
	
	function searchHospital() {
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid("setGridParam", {
			url: "${ctx}/dialog/getInfo.html",
			postData: queryData,//发送查询条件 
		}).trigger("reloadGrid");//重新载入
	}
  	  	
	function closeMyDialog(rowdata) {
		var dialog = top.dialog.get(window);
		dialog.close(rowdata);
		$("#searchForm")[0].reset();
		searchHospital();
	    return false;
	} 
	
	$("#adminAreaIdDrug2").HNSelect({
		url: "${ctx}/selectController/getArea.html", data: { ID: '${province}' }, defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
        func: function () {
			$("#adminAreaIdDrug3").HNSelect({
				parent_selector: "#adminAreaIdDrug2", url: "${ctx}/selectController/getArea.html", dataid: "ID", defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
			});
		}
	});
</script>
</html>