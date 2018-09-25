<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>用户管理</title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">

<section class="content-header">
    <h1>密码找回</h1>
    <ol class="breadcrumb">
        <li><a href="${ctx}/home.html"><i class="fa fa-home"></i>首页</a></li>
        <li class="active"><a href="#">用户管理</a></li>
        <li class="active"><a href="#">密码找回</a></li>
    </ol>
</section>
<section class="content">
    <div class=" box box-primary">
        <div class="box-body">
            <form id="searchForm" action="${ctx }/sysUser/updatePwd.html" id="updateForm" method="post">
                <div class="input">
                    <div class="textalign1">用户账号<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="userName" name="userName" placeholder="用户账号" maxlength="30"
                               style="width:100%"/>
                    </div>
                    <div class="textalign">用户名称<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="name" name="name" placeholder="用户名称" maxlength="30"
                               style="width:100%"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="btn-control-box">
        <button id="searchBtn" type="button" class="btn btn-primary btn-sm" onclick="search();">查询</button>
    </div>
    <table class="jqgrid" id="gridlist"></table>
    <div id="gridpage"></div>
</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>
<script type="text/javascript">

    var obj = {
        "names": [
            '',
            '操作',
            '账号',
            '用户名称',
            '用户类型'
        ],
        "model": [
            {name: "userId", key: true, width: 100, align: 'center', sortable: false, hidden: true},
            {name: 'operate', width: 50, align: 'center', sortable: false,
                formatter: function (val, opts, rowdata) {
                    var str = '';
                    str += "<a href=\"javascript:void(0);\" onclick=\"updatePwdDialog('" + rowdata.userId + "');\" class=\"opIcon detailIcon\" title=\"修改密码\">修改密码</a>";
                    return str;
                }
            },
            {name: "userName", width: 150, align: 'center', sortable: false},
            {name: "name", width: 150, align: 'center', sortable: false},
            {name: "userType",width: 150,align: 'center',sortable: false,
                formatter: function (val, opts, rowdate) {
                    return val == null ? "-":{"1":"投标企业","2":"配送企业","4":"疾控中心","6":"监管机构"}[val];
                }
            }
        ]
    };
    $(function () {
        $("#gridlist").jqGrid({
            url: "${ctx}/sysUser/getSearchPwdData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: false,
            caption: "用户列表",
            rowNum: 20,
        });

    });
    // 查询
    function search() {
        var queryData = $("#searchForm").serializeJSON();
        $("#gridlist").jqGrid("setGridParam", {
            url: "${ctx}/sysUser/getSearchPwdData.html",
            postData: queryData,//发送查询条件
        }).trigger("reloadGrid");//重新载入
    }
    //修改密码弹窗
    function updatePwdDialog(id){
        $.HN.dialog.open({
           /* id:id,
            title:name,*/
            url:"${ctx}/sysUser/toUpdatePwdDialog.html?id="+id,
            width:"600px",
            height:"400px",
            closefunc:function(){
                // search();
            }
        });
    }
</script>
</html>