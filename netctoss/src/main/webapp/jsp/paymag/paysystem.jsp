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
<title>资费管理系统</title>

	<link rel="stylesheet" type="text/css"
		href="<%=basePath%>static/easy_ui-1.5.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"
		href="<%=basePath%>static/easy_ui-1.5.2/themes/icon.css">
	<script type="text/javascript"
		src="<%=basePath%>static/js/jquery-3.1.1.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>static/easy_ui-1.5.2/jquery.easyui.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>static/easy_ui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>

	<table id="dg" title="资费信息一览表" class="easyui-datagrid"
		style="width: auto; height: auto" pagination="true"
		url="paymag/load"
		toolbar="#toolbar" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th data-options="field:'payName',width:100">资费名称</th>
				<th data-options="field:'payType',width:100">资费类型</th>
				<th data-options="field:'payTime',width:100,align:'right'">基本时长</th>
				<th data-options="field:'basicCost',width:100,align:'right'">基本费用</th>
				<th data-options="field:'unitCost',width:100,align:'right'">单位费用（元/月）</th>
				<th data-options="field:'costDiscrip',width:100,align:'right'">资费说明</th>
				<th data-options="field:'payStatus',width:100,align:'right'">资费状态</th>
				<th data-options="field:'createTime',width:100,align:'right'">创建时间</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="newUser()">New User</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-edit" plain="true"
			onclick="editUser()">Edit User</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="destroyUser()">Remove User</a>
	</div>


	<script type="text/javascript">
		
		
	</script>
</body>
</html>