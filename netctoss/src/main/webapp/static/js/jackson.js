$(function(){
	//单个新增或修改
	$('#one').click(function(){
		var user = {id:"1",userName:"张三",password:"123456"};
		var json = $.toJSON(user);//将JS对象转换为JSON对象
		$.ajax({
			type:"POST",
			url:"jsons/one",
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				alert(data.status);
				alert(data.msg);
			}
		});
	});
	
	
	//批量新增或修改
	$('#two').click(function(){
		var user = {id:"1",userName:"张三",password:"123456"};
		var user2 = {id:"2",userName:"李四",password:"123456"};
		var users = [];
		users.push(user);
		users.push(user2);
		
		var json = $.toJSON(users);//将JS数组转换为JSONArray对象
		
		$.ajax({
			type:"POST",
			url:"jsons/two",
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				alert(data.status);
				alert(data.msg);
			}
		});
	});
	
	//单个删除
	$('#three').click(function(){
		var id = 1;
		var json = $.toJSON(id);//将JS对象转换为JSON对象
		
		$.ajax({
			type:"POST",
			url:"jsons/three",
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				alert(data.status);
				alert(data.msg);
			}
		});
	});
	
	//批量删除
	$('#four').click(function(){
		var id = 1;
		var id2 = 2;
		var ids = [];
		ids.push(id);
		ids.push(id2);
		
		var json = $.toJSON(ids);//将JS对象转换为JSONArray对象
		
		$.ajax({
			type:"POST",
			url:"jsons/four",
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				alert(data.status);
				alert(data.msg);
				
			}
		});
	});
	
	$('#five').click(function(){
		var name = "老张";
		var json = $.toJSON(name);//将JS对象转换为JSON对象
		
		$.ajax({
			type:"POST",
			url:"jsons/five",
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				var length = data.length;
				for(var i = 0; i < length ; i ++){
					alert(data[i].userName);
				}
			}
		});
	});
	
	
	$('#six').click(function(){
		var name = "老张";
		var json = $.toJSON(name);//将JS对象转换为JSON对象
		
		$.ajax({
			type:"POST",
			url:"jsons/six",
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				alert(data.status);
				alert(data.msg);
				
			}
		});
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});