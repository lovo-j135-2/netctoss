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
<title>实验室系统主界面</title>

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
	
	<a href="javascript:void(0)" id="loginOut">登出</a>

	<script type="text/javascript"
		src="<%=basePath%>static/js/dmsmag/dmssystem.js"></script>
		
	<script type="text/javascript">
		$("#loginOut").on({
			"click":function(){
				$.ajax({
					type:"post",
					url:"dmsmag/loginOut",
					async:true,
					success:function(mes){
						window.location.href="http://localhost:8080/netctoss/jsp/dmsmag/dmssystem.jsp";
					}
				})
			}
		})
	</script>
</body>
</html>