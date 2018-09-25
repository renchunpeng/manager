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
		<div class=" box box-primary">
	    <div class="box-body">
	        <form id="searchForm" method="post">
	            <div class="textalign">医疗机构：</div>
	            <div class="boxinput">
	                <input type="text" class="textinput" id="hospitalName" name="hospitalName" placeholder="医疗机构" maxlength="100" />
	            </div>
	                <div class="textalign">
	                    <button type="button" class="btn btn-primary btn-sm" onclick="search();">
	                        <spring:message code='message.button.seach' />
	                    </button>
	                </div>
	    </div>
	    </form>
		</div>
		<table  class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
	<%@ include file="/WEB-INF/component/commonJS.jsp"%>
	<script type="text/javascript">
 	   	function search(page) {
			$("#gridlist").jqGrid('setGridParam',{  
		        datatype:'json',
		        postData:{hospitalName:"%"+$("#hospitalName").val()+"%"},
		        page : (page || 1)
		    }).trigger("reloadGrid"); //重新载入  
		}
 	  
  	  	 function closeMyDialog(rowdata) {
  	  	 	var dialog = top.dialog.get(window);
  	  		dialog.close(rowdata);
        	return false;
     	} 
  	  	$(function () {
  	  		$('#hospitalName').bind('keydown', function(event) {if (event.keyCode == "13") {event.preventDefault();  $('button').click();}}).focus();
	    	$("#gridlist").jqGrid({
	            url: "${ctx}/payOrder/getReturnHospByCompanyId.html",
	            mtype: "post",
	            autowidth: true,
	            shrinkToFit:true,
	            colNames: [
					'','医疗机构','未支付收货明细数','未结算金额(元)'
	            ],
	            colModel: [
					{ name: 'hospitalId', width: 10, align:"center",hidden:true, sortable: false},
					{ name: 'hospitalName', width: 10, align:"center", sortable: false},
	                { name: 'num', width: 10, align:"center", sortable: false},
	                { name: 'setMoney', width: 10, align:"center", sortable: false}
	            ],
	            rownumbers: true,
	            pager: "#gridpage",
	            viewrecords: true,
	            caption: "",
	            gridComplete:function(){
	                autoRNWidth("gridlist");
	            },
	            jsonReader: {
	                id: "ids"
	            },
	             onSelectRow: function (rowId) {
	            	 var rowdata = $("#gridlist").jqGrid('getRowData', rowId);
	            	 closeMyDialog(rowdata);
	            }, 
	        });
	        $("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
	        $(window).trigger("resize");
		}); 
</script>
</body>
</html>