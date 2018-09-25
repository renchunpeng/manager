"use strict";if(typeof jQuery==="undefined"){throw new Error("AdminLTE requires jQuery")}$.AdminLTE={};$.AdminLTE.options={navbarMenuSlimscroll:true,navbarMenuSlimscrollWidth:"3px",navbarMenuHeight:"200px",sidebarToggleSelector:"[data-toggle='offcanvas']",sidebarPushMenu:true,sidebarSlimScroll:true,sidebarExpandOnHover:false,enableBoxRefresh:true,enableBSToppltip:true,BSTooltipSelector:"[data-toggle='tooltip']",enableFastclick:false,enableControlSidebar:false,controlSidebarOptions:{toggleBtnSelector:"[data-toggle='control-sidebar']",selector:".control-sidebar",slide:true},enableBoxWidget:true,boxWidgetOptions:{boxWidgetIcons:{collapse:"fa-minus",open:"fa-plus",remove:"fa-times"},boxWidgetSelectors:{remove:'[data-widget="remove"]',collapse:'[data-widget="collapse"]'}},directChat:{enable:true,contactToggleSelector:'[data-widget="chat-pane-toggle"]'},colors:{lightBlue:"#3c8dbc",red:"#f56954",green:"#00a65a",aqua:"#00c0ef",yellow:"#f39c12",blue:"#0073b7",navy:"#001F3F",teal:"#39CCCC",olive:"#3D9970",lime:"#01FF70",orange:"#FF851B",fuchsia:"#F012BE",purple:"#8E24AA",maroon:"#D81B60",black:"#222222",gray:"#d2d6de"},screenSizes:{xs:480,sm:768,md:992,lg:1200}};$(function(){if(typeof AdminLTEOptions!=="undefined"){$.extend(true,$.AdminLTE.options,AdminLTEOptions)}var o=$.AdminLTE.options;_init();$.AdminLTE.layout.activate();$.AdminLTE.tree(".sidebar");if(o.enableControlSidebar){$.AdminLTE.controlSidebar.activate()}if(o.navbarMenuSlimscroll&&typeof $.fn.slimscroll!="undefined"){$(".navbar .menu").slimscroll({height:o.navbarMenuHeight,alwaysVisible:false,size:o.navbarMenuSlimscrollWidth}).css("width","100%")}if(o.sidebarPushMenu){$.AdminLTE.pushMenu.activate(o.sidebarToggleSelector)}if(o.enableBSToppltip){$("body").tooltip({selector:o.BSTooltipSelector})}if(o.enableBoxWidget){$.AdminLTE.boxWidget.activate()}if(o.enableFastclick&&typeof FastClick!="undefined"){FastClick.attach(document.body)}if(o.directChat.enable){$(o.directChat.contactToggleSelector).on("click",function(){var box=$(this).parents(".direct-chat").first();box.toggleClass("direct-chat-contacts-open")})}$('.btn-group[data-toggle="btn-toggle"]').each(function(){var group=$(this);$(this).find(".btn").on("click",function(e){group.find(".btn.active").removeClass("active");$(this).addClass("active");e.preventDefault()})})});function _init(){$.AdminLTE.layout={activate:function(){var _this=this;_this.fix();_this.fixSidebar();$(window,".wrapper").resize(function(){_this.fix();_this.fixSidebar()})},fix:function(){var neg=$(".main-header").outerHeight()+$(".main-footer").outerHeight();var window_height=$(window).height();var sidebar_height=$(".sidebar").height();if($("body").hasClass("fixed")){$(".content-wrapper, .right-side").css("min-height",window_height-$(".main-footer").outerHeight());$(".main-frame",".content-wrapper").css("min-height",window_height-$(".main-footer").outerHeight()-55);$(".main-frame",".content-wrapper").height(window_height-$(".main-footer").outerHeight()-55)}else{var postSetWidth;if(window_height>=sidebar_height){$(".content-wrapper, .right-side").css("min-height",window_height-neg);postSetWidth=window_height-neg}else{$(".content-wrapper, .right-side").css("min-height",sidebar_height);postSetWidth=sidebar_height}var controlSidebar=$($.AdminLTE.options.controlSidebarOptions.selector);if(typeof controlSidebar!=="undefined"){if(controlSidebar.height()>postSetWidth){$(".content-wrapper, .right-side").css("min-height",controlSidebar.height())}}}},fixSidebar:function(){if(!$("body").hasClass("fixed")){if(typeof $.fn.slimScroll!="undefined"){$(".sidebar").slimScroll({destroy:true}).height("auto")}return}else{if(typeof $.fn.slimScroll=="undefined"&&console){console.error("Error: the fixed layout requires the slimscroll plugin!")}}if($.AdminLTE.options.sidebarSlimScroll){if(typeof $.fn.slimScroll!="undefined"){$(".sidebar").slimScroll({destroy:true}).height("auto");$(".sidebar").slimscroll({height:($(window).height()-$(".main-header").height())+"px",color:"rgba(0,0,0,0.2)",size:"3px"})}}}};$.AdminLTE.pushMenu={activate:function(toggleBtn){var screenSizes=$.AdminLTE.options.screenSizes;$(toggleBtn).on("click",function(e){e.preventDefault();if($(window).width()>(screenSizes.sm-1)){$("body").toggleClass("sidebar-collapse")}else{if($("body").hasClass("sidebar-open")){$("body").removeClass("sidebar-open");$("body").removeClass("sidebar-collapse")}else{$("body").addClass("sidebar-open")}}});$(".content-wrapper").click(function(){if($(window).width()<=(screenSizes.sm-1)&&$("body").hasClass("sidebar-open")){$("body").removeClass("sidebar-open")}});if($.AdminLTE.options.sidebarExpandOnHover||($("body").hasClass("fixed")&&$("body").hasClass("sidebar-mini"))){this.expandOnHover()}},expandOnHover:function(){var _this=this;var screenWidth=$.AdminLTE.options.screenSizes.sm-1;$(".main-sidebar").hover(function(){if($("body").hasClass("sidebar-mini")&&$("body").hasClass("sidebar-collapse")&&$(window).width()>screenWidth){_this.expand()}},function(){if($("body").hasClass("sidebar-mini")&&$("body").hasClass("sidebar-expanded-on-hover")&&$(window).width()>screenWidth){_this.collapse()}})},expand:function(){$("body").removeClass("sidebar-collapse").addClass("sidebar-expanded-on-hover")},collapse:function(){if($("body").hasClass("sidebar-expanded-on-hover")){$("body").removeClass("sidebar-expanded-on-hover").addClass("sidebar-collapse")}}};$.AdminLTE.tree=function(menu){var _this=this;$("li a",$(menu)).on("click",function(e){var $this=$(this);var checkElement=$this.next();if((checkElement.is(".treeview-menu"))&&(checkElement.is(":visible"))){checkElement.slideUp("normal",function(){checkElement.removeClass("menu-open")});checkElement.parent("li").removeClass("active")}else{if((checkElement.is(".treeview-menu"))&&(!checkElement.is(":visible"))){var parent=$this.parents("ul").first();var ul=parent.find("ul:visible").slideUp("normal");ul.removeClass("menu-open");var parent_li=$this.parent("li");checkElement.slideDown("normal",function(){checkElement.addClass("menu-open");parent.find("li.active").removeClass("active");parent_li.addClass("active");_this.layout.fix()})}}if(checkElement.is(".treeview-menu")){e.preventDefault()}})};$.AdminLTE.controlSidebar={activate:function(){var _this=this;var o=$.AdminLTE.options.controlSidebarOptions;var sidebar=$(o.selector);var btn=$(o.toggleBtnSelector);btn.on("click",function(e){e.preventDefault();if(!sidebar.hasClass("control-sidebar-open")&&!$("body").hasClass("control-sidebar-open")){_this.open(sidebar,o.slide)}else{_this.close(sidebar,o.slide)}});var bg=$(".control-sidebar-bg");_this._fix(bg);if($("body").hasClass("fixed")){_this._fixForFixed(sidebar)}else{if($(".content-wrapper, .right-side").height()<sidebar.height()){_this._fixForContent(sidebar)}}},open:function(sidebar,slide){var _this=this;if(slide){sidebar.addClass("control-sidebar-open")}else{$("body").addClass("control-sidebar-open")}},close:function(sidebar,slide){if(slide){sidebar.removeClass("control-sidebar-open")}else{$("body").removeClass("control-sidebar-open")}},_fix:function(sidebar){var _this=this;if($("body").hasClass("layout-boxed")){sidebar.css("position","absolute");sidebar.height($(".wrapper").height());$(window).resize(function(){_this._fix(sidebar)})}else{sidebar.css({"position":"fixed","height":"auto"})}},_fixForFixed:function(sidebar){sidebar.css({"position":"fixed","max-height":"100%","overflow":"auto","padding-bottom":"50px"})},_fixForContent:function(sidebar){$(".content-wrapper, .right-side").css("min-height",sidebar.height())}};$.AdminLTE.boxWidget={selectors:$.AdminLTE.options.boxWidgetOptions.boxWidgetSelectors,icons:$.AdminLTE.options.boxWidgetOptions.boxWidgetIcons,activate:function(){var _this=this;$(_this.selectors.collapse).on("click",function(e){e.preventDefault();_this.collapse($(this))});$(_this.selectors.remove).on("click",function(e){e.preventDefault();_this.remove($(this))})},collapse:function(element){var _this=this;var box=element.parents(".box").first();var box_content=box.find("> .box-body, > .box-footer");if(!box.hasClass("collapsed-box")){element.children(":first").removeClass(_this.icons.collapse).addClass(_this.icons.open);box_content.slideUp(300,function(){box.addClass("collapsed-box")})}else{element.children(":first").removeClass(_this.icons.open).addClass(_this.icons.collapse);box_content.slideDown(300,function(){box.removeClass("collapsed-box")})}},remove:function(element){var box=element.parents(".box").first();box.slideUp()}}}(function($){$.fn.boxRefresh=function(options){var settings=$.extend({trigger:".refresh-btn",source:"",onLoadStart:function(box){},onLoadDone:function(box){}},options);var overlay=$('<div class="overlay"><div class="fa fa-refresh fa-spin"></div></div>');return this.each(function(){if(settings.source===""){if(console){console.log("Please specify a source first - boxRefresh()")}return}var box=$(this);var rBtn=box.find(settings.trigger).first();rBtn.on("click",function(e){e.preventDefault();start(box);box.find(".box-body").load(settings.source,function(){done(box)})})});function start(box){box.append(overlay);settings.onLoadStart.call(box)}function done(box){box.find(overlay).remove();settings.onLoadDone.call(box)}}})(jQuery);(function($){$.fn.todolist=function(options){var settings=$.extend({onCheck:function(ele){},onUncheck:function(ele){}},options);return this.each(function(){if(typeof $.fn.iCheck!="undefined"){$("input",this).on("ifChecked",function(event){var ele=$(this).parents("li").first();ele.toggleClass("done");settings.onCheck.call(ele)});$("input",this).on("ifUnchecked",function(event){var ele=$(this).parents("li").first();ele.toggleClass("done");settings.onUncheck.call(ele)})}else{$("input",this).on("change",function(event){var ele=$(this).parents("li").first();ele.toggleClass("done");settings.onCheck.call(ele)})}})}}(jQuery));(function($){$.fn.serializeJSON=function(){var serializeObj={};$(this.serializeArray()).each(function(){serializeObj[this.name]=this.value.trim()});return serializeObj};
    $.fn.serializeJsonSelf=function(){
        var serializeObj={}; // 目标对象
        var array=this.serializeArray(); // 转换数组格式
        // var str=this.serialize();
        $(array).each(function(){ // 遍历数组的每个元素 {name : xx , value : xxx}
            if(serializeObj[this.name]){ // 判断对象中是否已经存在 name，如果存在name
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value); // 追加一个值 hobby : ['音乐','体育']
                }else{
                    // 将元素变为 数组
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=[this.value]; // 如果元素name不存在，添加一个属性 name:value
            }
        });
        return serializeObj;
    };
    $("[data-cascade]").change(function(){var defaultParam={value:"id",name:"name"};var $this=$(this);var params=$.extend(defaultParam,$.parseJSON($this.attr("data-cascade")));var subObject=$(params.sub).empty();subObject.append([$("<option>").val("2").html("fff"),$("<option>").val("3").html("cccc")])});$(".number-only").keydown(function(event){return!event.shiftKey&&((event.keyCode>95&&event.keyCode<106)||(event.keyCode>47&&event.keyCode<59)||event.keyCode==8||event.keyCode==9||event.keyCode==46||event.keyCode==37||event.keyCode==39||event.keyCode==110||event.keyCode==116)});if($(".ueditor").size()>0){if(!window["UE"]){$.getScript(ctx+"/lib/plugins/ueditor/ueditor.config.js",function(){$.getScript(ctx+"/lib/plugins/ueditor/ueditor.all.js",function(){initUEditor()})})}else{initUEditor()}}function initUEditor(){$(".ueditor").each(function(){var editorId=$(this).attr("id");UE.getEditor(editorId,{initialFrameWidth:"100%"})})}}(jQuery));$.fn.outerHTML=function(){return(!this.length)?this:(this[0].outerHTML||(function(el){var div=document.createElement("div");div.appendChild(el.cloneNode(true));var contents=div.innerHTML;div=null;return contents})(this[0]))};function serialize(obj){switch(obj.constructor){case Object:var str="{";for(var o in obj){str+=o+":"+serialize(obj[o])+","}if(str.substr(str.length-1)==","){str=str.substr(0,str.length-1)}return str+"}";break;case Array:var str="[";for(var o in obj){str+=serialize(obj[o])+","}if(str.substr(str.length-1)==","){str=str.substr(0,str.length-1)}return str+"]";break;case Boolean:return'"'+obj.toString()+'"';break;case Date:return'"'+obj.toString()+'"';break;case Function:break;case Number:return'"'+obj.toString()+'"';break;case String:return'"'+obj.toString()+'"';break}}function setQueryCookie(secdondLevelCookie,cookieValue){var newCookieValue=secdondLevelCookie+"="+cookieValue;$.cookie("queryCondition",newCookieValue,{expires:7,path:"/"})}function getQueryCookie(secdondLevelCookie){var condition=$.cookie("queryCondition");if(condition){var indexofequal=condition.indexOf("=");if(indexofequal<=0){return""}else{var getpre=condition.substr(0,indexofequal);if(getpre!==secdondLevelCookie){return""}return condition.replace(secdondLevelCookie+"=","")}}else{return""}}jQuery(function($){var insertHTML='<div class="pull-left" style="position:relative;margin:2px 4px;"><span style="position: absolute;"><span  id="uploadBtn" >上传按钮</span></span></div>';var idIndex=0;$("[importObj]").each(function(){var $this=$(this);var uploadId="uploadBtn_"+idIndex++;$(insertHTML).find("#uploadBtn").attr("id",uploadId).end().insertBefore($this);var objHeight=$this.innerHeight();var objWidth=$this.innerWidth();var settring=$this.attr("importObj");if(window[settring]){settring=window[settring]}else{try{settring=$.parseJSON(settring)}catch(e){$.alert("JSON解析错误：\r\n"+settring);return}}var settings_object={upload_url:"importData.html",flash_url:ctx+"/lib/plugins/uploadify/uploadify.swf",file_post_name:"file",post_params:{},button_placeholder_id:uploadId,button_window_mode:SWFUpload.WINDOW_MODE.TRANSPARENT,button_width:objWidth,button_height:objHeight,use_query_string:true,file_types:"*.*",button_image_url:ctx+"/lib/img/empty.png",button_cursor:SWFUpload.CURSOR.HAND,file_dialog_complete_handler:function(){this.startUpload()},upload_success_handler:function(file,server,response){if(server.length>=2){server=server.substring(1,server.length-1);if(server==""){$.alert("Excel 表头信息错误，请重新选择！","error")}else{if(server=="{}"){$.alert("导入配置错误，请联系管理员！","error")}else{server="["+server.replace(/\\/g,"")+"]";var serverObj=JSON.parse(server);var actionPath=serverObj[0].actionPath;if(actionPath){var url=ctx+actionPath+"/importDataDialogList.html?expandInfos="+server;$.alert("导入数据处理成功","success",function(){$.HN.dialog.open({"id":"importDataInfo"+new Date().getTime(),"title":"导入数据列表","url":url,"data":{},"width":1000,"height":540,"closefunc":function(params){if(params){location.reload()}}})},1000)}else{$.alert("导入配置错误，请联系管理员！","error")}}}}}};$.extend(settings_object,settring);if(!settings_object.upload_url){$.alert("upload_url 不能为空")}new SWFUpload(settings_object)})});function isDateYMorYMD(dateString){if(dateString.trim()==""){return"日期不能为空！"}var ymd=/^(\d{4})(\d{2})(\d{2})$/;var ym=/^(\d{4})(\d{2})$/;var r=dateString.match(ymd);var r2=dateString.match(ym);if(r==null&&r2==null){return"请输入格式正确的日期格式:\n\r例    如：201608或20160808"}if(r!=null){var d=new Date(r[1],r[2]-1,r[3]);if(d.getFullYear()==r[1]&&d.getMonth()+1==r[2]&&d.getDate()==r[3]){var now=new Date();if(now>d){return"有效期不能小于当前时间！"}}else{return"请输入格式正确的日期格式:\n\r例    如：201608或20160808"}}if(r2!=null){var d=new Date(r2[1],r2[2]-1);if(d.getFullYear()==r2[1]&&d.getMonth()+1==r2[2]){var now=new Date();if(now>d){return"有效期不能小于当前时间！"}}else{return"请输入格式正确的日期格式:\n\r例    如：201608或20160808"}}};function showProcessing(){var _PageHeight=document.documentElement.clientHeight,_PageWidth=document.documentElement.clientWidth;var _LoadingTop=_PageHeight>61?(_PageHeight-61)/2:0,_LoadingLeft=_PageWidth>215?(_PageWidth-215)/2:0;var _LoadingHtml='<div id="loadingDiv" style="position:absolute;left:0;width:100%;height:'+_PageHeight+'px;top:0;z-index:10000;"><div style="position: absolute;  left: '+_LoadingLeft+'px; top:'+_LoadingTop+'px; width: auto; height: 100px; line-height: 100px; padding-left: 100px; padding-right: 100px; background: #fff  no-repeat scroll center left 4px; border: 2px solid #95B8E7; color: #696969; font-family:\'Microsoft YaHei\';">业务处理中,请稍等<span class="dotting"></span></div></div>';$('body').append(_LoadingHtml)};function removeProcessing(){if($("#loadingDiv").length==1){$("#loadingDiv").remove()}}var waitSeconds=1*1000;$.ajaxSetup({beforeSend:function(XMLHttpRequest){showProcessing()},complete:function(){$("#loadingDiv").remove()}});