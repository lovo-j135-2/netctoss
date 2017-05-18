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
<title>业务管理系统</title>

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
	<table id="dg" title="业务账号信息一览表" class="easyui-datagrid"
		style="width: auto; height: auto" pagination="true" toolbar="#toolbar"
		rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<!--  <th data-options="field:'business_name',width:100,align:'center'">业务账号</th>
				<th data-options="field:'password',width:100,align:'center'">密码</th>
			    <th data-options="field:'fk_accountuser_id',width:100,formatter:forUserName,align:'center'">账务账号</th>
				<th data-options="field:'pay',width:100,formatter:forPayName,align:'center'">资费类型</th>
				<th data-options="field:'lab',width:100,formatter:forLabName,align:'center'">实验室地址</th> -->

				<th field="id" width="100" align="center">业务账号</th>
				<th field="password" width="100" align="center">密码</th>
				<th field="fk_accountuser_id.account_name" width="100" formatter="forUserName"
					align="center">账务账号</th>
				<th field="user.pay.payName" width="100" formatter="forPayName" align="center">资费类型</th>
				<th field="user.lab.ip_num" width="100" formatter="forLabName" align="center">实验室地址</th>

			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="addBusiness()">增加业务账号</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="update()">修改业务密码</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-no"
			plain="true" onclick="deleteBusiness()">删除业务账号</a>

		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-pwd" plain="true" onclick="showBusinessDetail()">业务账号详细</a>
	</div>


	<!-- 添加业务窗口 -->
	<div id="addBusiness" class="easyui-dialog"
		style="width: 450px; height: 310px; padding: 10px 20px" closed="true"
		title="添加" buttons="#dlg-buttons">
		<form id="add" method="post" style="padding: 10px 20px">
			<div class="fitem">
				<label>业务账号</label> <input id="addBusiness" name="acconutName"
					class="easyui-validatebox" required="true" missingMessage="不能为空">
			</div>
			<br>
			<div class="fitem">
				<label>业务密码</label> <input id="addPassword" name="password"
					class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>账务账号</label> 
				  <!--  <input id="addAcconut" name="acconutName"
					class="easyui-validatebox" missingMessage="不能为空" required="true"> -->
				<select id="accountType" class="easyui-combobox" name="dept" style="width: 150px;">
				</select>
			</div>
			<br>
			<div class="fitem">
				<label>资费类型</label>
					<select id="payType" class="easyui-combobox" name="dept" style="width: 150px;">
					</select>
			</div>
			<br>

			<div class="fitem">
				<label>实验室号</label>
				<select id="labType" class="easyui-combobox" name="dept" style="width: 150px;">
					
				</select> 
			</div>
			<br>

		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveBusiness()">添加</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#addBusiness').dialog('close')">取消</a>
	</div>

	<!-- 修改账务窗口 -->
	<div id="updatePassword" class="easyui-dialog"
		style="width: 450px; height: 300px; padding: 10px 20px" closed="true"
		title="修改业务" buttons="#dlg-buttons">
		<form id="update" method="post" style="padding: 10px 20px">
			<div class="fitem">
				<label>业务账号：</label> 
				<span id="updateBusinessName"></span>
			</div><br>
			<div class="fitem">
				<label>密码</label> <input id="updatePasswordI" name="password"
					class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div><br>
			<div class="fitem">
				<label>确认密码</label> <input id="comfirmPasswordI" name="password"
					class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updatePwd()">修改</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#updatePassword').dialog('close')">取消</a>
	</div>

	<!-- 查询业务窗口 -->
	<div id="queryBusinessDetail" class="easyui-dialog"
		style="width: 450px; height: 300px; padding: 10px 20px" closed="true"
		title="查询业务" buttons="#dlg-buttons">
		<form id="showDetail" method="post" style="padding: 10px 20px">
			<div class="fitem">
				<label>业务账号：</label> 
				<span id="businessName"></span>
			</div><br>
			<div class="fitem">
				<label>账号密码：</label> 
				<span id="businesssPassword"></span>
			</div><br>
			<div class="fitem">
				<label>账务账号：</label> 
				<span id="accountNameDetail"></span>
			</div><br>
			<div class="fitem">
				<label>资费类型：</label> 
				<span id="payTypeDetail"></span>
			</div><br>
			<div class="fitem">
				<label>实验室IP：</label> 
				<span id="ipName"></span>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="query()">查询</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#queryAcconut').dialog('close')">取消</a>
	</div>


	<script type="text/javascript"
		src="<%=basePath%>static/js/usermag/business.js">
		
	</script>
	<script type="text/javascript">
		function forUserName(value, row, index) {
			return row.fk_accountuser_id.account_name;
		};
		function forPayName(value, row, index) {
			return row.pay.payName;
		};
		function forLabName(value, row, index) {
			return row.lab.ip_num;
		};
	</script>
</body>
</html>