//地区级联加载初始化
function initAreaId(area_id){
	areaChange("province");
	var area_id_length = area_id.length;
	if(area_id_length==6){
		var area_id_city = area_id.substr(0,4);
		$("#area2 option[value='"+area_id_city+"00']").attr("selected",true);
		areaChange("city");
		$("#area3 option[value='"+area_id+"']").attr("selected",true);
	}else if(area_id_length==4){
		$("#area2 option[value='"+area_id+"00']").attr("selected",true);
	}
}

//地区级联操作
$("#area2").change(function(){
	$("#area3 option").remove();
	var area2 = $("#area2").val();
	if($("#area2").val().length >= 1){
		areaChange("city");
	}
});

//ajax加载地区
function areaChange(level){
	if("city"==level){
		var parent_id = $("#area2").val();
	}else if("province"==level){
		var parent_id = $("#area1").val();
	}
	var url = ctx+"/selectController/getArea.html";
	$.ajax({
		url:url,
		data: {ID: parent_id},
		async:false,
		success:function(data){
			data = JSON.parse(data);
			var areas = '<option value="">请选择</option>';
			$.each(data,function(i,area){
				areas += '<option value="'+area.value+'">'+area.text+'</option>';
			});
			if("city"==level){
				$("#area3").append(areas);
			}else if("province"==level){
				$("#area2").append(areas);
			}
		}
	});
}

//查询条件初始化
function queryInit(){
	var adminAreaIdDrug = "";
	if($("#area3").val() !== null && $("#area3").val().length>0){
		adminAreaIdDrug = $("#area3").val();
	}else if($("#area2").val() !== null && $("#area2").val().length>0){
		adminAreaIdDrug = $("#area2").val().substr(0,4);
	}else{
		adminAreaIdDrug = $("#area1").val().substr(0,2);
	}
	$('#adminAreaIdDrug').val(adminAreaIdDrug);
	  
	var startTime = $("#submitTimeBefore").val();
	var endTime = $("#submitTimeAfter").val();
	if(startTime.length==0 || endTime.length==0){
		return false;
	}
	return true;
}

//打开医疗机构dialog
function toHosptialDialog(){
	var random = Math.floor(Math.random()*100);
	$.HN.dialog.open({
		"id":"showHosptial"+random,
		"title":"医疗机构",
		"url":ctx+"/dialog/toHosptialDialog.html",
		"data":{},
        "width":800,
        "height":500,
        "closefunc":function(params){
			$("#hospitalId").val(params.hospitalId);
			$("#hospitalName").val(params.hospitalName);
        }
	});
}

//打开通用名dialog
function toProductDialog(){
	var random = Math.floor(Math.random()*100);
	$.HN.dialog.open({
		"id":"showHosptial"+random,
		"title":"通用名",
		"url":ctx+"/dialog/toProductDialogForSup.html",
		"data":{},
        "width":800,
        "height":500,
        "closefunc":function(params){
			$("#productName").val(params.productName);
        }
	});
}

//企业dialog
function toCompanyDialog(type){
	var random = Math.floor(Math.random()*100);
	var title = "";
	if("sc"==type){
		title = "生产企业";
	}else if("ps"==type){
		title = "配送企业";
	}
	$.HN.dialog.open({
		"id":"showCompany"+type+random,
		"title":title,
		"url":ctx+"/dialog/toCompanyDialog.html",
		"data":{},
        "width":800,
        "height":500,
        "closefunc":function(params){
        	if("sc"==type){
				$("#companyIdSc").val(params.companyId);
				$("#companyNameSc").val(params.companyName);
        	}else if("ps"==type){
        		$("#companyIdPs").val(params.companyId);
				$("#companyNamePs").val(params.companyName);
        	}
        }
	});
}

//订单dialog
function toOrderDialog(){
	var random = Math.floor(Math.random()*100);
	$.HN.dialog.open({
		"id":"showOrder"+random,
		"title":"订单信息",
		"url":ctx+"/dialog/toOrderDialog.html",
		"data":{},
        "width":800,
        "height":500,
        "closefunc":function(params){
			$("#orderId").val(params.orderId);
			$("#orderName").val(params.orderName);
        }
	});
}