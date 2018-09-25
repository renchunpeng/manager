<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title><spring:message code="退货单"/></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<style type="text/css">
	input[type="radio"]{
		vertical-align: text-bottom;
		margin-bottom: 0px;
	}
</style>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="退货单"/></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#"><spring:message code="退货单"/></a></li>
		</ol>
	</section>
	<section class="content">
		<form  id="addForm" role="form" class="form-horizontal" action="addretOrder.html" method="post">
       		<div class=" box box-success ">
			 <div class="box-body">
			 			<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
			                            <label class="control-label ">退货单名称：</label>
			                        </th>
			                        <td>
			                        	<input id="orderName" name="orderName" class="form-control" value="${orderName }" placeholder="采购单名称" type="text"  maxlength="50" style="width:340px;">
			                        </td>
								</tr>
								<tr class="form-group-sm">
								   <th>
			                            <label class="control-label ">退货时间：</label>
			                        </th>
			                        <td>
			                        	<input type="datetime" value='<fmt:formatDate value="<%=new Date() %>"/>' style="border: hidden;" readonly="readonly" class="textinput"    placeholder="采购时间" maxlength="50" />
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
			                            <label class="control-label ">备&nbsp;&nbsp;注：</label>
			                        </th>
			                        <td>
			                        	 <textarea class="form-control" id="orderRamarks" name="orderRamarks" rows="3" placeholder="备注"  maxlength="256" style="width:340px;"></textarea>
			                        </td>
								</tr>
							</tbody>
						</table>
			 		<!-- form end -->
					<div class="null-line"></div>
					<div class="modal-footer">
	                    <button type="button" class="btn btn-primary btn-sm" onclick="nextStep();">下一步</button>
	                </div>
               </div>
		    </div>
         </form>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
function nextStep(){
	var orderRamarks=$.trim($('#orderRamarks').val());        	
	var orderName=$.trim($('#orderName').val());   
    if(orderName==""){
    	$.HN.message.alert('请输入退货单名称！', '提示信息', 'warn');
     	 return;
    }
  	if(orderName.length>50){
  		$.HN.message.alert('退货单名称长度不能超过50！', '提示信息', 'warn');
      	 return;
  	}
	if(orderRamarks.length>520){
  		$.HN.message.alert('备注信息长度不能超过520！', '提示信息', 'warn');
      	 return;
  	}
	$("#addForm").ajaxSubmit({
		dataType : "json",
   		success: function(result) {
       		if(result.success){
       		    var url = "${ctx}/yimiaoPurchaseOrder/toretOrderList.html?orderId="+result.msg;
       			window.location.href=url;
       		}
		}
	});
	
	
	
	
	}
</script>
</html>