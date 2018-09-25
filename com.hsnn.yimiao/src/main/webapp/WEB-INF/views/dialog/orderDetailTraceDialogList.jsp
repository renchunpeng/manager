<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
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
			
			.minheight0,
			.minheight0>* {
				min-height: 0;
			}
			.overflow-hidden>* {
				float: left;
			}
			#divPopBox {}
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
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div>
            </div>
            <div id="baseInfo" class="box-body">
            	<table class="form-table form-table-2 form-table-info">
            		<tbody>
						<tr class="form-group-sm">
							<th>
	                            <label class="control-label "><spring:message code="drugpurDistribute.orderName"/><spring:message code="message.yanZheng.maoHao"/></label>
	                        </th>
	                        <td>${orderDetail.orderName}</td>
	                        <th>
	                        	<label class="control-label "><spring:message code="配送地址"/><spring:message code="message.yanZheng.maoHao"/></label>
	                        </th>	
	                        <td>${orderDetail.detailDistributeAddress}</td>
						</tr>
						<tr class="form-group-sm">
							<th>
	                            <label class="control-label "><spring:message code="配送企业"/><spring:message code="message.yanZheng.maoHao"/></label>
	                        </th>
	                        <td>${orderDetail.companyNamePs}</td>
	                        <th>
	                        	<label class="control-label "><spring:message code="产品ID"/><spring:message code="message.yanZheng.maoHao"/></label>
	                        </th>	
	                        <td>${orderDetail.goodsId}</td>
						</tr>
					</tbody>	
            	</table>
            </div>
		</div>
		<script type="text/javascript">
		$(function(){
			var rightLen = $('.progress-bar-right dl').length,
				rightHeight = $('.progress-bar-right').height();
			$('.progress-bar-left').css('height',rightHeight);
			$('.order-progress-bar').css('width',$('.progress-bar-left').width() + $('.progress-bar-right').width());
			var p = 25, j = 0,m = 0;
			if(rightLen > 1){
				while ( j <= rightLen ){
					if(j == 2){
						m=p;
					}else if(j > 2){
						p += 5;
						m = p;
					}
					j++;
				};
				$('.progress-bar-left dl').css('top', m +'%');
			}else if( rightLen == 1){
				$('.progress-bar-left dl').css('top',m);
			}
		})
		</script>
		<div class="box box-primary">
			<div class="box-header with-border">
                <h3 class="box-title"><spring:message code="跟踪信息"/></h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div>
            </div>
            <div class="box-body">
				<div class="order-progress-bar">
					<div class="progress-bar-left">
						<dl>
							<dd class="${orderDetail.orderdetailState>=1?'active':''}"></dd>
							<dt class="progress-bar1">
								<div>
									<p>已提交待响应</p>
									<c:if test="${orderDetail.orderdetailState>=1}">
										<p><fmt:formatDate value="${orderDetail.submitTime}" type="both" pattern="yyyy-MM-dd" dateStyle="default"/></p>
										<p><fmt:formatDate value="${orderDetail.submitTime}" type="both" pattern="HH:mm:ss" dateStyle="default"/></p>
									</c:if>
								</div>
							</dt>
							<dd class="${orderDetail.orderdetailState >=2?'active':''}${orderDetail.orderdetailState eq 3?' bar-no':''}"></dd>
							<dt class="progress-bar2">
								<div>
									<p>${orderDetail.orderdetailState eq 3?'拒绝配送':'已响应待配送'}</p>
									<c:if test="${orderDetail.orderdetailState >=2}">
										<p><fmt:formatDate value="${orderDetail.confirmTime}" type="both" pattern="yyyy-MM-dd" dateStyle="default"/></p>
										<p><fmt:formatDate value="${orderDetail.confirmTime}" type="both" pattern="HH:mm:ss" dateStyle="default"/></p>
									</c:if>
								</div>
							</dt>
						</dl>
					</div>
					<!-- 配送环节 -->
					<div class="progress-bar-right">
						<c:choose>
							<c:when test="${orderDetail.orderdetailState <4}">
								<dl>
									<dd></dd>
									<dt class="progress-bar3">
										<div>
											<p>未配送</p>
										</div>
									</dt>
									<dd></dd>
									<dt class="progress-bar4">
										<div>
											<p>未收货</p>
											<p></p>
											<p></p>
										</div>
									</dt>
								</dl>
							</c:when>
							<c:when test="${orderDetail.orderdetailState >3}">
							  <c:forEach items="${distributes}" var="distribute" varStatus="eStatus">
							    <dl>
							  	  <dd class="active"></dd>
								  <dt class="progress-bar3">
									<div>
										<p>已配送${distribute.distributeCount}</p>
										<p><fmt:formatDate value="${distribute.distributeTime }" type="both" pattern="yyyy-MM-dd" dateStyle="default"/></p>
										<p><fmt:formatDate value="${distribute.distributeTime }" type="both" pattern="HH:mm:ss" dateStyle="default"/></p>
										<p>发票号：${distribute.invoiceId}</p>
									</div>
								  </dt>
								  <c:if test="${distribute.distributeState eq 0}">
									<span style="position: absolute;margin-top: 13px;margin-left: 19px;"><a href="javascript:showDistributeLogistics('${distribute.distributeId }');">查看物流</a></span>
								  	 <dd></dd><!-- 已配送待入库(未收货) -->
								  </c:if>
								  <c:if test="${distribute.distributeState eq 1}">
								  	 <dd class="active"></dd><!-- 已到货(已收货) -->
								  </c:if>
								  <c:if test="${distribute.distributeState eq 2}">
								  	 <!-- 不到货(拒绝配送) -->
								  	 <dd class="active bar-no"></dd>
								  </c:if>
								  <dt class="progress-bar4">
									<div>
										<c:if test="${distribute.distributeState eq 0}">
										  <p>未收货</p>
										  <p></p>
										  <p></p>
										</c:if>
										<c:if test="${distribute.distributeState eq 1}">
										  <p>已收货${distribute.warehouseCount}</p>
										  <p><fmt:formatDate value="${distribute.warehouseTime }" type="both" pattern="yyyy-MM-dd" dateStyle="default"/></p>
										  <p><fmt:formatDate value="${distribute.warehouseTime }" type="both" pattern="HH:mm:ss" dateStyle="default"/></p>
										</c:if>
										<c:if test="${distribute.distributeState eq 2}">
										  <p>拒绝收货</p>
										  <p><fmt:formatDate value="${distribute.warehouseTime }" type="both" pattern="yyyy-MM-dd" dateStyle="default"/></p>
										  <p><fmt:formatDate value="${distribute.warehouseTime }" type="both" pattern="HH:mm:ss" dateStyle="default"/></p>
										</c:if>
									</div>
								  </dt>
								</dl>
							  </c:forEach>
							</c:when>
						</c:choose>
					</div>
				</div>	
			</div>
		</div>
		<div class="null-line"></div>
		<div class="modal-footer">
            <button type="button" onclick="back();" class="btn btn-primary btn-sm"><spring:message code="message.button.getBack"/></button>
        </div>
	</section>
</body>
<script type="text/javascript">
	function showDistributeLogistics(distributeId) {
		$.HN.dialog.open({
            "id": "showDistributeLogistics" + new Date(), 
            "title": "<spring:message code='drugpurDistributeLogistics.show'/>", 
            "url": "${ctx}/drugpurDistributeLogistics/toShowDistributeLogisticsDialog.html?distributeId=" + distributeId,
            "data": {}, 
            "width": 700, 
            "height": 450, 
			"closefunc":function(params) {
            	if(params) {
            		$("#gridlist").trigger('reloadGrid');//重新载入
				}
            }
        });
	}
	// 关闭弹窗
	function closeMyDialog(rowdata) {
		var dialog = top.dialog.get(window);
		dialog.close(rowdata);
	    return false;
	}
	
	// 返回
	function back() {
		var dialog = top.dialog.get(window);
		dialog.close();
	}
</script>
</html>