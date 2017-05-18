window.onload=function(){
	var s=$('#dg').datagrid({
		url : "usermag/load",
	});
	$(function() {
		var pager = $('#dg').datagrid().datagrid('getPager');
		var options = $(pager).data("pagination").options;  
		// 将行数变为可选择的行数
		$(pager).pagination({
			pageSize:5,
			pageList: [5,10,15],
			beforePageText: '第',// 页数文本框前显示的汉字
    		afterPageText: '页    共 {pages} 页',  
    		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	})
	
}
function addAcconut() {
	$('#addAccont').dialog('open');
	$('#add').form('clear');
}
function que() {
	$('#queryAcconut').dialog('open');
	
}
//修改账务信息
function update() {
	var value = $('#dg').datagrid('getSelected');
	if(value!=null){
		$('#update').dialog('open');
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
//gender:$('#addGender').val(),id_num:$('#addIdNumber').val(),account_name:$('#addAcconutNumber').val(),password:$('#addPassword').val(),phone:$('#addPhone').val(),address:$('#addAddress').val(),
//添加账号
function saveAcconut() {
	var user = {real_name:$('#addName').val(),gender:$('#addGender').val(),id_num:$('#addIdNumber').val(),account_name:$('#addAcconutNumber').val(),password:$('#addPassword').val(),phone:$('#addPhone').val(),address:$('#addAddress').val(),postcode:$('#addPostcode').val(),qq:$('#addQq').val()};
	var json = $.toJSON(user);//将JS对象转换为JSON对象
	$.ajax({
		type:"POST",
		url:"usermag/add",
		data:json,
		contentType:"application/json",
		async:true,
		success:function(data){
			alert(data.message);
			//添加成功后刷新当前的表格数据
			$('#dg').datagrid('reload',{
//				code: '01',
//				name: 'name01'
			});
			$('#addAccont').dialog('close');
		}
	});
}

//删除账务账号
function deleteAcconut() {
	var value = $('#dg').datagrid('getSelected');
	if(value!=null){
		var userId = {id:value.id};
		var json = $.toJSON(userId);
		$.ajax({
			type:"POST",
			url:"usermag/delete",
			async:true,
			data:json,
			contentType:"application/json",
			success:function(msg){
				//alert(msg.message);
				//删除成功后刷新当前的表格数据
				$('#dg').datagrid('reload',{
//					code: '01',
//					name: 'name01'
				});
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
//开通账务
function updateAcconut() {
	var value = $('#dg').datagrid('getSelected');
	if(value!=null){
		if(value.status==0){
			var userId = {id:value.id,status:1};
			var json = $.toJSON(userId);
			$.ajax({
				type:"POST",
				url:"usermag/update",
				async:true,
				data:json,
				contentType:"application/json",
				success:function(msg){
					//alert(msg.message);
					//开通账务成功后刷新当前的表格数据
					$('#dg').datagrid('reload',{
//						code: '01',
//						name: 'name01'
					});
				}
			})
		}
		
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
//暂停账务
function stopAcconut() {
	var value = $('#dg').datagrid('getSelected');
	if(value!=null){
		if(value.status==1){
			var userId = {id:value.id,status:0};
			var json = $.toJSON(userId);
			$.ajax({
				type:"POST",
				url:"usermag/update",
				async:true,
				data:json,
				contentType:"application/json",
				success:function(msg){
					//alert(msg.message);
					//暂停账务账号成功后刷新当前的表格数据
					$('#dg').datagrid('reload',{
//						code: '01',
//						name: 'name01'
					});
				}
			})
		}
		
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

//修改账务信息
function updatePwd() {
	var value = $('#dg').datagrid('getSelected');
	console.info(value);
	var user = {id:value.id,password:$('#updatePassword').val(),phone:$('#updatePhone').val()};
	var json = $.toJSON(user);
	$.ajax({
		type:"POST",
		url:"usermag/updatePwd",
		async:true,
		data:json,
		contentType:"application/json",
		success:function(msg){
			//alert(msg.message);
			$('#dg').datagrid('reload',{
//				code: '01',
//				name: 'name01'
			});
			$('#update').dialog('close');
		}
		
		
	})
}

//查询账号
function query() {
	var user = {account_name:$('#query').val()};
	var json = $.toJSON(user);
	$.ajax({
		type:"POST",
		url:"usermag/query",
		async:true,
		data:json,
		contentType:"application/json",
		success:function(msg){
			$('#queryAcconut').dialog('close');
			$('#dg').datagrid('loadData',msg);//将查询返回的数据重新填充表格
		}
	})
	
}
