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
        <h1>已生成账号疾控中心列表</h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"></spring:message></a></li>
            <li class="active"><a href="#"><spring:message code="用户管理"></spring:message></a></li>
            <li class="active"><a href="#"><spring:message code="账号发放"></spring:message></a></li>
        </ol>
    </section>
    <section class="content-header" style="height: 40px;">
		<div class="divatab divnochecked" onclick="searchBy();">未生成账号</div>
		<div class="divatab divchecked">已生成账号</div>
	</section>
    <section class="content">
        <div class=" box box-primary">
            <div class="box-body">
            	<form id="searchForm">
            	<div class="input">
            		<div class="textalign1"><spring:message code="疾控中心名称"></spring:message>:</div>
                    <div class="boxinput">
                    	<input type="text" class="textinput" id="hospitalName" name="hospitalName" placeholder="<spring:message code="疾控中心名称"></spring:message>" maxlength="50" />
                 	</div>
                 	<div class="textalign"><spring:message code="message.stdHospital.stdHospitalForm.areaName"></spring:message>:</div>
                 	<div class="boxinput" style="width:500px;">
                  		<select class="textinput" id="area1" name="area1" style="width:100px;"><option value="${province}">${provinceName}</option></select>
			            <select class="textinput" id="area2" name="area2" style="width:150px;"></select>
			            <select class="textinput" id="area3" name="area3" style="width:150px;"></select>
			            <input type="hidden" id="areaId" name="areaId"/>
                  	</div>
            	</div>
                </form>
            </div>
        </div>
        <div class="btn-control-box">
			<button id="selectHospinfo" type="button" class="btn btn-success btn-sm mySearch">查询</button>
			<button type="button" class="btn btn-sm btn-danger" value="返回" id="btnBack" onclick="javascript:window.location.href='toCreateUser.html';">返回</button>
		</div>
        <table class="jqgrid" id="gridlist"></table>
        <div id="gridpage"></div>
    </section>
    <%@ include file="/WEB-INF/component/commonJS.jsp" %>
    <script type="text/javascript">
    var obj ={
	"names": [
	 			'账号',
	 			'疾控中心编号',
	 			'疾控中心名称',
	 			'所属地区',
	 			'地区编号',
	 			'是否启用',
	 			'初始化状态'
             ],
	"model": [
			 { name: 'userName', width: 40, align: 'center' ,sortable: false},           
			 { name: 'hospitalId',key:true, hidden:true, width: 40, align: 'center' ,sortable: false},
             { name: 'hospitalName', width: 100, align: 'center' ,sortable: false},
             { name: 'areaName', width: 60 , align: 'center',sortable: false},
             { name: 'areaId', width: 60 , align: 'center',sortable: false,hidden:false},
			 { name: 'isUsing', width: 30, align: 'center',sortable: false ,
				 formatter: function(cellvalue) {
					 return ${enum:getEnumJSON('com.hsnn.medstgmini.base.sys.enums.YesOrNo')}[cellvalue]||"";
			 }},
			 { name: 'initializationState', width: 30, align: 'center',sortable: false ,
				 formatter: function(cellvalue) {
					/* return ${enum:getEnumJSON('com.hsnn.medstgmini.base.std.enums.InitializationStateEnum')}[cellvalue]||""; */
					 var str='';
					 if(cellvalue ==1){
						 str='待审核';
					 }else if(cellvalue == 0){
						 str+='待提交';
					 }else if(cellvalue == 2){
						 str+='审核通过';
					 }else if(cellvalue == 3){
						 str+='审核不通过';
					 }else if(cellvalue == 4){
						 str+='审核通过';
					 } else if(cellvalue == 5){
						 str+='审核不通过';
					 }
					return str;
			 }}
             ]      
	 		};
	 
		 $(function () {			 
	         $("#gridlist").jqGrid({
	             url: "${ctx }/sysUser/getYySendSelectList.html",
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
	             caption: "<spring:message code="已生成账号疾控中心列表"/>",
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
	     });
	
   
		function generateAccount(name,id,areaId,userType){
	    	$.HN.dialog.open({
	             id:id,
	             title:"用户新增",
	             url:"${ctx}/sysUser/toGenerateAccount.html?id="+id+"&userType="+userType+"&areaId="+areaId+"&name="+name,
	             width:"700px",
	             height:"310px",
	             closefunc:function(){
	            	 window.location.href="${ctx}/sysUser/toCreateUserList.html?userType="+userType;
	             }
	         });
   		}
	    //查询
		$(".mySearch").click(function(){
			var areaId = $("#area3").val();
            if("" == areaId){
                areaId = $("#area2").val();
				if("" == areaId){
					areaId = $("#area1").val();
				}
            } 
            $('#areaId').val(areaId);
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid('setGridParam',{
				    mtype: "post",
	                url: "getYySendSelectList.html",
	                postData:queryData
	        }).trigger("reloadGrid"); //重新载入
	         
		});
	    
		 $("#area2").HNSelect({
             url: "${pageContext.request.contextPath}/selectController/getArea.html", data: { ID: '${province}' }, defaultText: "<option value=''><spring:message code="请选择"/></option>",
             func: function () {
                 $("#area3").HNSelect({
                     parent_selector: "#area2", url: "${pageContext.request.contextPath}/selectController/getArea.html", dataid: "ID", defaultText: "<option value=''><spring:message code="请选择"/></option>",
                 });
             }
         });
		
         //已生成账号疾控中心
         function searchBy(){
			
			document.location.href = "${ctx}/sysUser/toYYSelectList.html";
		}
    </script>
</body>
</html>