window.onload=function(){
	
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
//		columns: [[  
//			{field: 'real_name', title: '姓名', width: 100,align: 'center'},
//			{field: 'id_num', title: '身份证', width: 100,align: 'center'},
//			{field: 'account_name', title: '账务账号', width: 100,align: 'center'},
//			{field: 'monthCostAccount', title: '本月消费（RMB）', width: 100,align: 'center',formatter: forCost},
//			{field: 'monthCostAccount', title: '月份', width: 100,align: 'center',formatter: forMonth},
//			{field: 'monthCostAccount', title: '支付方式', width: 100,align: 'center',formatter: forPayWay},
//			{field: 'monthCostAccount', title: '资费状态', width: 100,align: 'center',formatter: forPayStatus},
//        ]]   
	})
}

//加载年份下拉框  
function loadSelect(){
	var date=new Date();
	var dateTime=date.getFullYear();
	var beginYear='2017';
	var length= parseInt(dateTime)- parseInt(beginYear);
	$("<option></option>").val(beginYear).text(beginYear).appendTo($("#year"));
	var year=parseInt(beginYear)+1;
	for (var i = 0; i < length; i++) {
		$("<option></option>").val(year).text(year).appendTo($("#year"));
		year++;
	}
}

loadSelect();

function showDetailWin(){
	var value = $("#dg").datagrid('getSelected');
	var options = $("#detailTable").datagrid("getPager" ).data("pagination" ).options;
    var page = options.pageNumber;
    var rows = options.pageSize;
	if(value!=null){
		$('#showDetail').dialog('open');
		$('#detailTable').form('clear');
		$("#accountID").text();
		$("#accountID").text("账号："+value.account_name);
		$.ajax({
			type:"post",
			url:"billmag/searchBusinessMonthDetail",
			async:true,
			data:{"year":$("#year").val(),
					"month":$("#month").val(),
					"page":page,"rows":rows,
					"id":value.id
			},
			dataType : "json",
			success:function(mes){
				$('#detailTable').datagrid('loadData',mes);
			}
		})
	}else{
		// 在上方中部显示消息窗口
		$.messager.show({
			title:'提示',
			msg:'请选择一条信息',
			showType:'show',
			style:{
				right:'',
				top:document.body.scrollTop+document.documentElement.scrollTop,
				bottom:''
			}
		});
	}
}

function payWin(){
	var value = $("#dg").datagrid('getSelected');
	if(value!=null){
		if(value.monthCostAccount.payStatus==0){
			$('#payBill').dialog('open');
		}else{
			// 在上方中部显示消息窗口
			$.messager.show({
				title:'提示',
				msg:'感谢，本月费用已支付',
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
			msg:'请选择一条信息',
			showType:'show',
			style:{
				right:'',
				top:document.body.scrollTop+document.documentElement.scrollTop,
				bottom:''
			}
		});
	}
}

//支付账单
function pay() {
	var value = $("#dg").datagrid('getSelected');
	var payWay=$("#payWay").val();
	$.ajax({
		type:"post",
		url:"billmag/payBill",
		async:true,
		data:{"year":$("#year").val(),
				"month":$("#month").val(),
				"payWay":payWay,
				"id":value.monthCostAccount.accountId
		},
		dataType : "json",
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
				$('#payBill').dialog('close');
				doSearch();
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
	})
}

//查询功能
function doSearch() {
	var options = $("#dg").datagrid("getPager" ).data("pagination" ).options;
    var page = options.pageNumber;
    var rows = options.pageSize;
    var id_num=$("#id_num").val();
    var realName=$("#realName").val();
    var accountName=$("#accountName").val();
	$.ajax({
		type:"post",
		url:"billmag/searchDetail",
		async:true,
		data:{"year":$("#year").val(),
				"month":$("#month").val(),
				"page":page,"rows":rows,
				"id_num":id_num,
				"realName":realName,
				"accountName":accountName
		},
		dataType : "json",
		success:function(mes){
			$('#dg').datagrid('loadData',mes);
		}
	})
}

