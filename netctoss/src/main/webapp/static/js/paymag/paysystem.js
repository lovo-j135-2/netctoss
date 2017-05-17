window.onload=function(){
	
	// 加在页面时，加载数据
	var s=$('#dg').datagrid({
		url : "paymag/load",
		// 将日期按要求输出
		columns: [[  
			{field: 'payName', title: '资费名称', width: 100,align: 'center'},
			{field: 'payType', title: '资费类型', width: 100,align: 'center'},
			{field: 'payTime', title: '基本时长', width: 100,align: 'center'},
			{field: 'basicCost', title: '基本费用', width: 100,align: 'center'},
			{field: 'unitCost', title: '单位费用（元/月）', width: 100,align: 'center'},
			{field: 'costDiscrip', title: '资费说明', width: 100,align: 'center'},
			{field: 'payStatus', title: '资费状态', width: 100,align: 'center',formatter: formatPrice},
            {field: 'createTime', title: '创建日期', width: 120,align: 'center',formatter: formatDatebox},
        ]]   
	});
	$(function() {
		var pager = $('#dg').datagrid().datagrid('getPager');
		var options = $(pager).data("pagination").options;  
		// 将行数变为可选择的行数
		$(pager).pagination({
			pageSize:10,
			pageList: [10,20],
			beforePageText: '第',// 页数文本框前显示的汉字
    		afterPageText: '页    共 {pages} 页',  
    		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	})
}


// 点击按钮弹窗
function addPayWin(){
	$('#addPay').dialog('open');
	$('#addFM').form('clear');
}
function updatePayWin(){
	var value = $("#dg").datagrid('getSelected');
	if (value != null) {
		if(value.payStatus==0){
			$('#updatePay').dialog('open');
			$('#updateFM').form('clear');
			$("#updateNameP").text(value.payName);
			$("#updateTypeP").text(value.payType);
			$("#updatePayTimeP").text(value.payTime);
			$("#updateBasicCostP").text(value.basicCost);
			$("#updateUnitCostP").text(value.unitCost);
			$("#updateCostDiscripP").text(value.costDiscrip);
		}else{
			// 在上方中部显示消息窗口
			$.messager.show({
				title:'提示',
				msg:"资费是开通状态，不能修改",
				showType:'show',
				style:{
					right:'',
					top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:''
				}
			});
		}
		
	} else {
		// 在上方中部显示消息窗口
		$.messager.show({
			title:'提示',
			msg:"请选择一条数据",
			showType:'show',
			style:{
				right:'',
				top:document.body.scrollTop+document.documentElement.scrollTop,
				bottom:''
			}
		});
	}
}

// 新增资费按钮
function savePay() {
	var date=new Date();
	var dateTime=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
	var pay={
			payName:$("#addName").val(),
			payType:$("#addType").val(),
			payTime:$("#addPayTime").val(),
			basicCost:$("#addBasicCost").val(),
			unitCost:$("#addUnitCost").val(),
			costDiscrip:$("#addCostDiscrip").val(),
			payStatus:0,
			createTime:dateTime
			}
	var json=$.toJSON(pay);
	$.ajax({
		type:"post",
		url:"paymag/addPay",
		async:true,
		data:json,
		contentType : "application/json",
		success:function(mes){
			if(mes.flag==true){
				$('#dg').datagrid('reload');
				// 在上方中部显示消息窗口
				$.messager.show({
					title:'提示',
					msg:mes.message,
					showType:'show',
					style:{
						right:'',
						top:document.body.scrollTop+document.documentElement.scrollTop,
						bottom:''
					}
				});
				$('#addPay').dialog('close');
				$('#addFM').form('clear');
			}else{
				// 在上方中部显示消息窗口
				$.messager.show({
					title:'提示',
					msg:'系统繁忙，请稍后重试',
					showType:'show',
					style:{
						right:'',
						top:document.body.scrollTop+document.documentElement.scrollTop,
						bottom:''
					}
				});
			}
			
		}
	});
}

// 修改资费按钮
function updatePay() {
	var value = $("#dg").datagrid('getSelected');
	var pay={
			id:value.id,
			payName:$("#updateName").val(),
			payType:$("#updateType").val(),
			payTime:$("#updatePayTime").val(),
			basicCost:$("#updateBasicCost").val(),
			unitCost:$("#updateUnitCost").val(),
			costDiscrip:$("#updateCostDiscrip").val(),
			}
	var json=$.toJSON(pay);
	$.ajax({
		type:"post",
		url:"paymag/updatePay",
		async:true,
		data:json,
		contentType : "application/json",
		success:function(mes){
			if(mes.flag==true){
				// 在上方中部显示消息窗口
				$.messager.show({
					title:'提示',
					msg:mes.message,
					showType:'show',
					style:{
						right:'',
						top:document.body.scrollTop+document.documentElement.scrollTop,
						bottom:''
					}
				});
				$('#updatePay').dialog('close');
				$('#updateFM').form('clear');
				$('#dg').datagrid('reload');
			}else{
				// 在上方中部显示消息窗口
				$.messager.show({
					title:'提示',
					msg:'系统繁忙，请稍后重试',
					showType:'show',
					style:{
						right:'',
						top:document.body.scrollTop+document.documentElement.scrollTop,
						bottom:''
					}
				});
			}
			
		}
	});
}

// 删除资费
function deletePay() {
	var value = $("#dg").datagrid('getSelected');
	if(value!=null){
		if(value.payStatus==0){
			var id=value.id;
			$.ajax({
				type:"post",
				url:"paymag/deletePay",
				async:true,
				data:{"id":id},
				success:function(mes){
					if(mes.flag==true){
						// 在上方中部显示消息窗口
						$.messager.show({
							title:'提示',
							msg:mes.message,
							showType:'show',
							style:{
								right:'',
								top:document.body.scrollTop+document.documentElement.scrollTop,
								bottom:''
							}
						});
						$('#dg').datagrid('reload');
					}else{
						// 在上方中部显示消息窗口
						$.messager.show({
							title:'提示',
							msg:'系统繁忙，请稍后重试',
							showType:'show',
							style:{
								right:'',
								top:document.body.scrollTop+document.documentElement.scrollTop,
								bottom:''
							}
						});
					}
					
				}
			});
		}else{
			// 在上方中部显示消息窗口
			$.messager.show({
				title:'提示',
				msg:'资费是开通状态，不能删除',
				showType:'show',
				style:{
					right:'',
					top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:''
				}
			});
		}
	}else{
		// 在上方中部显示消息窗口
		$.messager.show({
			title:'提示',
			msg:'请选择一条数据',
			showType:'show',
			style:{
				right:'',
				top:document.body.scrollTop+document.documentElement.scrollTop,
				bottom:''
			}
		});
	}
}

// 开通资费
function updatePayStatus() {
	var value = $("#dg").datagrid('getSelected');
	if(value!=null){
		if(value.payStatus==0){
			var pay={id:value.id}
			var json=$.toJSON(pay);
			$.ajax({
				type:"post",
				url:"paymag/updatePayStatus",
				async:true,
				data:json,
				contentType:"application/json",
				success:function(mes){
					if(mes.flag==true){
						// 在上方中部显示消息窗口
						$.messager.show({
							title:'提示',
							msg:mes.message,
							showType:'show',
							style:{
								right:'',
								top:document.body.scrollTop+document.documentElement.scrollTop,
								bottom:''
							}
						});
						$('#dg').datagrid('reload');
					}else{
						// 在上方中部显示消息窗口
						$.messager.show({
							title:'提示',
							msg:'系统繁忙，请稍后重试',
							showType:'show',
							style:{
								right:'',
								top:document.body.scrollTop+document.documentElement.scrollTop,
								bottom:''
							}
						});
					}
					
				}
			});
		}else{
			// 在上方中部显示消息窗口
			$.messager.show({
				title:'提示',
				msg:'资费已是开通状态',
				showType:'show',
				style:{
					right:'',
					top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:''
				}
			});
		}
	}else{
		// 在上方中部显示消息窗口
		$.messager.show({
			title:'提示',
			msg:'请选择一条数据',
			showType:'show',
			style:{
				right:'',
				top:document.body.scrollTop+document.documentElement.scrollTop,
				bottom:''
			}
		});
	}
	
}

//按开通日期查询内容
function doSearch() {
	var date=new Date();
	var dateTime=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
	var begin=$("#searchBegin").val();
	var end=$("#searchEnd").val();
	var options = $("#dg" ).datagrid("getPager" ).data("pagination" ).options;
    var page = options.pageNumber;
    var rows = options.pageSize;
	if(begin==null||begin==""){
		begin='1970-01-01';
	}
	if(end==null||end==""){
		end=dateTime;
	}
	var dateArray=[begin,end];
	$.ajax({
		type:"post",
		url:"paymag/findPaysByDate",
		async:true,
		data:{"data":dateArray,"page":page,"rows":rows},
		dataType: 'json',
		success:function(mes){
			//将来自后台的数据显示在页面上，调用loadData方，里面传值为json对象
			$('#dg').datagrid('loadData',mes);
		}
	});
}


//暂停资费
function pausePay() {
	var value = $("#dg").datagrid('getSelected');
	if(value!=null){
		if(value.payStatus!=0){
			$.ajax({
				type:"post",
				url:"paymag/pausePay",
				async:true,
				data:{"id":value.id},
				dataType: 'json',
				success:function(mes){
					if(mes.flag==true){
						// 在上方中部显示消息窗口
						$.messager.show({
							title:'提示',
							msg:mes.message,
							showType:'show',
							style:{
								right:'',
								top:document.body.scrollTop+document.documentElement.scrollTop,
								bottom:''
							}
						});
						$('#dg').datagrid('reload');
					}else{
						// 在上方中部显示消息窗口
						$.messager.show({
							title:'提示',
							msg:mes.message,
							showType:'show',
							style:{
								right:'',
								top:document.body.scrollTop+document.documentElement.scrollTop,
								bottom:''
							}
						});
					}
				}
			});
		}else{
			// 在上方中部显示消息窗口
			$.messager.show({
				title:'提示',
				msg:'资费已是暂停状态',
				showType:'show',
				style:{
					right:'',
					top:document.body.scrollTop+document.documentElement.scrollTop,
					bottom:''
				}
			});
		}
		
	}else{
		// 在上方中部显示消息窗口
		$.messager.show({
			title:'提示',
			msg:'请选择一条数据',
			showType:'show',
			style:{
				right:'',
				top:document.body.scrollTop+document.documentElement.scrollTop,
				bottom:''
			}
		});
	}
}

// 后台到前台的日期处理
Date.prototype.format = function (format) {  
    var o = {  
        "M+": this.getMonth() + 1, // month
        "d+": this.getDate(), // day
        "h+": this.getHours(), // hour
        "m+": this.getMinutes(), // minute
        "s+": this.getSeconds(), // second
        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
        "S": this.getMilliseconds()  
        // millisecond
    }  
    if (/(y+)/.test(format))  
        format = format.replace(RegExp.$1, (this.getFullYear() + "")  
            .substr(4 - RegExp.$1.length));  
    for (var k in o)  
        if (new RegExp("(" + k + ")").test(format))  
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  
    return format;  
}  
function formatDatebox(value) {  
    if (value == null || value == '') {  
        return '';  
    }  
    var dt;  
    if (value instanceof Date) {  
        dt = value;  
    } else {  
        dt = new Date(value);  
    }  
  
    return dt.format("yyyy-MM-dd"); // 扩展的Date的format方法(上述插件实现)
}  

// 格式化开通状态
function formatPrice(val,row){
	if (val == 0){
		return '未开通';
	} else if(val == 1){
		return '已开通';
	}
}

