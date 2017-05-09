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
<title>账务管理系统</title>

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
	
	<div class="easyui-tabs" style="width:auto;height:auto;">
		<div title="按月查询账务" style="padding:60px;">
			<div id="tb" style="padding: 3px">
				<select id="year" class="easyui-combobox" name="state" label="年" labelPosition="top" style="width:100px;">
					<option value="2016">2016</option>
				</select>
				<select id="month" class="easyui-combobox" name="state" label="月" labelPosition="top" style="width:100px;">
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
				<a href="javascript:void(0)" class="easyui-linkbutton" plain="true"
					onclick="doSearch()">查询</a>
			</div>
			
			<table id="monthTable" title="资费信息一览表" class="easyui-datagrid"
				style="width: auto; height: auto" pagination="true"
				toolbar="#toolbar" rownumbers="true" fitColumns="true"
				singleSelect="true">
				<thead>
					<tr>
						<th data-options="field:'year',width:50">年</th>
						<th data-options="field:'month',width:50">月</th>
						<th data-options="field:'day',width:50">日</th>
						<th data-options="field:'time',width:50">总时长</th>
						<th data-options="field:'ip',width:50">实验室ip</th>
					</tr>
				</thead>
			</table>
		</div>
		
		
		<div title="按年查询账务"  style="padding:60px;">
			Second Tab
		</div>
	</div>
	

	<script type="text/javascript" src="<%=basePath%>static/js/accountmag/accountsystem.js"></script>
	
</body>
</html>