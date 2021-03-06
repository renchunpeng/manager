<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<style type="text/css">
	div.divatab{
		width:100px;height:40px;float:left;border:2px solid #C6C9C9;border-radius:5px;text-align:center;line-height:35px;
		cursor:pointer;font-weight:900;
	}
	div.divchecked{
		background-color:#3C8DBC;color:#fff;
	}
	div.divnochecked{
		background-color:#E0E5ED;color:#777;
	}
</style>
<title><spring:message code="message.stdCompany.title"/></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		
	</section>
		
	<section class="content">
		<div class=" box box-primary">
			
		     <div class="box-body">
				<div class="textalign">配送企业名称：</div>
				<div class="boxinput">
			                <input type="text" class="textinput" id="delCompName" name="delCompName" placeholder="配送企业名称" maxlength="100" />
			     </div>
			     
			     
			     <div class="textalign">配送企业状态：</div>
				 <div class="boxinput">
			          <select id="delCompStatus">
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
		"names": ['操作',
			'生产企业名称',
			'生产企业拼音码',
			'生产企业状态',
			'配送企业名称',
			'配送企业拼音码',
			'配送企业状态',
			'最后一次更新时间',
			'配送企业编号'
        ],
        "model": [
		        { name: "oper", key:true, width: 100, align: 'center' ,sortable: false,
		        	formatter:function(val, opts, rowdata){	
	                	var delCompCode="'"+rowdata.delCompCode+"'";
	                	return "<a href=\"javascript:void(0);\" onclick=\"selectId('"+opts.rowId+"')\" >选择</a>";
	                }
		        },
				{ name: 'prodCompName', width: 80, align: 'center',sortable: false,hidden:true},
		        { name: "prodCompNameSpel", width: 80, align: 'center' ,sortable: false,hidden:true},
		        { name: "prodCompStatus", width: 220, align: 'center' ,sortable: false,hidden:true,
		        	formatter:function(val, opts, rowdata){	
	                	return {0:"停用",1:"启用"}[val];
	                }	
		        },
		        { name: "delCompName", width: 100, align: 'center' ,sortable: false},
		        { name: "delCompNameSpel", width: 90, align: 'center' ,sortable: false,hidden:true},
		        { name: "delCompStatus", width: 100, align: 'center' ,sortable: false,
		        	formatter:function(val, opts, rowdata){	
	                	return {0:"停用",1:"启用"}[val];
	                }	
		        },
		        { name: "updDatetime", width: 100, align: 'center' ,sortable: false,hidden:true,
		        	formatter:function(val, opts, rowdata){	
		        		if (val != null) {
		        			return new Date(val).format('yyyy-MM-dd HH:mm:ss');
		        		} else {
		        			return "暂未设置";
		        		}
	                }
		        },
		        { name: "delCompCode", width: 100, align: 'center' ,sortable: false,hidden:true}
					
        ]      
	};
	
	$(function(){
		
		$("#gridlist").jqGrid({
            url:"${ctx }/yimiaoOrderdetailRet/getYimiaoDelrelationData.html" ,
            contentType : 'application/json',
            datatype: "json",
            autowidth: true,
            height: 270,
            colNames: obj.names,
            colModel: obj.model,
            rowNum: 20,
            rowList: [10, 20, 50, 100],
            sortable:true,  //是否可排序
			sortname: "t.updDatetime",// 初始化默认排序字段（多个参数以逗号隔开）
			sortorder: "desc",
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
				url: "${ctx }/yimiaoOrderdetailRet/getYimiaoDelrelationData.html",
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

	 
	
	
	
	
	
	function addChComp(){
		window.location.href="${ctx}/stdCompany/toAdd.html";
	}
	function addOutChComp(){
		window.location.href="${ctx}/stdCompany/toAddOutComp.html";
	}
</script>
</html>