<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<style type="text/css">
	.content {
		min-height: 0px;
	}
</style>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-success">
	    	<div class="box-body">
				<!-- form start -->
				<div id="baseInfo" class="box-body">
					<table class="form-table form-table-2 form-table-info">
						<tbody>
							<tr class="form-group-sm">
								<th>
		                            <label class="control-label "><spring:message code="drugpurDistributeLogistics.sendTime"/>：</label>
		                        </th>
		                        <td colspan="3">
		                        	<fmt:formatDate value="${drugpurDistributeLogisticsForm.sendTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
		                        </td>
							</tr>
							<tr class="form-group-sm">
								<th>
		                            <label class="control-label "><spring:message code="drugpurDistributeLogistics.logisticsInformation"/>：</label>
		                        </th>
		                        <td colspan="3">
		                        	${drugpurDistributeLogisticsForm.logisticsInformation}
		                        </td>
							</tr>
							<tr class="form-group-sm">
								<th>
		                            <label class="control-label "><spring:message code="drugpurDistributeLogistics.arriveTime"/>：</label>
		                        </th>
		                        <td colspan="3">
		                        	<fmt:formatDate value="${drugpurDistributeLogisticsForm.arriveTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
		                        </td>
							</tr>
							<tr class="form-group-sm">
								<th>
		                            <label class="control-label "><spring:message code="drugpurDistributeLogistics.twoDimensionCode"/>：</label>
		                        </th>
		                        <td style="text-align: center;" colspan="3" id="showCode"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- form end -->
				<div class="box-footer text-center">
                    <button type="button" onclick="back();" class="btn btn-primary btn-sm"><spring:message code="message.button.close"/></button>
                </div>
	    	</div>
		</div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script src="${ctx }/lib/js/jquery.qrcode.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#showCode").qrcode({ 
			//render: "canvas", //设置渲染方式 table canvas
		    width: 200, //宽度 
		    height:200, //高度 
		    text: '${drugpurDistributeLogisticsForm.distributeId }' //任意内容 
		}); 
	}); 
	
	function closeMyDialog(rowdata) {
		var dialog = top.dialog.get(window);
		dialog.close(rowdata);
		$("#addForm")[0].reset();
	    return false;
	} 
	// 返回
	function back() {
		closeMyDialog(true);
	}
</script>
</html>