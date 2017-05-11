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
<title>普通用户登录</title>
<script type="text/javascript" src="<%=basePath%>static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/loginmag/accountUserLogin.js"></script>
</head>
<body>

		<input type="hidden" value="1" id="id">
		
		<span>用户名:</span> <input id="account_name">
		<br><br>
		<span>密码:</span> <input id="password">
		<br><br>
		<span>验证码:</span> <input id="ms">
		<br><br>
		
	    <button id="one">用户登录</button>
		<button id="two">修改个人密码</button><br><br>
		<button id="three">查看用户个人信息</button>
		<button id="four">退出系统</button>

</body>
</html>