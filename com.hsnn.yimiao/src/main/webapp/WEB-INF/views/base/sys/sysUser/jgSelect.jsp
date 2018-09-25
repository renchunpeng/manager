<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title><spring:message code="message.stdHospital.list.title"></spring:message></title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
	<style type="text/css">
		.inputStyle{
			vertical-align: text-bottom;
			margin-bottom: 2px;
		}
</style>    
</head>
<body class="skin-blue-light sidebar-mini fixed skin-blue-light-frame">						
    <section class="content-header">
        <h1>未生成账号监管机构列表</h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"></spring:message></a></li>
            <li class="active"><a href="#"><spring:message code="用户管理"></spring:message></a></li>
            <li class="active"><a href="#"><spring:message code="账号发放"></spring:message></a></li>
        </ol>
    </section>
    <section class="content-header" style="height: 40px;">
		<div class="divatab divchecked">未生成账号</div>
		<div class="divatab divnochecked" onclick="searchBy();">已生成账号</div>
	</section>
    <section class="content">
        <div class=" box box-primary">
            <div class="box-body">
            	<form id="searchForm">
            	 <div class="input">
					<div class="textalign1">机构名称<spring:message code="message.yanZheng.maoHao"/></div>
	                <div class="boxinput">
	                	<input type="text" class="textinput"  id="heaBurName" name="heaBurName"  placeholder="机构名称" maxlength="50" />
	                </div>
	             </div>
                </form>
            </div>
        </div>
        <div class="btn-control-box">
			<button id="selectHospinfo" type="button" class="btn btn-success btn-sm mySearch"><spring:message code="查询"/></button>
			<button id="add" type="button" class="btn btn-success btn-sm">新增</button>
			<button type="button" class="btn btn-sm btn-danger" value="返回" id="btnBack" onclick="javascript:window.location.href='toCreateUser.html';">返回</button>
		</div>
        <table class="jqgrid" id="gridlist"></table>
        <div id="gridpage"></div>
    </section>
    <%@ include file="/WEB-INF/component/commonJS.jsp" %>
    <script type="text/javascript">
    var obj ={
    		"names": [
    					'操作',
    					'主键',
    					'机构编号',
    					'机构名称',
    					'地区编号',
    					'所属地区',
    					'机构类别',
    					'联系人',
    					'联系电话',
    					'是否有效'
    		        ],
    		        "model": [
    					{ name: 'operate', width: 80, align: 'center',sortable: false,
    						formatter : function(val, opts,rowdata) {
    							var str="";
    	                		str += "<a href='javascript:generateAccount(\""+rowdata.heaBurName+"\",\""+rowdata.id+"\",\""+rowdata.heaBurType+"\",${userType});' title='<spring:message code='生成账号'/>'>生成账号</a>";
    							return str;
    						}
    		        	},
    			        { name: "id", key:true, width: 10, align: 'center' ,sortable: false, hidden: true},
    			        { name: "orgId", width: 10, align: 'center' ,sortable: false, hidden:true},
    			        { name: "heaBurName", width: 120, align: 'center' ,sortable: false}, 
    			        { name: "areaId", width: 80, align: 'center' ,sortable: false},
    			        { name: "areaName", width: 120, align: 'center' ,sortable: false},
                        { name: "heaBurType", width: 100, align: 'center' ,sortable: false,
                            formatter: function(val,opts,rowdata) {
                                return val == null ? "-":{"5":"市卫计委","4":"市疾控中心"}[val];
                            }},
    			        { name: "contactor", width: 100, align: 'center' ,sortable: false},
    			        { name: "cellphone", width: 100, align: 'center' ,sortable: false},
    			        { name: "isUsing", width: 80, align: 'center' ,sortable: false,
    			        	formatter: function(cellvalue) {
    			        		return ${enum:getEnumJSON('com.hsnn.medstgmini.base.sys.enums.YesOrNo')}[cellvalue];		
    			        }}
             ]      
	 		};
	 
		 $(function () {
			 $("#heaBurName").bind('keydown', function(event) {if (event.keyCode == "13") {event.preventDefault();  $('selectHospinfo').click();}}).focus();
	         $("#gridlist").jqGrid({
	             url: "${ctx }/sysUser/getJgSelectList.html",
	             //mtype: "localhost",
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
	             viewrecords: true,
	             multiselect: false,
	             caption: "<spring:message code="未生成账号监管机构列表"/>",
	             postData: {"userType":"${userType}"},
	             //序号宽度自动变化
	             gridComplete:function(){
	             	//序号列宽度自适应（参数为jqgridID）
	                 autoRNWidth("gridlist");
	             	//数据只有一条时默认选中（参数为jqgridID）
	                 selectByOneData("gridlist");
	             },
	
	             jsonReader: {
	                 repeatitems: false,
	                 id: "ids"
	             }
	         });
	         $("#gridlist").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden"});
	         $("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
	         $(window).trigger("resize");
	         showHideCol("gridlist", "advanceSearch");
	         initAdvanceSearch("searchTypeButton", "searchType");
	     });
	
		function generateAccount(name,id,heaBurType,userType){
	    	$.HN.dialog.open({
	             id:id,
	             title:"用户新增",
	             url:"${ctx}/sysUser/toGenerateAccount.html?id="+id+"&heaBurType="+heaBurType+"&userType="+userType+"&name="+name,
	             width:"800px",
	             height:"400px",
	             closefunc:function(){
	            	 window.location.href="${ctx}/sysUser/toCreateUserList.html?userType="+userType;
	             }
	         });
   		}
	    //查询
		$(".mySearch").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid('setGridParam',{
				    mtype: "post",
	                url: "getJgSelectList.html",
	                postData:queryData
	        }).trigger("reloadGrid"); //重新载入
	         
		});
		 
		//新增
         $("#add").click(function(){
       	  var url= '${ctx}/sysUser/toAddYMJG.html';
       	  $.HN.dialog.open({
		          "id": "quality",
		          "title": "新增监管机构",
		          "url": url, 
		          "data": {}, 
		          "width": 800, 
		          "height": 400, 
		          "closefunc":function(params) {
	            	   $("#gridlist").jqGrid("setGridParam",{
        				    mtype: "post",
        	                url: "getJgSelectList.html",
        	             }).trigger("reloadGrid"); 
		          }
		      }); 
         })
         
         //已生成账号监管机构
         function searchBy(){
			
			document.location.href = "${ctx}/sysUser/jgSendSelect.html";
		}
    </script>
</body>
</html>