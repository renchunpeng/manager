<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<div>
<section class="content">
	<div class="box box-primary center">
		<div class="box-header with-border">
		<h3 class="box-title">新增企业信息</h3>
			<div class="box-tools pull-right">
				<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
			</div>
		</div>
		<div class="box-body">
			<form id="addForm" action="addCompany.html" method="post">
				<div class="box box-success ">
					<div id="basePage">
						<table class="form-table form-table-2 form-table-info"></table>
						<input type="text" style="display: none;" name="userType" value="1">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
							<tr>
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;">企业类别：</label></th>
								<td colspan="3">
									<select class="form-control" id="companyType" name="companyType" style="width:200px;">
										<option value="">--请选择--</option>
										<option value="0">投标企业</option>
										<option value="1">配送企业</option>		
									</select>
								</td>
							</tr>
							<tr>
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;">企业名称：</label></th>	
								<td colspan="3"><input class="form-control" name="companyName" id="companyName" placeholder="企业名称" style="width:100%;"/></td>		
							</tr>
							<tr>
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;">地区：</label></th>				
								<td colspan="3">
									<select class="form-control" id="area1" name="area1" style="width:100px;">
										<option value="${province}">${provinceName}</option>	
									</select> 
									<select class="form-control" id="area2" name="area2" style="width:150px;"></select> 
									<select class="form-control" id="area3" name="" style="width:150px;"></select>
									<input type="hidden" id="areaId" name="areaId">
								</td>
							</tr>
							<tr>
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;">申报代表姓名：</label></th>
								<td colspan="3"><input class="form-control" name="representativeName" id="representativeName" placeholder="申请代表姓名" style="width:100%;"/></td>	
							</tr>
							<tr>	
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;">申报代表电话：</label></th>	
								<td colspan="3"><input class="form-control" name="representativePhone" id="representativePhone" placeholder="申请代表联系电话" style="width:100%;"/></td>
							</tr>					
							<tr>
								<th><span class="icon-required" style="color: red">*</span><label class="control-label " style="font-size: 13px;"><spring:message code="申报代表身份证" />：</label></th>			
								<td colspan="3"><input class="form-control" id="representativeIdNumber" name="representativeIdNumber" placeholder="申报代表身份证" style="width:100%;"/></td>
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
			if (isNull($("#companyType").val())) {
				$.alert("请选择企业类别!", "warn");
				return false;
			}
			if (isNull($("#companyName").val())) {
				$.alert("请输入企业名称!", "warn");
				return false;
			}
			var areaId3 = $("#area3").val();
			var areaId2 = $("#area2").val();
			var areaId1 = $("#area1").val();
			if (isNull(areaId1) && isNull(areaId2) && isNull(areaId3)) {
				$.alert("请选择地区!", "warn");
				return false;
			}
			if (isNull($("#representativeName").val())) {
				$.alert("请输入申报代表姓名!", "warn");
				return false;
			}
			if (len($("#representativeName").val()) > 200) {
				$.alert("填写的申报代表姓名为字母或数字时,字符长度总和不能超过200,如全部是中文字符,则长度不能超过100","warn");
				return false;
			}
			if (isNull($("#representativePhone").val())) {
				$.alert("请输入申报代表联系电话!", "warn");
				return false;
			}
			IdPhoneRe = /^(1\\d{10})|(0[1-9]{2,3}-[0-9]{5,10})|([1-9]{1}[0-9]{5,8})$/;
			if (!IdPhoneRe.test($("#representativePhone").val())) {
				$.alert("联系电话格式不正确", "warn");
				return false;
			}
			if (len($("#representativePhone").val()) > 11) {
				$.alert("填写的申请代表联系电话长度不得超过11", "warn");
				return false;
			}
			if (isNull($("#representativeIdNumber").val())) {
				$.alert("请输入申报代表身份证!", "warn");
				return false;
			}
			IdNumberRe = /^\d{15}|\d{18}$/;
			if (!IdNumberRe.test($("#representativeIdNumber").val())) {
				$.alert("填写的身份证号有误!", "warn");
				return false;
			}
			if (len($("#representativeIdNumber").val()) > 200) {
				$.alert("填写的申请代表身份证长度不能超过100", "warn");
				return false;
			}
			return true;
		}

		$(function() {
			$("#companyName").blur(function() {
				checkCompanyName();
			})
		})

		function checkCompanyName() {
			if (!isNull($("#companyName").val())) {
				$.post("${ctx}/stdCompany/getCompanyName.html", {
					"companyName" : $("#companyName").val()
				}, function(result) {
					if (!result) {
						$.alert('企业名称不能重复', "warn");
						$("#companyName").focus();
						return false;
					} else {
						return true;
					}
				}, "json");
			}
		}
		//保存
		function save() {
			if (!valid()) {
				return;
			}
			var areaId = $("#area3").val();
	        if("" == areaId){
	            areaId = $("#area2").val();
				if("" == areaId){
					areaId = $("#area1").val();
				}
	        }
	        $("#areaId").val(areaId);
			$.HN.message.confirm('确定要保存吗？', '', '').on(function(e) {
				if (e) {
					$("#addForm").ajaxSubmit({dataType : "json",
												timeout : 10000,
												success : function(result,statusText) {
														  		if (result.success) {
																	$.alert("添加成功！","success");			
																	var userType = 1;
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
		$("#area1").HNSelect({
		   url: "${pageContext.request.contextPath}/selectController/getArea.html", data: { ID: '000000' }, 
		   defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
		   defaultselect:"${province}",
		   func: function () {
		     $("#area2").HNSelect({
		     	parent_selector: "#area1", url: "${pageContext.request.contextPath}/selectController/getArea.html", dataid: "ID", 
		     	defaultText: "<option value=''><spring:message code="message.select.option"/></option>" ,
		     	func: function (){
		     		$("#area3").HNSelect({
		     			parent_selector: "#area2", 
		                url: "${pageContext.request.contextPath}/selectController/getArea.html", 
		                dataid: "ID", 
		                defaultText: "<option value=''><spring:message code="message.select.option"/></option>",
		     		});
		     	}
		     });
		   }
		});
	</script>
</div>