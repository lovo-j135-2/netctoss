<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理系统</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/easy_ui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/easy_ui-1.5.2/themes/icon.css">
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery-3.1.1.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/easy_ui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/managermag/managerSystem.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/easy_ui-1.5.2/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>

	<table id="dg" title="管理员信息一览表" class="easyui-datagrid"
		url="managermag/show" style="width: auto; height: auto"
		pagination="true" toolbar="#toolbar" rownumbers="true"
		fitColumns="true" singleSelect="true" ondblclick="onClickCell">
		<thead>
			<tr>
				<th field="name" width="80">名称</th>
				<th field="accounts" width="80" align="right">账号</th>
				<th field="password" width="80" align="right">密码</th>
				<th field="phone" width="150">电话</th>
				<th field="postcode" width="150">邮箱</th>
				<th field="role" formatter="forRoleName" width="150">管理员角色</th>
				<!-- <th field="role" formatter="forRoleType" width="150">角色类型</th> -->
			
			</tr>
		</thead>

	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newUser()">增加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUser()">修改</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="doCancel()">删除</a>
	</div>
	
	
	
		<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">添加管理员</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label>用户名:</label> <br> <input name="name"
					class="easyui-validatebox" required="true" id="addUserNAme">
			</div>
			<div class="fitem">
				<label>账号:</label><br> <input name="accounts"
					class="easyui-validatebox" required="true" id="addAccounts">
			</div>
			<div class="fitem">
				<label>密码:</label><br> <input name="password" 
				required="true" type="password" class="easyui-validatebox" id="addPassword">
			</div>
			<div class="fitem">
				<label>电话:</label><br> <input name="phone" id="addPhone">
			</div>
			<div class="fitem">
				<label>Email:</label><br> <input name="postcode"
					class="easyui-validatebox" validType="email" id="addPostcode">
			</div>
			<div class="fitem">
			<label>角色类型</label><br><input id="addRoleName" name="dept" value="aa"> 
	</input>
	</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveUser()">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">退出</a>
	</div>
	
	
	

	
	
	
	<script type="text/javascript">
		function forRoleName(value) {
			return value.name;
		};
		function forRoleType(value) {
			return value.roleType;
		};
		
		
		
		
	</script>

</body>
</html>