<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title><spring:message code="message.stdCompany.title"/></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-primary">
		     <div class="box-body">
				<div class="textalign">配送企业名称：</div>
				<div class="boxinput">
			                <input type="text" class="textinput" id="delCompName" name="delCompName" placeholder="配送企业名称" maxlength="100" />
			     </div>
			     <div class="textalign">配送企业状态：</div>
				 <div class="boxinput">
			          <select id="delCompStatus" name="delCompStatus">
			          	<option value="">请选择</option>
			          	<option value="0">停用</option>
			          	<option value="1">启用</option>
			          </select>
			     </div>
			</div>
		</div>
		<div class="btn-control-box">
				<button  type="button" id="search" class="btn btn-primary btn-sm" >查询</button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
     /* 归档号	企业名称 企业类型 	录入人	资质状态	复核人	审核人	初始化状态 */

	var obj ={
		"names": [
			'',
		    '操作',
			'配送企业名称',
			'配送企业状态',
        ],
        "model": [
				{ name: "delCompCode", width: 200, align: 'center' ,sortable: false, hidden: true},
		        { name: "oper", key:true, width: 50, align: 'center' ,sortable: false,
		        	formatter:function(val, opts, rowdata){	
	                	var delCompCode=rowdata.delCompCode;
	                	var delCompName=rowdata.delCompName;
	                	return "<a href=\"javascript:void(0);\" onclick=\"selectId('"+opts.rowId+"')\" >选择</a>";
	                }
		        },
		        { name: "delCompName", width: 200, align: 'center' ,sortable: false},
		        { name: "delCompStatus", width: 100, align: 'center' ,sortable: false,
		        	formatter:function(val, opts, rowdata){	
	                	return {0:"停用",1:"启用"}[val];
	                }	
		        },		
        ]      
	};
	
	$(function(){
		
		$("#gridlist").jqGrid({
            url:"${ctx }/yimiaoOrderdetail/getYimiaoPSData.html" ,
            contentType : 'application/json',
            datatype: "json",
            autowidth: true,
            height: 270,
            colNames: obj.names,
            colModel: obj.model,
            rowNum: 20,
            rowList: [10, 20, 50, 100],
            rownumbers: true,
            pager: "#gridpage",
          	shrinkToFit:true,
            caption: "配送企业列表",

            //序号宽度自动变化
            gridComplete:function(){
            	//序号列宽度自适应（参数为jqgridID）
                autoRNWidth("gridlist");
            },

            jsonReader: {
                repeatitems: false,
                id: "companyId"
            },
            onSelectRow : function(id) {
                if (id) {
                  jQuery('#gridlist').jqGrid('editRow', id, true);
                }
            }
        });
		$("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
        $(window).trigger("resize");
        $("#gridlist").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden","height" : "230px" });
		
		// 查询
		$("#search").click(function(){
			var delCompName=$.trim($("#delCompName").val());
			var delCompStatus=$.trim($("#delCompStatus").val());
			$("#gridlist").jqGrid("setGridParam", {
				mtype: "post",
				url: "${ctx }/yimiaoOrderdetail/getYimiaoPSData.html",
				postData: {"delCompName":delCompName,"delCompStatus":delCompStatus},//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	 });
	
	 function selectId(rowId){
		 var rowdata = $("#gridlist").jqGrid('getRowData', rowId);
		 var dialog = top.dialog.get(window);
    	 dialog.close(rowdata); // 关闭（隐藏）对话框
    	 dialog.remove();				 //
	}
</script>
</html>