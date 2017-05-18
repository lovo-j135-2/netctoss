window.onload=function(){
	
	// 加在页面时，加载数据
	var s=$('#dg').datagrid({
		url : "businessmag/load",
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


//打开添加业务窗口
function addBusiness() {
	$("#accountType").text("");
	$("#labType").text("");
	$("#payType").text("");
	$('#addBusiness').dialog('open');
	$('#add').form('clear');
	loadAccountAndPayAndLab();
}

function loadAccountAndPayAndLab() {
	$.ajax({
		type:"POST",
		url:"businessmag/loadAccount",
		contentType:"application/json",
		async:true,
		success:function(data){
			for (var i = 0; i < data.length; i++) {
				$("<option></option>").val(data[i].id).text(data[i].account_name).appendTo($("#accountType"));
			}
		}
	});
	
	$.ajax({
		type:"POST",
		url:"businessmag/loadPay",
		contentType:"application/json",
		async:true,
		success:function(data){
			console.info(data)
			for (var i = 0; i < data.length; i++) {
				$("<option></option>").val(data[i].id).text(data[i].payName).appendTo($("#payType"));
			}
		}
	});
	
	$.ajax({
		type:"POST",
		url:"businessmag/loadLab",
		contentType:"application/json",
		async:true,
		success:function(data){
			for (var i = 0; i < data.length; i++) {
				$("<option></option>").val(data[i].id).text(data[i].ip_num).appendTo($("#labType"));
			}
		}
	});
}
/*function update() {
	$('#update').dialog('open');
}*/
function update() {
	var value = $('#dg').datagrid('getSelected');
	if(value!=null){
		$('#updatePassword').dialog('open');
		$("#updateBusinessName").text(value.id)
	}else{
		$.messager.show({
			title:'提示',
			msg:'请选择一条数据',
			showType:'show',
			style:{
				right:'',
				top:document.body.scrollTop+document.documentElement.scrollTop,
				bottom:''
			}
		})
	}
}
function queryBusiness() {
	$('#queryBusiness').dialog('open');
	$('#find').form('clear');
}

//添加业务
function saveBusiness() {
	//,fk_accountuser_id:$('#addName').val(),pay:$('#addPay').val(),lab:$('#addLab').val()
	//var business = {business_name:$('#addBusiness').val(),"password":$('#addPassword').val(),fk_accountuser_id:$('#cc').val(),pay:$('#dd').val(),lab:$('#ee').val()};
	var business = {"business_name":$('#addBusiness').val(),"password":$('#addPassword').val()};
	var json = $.toJSON(business);//将JS对象转换为JSON对象
	$.ajax({
		type:"POST",
		url:"businessmag/add",
		data:json,
		contentType:"application/json",
		async:true,
		success:function(data){
			//alert(data.message);
			//添加成功后刷新当前的表格数据
		/*	$('#dg').datagrid('reload',{
//				code: '01',
//				name: 'name01'
			});*/
			$('#addBusiness').dialog('close');
		}
	});
}
//删除业务
function deleteBusiness() {
	var value = $('#dg').datagrid('getSelected');
	if(value!=null){
		var userId = {id:value.id};
		var json = $.toJSON(userId);
		$.ajax({
			type:"POST",
			url:"businessmag/delete",
			async:true,
			data:json,
			contentType:"application/json",
			success:function(msg){
				//alert(msg.message);
				//删除成功后刷新当前的表格数据
				$('#dg').datagrid('reload');
			}
		})
	}else{
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

//修改业务密码
function updatePwd() {
	var user = {id:$("#updateBusinessName").text(),password:$('#comfirmPasswordI').val()};
	var json = $.toJSON(user);
	$.ajax({
		type:"POST",
		url:"businessmag/updatePwd",
		async:true,
		data:json,
		contentType:"application/json",
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
				$('#updatePassword').dialog('close');
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
	})
}

function showBusinessDetail() {
	var value = $("#dg").datagrid('getSelected');
	console.info(value);
	if (value != null) {
		$('#queryBusinessDetail').dialog('open');
		$('#showDetail').form('clear');
		$("#businessName").html(value.business_name);
		$("#businesssPassword").html(value.password);
		$("#accountNameDetail").html(value.fk_accountuser_id.account_name);
		$("#payTypeDetail").html(value.pay.payType);
		$("#ipName").html(value.lab.ip_num);
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



//查询业务
function query() {
	var va = {business_name:$('#query').val()};
	var json = $.toJSON(va);
	$.ajax({
		type:"POST",
		url:"businessmag/find",
		async:true,
		data:json,
		contentType:"application/json",
		success:function(msg){
			console.info(msg);
			$('#queryBusiness').dialog('close');
			$('#dg').datagrid('loadData',msg);//将查询返回的数据重新填充表格
		}
	})
}