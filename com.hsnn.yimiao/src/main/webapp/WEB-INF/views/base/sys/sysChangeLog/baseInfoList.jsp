<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="message.sysChangeLog.list.title"></spring:message></title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
    <style type="text/css">
    	.dateWidth{width: 40%;min-width: 70px;}
    </style>
</head>
<body class="skin-blue-light sidebar-mini fixed skin-blue-light-frame">
							
    <section class="content-header">
        <h1><spring:message code="message.sysChangeLog.list.h1"></spring:message></h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.html"><i class="fa fa-home"></i><spring:message code="message.lable.first"></spring:message></a></li>
            <li class="active"><a href="#"><spring:message code="message.sysChangeLog.lable.left"></spring:message></a></li>
            <li class="active"><a href="#"><spring:message code="message.sysChangeLog.lable.right"></spring:message></a></li>
        </ol>
    </section>
    
    <section class="content">
        <div class=" box box-primary">
            <div class="box-body">
            	<form id="searchForm">
                    
                    <div class="textalign"><spring:message code="message.sysChangeLog.search.tableName"></spring:message>:</div>
	                  <div class="boxinput">
	                  		<select class="textinput" id="serializeTable" name="serializeTable"> 
	                  			 <option value="">--全部--</option>
								 <c:forEach items="${serializeTable}" var="serializeTable" >
	                        		<option value="${serializeTable.key}">${serializeTable.value}</option>
	                        	 </c:forEach>
	                        </select>
	                  </div>
                  
                    <div class="textalign"><spring:message code="message.sysChangeLog.search.operateType"></spring:message>:</div>
                    <div class="boxinput">
	                    <select class="textinput" id="operateType" name="operateType"> 
                            <option value="">--全部--</option>
                        	<c:forEach items="${enum:getEnumValues('com.hsnn.medstgmini.base.sys.enums.SysChangelogOperateType')}" var="items" >
								<option value="${items.key}" >${items.value}</option> 
							</c:forEach>
                       </select>
                  </div>
                  
                   <div class="textalign"><spring:message code="message.sysChangeLog.search.startCreaterDatetime"></spring:message>:</div>
                   <div class="boxinput">
						<input id="startCreaterDatetime" name="startCreaterDatetime" class="register-input Wdate dateWidth" 
							aria-required="true" aria-invalid="false" onfocus="WdatePicker({maxDate:'%y-%M-%d'})"/>
							-
						<input id="endCreaterDatetime" name="endCreaterDatetime"   class="register-input Wdate dateWidth" 
							aria-required="true" aria-invalid="false" onfocus="WdatePicker({minDate:'%y-%M-%d'})"/>
						
                   </div>
                   
                   <div class="textalign"><spring:message code="message.sysChangeLog.search.tableCode"></spring:message>:</div>
                      <div class="boxinput">
                      <input type="text" class="textinput" name="tableCode" placeholder="<spring:message code="message.sysChangeLog.search.tableCode"></spring:message>" maxlength="50" />
                  </div>
                  
                   <div class="textalign"><spring:message code="message.sysChangeLog.search.userName"></spring:message>:</div>
                      <div class="boxinput">
                      <input type="text" class="textinput" name="userName" placeholder="<spring:message code="message.sysChangeLog.search.userName"></spring:message>" maxlength="50" />
                  </div>
                  
                  <div class="textalign"><spring:message code="message.sysChangeLog.search.name"></spring:message>:</div>
                      <div class="boxinput">
                      <input type="text" class="textinput" name="name" placeholder="<spring:message code="message.sysChangeLog.search.name"></spring:message>" maxlength="50" />
                  </div>
                   	
                  <div class="textalign" >
                    <button id="selectHospinfo" type="button" class="btn btn-success btn-sm mySearch"><spring:message code="message.button.seachSpacing"/></button>
                  </div>
                
                </form>
            </div>
        </div>
        
        <table class="jqgrid" id="gridlist"></table>
        <div id="gridpage"></div>
        
        <div class=" box box-warning bottongroup">
       		<button id="translating" type="button" class="btn btn-success btn-sm"><spring:message code="message.sysChangeLog.search.batchCompareButton"></spring:message></button>
        </div>
    </section>
    
    <%@ include file="/WEB-INF/component/commonJS.jsp" %>
    
    <script type="text/javascript">
    var obj ={
	 			"names": [
	 			          	'操作',
	 			          	'',
							'<spring:message code="message.sysChangeLog.listForm.serializeTable"></spring:message>',
							'<spring:message code="message.sysChangeLog.listForm.operateType"></spring:message>',
							'<spring:message code="message.operationLog.listForm.mechanismName"/>',
							'<spring:message code="message.operationLog.listForm.departmentName"/>',
							'<spring:message code="message.operationLog.listForm.jobName"/>',
							'<spring:message code="message.operationLog.listForm.userName"/>',
							'<spring:message code="message.operationLog.listForm.name"/>',
							'<spring:message code="message.sysChangeLog.listForm.tableCode"></spring:message>',
							'<spring:message code="message.sysChangeLog.listForm.createrName"></spring:message>',
							'<spring:message code="message.sysChangeLog.listForm.createrDatetime"></spring:message>'
             ],
		      "model": [
			 {name: 'operate', width: 30, align:"center", sortable: false,
			    formatter : function(val, opts, rowdata) {
			    				var str = "<a href='${ctx}/sysChangeLog/getBaseDetial.html?id="+rowdata.id+ "&comeBack=${comeBack}' class='opIcon' title='详情'>详情</a>";
			         			return str;
			         		 }
			 },             
			 { name: 'id',key:true, hidden:true, width: 40, align: 'center' ,sortable: false},
             { name: 'serializeTable', width: 40, align: 'center' ,sortable: false,
				 formatter: function(cellvalue) {
					 return ${enum:getEnumJSON('com.hsnn.medstgmini.base.sys.enums.TableNameEnum')}[cellvalue];
			 }},
             { name: 'operateType', width: 60 , align: 'center',sortable: false,
				 formatter: function(cellvalue) {
					 return ${enum:getEnumJSON('com.hsnn.medstgmini.base.sys.enums.SysChangelogOperateType')}[cellvalue];
			 }},
             { name: 'mechanismName', width: 80, align: 'center',sortable: false },
             { name: 'departmentName', width: 80, align: 'center',sortable: false },
             { name: 'jobName', width: 80, align: 'center',sortable: false },
             { name: 'userName', width: 80, align: 'center',sortable: false },
             { name: 'name', width: 80, align: 'center',sortable: false },
             { name: 'tableCode', width: 40, align: 'center',sortable: false},
             { name: 'createrName', width: 80, align: 'center',sortable: false },
             { name: 'createrDatetime', width: 90, align: 'center',sortable: false ,
             	formatter:function(val){
            		return val!=null?new Date(val).format('yyyy-MM-dd HH:mm:ss'):"";
            	}
             }
             ]      
	 		};
	 
		 $(function () {
	         $("#gridlist").jqGrid({
	             url: "getBaseInfo.html",
	             //mtype: "localhost",
	             contentType : 'application/json',
	             datatype: "json",
	             autowidth: true,
	             colNames: obj.names,
	             colModel: obj.model,
	             rownumbers: true,
	             pager: "#gridpage",
	             viewrecords: true,
	             multiselect: true,
	             caption: "<spring:message code="message.sysChangeLog.list.title"/>",
	
	             //序号宽度自动变化
	             gridComplete:function(){
	             	//序号列宽度自适应（参数为jqgridID）
	                 autoRNWidth("gridlist");
	             },
	
	             jsonReader: {
	                 repeatitems: false,
	                 id: "ids"
	             }
	         });
	         $("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
	         $(window).trigger("resize");
	     });
	
   
	    //查询
		$(".mySearch").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			 $("#gridlist").jqGrid('setGridParam',{
				    mtype: "post",
	                url: "getBaseInfo.html",
	                postData:queryData
	         }).trigger("reloadGrid"); //重新载入
		});
		var width=document.body.clientWidth;
		var height=document.body.clientHeight;
		// 批量比较
		$("#translating").click(function() {
			var selectIds = $("#gridlist").jqGrid('getGridParam','selarrrow');
			if(selectIds == "" || selectIds.length==1) {
				$.alert("请选择多条数据进行比较！", "warn");
				return;
			}
			var flag=true;
			for(var i=0;i<selectIds.length-1;i++){
				//判断业务ID和数据表是否相同
				var rowDataTop = $("#gridlist").jqGrid('getRowData',selectIds[i]);
				var rowDataButtom = $("#gridlist").jqGrid('getRowData',selectIds[i+1]);
				if(rowDataTop.serializeTable!=rowDataButtom.serializeTable || rowDataTop.tableCode!=rowDataButtom.tableCode){
					$.alert("请选择相同的业务数据!", "error");
					return ;
				}
				
			}
			$.HN.dialog.open({
		          "id": "quality",
		          "title": "对比信息",
		          "url": "${ctx}/sysChangeLog/getBaseInfoCompare.html?ids="+selectIds, 
		          "data": {}, 
		          "width": 800, 
		          "height": 450, 
		          "closefunc":function(params) {
		        	 
		          }
		      });
			
		});
	
	 function win(url,title){
   	 $.HN.dialog.open({
	          "id": "quality",
	          "title": title,
	          "url": url, 
	          "data": {}, 
	          "width": 800, 
	          "height": 510, 
	          "closefunc":function(params) {
            	   $("#gridlist").jqGrid('setGridParam',{
    				    mtype: "post",
    	                url: "getDataList.html",
    	             }).trigger("reloadGrid"); 
	          }
	      }); 
    }
    </script>
</body>
</html>












