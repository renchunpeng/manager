<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1>密码重置</h1>
		<ol class="breadcrumb">
			<li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#">密码重置</a></li>
			
		</ol>
	</section>
	<section class="content">
	
	 <div class=" box box-primary">
            <div class="box-body">
                <form id="serchForm">
                    <div class="input">
	                    <div class="textalign">岗位名称：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput" id="postName" name="postName" placeholder="岗位名称" maxlength="25" />
	                    </div>
	                    <div class="textalign1">用户姓名：</div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput" id="sysUserName" name="name" placeholder="用户姓名" maxlength="25" />
	                    </div>
                    </div>
                     </form>  
                </div>
             
            </div>
	
	<div class="btn-control-box">
			 <button type="button" class="btn btn-success btn-sm" onclick="search();"><spring:message code="message.button.seachSpacing" /></button>
		</div>
		
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
		
		<div class="modal fade" id="changePasswordDialog" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header bg-primary">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h5 class="modal-title">重置密码</h5>
					</div>
					<div class="modal-body">
						<!--  <div class="form-group form-group-xs">
							<label for="password" class="control-label">旧密码：</label>
							<input class="form-control" type="password" id="oldPassword" maxlength="127" />
						</div>
						-->
						<div class="form-group form-group-xs">
							<label for="password" class="control-label">新密码：</label>
							<input class="form-control" type="password" id="password" maxlength="127" />
						</div>
						<div class="form-group form-group-xs">
							<label for="passwordRepeat" class="control-label">确认密码：</label>
							<input class="form-control" type="password" id="passwordRepeat" maxlength="20" />
						</div>
						   <div class="form-group form-group-xs">
					        <label for="newpassword" class="col-sm-2 text-right"><i class="fa fa-exclamation-circle fa-lg" style="color:#dd4b39;"></i>&nbsp;<span style="color:#dd4b39;font-weight:600">提示 ：</span></label>					        
						    <div class="col-sm-6.5 text-left" style="color:#dd4b39">密码只能为6位长度的数字</div>
				         </div>
					</div>
					<div style="padding:0px 0px 30px 230px;">
						<button type="button" class="btn btn-primary btn-sm reSetPsr" onclick="submitPassword();">确  认</button>
						<button type="button" class="btn btn-danger btn-sm" id="closeChangePasswordDialog" data-dismiss="modal">关 闭</button>
					</div>
				</div>
			</div>
		</div>
		
	</section>
	<%@ include file="/WEB-INF/component/commonJS.jsp"%>
	<script src="${ctx}/lib/js/validate/jquery.validate.js"></script>
	<script src="${ctx}/lib/js/validate.expand.js"></script>
	<script type="text/javascript">
	 var id = "";
	 var userName = "";
	 var obj ={
 	 			"names": [
   	 	 			        '操作',
   	 	 	                '',
   	 		                '用户姓名',
   	 		              	'用户账号',
   	 		                '岗位名称',
   	 		                '用户状态'
    	                ],
 		        "model": [{ 
 		        	name: 'operate', width: 40, align: 'center',sortable: false,
 					formatter:function(val, opts, rowdata){
 						var str = '';
 						str += "<a href='javascript:changePassword(\""+rowdata.userId+"\",\""+rowdata.name+"\",\""+rowdata.email+"\",\""+rowdata.acctType+"\");'class='opIcon' title='密码重置'>密码重置</a>";
	                    return str;
	                 }
                 },{
                	 name: 'userId',
                	 key:true,
                	 hidden:true, 
                	 sortable: false
               	},{
               		name: 'name',
               		sortable: false
               	},{
               		name: 'userName',
               		sortable: false
               	},{
               		name: 'postName',
               		sortable: false
               	},{
               		name: 'userIsUsing',
               		sortable: false,
               		cellattr:function (rowId, val, rawObject, cm) {
                         if(val == '停用'){
                             return 'style="color:red"';
                         }
                    },
                    formatter:function(val, opts, rowdata){
                         if (rowdata.userIsUsing == 1){
                             return "<spring:message code="message.button.start"/>";
                         } else if (rowdata.userIsUsing == 0){
                             return "<spring:message code="message.button.stop"/>";
                         }
                     }
                 }]      
 	 		};
        $(function () {
        	$('.box-body :input').bind('keydown', function(event) {if (event.keyCode == "13") {search();}}).eq(0).focus();

            $("#gridlist").jqGrid({
                url: "${pageContext.request.contextPath}/resetPsw/getSysUserData.html",
                mtype: "post",
                contentType : 'application/json',
                datatype: "json",
                autowidth: true,
                height: 270,
                colNames: obj.names,
                colModel: obj.model,
                rowNum: 20,
                rowList: [10, 20, 50, 100],
                rownumbers: true,
                pager: "#gridpage",
                viewrecords: true,
                multiselect: false,
                caption: "用户列表",
                postData: {"orgId":"${orgId}","departmentId":"${departmentId}"},
                //序号宽度自动变化
                gridComplete:function(){
                	//序号列宽度自适应（参数为jqgridID）
                    autoRNWidth("gridlist");
                	//数据只有一条时默认选中（参数为jqgridID）
                    selectByOneData("gridlist");
                },

                jsonReader: {
                    repeatitems: false,
                    id: "ids"
                }
            });
            $("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
            $(window).trigger("resize");
        });

        //查询
        function search(pg) {
            var name = $("#sysUserName").val();
            var groupName = $("#groupName").val();
            var postName = $("#postName").val();
            var orgName = $("#orgName").val();
            $("#gridlist").jqGrid('setGridParam',{
                datatype:'json',
                postData:{	"name":name,
                			"departmentName":groupName,
                			"postName":postName,
                			"orgName":orgName
                        },
                        page : pg|1
            }).trigger("reloadGrid"); //重新载入
        }
        
     	function changePassword(userId,name,email,acctType) {
     		//账户类型 0 管理账户  邮件  1业务账户
     		if(acctType==0){
    	    	  $.HN.message.confirm("确定为"+name+"重置密码吗？", '', '').on(function (e) {
    	              if (e) {
    	            		$.post("${ctx}/resetPsw/sendEmail.html", {
    	            			"email" : email
    	            		}, function(result) {
    	            			if (result.success) {
    	            				top.$.HN.message.alert(result.msg, "", "success");
    	            			} else {
    	            				top.$.HN.message.alert(result.msg || "<spring:message code='message.HN.alert.fail'/>", "", "error");
    	            			}
    	            		}, "json");
    	    		}
    	       	  });
     		}else if(acctType==1){
     			id = userId || "";
     			userName = name;
     			$("#oldPassword").val("");
        		$("#password").val("");
        		$("#passwordRepeat").val("");
        		$("#changePasswordDialog").find(".modal-title").html('用户名称：'+name);
        		$('#changePasswordDialog').modal({
                    keyboard: true
                });
     		}else{
     			top.$.HN.message.alert("用户类型不存在", "", "warn");
     		}
     	}
     	
    	function submitPassword() {
			var password = $.trim($("#password").val());
			var passwordRepeat = $.trim($("#passwordRepeat").val());
			var parn =new RegExp("^[0-9]*$");
			
			
		     if (password == null || password == "") {
		         $.HN.message.alert("请输入新密码！", "", "warn");
		         return false;
		     } else if (!(parn.test(password))) {
		    	 $.HN.message.alert("密码只能为6位长度的数字", "消息", "warn");
		         return false;
		     } else if (password.length != 6) {
		         $.HN.message.alert("密码长度只能是6位！", "", "warn");
		         return false;
		     }
		     if (passwordRepeat == null || passwordRepeat == "") {
		         $.HN.message.alert("请输入确认密码！", "", "warn");
		         return false;
		     } else if (passwordRepeat != password ) {
		         $.HN.message.alert("确认密码与密码不一致！请重新输入确认密码", "", "warn");
		         return false;
		     }
	      	  $.HN.message.confirm("确定为"+userName+"重置密码吗?", '', '').on(function (e) {
	              if (e) {
	            		$.post("${ctx}/resetPsw/resetByWeb.html", {
	            			"userId" : (id || ""),
	            			//"oldPassword" : oldPassword,
	            			"password" : password,
	            			"passwordRepeat":passwordRepeat
	            		}, function(result) {
	            			if (result.success) {
	            				$("#closeChangePasswordDialog").click();
	            				$.HN.message.alert("操作成功！！", "消息", "success");
	            			} else {
	            				$.HN.message.alert(result.msg ||"操作失败！！", "消息", "error");
	            			}
	            		}, "json");
	    		}
	       	  });
       }

    </script>
</body>
</html>
