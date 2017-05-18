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
	<table id="dg" title="账务账号信息一览表" class="easyui-datagrid"
		style="width: auto; height: auto" pagination="true"
		toolbar="#toolbar" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th data-options="field:'real_name',width:100,align:'center'">真实姓名</th>
				<th data-options="field:'gender',width:100,align:'center'">性别</th>
				<th data-options="field:'id_num',width:100,align:'center'">身份证号</th>
				<th data-options="field:'account_name',width:100,align:'center'">账务账号</th>
				<th data-options="field:'phone',width:100,align:'center'">联系电话</th>
				<th data-options="field:'password',width:100,align:'center'">密码</th>
				<th data-options="field:'address',width:100,align:'center'">通讯地址</th>
				<th data-options="field:'postcode',width:100,align:'center'">邮编</th>
				<th data-options="field:'qq',width:100,align:'center'">QQ号码</th>
				<th data-options="field:'status',width:100,align:'center'">开通状态</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="addAcconut()">增加账务账号</a>
			
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
			onclick="update()">修改账务账号</a> 
			
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-no" plain="true"
			onclick="deleteAcconut()">删除账务账号</a>
			
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
			onclick="updateAcconut()">开通账务账号</a>
		
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
			onclick="stopAcconut()">暂停账务账号</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-pwd" plain="true"
			onclick="que()">查询账务账号</a>
			
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-pwd" plain="true"
			onclick="acconutInfo()">账务账号详细</a>
			
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-pwd" plain="true"
			onclick="acconutScan()">账务账号浏览</a>
	</div>


	<!-- 添加账务窗口 -->
	<div id="addAccont" class="easyui-dialog"
		style="width: 450px; height: 350px; padding: 10px 20px" closed="true"
		title="添加" buttons="#dlg-buttons">
		<form id="add" method="post" style="padding: 10px 20px">
			<div class="fitem">
				<label>真实姓名</label> <input id="addName" name="acconutName"
					class="easyui-validatebox" required="true" missingMessage="不能为空">
			</div><br>
			<div class="fitem">
				<label>用户性别</label> <input type="radio" id="addGender" name="gender"
					class="easyui-validatebox" required="true" missingMessage="不能为空" value="1">男
					<input type="radio" id="addGender" name="gender"
					class="easyui-validatebox" required="true" missingMessage="不能为空" value="0">女
			</div><br>
			<div class="fitem">
				<label>身份证号</label> <input id="addIdNumber" name="idNumber" 
					class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>账务账号</label> <input id="addAcconutNumber" name="acconutNumber"
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>账务密码</label> <input id="addPassword" name="password" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>联系电话</label> <input id="addPhone" name="phone" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>通讯地址</label> <input id="addAddress" name="address" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>邮政编号</label> <input id="addPostcode" name="postcode" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>Q Q 号码</label> <input id="addQq" name="qq" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveAcconut()">添加</a> 
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#addAccont').dialog('close')">取消</a>
	</div>
	
	<!-- 修改账务窗口 -->
	<div id="update" class="easyui-dialog"
		style="width: 450px; height: 350px; padding: 10px 20px" closed="true"
		title="修改账号" buttons="#dlg-buttons">
		<form id="update" method="post" style="padding: 10px 20px">
			<div class="fitem">
				<label>账务密码</label> <input id="updatePassword" name="password" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>联系电话</label> <input id="updatePhone" name="phone" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<!-- <div class="fitem">
				<label>通讯地址</label> <input id="addAddress" name="address" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>邮政编号</label> <input id="addPostcode" name="postcode" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>Q Q 号码</label> <input id="addQq" name="qq" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br> -->
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updatePwd()">修改</a> 
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#update').dialog('close')">取消</a>
	</div>
	
	
	
	
	<!-- 查询账务窗口 -->
	<div id="queryAcconut" class="easyui-dialog"
		style="width: 450px; height: 150px; padding: 10px 20px" closed="true"
		title="查询账号" buttons="#dlg-buttons">
		<form id="find" method="post" style="padding: 10px 20px">
			<div class="fitem">
				<label>账务账号</label> <input  id="query" name="queryId" placeholder="请输入要查询的账务账号"
				class="easyui-validatebox" missingMessage="不能为空" required="true" style="width:200px">
			</div><br>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="query()">查询</a> 
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#queryAcconut').dialog('close')">取消</a>
	</div>
	<script type="text/javascript" src="<%=basePath%>static/js/usermag/acconutUser.js">
		
	</script>
</body>
</html>