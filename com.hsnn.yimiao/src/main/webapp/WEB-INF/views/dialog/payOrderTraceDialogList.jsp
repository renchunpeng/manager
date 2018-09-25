<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<title></title>
<style type="text/css">
span.required {
	color: red;
	margin-right: 6px;
}

div.ccl-window {
	width: 1024px;
	height: 600px;
	margin: auto;
	margin-top: 20px;
	-moz-border-radius: 5px;
	/* Gecko browsers */
	-webkit-border-radius: 5px;
	/* Webkit browsers */
	border-radius: 5px;
	/* W3C syntax */
	background-color: #ffffff;
}

div.ccl-header {
	height: 40px;
	padding: 10px;
	border-bottom: 1px solid #dddfe0;
}

div.ccl-header * {
	display: inline-block;
}

span.ccl-title {
	font-weight: 500;
	font-size: 18px;
	font-family: "å®ä½", "Source Sans Pro", sans-serif;
}

iframe.ccl-iframe {
	width: 100%;
	height: 560px;
	-moz-border-radius: 5px;
	/* Gecko browsers */
	-webkit-border-radius: 5px;
	/* Webkit browsers */
	border-radius: 5px;
	/* W3C syntax */
}

.modal-footer {
	padding: 15px;
	text-align: center;
	border-top: 1px solid #e5e5e5;
}

div.ccl-window button.close {
	color: #000;
}

.overflow-hidden {
	overflow: hidden;
}

.minheight0, .minheight0>* {
	min-height: 0;
}

.overflow-hidden>* {
	float: left;
}

