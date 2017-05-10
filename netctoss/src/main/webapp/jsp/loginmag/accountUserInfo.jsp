<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//项目名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户个人信息</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/demo.css">


<script type="text/javascript" src="<%=basePath%>static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/loginmag/accountUserLogin.js"></script>
</head>
<body>

		<h2>用户个人信息</h2>
	<div id="w" class="easyui-window" title="Window Layout" data-options="iconCls:'icon-save'" style="width:500px;height:200px;padding:5px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'east',split:true" style="width:100px"></div>
			<div data-options="region:'center'" style="padding:10px;">
			<span>真实姓名:</span> <input id="account_name">
			<span>身份证信息:</span> <input id="account_name">
			<br><br>
			<span>账务账号:</span> <input id="password">
			<br><br>
			<span>联系电话:</span> <input id="ms">
			<br><br>
			</div>
			<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:alert('ok')" style="width:80px">Ok</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:alert('cancel')" style="width:80px">Cancel</a>
			</div>
		</div>
	</div>

</body>
</html>