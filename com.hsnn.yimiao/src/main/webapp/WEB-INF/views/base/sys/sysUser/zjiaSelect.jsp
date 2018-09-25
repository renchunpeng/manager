<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/component/commonTagLib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <title>未生成账号专家</title>
    <%@ include file="/WEB-INF/component/commonCSS.jsp" %>
</head>
<body class="skin-blue-light sidebar-mini fixed skin-blue-light-frame">
	<section class="content-header">
		<h1>${(userType==8)?"未生成账号专家":"未生成账号专家"}</h1>
		<ol class="breadcrumb">
			<li><a href="${ctx}/home.jsp"><i class="fa fa-home"></i><spring:message code="message.lable.first"/></a></li>
			<li class="active"><a href="#">基础库管理</a></li>
            <li class="active"><a href="#">信息维护</a></li>
            <li class="active"><a href="#">生成账号</a></li>
		</ol>
	</section>
	<section class="content">
	 <div class=" box box-primary">
            <div class="box-body">
                <form id="searchForm">
                    <div class="input">
	                    <div class="textalign1">专家姓名：</div>
						 <div class="boxinput">
		                        <input type="text" class="textinput" id="name" name="name" placeholder="<spring:message code="message.listForm.zhuanJiaXingming"/>" maxlength="64"/>
		               </div>	
	                    <div class="textalign">专家类别：</div>
						 <div class="boxinput">
		                 <table style="width:100%;">
		                   <tr>
		                     <td>
		                        <select class="textinput" id="expSkillsType1" name="dictionaryKey1" style="width: 90px; float:left;margin:0 10px 0 0;">
		                        </select>
		                     </td>
		                     <td>
		                        <select class="textinput" id="expSkillsType2" name="dictionaryKey2" style="width: 90px; float:left;margin:0 10px 0 0;"><option value=""><spring:message code="message.select.option"/> </option></select>
		                     </td>
		                     <td>  
		                        <select class="textinput" id="expSkillsType3" name="dictionaryKey3" style="width: 90px; float:left;margin:0 10px 0 0;"><option value=""><spring:message code="message.select.option"/> </option></select>
		                     </td>
		                    </tr>
		                  </table>
		               </div>
                	</div>
            	</form>  
            </div>
	</div>
		<div class="btn-control-box">
			<button id="search" type="button" onclick="search();"  class="btn btn-success btn-sm"><spring:message code="message.button.seachSpacing"/></button>
			<button type="button" class="btn btn-sm btn-danger" value="返回" id="btnBack" onclick="javascript:window.location.href='toCreateUser.html';">返回</button>
		</div>
		
		
		<table class="jqgrid" id="gridlist"></table>
		<div id="gridpage"></div>
	</section>
	<%@ include file="/WEB-INF/component/commonJS.jsp"%>
	<script type="text/javascript">
		
	var obj ={
			"names": [
				'<spring:message code="message.jqGrid.cz"/>',
				'expertId',
				'expertCode',
				 '<spring:message code="message.listForm.zhuanJiaXingming"/>',
                 '<spring:message code="message.listForm.xingbie"/>',
                 '<spring:message code="message.listForm.zhuanJiaLeiBie"/>', 
                 '<spring:message code="message.listForm.zhiWu"/>',
                 '<spring:message code="message.listForm.danWei"/>', 
                 '<spring:message code="message.listForm.lianXiDianHua"/>'
	        ],
	        "model": [
			        
					{ name: 'operate', width: 10, align: 'center',sortable: false,
			        	formatter : function(val, opts,rowdata) {
							var str="";
                       		str += "<a href='javascript:generateAccount(\""+rowdata.expertId+"\",\""+rowdata.name+"\",${userType});' title='<spring:message code='生成账号'/>'>生成账号</a>";
							return str;
						}
		        	},
		        	{ name: 'expertId', width: 10, align:"center", sortable: false,hidden:true },
		        	{ name: 'expertCode', width: 10, align:"center", sortable: false,hidden:true  },
		        	{ name: 'name', width: 10, align:"center", sortable: false },
                    { name: 'sex', width: 10, align:"center", sortable: false},
                    { name: 'dictionaryValue', width: 10, align:"center", sortable: false},
                    { name: 'position', width: 10, align:"center", sortable: false},
                    { name: 'companyId', width: 10, align:"center", sortable: false},
                    { name: 'handphone', width: 10, align:"center", sortable: false}
	        ]      
		};
    	
        $(function () {
        	$('#searchForm input').bind('keydown', function(event) {if (event.keyCode == "13") {event.preventDefault();gridSerch();}})[0].focus();
            $("#gridlist").jqGrid({
                url: "${ctx}/sysUser/getExpertListZH.html",
                mtype: "post",
                contentType : 'application/json',
                datatype: "json",
                autowidth: true,
                height: 340,
                colNames: obj.names,
                colModel: obj.model,
                rowNum: 20,
                rowList: [10, 20, 50, 100],
                rownumbers: true,
                pager: "#gridpage",
                viewrecords: true,
                multiselect: false,
                caption: "未生成账号专家列表",
                postData: {"userType":"${userType}"},
                //序号宽度自动变化
                gridComplete:function(){
                	//序号列宽度自适应（参数为jqgridID）
                    autoRNWidth("gridlist");
                	//数据只有一条时默认选中（参数为jqgridID）
                    selectByOneData("gridlist");
                },

                jsonReader: {
                    repeatitems: false,
                    id: "ids"
                }
            });
            $("#gridlist").jqGrid('navGrid', '#gridpage', { add: false, edit: false, del: false, search: false, refresh: false });
            $(window).trigger("resize");
            $("#gridlist").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden","height" : "230px" });

      // 查询
		$("#search").click(function(){
			var queryData = $("#searchForm").serializeJSON();
			
			$("#gridlist").jqGrid("setGridParam", {
				mtype: "post",
				url: "${ctx}/sysUser/getExpertListZH.html",
				postData: queryData,//发送查询条件 
			}).trigger("reloadGrid");//重新载入
		}); 
      
     
     
        showHideCol("gridlist", "advanceSearch");
        
        initAdvanceSearch("searchTypeButton", "searchType");
        
        $("#expSkillsType1").HNSelect({
            url: "${ctx}/selectController/getExpertType.html", data: { ID: '0' },  defaultText: "<option value=''>请选择</option>",
            func: function () {
                $("#expSkillsType2").HNSelect({
                    parent_selector: "#expSkillsType1", url: "${ctx}/selectController/getExpertType.html", dataid: "ID",defaultText: "<option value=''>请选择</option>",
                              func: function () {
                                  $("#expSkillsType3").HNSelect({
                                      parent_selector: "#expSkillsType2", url: "${ctx}/selectController/getExpertType.html", dataid: "ID", defaultText: "<option value=''>请选择</option>"
                                  });
                              }
                });
            }
        });
	});
        
        
      /*   //查询
        function search(page) {
        	var expSkillsType1 = $("#expSkillsType1").val();
            var expSkillsType2 = $("#expSkillsType2").val();
            var expSkillsType3 = $("#expSkillsType3").val();
            var name = $("#name").val();
            var companyId = $("#companyId").val();
            var status = $("#status").val();
            $("#gridlist").jqGrid('setGridParam',{  
                datatype:'json',
                postData:{
                    "dictionaryKey1":expSkillsType1,
                    "dictionaryKey2":expSkillsType2,
                    "dictionaryKey3":expSkillsType3,
                    "name":name,
                    "companyId":companyId,
                    "status":status
                    },
                page : (page || 1)
            }).trigger("reloadGrid"); //重新载入  
        }  */
        
      
        
         function generateAccount(id,name,userType){
        	
	    	$.HN.dialog.open({
	             id:id,
	             title:"用户新增",
	             url:"${ctx}/sysUser/toGenerateAccount.html?id="+id+"&name="+name+"&userType="+userType,
	             width:"350px",
	             height:"185px",
	             closefunc:function(){
	            	 window.location.href="${ctx}/sysUser/toCreateUserList.html?userType="+userType;
	             } 
	         });
    	} 
    </script>
</body>
</html>
