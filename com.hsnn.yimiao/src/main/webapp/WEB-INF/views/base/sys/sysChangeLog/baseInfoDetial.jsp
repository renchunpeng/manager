<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="message.sysChangeLog.detial.title"/></title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp"%>
    <!--[if lt IE 9]>
        <script src="${ctx}/lib/js/html5shiv.min.js"></script>
        <script src="${ctx}/lib/js/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        div.col-sm-3.text-left, div.col-sm-2.text-left, div.col-sm-10.text-left{
            color:#949494;
        }
        
    </style>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
    <section class="content-header">
        <h1><spring:message code="message.sysChangeLog.detial.h1"/> </h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.html"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
            <li class="active"><a href="#"><spring:message code="message.sysChangeLog.detial.left"/></a></li>
            <li class="active"><a href="#"><spring:message code="message.sysChangeLog.detial.right"/></a></li>
        </ol>
    </section>
    <section class="content">
    	<div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title"><spring:message code="message.sysChangeLog.detial.h3"/></h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div>
            </div>
            <div class="box-body">
               <table class='form-table form-table-2 form-table-info'> 
               <tbody>
               		<tr id='comsc' class='form-group-sm'>
               			<th><label class='control-label '><spring:message code="message.sysChangeLog.listForm.serializeTable"/>：</label></th>
               			<td><label class='control-label '>
               				<c:forEach items="${enum:getEnumValues('com.hsnn.medstgmini.base.sys.enums.TableNameEnum')}" var="items" >
								<c:if test="${items.key==sysChangeLog.serializeTable}">${items.value}(${sysChangeLog.serializeTable})</c:if> 
							</c:forEach>
               			</label></td>
               			<th><label class='control-label '><spring:message code="message.sysChangeLog.listForm.operateType"/>：</label></th>
               			<td><label class='control-label '>
               				<c:forEach items="${enum:getEnumValues('com.hsnn.medstgmini.base.sys.enums.SysChangelogOperateType')}" var="items" >
								<c:if test="${items.key==sysChangeLog.operateType}">${items.value}</c:if> 
							</c:forEach>
               			</label></td>
               		</tr>
               	    <c:if test="${userType == 5}">
	               		<tr id='comsc' class='form-group-sm'>
	               			<th><label class='control-label '><spring:message code="message.sysChangeLog.listForm.mechanismName"/>：</label></th>
	               			<td><label class='control-label '></label>${sysChangeLog.mechanismName}</td>
	               			<th><label class='control-label '><spring:message code="message.sysChangeLog.listForm.departmentName"/>：</label></th>
	               			<td><label class='control-label '>${sysChangeLog.departmentName}</label></td>
	               		</tr>
	               		<tr id='comsc' class='form-group-sm'>
	               			<th><label class='control-label '><spring:message code="message.sysChangeLog.listForm.userName"/>：</label></th>
	               			<td><label class='control-label '></label>${sysChangeLog.userName}</td>
	               			<th><label class='control-label '><spring:message code="message.sysChangeLog.listForm.name"/>：</label></th>
	               			<td><label class='control-label '>${sysChangeLog.name}</label></td>
	               		</tr>
	               		<tr id='comsc' class='form-group-sm'>
	               			<th><label class='control-label '><spring:message code="message.sysChangeLog.listForm.tableCode"/>：</label></th>
	               			<td><label class='control-label '>${sysChangeLog.tableCode}</label></td>
	               			<th><label class='control-label '><spring:message code="message.sysChangeLog.listForm.createrName"/>：</label></th>
	               			<td><label class='control-label '>${sysChangeLog.createrName}</label></td>
	               		</tr>
	               		<tr id='comsc' class='form-group-sm'>
	               			<th><label class='control-label '><spring:message code="message.sysChangeLog.listForm.jobName"/>：</label></th>
	               			<td><label class='control-label '>${sysChangeLog.jobName}</label></td>
	               			<th><label class='control-label '><spring:message code="message.sysChangeLog.listForm.createrDatetime"/>：</label></th>
	               			<td><label class='control-label '><fmt:formatDate value="${sysChangeLog.createrDatetime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" dateStyle="default"/></label></td>
	               		</tr>
               		</c:if>
               </tbody>
               </table>
            </div>
        </div>
    
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title"><spring:message code="message.sysChangeLog.detial.serializeObj"/></h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div>
            </div>
            <div class="box-body">
                <div id="returnMsg"><!-- 显示内容区域 --></div>
            </div>
        </div>
        <div class="box-footer text-center modal-footer">
        	<%-- <a href="toBaseInfo.html" class="btn btn-danger"><spring:message code="message.sysChangeLog.detial.btnBack"/></a> --%>
        	<a href="${comeBack}" class="btn btn-primary btn-sm"><spring:message code="message.sysChangeLog.detial.btnBack"/></a>
        </div>
    </section>
    
    <script src="${ctx}/lib/js/jquery.min.js" type="text/javascript"></script>
    <script src="${ctx}/lib/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${ctx}/lib/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="${ctx}/lib/js/app.js" type="text/javascript"></script>
    <script src="${ctx}/lib/plugins/jqgrid/jquery.jqGrid.min.js" type="text/javascript"></script>
    <script src="${ctx}/lib/plugins/daterangepicker/moment.js"></script>
    <script src="${ctx}/lib/plugins/daterangepicker/daterangepicker.js"></script>
    <script src="${ctx}/lib/js/jquery.form.js" type="text/javascript"></script>
    <script src="${ctx}/lib/js/HNApp.js"></script>
    
    <script type="text/javascript">
    	var strTitle = []; 
    	var strFiled = [];
    	var datas=${datas};
    	
    	$(function(){
    		
    		$.each(datas, function(idx, obj) {
    			printObject(obj);
    		});
    		
    		$.each(datas, function(idx, obj) {
				printField(obj);
			})
			
			//循环遍历字段,组装表单
			var indexTitle=$(strTitle).length;
    		var indexFiled=$(strFiled).length;
    		
	   	/* 	var flag=check(indexTitle/2);
	   		indexTitle=indexTitle/2;
	   		
	   		var is=String(indexTitle).indexOf('.');
	   		var row=0;
	   		if(is>=0){
	   			row=parseInt(indexTitle)+1;
	   		} */
     		var row = indexTitle;
    		if(indexTitle%2==1){
    			strTitle[row]='';
    			strFiled[row]='';
    			row++;
    		}
    		var table="<table class='form-table form-table-2 form-table-info'> <tbody>";
    		
    		var trs="";
    		
    		for(var i=0;i<row;i++){
    			var tr="<tr id='comsc' class='form-group-sm'>";
	    				tr+="<th>";
		    		        tr+="<label class='control-label '>";
		    		        tr+=$(strTitle).get(i);//输出字段标题
		    		        tr+="：</label>";
		    		   	tr+="</th>";
		    		   	tr+="<td>";
		    		   	    tr+="<label class='control-label '>";
		    		   	 	tr+=$(strFiled).get(i);//输出字段的值
		    		   	 	tr+="</label>";
		    		    tr+="</td>";
		    		    ++i;
			    		tr+="<th>";
		    		        tr+="<label class='control-label '>";
		    		        tr+=$(strTitle).get(i);//输出字段标题
		    		        if($(strTitle).get(i)!=""){
		    		        	tr+="：";
		    		        }
		    		        tr+="</label>";
		    		   	tr+="</th>";
		    		   	tr+="<td>";
		    		   	    tr+="<label class='control-label '>";
		    		   	 	tr+=$(strFiled).get(i);//输出字段的值
		    		   	 	tr+="</label>";
		    		    tr+="</td>";
		    		    tr+="</tr>";
		       trs+=tr;
    		}
    		table+=trs;
    		table+=" </tbody> </table>";
    		
    		$("#returnMsg").append(table);
    	});
    	
    	//判断是否为整数
    	function check(str){
    		var ex = /^\d+$/;
    		if (ex.test(str)) {
    		   // 则为整数
    		   return true;
    		}
    		return false;
    	}
    	
    	
    	//遍历属性的方法
        function printObject(obj){ 
    		var temp = ""; 
    		for(var i in obj){//用javascript的for/in循环遍历对象的属性 
    			strTitle.push(i);
    		} 
    	} 
    	
        function printField(obj){ 
    		var temp = ""; 
    		for(var i in obj){//用javascript的for/in循环遍历对象的属性 
    			strFiled.push(obj[i]);
    		} 
    	} 
    
    </script>
    
</body>
</html>
