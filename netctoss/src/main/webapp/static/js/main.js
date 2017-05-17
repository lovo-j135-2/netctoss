var mainPlatform = {

	init: function(){

		this.bindEvent();
		// this.render(menu['home']);
	},

	bindEvent: function(){
		var self = this;
		// 顶部大菜单单击事件
		$(document).on('click', '.pf-nav-item', function() {
            $('.pf-nav-item').removeClass('current');
            $(this).addClass('current');

            // 渲染对应侧边菜单
            var m = $(this).data('menu');
            self.render(menu[m]);
        });

        $(document).on('click', '.sider-nav li', function() {
            $('.sider-nav li').removeClass('current');
            $(this).addClass('current');
            $('iframe').attr('src', $(this).data('src'));
        });

        $(document).on('click', '.pf-logout', function() {
            layer.confirm('您确定要退出吗？', {
              icon: 4,
			  title: '确定退出' //按钮
			}, function(){
			  location.href= 'login.html'; 
			});
        });
        //左侧菜单收起
        $(document).on('click', '.toggle-icon', function() {
            $(this).closest("#pf-bd").toggleClass("toggle");
            setTimeout(function(){
            	$(window).resize();
            },300)
        });

        $(document).on('click', '.pf-modify-pwd', function() {
            $('#pf-page').find('iframe').eq(0).attr('src', 'backend/modify_pwd.html')
        });

        $(document).on('click', '.pf-notice-item', function() {
            $('#pf-page').find('iframe').eq(0).attr('src', 'backend/notice.html')
        });
	},

	render: function(menu){
		var current,
			html = ['<h2 class="pf-model-name"><span class="pf-sider-icon"></span><span class="pf-name">'+ menu.title +'</span></h2>'];

		html.push('<ul class="sider-nav">');
		for(var i = 0, len = menu.menu.length; i < len; i++){
			if(menu.menu[i].isCurrent){
				current = menu.menu[i];
				html.push('<li class="current" title="'+ menu.menu[i].title +'" data-src="'+ menu.menu[i].href +'"><a href="javascript:;"><img src="'+ menu.menu[i].icon +'"><span class="sider-nav-title">'+ menu.menu[i].title +'</span><i class="iconfont"></i></a></li>');
			}else{
				html.push('<li data-src="'+ menu.menu[i].href +'" title="'+ menu.menu[i].title +'"><a href="javascript:;"><img src="'+ menu.menu[i].icon +'"><span class="sider-nav-title">'+ menu.menu[i].title +'</span><i class="iconfont"></i></a></li>');
			}
		}
		html.push('</ul>');

		$('iframe').attr('src', current.href);
		$('#pf-sider').html(html.join(''));
	}

};

mainPlatform.init();

var json1 = [{
	"id":11,
	"text":"用户管理系统",
	"children":[{
			"id":111,
			"text":"账务帐号管理",
			"url":"<%=basePath%>/index.jsp"
		},{
			"id":112,
			"text":"业务帐号管理",
			"url":"<%=basePath%>/index.jsp"
		}]
	},{
		"id":12,
		"text":"权限管理系统",
		"state":"close",
		"children":[{
			"id":121,
			"text":"角色管理",
			"url":"<%=basePath%>/index.jsp"
		},{
			"id":122,
			"text":"权限管理",
			"url":"<%=basePath%>/index.jsp"
		}]
	},{
		"id":13,
		"text":"管理员管理系统",
		"state":"close",
		"children":[{
			"id":131,
			"text":"管理员管理",
			"url":"<%=basePath%>/index.jsp"
		}]
	},{
		"id":14,
		"text":"资费管理系统",
		"state":"close",
		"children":[{
			"id":141,
			"text":"资费管理",
			"url":"http://localhost:8080/netctoss/jsp/paymag/paysystem.jsp"
		}]
	},{
		"id":15,
		"text":"账单查询系统",
		"state":"close",
		"children":[{
			"id":151,
			"text":"账单查询",
			"url":"<%=basePath%>/index.jsp"
		}]
	},{
		"id":16,
		"text":"账务查询系统",
		"state":"close",
		"children":[{
			"id":161,
			"text":"账务管理",
			"url":"http://localhost:8080/netctoss/jsp/accountmag/accountsystem.jsp"
		}]
	},{
		"id":17,
		"text":"前台日志系统",
		"state":"close",
		"children":[{
			"id":171,
			"text":"登录服务日志",
			"url":"<%=basePath%>/index.jsp"
		},{
			"id":172,
			"text":"操作服务日志",
			"url":"<%=basePath%>/index.jsp"
		}]
	},{
		"id":18,
		"text":"报表查询系统",
		"state":"close",
		"children":[{
			"id":181,
			"text":"账务账单",
			"url":"<%=basePath%>/index.jsp"
		},{
			"id":182,
			"text":"业务账单管理",
			"url":"<%=basePath%>/index.jsp"
		}]
	}];


//动态生成节点
$.each(json1, function(i, obj) {  
    var child = obj.children; 
    //添加一级菜单
    var a = $("<a href='javascript:;'><span class='iconfont sider-nav-icon'>&#xe60d;</span><span class='sider-nav-title'>"+obj.text+"</span><i class='iconfont'>&#xe642;</i></a>");
    var ul = $("<ul class='sider-nav-s'></ul>");
    //添加二级菜单
    $.each(child,function(j, childnode){
    	var text = childnode.text;
    	var aa = $("<a>"+text+"</a>").attr("href","javascript:addPanel('"+text+"','"+childnode.url+"')");
    	var li = $("<li></li>");
    	li.append(aa);
    	ul.append(li);
    });
    var li = $("<li></li>");
    li.append(a);
    li.append(ul);
    $("#treeul").append(li);
}); 
//点击树节点，动态产生页面
function addPanel(name,url){
    console.info(name);
    if ($('#piframe').tabs('exists', name)){//判断页面是否存在，如果存在则不新建当前页面，改为显示页面
        $('#piframe').tabs('select', name);
    }else{
    	$('#piframe').tabs('add',{
            title: name,
            content: '<div style="height: 100%"><iframe class="page-iframe" src='+url+'></iframe></div>',
            closable: true
        });
    }   
}


































