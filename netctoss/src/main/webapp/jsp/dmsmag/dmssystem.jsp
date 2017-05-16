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
<title>实验室系统</title>

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
	
	<div class="easyui-panel" title="Login to system" style="width:100%;max-width:400px;padding:30px 60px;">
		<div style="margin-bottom:10px">
			<input id="businessName"  class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'业务账号',iconCls:'icon-man',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<input id="password" class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'账号密码',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<select id="ip" class="easyui-combobox" name="state" label="实验室IP" labelPosition="top" style="width:100px;float:left;">
			</select>
		</div>
		<div style="margin-bottom:20px">
			<input type="checkbox" checked="checked">
			<span>Remember me</span>
			<span id="notice"></span>
		</div>
		<div>
			<a id="login" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
				<span style="font-size:14px;">Login</span>
			</a>
		</div>
	</div>
	
	
	

	<script type="text/javascript"
		src="<%=basePath%>static/js/dmsmag/dmssystem.js"></script>
		
	<script type="text/javascript">
		
	</script>
</body>
</html>