<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
<style type="text/css">
	.content {
		min-height: 0px;
	}
	.tr-title>td{
	    text-align: center;
    	font-weight: bold;
    }
</style>
</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content">
		<div class=" box box-success">
	    	<div class="box-body">
				<div id="baseInfo" class="box-body">
					<table class="form-table form-table-2 form-table-info">
						<thead>
							<tr class="tr-title">
								<td>排序字段</td>
								<td>排序方式</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody id="tableDatas">
							<tr class="form-group-sm">
								<td>
									<div class="col-div">
										<select id="column" name="column" class="column" style="width: 125px;">
											<option value="purchase_count">采购数量</option>
											<option value="purchase_price">采购价</option>
											<option value="goods_id">产品ID</option>
											<option value="product_name">通用名</option>
											<option value="goods_name">商品名</option>
											<option value="medicinemodel">剂型</option>
											<option value="outlook">规格</option>
											<option value="factor">转换比</option>
											<option value="material_name">材质</option>
											<option value="unit">单位</option>
											<option value="company_name_sc">生产企业</option>
											<option value="company_name_ps">配送企业名称</option>
											<option value="source_name">来源名称</option>
											<option value="detail_distribute_address">订单明细配送地址</option>
											<option value="add_time">添加时间</option>
										</select>
									</div>
								</td>
		                        <td>
		                        	<select name="direction" id="direction" style="width: 125px;">
										<option value="ASC">升序</option>
										<option value="DESC">降序</option>
									</select>
		                        </td>
		                        <td style="text-align: center;">
									<a href="###" class="remove">删除</a>
								</td>
							</tr>
						</tbody>
					</table>
					<div style="margin-top: 5px;text-align: center;margin-bottom: -8px;">
			            <input id="saveCookie" type="checkbox" checked="true" />
			            <span>保存查询条件至cookie中。</span>
			        </div>
				</div>
				<!-- form end -->
				<div class="box-footer text-center">
                    <button type="button" id="btnAdd" class="btn btn-success btn-sm">新增</button>
                    <button type="button" onclick="save();" class="btn btn-success btn-sm">确定</button>
                    <button type="button" onclick="back();" class="btn btn-primary btn-sm">取消</button>
                </div>
	    	</div>
		</div>
	</section>
	<!-- 页面备注信息 -->
	<div class="pagetip" style="text-align: left;">
		<h4>注:</h4>
		<div>最多可增加四个查询字段。</div>
		<div>当没有设置时按：产品Id 升序，订单明细配送地址 升序，配送企业 升序。</div>
	</div>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
	var orderInfos = '${orderInfos}'; 
	$(function () {
		if(orderInfos) {
			var arr = orderInfos.split(",");
			var cols = new Array();// 已存在的排序字段
			var sors = new Array();// 已存在的排序字段方向
			if(arr.length > 0) {
				$.each(arr, function(i, v){
					var arr2 = v.split(" ");
					cols.push(arr2[0]);
					sors.push(arr2[1]);
				});
			}
			
			var $tb = $("#tableDatas");
            var $rowTemplate = $("#tableDatas>tr:eq(0)").clone(true);
            
			$("#btnAdd").bind("click", function () {
	            var trCount = $("#tableDatas").find("tr").length;
	            if (trCount > 3) {
	            	$.alert("最多可增加四个查询字段。", "warn");
	            	return false;
	            }
	            var appentRow = $rowTemplate.clone(true);
	            var $cTr = appentRow.find("select:eq(0)");
	            $cTr.attr("id", $cTr.attr("id") + trCount);
				
	            for (var i = 0; i < trCount; i++) {
	                var selectVal = $("#tableDatas>tr").eq(i).find("select:eq(0) option:selected").val();
	                $cTr.find("option[value=" + selectVal + "]").remove();
	            }
	            appentRow.appendTo($tb);
	        });
			
			//依据现有排序规则显示
			if(cols != null && cols.length > 0) {
				//绑定原有排序字段值
				for (var i = 0; i < cols.length; i++) {
					if(i == 0) {
						var $col = $("#tableDatas>tr").eq(i).find("select:eq(0)");
						$col.val(cols[i]);
						$col.attr("id", $col.attr("id") + i);
					} else {
						var appentRow = $rowTemplate.clone(true);
						var $cTr = appentRow.find("select:eq(0)");
						$cTr.val(cols[i]);
						$cTr.attr("id", $cTr.attr("id") + i);
						appentRow.appendTo($tb);
					}
					$sor = $("#tableDatas>tr").eq(i).find("select:eq(1)");
					$sor.val(sors[i]);
                }
			}
			
			//删除当前行
            $(document).on("click", ".remove", function () {
            	var $tr = $(this).parents('tr');
            	var ncId = $tr.find("select:eq(0)").attr('id');
            	ncId = ncId.substring(ncId.lastIndexOf('n') + 1);
            	var trCount = $("#tableDatas").find("tr").length;
            	for (var i = 0; i < trCount; i++) {
            		if(i > ncId) {
            			$("#column" + i).attr("id", "column" + (i - 1));
            		}
            	}
                $tr.remove();
            });
		}
		
		$(document).on("focus",".col-div", function() {
            var ncId = $(this).find("select:eq(0)").attr("id");
			var trs = $("#tableDatas").find("tr");
			var $this = $(this).find("select:eq(0)");
			var appentRow = $rowTemplate.clone(true);
			
			$this.empty();
			$this.append(appentRow.find("select:eq(0)").find("option"));
			
			$.each(trs, function(i, v){
				var c = $(v).find("select:eq(0)").attr("id");
				if(c === ncId) {
				} else {
					var selectVal = $(v).find("select:eq(0) option:selected").val();
	                $this.find("option[value=" + selectVal + "]").remove();
				}
			});
		});
	}); 
	
	function save() {
		var orderInfos = new Array();
		var columns = new Array();
        var columnNames = new Array();
		$("#tableDatas>tr").each(function (i) {
			var $select1 = $(this).find("select option:selected").eq(0);
            var $select2 = $(this).find("select option:selected").eq(1);
            columns.push($select1.val() + " " + $select2.val());
            columnNames.push($select1.text() + " " + $select2.text());
		});
		var isSave = $("#saveCookie").is(":checked");
		orderInfos.push(columns.join(","));
		orderInfos.push(columnNames.join(","));
		orderInfos.push(isSave);
		closeMyDialog(orderInfos);
	}
	
	function orderInfos(columns, columnNames, isSave) {
		var obj = new Object();
		obj.columns = columns;
		obj.columnNames = columnNames;
		obj.isSave = isSave;
		return obj;
	}
	
	function closeMyDialog(rowdata) {
		var dialog = top.dialog.get(window);
		dialog.close(rowdata);
	    return false;
	} 
	// 返回
	function back() {
		closeMyDialog();
	}
</script>
</html>