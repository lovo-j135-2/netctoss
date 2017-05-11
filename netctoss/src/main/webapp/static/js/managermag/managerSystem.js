		//弹窗添加用户窗口
		function newUser() {
			$('#dlg').dialog('open').dialog('setTitle', '添加管理员');
			$('#fm').form('clear');
			url = 'save_user.php';
			

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
			alert(json)
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
			console.info(row);
			
		}

		
		
		
