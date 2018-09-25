(function(h){var k=h.each,m=function(b,a){this.init(b,a)};h.extend(m.prototype,{init:function(b,a){this.options=b;this.chartOptions=a;this.columns=b.columns||this.rowsToColumns(b.rows)||[];this.columns.length?this.dataFound():(this.parseCSV(),this.parseTable(),this.parseGoogleSpreadsheet())},getColumnDistribution:function(){var b=this.chartOptions,a=b&&b.chart&&b.chart.type,c=[];k(b&&b.series||[],function(b){c.push((h.seriesTypes[b.type||a||"line"].prototype.pointArrayMap||[0]).length)});this.valueCount={global:(h.seriesTypes[a||"line"].prototype.pointArrayMap||[0]).length,individual:c}},dataFound:function(){this.parseTypes();this.findHeaderRow();this.parsed();this.complete()},parseCSV:function(){var b=this,a=this.options,c=a.csv,d=this.columns,f=a.startRow||0,i=a.endRow||Number.MAX_VALUE,j=a.startColumn||0,e=a.endColumn||Number.MAX_VALUE,g=0;c&&(c=c.replace(/\r\n/g,"\n").replace(/\r/g,"\n").split(a.lineDelimiter||"\n"),k(c,function(c,h){var n=b.trim(c),p=n.indexOf("#")===0;h>=f&&h<=i&&!p&&n!==""&&(n=c.split(a.itemDelimiter||","),k(n,function(b,a){a>=j&&a<=e&&(d[a-j]||(d[a-j]=[]),d[a-j][g]=b)}),g+=1)}),this.dataFound())},parseTable:function(){var b=this.options,a=b.table,c=this.columns,d=b.startRow||0,f=b.endRow||Number.MAX_VALUE,i=b.startColumn||0,j=b.endColumn||Number.MAX_VALUE,e;a&&(typeof a==="string"&&(a=document.getElementById(a)),k(a.getElementsByTagName("tr"),function(a,b){e=0;b>=d&&b<=f&&k(a.childNodes,function(a){if((a.tagName==="TD"||a.tagName==="TH")&&e>=i&&e<=j){c[e]||(c[e]=[]),c[e][b-d]=a.innerHTML,e+=1}})}),this.dataFound())},parseGoogleSpreadsheet:function(){var b=this,a=this.options,c=a.googleSpreadsheetKey,d=this.columns,f=a.startRow||0,i=a.endRow||Number.MAX_VALUE,j=a.startColumn||0,e=a.endColumn||Number.MAX_VALUE,g,h;c&&jQuery.getJSON("https://spreadsheets.google.com/feeds/cells/"+c+"/"+(a.googleSpreadsheetWorksheet||"od6")+"/public/values?alt=json-in-script&callback=?",function(a){var a=a.feed.entry,c,k=a.length,m=0,o=0,l;for(l=0;l<k;l++){c=a[l],m=Math.max(m,c.gs$cell.col),o=Math.max(o,c.gs$cell.row)}for(l=0;l<m;l++){if(l>=j&&l<=e){d[l-j]=[],d[l-j].length=Math.min(o,i-f)}}for(l=0;l<k;l++){if(c=a[l],g=c.gs$cell.row-1,h=c.gs$cell.col-1,h>=j&&h<=e&&g>=f&&g<=i){d[h-j][g-f]=c.content.$t}}b.dataFound()})},findHeaderRow:function(){k(this.columns,function(){});this.headerRow=0},trim:function(b){return typeof b==="string"?b.replace(/^\s+|\s+$/g,""):b},parseTypes:function(){for(var b=this.columns,a=b.length,c,d,f,i;a--;){for(c=b[a].length;c--;){d=b[a][c],f=parseFloat(d),i=this.trim(d),i==f?(b[a][c]=f,f>31536000000?b[a].isDatetime=!0:b[a].isNumeric=!0):(d=this.parseDate(d),a===0&&typeof d==="number"&&!isNaN(d)?(b[a][c]=d,b[a].isDatetime=!0):b[a][c]=i===""?null:i)}}},dateFormats:{"YYYY-mm-dd":{regex:"^([0-9]{4})-([0-9]{2})-([0-9]{2})$",parser:function(b){return Date.UTC(+b[1],b[2]-1,+b[3])}}},parseDate:function(b){var a=this.options.parseDate,c,d,f;a&&(c=a(b));if(typeof b==="string"){for(d in this.dateFormats){a=this.dateFormats[d],(f=b.match(a.regex))&&(c=a.parser(f))}}return c},rowsToColumns:function(b){var a,c,d,f,i;if(b){i=[];c=b.length;for(a=0;a<c;a++){f=b[a].length;for(d=0;d<f;d++){i[d]||(i[d]=[]),i[d][a]=b[a][d]}}}return i},parsed:function(){this.options.parsed&&this.options.parsed.call(this,this.columns)},complete:function(){var b=this.columns,a,c,d=this.options,f,i,j,e,g,k;if(d.complete){this.getColumnDistribution();b.length>1&&(a=b.shift(),this.headerRow===0&&a.shift(),a.isDatetime?c="datetime":a.isNumeric||(c="category"));for(e=0;e<b.length;e++){if(this.headerRow===0){b[e].name=b[e].shift()}}i=[];for(e=0,k=0;e<b.length;k++){f=h.pick(this.valueCount.individual[k],this.valueCount.global);j=[];for(g=0;g<b[e].length;g++){j[g]=[a[g],b[e][g]!==void 0?b[e][g]:null],f>1&&j[g].push(b[e+1][g]!==void 0?b[e+1][g]:null),f>2&&j[g].push(b[e+2][g]!==void 0?b[e+2][g]:null),f>3&&j[g].push(b[e+3][g]!==void 0?b[e+3][g]:null),f>4&&j[g].push(b[e+4][g]!==void 0?b[e+4][g]:null)}i[k]={name:b[e].name,data:j};e+=f}d.complete({xAxis:{type:c},series:i})}}});h.Data=m;h.data=function(b,a){return new m(b,a)};h.wrap(h.Chart.prototype,"init",function(b,a,c){var d=this;a&&a.data?h.data(h.extend(a.data,{complete:function(f){a.series&&k(a.series,function(b,c){a.series[c]=h.merge(b,f.series[c])});a=h.merge(f,a);b.call(d,a,c)}}),a):b.call(d,a,c)})})(Highcharts);