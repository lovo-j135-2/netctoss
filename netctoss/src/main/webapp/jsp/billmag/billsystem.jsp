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
<title>账单管理系统</title>

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
	
	<div id="tb" style="padding: 3px">
			<select id="year" class="easyui-combobox" name="state" label="年" labelPosition="top" style="width:100px;float:left;">
			</select>
			<select id="month" class="easyui-combobox" name="state" label="月" labelPosition="top" style="width:100px;float:left;">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
			</select>
			
			<span>身份证号</span> 
			<input id="id_num" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:150px">&nbsp;&nbsp;
			<span>用户名</span> 
			<input id="realName" class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:150px">&nbsp;&nbsp;
			<span>账务账号</span> 
			<input id="accountId" class="easyui-textbox" data-options="iconCls:'icon-billing'" style="width:150px">&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton" plain="true"
				onclick="doSearch()">查询</a>
	</div><br/>
	
	<table id="dg" title="账务账单信息" class="easyui-datagrid"
		style="width: auto; height: auto" pagination="true"
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

	<script type="text/javascript" src="<%=basePath%>static/js/billmag/billsystem.js"></script>
	
</body>
</html>