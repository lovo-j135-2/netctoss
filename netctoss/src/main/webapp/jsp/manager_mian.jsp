<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>前台营运系统</title>
<link href="<%=basePath%>static/css/base.css" rel="stylesheet">
<link href="<%=basePath%>static/css/platform.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>static/css/easyui.css">
<link rel="stylesheet" href="<%=basePath%>static/css/mian.css">

</head> 
<body>


    <!--头部区域-->
    <div class="container">
        <div id="pf-hd">
            <div class="pf-logo">
                <img src="<%=basePath%>static/images/log.png" alt="logo" style="width: 70px;height: 70px;margin-top: -8px">
                <span style="font-size: 26px;color: white;font-family: 华文楷体;font-weight: 900;font-style: oblique">前台营运系统</span>
            </div>

            <div class="pf-user">
                <div class="pf-user-photo">
                    <img src="<%=basePath%>static/images/main/user.png" alt="">
                </div>
                <h4 class="pf-user-name ellipsis">admin</h4>
                <i class="iconfont xiala">&#xe607;</i>

                <div class="pf-user-panel">
                    <ul class="pf-user-opt">
                        <li>
                            <a href="javascript:">
                                <i class="iconfont">&#xe60d;</i>
                                <span class="pf-opt-name">用户信息</span>
                            </a>
                        </li>
                        <li class="pf-modify-pwd">
                            <a href="">
                                <i class="iconfont">&#xe634;</i>
                                <span class="pf-opt-name">修改密码</span>
                            </a>
                        </li>
                        <li class="pf-logout">
                            <a href="login.html">
                                <i class="iconfont">&#xe60e;</i>
                                <span class="pf-opt-name">退出</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div><!--头部区域结束-->

        <!--左部树区域-->
        <div id="pf-bd">
            <div id="pf-sider">
                <h2 class="pf-model-name">
                    <span class="iconfont">&#xe64a;</span>
                    <span class="pf-name">前台营运系统</span>
                    <span class="toggle-icon"></span>
                </h2>

                <ul class="sider-nav" id="treeul">
                    <!--  <li>
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe60d;</span>
                            <span class="sider-nav-title">用户管理系统</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                        <ul class="sider-nav-s">
                           <li><a href="javascript:addPanel('账务帐号管理')">账务帐号管理</a></li>
                           <li><a href="javascript:addPanel('业务帐号管理')">业务帐号管理</a></li>
                        </ul>
                     </li> -->
                     <%-- <li>
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe62f;</span>
                            <span class="sider-nav-title">管理员管理系统</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                        <ul class="sider-nav-s">
                           <li><a href="javascript:addPanel('管理员管理')">管理员管理</a></li>
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe625;</span>
                            <span class="sider-nav-title">资费管理系统</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                        <ul class="sider-nav-s">
                           <li><a href="javascript:addPanel('资费管理','<%=basePath%>jsp/paymag/paysystem.jsp')">资费管理</a></li>
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe61e;</span>
                            <span class="sider-nav-title">账单查询系统</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                        <ul class="sider-nav-s">
                           <li><a href="javascript:addPanel('账单查询')">账单查询</a></li>
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe684;</span>
                            <span class="sider-nav-title">账务查询系统</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                         <ul class="sider-nav-s">
                             <li><a href="javascript:addPanel('账务查询')">账务查询</a></li>
                         </ul>
                     </li>
                     <li>
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe6ae;</span>
                            <span class="sider-nav-title">权限管理系统</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                         <ul class="sider-nav-s">
                             <li><a href="javascript:addPanel('角色管理')">角色管理</a></li>
                             <li><a href="javascript:addPanel('权限管理')">权限管理</a></li>
                         </ul>
                     </li>
                    <li>
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe6c9;</span>
                            <span class="sider-nav-title">前台日志系统</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                        <ul class="sider-nav-s">
                            <li><a href="javascript:addPanel('登录日志服务')">登录服务日志</a></li>
                            <li><a href="javascript:addPanel('操作服务日志')">操作服务日志</a></li>
                        </ul>
                     </li>
                    <li>
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe6d9;</span>
                            <span class="sider-nav-title">报表查询系统</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                        <ul class="sider-nav-s">
                            <li><a href="javascript:addPanel('账务账单系统')">账务账单系统</a></li>
                            <li><a href="javascript:addPanel('业务帐号管理')">业务账单系统</a></li>
                        </ul>
                     </li> --%>
                 </ul> 
            </div><!--左部树区域结束-->

            <!--内容显示区域-->
            <div id="pf-page">
                <div class="easyui-tabs" style="width:100%;height:100%;" id="piframe">
                  <div title="首页">
                    <iframe class="page-iframe" src="<%=basePath%>jsp/discription.jsp" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                </div>
            </div><!--内容显示区域结束-->
        </div>

        <!-- <div id="pf-ft">
            <div class="system-name">
              <i class="iconfont">&#xe6fe;</i>
              <span>前台营运系统&nbsp;v1.0</span>
            </div>
            <div class="copyright-name">
              <span>CopyRight&nbsp;2016&nbsp;&nbsp;lovo.j135_2&nbsp;版权所有</span>
              <i class="iconfont" >&#xe6ff;</i>
            </div>
        </div> -->
    </div>

    <script type="text/javascript" src="<%=basePath%>static/js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/main.js"></script>
    <script type="text/javascript">
        $(window).resize(function(){
          $('#pf-bd').height($(window).height()-76);
        }).resize();
    </script>
</body> 
</html>