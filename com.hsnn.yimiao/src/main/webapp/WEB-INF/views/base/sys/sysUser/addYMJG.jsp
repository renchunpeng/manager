<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<div>
<section class="content">
	<div class="box box-primary center">
		<div class="box-header with-border">
		<h3 class="box-title">新增疫苗监管</h3>
			<div class="box-tools pull-right">
				<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
			</div>
		</div>
		<div class="box-body">
			<form id="addForm" action="addYMJG.html" method="post">
				<div class="box box-success ">
					<div id="basePage">
						<table class="form-table form-table-2 form-table-info"></table>
						<input type="text" style="display: none;" name="userType" value="6">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
							<tr>
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;">机构类型：</label></th>				
								<td colspan="3">
									<select class="form-control" id="heaBurType" name="heaBurType" style="width:150px;">
										<option value="">请选择</option>
										<option value="5">市卫计委</option>	
										<option value="4">市疾控中心</option>
									</select> 
								</td>
							</tr>
							<tr>
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;">机构名称：</label></th>	
								<td colspan="3"><input class="form-control" name="heaBurName" id="heaBurName" placeholder="机构名称" style="width:100%;"/></td>		
							</tr>
							<tr>
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;">所属地区：</label></th>				
								<td colspan="3">
									<select class="form-control" id="area1" name="area1" style="width:150px;">
										<option value="530000">云南省</option>	
									</select> 
									<select class="form-control" id="area2" name="area2" style="width:200px;"></select> 
									<input type="hidden" id="areaId" name="areaId">
								</td>
							</tr>
							<tr>
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;">申报代表姓名：</label></th>
								<td colspan="3"><input class="form-control" name="contactor" id="contactor" placeholder="申请代表姓名" style="width:100%;"/></td>	
							</tr>
							<tr>
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;">申报代表电话：</label></th>	
								<td colspan="3"><input class="form-control" name="cellphone" id="cellphone" placeholder="申请代表联系电话" style="width:100%;"/></td>
							</tr>									
							</tbody>								
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="box-footer text-center">
			<button type="button" class="btn btn-success" onclick="save()" value="确认" id="ok">确认</button>					
			<button type="button" class="btn btn-success" onclick="back()" value="确认">取消</button>
		</div>
	</div>
	</section>
	<%@ include file="/WEB-INF/component/commonJS.jsp"%>
	<script src="${ctx}/lib/js/validate/jquery.validate.js"></script>
	<script src="${ctx}/lib/js/validate.expand.js"></script>
	<script src="${ctx }/lib/js/PinYin.js"></script>
	<script type="text/javascript">
		 //判断是否为空
		function isNull(str) {
			if (str.trim() == "") {
				return true;
			}
			return false;
		}
		var s;
		function len(s) {
			var l = 0;
			var a = s.split("");
			for (var i = 0; i < a.length; i++) {
				if (a[i].charCodeAt(0) < 299) {
					l++;
				} else {
					l += 2;
				}
			}
			return l;
		}

		function valid() {
			if (isNull($("#heaBurName").val())) {
				$.alert("请输入监管机构名称!", "warn");
				return false;
			}
			var areaId2 = $("#area2").val();
			var areaId1 = $("#area1").val();
			if (isNull(areaId1) && isNull(areaId2)) {
				$.alert("请选择地区!", "warn");
				return false;
			}
			if (isNull($("#contactor").val())) {
				$.alert("请输入申报代表姓名!", "warn");
				return false;
			}
			if (len($("#contactor").val()) > 200) {
				$.alert("填写的申报代表姓名为字母或数字时,字符长度总和不能超过200,如全部是中文字符,则长度不能超过100","warn");
				return false;
			}
			if (isNull($("#cellphone").val())) {
				$.alert("请输入申报代表联系电话!", "warn");
				return false;
			}
			IdPhoneRe = /^(1\\d{10})|(0[1-9]{2,3}-[0-9]{5,10})|([1-9]{1}[0-9]{5,8})$/;
			if (!IdPhoneRe.test($("#cellphone").val())) {
				$.alert("联系电话格式不正确", "warn");
				return false;
			}
			if (len($("#cellphone").val()) > 11) {
				$.alert("填写的申请代表联系电话长度不得超过11", "warn");
				return false;
			}
			return true;
		}

		//保存
		function save() {
			if (!valid()) {
				return;
			}
	        var  areaId = $("#area2").val();
			if("" == areaId){
				areaId = $("#area1").val();
			}
	        $("#areaId").val(areaId);
			$.HN.message.confirm('确定要保存吗？', '', '').on(function(e) {
				if (e) {
					$("#addForm").ajaxSubmit({dataType : "json",
												timeout : 10000,
												success : function(result,statusText) {
														  		if (result.success) {
																	$.alert("添加成功！","success");			
																	var userType = 6;
																	window.top.dialog({"id" : "quality"}).close();	
																	window.top.dialog({"id" : "quality"}).remove();	
																	window.location.href = "/com.hsnn.std/sysUser/toCreateUserList.html?userType="+ userType;		
																} else {
																	$.alert(result.msg|| "保存失败！","error");					
																}
															}
											});

				}
			});
		}
		//返回
		function back() {
			window.top.dialog({"id" : "quality"}).close();
			window.top.dialog({"id" : "quality"}).remove();		
			window.location.href = "/com.hsnn.std/sysUser/toCreateUserList.html?userType="+ userType;				
		}
			
		//部门地区名称联动
		$("#area2").HNSelect({
             url: "${pageContext.request.contextPath}/selectController/getArea.html", data: { ID: '530000' }, defaultText: "<option value=''><spring:message code="请选择"/></option>",
         });
	</script>
</div>