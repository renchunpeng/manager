<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="更新-待修改"/></title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1><spring:message code="更新-待修改"/></h1>
		<ol class="breadcrumb">
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#"><spring:message code="管理-待修改"/></a></li>
			<li class="active"><a href="#"><spring:message code="更新-待修改"/></a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">     
				<form role="form" id="updateForm" class="form-horizontal" action="updateUserBookList.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
										<!-- id -->
			                            <label class="control-label "><spring:message code="userBookList.id"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="id" name="id"
	                            			value="${userBookListForm.id}" placeholder="<spring:message code="userBookList.id"/>" type="text">
			                        </td>
									<th>
										<!-- 用户id -->
			                            <label class="control-label "><spring:message code="userBookList.userId"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="userId" name="userId"
	                            			value="${userBookListForm.userId}" placeholder="<spring:message code="userBookList.userId"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 书名 -->
			                            <label class="control-label "><spring:message code="userBookList.name"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="name" name="name"
	                            			value="${userBookListForm.name}" placeholder="<spring:message code="userBookList.name"/>" type="text">
			                        </td>
									<th>
										<!-- 书籍地址 -->
			                            <label class="control-label "><spring:message code="userBookList.bookUrl"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="bookUrl" name="bookUrl"
	                            			value="${userBookListForm.bookUrl}" placeholder="<spring:message code="userBookList.bookUrl"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 书籍图片地址 -->
			                            <label class="control-label "><spring:message code="userBookList.imgUrl"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="imgUrl" name="imgUrl"
	                            			value="${userBookListForm.imgUrl}" placeholder="<spring:message code="userBookList.imgUrl"/>" type="text">
			                        </td>
									<th>
										<!-- 网站最后的章节，用于判断网站是否更新 -->
			                            <label class="control-label "><spring:message code="userBookList.lastPageName"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="lastPageName" name="lastPageName"
	                            			value="${userBookListForm.lastPageName}" placeholder="<spring:message code="userBookList.lastPageName"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
										<!-- 最后一次阅读记录 -->
			                            <label class="control-label "><spring:message code="userBookList.bookMark"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="bookMark" name="bookMark"
	                            			value="${userBookListForm.bookMark}" placeholder="<spring:message code="userBookList.bookMark"/>" type="text">
			                        </td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
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
           	     				document.location.href="${ctx }/userBookList/toList.html";
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
		document.location.href="${ctx }/userBookList/toList.html";
	}
</script>
</html>