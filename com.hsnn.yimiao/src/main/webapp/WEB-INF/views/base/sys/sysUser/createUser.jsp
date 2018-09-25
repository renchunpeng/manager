<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>账号新增</title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
</head>
<body class="skin-blue-light sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
        <h1>账号新增</h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i>首页</a></li>
			<li class="active"><a href="#">账号管理</a></li>
            <li class="active"><a href="#">账号新增</a></li>
        </ol>
    </section>
    <section class="content">
    <form  id="addForm" role="form" class="form-horizontal" action="priceChangeDetail.home" method="post">
       <div class=" box box-success ">
                <div class="box-body">
                	<table class="form-table form-table-2 form-table-info">
                		<tbody>
							<tr class="form-group-sm">
								<th>
                       				<label class="control-label"><span class="required">*</span>账号类型：</label>
                       			</th>
                       			<td>
			                        <select class="textinput" name="userType" id="userType" style="width:200px">
			                       		<option value="1">企业</option>
			                       		<option value="4">疾控中心</option>
                                        <option value="6">监管机构</option>
			                        </select>
                       			</td>
							</tr>
                   	</tbody>
                   </table>
                <div class="box-footer text-center">
                    <button type="button" class="btn btn-primary btn-sm" onclick="nextStep();">下一步</button>
                </div>
               </div>
               </div>
            </form>
    </section>
	<%@ include file="/WEB-INF/component/commonJS.jsp"%>
	<script type="text/javascript">
	 function nextStep(){
     	var userType=$.trim($('#userType').val());   
     	window.location.href="${ctx }/sysUser/toCreateUserList.html?userType="+userType;
     }
    </script>
</body>
</html>