#divPopBox {
	
}
</style>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class="box box-primary">
			<div class="box-header with-border">
				<h3 class="box-title">订单信息</h3>
				<div class="box-tools pull-right">
					<button class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
				</div>
			</div>
			<div id="baseInfo" class="box-body">
				<table class="form-table form-table-2 form-table-info">
					<tbody>
						<tr class="form-group-sm">
							<th><label class="control-label ">订单编号<spring:message
										code="message.yanZheng.maoHao" /></label></th>
							<td>${payOrder.payOrderCode}</td>
							<th><label class="control-label ">订单名称<spring:message
										code="message.yanZheng.maoHao" /></label></th>
							<td>${payOrder.payOrderName}</td>
						</tr>
						<tr class="form-group-sm">
							<th><label class="control-label ">收款机构<spring:message
										code="message.yanZheng.maoHao" /></label></th>
							<td>${payOrder.collectOrgName}</td>
							<th><label class="control-label ">结算总金额<spring:message
										code="message.yanZheng.maoHao" /></label></th>
							<td>${payOrder.payOrderAmount}元</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<script type="text/javascript">
			$(
					function() {
						var rightLen = $('.progress-bar-right dl').length, rightHeight = $(
								'.progress-bar-right').height();
						$('.progress-bar-left').css('height', rightHeight);
						$('.order-progress-bar').css(
								'width',
								$('.progress-bar-left').width()
										+ $('.progress-bar-right').width());
						var p = 25, j = 0, m = 0;
						if (rightLen > 1) {
							while (j <= rightLen) {
								if (j == 2) {
									m = p;
								} else if (j > 2) {
									p += 5;
									m = p;
								}
								j++;
							}
							;
							$('.progress-bar-left dl').css('top', m + '%');
						} else if (rightLen == 1) {
							$('.progress-bar-left dl').css('top', m);
						}
					})
		</script>
		<div class="box box-primary">
			<div class="box-header with-border">
				<h3 class="box-title">
					<spring:message code="跟踪信息" />
				</h3>
				<div class="box-tools pull-right">
					<button class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
				</div>
			</div>
			<div class="box-body">
				<div class="order-progress-bar">
					<div class="progress-bar-right">
						<dl>
							<dd class="${(payOrder.payStatus >= -1 && payOrder.auditStatus >= 1)?'active':''}"></dd>
							<dt class="progress-bar5">
								<div>
									<p>已提交</p>
									<p>
										<fmt:formatDate value="${payOrder.submitTime }"
											type="both" pattern="yyyy-MM-dd" dateStyle="default" />
									</p>
									<p>
										<fmt:formatDate value="${payOrder.submitTime }"
											type="both" pattern="HH:mm:ss" dateStyle="default" />
									</p>
								</div>
							</dt>
							<c:if test="${payOrder.payStatus<=-1 && payOrder.auditStatus <= 1}">
								<dd></dd>
							</c:if>
							<c:if test="${payOrder.payStatus>=-1 && payOrder.auditStatus == 2}">
								<dd class="active"></dd>
							</c:if>
							<dt class="progress-bar5">
								<div>
									<p>审核通过</p>
									<p>
										<fmt:formatDate value="${payOrder.auditTime }"
											type="both" pattern="yyyy-MM-dd" dateStyle="default" />
									</p>
									<p>
										<fmt:formatDate value="${payOrder.auditTime }"
											type="both" pattern="HH:mm:ss" dateStyle="default" />
									</p>
								</div>
							</dt>
							<c:if test="${payOrder.payStatus<=-1 && payOrder.auditStatus <= 1}">
								<dd></dd>
							</c:if>
							<c:if test="${payOrder.payStatus>=0 && payOrder.auditStatus == 2}">
								<dd class="active"></dd>
							</c:if>
							<dt class="progress-bar5">
								<div>
									<p>已支付</p>
									<p>
										<fmt:formatDate value="${payOrder.synchrobankTime }"
											type="both" pattern="yyyy-MM-dd" dateStyle="default" />
									</p>
									<p>
										<fmt:formatDate value="${payOrder.synchrobankTime }"
											type="both" pattern="HH:mm:ss" dateStyle="default" />
									</p>
								</div>
							</dt>
						</dl>
						<dl>
							<dd class="${payOrder.payStatus>-1?'active':''}"></dd>
							<dt class="progress-bar5">
								<div>
									<p>未付款</p>
									<p>
										<fmt:formatDate value="${payOrder.synchrobankTime }"
											type="both" pattern="yyyy-MM-dd" dateStyle="default" />
									</p>
									<p>
										<fmt:formatDate value="${payOrder.synchrobankTime }"
											type="both" pattern="HH:mm:ss" dateStyle="default" />
									</p>
								</div>
							</dt>
							<c:if test="${payOrder.payStatus <= 0}">
								<dd></dd>
							</c:if>
							<c:if test="${payOrder.payStatus > 0}">
								<dd class="active"></dd>
							</c:if>
							<dt class="progress-bar5">
								<div>
									<p>正在付款给药械</p>
									<p>
										<fmt:formatDate value="${payOrder.payingCenterTime }"
											type="both" pattern="yyyy-MM-dd" dateStyle="default" />
									</p>
									<p>
										<fmt:formatDate value="${payOrder.payingCenterTime }"
											type="both" pattern="HH:mm:ss" dateStyle="default" />
									</p>
								</div>
							</dt>
							<c:if test="${payOrder.payStatus <= 1}">
								<dd></dd>
							</c:if>
							<c:if test="${payOrder.payStatus > 1}">
								<dd class="active"></dd>
							</c:if>
							<dt class="progress-bar5">
								<div>
									<p>付款给药械成功</p>
									<p>
										<fmt:formatDate value="${payOrder.payedCenterTime }"
											type="both" pattern="yyyy-MM-dd" dateStyle="default" />
									</p>
									<p>
										<fmt:formatDate value="${payOrder.payedCenterTime }"
											type="both" pattern="HH:mm:ss" dateStyle="default" />
									</p>
								</div>
							</dt>
							</dl>
						<dl>
							<c:if test="${payOrder.payStatus <= 2}">
								<dd></dd>
							</c:if>
							<c:if test="${payOrder.payStatus > 2}">
								<dd class="active"></dd>
							</c:if>
							<dt class="progress-bar5">
								<div>
									<p>正在付款给收款人</p>
									<p>
										<fmt:formatDate value="${payOrder.payingCompanyTime }"
											type="both" pattern="yyyy-MM-dd" dateStyle="default" />
									</p>
									<p>
										<fmt:formatDate value="${payOrder.payingCompanyTime }"
											type="both" pattern="HH:mm:ss" dateStyle="default" />
									</p>
								</div>
							</dt>
							<c:if test="${payOrder.payStatus <= 8}">
								<dd></dd>
							</c:if>
							<c:if test="${payOrder.payStatus > 8}">
								<dd class="active"></dd>
							</c:if>
							<dt class="progress-bar5">
								<div>
									<p>付款给收款人成功</p>
									<p>
										<fmt:formatDate value="${payOrder.payedCompanyTime }"
											type="both" pattern="yyyy-MM-dd" dateStyle="default" />
									</p>
									<p>
										<fmt:formatDate value="${payOrder.payedCompanyTime }"
											type="both" pattern="HH:mm:ss" dateStyle="default" />
									</p>
								</div>
							</dt>
							<c:if test="${payOrder.payStatus <= 9}">
								<dd></dd>
							</c:if>
							<c:if test="${payOrder.payStatus > 9}">
								<dd class="active"></dd>
							</c:if>
							<dt class="progress-bar5">
								<div>
									<p>收款人确认收款</p>
									<p>
										<fmt:formatDate value="${payOrder.confirmPayTime }"
											type="both" pattern="yyyy-MM-dd" dateStyle="default" />
									</p>
									<p>
										<fmt:formatDate value="${payOrder.confirmPayTime }"
											type="both" pattern="HH:mm:ss" dateStyle="default" />
									</p>
								</div>
							</dt>
						</dl>
					</div>
				</div>
			</div>
		</div>
		<div class="null-line"></div>
		<div class="modal-footer">
			<button type="button" onclick="back();"
				class="btn btn-primary btn-sm">
				<spring:message code="message.button.getBack" />
			</button>
		</div>
	</section>
</body>
<script type="text/javascript">
	// 返回
	function back() {
		var dialog = top.dialog.get(window);
		dialog.close();
	}
</script>
</html>