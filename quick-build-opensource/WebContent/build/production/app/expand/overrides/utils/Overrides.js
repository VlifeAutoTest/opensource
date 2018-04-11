Ext.define("Ext.locale.zh_CN.view.AbstractView",{override:"Ext.view.AbstractView",loadingText:"读取中..."});Ext.apply(Ext.util.Format,{addDataToolTip:function(b,a,f,j,c,i,h){if(h){var d=h.ownerCt.columnManager.getHeaderAtIndex(c);try{if(d&&d.tooltipXTemplate){a.tdAttr='data-qtip="'+d.tooltipXTemplate.apply(f.data)+'"'}}catch(g){console.log(g)}}},monetaryRenderer:function(g,b,e,f,d,c,a){if(g){if(g){if(Ext.monetaryUnit&&Ext.monetaryUnit!=1){g=g/Ext.monetaryUnit}b.style="color:"+(g>0?"blue":"red")+";";Ext.util.Format.addDataToolTip(g,b,e,f,d,c,a);return Ext.util.Format.number(g,"0,000.00")+Ext.monetaryText}else{return""}}else{return""}},dateRenderer:function(g,b,e,f,d,c,a){if(b){b.style="color:#a40;";Ext.util.Format.addDataToolTip(g,b,e,f,d,c,a)}return Ext.util.Format.date(g,"Y-m-d")},datetimeRenderer:function(g,b,e,f,d,c,a){if(b){b.style="color:#a40;";Ext.util.Format.addDataToolTip(g,b,e,f,d,c,a)}return Ext.util.Format.date(g,"Y-m-d H:i:s")},floatRenderer:function(g,b,e,f,d,c,a){if(b){b.style="color:"+(g>0?"blue":"red")+";";Ext.util.Format.addDataToolTip(g,b,e,f,d,c,a)}return g==0?"":Ext.util.Format.number(g,"0,000.00")},intRenderer:function(h,b,e,g,d,c,a){if(b){b.style="color:"+(h>=0?"blue":"red")+";";Ext.util.Format.addDataToolTip(h,b,e,g,d,c,a)}if(a){var f=a.ownerCt.columnManager.getHeaderAtIndex(d)}return h==0?f&&f.displayZero?"0":"":h},percentRenderer:function(i,b,d,j,c,h,e){if(!i){i=0}i=Math.round(i*10000)/100;var g=i>100?100:i;g=g<0?0:g;var f=parseInt(g*2.55).toString(16);if(f.length==1){f="0"+f}Ext.util.Format.addDataToolTip(i,b,d,j,c,h,e);var a=["#DDE7EC","#CADFE9","#B7D6E5","#A4CDE2","#92C5DE","#7FBCDA","#6CB3D7","#59AAD3","#46A2D0","#3399CC"];return Ext.String.format('<div><div style="float:left;border:1px solid #C0C0C0;height:18px;width:100%;"><div style="float:left;text-align:center;width:100%;color:blue;">{0}%</div><div style="background: {2};width:{1}%;height:16px;"></div></div></div>',i,g,"#B7D6E5")},wavgRenderer:function(h,a,d,i,b,g,e){if(!Ext.isNumeric(h)){a.tdAttr='data-qtip="分母无数据"';return Ext.String.format('<div><div style="float:left;border:1px solid #C0C0C0;height:18px;width:100%;"><div style="float:left;text-align:center;width:100%;color:blue;"></div><div style="background: {2};width:{1}%;height:16px;"></div></div></div>',0,0,"#B7D6E5")}var c=e.ownerCt.columnManager.getHeaderAtIndex(b);fz=d.get(c.dataIndex+"1"),fm=d.get(c.dataIndex+"2");h=Math.round(h*10000)/100;var f=h>100?100:h;f=f<0?0:f;a.tdAttr='data-qtip="&nbsp;&nbsp;&nbsp;'+Ext.util.Format.number(fz,"0,000.00")+"<br/><hr color=#fff size=1>&nbsp;&nbsp;&nbsp;"+Ext.util.Format.number(fm,"0,000.00")+'&nbsp;&nbsp;&nbsp;"';return Ext.String.format('<div><div style="float:left;border:1px solid #C0C0C0;height:18px;width:100%;"><div style="float:left;text-align:center;width:100%;color:blue;">{0}%</div><div style="background: {2};width:{1}%;height:16px;"></div></div></div>',h,f,"#B7D6E5")},aggregateSumRenderer:function(c,a,f,k,d,j,i){var e=i.ownerCt.columnManager.getHeaderAtIndex(d);var g=f.parentNode;if(g.get(e.dataIndex)){var b=Math.round((!!c?c:0)/g.get(e.dataIndex)*10000)/100;var h=b>100?100:b;h=h<0?0:h;a.tdAttr='data-qtip="占 '+(g.get("text_")||g.get("text"))+" 的 "+b+'%"';return Ext.String.format('<div><div style="float:left;height:18px;width:100%;"><div style="float:left;text-align:right;width:100%;color:blue;">{0}</div><div style="background: {2};width:{1}%;height:2px;"></div></div>',Ext.util.Format.monetaryRenderer(c,a,f,k,d,j,i),h,"#DDE7EC")}else{return Ext.util.Format.monetaryRenderer(c,a,f,k,d,j,i)}},aggregateSumFloatRenderer:function(c,a,f,k,d,j,i){var e=i.ownerCt.columnManager.getHeaderAtIndex(d);var g=f.parentNode;if(g.get(e.dataIndex)){var b=Math.round((!!c?c:0)/g.get(e.dataIndex)*10000)/100;var h=b>100?100:b;h=h<0?0:h;a.tdAttr='data-qtip="占 '+(g.get("text_")||g.get("text"))+" 的 "+b+'%"';return Ext.String.format('<div><div style="float:left;height:18px;width:100%;"><div style="float:left;text-align:right;width:100%;color:blue;">{0}</div><div style="background: {2};width:{1}%;height:2px;"></div></div>',Ext.util.Format.floatRenderer(c,a,f,k,d,j,i),h,"#DDE7EC")}else{return Ext.util.Format.floatRenderer(c,a,f,k,d,j,i)}},aggregateCountRenderer:function(c,a,f,k,d,j,i){var e=i.ownerCt.columnManager.getHeaderAtIndex(d);var g=f.parentNode;if(g.get(e.dataIndex)){var b=Math.round((!!c?c:0)/g.get(e.dataIndex)*10000)/100;var h=b>100?100:b;h=h<0?0:h;a.tdAttr='data-qtip="占 '+(g.get("text_")||g.get("text"))+" 的 "+b+'%"';return Ext.String.format('<div><div style="float:left;height:18px;width:100%;"><div style="float:left;text-align:right;width:100%;color:blue;">{0}</div><div style="background: {2};width:{1}%;height:2px;"></div></div>',Ext.util.Format.intRenderer(c,a,f,k,d,j,i),h,"#DDE7EC")}else{return Ext.util.Format.intRenderer(c,a,f,k,d,j,i)}},percentNumberRenderer:function(a,c,b){return'<span style="color: #00C;float:right;">'+(a*100+" %")+"</span>"},nameFieldRenderer:function(g,b,e,f,d,c,a){b.style="font-weight:bold;";Ext.util.Format.addDataToolTip(g,b,e,f,d,c,a);return g},defaultRenderer:function(g,b,e,f,d,c,a){Ext.util.Format.addDataToolTip(g,b,e,f,d,c,a);return g},booleanTextRenderer:function(a){return(a?"是":" ")},iconClsRenderer:function(a){if(a){return'<span class="'+a+'"> '+a+"</span>"}else{return""}},date:function(a,b){if(!a){return""}if(!Ext.isDate(a)){if(a.indexOf("T")>0){a=new Date(Date.parse(a))}else{a=new Date(a.replace(/-/g,"/"))}}return Ext.Date.dateFormat(a,b||Ext.Date.defaultFormat)}});Ext.apply(Ext.form.VTypes,{postcode:function(c,b){var a=/^[1-9][0-9]{5}$/;if(!a.test(c)){return false}return true},postcodeText:"请输入有效的邮政编码!",number:function(c,b){var a=/^\d+$/;if(!a.test(c)){return false}return true},chineseText:"请输入有效的数字!"});