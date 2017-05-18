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

				<th field="business_name" width="100" align="center">业务账号</th>
				<th field="password" width="100" align="center">密码</th>
				<th field="fk_accountuser_id" width="100" formatter="forUserName"
					align="center">账务账号</th>
				<th field="pay" width="100" formatter="forPayName" align="center">资费类型</th>
				<th field="lab" width="100" formatter="forLabName" align="center">实验室地址</th>

			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="addBusiness()">增加业务账号</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="update()">修改业务账号</a> <a
			href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-no"
			plain="true" onclick="deleteBusiness()">删除业务账号</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="updateBusiness()">开通业务账号</a>

		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="stopBusiness()">暂停业务账号</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-pwd" plain="true" onclick="queryBusiness()">查询业务账号</a>

		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-pwd" plain="true" onclick="usinessInfo()">业务账号详细</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-pwd" plain="true" onclick="usinessScan()">业务账号浏览</a>
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
	<div id="update" class="easyui-dialog"
		style="width: 450px; height: 150px; padding: 10px 20px" closed="true"
		title="修改业务" buttons="#dlg-buttons">
		<form id="update" method="post" style="padding: 10px 20px">
			<div class="fitem">
				<label>业务密码</label> <input id="updatePassword" name="password"
					class="easyui-validatebox" missingMessage="不能为空" required="true">
			</div>
			<br>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="updatePwd()">修改</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#update').dialog('close')">取消</a>
	</div>

	<!-- 查询业务窗口 -->
	<div id="queryBusiness" class="easyui-dialog"
		style="width: 450px; height: 150px; padding: 10px 20px" closed="true"
		title="查询业务" buttons="#dlg-buttons">
		<form id="find" method="post" style="padding: 10px 20px">
			<div class="fitem">
				<label>业务账号</label> <input id="query" name="queryBusiness"
					placeholder="请输入要查询的业务账号" class="easyui-validatebox"
					missingMessage="不能为空" required="true" style="width:200px">
			</div>
			<br>
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
			if (row.user) {
				return row.fk_accountuser_id.account_name;
			} else {
				return value;
			}

		};
		function forPayName(value, row, index) {
			if (row.user) {
				return row.user.pay.payName;
			} else {
				return value;
			}
		};
		function forLabName(value, row, index) {
			if (row.user) {
				return row.user.lab.ip_num;
			} else {
				return value;
			}
		};
	</script>
	<!-- <script type="text/javascript">
	$('#dg').datagrid({
		columns:[[
			{field:'business_name',title:'业务账号', width:80,
				formatter: function(value,row,index){
					if (row.user){
						return row.user.business_name;
					} else {
						return value;
					}
				}
			},
			{field:'password',title:'业务密码', width:80,
				formatter: function(value,row,index){
					if (row.user){
						return row.user.password;
					} else {
						return value;
					}
				}
			},
			 {field:'fk_accountuser_id',title:'账务账号', width:80,
				formatter: function(value,row,index){
					return row.fk_accountuser_id;
				}
			} 
		]]
	});
	</script> -->
</body>
</html>