<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>CA绑定</title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
<section class="content">
    <div class="box box-success">
    <div action="netonex" activex32_codebase="/lib/js/Ca/NetONEX32.v1.3.8.0.cab" activex64_codebase="/lib/js/Ca/NetONEX64.v1.3.8.0.cab" msi_codebase="/lib/js/Ca/NetONEX.v1.3.8.0.msi" version="1.3.8.0" logshowid="divlog">
        <object width="1" height="1" classid="CLSID:EC336339-69E2-411A-8DE3-7FF7798F8307" codebase="/lib/js/Ca/NetONEX32.v1.3.8.0.cab#Version=1,3,8,0"></object>
        <object width="1" height="1" classid="CLSID:EC336339-69E2-411A-8DE3-7FF7798F8307" codebase="/lib/js/Ca/NetONEX64.v1.3.8.0.cab#Version=1,3,8,0"></object>
    </div>
            <div class="box-body">
                        <form id="form1" method="post" enctype="multipart/form-data">
                        <table class="form-table form-table-1 form-table-info">
                            <tr class="form-group-sm">
                                <th>
                                    <label>用户编号：</label>
                                </th>
                                <td>
                                    <input id="id" name="id" value="${user.userId}" type="hidden">
                                    <label>${user.userId}</label>
                                </td>
                            </tr>
                            <tr class="form-group-sm" style="border-top:2px solid red;">
                                <th>
                                    <label>用户名称：</label>
                                </th>
                                <td>
                                    <input id="name" name="name" value="${user.userName}" type="hidden">
                                    <label>${user.userName}</label>
                                </td>
                            </tr>
                            <tr class="form-group-sm">
                                <th>
                                    <label>已经绑定的企业CA证书序列号：</label>
                                </th>
                                <td>
                                    <input id="CASerilnumber" name="CASerilnumber" value="${user.CAKey}"  type="hidden">
                                    <label>${user.CAKey}</label>
                                </td>
                            </tr>
                        </table>
                   <div class="box-footer text-center" >
                        <input type="button" value="绑定企业CA证书" class="btn-primary" id="btnSubmit" name="authName" >
                        <input type="button" value="获取CA证书" class="btn-primary" id="btngetCAinfo" name="btngetCAinfo" onclick="SetCertificate()">
                        <input type="button" value="关闭" class="btn-danger" id="btnBack" name="btnBack" onclick="back()">
                   </div>
                        <table class="form-table form-table-1 form-table-info">
                            <tr class="form-group-sm">
                                <th>
                                    <label>插入的CA证书序列号：</label>
                                </th>
                                <td>
                                    <textarea id="Certificate" name="Certificate" placeholder="签名证书ID" readonly="readonly" style="width: 100%"></textarea>
                                </td>
                            </tr>
                            <tr class="form-group-sm">
                                <th>
                                    <label>证书用户名：</label>
                                </th>
                                <td>
                                    <textarea id="CAUserName" name="CAUserName" placeholder="证书用户名" readonly="readonly" style="width: 100%"></textarea>

                                </td>
                            </tr>
                            <tr class="form-group-sm">
                                <th>
                                    <label>证书友好名：</label>
                                </th>
                                <td>
                                    <textarea id="FriendlyName" name="FriendlyName" placeholder="证书友好名" readonly="readonly" style="width: 100%"></textarea>
                                </td>
                            </tr>

                            <tr class="form-group-sm">
                                <th>
                                    <label>证书指纹：</label>
                                </th>
                                <td>
                                    <textarea id="ThumbprintSHA1" name="ThumbprintSHA1" placeholder="证书指纹" readonly="readonly" style="width: 100%"></textarea>
                                </td>
                            </tr>
                            <tr class="form-group-sm">
                                <th>
                                    <label>扩展信息(组织机构代码/法定代表人身份证)：</label>
                                </th>
                                <td>
                                    <textarea id="OrgCode" name="OrgCode" placeholder="扩展信息" readonly="readonly" style="width: 100%"></textarea>
                                </td>
                            </tr>


                            <tr class="form-group-sm">
                                <th>
                                    <label>生效时间：</label>
                                </th>
                                <td>
                                    <textarea id="NotBeforeSystemTime" name="NotBeforeSystemTime" placeholder="生效时间" readonly="readonly" style="width: 100%"></textarea>
                                </td>
                            </tr>
                            <tr class="form-group-sm">
                                <th>
                                    <label>失效时间：</label>
                                </th>
                                <td>
                                    <textarea id="NotAfterSystemTime" name="NotAfterSystemTime" placeholder="失效时间" readonly="readonly" style="width: 100%"></textarea>
                                </td>
                            </tr>
                            <tr class="form-group-sm">
                                <th>
                                    <label>主题项：</label>
                                </th>
                                <td>
                                    <textarea id="Subject" name="Subject" placeholder="主题项" readonly="readonly" style="width: 100%"></textarea>
                                </td>
                            </tr>
                        </table>
            </form>
          </div>
    </div>
