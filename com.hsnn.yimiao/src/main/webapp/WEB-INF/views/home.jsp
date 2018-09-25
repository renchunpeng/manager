<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<title><spring:message code="首页"/></title>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>

</head>
<body class="skin-blue sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
	        <h1>
	           	 首&nbsp;页
	            <!--<small>Control panel</small>-->
	        </h1>
	        <ol class="breadcrumb">
	            <li class="active"><i class="fa fa-home"></i> 首页</li>
	            <!--<li class="active">Dashboard</li>-->
	        </ol>
	    </section>
	    <section class="content home-content">
	    	<div class="row">
	    		<div class="col-sm-13">
	    			<div class="home-btn-group clearfix">
	    			<span style="margin: auto;padding: auto;font-size:40px">欢迎使用贵州省第二类疫苗集中采购系统</span>
	    			   <%-- <!-- 中心 -->
		    		   <c:if test="${type == 5 && acctType == 1}">
		    			    <a href="${ctx }/drugpurGoods/toList.html" class="home-btn home-btn13">
				    			<span>产品列表</span>
				    		</a>
				    		<a href="${ctx }/drugpurProcurecatalog/toDgProcatalogList.html" class="home-btn home-btn13">
				    			<span>商品列表</span>
				    		</a>
				    		<a href="${ctx }/drugpurPurchaseOrderdetailRecent/toRecentDrugOrderdList.html" class="home-btn home-btn5">
			    			  <span>近三个月订单</span>
			    		    </a>
			    		    <a href="${ctx }/drugpurPurchaseOrderdetailRecent/toHistoryDrugOrderdList.html" class="home-btn home-btn5">
			    			  <span>三个月前订单</span>
			    		    </a>
	    			    </c:if>
	    			    <!-- 医疗机构 -->
		    		   <c:if test="${type == 4 && acctType == 1 || type == 7 && acctType == 1}">
		    			    <a href="${ctx }/drugpurProcurecatalog/toDgProcatalogList.html" class="home-btn home-btn13">
				    			<span>商品列表</span>
				    		</a>
				    		<a href="${ctx }/drugpurPurchaseOrderdetailRecent/toRecentDrugOrderdList.html" class="home-btn home-btn5">
			    			  <span>近三个月订单</span>
			    		    </a>
			    		    <a href="${ctx }/drugpurPurchaseOrderdetailRecent/toHistoryDrugOrderdList.html" class="home-btn home-btn5">
			    			  <span>三个月前订单</span>
			    		    </a>
	    			    </c:if>
	    			    
	    			    <!-- 配送企业 -->
		    		   <c:if test="${type == 2 && acctType == 1 || type == 3 && acctType == 1}">
		    			    <a href="${ctx }/drugpurProcurecatalog/toDgProcatalogList.html" class="home-btn home-btn13">
				    			<span>商品列表</span>
				    		</a>
				    		<a href="${ctx }/drugpurPurchaseOrderdetailRecent/toRecentDrugOrderdList.html" class="home-btn home-btn5">
			    			  <span>近三个月订单</span>
			    		    </a>
			    		    <a href="${ctx }/drugpurPurchaseOrderdetailRecent/toHistoryDrugOrderdList.html" class="home-btn home-btn5">
			    			  <span>三个月前订单</span>
			    		    </a>
	    			    </c:if>
	    			    
	    			    <!-- 监管机构 -->
		    		   <c:if test="${type == 6 && acctType == 1}">
		    			    <a href="${ctx }/drugpurProcurecatalog/toDgProcatalogList.html" class="home-btn home-btn13">
				    			<span>商品列表</span>
				    		</a>
				    		<a href="${ctx }/drugpurPurchaseOrderdetailRecent/toRecentDrugOrderdList.html" class="home-btn home-btn5">
			    			  <span>近三个月订单</span>
			    		    </a>
			    		    <a href="${ctx }/drugpurPurchaseOrderdetailRecent/toHistoryDrugOrderdList.html" class="home-btn home-btn5">
			    			  <span>三个月前订单</span>
			    		    </a>
	    			    </c:if>
			    		<!--<a href="##" class="col-sm-1">
			    			<span>主用户管理</span>
			    		</a>--> --%>
		            </div>
		            
		          <!--   <div class="box box-default home-box">
			            <div class="box-header with-border">
			                <h3 class="box-title">通知公告</h3>
			            </div>/.box-header
			            <div class="box-body home-message-box">
			            	<div class="home-message-outer">
			            		<ul class="home-message">
				            	</ul>
			            	</div>
			             	<div class="home-page-outer">
			            		<button class="page-next"></button>
			            		<button class="page-previous"></button>
							</div>
			            </div> 
			        </div> -->
			        <!-- <div class="box box-default home-box">
			            <div class="box-header with-border">
			                <h3 class="box-title">待办事项</h3>
			            </div>/.box-header
			            <div class="box-body  to-do-lists">
			            	<ul class="home-matter">
			            	</ul>
			            </div> 
			        </div> -->
			        <%-- <div class="box box-default home-box">
			            <div class="box-header with-border">
			                <h3 class="box-title">采购情况
				                <c:if test="${type == 3}">
				                    <select class="typeSearch">
				                     <option value="2">配送相关</option>
				                     <option value="3">投标相关</option>
				                    </select>
				                </c:if>
			                </h3>
			            </div><!-- /.box-header -->
			            <div class="box-body">
			            	<!--放置柱图状-->
			            	<div id="chartsBar" style="width:100%; height:230px;"></div>
			            </div> 
			        </div> --%>
	    		</div>
	    		<%-- <div class="col-sm-5">
	    			   <c:if test="${type == 5 || type ==6}">
			    			<div class="home-paragraph"></div>
	    			   </c:if>
	            	<div class="box box-default map-box">
			            <div class="box-header with-border">
			                <h3 class="box-title">地图</h3>
			            </div><!-- /.box-header -->
			            <div class="box-body">
			            	<!--放置地图-->
			               <div id="chartMap" style="width:100%; height:430px;"><img src="lib/img/map.jpg" style="display: block;height:100%;margin: 0 auto;"/></div> 
			            </div> 
			        </div>
			        <div class="box box-default home-box" style="display: none">
			            <div class="box-header with-border">
			                <h3 class="box-title">基药非基药采购比例</h3>
			            </div><!-- /.box-header -->
			            <div class="box-body">
			            	<!--放置饼图-->
			            	<div id="chartsPie" style="width:100%; height:200px;"></div>
			            </div> 
			        </div>
	    		</div> --%>
	    	</div>
	    </section>
