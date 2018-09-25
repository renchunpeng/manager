define("echarts/chart/eventRiver",["require","./base","../layout/eventRiver","zrender/shape/Polygon","../component/axis","../component/grid","../component/dataZoom","../config","../util/ecData","../util/date","zrender/tool/util","zrender/tool/color","../chart"],function(e){function t(e,t,i,a,o){n.call(this,e,t,i,a,o);var r=this;r._ondragend=function(){r.isDragend=!0},this.refresh(a)}var n=e("./base"),i=e("../layout/eventRiver"),a=e("zrender/shape/Polygon");e("../component/axis"),e("../component/grid"),e("../component/dataZoom");var o=e("../config");o.eventRiver={zlevel:0,z:2,clickable:!0,legendHoverLink:!0,itemStyle:{normal:{borderColor:"rgba(0,0,0,0)",borderWidth:1,label:{show:!0,position:"inside",formatter:"{b}"}},emphasis:{borderColor:"rgba(0,0,0,0)",borderWidth:1,label:{show:!0}}}};var r=e("../util/ecData"),s=e("../util/date"),l=e("zrender/tool/util"),h=e("zrender/tool/color");return t.prototype={type:o.CHART_TYPE_EVENTRIVER,_buildShape:function(){var e=this.series;this.selectedMap={},this._dataPreprocessing();for(var t=this.component.legend,n=[],a=0;a<e.length;a++){if(e[a].type===this.type){e[a]=this.reformOption(e[a]),this.legendHoverLink=e[a].legendHoverLink||this.legendHoverLink;var o=e[a].name||"";if(this.selectedMap[o]=t?t.isSelected(o):!0,!this.selectedMap[o]){continue}this.buildMark(a),n.push(this.series[a])}}i(n,this._intervalX,this.component.grid.getArea()),this._drawEventRiver(),this.addShapeList()},_dataPreprocessing:function(){for(var e,t,n=this.series,i=0,a=n.length;a>i;i++){if(n[i].type===this.type){e=this.component.xAxis.getAxis(n[i].xAxisIndex||0);for(var o=0,r=n[i].data.length;r>o;o++){t=n[i].data[o].evolution;for(var l=0,h=t.length;h>l;l++){t[l].timeScale=e.getCoord(s.getNewDate(t[l].time)-0),t[l].valueScale=Math.pow(t[l].value,0.8)}}}}this._intervalX=Math.round(this.component.grid.getWidth()/40)},_drawEventRiver:function(){for(var e=this.series,t=0;t<e.length;t++){var n=e[t].name||"";if(e[t].type===this.type&&this.selectedMap[n]){for(var i=0;i<e[t].data.length;i++){this._drawEventBubble(e[t].data[i],t,i)}}}},_drawEventBubble:function(e,t,n){var i=this.series,o=i[t],s=o.name||"",l=o.data[n],m=[l,o],V=this.component.legend,U=V?V.getColor(s):this.zr.getColor(t),d=this.deepMerge(m,"itemStyle.normal")||{},p=this.deepMerge(m,"itemStyle.emphasis")||{},c=this.getItemStyleColor(d.color,t,n,l)||U,u=this.getItemStyleColor(p.color,t,n,l)||("string"==typeof c?h.lift(c,-0.2):c),g=this._calculateControlPoints(e),y={zlevel:this.getZlevelBase(),z:this.getZBase(),clickable:this.deepQuery(m,"clickable"),style:{pointList:g,smooth:"spline",brushType:"both",lineJoin:"round",color:c,lineWidth:d.borderWidth,strokeColor:d.borderColor},highlightStyle:{color:u,lineWidth:p.borderWidth,strokeColor:p.borderColor},draggable:"vertical",ondragend:this._ondragend};y=new a(y),this.addLabel(y,o,l,e.name),r.pack(y,i[t],t,i[t].data[n],n,i[t].data[n].name),this.shapeList.push(y)},_calculateControlPoints:function(e){var t=this._intervalX,n=e.y,i=e.evolution,a=i.length;if(!(1>a)){for(var o=[],r=[],s=0;a>s;s++){o.push(i[s].timeScale),r.push(i[s].valueScale)}var l=[];l.push([o[0],n]);var s=0;for(s=0;a-1>s;s++){l.push([(o[s]+o[s+1])/2,r[s]/-2+n])}for(l.push([(o[s]+(o[s]+t))/2,r[s]/-2+n]),l.push([o[s]+t,n]),l.push([(o[s]+(o[s]+t))/2,r[s]/2+n]),s=a-1;s>0;s--){l.push([(o[s]+o[s-1])/2,r[s-1]/2+n])}return l}},ondragend:function(e,t){this.isDragend&&e.target&&(t.dragOut=!0,t.dragIn=!0,t.needRefresh=!1,this.isDragend=!1)},refresh:function(e){e&&(this.option=e,this.series=e.series),this.backupShapeList(),this._buildShape()}},l.inherits(t,n),e("../chart").define("eventRiver",t),t}),define("echarts/layout/eventRiver",["require"],function(){function e(e,o,r){function s(e,t){var n=e.importance,i=t.importance;return n>i?-1:i>n?1:0}function l(e,t){if(e.indexOf){return e.indexOf(t)}for(var n=0,i=e.length;i>n;n++){if(e[n]===t){return n}}return -1}for(var h=5,m=o,V=0;V<e.length;V++){for(var U=0;U<e[V].data.length;U++){null==e[V].data[U].weight&&(e[V].data[U].weight=1);for(var d=0,p=0;p<e[V].data[U].evolution.length;p++){d+=e[V].data[U].evolution[p].valueScale}e[V].data[U].importance=d*e[V].data[U].weight}e[V].data.sort(s)}for(var V=0;V<e.length;V++){null==e[V].weight&&(e[V].weight=1);for(var d=0,U=0;U<e[V].data.length;U++){d+=e[V].data[U].weight}e[V].importance=d*e[V].weight}e.sort(s);for(var c=Number.MAX_VALUE,u=0,V=0;V<e.length;V++){for(var U=0;U<e[V].data.length;U++){for(var p=0;p<e[V].data[U].evolution.length;p++){var g=e[V].data[U].evolution[p].timeScale;c=Math.min(c,g),u=Math.max(u,g)}}}for(var y=n(Math.floor(c),Math.ceil(u)),b=0,V=0;V<e.length;V++){for(var U=0;U<e[V].data.length;U++){var f=e[V].data[U];f.time=[],f.value=[];for(var p=0;p<e[V].data[U].evolution.length;p++){f.time.push(e[V].data[U].evolution[p].timeScale),f.value.push(e[V].data[U].evolution[p].valueScale)}var k=l(f.value,Math.max.apply(Math,f.value)),x=i(y,f.time[k],f.time[k+1]),p=0;for(f.y=x+f.value[k]/2+h,p=0;p<f.time.length-1;p++){var _=i(y,f.time[p],f.time[p+1]);f.y-f.value[p]/2-h<_&&(f.y=_+f.value[p]/2+h)}var _=i(y,f.time[p],f.time[p]+m);for(f.y-f.value[p]/2-h<_&&(f.y=_+f.value[p]/2+h),e[V].y=f.y,b=Math.max(b,f.y+f.value[k]/2),p=0;p<f.time.length-1;p++){a(y,f.time[p],f.time[p+1],f.y+f.value[p]/2)}a(y,f.time[p],f.time[p]+m,f.y+f.value[p]/2)}}t(e,r,b,h)}function t(e,t,n,i){for(var a=t.y,o=(t.height-i)/n,r=0;r<e.length;r++){e[r].y=e[r].y*o+a;for(var s=e[r].data,l=0;l<s.length;l++){s[l].y=s[l].y*o+a;for(var h=s[l].evolution,m=0;m<h.length;m++){h[m].valueScale*=1*o}}}}function n(e,t){var i={left:e,right:t,leftChild:null,rightChild:null,maxValue:0};if(t>e+1){var a=Math.round((e+t)/2);i.leftChild=n(e,a),i.rightChild=n(a,t)}return i}function i(e,t,n){if(1>n-t){return 0}var a=Math.round((e.left+e.right)/2),o=0;if(t==e.left&&n==e.right){o=e.maxValue}else{if(a>=n&&null!=e.leftChild){o=i(e.leftChild,t,n)}else{if(t>=a&&null!=e.rightChild){o=i(e.rightChild,t,n)}else{var r=0,s=0;null!=e.leftChild&&(r=i(e.leftChild,t,a)),null!=e.rightChild&&(s=i(e.rightChild,a,n)),o=r>s?r:s}}}return o}function a(e,t,n,i){if(null!=e){var o=Math.round((e.left+e.right)/2);e.maxValue=e.maxValue>i?e.maxValue:i,(Math.floor(10*t)!=Math.floor(10*e.left)||Math.floor(10*n)!=Math.floor(10*e.right))&&(o>=n?a(e.leftChild,t,n,i):t>=o?a(e.rightChild,t,n,i):(a(e.leftChild,t,o,i),a(e.rightChild,o,n,i)))}}return e});