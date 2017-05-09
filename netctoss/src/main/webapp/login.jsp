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
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>电信实验室租赁服务计费系统</title>
    <link href="<%=basePath%>static/css/base.css" rel="stylesheet">
    <link href="<%=basePath%>static/css/login/login.css" rel="stylesheet">
</head> 
<body>
	<div class="login-hd">
		<div class="left-bg"></div>
		<div class="right-bg"></div>
		<div class="hd-inner">
			<!--<span class="logo"></span>-->
			<img src="<%=basePath%>static/images/log.png" alt="logo" style="width: 100px;height: 95px;margin-top: 0px">
			<span class="split"></span>
			<span class="sys-name">电信实验室租赁服务计费系统</span>
		</div>
	</div>
	<div class="login-bd">
		<div class="bd-inner">
			<div class="inner-wrap">
				<div class="lg-zone">
					<div class="lg-box">
						<div class="lg-label"><h4>用户登录</h4></div>
						<div class="alert alert-error">
			              <i class="iconfont">&#xe62e;</i>
			              <span>请输入用户名</span>
			            </div>
						<form>
							<div class="lg-username input-item clearfix">
								<i class="iconfont">&#xe60d;</i>
								<input type="text" placeholder="账号/邮箱">
							</div>
							<div class="lg-password input-item clearfix">
								<i class="iconfont">&#xe634;</i>
								<input type="password" placeholder="请输入密码">
							</div>
							<div class="lg-check clearfix">
								<div class="input-item">
									<i class="iconfont">&#xe633;</i>
									<input type="text" placeholder="验证码">
								</div>
								<span class="check-code">XD34F</span>
							</div>
							<div class="tips clearfix">
								<!--<label><input type="checkbox" checked="checked">记住用户名</label>-->
								<a href="javascript:;" class="register">立即注册</a>
								<a href="javascript:;" class="forget-pwd">忘记密码？</a>
							</div>
							<div class="enter">
								<a href="javascript:;" class="purchaser" onClick="javascript:window.location='<%=basePath%>jsp/user_mian.jsp'">用户登录</a>
								<a href="javascript:;" class="supplier" onClick="javascript:window.location='<%=basePath%>jsp/manager_mian.jsp'">管理员登录</a>
							</div>
						</form>
					</div>
				</div>
				<div class="lg-poster"></div>
			</div>
		</div>
	</div>
	<div class="login-ft">
		<div class="ft-inner">
			<div class="about-us">
				<a href="javascript:;">关于我们</a>
				<!--<a href="javascript:;">法律声明</a>-->
				<!--<a href="javascript:;">服务条款</a>-->
				<a href="javascript:;">联系方式</a>
			</div>
			<div class="address">地址：成都市青羊区抚琴东南路10号</div>
			<!--<div class="other-info">建议使用IE8及以上版本浏览器&nbsp;苏ICP备&nbsp;09003078号&nbsp;E-mail：admin@uimaker.com</div>-->
		</div>
	</div>
</body> 
</html>