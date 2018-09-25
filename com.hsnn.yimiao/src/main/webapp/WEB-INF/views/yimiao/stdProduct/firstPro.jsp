<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code=" 一级目录新增"/></title>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
	<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
	<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
<section class="content-header">
	<h1><spring:message code="目录管理"/></h1>
	<ol class="breadcrumb">
		<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
		<li class="active"><a href="#"><spring:message code="目录管理"/></a></li>
		<li class="active"><a href="#"><spring:message code="一级目录新增"/></a></li>
	</ol>
</section>
<section class="content">
	<div class=" box box-success">
		<div class="box-body">
			<form role="form" id="addForm" class="form-horizontal" action="addStdProduct.html" method="post">
				<!-- form start -->
				<div id="baseInfo" class="box-body">
					<table class="form-table form-table-2 form-table-info">
						<tbody>
						<tr class="form-group-sm">
							<th>
								<label class="control-label ">一级目录：</label>
							</th>
							<td>
								<input class="form-control" style="width: 100%;" id="productName" name="productName"
									   value=""  type="text">
							</td>
						</tr>
						</tbody>
					</table>
					<div style="margin-top: 2%" >
						<button type="button" onclick="submitStdProduct();" class="btn btn-success btn-sm" style="margin-left: 43%;"><spring:message code="message.button.submit"/></button>
					</div>
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
    });

    function init() {
        $("#addForm").validate(${validate});
    }


    function submitStdProduct() {
        var productName=$("#productName").val();
        if(productName==""||productName==null){
            alert("请填写一级目录");
            return false;
        }

        $.HN.message.confirm('确定要提交吗？', '', '').on(function (e) {
            if (e) {
                $("#addForm").ajaxSubmit({
                    url:"${ctx }/stdProduct/addProduct.html",
                    dataType : "json",
                    timeout: 10000,
                    success: function(result,statusText) {
                        if(result.success){
                            $.alert("提交成功！", "success", function() {
                               document.location.href="${ctx }/stdProduct/addFirstPro.html";
                            });
                        }else{
                            $.alert(result.msg, "error");
                        }
                    }
                });
            }
        });
    }

    $("#chooseRegcode").click(function() {
        $(this).prop("disabled",true);
        $.HN.dialog.open({
            "id": "chooseRegcode",
            "title": "选择产品分类",
            "url": "${ctx}/stdSort/toList.html",
            "data": {},
            "width": 800,
            "height": 400,
            "closefunc":function(params) {
                $("#chooseRegcode").prop("disabled",false);
                if (params) {
                    $("#sortName").val(params.sortName);
                    $("#sortId").val(params.sortId);
                }
            }
        });
    });

    function back() {
        document.location.href="${ctx }/stdProduct/toList.html";
    }
</script>
</html>