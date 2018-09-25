<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <title>首页</title>
    <link href="${ctx}/lib/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/lib/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/lib/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/lib/css/skins/skin-blue.css" rel="stylesheet" type="text/css" />
    <!--[if lt IE 9]>
        <script src="lib/js/html5shiv.min.js"></script>
        <script src="lib/js/respond.min.js"></script>
    <![endif]-->
    
</head>

                    
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
    <section class="content-header">
        <h1>
            首&nbsp;页
            <!--<small>Control panel</small>-->
        </h1>
        <ol class="breadcrumb">
            <li class="active"><i class="fa fa-home"></i> 首页</li>
            <!--<li class="active">Dashboard</li>-->
        </ol>
    </section>
    <section class="content">
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">最新公告</h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div><!-- /.box-tools -->
            </div><!-- /.box-header -->
            <div class="box-body home-message" id="sysNoticeList" style="margin-left:5px">
            </div>
            <div class="box-body home-message"  style="margin-left:5px;	color:red;font-size:12px; ">
           		
           		<div style="background:url(${ctx}/lib/img/jisumoshi.jpg) no-repeat;height:200px; "></div>
            </div>
            
        </div>
    </section>
        
  <%@ include file="/WEB-INF/component/commonJS.jsp" %>
    <script type="text/javascript">
        
        $(function () {
            
        	$.post("${ctx}/home/toHome.html",
     		function(result) {
     			if (result.success) {
     				var obj = result.rows;
      				if(obj && obj.sysNotice && obj.sysNotice.length > 0 ){
      				  for(var i=0;i<obj.sysNotice.length;i++){
      					  if(obj.sysNotice[i].url =="" ||obj.sysNotice[i].url==null){
      						 $("#sysNoticeList").append("<h5 onclick='show(\""+obj.sysNotice[i].sysNoticId+"\");'><span class='fa fa-angle-double-right' style='padding-right:4px;color:#3c8dbc'></span>"+obj.sysNotice[i].title+"<small class='pull-right'>"+obj.sysNotice[i].dateTime+"</small></h5>");
      					  }else{
      						 $("#sysNoticeList").append("<h5 onclick='url(\""+obj.sysNotice[i].url+"\");'><span class='fa fa-angle-double-right' style='padding-right:4px;color:#3c8dbc'></span>"+obj.sysNotice[i].title+"<small class='pull-right'>"+obj.sysNotice[i].dateTime+"</small></h5>");
      					  }
      					 
      				  }  
      				}
     			}
     			
     		}, "json");
        })
        
          function show(id){
        	window.location.href= "${ctx}/home/toHomeNoticeDetial.html?sysNoticeId=" +id;
        }
		 function url(url){
	        	window.top.location.href=url;
	        }
    </script>
</body>
</html>
