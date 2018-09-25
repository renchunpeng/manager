<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script charset="utf-8" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
    <title><c:out value="${systemTitle}"></c:out></title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <style type="text/css">
        div.sys-menubar { color: #fff; font-family: "微软雅黑"; max-height:50px; position:absolute; left: 0px; top: 0px; }
    	span.sys-menu { padding:14px 16px 15px 16px; display:block; float: left; cursor: pointer; font-size:15px; letter-spacing:3px;}
    	span.sys-focus { color:#000; background-color: #ecf0f5 !important; }
    	span.sys-menu:hover { background-color: #077fb1; }
    	ul.sys-left-menu { display: none; }
    	iframe { margin: 0px; padding-top: 5px; border: 0px; }
    	p.headtitle {
			padding:0px;
			margin:0px;
		 	margin-right:10px; 
			color:white;
			font-size:20px;
			font-family:"黑体";
			line-height:50px;
			float: left;
			width:300px;
		}
		.navbar-nav > li > a {
		    color: #fff; 
		    padding-bottom: 7px;
		    padding-top: 8px;
		}
		/*.nav .open > a, .nav .open > a:focus, .nav .open > a:hover {
		    color: #fff !important;
            background-color: #23272a !important;
		}*/
		.navbar-nav > li > a:hover, .navbar-nav > li > a:focus {
		   /*  color: #077fb1 ;
		    background-color: #23272a !important; */
		}
		span.lineDiv {
            width: 2px;
            height: 35px;
            position: relative;
            display: block;
            float: left;
            background: url("${ctx}/lib/img/mainMenuLine.png") no-repeat;
		}
		.main-header .logo {
		    width: 335px;
		}
		.main-header > .navbar {
		    margin-left: 335px;
		}
		.navbar-custom-menu .navbar-nav > li > a {
		    line-height: 43px;
		    padding-bottom: 0px;
		    padding-top: 0px;
		    color: #fff;
		}
		.main-sidebar, .left-side {
		    padding-top:70px;
		    width:185px;
		}
		.fixed .content-wrapper, .fixed .right-side {
		    padding-top: 44px;
		}
		.content-wrapper, .right-side, .main-footer {
		    margin-left: 185px;
		}
		span.hidden-xs {
		    display:inline-block !important;
		}
		.navbar-nav > .user-menu .user-image {
		    border-radius: 50% !important;
		    float: left !important;
		    height: 25px !important;
		    margin-right: 10px !important;
		    margin-top: 8px !important;
		    width: 25px !important;
		}
		@media (max-width: 767px) {
		    nav#menuNav { 
		        margin-top: -35px;
		    }
		}
    </style>
</head>
<body class="skin-blue sidebar-mini fixed">
    <div class="wrapper">
        <header class="main-header" style="max-height: 70px;" >
            <div style="background-color: #222d32;height:0px;overflow:hidden;"> 
                <span style="clear:both;"></span>
	        </div>
            <a href="#" class="logo" style="height:50px;padding:0px;" id="headLeft">
               <p class="headtitle tag1"><c:out value="${systemTitle}"></c:out></p>
            </a>
            <nav id="menuNav" class="navbar navbar-static-top" role="navigation" style="height:50px;min-height:50px;">
                <a id="toggleButton" class="sidebar-toggle" data-toggle="offcanvas" role="button" style="padding:18px 15px 18px 15px; line-height:normal;font-size:13px;float:left;margin-left:-42px;">
                    <span class="sr-only">菜单切换</span>
                </a>
                <div class="sys-menubar">
                	<c:if test="${ list != null }">
                	    <!-- <span class="lineDiv" style="margin-left:-2px;"></span>  -->
                	     <p class="headtitle tag2" hidden><c:out value="${systemTitle}"></c:out></p>
                		<c:forEach items="${list}" var="sys">
                			<span class="sys-menu" onclick="changeMenuList(this, 'sys-${sys.resourceId}');"><i class="${sys.icon}"></i><span>&nbsp;${sys.menuName}</span></span>
                			<!-- <span class="lineDiv"></span> -->
                		</c:forEach>
                	</c:if>
                	<span style="clear:both;"></span>
                </div>
                  <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav" style="margin-top: 7px;">
                        <!-- <li>
								<a style="cursor:pointer;" class="telephone-btn" data-toggle="tooltip" data-placement="bottom">
									<i class="fa fa-phone" style="background-color:#0095ea;padding:1px 4px;border-radius:2px;"></i>&nbsp;
									<span>电话咨询</span>
								</a>
							</li> -->
							<li>
								<%--  <a id="BizQQWPA" style="cursor:pointer;">
									<i class="qq-img" style="background-color:#9cdbff;padding:1px 4px;border-radius:2px;"></i>&nbsp;
									<span>平台咨询</span>
								</a>--%>
							</li>
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa fa-user" style="background-color:#3c8dbc;padding:1px 4px;border-radius:2px;"></i>&nbsp;
                                <span class="hidden-xs">${user.fatherName}</span>      
                            </a>
                        </li>
                        <li>
                            <a href="${ctx}/sysUser/toUpdateUserPassWordJsp.html" class="" target="mainframe"><i class="fa fa fa-lock" style="background-color:#00a65a;padding:1px 4px;border-radius:2px;"></i>&nbsp;修改密码</a>
                        </li>
                        <li>
                            <a href="javascript:logout(1);" class=""><i class="fa fa fa-ban" style="background-color:#dd4b39;padding:1px 4px;border-radius:2px;"></i>&nbsp;退出</a>
                        </li>
                        
                    </ul>
                </div>
            </nav>
            <span style="clear:both;"></span>
        </header>
        <aside class="main-sidebar">
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <div class="user-panel" style="padding-left:15px;padding-top:1px;padding-bottom:25px">
                    <div class="pull-left image">
                        <img src="lib/img/center.png" class="img-circle" alt="User Image" />
                    </div>
                    <div class="pull-left info" style="padding-left:15px;">
                        <p>${user.name}</p>
                        <a href="#" id="projNameTags"><i class="fa fa-circle text-success" ></i>在线</a>
                    </div>
                </div>

				<c:if test="${ list != null }">
               		<c:forEach items="${list}" var="sys">
               			<ul class="sidebar-menu sys-left-menu" id="sys-${sys.resourceId}">
               				<c:set var="menuList" value="${sys.children}" scope="request" />
               				<c:import url="menu.jsp" charEncoding="UTF-8"/>
               			</ul>
               		</c:forEach>
               	</c:if>
            </section>
        </aside>

        <div id="mainDiv" class="content-wrapper">
            <iframe class="main-frame embed-responsive-item" id="mainframe" name="mainframe" 
            		width="100%" height="500px" src="${ctx}/home.html"></iframe>
        </div>
        <%-- 
        <footer class="main-footer" style="height:20px;padding: 2px 10px;">
            <div class="pull-right hidden-xs">
                <b>Version</b> 2.0
            </div>
            <div style="font-family:Arial;font-size:11px"><strong>Copyright &copy; 2014-2015 <a href="#">HSNN</a>.</strong> All rights reserved.</div>
        </footer>
 --%>
		<div class="modal fade" id="agreementDialog" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content">
					<div class="modal-body">
						<div class="form-group form-group-xs">
					        <div class="col-sm-6.5 text-left" style="color:#dd4b39">是否同意协议</div>
				         </div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success btn-sm reSetPsr" id="closeAgreementDialog" data-dismiss="modal" disabled="disabled">(10)同意</button>
						<button type="button" class="btn btn-primary btn-sm" onclick="logout(2);" >不同意</button>
					</div>
				</div>
			</div>
		</div>
    </div>
    
    <%@ include file="/WEB-INF/component/commonJS.jsp" %>
    
    <script type="text/javascript">
    	function changeMenuList(obj, id) {
    		$("span.sys-menu").removeClass("sys-focus");
    		$(obj).addClass("sys-focus");
    		if (id) {
    			$("ul.sys-left-menu").hide();
        		$("#" + id).show();
    		}
    	}
    	
    	function changeBidProject(projName) {
    		$("#projNameTags").html(projName);
    	}
    	
    	$("span.sys-menu:first").click();
   		//按钮倒计时10秒可用  吴.丰
	    var thisInterval;//定时器
   		var countdown=9;
		var $btnAgree =$("#closeAgreementDialog");
		function settime() { 
			if (countdown == 0) { 
				clearInterval(thisInterval);
				$btnAgree.removeAttr("disabled").text("同意");
			} else { 
				$btnAgree.text("(" + countdown + ")同意");
				countdown--; 
			}
        }
		//页面加载完成
        $(document).ready(function() {
        	var titleA = '<p class="nowrap">综合科：0000-00000000</p>'
				+ '<p class="nowrap indent">0000-00000000</p>'
				+ '<p class="nowrap">药品科：0000-00000000(含传)</p>'
				+ '<p class="nowrap">耗材科：0000-00000000</p>'
				+ '<p class="nowrap">信息科：0000-00000000(含传)</p>'
				+ '<p class="nowrap">监管科：0000-00000000（含传）</p>';
			$(".telephone-btn").attr('title',titleA);
		 	$(".telephone-btn").tooltip({html : true });
		 	
    		var type = 0;
    		$("#toggleButton").click(function() {
    			var time=400;
    			$(".tag1").fadeToggle(time); 
				$(".tag2").fadeToggle(time);
    		});
    	/* 	<c:if test="${showht == 1}">
	    		$('#agreementDialog').modal({
	                keyboard: false,//当按下 escape 键时关闭模态框，设置为 false 时则按键无效
	                backdrop:false
	            }); 
			    //定时器
                thisInterval=setInterval(settime,1000);
	    		//同意
	    		$("#closeAgreementDialog").click(function() {
	    			$.post("${ctx}/stdPayContract/addStdPayContract.html?","", function(result) {
		        		
		            }, "json")
	    		});
    		</c:if> */
    		
    	});
    	
    	function logout(type) {
    		if(type == 1) {
    			$.HN.message.confirm('确定要退出吗？', '', '').on(function (e) {
        			if (e) {
        				document.location.href="${ctx}/logout.html";
        			}
        		});
    		}else {
    			document.location.href="${ctx}/logout.html";
    		}
    	};
    	/*菜单栏切换*/
        $(".skin-blue .treeview-menu > li > a").on('click',function(){
            $(".skin-blue .treeview-menu > li > a.active").removeClass('active');
            $(this).addClass('active');
        });
        //BizQQWPA.addCustom({aty: '1', a: '1001', nameAccount: 4006909895, selector: 'BizQQWPA'});
    </script>
    
</body>
</html>