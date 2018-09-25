<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
          name='viewport'>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
    <title>CA绑定</title>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
<section class="content">
    <div class="box box-success">
        <div class="box-body">
            <form class="form-inline">
                <div class="form-group form-inline searchform">
                    <label>用户编号：</label>
                    <input type="text" id="UserID" placeholder="用户编号">
                    <label>用户名称：</label>
                    <input type="text" id="UserName" placeholder="用户名称">
                    <div class="form-group form-group-sm searchgroup">
                        <label>是否绑定企业CA：</label>
                        <select class="form-control" name="IsBindCAInfo" id="IsBindCAInfo">
                            <option value="">请选择</option>
                            <option value="1">未绑定</option>
                            <option value="0">已绑定</option>
                        </select>
                    </div>
                    <%--<div class="form-group form-group-sm searchgroup">--%>
                        <%--<label>用户角色：</label><select class="form-control" name="RoleID" id="RoleID">--%>
                        <%--<option value="">请选择</option>--%>
                        <%--<option value="1">投标企业</option>--%>
                    <%--</select>--%>
                    <%--</div>--%>
                </div>

            </form>
                <button name="查询" class="success btn btn-primary btn-sm" id="btnQuery"
                        onclick="gridSearch()">查询
                </button>
        </div>
    </div>

    <table class="jqgrid" id="gridlist"></table>
    <div id="gridpage"></div>
</section>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>
<script type="text/javascript">
    var obj = {
        "names": [
            '用户编号',
            '用户名称',
            '企业CA证书',
            '是否绑定企业CA证书',
            '操作'

        ],
        "model": [
            {name: 'userId', align: "center", width: 100, key: true},
            {name: 'userName', align: "center", width: 100},
            {name: 'cakey', align: "center",hidden:true},
            {
                name: 'status', align: "center", width: 50, formatter: function (val, opts, row) {
                    if (row.cakey != null && row.cakey !== '') {
                        return '<font color="#FF6A6A"><strong>已绑定</strong></font>';
                    }
                    else {
                        return '未绑定';
                    }
                }
            },
            {
                name: 'operator', align: "center", width: 80, formatter: function (val, opts, row) {
                    var str = "";
                    if ((row.cakey == null || row.cakey === '') && (row.cakey == null || row.cakey === '')) {
                        str += "<a href='javascript:BindCA(\"" + row.userId + "\")'>绑定CA证书</a>";
                    }
                    else {
                        str += "<a href='javascript:EditBindCA(\"" + row.userId + "\")'>更换CA证书</a>";
                        str += "<a href='javascript:EmptyBindCA(\"" + row.userId + "\")'>清除CA绑定</a>";
                    }
                    return str;
                }
            }
        ]
    };
    $(function () {
        $("#gridlist").jqGrid({
            url: "${ctx }/yimiaoCA/getCAList.html",
            colNames: obj.names,
            colModel: obj.model,
            mtype: "POST",
            datatype: "json",
            caption: "CA绑定列表",
            height: 240,
            rowNum: 20,
            rowList: [10, 20, 50, 100],
            rownumbers: true,
            pager: "#gridpage",
            viewrecords: true,
            gridComplete: function () {
                autoRNWidth("gridlist");
            },
            jsonReader: {
                repeatitems: false,
                id: "ids"
            }
        });
        $(window).trigger("resize");
    });

    //查询
    function gridSearch() {
        var UserID = $.trim($("#UserID").val());
        var UserName = $.trim($("#UserName").val());
        var IsBindCAInfo = $.trim($("#IsBindCAInfo").val());
        $("#gridlist").jqGrid('setGridParam', {
            mtype: "POST",
            datatype: 'json',
            postData: {
                "UserID": UserID,
                "UserName": UserName,
                "IsBindCAInfo": IsBindCAInfo
            }
        }).trigger("reloadGrid"); //重新载入
    }

    function BindCA(userId) {
        $.HN.dialog.open({
            "id": userId,
            "title": "绑定CA证书",
            "url": "${ctx}/yimiaoCA/Bind.html?userId=" + userId,
            "data": {},
            "width": 1100,
            "height": 560,
            "closefunc": function (params) {
                gridSearch();
            }
        });
    }

    // add by ws
    function EditBindCA(userId) {
        $.HN.dialog.open({
            "id": userId,
            "title": "更换CA证书",
            "url": "${ctx}/yimiaoCA/Bind.html?userId=" + userId,
            "data": {},
            "width": 1100,
            "height": 560,
            "closefunc": function () {
                gridSearch();
            }
        });
    }

    //绑定情况一览
    function CABindShow() {
        $.HN.dialog.showModal({
            title: "企业CA绑定情况一览",
            url: "/BidCompany/CABind/CABindShow",
            width: 1000
        });
    }

    function EmptyBindCA(obj) {

        $.HN.message.confirm("是否确认清除【" + obj + "】用户的CA绑定？", "", "", "",
            '<label><input name="cdtid" value="1" type="radio" checked="checked">企业</label>&nbsp;&nbsp;<label><input name="cdtid" value="2"  type="radio">法人</label>&nbsp;&nbsp;<label><input name="cdtid" value="3" type="radio">全部</label>', 'cdtid').on(function (e) {
            if (e) {

                $.post("${ctx}/yimiaoCA/EmptyCA.html?userId="+obj, function (result) {
                    if (result.success) {
                        $.HN.message.alert("清除CA信息成功！", "<spring:message
                        code="message.HN.alert.type"/>", "success");
                        $("#gridlist").jqGrid('setGridParam', {
                            datatype: 'json'
                        }).trigger("reloadGrid");
                    } else {
                        $.HN.message.alert(result.msg, "<spring:message code="message.HN.alert.type"/>", "error");
                    }
                }, "json")
            }

        });
    }
</script>
<%--}--%>

</body>
</html>
