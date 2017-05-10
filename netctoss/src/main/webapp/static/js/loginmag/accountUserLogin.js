$(function() {
	//登录
	$('#one').click(function() {
		var accountName = $('#account_name').val();
		var pwd = $('#password').val();
		
		
		$.ajax({
			type : "Get",
			url : uri,
			async : true,
			success : function(data) {
				alert(data.account_name);

			}

		});

	});
	//修改个人密码
	$('#two').click(function(){
		//user需要修改的信息，
		var account = {id : "1",account_name : "张三",password : "123456"};
		var json = $.toJSON(account);//将JS对象转换为JSON对象
		var id=$('#id').val();//需要修改的对象id
		var uri="accountUserLogin/" +id;
		$.ajax({
			type:"put",
			url:uri,
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				alert(data.status);
				alert(data.msg);
			}
		});
	});
	
	//查询
	$('#three').click(function(){
		var id=$('#id').val();//需要修改的对象id
		var uri="accountUserLogin/" +id;
		$.ajax({
			type:"GET",
			url:uri,		
			async:true,
			success:function(data){
				alert(data.account_name);	
			}
		});
	});


});