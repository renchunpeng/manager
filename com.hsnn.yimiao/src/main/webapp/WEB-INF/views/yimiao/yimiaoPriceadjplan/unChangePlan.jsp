<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<title>未处理调价计划</title>
<meta http-equiv="X-UA-Compatible" content="chrome=1">
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
    <style type="text/css">
    .box-body{
    margin-top:-10px;
    }    	
    </style>
</head>
<body class="skin-blue-light sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
        <h1>未处理调价计划</h1>
        <ol class="breadcrumb">
            <li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i>首页</a></li>
			<li class="active"><a href="#">交易</a></li>
			<li class="active"><a href="#">药品调价</a></li>
            <li class="active"><a href="#">未处理调价计划</a></li>
        </ol>
    </section>
    
	<section class="content">
	   <form id="searchForm" method="post" class="form-horizontal">
		<div class=" box box-success">
			<div class="box-body">
			   <div class="input">
			        <div class="textalign1">计划名称：</div>
                    <div class="boxinput">
                        <input type="text" class="textinput" id="priceAdjPlanName" name="priceAdjPlanName" placeholder="计划名称" />
                    </div>
                 
                    <div class="textalign" >制定时间：</div>
                    <div class="boxinput"> 
                        <table style="width:100%;">
                                <tr>
                                    <td style="width:50%">       
                                        <input class="textinput" id='createStartTime' name="createStartTime" type="text"  placeholder="制定开始时间" onFocus="var endDate=$dp.$('createEndTime');WdatePicker({maxDate:'#F{$dp.$D(\'createEndTime\')}'})" >
						            </td>
                                    <td>&nbsp;-&nbsp;</td>
                                    <td style="width:50%">       
                                        <input class="textinput" id='createEndTime' name="createEndTime" type="text"  placeholder="制定开始时间" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'createStartTime\')}'})"  >
                                    </td>
                                </tr>
                         </table>        
                    </div>	
                    <div class="textalign" >执行时间：</div>
                    <div class="boxinput"> 
                        <table style="width:100%;">
                                <tr>
                                    <td style="width:50%">       
                                        <input class="textinput" id='executeStartTime' name="executeStartTime" type="text"  placeholder="执行开始时间" onFocus="var endDate=$dp.$('executeEndTime');WdatePicker({maxDate:'#F{$dp.$D(\'executeEndTime\')}'})"  >
                        
						            </td>
                                    <td>&nbsp;-&nbsp;</td>
                                    <td style="width:50%">       
                                        <input class="textinput" id='executeEndTime' name="executeEndTime" type="text"  placeholder="执行开始时间"  onFocus="WdatePicker({minDate:'#F{$dp.$D(\'executeStartTime\')}'})"  >
                                    </td>
                                </tr>
                         </table>        
                    </div>  
                </div>
                <%--<div class="input">
				    <div class="textalign1">执行方式：</div>
                    <div class="boxinput">
                        <select class="textinput" id="executeCat" name="executeCat" style="width: 100%;">
							<option value="">请选择</option>
                       		<option value="1">手动执行</option>
                       		<option value="2">自动执行</option>
                       	</select>
                    </div>		   
			   </div>--%>
			</div>
		 </div>
		  
		</form>
	 		<div class="btn-control-box">
            	<button type="button" class="btn btn-success btn-sm" id="search">查&nbsp;询</button>
        	</div>
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>

	<%@ include file="/WEB-INF/component/commonJS.jsp" %>
	<script src="${ctx}/lib/js/moreAndMore.js" type="text/javascript"></script>
	<script type="text/javascript">
		 var obj ={
					"names": [
							'操作',
							'计划名称',
							/*'执行方式',*/
							'制定时间',
							'执行时间',
							'调价依据'
						
			        ],
			        "model": [				
			                  {name: 'operate', align: 'center',sortable: false,
			  	            	formatter:function(val, opts, rowdata){	
				            		var b="<a href='${ctx}/yimiaoPriceadjplan/toPricePlanChange.html?priceAdjPlanId="+rowdata.priceAdjPlanId+"' class='opIcon' title='调价明细'>调价明细</a>"
				                	return b;
			  	            	}
			                  },
						   		{name:'priceAdjPlanName',  align:"center", sortable:false},
						   		/*{name:'executeCat',  align:"center", sortable:false,
						   			formatter : function(val,opts,row){
						   				if(row.executeCat == 1){
						   					return "手动执行"
						   				}else if(row.executeCat == 2){
						   					return "自动执行";
						   				}else {
						   					return "";
						   				}
						   			}	
						   		},*/
								{name:'createDatetime',  align:"center", sortable:false,
						   			formatter : function(val,opts,row){
						   				return new Date(val).format('yyyy-MM-dd HH:mm:ss');
						   			}	
								},
						   		{name:'executeDatetime', align:"center", sortable:false,
									formatter : function(val,opts,row){
										if(row.executeCat == 1){
											return '';
										}
										if(row.executeCat == 2){
											return new Date(val).format('yyyy-MM-dd HH:mm:ss');
										}
					   					
					   			}	},
						   		{name:'priceAdjAccord',  align:"center", sortable:false }						   		
						   	],       		           
				};
				
				
				 $(function () {			
			         $("#gridlist").jqGrid({
			             url: "${ctx}/yimiaoPriceadjplan/getUnChangePlanList.html",
			             postData:{},
			             contentType : 'application/json',
			             datatype: "json",
			             autowidth: true,
			             height: 270,
			             caption: "未处理调价计划列表",
			             colNames: obj.names,
			             colModel: obj.model,
			             rowNum: 20,
			             rowList: [10, 20, 50, 100],
			             rownumbers: true,
			             viewrecords: true,
			             editurl:"priceChangeList.jsp",
					     jsonReader: {
					         id: "priceAdjPlanId"
					     },
			             /*  multiselect: false, */

			             //序号宽度自动变化
			             gridComplete:function(){
			             	//序号列宽度自适应（参数为jqgridID）
			                 autoRNWidth("gridlist");
			             },
			         });	      
			         $("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
			         $(window).trigger("resize");
			         $("#gridlist").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden","height" : "230px" });
			      // 查询
			         $("#search").click(function(){
			 			var queryData = $("#searchForm").serializeJSON();
			 			$("#gridlist").jqGrid("setGridParam", {
			 				url: "${ctx}/yimiaoPriceadjplan/getUnChangePlanList.html",
			 				postData: queryData,//发送查询条件 
			 			}).trigger("reloadGrid");//重新载入
			 		});

			     });
		 
		 
		/* $(function () {
			jQuery("#gridlist").jqGrid({
				url: "${ctx}/drugpurPriceadjplan/getUnChangePlanList.html",
			    mtype: "post",
				datatype: "json",
				autowidth: true,
				height: 325,
			   	colNames:['操作','计划名称','执行方式','制定时间','执行时间','调价依据'],
			   	colModel:[
                    {name:'opts',  align:"center", sortable:false, formatter :function(val, opts, rowdata){
		                 var opts = "<a href='toPricePlanEdit.html?id=" + rowdata.priceAdjPlanId + "' style='background:url(${ctx}/lib/img/icon/icon.png) no-repeat 0px 0px' class='opIcon' title='编辑'></a>";
		                 opts += "<a href='toPricePlanChange.html?id=" + rowdata.priceAdjPlanId + "' style='background:url(${ctx}/lib/img/icon/icon.png) no-repeat -100px 0px' class='opIcon' title='调价明细'></a>";
		                 return opts;
	                }},
			   		{name:'planName',  align:"center", sortable:false},
			   		{name:'executeCat',  align:"center", sortable:false,
			   			formatter : function(val,opts,row){
			   				if(row.executeCat == 0){
			   					return "手动执行"
			   				}else if(row.executeCat == 1){
			   					return "自动执行";
			   				}else {
			   					return "";
			   				}
			   			}	
			   		},
					{name:'createDatetime',  align:"center", sortable:false },
			   		{name:'executeDatetime', align:"center", sortable:false},
			   		{name:'priceAdjAccord',  align:"left", sortable:false }
			   		
			   	],
				 rowNum: 20,
				 rowList: [10, 20, 50, 100],
			     rownumbers: true,
			     pager: "#gridpage",
			     viewrecords: true,
			     caption: "未处理调价计划列表",
			     editurl:"priceChangeList.jsp",
			     jsonReader: {
			         id: "priceAdjPlanId"
			     },
			     gridComplete:function(){
	                    //序号列宽度自适应（参数为jqgridID）
	                    autoRNWidth("gridlist");
	                    //数据只有一条时默认选中（参数为jqgridID）
	                    selectByOneData("gridlist");
	                }
			   	
			});
				 
			$("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
			$("#gridlist").jqGrid("setGridHeight", create());
		});
		 $(window).trigger("resize");
			// 查询
			$("#search").click(function(){
				var queryData = $("#searchForm").serializeJSON();
				$("#gridlist").jqGrid("setGridParam", {
					url: "${ctx}/drugpurPriceadjplan/getUnChangePlanList.html",
					postData: queryData,//发送查询条件 
				}).trigger("reloadGrid");//重新载入
			});
		}); */

	</script>
</body>
</html>