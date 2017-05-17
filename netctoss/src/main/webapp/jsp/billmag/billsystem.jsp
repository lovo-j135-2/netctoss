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
			<input id="accountName" class="easyui-textbox" data-options="iconCls:'icon-billing'" style="width:150px">&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton" plain="true"
				onclick="doSearch()">查询</a>
	</div><br/>
	
	<table id="dg" title="账务账单信息" class="easyui-datagrid"
		style="width: auto; height: auto" pagination="true"
		toolbar="#toolbar" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th data-options="field:'real_name',width:100">姓名</th>
				<th data-options="field:'id_num',width:100">身份证</th>
				<th data-options="field:'account_name',width:100,align:'right'">账务账号</th>
				<th data-options="field:'monthCostAccount.cost',width:100,align:'right',formatter:forCost">本月消费（RMB）</th>
				<th data-options="field:'monthCostAccount.month',width:100,align:'right',formatter:forMonth">月份</th>
				<!-- <th data-options="field:'monthCostAccount.payWay',width:100,align:'right',formatter:forPayWay">支付方式</th> -->
				<th data-options="field:'monthCostAccount.payStatus',width:100,align:'right',formatter:forPayStatus">资费状态</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="showDetailWin()">账单详细信息</a>
			
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
			onclick="payWin()">支付</a> 
	</div>
	
	
	<!-- 显示详细账单信息窗口 -->
	<div id="showDetail" class="easyui-dialog"
		style="width: 600px; height: 400px; padding: 10px 20px" closed="true"
		title="账单明细" buttons="#dlg-buttons">
		<label id="accountID"></label>
		<table id="detailTable"  class="easyui-datagrid"
					style="width: auto; height: auto" pagination="true"
					toolbar="#toolbar" rownumbers="true" fitColumns="true"
					singleSelect="true">
				<thead>
					<tr>
						<th data-options="field:'bussiness.id',width:50,formatter:forBusiId">业务账号</th>
						<th data-options="field:'ip',width:50">服务器IP</th>
						<th data-options="field:'time',width:50">时长</th>
						<th data-options="field:'cost',width:50">费用</th>
						<th data-options="field:'payType',width:50">支付状态</th>
					</tr>
				</thead>
		</table>
	</div>
	<div id="dlg-buttons">
		<!-- <a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="savePay()">确定</a> --> 
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#showDetail').dialog('close')">取消</a>
	</div>
	
	
	<!-- 显示支付窗口 -->
	<div id="payBill" class="easyui-dialog"
		style="width: 350px; height: 200px; padding: 10px 20px" closed="true"
		title="支付本月账单" buttons="#dlg-buttons">
		<select id="payWay" class="easyui-combobox" name="state" label="月" labelPosition="top" style="width:100px;float:left;">
					<option value="1">支付宝</option>
					<option value="2">微信</option>
					<option value="3">银联</option>
			</select>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="pay()">确定</a>
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#payBill').dialog('close')">取消</a>
	</div>

	<script type="text/javascript" src="<%=basePath%>static/js/billmag/billsystem.js"></script>
	
	<script type="text/javascript">
		function forCost(value,rec) {
			return rec.monthCostAccount['cost'];
		};
		function forMonth(value,rec) {
			return rec.monthCostAccount.month;
		};
		function forPayWay(value,rec) {
			var payWay=rec.monthCostAccount.payWay
			return rec.monthCostAccount.payWay;
		};
		function forPayStatus(value,rec) {
			value=rec.monthCostAccount.payStatus;
			if (value == 0){
				return rec.monthCostAccount.payStatus+'未支付';
			} else if(value == 1){
				return rec.monthCostAccount.payStatus+"已支付";
			}
		};
		
		function forBusiId(value,rec) {
			return rec.bussiness.id;
		};
		
		
	</script>
</body>
</html>