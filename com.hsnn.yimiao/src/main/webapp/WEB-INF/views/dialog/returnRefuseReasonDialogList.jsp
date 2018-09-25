<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-success">
	    	<div class="box-body">
		        <form id="searchForm" method="post">
		            <div class="input">
	                    <div class="textalign1"><spring:message code="drugpurRefuseResponseReason.refuseReason"/><spring:message code="message.yanZheng.maoHao"/></div>
	                    <div class="boxinput">
	                        <input type="text" class="textinput"  id="refuseReason" name="refuseReason"  placeholder="<spring:message code="drugpurRefuseResponseReason.refuseReason"/>" maxlength="50" />
	                    </div>
	                    
					</div>
			    </form>
	    	</div>
		</div>
		
		<div class="btn-control-box">
            <button type="button" onclick="add();" class="btn btn-success btn-sm"><spring:message code="message.button.add"/></button>
			<c:if test="${opt == 'manager' }">
	            <button type="button" onclick="del();" class="btn btn-danger btn-sm"><spring:message code="message.button.delete"/></button>
			</c:if>
            <button type="button" onclick="back();" class="btn btn-primary btn-sm"><spring:message code="message.button.getBack"/></button>
			<button id="search" type="button" class="btn btn-primary btn-sm" onclick="searchRefuseReason();"><spring:message code="message.button.seachSpacing"/></button>
		</div>
		
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
		
	</section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var obj ={
		"names": [
			'<spring:message code="drugpurRefuseResponseReason.id"/>',
			'<spring:message code="drugpurRefuseResponseReason.refuseReason"/>',
        ],
        "model": [
			{ name: "id", key:true, align: 'center' ,sortable: false, hidden:true},
	        { name: "refuseReason", align: 'center' ,sortable: false},
        ]      
	};
	var returnInfos = '${returnInfos}';
	var opt = '${opt}';
	var optionType = '${optionType}';
	var multiselectFlag = true;
	if(opt == 'choose') {
		multiselectFlag = false;
	}
	var tuihuo = <spring:eval expression="T(com.hsnn.medstgmini.util.enums.OptionType).getKeyByItemName('RETURN_AGREE')"></spring:eval>;
	$(function () {
    	$("#gridlist").jqGrid({
    		url: "${ctx}/dialog/getInfo.html",
    		colNames: obj.names,
	        colModel: obj.model,
            multiselect: multiselectFlag,
            caption: "<spring:message code='drugpurRefuseResponseReason.list'/>",
            postData: {"beanName":"drugpurRefuseResponseReasonManager", "companyIdPs":'${companyIdPs}'},
            gridComplete:function(){
                autoRNWidth("gridlist");
                $(".ui-jqgrid-bdiv table,.ui-jqgrid-htable").css("width",$(".ui-jqgrid-bdiv table").width()-1);
            },
            sortable:true,  //是否可排序
            sortname: "add_time",// 初始化默认排序字段（多个参数以逗号隔开）
            sortorder: "desc",
            jsonReader: {
                id: "id"
            },
            onSelectRow: function(id) {
            	if(!multiselectFlag) {
            		var refuseReason = $("#" + id).find("td[aria-describedby=gridlist_refuseReason]").attr("title");
            		returnInfos = eval(returnInfos);
            		$.each(returnInfos, function(i, v){
            			v.refuseReason = refuseReason;
            		});
    				$.HN.message.confirm('<spring:message code="message.refuse.return.ask"/>', '', '').on(function (e) {
    					if (e && checkData('${returnIds}', tuihuo)) {
    						$.post("${ctx}/drugpurReturn/confirmDrugpurRecent.html", 
    								{"returnInfos":serialize(returnInfos), "optionType":optionType}, function(result) {
    		                    if (result.success) {
    		                 	   closeMyDialog(result.success);
    		                 	   $.alert('<spring:message code="message.refuse.return.success"/>', '<spring:message code="message.HN.alert.type"/>', "success");
    		                    } else {
    		                 	   $.alert(result.msg || '<spring:message code="message.refuse.return.fail"/>', "error");
    		                    }
    	                	}, "json");
    					}
    		    	});
            	}
            }
        });
    	$(window).trigger("resize");
	}); 
	
	// 查询
	function searchRefuseReason() {
		var queryData = $("#searchForm").serializeJSON();
		$("#gridlist").jqGrid("setGridParam", {
			url: "${ctx}/dialog/getInfo.html",
			postData: queryData,//发送查询条件 
		}).trigger("reloadGrid");//重新载入
	}
	// 关闭弹窗
	function closeMyDialog(rowdata) {
		var dialog = top.dialog.get(window);
		dialog.close(rowdata);
		$("#searchForm")[0].reset();
		searchRefuseReason();
	    return false;
	} 
	// 新增拒绝理由
	function add() {
		$.HN.dialog.open({
            "id": "addRefuseResponseReason", 
            "title": "<spring:message code='message.button.add'/><spring:message code='drugpurRefuseResponseReason'/>", 
            "url": "${ctx}/dialog/toAddRefuseReasonDialogList.html?companyIdPs=${companyIdPs}",
            "data": {}, 
            "width": 1000, 
            "height": 200, 
			"closefunc":function(params) {
            	if(params) {
            		$("#gridlist").trigger('reloadGrid');//重新载入
				}
            }
        });
	}
	// 删除拒绝理由
	function del() {
		var orderDetailIds = $("#gridlist").jqGrid("getGridParam", "selarrrow");
		if(orderDetailIds.length > 0) {
			$.HN.message.confirm('<spring:message code="message.jieSuan.queDingShanChuMa"/>', '', '').on(function (e) {
				if (e) {
					$.post("${ctx}/drugpurRefuseResponseReason/delDrugpurRefuseResponseReason.html", {"ids":orderDetailIds.join(",")}, function(result) {
                       if (result.success) {
                    	   $.alert('<spring:message code="message.jieSuan.shanchuChengGong"/>', '<spring:message code="message.HN.alert.type"/>', "success");
                       } else {
                    	   $.alert(result.msg || "<spring:message code="message.jieSuan.shanchuShiBai"/>", "error");
                       }
                      $("#gridlist").trigger('reloadGrid');//重新载入
                   	}, "json");
	            }
	        });
		} else {
			$.alert('<spring:message code="message.HN.alert.pleaseSelectLine"/>', "warn");
		}
	}
	
	function checkData(returnIds, tuihuo) {
		var flag = true;
		$.ajax({
			url:"${ctx}/drugpurReturn/optionChecks.html", 
			data:{"ids":returnIds, "optionType":tuihuo},
			async:false,
			type:"POST",  
			dataType:"json",
			success: function(checkResult){
				if(checkResult.success) {
					flag = true;
				} else {
					flag = false;
					$.alert("数据状态不符，请重新选择拒绝数据！" || "<spring:message code='message.response.fail'/>", "error");
				}
			}
		});
		return flag;
	}
	
	// 返回
	function back() {
		var dialog = top.dialog.get(window);
		dialog.close();
	}
</script>
</html>