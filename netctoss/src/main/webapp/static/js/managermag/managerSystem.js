		//弹窗添加用户窗口
		function newUser() {
			$('#dlg').dialog('open').dialog('setTitle', '添加管理员');
			$('#fm').form('clear');
			
			

			//添加管理员下拉框
			$('#addRoleName').combobox({    
			    url:'managermag/showRole',    
			    valueField:'id',    
			    textField:'name'   
			}); 
			
						
		}
		
		

		
		function saveUser() {

			var name = $("#addUserNAme").val();
			var accounts = $("#addAccounts").val();
			var password = $("#addPassword").val();
			var phone = $("#addPhone").val();
			var postcode = $("#addPostcode").val();
			var ro = $("#addRoleName").val();
			
			console.info(name,accounts,password,phone,postcode,role);
			
			var role ={
				"id":ro,
				"name":null,
				"roleType":null,
				
			};
			
			var manager = {
				"name" : name,
				"accounts" : accounts,
				"password" : password,
				"phone" : phone,
				"postcode" : postcode,
				"role" : role,
				
			};
			var json = $.toJSON(manager);//将JS对象转换为JSON对象
			console.info(json)
			var uri = "managermag/save";

			$.ajax({
				type : "post",
				url : uri,
				data : json,
				contentType : "application/json",
				async : true,
				success : function(result) {
					$.messager.show({
						title : '提示信息',
						msg : result.message
					});

				}
			});
		}
		
		
		//删除用户
		function doCancel() {
			var ids = [];
			var rows = $('#dg').datagrid('getSelections');
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}			

			var uri = 'managermag/' + ids;

			alert(uri);
			$.ajax({
				type : "DELETE",
				url : uri,
				async : true,
				success : function(data) {
					$.messager.show({
						title : '提示信息',
						msg : data.message
					});
				}

			});

		}
		
		
		
		//修改管理员
		function editUser() {
			var row = $('#dg').datagrid('getSelected');
			$('#edit').dialog('open').dialog('setTitle', '修改管理员');	
			
			if(row){			
				$("#editUserNAme").html(row.name);
				$("#editAccounts").val(row.accounts);
				$("#editPassword").val(row.password);
				$("#editPhone").val(row.phone);
				$("#editPostcode").val(row.postcode);								
				$("#editRoleName").val(row.role.name);
				
				console.info($("#editRoleName").val());
				console.info(row.role.name);
				
			}
			
			//修改管理员下拉框
			$('#editRoleName').combobox({    
			    url:'managermag/showRole',    
			    valueField:'id',    
			    textField:'name'   
			}); 
			
			console.info(row);
			
		}

		function doEdit(){						
			var row = $('#dg').datagrid('getSelected');
			
			var name = $("#editUserNAme").html();
			var accounts = $("#editAccounts").val();
			var password = $("#editPassword").val();
			var phone = $("#editPhone").val();
			var postcode = $("#editPostcode").val();
			var ro = $("#editRoleName").val();	
			if(ro==row.role.name){
				 ro=row.role.id;
			}else if(ro!=row.role.name){
				ro=$("#editRoleName").val();
			}
			
				console.info("下拉框值"+ro);			
			var id = row.id;
			console.info(row.id);
			var role ={
					"id":ro,
					"name":null,
					"roleType":null,
					
				};
				
				var manager = {
					"id":id,
					"name" : name,
					"accounts" : accounts,
					"password" : password,
					"phone" : phone,
					"postcode" : postcode,
					"role" : role,
					
				};
				var json = $.toJSON(manager);//将JS对象转换为JSON对象
				console.info(json)				
				var uri = 'managermag/update';
				$.ajax({
					type:"POST",
					url:uri,
					data:json,
					contentType:"application/json",
					async:true,
					success : function(result) {
						$.messager.show({
							title : '提示信息',
							msg : result.message
						});

					}
					
				});
				
		}
		
		
		
