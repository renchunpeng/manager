<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<style type="text/css">
	div.divatab{
		width:100px;height:40px;float:left;border:2px solid #C6C9C9;border-radius:5px;text-align:center;line-height:35px;
		cursor:pointer;font-weight:900;
	}
	div.divchecked{
		background-color:#3C8DBC;color:#fff;
	}
	div.divnochecked{
		background-color:#E0E5ED;color:#777;
	}
</style>
<title>选择配送企业</title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	
	<section class="content" style="padding-top:0;">
		<div class=" box box-primary">
			
		     <div class="box-body">
				<div class="textalign">配送企业：</div>
				<div class="boxinput">
			                <input type="text" class="textinput" id="delCompName" name="delCompName" placeholder="配送企业" maxlength="100" />
			     </div>

			</div>
			
		</div>
		
		<div class="btn-control-box">
			 <button  type="button" id="search" class="btn btn-primary btn-sm" >查询</button>
			 <button  type="button" id="addCompany" onclick="addcompany()" class="btn btn-primary btn-sm" >新增配送企业</button>
		</div>
		
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
		<div class=" box box-warning bottongroup">
			<button  type="button" id="save" class="btn btn-primary btn-sm" >更新委托配送企业</button>
		</div>
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
     /* 归档号	企业名称 企业类型 	录入人	资质状态	复核人	审核人	初始化状态 */

	var obj ={
		"names": [
		    'companyId',
			'配送企业'
        ],
        "model": [
		        { name: 'companyId',  hidden:true, width: 80, align: 'center' ,sortable: false},
		        { name: 'companyNamePs',  hidden:false, width: 80, align: 'center' ,sortable: false}
        ]      
	};
	
	$(function(){
		$("#gridlist").jqGrid({
            url: "${ctx }/yimiaoCompany/getYimiaoCompanyPsData.html",
            colNames: obj.names,
            colModel: obj.model,
            pager: "#gridpage",
            caption: "配送企业列表",
            multiselect: true,//复选框
            rowNum: 20
        });
		
        $(window).trigger("resize");

		// 查询
		$("#search").click(function(){
			var delCompName=$.trim($("#delCompName").val());
			var isUsing = $.trim($("#isUsing").val());
			$("#gridlist").jqGrid("setGridParam", {
				mtype: "post",
				url: "${ctx }/yimiaoCompany/getYimiaoCompanyPsData.html",
				postData: {"delCompName":delCompName},//发送查询条件
			}).trigger("reloadGrid");//重新载入
		});

	 });

	$("#save").click(function(){
		var procurecatalogId = "${procurecatalogId}";
        var gridlist=  $("#gridlist");
        var list = [];
        var rowIds =gridlist.jqGrid("getGridParam", "selarrrow") || [];
        //遍历访问这个集合
        $(rowIds).each(function (index, id){
            //由id获得对应数据行
            var row = $("#gridlist").jqGrid('getRowData', id);
            var companyNamePs = row.companyNamePs;
            list.push({
                "companyNamePs": companyNamePs
			});
        })

        if (rowIds.length <= 0) {
            top.$.HN.message.alert("请至少选择一个委托配送企业！", "消息", "warn");
            return false;
        }

        $.HN.message.confirm('确定要更新吗？', '', '').on(function (e) {
            if(e){
                $.ajax({
                    url: "${ctx}/yimiaoProcurecatalog/updateCompanyNamePsByProcurecatalogId.html",
                    type: "post",
                    dataType: "json",
                    data:{"str":JSON.stringify(list),"procurecatalogId":procurecatalogId},
                    success:function (result) {
                        if(result.success){
                            $.alert("添加成功！", "success", function() {
                                closeDialog();

                            });
                        }else{
                            $.alert(result.msg || "<spring:message code="message.HN.alert.baoCunBai"/>", "error");
                        }
                    }

                });
            }
        });
    });

	function back(){
		window.location.href="${ctx }/yimiaoCompany/toList.html";
	}

	function  addcompany() {
        $.HN.dialog.open({
			"id": "showCompanyNamePs",
			"title": "新增配送企业",
			"url": "${ctx}/yimiaoCompany/toAddYimiaoCompPs.html",
			"data": {},
			"width": 850,
			"height": 240,
			"closefunc":function(params) {
                var delCompName=$.trim($("#delCompName").val());
                var isUsing = $.trim($("#isUsing").val());
                $("#gridlist").jqGrid("setGridParam", {
                    mtype: "post",
                    url: "${ctx }/yimiaoCompany/getYimiaoCompanyPsData.html",
                    //postData: {"delCompName":delCompName,"isUsing":isUsing},//发送查询条件
                }).trigger("reloadGrid");//重新载入
			}

        });
    }

     function closeDialog() {
         var dialog = top.dialog.get(window);
         dialog.close();
     }
</script>
</html>