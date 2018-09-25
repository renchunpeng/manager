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
		<div class=" box box-success">
	    	<div class="box-body">
		        <form id="searchForm" method="post">
		            <div class="input">
						
						<div class="textalign1"><spring:message code="配送企业"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="companyName" name="companyName"  placeholder="<spring:message code="配送企业名称"/>" maxlength="50" />
	                    </div>                  
	                    
						<div class="textalign">
							<button id="search" type="button" class="btn btn-primary btn-sm"><spring:message code="message.button.seachSpacing"/></button>
						</div>
					</div>
			    </form>
	    	</div>
		</div>
		<table  class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
		
		<div class=" box box-warning bottongroup">
       		<button type="button" id="addRelation" class="btn btn-success btn-sm"><spring:message code="设置"/></button>
        </div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">

$(function () {
	var companyTypes = ${companyTypes};
	
	$("#gridlist").jqGrid({
		url: "${ctx}/dialog/getInfo.html",
		colNames: [
					'companyId', '企业名称'
	            ],
	         	colModel: [
			{ name: 'companyId', width: 10, align:"center",hidden:true, sortable: false},
            { name: 'companyName', width: 10, align:"center", sortable: false}
        ],
        multiselect: true,
        caption: "<spring:message code='配送企业列表'/>",
        postData: {"isUsing": 1,
        	       "initializationState":4,
        	       "beanName":"stdCompanyManager",
        	       "companyTypes[]":companyTypes,
        	       "queryOther":1,
        	       "hospitalId":'${hospitalId}',
        	       "hospitalDepartmentId":${hospitalDepartmentId}
        	       },// 审核通过、有效
        gridComplete:function(){
            autoRNWidth("gridlist");
        },
        jsonReader: {
            id: "companyId"
        }
    });
	$(window).trigger("resize");
	
	$("#search").click(function(){
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid("setGridParam", {
			url: "${ctx}/dialog/getInfo.html",
			postData: queryData,//发送查询条件 
		}).trigger("reloadGrid");//重新载入
	});
	
	$("#addRelation").click(function() {
		var companyIds = $("#gridlist").jqGrid("getGridParam", "selarrrow");
		if(companyIds.length > 0) {
			$.HN.message.confirm('<spring:message code="message.HN.alert.queDingTiJiaoMa"/>', '', '').on(function (e) {
				if (e) {
					$.post("${ctx}/drugpurFilingApply/addDrugpurFilingApplyCommonCompany.html", {"companyIds":companyIds.join(","),}, function(result) {
                       if (result.success) {
                    	   closeMyDialog(result.success);
                    	   $.alert('<spring:message code="设置配送企业成功!"/>', '<spring:message code="message.HN.alert.type"/>', "success");
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

function closeMyDialog(rowdata) {
	var dialog = top.dialog.get(window);
	dialog.close(rowdata);
    return false;
} 

</script>
</html>