<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<style type="text/css">
#red{color:red}
</style>

</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1>疫苗新增</h1>
		<ol class="breadcrumb">
		
			<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#">疫苗管理</a></li>
			<li class="active"><a href="#">疫苗新增</a></li>
		</ol>
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">     
				<form role="form" id="addForm" class="form-horizontal" action="addYimiaoProcurecatalog.html" method="post">
					<!-- form start -->
					<div id="baseInfo" class="box-body">
						<table class="form-table form-table-2 form-table-info">
							<tbody>
								<tr class="form-group-sm">
									<th>
			                            <label class="control-label "><span name="red" id="red">*</span>疫苗编号：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="goodsId" name="goodsId"
	                            			value="${yimiaoProcurecatalogForm.goodsId}" placeholder="疫苗编号" type="text" style="width:220px">
			                        </td>
			                        <th>
			                            <label class="control-label "><span name="red" id="red">*</span><spring:message code="疫苗名称"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="productName" name="productName" style="width:220px"  onclick="mlBtn()"
	                            			value="${yimiaoProcurecatalogForm.productName}" placeholder="<spring:message code="疫苗名称"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th> 
			                            <label class="control-label "><span name="red" id="red">*</span><spring:message code="yimiaoProcurecatalog.outlook"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="outlook" name="outlook"  style="width:220px"
	                            			value="${yimiaoProcurecatalogForm.outlook}" placeholder="<spring:message code="yimiaoProcurecatalog.outlook"/>" type="text">
			                        </td>
			                        <th>
			                            <label class="control-label "><span name="red" id="red">*</span>生产企业：</label>
			                        </th>
			                        <td>
	                            			<input  type="text" id="companyNameSc" name="companyNameSc"   placeholder="生产企业"  style="width:220px"  value="${yimiaoProcurecatalogForm.companyNameSc}"  onclick="scBtn();"/>
	                            			<input class="form-control" id="companyIdSc"  name="companyIdSc"  style="width:220px;display:none" 
	                            			value="${yimiaoProcurecatalogForm.companyIdSc}" placeholder="<spring:message code="yimiaoProcurecatalog.companyIdSc"/>" type="text">
										    <input type="hidden" id="sortId" name="sortId">
										    <input type="hidden" id="productId" name="productId">
			                        </td>
								</tr>
								<tr class="form-group-sm">
									<th>
			                            <label class="control-label "><span name="red" id="red">*</span>最小制剂单位中标价格（元）：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="bidPrice" name="bidPrice"  style="width:220px"
	                            			value="${yimiaoProcurecatalogForm.bidPrice}" placeholder="最小制剂单位中标价格（元）" type="text">
	                            	</td>
									<th>
										<!-- 单位 -->
			                            <label class="control-label "><span name="red" id="red">*</span>计量<spring:message code="yimiaoProcurecatalog.unit"/>：</label>
			                        </th>
			                        <td>
			                        	<input class="form-control" id="unit" name="unit"  style="width:220px" 
	                            			value="${yimiaoProcurecatalogForm.unit}" placeholder="计量<spring:message code="yimiaoProcurecatalog.unit"/>" type="text">
			                        </td>
								</tr>
								<tr class="form-group-sm">
	                            	 <th>
			                            <label class="control-label "><span name="red" id="red">*</span>年度：</label>
			                        </th>
			                        <td colspan="3">
			                        	<select id="yimiaoYear" name="yimiaoYear" value="${yimiaoProcurecatalogForm.yimiaoYear}" type="text"  style="width:220px">
 										  <option value="2016年" <c:if test="${'2016年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2016年</option>  
  										  <option value="2017年" <c:if test="${'2017年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2017年</option>
  										  <option value="2018年" <c:if test="${'2018年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2018年</option>
  										  <option value="2019年" <c:if test="${'2019年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2019年</option>
  										  <option value="2020年" <c:if test="${'2020年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2020年</option>
  										  <option value="2021年" <c:if test="${'2021年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2021年</option>
  										  <option value="2022年" <c:if test="${'2022年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2022年</option>
  										  <option value="2023年" <c:if test="${'2023年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2023年</option>
  										  <option value="2024年" <c:if test="${'2024年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2024年</option>
  										  <option value="2025年" <c:if test="${'2025年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2025年</option>
  										  <option value="2026年" <c:if test="${'2026年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2026年</option>
  										  <option value="2027年" <c:if test="${'2027年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2027年</option>
  										  <option value="2028年" <c:if test="${'2028年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2028年</option>
  										  <option value="2029年" <c:if test="${'2029年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2029年</option>
  										  <option value="2030年" <c:if test="${'2030年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2030年</option>
  										  <option value="2031年" <c:if test="${'2031年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2031年</option>
  										  <option value="2032年" <c:if test="${'2032年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2032年</option>
  										  <option value="2033年" <c:if test="${'2033年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2033年</option>
  										  <option value="2034年" <c:if test="${'2034年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2034年</option>
  										  <option value="2035年" <c:if test="${'2035年' eq yimiaoProcurecatalogForm.yimiaoYear}">selected</c:if> >2035年</option>
			                        	</select>
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
	function save() {
		if(!$('#addForm').valid()) {
			return;
		}
	 	if(document.getElementById('goodsId').value=='') { 
			 alert('请输入疫苗编号！'); 
			 return;
		}
	 	if(document.getElementById('productName').value=='') { 
			 alert('请输入疫苗名称！'); 
			 return;
		}
	 	if(document.getElementById('unit').value=='') { 
			 alert('请输入计量单位！'); 
			 return;
		}
	 	if(document.getElementById('companyIdSc').value=='') { 
			 alert('请选择生产企业！'); 
			 return;
		}
	 	if(document.getElementById('companyNameSc').value=='') { 
			 alert('请选择生产企业！'); 
			 return;
		}
	 	if(document.getElementById('bidPrice').value=='') { 
			 alert('请输入采购单价！'); 
			 return;
		}
	 	if(document.getElementById('outlook').value=='') { 
			 alert('请输入规格！'); 
			 return;
		}
	 	if(document.getElementById('yimiaoYear').value=='') { 
			 alert('请选择年度！'); 
			 return;
		}
		$.HN.message.confirm('确定要保存吗？', '', '').on(function (e) {
			if (e) {
				$("#addForm").ajaxSubmit({
					dataType : "json",
             		timeout: 10000,
               		success: function(result,statusText) {
                   		if(result.success){
           	     			$.alert("添加成功！", "success", function() {
           	     				document.location.href="${ctx }/yimiaoProcurecatalog/toyimiaoAddList.html";
							});
                   		}else{
                   			$.alert(result.msg || "添加失败,疫苗编号已存在", "warn");
                   		}
					}
				});
			}
		});
	}
	
	function back() {
		document.location.href="${ctx }/yimiaoProcurecatalog/toyimiaoAddList.html";
	}	
	
	function scBtn(){
		 $.HN.dialog.open({
	            "id": "showScCompInfo", 
	            "title": "选择生产企业", 
	            "url": "${ctx}/yimiaoOrderdetailRet/toYimiaoSCList.html",
	            "data": {}, 
	            "width": 800, 
	            "height": 500, 
				"closefunc":function(params) {
					var scqy=document.getElementById("companyNameSc");
					var scqyid=document.getElementById("companyIdSc");
					if(params.companyName!=null&&params.companyId!=null){				
						scqy.value=params.companyName;
						scqyid.value=params.companyId;
					}
				}
	            
	       });  
	}

    function mlBtn(){
        $.HN.dialog.open({
            "id": "showMlInfo",
            "title": "选择疫苗名称和规格",
            "url": "${ctx}/yimiaoProcurecatalog/toSortList.html",
            "data": {},
            "width": 800,
            "height": 500,
            "closefunc":function(params) {
                if (params) {
                    $("#productName").val(params.productName);
                    $("#outlook").val(params.outlook);
                    $("#sortId").val(params.sortId);
                    $("#productId").val(params.productId);
                }
            }

        });
    }
</script>
</html>