<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>角色管理</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/demo.css">
	<script type="text/javascript" src="<%=basePath %>static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript"	src="<%=basePath%>static/easy_ui-1.5.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>static/js/jquery.json-2.4.js"></script>
</head>
<body>
	
	<div style="margin:20px 0;"></div>
	<table id="dg" title="角色管理" style="width:700px;height:450px"
			data-options="
			rownumbers:true,
			singleSelect:true,
			pagination:true,
			url:'datagrid_data1.json',
			method:'get',
			toolbar:'#tool'
			">
		<thead>
			<tr>
				<th field="name" width="320" align="center">角色名称</th>
				<th field="roleType" width="320" align="center">角色类型</th>
				
			</tr>
		</thead>
	</table>
	
	<div id="tool">
			<div style="height:30px;margin-top:15px">
					<span style="margin-left:20px">角色名称：<input type="text" id="searchName"></span>
					<span style="margin-left:20px">
						角色类型：
						<select id="searchType" style="width:130px">
							<option value="%">全部</option>
							<option value="user">用户</option>
							<option value="admin">管理员</option>
						</select>
						</span>
					<span style="margin-left:20px"><input type="button" value="查询" onclick="searchRole()"></span>
			</div>
			<div style="height:40px;margin-top:10px">
					<span style="margin-left:20px"><input type="button" value="添加角色" onclick="saveButton()"></span>
					<span style="margin-left:120px"><input type="button" value="修改角色" onclick="updateButton()"></span>
					<span style="margin-left:120px"><input type="button" value="删除角色" onclick="deleteButton()"></span>
			</div>
	</div>
	
	<div id="w" closed="true" class="easyui-window" title="添加角色" data-options="iconCls:'icon-save'" style="width:400px;height:400px;padding:10px;">
			<form id="ff" method="post">
					<div style="margin-bottom:20px">
							<input  id="roleName" class="easyui-textbox" name="name" style="width:100%" data-options="label:'用户名称：',required:true">
					</div>
					<div style="margin-bottom:20px">
							<select id="roleType" class="easyui-combobox" name="type" label="用户类型：" style="width:100%">
									<option value="user">用户</option>
									<option value="admin">管理员</option>
							</select>
					</div>
					<div id="checkBoxList" style="height:200px"></div>
			</form>
			<div style="text-align:center;padding:5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="save()" style="width:80px">确定</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')" style="width:80px">取消</a>
			</div>
	</div>
	<div id="u" closed="true" class="easyui-window" title="修改角色" data-options="iconCls:'icon-save'" style="width:400px;height:400px;padding:10px;">
			<form id="ff" method="post">
					<div style="margin-bottom:20px">
							<input  id="roleNameToUpdate" class="easyui-textbox" name="name" style="width:100%" data-options="label:'用户名称：',required:true">
					</div>
					<div style="margin-bottom:20px">
							<select id="roleTypeToUpdate" class="easyui-combobox" name="type" label="用户类型：" style="width:100%">
									<option value="user">用户</option>
									<option value="admin">管理员</option>
							</select>
					</div>
					<div id="checkBoxListUpdate" style="height:200px"></div>
			</form>
			<div style="text-align:center;padding:5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateRole()" style="width:80px">确定</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#u').window('close')" style="width:80px">取消</a>
			</div>
	</div>
	<div id="d" closed="true" class="easyui-window" title="删除角色" data-options="iconCls:'icon-save'" style="width:300px;height:120px;padding:10px;">
			<div style="text-align:center;padding:5px 0">
					<label>确定删除该权限吗？</label><br><br>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="deleteRole()" style="width:80px">确定</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#d').window('close')" style="width:80px">取消</a>
			</div>
	</div>
	
	
	<script type="text/javascript">
		var rid;
		show = function(){
			$('#dg').datagrid({
				url:"role/show",
			});
		}
		
		window.onload=show();
		
		function updateButton(){
			var row=$('#dg').datagrid('getSelected');//获取选中行在mysql数据库中的id
			if(row==null||row==""){
				alert("请选中一行数据");
			}else{
				rid=row.id;
				var right={"id":rid};
				$('#u').window('open');
				$('#roleNameToUpdate').textbox("setValue",row.name);
				//console.info(row.roleType);
				$('#roleTypeToUpdate').combobox("setValue",row.roleType);
				$.ajax({
					type:"POST",
					url:"role/searchRightOfRole",
					data:right,
					dataType:"json",
					async:true,
					 success:function(idList){
						checked(idList);				
					}
				})
			}
		}
		
		function deleteButton(){
			var row=$('#dg').datagrid('getSelected');//获取选中行在mysql数据库中的id
			if(row==null||row==""){
				alert("请选中一行数据");
			}else{
				rid=row.id;
				$('#d').window('open');
			}
		}

		function deleteRole(){
			var right={"id":rid};
			$.ajax({
				type:"POST",
				url:"role/delete",
				data:right,
				
				async:true,
				 success:function(data){
					alert("删除成功");
					$('#d').window('close');
					show();
				}
			})
		}
		
		function updateRole(){
			var rname=$("#roleNameToUpdate").val();
			var rtype=$("#roleTypeToUpdate").val();
			var rightId=new Array();
			if(rname==null||rname==""){
				alert("用户名称不能为空");
			}else{
				//console.info(rname);
				//console.info(rtype);
				$(".rightUpdate").each(function(){//根据checkbox的class属性来定位
					if($(this).is(":checked")){//如果该复选框被选中
						//console.info($(this).val());
						rightId.push($(this).val());
					}
				})
				console.info(rightId);
				var role={'name':rname,'roleType':rtype,'id':rightId,'roleId':rid};				
				$.ajax({
					type:"POST",
					url:"role/update",
					data:role,
					dataType:"text",
					async:true,
					success:function(data){
						alert("修改成功");
						$('#u').window('close');
						show();
					}
				})	
			}
		}
		
		function checked(idList){
			$('#checkBoxListUpdate').text("");
			$.ajax({
				type:"POST",
				url:"role/searchRight",
				dataType:"json",
				async:true,
				 success:function(data){
					//console.info(data);	
					$.each(data,function(i,item){
						$("#checkBoxListUpdate").append("<input type='checkbox' class='rightUpdate' value='"+item.id+"' name='header'/>"+item.name);
						//动态添加checkbox
					});
					$(".rightUpdate").each(function(){
						//console.info($(this).val());
						for(var i=0;i<idList.length;i++){
							if($(this).val()==idList[i]){
								//console.info(idList[i]);
								$(this).attr("checked",'true');
							}
						}
					});
				}
			});
			//console.info(idList.length);
			
		}
		
		function searchRole(){
			var sname=$('#searchName').val();
			if(sname==""){
				sname="%";
			}
			var stype=$('#searchType').val();
			var role={name:sname,roleType:stype};
			var json=$.toJSON(role);
			$.ajax({
				type:"POST",
				url:"role/searchRole",
				data:json,
				contentType:"application/json",
				async:true,
				success:function(data){
					console.info(data);
					
					$('#dg').datagrid('loadData',data);
						//url:"role/searchRole",
						//'loadData',data;
					
					//$('#dg').datagrid("options").url = 'role/searchRole'; 
					//$('#dg').datagrid('load');
				}
			})
		}
		
		function saveButton(){
			$('#roleName').textbox("setValue","");
			$('#checkBoxList').text("");
			$('#w').window('open');
			$.ajax({
				type:"POST",
				url:"role/searchRight",
				dataType:"json",
				async:true,
				 success:function(data){
					//console.info(data);	
					$.each(data,function(i,item){
						$("#checkBoxList").append("<input type='checkbox' class='right' value='"+item.id+"' name='header'/>"+item.name);
						//动态添加checkbox
					});
				}
			})
		}
		
		function save(){
			var rname=$("#roleName").val();
			var rtype=$("#roleType").val();
			var rightId=new Array();
			if(rname==null||rname==""){
				alert("用户名称不能为空");
			}else{
				//console.info(rname);
				//console.info(rtype);
				$(".right").each(function(){//根据checkbox的class属性来定位
					if($(this).is(":checked")){//如果该复选框被选中
						//console.info($(this).val());
						rightId.push($(this).val());
					}
				})
				//console.info(rightId);
				var role={'name':rname,'roleType':rtype,'id':rightId};

				$.ajax({
					type:"POST",
					url:"role/save",
					data:role,
					dataType:"text",
					async:true,
					success:function(data){
						alert("添加成功");
						$('#w').window('close');
						show();
					}
				})	
			}
		}
		
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					handler:function(){
						alert('search');
					}
				},{
					handler:function(){
						alert('add');
					}
				},{
					handler:function(){
						alert('edit');
					}
				}]
			});			
		})
		
		
	</script>

</body>
</html>