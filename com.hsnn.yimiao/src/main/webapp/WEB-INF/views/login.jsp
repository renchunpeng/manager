<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<title>系统登录</title>
	<script charset="utf-8" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
	<%@ include file="/WEB-INF/component/commonCSS.jsp" %>
	<style type="text/css">
		html, body {
			width: 100%;
			height: 100%;
			margin: 0px;
			padding: 0px;
			overflow: hidden;
			background-color: #ecf0f5;
		}
		div.bgPanel {
			width: 100%;
			height: 100%;
			z-index: 10px;
		}
		div.dialogDiv {
			min-width: 348px;
			min-height: 402px;
			overflow: auto;
		}
		table.bgTable {
			left: 0px;
			top: 0px;
			width: 100%;
			height: 100%;
			position: absolute;
			vertical-align: middle;
			text-align: center;
			border-collapse: collapse;
		}
		div.backBg {
			width:1105px;
			height: 295px;
			margin: auto;
			padding: 0px;
			position: relative;
			background: url("${ctx}/lib/img/login_bg.jpg") no-repeat;
		}
		div.backDialog {
			width:348px;
			height: 402px;
			margin: 20px 200px 0px 0px;
			padding: 0px;
			position: relative;
			background: url("${ctx}/lib/img/login_dialog.jpg") no-repeat;
		}
		div.backDialogCA {
			width:348px;
			height: 402px;
			margin: 20px 200px 0px 0px;
			padding: 0px;
			position: relative;
			background: url("${ctx}/lib/img/login_ca_dialog.jpg") no-repeat;
		}
		div.loginLabel {
			position: absolute;
			left: 30px;
			top: 20px;
			font-family: "黑体";
			color: #00587d;
			font-size: 22px;
		}
		div.inputtitle {
			    float: left;
			    width: 50%;
			    text-align: center;
			    font-weight: bold;
			    font-size: 16px;
			    color: #8d8d8d;
			    border-bottom: 3px solid #8d8d8d;
			    padding: 8px;
			    text-decoration: none;
			    text-transform: uppercase;
			    cursor: pointer;
			    margin-top: 20px;
		}
		div.active {
			color: #00587d;
    		border-bottom: 3px solid #0593ce;
		}
		h1.title {
			margin: auto;
			padding: 0px;
			text-align: left;
			font-family: "黑体";
			font-size: 40px;
			position: relative;
			margin-top: -30px;
			margin-bottom: 10px;
			width: 1105px;
		}
		div.errorTips {
			position: absolute;
			left: 130px;
			top: 28px;
			overflow: hidden;
			color: red;
			font-size: 14px;
		}
		input.username {
			position: absolute;
			left: 67px;
			top: 67px;
			width: 255px;
			height: 35px;
		}
		input.password {
			position: absolute;
			left: 67px;
			top: 131px;
			width: 255px;
			height: 35px;
		}
		input.answer {
			position: absolute;
			left: 67px;
			top: 195px;
			width: 127px;
			height: 35px;
		}
		img.captchaImg {
			position: absolute;
			left: 200px;
			top: 195px;
			width: 120px;
			height: 35px;
			cursor: pointer;
		}
		button.submit {
			position: absolute;
			left: 30px;
			top: 280px;
			width: 136px;
			height: 33px;
			cursor: pointer;
			font-size: 14px;
		}
		button.reset {
			position: absolute;
			left: 185px;
			top: 280px;
			width: 136px;
			height: 33px;
			cursor: pointer;
			font-size: 14px;
		}
		div.regBar {
			position: absolute;
			left: 30px;
			top: 250px;
			width: 290px;
			text-align: left;
		}
		div.regBarPsw {
			position: relative;
			left: 0px;
			top: 259px;
			width: 290px;
			text-align: left;
		}
		div.regBar * {
			display: inline-block;
			vertical-align: middle;
			margin: 0px;
			padding: 0px;
			font-family: "宋体";
			font-size: 12px;
			font-weight: normal !important;
		}
		a.reg {
			float: right;
		}
		div.footDiv {
		    font-family:Arial;
			font-size: 11px;
			position: absolute;
			width: 100%;
			text-align: center;
			bottom: 0px;
			height: 30px;
			line-height: 30px;
			left: 0px;
			z-index: 0px;
		}
		input.username, input.password, input.answer {
			border: 1px solid #BDD1D0 !important;
			background-color: white !important;
			padding-left: 10px !important;
			outline: none !important;
		}
		input:-webkit-autofill {
			-webkit-box-shadow: 0 0 0px 1000px white inset;
		}
	</style>
