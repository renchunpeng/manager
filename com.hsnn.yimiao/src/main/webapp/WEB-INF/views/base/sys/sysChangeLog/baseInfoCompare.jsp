<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/component/commonTagLib.jsp"%>
<%@ include file="/WEB-INF/component/commonCSS.jsp"%>
    <!--[if lt IE 9]>
        <script src="${ctx}/lib/js/html5shiv.min.js"></script>
        <script src="${ctx}/lib/js/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    	div.col-sm-3.text-left, div.col-sm-2.text-left, div.col-sm-10.text-left{
    	    color:#949494;
    	}
    	.autoTd{word-break: break-all}
    </style>
<div>
     <section class="content">
		<div class="box box-primary">
            <div class="box-header with-border">
                <h3 id="box-title" class="box-title"></h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div>
            </div>
            <div class="box-arrow"><img src="${ctx}/lib/img/onPageArrow.png"/></div>
            <div class="box-body">
               <div id="returnMsg"></div>
			</div>
		</div>
		<div class="box-footer text-center">
			<button type="button" class="btn btn-primary btn-sm" value="关闭" id="btnClose">返回</button>
		</div>
    </section>
    <%@ include file="/WEB-INF/component/commonJS.jsp"%>
	<script src="${ctx}/lib/js/validate/jquery.validate.js"></script>
	<%-- <script src="${ctx}/lib/js/validate.expand.js?v=2"></script> --%>
	<script type="text/javascript">
		var strTitle = []; 
		var strFiled = [];
		var title= [];
		var filed=[];
		var datas=${datas};
		//标题关键字
		var jsonKeys=${jsonKeys}
		var keys=[];
		
		$(function(){
			
			$.each(datas, function(idx, obj) {
    			printObject(obj);
    			return false;
    		});
			
			$.each(datas, function(idx, obj) {
				printField(obj);
			})
			
			$.each(jsonKeys, function(idx, obj) {
				getKeys(idx,obj);
			})
			
			//alert(title.length); 输出1行标题
			//alert(filed.length); 输出三行比较
			
			//应该显示多少行,根据标题的个数
			//alert($(title[0]).length);
			var row = $(title[0]).length;
			var col = filed.length;
			
			//输出Table：
			//	规格：23行
			//       3列=标题+数据3列
			
			var table="<table class='form-table form-table-2 form-table-info'> <tbody>";
				var trs="";
				for(var i=0;i<row;i++){
					var tr="<tr id='comsc' class='form-group-sm'>";
							tr+="<th style='width:168px;'>";
		    		        	tr+="<label class='control-label'>";
								tr+=$(title[0]).get(i);//输出字段标题
								tr+="</label>";
							tr+="</th>";
							//输出列
							for(var j=0;j<filed.length;j++){
							tr+="<td>";
			    		   	    tr+="<label class='control-label autoTd'>";
			    		   	 	tr+=$(filed[j]).get(i);//输出字段的值:第j行,滴i列
			    		   	 	tr+="</label>";
		    		    	tr+="</td>";
					   		}
					trs+=tr;
				}
				table+=trs;
			table+=" </tbody> </table>";
			
			
			$("#returnMsg").append(table);
			
			
			//设置关键字
			$("#box-title").html(keys);
			
			//关闭窗口事件
        	$("#btnClose").click(function(){
        		top.dialog({"id":"quality"}).close();
        	});
			
		});
		
		//遍历属性的方法
        function printObject(obj){ 
    		var temp = ""; 
    		for(var i in obj){//用javascript的for/in循环遍历对象的属性 
    			strTitle.push(i);
    		} 
    		title.push(strTitle);
    	} 
    	
        function printField(obj){ 
    		var temp = ""; 
    		for(var i in obj){//用javascript的for/in循环遍历对象的属性 
    			strFiled.push(obj[i]);
    		} 
    		filed.push(strFiled);
    		strFiled=[];
    	} 
        
        function getKeys(idx,obj){
        	var temp = "";
        	keys.push(idx+":"+obj+"	");
        }
        
    </script>

</div>