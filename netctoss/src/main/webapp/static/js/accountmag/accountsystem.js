window.onload=function(){
	
	// 加在页面时，加载数据
	var s=$('#dg').datagrid({
		url : "accountmag/loadMonth",
		
	});
	$(function() {
		var pager = $('#monthTable').datagrid().datagrid('getPager');
		var options = $(pager).data("pagination").options;  
		// 将行数变为可选择的行数
		$(pager).pagination({
			pageSize:10,
			pageList: [10,20],
			beforePageText: '第',// 页数文本框前显示的汉字
    		afterPageText: '页    共 {pages} 页',  
    		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	})
}