</body>
<%@ include file="/WEB-INF/component/commonJS.jsp"%>
<script type="text/javascript">
$(function(){
	noticePage();
	todoList();
	btnWidth(6);
});
$(window).resize(function(){
	 btnWidth(6);
});
	/* 通知公告 begin  */
	var records = 0; // 中页数
	var nextPage = 1;
    var count = 5;
    var pageSize = 1;
	    
	function noticePage(){
		var url = '${ctx }/home/getConnectorSysNoticeData.html';
		var data ={'page':nextPage,'rows':count};
		$.ajax({
			   type: "POST",
			   url: url,
			   data:data,
			   success: function(data){
				   var datas = $.parseJSON(data);
				   records = datas.records;
				   pageSize = pageSun(records,count);
				   activation(pageSize,nextPage);
				   var rows = datas.rows;
				   var str = '';
				   $.each(rows,function(i,obj){
	 			       str += '<li> <a href="${stdurl}/sysNotice/getConnectorDetial.html?id='+ obj.sysNoticeId + '">';
	 				   str += '<p>'+ obj.title +'</p>';
	 				   str += '<span>'+ new Date(obj.datetime).format("yyyy-MM-dd HH:mm:ss");+'</span>';
	 				   str += '</a></li>';
				   });
				   $(".home-message").empty().append(str);
			   }
		});
	}
	
	function activation(pageSize,nextPage){
		if(pageSize == 1 || pageSize == 0){
			$(".page-previous").removeClass("activation").prop("disabled","disabled");
			$(".page-next").removeClass("activation").prop("disabled","disabled");
		}else{
			if(nextPage == 1){
				$(".page-previous").removeClass("activation").prop("disabled","disabled");
				$(".page-next").addClass("activation").removeProp("disabled");
		    }else if(pageSize > nextPage &&  nextPage > 1){
		    	$(".page-next").addClass("activation").removeProp("disabled");
		    	$(".page-previous").addClass("activation").removeProp("disabled");
		    }else if(nextPage == pageSize){
		    	$(".page-previous").addClass("activation").removeProp("disabled");
		    	$(".page-next").removeClass("activation").prop("disabled","disabled");
		    }
		}
	}
	
	function pageSun(records,count){
		var size = 0;
		if ((records % count) == 0) { 
			size = records / count; 
		} else { 
			size = Math.ceil(records / count); 
		} 
		return size;
	}
	
	$(".page-next").click(function(){
		nextPage = nextPage + 1;
		if(nextPage <= pageSize){
			noticePage();
		}
		activation(pageSize,nextPage);
	 });      
	 $(".page-previous").click(function(){
		 nextPage = nextPage - 1;
		 if(nextPage > 0){
			 noticePage();
		 }
		 activation(pageSize,nextPage);
	 });
	 /* 通知公告 end   */
	 
	 
	 /* 待办事项 begin  */
	  function todoList(){
	    var url = '${ctx }/home/getMatterData.html';
	    var acctTypePage = ${acctType};//操作用户展示待办事项
	    if(acctTypePage == 1){
			$.ajax({
				   type: "POST",
				   url: url,
				   success: function(data){
					   var datas = $.parseJSON(data);
					   var rows = datas.rows;
					   var str = '';
					   $.each(rows,function(i,obj){
						   str +='<li><a href="${ctx }'+obj.url +'">'
						   str +='<i class="home-matter-num num-color1">'+ (i+1) +'</i>';
						   str +='<p>您有<i>'+obj.sun+'</i>个</p>';
						   str +='<i>【'+ obj.desc +'】</i>';
						   str +='<span>待处理</span>';
						   str +='</a></li>';
					   });
					   $(".home-matter").empty().append(str);
				   }
			});
	    } 
	 }
	 /* 待办事项 end  */
 
  //快捷按钮宽度计算，建议colNum范围在4~6,大于8个和小于3个的按照4个的计算
   function btnWidth(colNum){
   	var groupWidth = $(".home-btn-group").width();
   	var aWidth;
   	if(colNum >=3 && colNum <= 7 ){
   		aWidth = groupWidth / colNum - 9;
   	}else if( (colNum > 0 && colNum <= 3) || colNum >=8){
   		/*按照4个按钮的计算*/
   		aWidth = groupWidth / 4 -10; 
   	};
   	$(".home-btn-group a").css("width",aWidth);
  };

  /* 结算情况  */
  $(function(){
	  var userType = ${type};
	  if(userType == 5 || userType == 6){
		  var url = '${ctx }/home/getJgPayConditionData.html';
		  $.ajax({
			  type: "POST",
			   url: url,
			   success: function(data){
				   data = JSON.parse(data);
				   var str = '';
				   if(data.showData){
					   var drugjgPayCondition = data.drugjgPayCondition;
					   str +='截止目前，全省待结算资金<span>'+ drugjgPayCondition.needPayAmount +'</span>万元，结算中资金<span>'+ drugjgPayCondition.payingAmount +'</span>万元，已结算<span>'+ drugjgPayCondition.hasPayAmount +'</span>万元，共计<span>'+ drugjgPayCondition.totalPayAmount +'</span>万元。';
					   str +='其中，县及县以上医疗机构待结算资金<span>'+ drugjgPayCondition.cityNeedPayAmount +'</span>万元，结算中资金<span>'+ drugjgPayCondition.cityPayingAmount +'</span>万元，已结算<span>'+ drugjgPayCondition.cityHasPayAmount +'</span>万元，共计<span>'+ drugjgPayCondition.cityTotalPayAmount +'</span>万元；';
					   str +='基层医疗机构待结算资金<span>'+ drugjgPayCondition.villageNeedPayAmount +'</span>万元，结算中资金<span>'+ drugjgPayCondition.villagePayingAmount +'</span>万元，已结算<span>'+ drugjgPayCondition.villageHasPayAmount +'</span>万元，共计<span>'+ drugjgPayCondition.villageTotalPayAmount +'</span>万元。';
					   $(".home-paragraph").append(str);
				   }else{
					   $(".home-paragraph").hide();
				   }
			   }
		  });
		  
		  $('#chartMap').css({
				'height':$('.col-sm-7').height() - ($('#chartsPie').parents('.home-box').height() + 13) - ($('.map-box .box-header').height() + 17) - ($('.home-paragraph').height() + 3) 
			});
	  }else{
		  $('#chartMap').css({
				'height':$('.col-sm-7').height() - ($('#chartsPie').parents('.home-box').height() + 13) - ($('.map-box .box-header').height() + 17)
				});
	  }
	  
	  
  });
  
 /*柱状图--采购情况*/
 $(function(){
	 var chartBar = echarts.init(document.getElementById('chartsBar'));
	 var legend = {};
	     legend.data = ['采购金额(万元)', '配送金额(万元)', '收货金额(万元)'];
	 var series = [];
	 for(var i = 0; i < legend.data.length ; i++){
   	      var serie = {};
   	      serie.name =  legend.data[i];
   	      serie.type = 'bar';
   	      serie.data = [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0];
   	      series.push(serie);
     }
	 var title = {};
	 title.text = ''; 
	  var option = {
	     title : title,
	     tooltip : {
	         trigger: 'axis'
	     },
	     legend:legend,
	     xAxis : [
	         {
	             type : 'category',
	             data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
	         }
	     ],
	     yAxis : [
	         {
	             type : 'value'
	         }
	     ],
	     series : series 
	  }
	  
	 var url = '${ctx }/home/getPurchaseSituationData.html';
	 var userType = ${type};
	 var data = {};
	 if(userType == 3){
		 data.type = 2;
	 }
	 purchaseData(data);
	 
	 $(".typeSearch").change(function(){
		 data.type = $(this).val();
		 purchaseData(data);
	 });
	 
	 function purchaseData(data){
		 $.ajax({
			   type: "POST",
			   url: url,
			   data:data,
			   success: function(data){
				   data = JSON.parse(data);
				   if(data.purchaseMonthDataList.length > 0){
					   var myDate = new Date();
					   for(var i = 0 ; i < 12; i++){
						   var gatherMonth = myDate.getFullYear();
						   if(i <10){
							   gatherMonth = gatherMonth +"0" + (i+1);
						   }
						   $.each(data.purchaseMonthDataList,function(index,monthData){
							   if(monthData.gatherMonth == gatherMonth){
								   series[0].data[i] = monthData.purchaseAmount;
								   series[1].data[i] = monthData.distributeAmount;
								   series[2].data[i] = monthData.warehouseAmount;
							   }
						   })
					   }
				   }
				  chartBar.setOption(option);  //采购情况
			   }
		 });
	 }
	
  })

 
 
 
/*饼图--基药非基药采购比例*/
var chartPie = echarts.init(document.getElementById('chartsPie'));
option2 = {
   title : {
       text: '基药非基药采购比例',
       x:'center'
   },
   tooltip : {
       trigger: 'item',
       formatter: "{a} <br/>{b} : {c} ({d}%)"
   },
   legend: {
       orient : 'vertical',
       x : 'left',
       data:['基药','非基药']
   },
//   calculable : true,
   series : [
       {
           name:'访问来源',
           type:'pie',
           radius : '55%',
           center: ['50%', '60%'],
           data:[
               {value:365, name:'基药'},
               {value:200, name:'非基药'}
           ]
       }
   ]
};

//chartPie.setOption(option2);

window.onresize = function () {
	chartBar.resize(); //使第一个图表适应
	chartPie.resize(); // 使第二个图表适应
}
</script>
</script>
</html>