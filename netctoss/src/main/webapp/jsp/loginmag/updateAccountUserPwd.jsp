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
<title>修改用户密码</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easy_ui-1.5.2/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/demo/demo.css">

<script type="text/javascript" src="<%=basePath%>static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
</head>
<body>	
	 <div id="u1" class="easyui-window" title="修改用户密码" data-options="iconCls:'icon-save'" style="width:500px;height:300px;padding:5px;">
		<div class="easyui-layout" data-options="fit:true">
			
			<div data-options="region:'center'" style="padding:10px;">
			<h2>密码修改</h2>
			
			<label>请重置您的密码</label> <input id="updateAccountUserPwd" name="pwd1" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
				<span id="updatePwd1"></span>
			<br><br><br>
			<label>请再次输入密码</label> <input id="updateUserPwdAgain" name="pwd2" 
				class="easyui-validatebox" missingMessage="不能为空" required="true">
				<span id="updatePwd2"></span>
			<br><br><br>
			
			</div>
			<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:alert('ok')" style="width:80px">Ok</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:alert('cancel')" style="width:80px">Cancel</a>
			</div>
		</div>
	</div>
	
</body>
</html>