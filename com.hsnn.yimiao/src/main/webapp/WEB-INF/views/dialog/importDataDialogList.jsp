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
		<table  class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
		
		<div class="null-line"></div>
		<div class="modal-footer">
            <button type="button" id="import" onclick="importConfirm();" class="btn btn-success btn-sm">
            	<spring:message code='message.HN.alert.import.confirm'/>
            </button>
            <c:if test="${errorSize > 0 }">
	            <button type="button" onclick="exportErrorData();" class="btn btn-danger btn-sm">
	            	<spring:message code='message.HN.alert.import.error.data.before'/>${errorSize }<spring:message code='message.HN.alert.import.error.data.after'/>
	            </button>
            </c:if>
            <button type="button" onclick="closeMyDialog();" class="btn btn-danger btn-sm">
            	<spring:message code='message.button.cancel'/>
            </button>
        </div>
		
		<form action="${ctx}${actionPath }/exportData.html" id="exportErrorForm" method="post">
			<input type="hidden" name="errorData" value="errorData"/>
		</form>
		
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var colNames = ${colNames};
	var colModels = ${colModel};
	var rightData = <spring:eval expression="T(com.hsnn.medstgmini.util.enums.DataState).getKeyByItemName('IS_RIGHT')"></spring:eval>;
	$(function () {
		var colModel = new Array();
		$.each(colModels, function(i, v){
			colModel.push({name: v, align:"center", sortable: false});
		});
		var url = "${ctx}${actionPath}/getImportInfo.html";
    	$("#gridlist").jqGrid({
			url: url,
    		colNames: colNames,
			colModel: colModel,
            multiselect: false,
            caption: "<spring:message code='message.HN.alert.import.right.data.list'/>",
            postData:{"tmpImportDataState":rightData},
            gridComplete:function(){
                autoRNWidth("gridlist");
                $(".ui-jqgrid-bdiv table,.ui-jqgrid-htable").css("width",$(".ui-jqgrid-bdiv table").width()-1);
                var rowNum = $(this).jqGrid('getGridParam','records');
                if(rowNum == 0) {
                	$("#import").hide();
                }
            }
        });
    	$(window).trigger("resize");
	}); 
	function importConfirm() {
		$.HN.message.confirm('<spring:message code="message.HN.alert.import.tmp2business.confirm.ask"/>', '', '').on(function (e) {
			if (e) {
				$.post("${ctx}${actionPath}/confirmImportData.html", {"expandInfos": '${expandInfos}'}, function(result) {
					if (result) {
						$.alert('<spring:message code="message.HN.alert.import.success"/>', "success", function(){
							closeMyDialog(result);
						}, 1000);
                    } else {
                   		$.alert(result.msg || "<spring:message code='message.HN.alert.import.fail'/>", "error");
					}
				}, "json");
            }
        });
	}
	
	// 导出错误数据
	function exportErrorData() {
		$("#exportErrorForm").submit();
	}
	// 取消
	function closeMyDialog(rowdata) {
		var dialog = top.dialog.get(window);
		dialog.close(rowdata);
	    return false;
	} 
</script>
</html>