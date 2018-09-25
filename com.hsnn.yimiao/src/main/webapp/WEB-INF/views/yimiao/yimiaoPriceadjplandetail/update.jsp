<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="调价明细表更新-待修改"/></title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="调价明细表更新-待修改"/></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#"><spring:message code="调价明细表管理-待修改"/></a></li>
			<li class="active"><a href="#"><spring:message code="调价明细表更新-待修改"/></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">     
				<form role="form" id="updateForm" class="form-horizontal" action="updateYimiaoPriceadjplandetail.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
										<!-- 计划明细id -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplandetail.priceAdjPalnDetailId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="priceAdjPalnDetailId" name="priceAdjPalnDetailId"
	                            			value="${yimiaoPriceadjplandetailForm.priceAdjPalnDetailId}" placeholder="<spring:message code="yimiaoPriceadjplandetail.priceAdjPalnDetailId"/>" type="text">
			                        </td>
									<th>
										<!-- 调价计划id -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplandetail.priceAdjPlanId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="priceAdjPlanId" name="priceAdjPlanId"
	                            			value="${yimiaoPriceadjplandetailForm.priceAdjPlanId}" placeholder="<spring:message code="yimiaoPriceadjplandetail.priceAdjPlanId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 商品号 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplandetail.goodsCode"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="goodsCode" name="goodsCode"
	                            			value="${yimiaoPriceadjplandetailForm.goodsCode}" placeholder="<spring:message code="yimiaoPriceadjplandetail.goodsCode"/>" type="text">
			                        </td>
									<th>
										<!-- 原采购限价 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplandetail.origProPriceLimit"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="origProPriceLimit" name="origProPriceLimit"
	                            			value="${yimiaoPriceadjplandetailForm.origProPriceLimit}" placeholder="<spring:message code="yimiaoPriceadjplandetail.origProPriceLimit"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 新采购限价 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplandetail.currProPriceLimit"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="currProPriceLimit" name="currProPriceLimit"
	                            			value="${yimiaoPriceadjplandetailForm.currProPriceLimit}" placeholder="<spring:message code="yimiaoPriceadjplandetail.currProPriceLimit"/>" type="text">
			                        </td>
									<th>
										<!-- 原最高零售价 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplandetail.origRetailPriceLimit"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="origRetailPriceLimit" name="origRetailPriceLimit"
	                            			value="${yimiaoPriceadjplandetailForm.origRetailPriceLimit}" placeholder="<spring:message code="yimiaoPriceadjplandetail.origRetailPriceLimit"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 新最高零售价 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplandetail.currRetailPriceLlimit"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="currRetailPriceLlimit" name="currRetailPriceLlimit"
	                            			value="${yimiaoPriceadjplandetailForm.currRetailPriceLlimit}" placeholder="<spring:message code="yimiaoPriceadjplandetail.currRetailPriceLlimit"/>" type="text">
			                        </td>
									<th>
										<!-- 加入计划时间 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplandetail.addDatetime"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addDatetime" name="addDatetime"
	                            			value="${yimiaoPriceadjplandetailForm.addDatetime}" placeholder="<spring:message code="yimiaoPriceadjplandetail.addDatetime"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 加入计划操作人 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplandetail.addUser"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="addUser" name="addUser"
	                            			value="${yimiaoPriceadjplandetailForm.addUser}" placeholder="<spring:message code="yimiaoPriceadjplandetail.addUser"/>" type="text">
			                        </td>
									<th>
										<!-- 备注 -->
			                            <label class="control-label "><spring:message code="yimiaoPriceadjplandetail.remarks"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="remarks" name="remarks"
	                            			value="${yimiaoPriceadjplandetailForm.remarks}" placeholder="<spring:message code="yimiaoPriceadjplandetail.remarks"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
								</tr>
							</tbody>
						</table>
					</div>
					<!-- form end -->
					<div class="null-line"></div>
					<div class="modal-footer">
	                    <button type="button" onclick="save();" class="btn btn-success btn-sm"><spring:message code="message.button.save"/></button>
	                    <button type="button" onclick="back();" class="btn btn-danger btn-sm"><spring:message code="message.button.getBack"/></button>
	                </div>
				</form>
			</div>
		</div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script src="${ctx }/lib/js/validate/jquery.validate.js"></script>
<script src="${ctx }/lib/js/validate.expand.js"></script>
<script type="text/javascript">
	$(function(){
		init();//页面加载完毕了，做点什么呢？
	})
	
	function init() {
		$("#updateForm").validate(${validate});
	}
	
	function save() {
		if(!$('#updateForm').valid()) {
			return;
		}
		$.HN.message.confirm('确定要保存吗？', '', '').on(function (e) {
			if (e) {
				$("#updateForm").ajaxSubmit({
					dataType : "json",
             		timeout: 10000,
               		success: function(result,statusText) {
                   		if(result.success){
           	     			$.alert("添加成功！", "success", function() {
           	     				document.location.href="${ctx }/yimiaoPriceadjplandetail/toList.html";
							});
                   		}else{
                   			$.alert(result.msg || "<spring:message code="message.HN.alert.baoCunBai"/>", "error");
                   		}
					}
				});
			}
		});
	}
	
	function back() {
		document.location.href="${ctx }/yimiaoPriceadjplandetail/toList.html";
	}
</script>
</html>