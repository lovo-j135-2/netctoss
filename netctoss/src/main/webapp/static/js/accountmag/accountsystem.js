window.onload=function(){
	
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

//加载年份下拉框  
function loadSelect(){
	var date=new Date();
	var dateTime=date.getFullYear();
	var beginYear='2017';
	var length= parseInt(dateTime)- parseInt(beginYear);
	$("<option></option>").val(beginYear).text(beginYear).appendTo($("#year"));
	var year=parseInt(beginYear)+1;
	for (var i = 0; i < length; i++) {
		$("<option></option>").val(year).text(year).appendTo($("#year"));
		year++;
	}
}

loadSelect();

//月份表格查询
function doSearchMonth() {
	var options = $("#monthTable").datagrid("getPager" ).data("pagination" ).options;
    var page = options.pageNumber;
    var rows = options.pageSize;
	$.ajax({
		type:"post",
		url:"accountmag/searchMonth",
		async:true,
		data:{"year":$("#year").val(),"month":$("#month").val(),"page":page,"rows":rows},
		dataType : "json",
		success:function(mes){
			$('#monthTable').datagrid('loadData',mes);
		}
	})
}

//月份表格双击弹出每天实验室明细
$('#monthTable').datagrid({
    onDblClickRow: function (rowIndex, rowData) {
    	console.info(rowIndex);
        console.info(rowData);
    	$("#dayDialog").dialog({closed:false});
    	$("#dayTable").form("clear");
    	var options = $("#dayTable" ).datagrid("getPager" ).data("pagination" ).options;
        var page = options.pageNumber;
        var rows = options.pageSize;
        var value=$("#monthTable").datagrid('getSelected');
    	$.ajax({
    		type:"post",
    		url:"accountmag/searchDay",
    		async:true,
    		data:{"ip":value.ip,"year":$("#year").val(),"month":$("#month").val(),"page":page,"rows":rows},
    		dataType : "json",
    		success:function(mes){
    			$('#dayTable').datagrid('loadData',mes);
    		}
    	})
    }
});




//以下为按年查询模块

//加载按年查询账务的年份下拉框  
function loadYearSelect(){
	var date=new Date();
	var dateTime=date.getFullYear();
	var beginYear='2017';
	var length= parseInt(dateTime)- parseInt(beginYear);
	$("<option></option>").val(beginYear).text(beginYear).appendTo($("#yearByYear"));
	var year=parseInt(beginYear)+1;
	for (var i = 0; i < length; i++) {
		$("<option></option>").val(year).text(year).appendTo($("#yearByYear"));
		year++;
	}
}

loadYearSelect();

//月份表格查询
function doSearchYear() {
	var options = $("#yearTable" ).datagrid("getPager" ).data("pagination" ).options;
    var page = options.pageNumber;
    var rows = options.pageSize;
	$.ajax({
		type:"post",
		url:"accountmag/searchYear",
		async:true,
		data:{"year":$("#year").val(),"page":page,"rows":rows},
		dataType : "json",
		success:function(mes){
			$('#yearTable').datagrid('loadData',mes);
		}
	})
}



//年份表格双击弹出每天实验室明细
$('#yearTable').datagrid({
    onDblClickRow: function (rowIndex, rowData) {
    	var value=$("#yearTable").datagrid('getSelected');
    	$("#monthDialog").dialog({closed:false});
//    	$("#yearMonthTable").form("clear");
    	$("#ipLabel").text("实验室ip地址:"+value.ip);
    	var options = $("#yearMonthTable").datagrid("getPager" ).data("pagination" ).options;
        var page = options.pageNumber;
        var rows = options.pageSize;
    	$.ajax({
    		type:"post",
    		url:"accountmag/searchYearMonth",
    		async:true,
    		data:{"ip":value.ip,"year":$("#year").val(),"page":page,"rows":rows},
    		dataType : "json",
    		success:function(mes){
    			$('#yearMonthTable').datagrid('loadData',mes);
    		}
    	})
    }
});

//月份表格双击弹出每天实验室明细
$('#yearMonthTable').datagrid({
    onDblClickRow: function (rowIndex, rowData) {
    	var ip=$("#ipLabel").text();
    	var value=$("#yearMonthTable").datagrid('getSelected');
    	$("#monthDayDialog").dialog({closed:false});
//    	$("#yearMonthDayTable").form("clear");
    	$("#ipDayLabel").text(ip);
    	var options = $("#yearMonthDayTable").datagrid("getPager" ).data("pagination" ).options;
        var page = options.pageNumber;
        var rows = options.pageSize;
    	$.ajax({
    		type:"post",
    		url:"accountmag/searchYearMonthDay",
    		async:true,
    		data:{"ip":ip,"year":$("#year").val(),"month":value.month,"page":page,"rows":rows},
    		dataType : "json",
    		success:function(mes){
    			$('#yearMonthDayTable').datagrid('loadData',mes);
    		}
    	})
    }
});
