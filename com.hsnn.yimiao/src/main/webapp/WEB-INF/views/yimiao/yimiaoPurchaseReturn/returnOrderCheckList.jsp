<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
	<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

	<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
<section class="content-header">
	<h1><spring:message code="退货订单审核"/></h1>
	<ol class="breadcrumb">
		<li><a href="${ctx }/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
		<li class="active"><a href="#"><spring:message code="退货订单审核"/></a></li>
	</ol>
</section>
<section class="content">
	<div class=" box box-primary">
		<div class="box-body">
			<form action="${ctx }/yimiaoPurchaseOrder/getYimiaoPurchaseOrderData.html" id="searchForm" method="post" >
				<div class="input">
					<div class="textalign1">退货单名称<spring:message code="message.yanZheng.maoHao"/></div>
					<div class="boxinput">
						<input type="text" class="textinput"  id="orderName" name="orderName"  placeholder="订单名称" maxlength="50" />
					</div>
					<div class="textalign1">添加时间：</div>
					<div class="boxinput">
						<table style="width:100%" >
							<tr>
								<td style="width:50%;">
									<input class="textinput" id="startTime" name="startTime"  readonly="readonly"  placeholder="开始日期"
										   onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}'})"  />
								</td>
								<td>&nbsp;-&nbsp;</td>
								<td style="width:50%;">
									<input class="textinput" id="endTime" name="endTime"   type="text" readonly="readonly"   placeholder="结束日期"
										   onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}'})"  />
								</td>
							</tr>
						</table>
					</div>
					<div class="textalign1">订单状态<spring:message code="message.yanZheng.maoHao"/></div>
                    <div class="boxinput">
                        <select class="textinput" name="orderState">
                            <option value="">请选择</option>
							<c:forEach items="${enum:getEnumValues('com.hsnn.medstgmini.util.enums.ReturnOrderStatus')}" var="items" >
								<c:if test="${items.key==2||items.key==3}">
									<option value="${items.key }">${items.value}</option>
								</c:if>
							</c:forEach>
                        </select>
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
            '订单名称',
            '订单名称',
            '医疗机构名称',
            '医疗机构部门编号',
            '医疗机构部门名称',
            '订单类型',
            '订单ID',
            '订单金额',
            '订单备注',
            '添加时间',
            '提交时间',
            '提交人',
            '是否自动提交',
            '自动提交时间',
            '订单状态',
            '默认配送地址',
            '记录添加人id',
            '记录添加人',
            '最后一次更新记录人id',
            '最后一次更新记录人',
            '最后一次更新记录时间',
        ],
        "model": [
            { name: 'operate', width: 40, align: 'center',sortable: false,
                formatter:function(val, opts, rowdata){
                    var str =  "<a href='${ctx }/yimiaoPurchaseReturn/toCheckReturnDetailList.html?orderId=" + rowdata.retOrderId + "'  >详情</a>";
                    return str;
                }
            },
            { name: "retOrderId", key:true, sortable: false,hidden:true},
            { name: "orderName", sortable: false,align:'center'},
            { name: "hospitalId", sortable: false,hidden:true},
            { name: "hospitalName", sortable: false,hidden:true},
            { name: "hospitalDepartmentId", sortable: false,hidden:true},
            { name: "hospitalDepartmentName", sortable: false,hidden:true},
            { name: "orderType", sortable: false,hidden:true},
            { name: "orderAmount", sortable: false,align:'center',
                formatter:function(val, opts, rowdata){
                    if(val!=null){
                        return val.toFixed(3);
                    }else{
                        return "0.000";
                    }
                }
            },
            { name: "orderRemarks", sortable: false,hidden:true},
            { name: "addTime", sortable: false,align:'center',
                formatter:function(val, opts, rowdata){
                    return new Date(val).format('yyyy-MM-dd HH:mm:ss');
                }
            },
            { name: "submitTime", sortable: false,align:'center',hidden:true,
                formatter:function(val, opts, rowdata){
                    if (val != null) {
                        return new Date(val).format('yyyy-MM-dd HH:mm:ss');
                    } else {
                        return "暂未提交";
                    }
                }
            },
            { name: "subminter", sortable: false,hidden:true},
            { name: "isAutoSubmint", sortable: false,hidden:true},
            { name: "autoSubmitTime", sortable: false,hidden:true},
            { name: "orderState", sortable: false,align:'center',
                formatter : function(val, opts, rowdata) {
                    return val==null?"":${enum:getEnumJSON('com.hsnn.medstgmini.util.enums.orderStatus')}[val];
                }
            },
            { name: "defaultDistributeAddr", sortable: false,hidden:true},
            { name: "addUserId", sortable: false,hidden:true},
            { name: "addUserName", sortable: false,hidden:true},
            { name: "lastUpdateUserId", sortable: false,hidden:true},
            { name: "lastUpdateUserName", sortable: false,hidden:true},
            { name: "lastUpdateTime", sortable: false,hidden:true},
        ]
    };



    $(function(){
        $("#gridlist").jqGrid({
            url: "${ctx }/yimiaoPurchaseReturn/getReturnOrderData.html",
            colNames: obj.names,
            colModel: obj.model,
            multiselect: false,
            caption: "退货单审核记录列表"
        });
        $(window).trigger("resize");

        // 查询
        $("#search").click(function(){
            var queryData = $("#searchForm").serializeJSON();
            $("#gridlist").jqGrid("setGridParam", {
                url: "${ctx }/yimiaoPurchaseReturn/getReturnOrderData.html",
                postData: queryData,//发送查询条件
            }).trigger("reloadGrid");//重新载入
        });
    });

</script>
</html>