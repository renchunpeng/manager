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
<title>选择配送企业</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	
		
	<section class="content" style="padding-top:0;">
		<div class=" box box-primary">
			
		     <div class="box-body">
				<div class="textalign">配送企业：</div>
				<div class="boxinput">
			                <input type="text" class="textinput" id="delCompName" name="delCompName" placeholder="配送企业" maxlength="100" />
			     </div>
			     
			     &nbsp;&nbsp;&nbsp;
			     <div class="textalign">配送企业状态：</div>
				 <div class="boxinput">
			          <select id="isUsing">
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
		    'companyId',      
		    '操作',
			'配送企业',
			'配送企业拼音码',
			'配送企业状态'
        ],
        "model": [
		        { name: 'companyId',  hidden:true, width: 80, align: 'center' ,sortable: false},
		        { name: 'oper',  hidden:false, width: 80, align: 'center' ,sortable: false,
		        	formatter:function(val, opts, rowdata){	
		        		var companyId="'"+rowdata.companyId+"'";
	                	return '<a href="javascript:void(0)" onclick="addRelation('+companyId+');">添加</a>';
	                	
	                }
		        },
		        { name: 'companyName',  hidden:false, width: 80, align: 'center' ,sortable: false},
				{ name: 'compSpelCode', width: 80, align: 'center',sortable: false,  hidden:true},			
				{ name: 'isUsing', width: 80, align: 'center',sortable: false,
					formatter:function(val, opts, rowdata){	
	                	return {0:"停用",1:"启用"}[val];
	                }
				}			
        ]      
	};
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoCompany/getYimiaoCompanyData.html",
            colNames: obj.names,
            colModel: obj.model,
            pager: "#gridpage",
            caption: "未绑定配送企业列表",
            rowNum: 20
        });
		
        $(window).trigger("resize");
      
		
		// 查询
		$("#search").click(function(){
			var delCompName=$.trim($("#delCompName").val());
			var isUsing = $.trim($("#isUsing").val());
			$("#gridlist").jqGrid("setGridParam", {
				mtype: "post",
				url: "${ctx }/yimiaoCompany/getYimiaoCompanyData.html",
				postData: {"delCompName":delCompName,"isUsing":isUsing},//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
		
		
	 });
	
	function back(){
		window.location.href="${ctx }/yimiaoCompany/toList.html";
	}
	
	function addRelation(companyId){
		$.ajax({
			url:"${ctx }/yimiaoCompany/addYimiaodelrelationship.html",
			mtype:"post",
			dataType:"json",
			data:{"delCompCode":companyId},
			success:function(result){
				if(result.success){
					$.alert("添加成功","success");
					$("#gridlist").jqGrid("setGridParam", {
						mtype: "post",
						url: "${ctx }/yimiaoCompany/getYimiaoCompanyData.html",
					}).trigger("reloadGrid");//重新载入
				}else{
					$.alert("<spring:message code="message.HN.alert.fail"/>", "error");

				}
			}
		})
		
	}
	

</script>
</html>