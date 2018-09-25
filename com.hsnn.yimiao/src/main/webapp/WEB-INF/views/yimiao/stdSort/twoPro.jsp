<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="二级目录新增"/></title>
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
		<li class="active"><a href="#"><spring:message code="二级目录新增"/></a></li>
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
						<input  id="productId" name="productId" value=""  type="hidden">
						<tr class="form-group-sm">
							<th>
								<label class="control-label ">一级目录：</label>
							</th>
							<td>
								<input class="form-control" style="width: 60%;"  id="productName" name="productName"
								readonly="readonly"	value=""  type="text"><button id="choosePro" type="button" style="height: 26px;" class="btn btn-primary btn-sm">请选择一级目录</button>
							</td>
						</tr>

						<tr class="form-group-sm">
							<th>
								<label class="control-label ">二级目录：</label>
							</th>
							<td>
								<input class="form-control" style="width: 100%;" id="outlook" name="outlook"
									   value=""  type="text">
							</td>
						</tr>
						</tbody>
					</table>
					<div style="margin-top: 2%" >
						<button type="button" onclick="submitStdSort();" class="btn btn-success btn-sm" style="margin-left: 43%;"><spring:message code="message.button.submit"/></button>
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


    function submitStdSort() {
        var productName=$("#productName").val();
        if(productName==""||productName==null){
            alert("请填写一级目录");
            return false;
        }
        var outlook=$("#outlook").val();
        if(outlook==""||outlook==null){
            alert("请填写二级目录");
            return false;
        }

        $.HN.message.confirm('确定要提交吗？', '', '').on(function (e) {
            if (e) {
                $("#addForm").ajaxSubmit({
                    url:"${ctx }/stdSort/addSort.html",
                    dataType : "json",
                    timeout: 10000,
                    success: function(result,statusText) {
                        if(result.success){
                            $.alert("提交成功！", "success", function() {
                               document.location.href="${ctx }/stdSort/addTwoPro.html";
                            });
                        }else{
                            $.alert(result.msg, "error");
                        }
                    }
                });
            }
        });
    }

    $("#choosePro").click(function() {
        var random = Math.floor(Math.random()*100);
        $.HN.dialog.open({
            "id":"showHosptial"+random,
            "title": "选择一级目录",
            "url": "${ctx}/stdSort/toProList.html",
            "data": {},
            "width":800,
            "height":500,
            "closefunc":function(params) {
                if (params) {
                    $("#productName").val(params.productName);
                    $("#productId").val(params.productId);
                }
            }
        });
    });

    function back() {
        document.location.href="${ctx }/stdProduct/toList.html";
    }
</script>
</html>