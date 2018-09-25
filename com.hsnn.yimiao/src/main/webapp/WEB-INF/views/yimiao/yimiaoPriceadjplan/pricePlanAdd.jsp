<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>新增调价计划</title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
   <%--  <link href="${ctx}/lib/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" /> --%>
   <style type="text/css">
    	div.box-body {
    		margin-top:7px;
    	}
    	.newWidth{
    		width: 98%;
    	}
    </style>
</head>
<body class="skin-blue-light sidebar-mini fixed skin-blue-light-frame">
    <section class="content-header">
        <h1>新增调价计划</h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i>首页</a></li>
			<li class="active"><a href="#">交易</a></li>
            <li class="active"><a href="#">药品调价</a></li>
            <li class="active"><a href="#">新增调价计划</a></li>
        </ol>
    </section>
    <section class="content">
    <form  id="addForm" role="form" class="form-horizontal" action="priceChangeDetail.home" method="post">
       <div class=" box box-success ">
            <!-- form start -->
            
                <div class="box-body">
                	<table class="form-table form-table-2 form-table-info">
						<tbody>
							<tr class="form-group-sm">
								<th>
									<label class="control-label "><span class="required">*</span>计划名称：</label>
		                        </th>
		                        <td colspan="3">
		                        	<input id="priceAdjPlanName" name="priceAdjPlanName" style="width: 50%;" class="form-control" placeholder="计划名称" type="text"  maxlength="170">
		                        </td>
							</tr>
							<%--<tr class="form-group-sm">
								<th>
		                            <label class="control-label "><span class="required">*</span>计划类型：</label>
		                        </th>
		                        <td colspan="3">
		                        	<select class="form-control" style="width: 50%;"id="executeCat" name="executeCat">
		                        		<option value="1">手动执行</option>
		                        		<option value="2">自动执行</option>
		                        	</select>
		                        </td>
							</tr>
                            <tr class="form-group-sm" id="divAdd" hidden="true">
								<th>
		                             <label id="executeTimeLabel" class="control-label" ><span class="required">*</span>执行时间：</label>
		                        </th>
		                        <td colspan="3">
		                        	<input class="form-control" id="executeDatetime" name="executeDatetime" style="width: 50%;" readonly placeholder="执行时间精确到秒" type="text" data-provide="datepicker" data-date-fmt="yyyy-MM-dd HH:mm:ss" />
		                        </td>
							</tr>--%>
							<tr class="form-group-sm">
								<th>
		                            <label class="control-label"><span class="required">*</span>调价依据：</label>
		                        </th>
		                        <td colspan="3">
		                        	<textarea id="priceAdjAccord" name="priceAdjAccord" style="resize: vertical;width: 98%;" class="form-control" rows="3" placeholder="调价依据"  maxlength="170"></textarea>
		                        </td>
							</tr>
							<tr class="form-group-sm">
								<th>
		                            <label class="control-label">备&nbsp;&nbsp;注：</label>
		                        </th>
		                        <td colspan="3">
		                        	 <textarea class="form-control" id="remark" name="remark" placeholder="备注" style="resize: vertical;width: 98%;" maxlength="340"></textarea>
		                        </td>
							</tr>
						</tbody>
					</table>
                </div>
                
                <div class="box-footer text-center">
                    <button type="button" class="btn btn-primary btn-sm" onclick="save();">提 交</button>
                </div>
               </div>
            </form>
        
    </section>
    <%@ include file="/WEB-INF/component/commonJS.jsp" %>
    <script type="text/javascript">
        $(document).ready(function() {
        	
        	$("#executeCat").change(function() {
        		if ($(this).val() == "2") {
        			$("#divAdd").show();
        			$("#divAdd").show();
        		} else {
        			$("#divAdd").hide();
        			$("#divAdd").hide();
        		}
        	});
        	
        });
        function save(){
        	var priceAdjPlanName=$.trim($('#priceAdjPlanName').val());
        	/*var executeCat=$('#executeCat').val(); ;
        	var executeDatetime=$.trim($('#executeDatetime').val());*/
        	var priceAdjAccord=$.trim($('#priceAdjAccord').val());
        	var remark=$.trim($('#remark').val());
            if(priceAdjPlanName==""){
            	$.HN.message.alert('请输入调价名称！', '提示信息', 'warn');
             	 return;
            }
          	if(priceAdjPlanName.length>170){
          		$.HN.message.alert('调价名称长度不能超过170！', '提示信息', 'warn');
              	 return;
          	}
          	/*if(executeCat=="2"){
        		if(executeDatetime==""){
        			$.HN.message.alert('请设置自动执行时间！', '提示信息', 'warn');
    	        	return;
        		}
        	var tp = Date.parse(executeDatetime);       	
            if(tp<new Date().getTime()){
            	$.alert("执行时间不能小于当前时间!","warn");
            	return;
            	}
        	}*/
        	 if(priceAdjAccord==""){
             	$.HN.message.alert('请输入调价依据！', '提示信息', 'warn');
              	 return;
             }
        	if(priceAdjAccord.length>170){
          		$.HN.message.alert('调价依据长度不能超过170！', '提示信息', 'warn');
              	 return;
          	}
        	$.HN.message.confirm('您确定要提交吗？', '', '').on(function (e) {
	        	if (e) {
	        		 var data =$('#addForm').serializeJSON();	   
	        		$.ajax({
			        	url:"${ctx}/yimiaoPriceadjplan/submitPricePlanAdd.html",
			        	type: "post",
		                dataType:"json",
			        	data:data,
			        	success:function(result){
				        	if(result.success){
				        		top.$.alert('为您成功新增调价计划！','success');
				        		window.location.href = "toUnChangePlan.html";
				        	}else{
				        		$.HN.message.alert(result.msg, '提示信息', 'error');
				        	}
			        	},
						
		        	});
	        	}
        	});
        }
        
        
    </script>
</body>
</html>
