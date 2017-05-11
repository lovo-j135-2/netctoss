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
	<div id="tb" style="padding: 3px">
			<span>起始日期</span> <input id="searchBegin" class="easyui-datebox" 
			style="line-height: 26px; border: 1px solid #ccc">&nbsp;&nbsp;
			<span>结束日期</span> <input id="searchEnd" class="easyui-datebox" style="line-height: 26px; 
			border: 1px solid #ccc">&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton" plain="true"
				onclick="doSearch()">查询</a>
	</div>
	
	<table id="dg" title="资费信息一览表" class="easyui-datagrid"
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
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="addPayWin()">添加资费</a>
			
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
			onclick="updatePayWin()">修改资费</a> 
			
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-no" plain="true"
			onclick="deletePay()">删除资费</a>
			
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="updatePayStatus()">开通资费</a>
		
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-pwd" plain="true"
			onclick="destroyPay()">暂停资费</a>
	</div>


	<!-- 添加资费窗口 -->
	<div id="addPay" class="easyui-dialog"
		style="width: 450px; height: 350px; padding: 10px 20px" closed="true"
		title="新增资费" buttons="#dlg-buttons">
		<form id="addFM" method="post" style="padding: 10px 20px">
			<div class="fitem">
				<label>资费名称</label> <input id="addName" name="payName"
					class="easyui-validatebox" required="true" missingMessage="不能为空">
			</div><br>
			<div class="fitem">
				<label>资费类型</label> <input id="addType" name="payType"
					class="easyui-validatebox" required="true" missingMessage="不能为空">
			</div><br>
			<div class="fitem">
				<label>基本时长</label> <input id="addPayTime" name="payTime" 
					class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>基本费用</label> <input id="addBasicCost" name="basicCost"
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>单位费用</label> <input id="addUnitCost" name="unitCost" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>资费说明</label> <input id="addCostDiscrip" name="costDiscrip"
					class="easyui-validatebox" validType="length[1,100]" 
					missingMessage="不能为空" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="savePay()">确定</a> 
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#addPay').dialog('close')">取消</a>
	</div>

	<!-- 修改资费窗口 -->
	<div id="updatePay" class="easyui-dialog"
		style="width: 500px; height: 350px; padding: 10px 20px" closed="true"
		title="修改资费" buttons="#dlg-buttons">
		<form id="updateFM" method="post" style="padding: 10px 20px">
			<div class="fitem">
				<label>资费名称</label> <input id="updateName" name="payName"
					class="easyui-validatebox" required="true" missingMessage="不能为空">
					<span id="updateNameP"></span>
			</div><br>
			<div class="fitem">
				<label>资费类型</label> <input id="updateType" name="payType"
					class="easyui-validatebox" required="true" missingMessage="不能为空">
					<span id="updateTypeP"></span>
			</div><br>
			<div class="fitem">
				<label>基本时长</label> <input id="updatePayTime" name="payTime" 
					class="easyui-validatebox" missingMessage="不能为空" required="true">
					<span id="updatePayTimeP"></span>
			</div><br>
			<div class="fitem">
				<label>基本费用</label> <input id="updateBasicCost" name="basicCost"
				class="easyui-validatebox" missingMessage="不能为空" required="true">
				<span id="updateBasicCostP"></span>
			</div><br>
			<div class="fitem">
				<label>单位费用</label> <input id="updateUnitCost" name="unitCost" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
				<span id="updateUnitCostP"></span>
			</div><br>
			<div class="fitem">
				<label>资费说明</label> <input id="updateCostDiscrip" name="costDiscrip"
					class="easyui-validatebox" validType="length[1,100]" 
					missingMessage="不能为空" required="true">
					<span id="updateCostDiscripP"></span>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updatePay()">确定</a> 
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#updatePay').dialog('close')">取消</a>
	</div>
	

	<script type="text/javascript"
		src="<%=basePath%>static/js/paymag/paysystem.js"></script>
		
	<script type="text/javascript">
		
	</script>
</body>
</html>