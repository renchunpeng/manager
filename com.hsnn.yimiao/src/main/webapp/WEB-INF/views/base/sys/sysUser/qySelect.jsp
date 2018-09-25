<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title>未生成账号企业</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue-light sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1>未生成账号企业</h1>
		<ol class="breadcrumb">
			<li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i> <spring:message code="message.lable.first" /></a></li>
			<li class="active"><a href="#">账号管理</a></li>
			<li class="active"><a href="#">账号发放</a></li>
		</ol>
	</section>
	<section class="content-header" style="height: 40px;">
		<div class="divatab divchecked">未生成账号企业</div>
		<div class="divatab divnochecked" onclick="searchBy();">已生成账号企业</div>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form id="searchForm">
					<div class="input">
						<div class="textalign1">企业名称：</div>
						<div class="boxinput">
							<input type="text" class="textinput" id="companyName" name="companyName" placeholder="企业名称" maxlength="100" />
						</div>
						<div class="textalign">企业类型：</div>
						<div class="boxinput">
							<select class="textinput" id="companyType" name="companyType" style="width:200px;">
								<option value="">--请选择--</option>
								<option value="0">投标企业</option>
								<option value="1">配送企业</option>
							</select>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="insert" type="button" class="btn btn-success btn-sm"><spring:message code="新增" /></button>
			<button id="search" type="button" class="btn btn-success btn-sm"><spring:message code="查询" /></button>
			<button type="button" class="btn btn-sm btn-danger" value="返回" id="btnBack"
				onclick="javascript:window.location.href='toCreateUser.html';">返回</button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
	<%@ include file="/WEB-INF/component/commonJS.jsp"%>
	<script type="text/javascript">
	var obj ={
			"names": ['',
				'<spring:message code="操作"/>',
				'<spring:message code="企业名称"/>',
				'<spring:message code="企业类型"/>',
				'<spring:message code="是否启用"/>', 
				'<spring:message code="录入人"/>',
				'<spring:message code="资质状态"/>',
				'<spring:message code="初始化状态"/>',
	        ],
	        "model": [
			        { name: "companyId", key:true, hidden:true, width: 10, align: 'center' ,sortable: false},
					{ name: 'operate', width: 10, align: 'center',sortable: false,
			        	formatter : function(val, opts,rowdata) {
							var str="";
                       		str += "<a href='javascript:generateAccount(\""+rowdata.companyName+"\",\""+rowdata.companyId+"\",\""+rowdata.companyType+"\",${userType});' title='<spring:message code='生成账号'/>'>生成账号</a>";
							return str;
						}
		        	},
			        { name: "companyName", width: 10, align: 'center' ,sortable: false},
			        { name: "companyType", width: 10, align: 'center' ,sortable: false,
			        	formatter:function(val, opts, rowdata){
			        		return val == null ? "-":{"0":"投标企业","1":"配送企业"}[val];
			           }  
			        },
			       	{ name: "isUsing", width: 10, align: 'center' ,sortable: false,
			        	formatter: function(val) {
			        		 var str =  val == 1 ?"启用":"停用";
		                     return str;
			          }
			        },
			        { name: "addUserName", width: 10, align: 'center' ,sortable: false}, 
				    { name: "qualificationStatus", width: 10, align: 'center' ,sortable: false,
			        	formatter: function(val) {
			        		 var str =  val == 1 ?"合格":"不合格";
		                     return str;
			          }
			        }, 
		           	{ name: "initializationState", width: 10, align: 'center' ,sortable: false,
				        formatter: function(cellvalue) {
							return ${enum:getEnumJSON('com.hsnn.medstgmini.base.std.enums.InitializationStateEnum')}[cellvalue];
				       	}
					},
	        ]      
		};
    	
        $(function () {
        	$('#searchForm input').bind('keydown', function(event) {if (event.keyCode == "13") {event.preventDefault();gridSerch();}})[0].focus();
            $("#gridlist").jqGrid({
                url: "${ctx}/sysUser/getQySelectList.html",
                mtype: "post",
                contentType : 'application/json',
                datatype: "json",
                autowidth: true,
                height: 340,
                colNames: obj.names,
                colModel: obj.model,
                rowNum: 20,
                rowList: [10, 20, 50, 100],
                rownumbers: true,
                pager: "#gridpage",
                viewrecords: true,
                multiselect: false,
                caption: "未生成账号企业列表",
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
            $("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
            $(window).trigger("resize");
            $("#gridlist").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden","height" : "230px" });
	
          //新增
          $("#insert").click(function(){
        	  var url= '${ctx}/sysUser/toInsert.html';
        	  $.HN.dialog.open({
		          "id": "quality",
		          "title": "新增企业信息",
		          "url": url, 
		          "data": {}, 
		          "width": 800, 
		          "height": 400, 
		          "closefunc":function(params) {
	            	   			$("#gridlist").jqGrid("setGridParam",{
         				    	mtype: "post",
         	                	url: "getQySelectList.html",
         	             		}).trigger("reloadGrid"); 
		          			}
		      }); 
          })    
     	// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				mtype: "post",
				url: "${ctx }/sysUser/getQySelectList.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
        
		//生成账号
        function generateAccount(name,id,companyType,userType){
        	
        	if (companyType != null && parseInt(companyType) == 0) {//投标企业
        		userType = 1;
        	} else if (companyType != null && parseInt(companyType) == 1) {//配送企业
        		userType = 2;
        	}
	    	$.HN.dialog.open({
	             id:id,
	             title:"用户新增",
	             url:"${ctx}/sysUser/toGenerateAccount.html?id="+id+"&userType="+userType+"&companyType="+companyType+"&name="+name,
	             width:"700px",
	             height:"310px",
	             closefunc:function(){
	            	 window.location.href="${ctx}/sysUser/toCreateUserList.html?userType="+userType;
	             }
	         });
    	}
		
		//跳转已生成账号企业
		function searchBy(){
			document.location.href="${ctx}/sysUser/qySendSelect.html";
		}
    </script>
</body>
</html>