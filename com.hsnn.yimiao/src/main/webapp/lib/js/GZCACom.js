
//获取签名证书信息NetONEX
function GetCertificateByNetONEX(KeyUsage) {
    var obj = new NetONEX();
    var colx = obj.getCertificateCollectionX();
    colx.Quiet = 1;
    colx.CF_KeyUsage = KeyUsage;          //密钥用途过滤，所有：1  签名证书:32  加密证书:16
    colx.CF_Issuer_Contains = "CN=GZCA";  //签发者主题项，贵州CA证书：CN=GZCA
    if (colx.Load() <= 0) {
        alert(getGZCAErr());
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


function SignByCANoPIN(EncryptData) {
    var crtx = GetCertificateByNetONEX(0x20);
    if (!crtx) {
        return;
    }
    var Result = crtx.PKCS1String(EncryptData);
    if (!Result) {
        return;
    }
    return new Array(Result, crtx.SerialNumber);
};

//签名
function SignByCA(EncryptData) {
    return SignByCANoPIN(EncryptData);
};

function GZCAEncrypt(DecryptVal) {
    if (DecryptVal === '' || DecryptVal === null || DecryptVal === undefined) {
        alert("请输入要加密的原文！");
        return "";
    }
    return encrypt(true, DecryptVal);
}

//字符串加密
function GZCADecrypt(DecryptVal) {
    //if (DecryptVal === "") {
    //    alert("请输入要解密的密文！");
    //    return "";
    //}
    if (DecryptVal === '' || DecryptVal === null || DecryptVal === undefined) {
        return '';
    }
    return encrypt(false, DecryptVal);
}

function loadCertificate(colx) {
    var crtx = null;
    var crtxNumber = colx.Load();
    if (crtxNumber == 0) {
        alert("浏览器中没有发现数字证书！");
        //} else if (crtxNumber == 1) {
        //    crtx = colx.GetAt(0);
        //} else {
        //    crtx = colx.SelectCertificateDialog();
    }
    else if (colx.Size > 1) {
        crtx = colx.SelectCertificateDialog();
    } else {
        crtx = colx.GetAt(0);
    }

    return crtx;
}


function initialize() { //主动初始化,并返回证书序列号

    var obj = new NetONEX();
    colx = obj.getCertificateCollectionX();
    colx.Quiet = 1;
    colx.CF_KeyUsage = 32;          //密钥用途过滤，所有：1  签名证书:32  加密证书:16
    colx.CF_Issuer_Contains = "CN=GZCA";  //签发者主题项，贵州CA证书：CN=GZCA
    if (colx.Load() <= 0) {
        alert(getGZCAErr());
        return;
    }
    crtx = loadCertificate(colx);
    crtx.Quiet = 1;
    return crtx.SerialNumber;
}



//var fingerprint;
var colxFull = null;
var b64xFull = null;
var crtxFull = null;
function encrypt(enc, val) {
    if (val === '' || val === null || val === undefined) {
        return '';
    }

    if (!colxFull) {
        var obj = new NetONEX();
        colxFull = obj.getCertificateCollectionX();
        colxFull.Quiet = 1;
        colxFull.CF_KeyUsage = 16;          //密钥用途过滤，所有：1  签名证书:32  加密证书:16
        colxFull.CF_Issuer_Contains = "CN=GZCA";  //签发者主题项，贵州CA证书：CN=GZCA
        if (colxFull.Load() <= 0) {
            alert(getGZCAErr());
            return;
        }
        b64xFull = obj.getBase64X();
    }
    if (!b64xFull) {
        var obj = new NetONEX();
        b64xFull = obj.getBase64X();
    }

    if (enc) {
        if (!crtxFull) {
            crtxFull = loadCertificate(colxFull);
            crtxFull.Quiet = 1;
            if (!crtxFull) {
                alert("找不到有效证书！");
                return '无有效证书';
            }
        }
        if (getDocumentType(crtxFull) != '机构代码') {
            return '#code0001';
        }
        //var crtx = loadCertificate(colx);
        //crtx.Quiet = 1;
        var data = val;
        var b64data = b64xFull.EncodeString(data);
        var encryptedData = crtxFull.PublicEncrypt(b64data);
        return encryptedData;
    } else {

        var enData = val;
        try {
            if (!crtxFull) {
                crtxFull = loadCertificate(colxFull);
                crtxFull.Quiet = 1;
                if (!crtxFull) {
                    alert("找不到有效证书！");
                    return '无有效证书';
                }
            }
            if (crtxFull.IsPrivateKeyAccessible) {
                var decrypedData = crtxFull.PrivateDecrypt(enData);
                if (decrypedData) {
                    return (b64xFull.DecodeString(decrypedData));
                }
                else {
                    return '用户取消';
                }

            } else {
                alert("您选择的证书私钥不可访问");
            }
        } catch (e) {
            alert(e);
        }
    }
}



if (isIE() != true) {
    // Alert the that CAPICOM was not able to be installed
    alert("此浏览器不兼容CA,请使用IE浏览器登录.");
}

function isIE() {
    if (!!window.ActiveXObject || "ActiveXObject" in window)
        return true;
    else
        return false;
}

function getDocumentType(crtx) {
    if (crtx.Issuer.indexOf("CN=GZCA", 0) >= 0) {
        //组织机构:1.2.156.10260.4.1.4  个人:1.2.156.10260.4.1.1
        var oid = ['1.2.156.10260.4.1.4', '1.2.156.10260.4.1.1'];
        var d;
        for (var i in oid) {
            d = crtx.GetExtensionString(oid[i], 0);
            if (d) {
                if (oid[i] == '1.2.156.10260.4.1.4') {
                    return "机构代码";//机构代码
                } else if (oid[i] == '1.2.156.10260.4.1.1') {
                    return "身份证号";//身份证号
                }
            }
        }
    } else {
        return "";
    }
}

function getGZCAErr() {
    var ms = "未能成功加载数字证书，可能是如下原因：";
    ms += "\n1、证书介质USBKEY未插入电脑USB口;";
    ms += "\n2、未安装证书介质驱动（数字证书客户端）;";
    ms += "\n3、数字证书客户端未启动;";
    ms += "\n4、当前USB口故障，请换其他USB口;";
    ms += "\n5、插入的证书不是当前登录用户的证书。";
    ms += "\n\n如有疑问，请拨打贵州省电子证书有限公司客服电话：0851-86402317,4007000813。";
    return ms;
}
