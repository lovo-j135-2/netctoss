$(document).ready(function() {
	load();
})
function load() {
	var va = {page:"1",rows:"10"};
	var json = $.toJSON(va);
	$.ajax({
		type:"get",
		url:"businessmag/load",
		data:va,
		dataType:"json",
		success:function(data){
			//var json = $.parseJSON(data);
			var users = data.rows;
			var jsonArray = [];
			$.each(users,function(index, content){
				var a = {
                    'business_name' : content.business_name,
                    'id' :content.id,
					'password' : content.password,
                    'fk_accountuser_id' : content.fk_accountuser_id.account_name,
                    'pay' : content.pay.payType,
                    'lab' : content.lab.ip_num,
                };
				jsonArray.push(a);
			});
			var total = {total:data.total,rows:jsonArray};
			$('#dg').datagrid('loadData', total);
		},
		error : function() {
	        alert('error');
	    }
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
//打开添加业务窗口
function addBusiness() {
	$("#accountType").text("");
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
			console.info(data[0].id);
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
			for (var i = 0; i < data.length; i++) {
				$("<option></option>").val(data.id).text(data.account_name).appendTo($("#payType"));
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
				$("<option></option>").val(data[i].id).text(data[i].account_name).appendTo($("#labType"));
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
				$('#dg').datagrid('reload',{
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

//修改业务密码
function updatePwd() {
	var value = $('#dg').datagrid('getSelected');
	console.info(value);
	var user = {"id":value.id,"password":$('#updatePassword').val()};
	var json = $.toJSON(user);
	$.ajax({
		type:"POST",
		url:"businessmag/updatePwd",
		async:true,
		data:json,
		contentType:"application/json",
		success:function(msg){
			console.info(msg.message);
			load();
			$('#update').dialog('close');
		}
		
		
	})
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