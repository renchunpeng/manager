<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title>用户书籍列表</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
    <style>
        a.opIcon {
            display: inline-block;
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		
	</section>
	<section class="content">
		<div class=" box box-primary">
			<div class="box-body">
				<form action="${ctx }/userBookList/getUserBookListData.html" id="searchForm" method="post" >
					<div class="input">
						<div class="textalign1">书名<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="name" name="name"  placeholder="请输入书名" maxlength="50" />
	                    </div>
	                    <div class="textalign">用户名<spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="userName" name="userName"  placeholder="请输入用户名" maxlength="50" />
	                    </div>
					</div>
				</form>
			</div>
		</div>
		<div class="btn-control-box">
			<button id="search" type="button" class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
		</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var obj ={
		"names": [
			'<spring:message code="message.jqGrid.cz"/>',
			'<spring:message code="userBookList.name"/>',<!-- 书名 -->
			'<spring:message code="userBookList.bookUrl"/>',<!-- 书籍地址 -->
			'<spring:message code="userBookList.imgUrl"/>',<!-- 书籍图片地址 -->
			'最后更新章节',<!-- 网站最后的章节，用于判断网站是否更新 -->
			'<spring:message code="userBookList.bookMark"/>',<!-- 最后一次阅读记录 -->
        ],
        "model": [
			{ name: 'operate', width: 40, align: 'center',sortable: false,
            	formatter:function(val, opts, rowdata){
                	var str =  "<a href='${ctx }/userBookList/toUpdate.html?id=" + rowdata.id + "' style='background:url(${ctx}/lib/img/icon/icon.png) no-repeat 0px 0px' class='opIcon' title='更新'></a>";
                    return str;
                }
        	},
		        { name: "name", sortable: false},<!-- 书名 -->
		        { name: "bookUrl", sortable: false},<!-- 书籍地址 -->
		        { name: "imgUrl", sortable: false},<!-- 书籍图片地址 -->
		        { name: "lastPageName", sortable: false},<!-- 网站最后的章节，用于判断网站是否更新 -->
		        { name: "bookMark", sortable: false},<!-- 最后一次阅读记录 -->
        ]      
	};
	
	
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/userBookList/getUserBookListData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: true,
            caption: "用户书籍列表"
        });
        $(window).trigger("resize");
		
		// 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			$("#gridlist").jqGrid("setGridParam", {
				url: "${ctx }/userBookList/getUserBookListData.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		});
	});
</script>
</html>