</section>
<%@ include file="/WEB-INF/component/commonJS.jsp" %>
<script  src="${ctx}/lib/js/jquery.sprintf.js"></script>
<script  src="${ctx}/lib/js/objectclass.js"></script>
<script  src="${ctx}/lib/js/netonex.base.src.js"></script>
<script  src="${ctx}/lib/js/netonex.singleton.js"></script>
<script  src="${ctx}/lib/js/GZCACom.js"></script>
<script  src="${ctx}/lib/js/netonex.js"></script>

<script type="text/javascript">
    $(function () {
        CleanCertificate();
        SetCertificate();
    });

    $('#btnSubmit').click(function () {
        var base64Value = $("#Certificate").val();
        if ($.trim(base64Value) === '') {
            alert("未获取到CA证书签名内容", "e", "");
            return;
        }
        var CASerilnumber = $("#CASerilnumber").val();
        if(CASerilnumber == base64Value){
            alert("该CA已被该企业绑定", "e", "");
            return;
        }
        var userId = $("#id").val();
        $.HN.message.confirm("您确定要将该企业与CAkey进行绑定吗？",'','').on(function(e){
            if(e){
                $.post("${ctx}/yimiaoCA/bindCAData.html",{"id":userId,"serialnumber":base64Value},function(result) {
                    if (result.success) {
                        alert("绑定CA信息成功！", "<spring:message code="message.HN.alert.type"/>", "success");
                        back();
                    } else {
                        $.HN.message.alert(result.msg, "<spring:message code="message.HN.alert.type"/>", "error");
                    }
                }, "json")
            }
        });
    });

    var obj = new NetONEX();

    function CleanCertificate() {
        $("#Certificate").val('');              //证书序列号
        $("#FriendlyName").val('');                 //证书友好名
        $("#ThumbprintSHA1").val('');             //证书指纹(SHA1)
        $("#NotBeforeSystemTime").val('');   //生效时间
        $("#NotAfterSystemTime").val('');     //失效时间
        $("#Subject").val('');                           //主题项
        $("#CAUserName").val('');                 //用户名称
        $("#OrgCode").val('');                     //组织机构代码/身份证号
    }


    function getCAinfofromB64() {
        CleanCertificate();
        obj.setupObject();
        var b64 = '';

        var d = dialog({
            title: '请输入CABase64文本',
            content: '<input id="Base64txt" value="" />',
            ok: function () {
                var value = $('#Base64txt').val();
                if (value == null || value == '' || value == undefined)
                    return;
                this.close(value);
                this.remove();
            }
        });
        d.addEventListener('close', function () {
            if (this.returnValue == null || this.returnValue == '' || this.returnValue == undefined)
                return;
            b64 = this.returnValue;
            var colx = obj.getCertificateCollectionX();
            var crtx = colx.CreateCertificateBase64(b64);
            if (!crtx) {
                alert("不是有效的证书B64编码！");
                return;
            }

            $("#Certificate").val(crtx.SerialNumber);              //证书序列号
            $("#FriendlyName").val(crtx.FriendlyName);                 //证书友好名
            $("#ThumbprintSHA1").val(crtx.ThumbprintSHA1);             //证书指纹(SHA1)
            $("#NotBeforeSystemTime").val(crtx.NotBeforeSystemTime);   //生效时间
            $("#NotAfterSystemTime").val(crtx.NotAfterSystemTime);     //失效时间
            $("#Subject").val(crtx.Subject);                           //主题项

            $("#CAUserName").val(obj.getUserName(crtx));                 //用户名称
            $("#OrgCode").val(obj.getUserID(crtx));                     //组织机构代码/身份证号
        });
        d.show();
    }

    function SetCertificate() {
        CleanCertificate();
        var b641='';
        obj.setupObject();
        var crtx = GetCertificateByNetONEX(0x20);
        if (crtx == null) return;
        $("#Certificate").val(crtx.SerialNumber);              //证书序列号
        $("#FriendlyName").val(crtx.FriendlyName);                 //证书友好名
        $("#ThumbprintSHA1").val(crtx.ThumbprintSHA1);             //证书指纹(SHA1)
        $("#NotBeforeSystemTime").val(crtx.NotBeforeSystemTime);   //生效时间
        $("#NotAfterSystemTime").val(crtx.NotAfterSystemTime);     //失效时间
        $("#Subject").val(crtx.Subject);                           //主题项

        $("#CAUserName").val(obj.getUserName(crtx));                 //用户名称
        $("#OrgCode").val(obj.getUserID(crtx));                     //组织机构代码/身份证号
    };


    function GetCertificateByNetONEX(KeyUsage) {
        var colx = obj.getCertificateCollectionX();
        colx.Quiet = 1;
        colx.CF_KeyUsage = KeyUsage;          //密钥用途过滤，所有：1  签名证书:32  加密证书:16
        colx.CF_Issuer_Contains = "CN=GZCA";  //签发者主题项，贵州CA证书：CN=GZCA
        if (colx.Load() <= 0) {
            alert(obj.getGZCAErr());
            return;
        }
        var crtx;
        if (colx.Size > 1) {
            crtx = colx.SelectCertificateDialog();
        } else {
            crtx = colx.GetAt(0);
        }
        return crtx;
    };

    //返回
    function back() {
        var dialog = top.dialog.get(window);
        dialog.close();
        dialog.remove();
    }
</script>
</body>
</html>
