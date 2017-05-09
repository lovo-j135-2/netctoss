$(document).ready(function() {
	//加在页面时，加载数据
	$('#dg').datagrid({
		url : "paymag/load",
	});
	
	$(function() {
		var pager = $('#dg').datagrid().datagrid('getPager');
		var options = $(pager).data("pagination").options;  
		//将行数变为可选择的行数
		$(pager).pagination({
			pageSize:4,
			pageList: [4,8,10,20],
			beforePageText: '第',//页数文本框前显示的汉字  
    		afterPageText: '页    共 {pages} 页',  
    		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
		
		pager.pagination({
			buttons : [
					{
						iconCls : 'icon-search',
						handler : function() {

						}
					},
					{
						iconCls : 'icon-add',
						handler : function() {
							$('#addUserWin').dialog('open').dialog(
									'setTitle', '添加用户');
							$('#fm').form('clear');
						}
					}, {
						iconCls : 'icon-edit',
						handler : function() {
							var value = $("#dg").datagrid('getSelected');
							if (value != null) {
								$('#updateUser').window('open');
							} else {
								alert("请选择一条数据")
							}
						}
					}, {
						iconCls : 'icon-cut',
						handler : function() {
							var value = $("#dg").datagrid('getSelected');
							if (value != null) {
								deleteUser();
							} else {
								alert("请选择一条数据")
							}
						}
					} ]
		});
	})
})