</head>
<body>

	<div class="bgPanel">
		<table class="bgTable">
			<tr>
				<td>
					<h1 class="title"><c:out value="${systemTitle}"></c:out></h1>
					<div class="backBg"></div>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="bgPanel dialogDiv">
		<table class="bgTable">
			<tr>
				<td align="right">
					<div id="backDialog" class="backDialog">
						<!-- <div class="loginLabel">用户登录</div> -->
						<div style="clear:both;width:320px;margin:15px 0 0 0;padding:0 25px 0 0;">
							<div class="inputtitle active" data-login="0" id="ptLogin">普通登录</div>
							<div class="inputtitle" data-login="1" id="caLogin">CA登陆</div>
						</div>
						<%-- <div class='errorTips ${ errorMsg != null and errorMsg != "" ? "fa fa-minus-circle" : "" }'>  ${ errorMsg }</div> --%>
						<form id="form" method="post" action="${ctx}/loginAuth.html" >
							<input class="username" type="text" id="username" name="username" value="" />
							<input class="password" type="password" id="password" name="password" value="" />
							<input class="answer" type="text" id="answer" name="answer" />
							<img class="captchaImg" id="captchaImg" src="${ctx}/captchaImg" onclick="refreshImg()" />
							<button type="button" class="btn btn-primary btn-sm submit" onclick="submitForm()">登  录</button>
							<button type="button" class="btn btn-danger btn-sm reset" onclick="resetForm()">重  置</button>
						</form>
							<div class='regBar errorTips ${ errorMsg != null and errorMsg != "" ? "fa fa-minus-circle" : "" }'>${ errorMsg }
							</div>

						<form id="CAform" method="post" action="${ctx}/CALogin.html" style="display:none;" >
							<ul style="position:absolute;left:25px;top:165px;text-align:left;">
								<li><a href="https://www.gzca.cc/down/ggzyjy/gzsyy/qd.rar" >请下载驱动</a></li>
								<li>请确认已经USB KEY插入到电脑上</li>
								<li>请在证书选择框中，选择您的数字证书</li>
								<li>为了安全，请在退出系统后及时拔出USB KEY</li>
							</ul>
							<input name="guid" id="guid" type="hidden" /><!--签名证书序列号 -->
							<input name="serialnumber" id="Serialnumber" type="hidden" /><!--签名证书序列号 -->
							<input name="signature" id="Signature" type="hidden" ><!--签名结果B64 -->
							<button type="button" class="btn btn-primary btn-sm submit" onclick="submitCAForm()" >登  录</button>
							<button type="button" class="btn btn-danger btn-sm reset" onclick="resetForm()">重  置</button>
						</form>
					</div>
				</td>
			</tr>
		</table>
	</div>
    <div action="netonex" netonexid="netonex" activex_codebase="路径/NetONEX.v1.3.0.0.cab" npapi_codebase="路径/npNetONE.v1.3.0.0.msi" version="1.3.0.0">
        <object width="1" height="1" classid="CLSID:EC336339-69E2-411A-8DE3-7FF7798F8307" codebase="NetONEX.v1.3.0.0.cab#Version=1,3,0,0"></object>
    </div>

			<div class="modal fade" id="changePasswordDialog" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header bg-primary">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h5 class="modal-title">请输入您要找回密码的账号</h5>
					</div>
					
					<div class="modal-body" >
						 <div class="form-group" style="width:348px;">
						      <input type="text" class="form-control" style="margin-top: 31px;" id="userNameFindKey" maxlength="50"  placeholder="请输入账号" >
						 </div>
						  <div class="form-group" style="width:348px;">
        					 <input class="form-control" type="text" id="answerFindKey"  placeholder="请输入验证码" />
        					 <br/>
        					 <img id="captchaImgFindKey" src="${ctx}/captchaImg" onclick="refreshImgFindKey()" />
						 </div>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-primary " onclick="submitUserName();">确  定</button>
					</div>
				</div>
			</div>
		</div>

	<%@ include file="/WEB-INF/component/commonJS.jsp" %>
	<script  src="${ctx}/lib/js/jquery.sprintf.js"></script>
	<script  src="${ctx}/lib/js/objectclass.js"></script>
	<script  src="${ctx}/lib/js/netonex.base.src.js"></script>
	<script  src="${ctx}/lib/js/netonex.singleton.js"></script>
	<%--<script  src="${ctx}/lib/js/GZCACom.js"></script>--%>
	
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			var titleA = '<p class="nowrap">综合科：0000-00000000</p>'
				+ '<p class="nowrap indent">0000-0000000</p>'
				+ '<p class="nowrap">药品科：0000-0000000(含传)</p>'
				+ '<p class="nowrap">耗材科：0000-0000000</p>'
				+ '<p class="nowrap">信息科：0000-0000000(含传)</p>'
				+ '<p class="nowrap">监管科：0000-0000000(含传)</p>';
			$(".telephone-btn").attr('title',titleA);
		 	$(".telephone-btn").tooltip({html : true });

		 	
			$("#caLogin").bind("click",function(){
				$("#backDialog").addClass("backDialogCA");
				$("#form").hide();
				$("#CAform").show();
				$("#caLogin").addClass("active");
				$("#ptLogin").removeClass("active");
			});
			
			$("#ptLogin").bind("click",function(){
				$("#backDialog").removeClass("backDialogCA");
				$("#form").show();
				$("#CAform").hide();
				$("#ptLogin").addClass("active");
				$("#caLogin").removeClass("active");
			});
			
			$(document).keydown(function(event){
				if (event.keyCode == 13){
					submitForm();
				}
			});
			
		});
	
		function resetForm() {
			$("#username").val("");
			$("#password").val("");
			$("#answer").val("");
		}
		
		function submitForm() {
			var ua = navigator.userAgent; 
			ua = ua.toLowerCase(); 
			var match = /(webkit)[ \/]([\w.]+)/.exec(ua) || 
			/(opera)(?:.*version)?[ \/]([\w.]+)/.exec(ua) || 
			/(msie) ([\w.]+)/.exec(ua) || 
			!/compatible/.test(ua) && /(mozilla)(?:.*? rv:([\w.]+))?/.exec(ua) || []; 
			//如果需要获取浏览器版本号：match[2] 
			switch(match[1]){ 
			case "msie": //ie 
			if (parseInt(match[2])<= 8) { //ie8
			alert("暂时不支持IE8.0及以下版本浏览器，请升级您的浏览器版本！"); 
			return;
			} 
			} 
			$("#form").submit();
		}

        function submitCAForm() {
            var Data ="${Data}";//随机码
            var obj = new NetONEX();
            obj.setupObject();
            var colx = obj.getCertificateCollectionX();
            colx.Quiet=1;
            colx.CF_KeyUsage="32";//签名证书
            if(colx.Load()<=0){
                alert(obj.getGZCAErr());
                return;
            }
            //var crtx;
            var crtx = colx.SelectCertificateDialog();
            if (!crtx) {
                alert("找不到有效证书！");
                return;
            }
            var Result = crtx.PKCS1String(Data);
            var Serialnumber = crtx.SerialNumber;
            if (!Result) {
                document.location.href="${ctx}/login.html";
                throw new Error(crtx.ErrorString);
            }
            $("#guid").val(Data);
            $("#Signature").val(Result); 	//签名结果
            $("#Serialnumber").val(Serialnumber); 	//签名证书序列号

            $("#CAform").submit();
        }
		
		function refreshImg() {
			$("#captchaImg").attr("src", "${ctx}/captchaImg?time="+new Date().getTime());
		}
		function findPsw(){
			$('#userName').val('');
			$('#changePasswordDialog').modal({
                keyboard: true
            });
		}
		function submitUserName(){
			  var username = $.trim($('#userNameFindKey').val());
			  if (username == null || username == "") {
			         $.HN.message.alert("请输入用户账号！", "", "warn");
			         return false;
			  }
			  var answerFindKey = $.trim($('#answerFindKey').val());
			  if (answerFindKey == null || answerFindKey == "") {
			         $.HN.message.alert("请输入验证码！", "", "warn");
			         return false;
			  }
      		$.post("${ctx}/resetPsw/sendEmail.html", {
      			"answer":answerFindKey,
    			"username" : username
    		}, function(result) {
    			if (result.success) {
    				top.$.HN.message.alert(result.msg, "", "success");
    				$("#userNameFindKey").val("");
    				$('#answerFindKey').val("");
    				$('#changePasswordDialog').modal('hide');
    			} else {
    				top.$.HN.message.alert(result.msg || "<spring:message code='message.HN.alert.fail'/>", "", "error");
    			}
    		}, "json");
		}
		 //BizQQWPA.addCustom({aty: '1', a: '1001', nameAccount: 4006909895, selector: 'BizQQWPA'});
	</script>
	
</body>
</html>