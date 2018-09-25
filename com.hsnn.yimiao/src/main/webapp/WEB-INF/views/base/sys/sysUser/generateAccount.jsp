<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title></title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
    <link href="${ctx}/lib/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" />
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame" style="background-color:#fff ;">
    <section class="content" style="min-height: 138px;padding-bottom: 0px;">
        <div>
        <div class="box-body" style="height: 300px;" >
        	<div class="form-group form-group-xs " >
               <label for="bussinessShow" class="col-sm-0 control-label">确定生成账号吗？</label> 
			</div>
	        <div class="form-group form-group-xs" style="white-space:nowrap;">
               <label for="bussinessShow" class="col-sm-2 control-label">账号类型:</label>
	            <select id="bussinessShow" name="bussinessShow" style="width:100px;" > 
					<option value="1">业务账号</option>
				</select>					                            
			</div><br/>
         </div>
         <div class="userInfo"></div>
        </div>
    </section>
    <div class="modal-footer" style="padding-top: 5px;padding-bottom: 5px;">
    	<button type="button" class="btn btn-success btn-sm" id="config" onclick="ok();"><spring:message code='message.button.confirm'/></button>
        <button type="button" class="btn btn-danger btn-sm"  onclick="closeDialog();"><spring:message code="message.button.cancel" /></button>
     </div>
    <%@ include file="/WEB-INF/component/commonJS.jsp" %>    	
    <script type="text" id="test">
		<center>
			登录网址：<br/><span class="url"></span><br/>
			<div>机构账号：<span class="zhu"></span> 密码：<span class="psr"></span><br/></div>
		</center>
    </script>
    <script type="text/javascript">
    function print(){
    	$('.userInfo').jqprint();
    }
    function ok(){
    	$("#config").css("disabled","true");
    	 var show =$("#bussinessShow option:selected").val();
    	    var data = {
    	    		id:	"${id}",
    	    		userType:"${userType}",
    	    		areaId:"${areaId}",
    	    		companyType:"${companyType}",
    	    		name:"${name}",
    	    		heaBurType:"${heaBurType}",
    	    		fatherId:"${fatherId}",
    	    		drugPurchaseProperty:"${drugPurchaseProperty}",
    	    		bussinessShow:show,//账号类型
    	    		generateSubAccount:"0"//是否生成子账号
    	    }
  			$.post("${ctx}/sysUser/generateSubAccount.html",data, function(result) {
                    if (result.success) {
                        $(".box-body").hide();
                        $(".content").css("background","");
                        var html = template('test', result);
                        $('.userInfo').html(html);
                        $(".zhu").html(result.conditions.zhuUserName);
                        $(".psr").html(result.conditions.zhuPassword);
                        if(result.conditions.bussinessShow=='1'){
                            $(".psr1").html(result.conditions.zhuPassword1);
                            $(".psr2").html(result.conditions.zhuPassword2);
                        }
                        $(".url").html(result.conditions.url);
                        var temp= $(".btn-success");
                        temp.attr("onclick","print();");
                        temp.html("<spring:message code='message.button.print'/>");
                        $('.btn-danger').attr("onclick","afferCloseDialog();");
                        $(".userInfo").show();
                        top.$.HN.message.alert("账号生成成功！默认密码为111111", "", "success");
                    } else {
                        top.$.HN.message.alert("<spring:message code='message.HN.alert.fail'/>", "", "error");
                    }
                }, "json");
    }
	function closeDialog() {
       var dialog = top.dialog.get(window);
       dialog.remove(); // 主动销毁对话框
    }
	function afferCloseDialog() {
       var dialog = top.dialog.get(window);
       dialog.close();
       dialog.remove(); // 主动销毁对话框 
    }  
    </script>
</body>
</html>
