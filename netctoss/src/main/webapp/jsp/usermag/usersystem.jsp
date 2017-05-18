<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//项目名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/easy_ui-1.5.2/demo/demo.css">
<script type="text/javascript" src="<%=basePath%>static/js/jquery-3.1.1.min.js"></script>

<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/jquery.easyui.min.js"></script>
</head>
<body>

	<!-- <div style="margin:-20px 0;"></div> -->
	<div class="easyui-layout"  fit="true" id="olayout">
		<div data-options="region:'south',split:true,iconCls:'icon-ok'" title="业务账单" style="height:50%">
			<div class="easyui-layout" fit="true" id="southlayout">
				<div data-options="region:'center',iconCls:'icon-ok'" style="width:100%">
					<table id="business"  class="easyui-datagrid"	
						rownumbers="true" 
						fitColumns="true"
						singleSelect="true"
						iconCls="icon-man"
						data-options="fit:true,onDblClickCell: onClick"
						>
						<thead>
							<tr>
								<th data-options="field:'monthCostAccoutId',width:80,halign:'center'">账务ID</th>
								<th data-options="field:'bussinessId',width:80,halign:'center'">业务ID</th>
								<th data-options="field:'year',width:80,halign:'center'">年</th>
								<th data-options="field:'month',width:80,halign:'center'">月</th>
								<th data-options="field:'time',width:100,halign:'center'">时长（小时）</th>
								<th	data-options="field:'ip',width:80,align:'center',halign:'center'">实验室ip</th>
								<th	data-options="field:'cost',width:80,align:'center',halign:'center'">费用（人民币：元）</th>
								<th	data-options="field:'payType',width:80,align:'center',halign:'center'">支付类型</th>
							</tr>
						</thead>
					</table>
				</div>
				
				<div data-options="region:'east',iconCls:'icon-ok',title:'业务账单详情'"  style="height:100%;width:60%">
					<table id="daycost"  class="easyui-datagrid"	
						rownumbers="true" 
						fitColumns="true"
						singleSelect="true"
						iconCls="icon-man"
						data-options="fit:true"
						>
						<thead>
							<tr>
								<th data-options="field:'bussinessId',width:80,halign:'center'">业务ID</th>
								<th data-options="field:'month',width:80,halign:'center'">月</th>
								<th	data-options="field:'ip',width:80,align:'center',halign:'center'">实验室ip</th>
								<th data-options="field:'beginTime',width:80,halign:'center'">登录时间</th>
								<th data-options="field:'endTime',width:80,halign:'center'">退出时间</th>
								<th data-options="field:'time',width:100,halign:'center'">时长（小时）</th>
								<th	data-options="field:'cost',width:80,align:'center',halign:'center'">费用（人民币：元）</th>
								<th	data-options="field:'payType',width:80,align:'center',halign:'center'">支付类型</th>
							</tr>
						</thead>
					</table>
				</div>
				
			</div>
		
		
				
		</div>
		
		<div data-options="region:'center',title:'月账单查询',iconCls:'icon-ok'" style="height:50%;">
			<table id="dg"  class="easyui-datagrid"	
				style="width: auto; height: auto" pagination="true"
		toolbar="#toolbar" rownumbers="true" fitColumns="true"
		singleSelect="true"
				data-options="fit:true,onDblClickCell: onClickCell"
				>
				<thead>
					<tr>
						<th data-options="field:'id',width:80,halign:'center'">账务账单ID</th>
						<th data-options="field:'year',width:80,halign:'center',editor:'numberbox'">年</th>
						<th data-options="field:'month',width:80,halign:'center',editor:'textbox'">月</th>
						<th data-options="field:'time',width:100,halign:'center',editor:'textbox'">时长（小时）</th>
						<th	data-options="field:'cost',width:80,align:'center',halign:'center',editor:'numberbox'">费用（人民币：元）</th>
						<th	data-options="field:'payStatus',width:80,align:'center',halign:'center',editor:'textbox'">支付状态</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>

	<div id="toolbar">
		<span style="margin-left:10px">年:</span><select id="yearstate" class="easyui-combobox" name="state" label="State:" labelPosition="top" style="width:100px;">
				
			</select>
		<span>月:</span><select id="monthstate" class="easyui-combobox" name="state" label="State:" labelPosition="top" style="width:100px;">
				
			</select>
		<a href="#" class="easyui-linkbutton" plain="true"	onclick="doSearch()" data-options="iconCls:'icon-search',plain:true	">搜索</a>
	</div>
<script type="text/javascript">
	//var id=1;
	$(function(){
	 	$("#olayout").layout('collapse','south');
		$("#southlayout").layout('collapse','east');
		var pager = $('#dg').datagrid().datagrid('getPager');
		// 将行数变为可选择的行数
		$(pager).pagination({
			pageSize:4,
			pageList: [4,10,15,20],
			beforePageText: '第',// 页数文本框前显示的汉字
    		afterPageText: '页    共 {pages} 页',  
    		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
		$('#dg').datagrid({
			url : "<%=basePath%>accountmag/loadMonthAccount"
		});
	})
	var year;
	var month;
	
	function date(){
		var mydate = new Date();
		year = mydate.getFullYear();
		month = (mydate.getMonth()+1);
		
		for(var i=year;i>=year-10;i--){
			var option = $("<option value='"+i+"'>"+i+"</option>");
			$("#yearstate").append(option);
		}
		for(var j=1;j<=12;j++){
			var option2 = $("<option value='"+j+"'>"+j+"</option>");
			$("#monthstate").append(option2);
		}
	}
	date();
	
	function doSearch(){
		var year = $("#yearstate").combobox('getValue');
		var month = $("#monthstate").combobox('getValue');
		var date = {};
		date.year = year;
		date.month = month;
		var uri = "<%=basePath%>accountmag/loadbydate";
		
		$.ajax({
			type:"get",
			url:uri,
			data:date,
			contentType:"application/json",
			success:function(data){
				
				$('#dg').datagrid("loadData", data);
			}
		});
	}
	function onClickCell(){
		var a=[];
		$('#daycost').datagrid("loadData", a);
		var currentRow = $("#dg").datagrid("getSelected");
		
		var account = currentRow.accountId;
		var month = currentRow.month;
		var date = {};
		date.account = account;
		date.month = month;
		var uri = "<%=basePath%>accountmag/loadBusinessbyAccountId";
		if(account!=null && account!=0){
			$("#southlayout").layout('collapse','east');
			$("#olayout").layout('expand','south');
			$.ajax({
				type:"get",
				url:uri,
				data:date,
				contentType:"application/json",
				success:function(data){
					
					$('#business').datagrid("loadData", data);
				}
			});
			
			$("#business").datagrid({
				pagination:true,
				pageSize:4,
				pageList: [4,8,10,20],
				beforePageText: '第',//页数文本框前显示的汉字  
	    		afterPageText: '页    共 {pages} 页',
				
			}); 
		}
	}
	function onClick(){
		var currentRow = $("#business").datagrid("getSelected");
		console.info(currentRow.monthCostAccoutId);
		console.info(currentRow.bussinessId);
		console.info(currentRow.month);
		var businessId = currentRow.bussinessId;
		var ip = currentRow.ip;
		var accoutId = currentRow.monthCostAccoutId;
		var bussinessId = currentRow.bussinessId;
		var month = currentRow.month;
		var date = {};
		date.accountId = accoutId;
		date.businessId = bussinessId;
		date.month = month;
		var uri = "<%=basePath%>accountmag/loadDayCost";
		if(bussinessId!=null && bussinessId!=0){
			$("#southlayout").layout('expand','east');
			
			$.ajax({
				type:"get",
				url:uri,
				data:date,
				contentType:"application/json",
				success:function(data){
					console.info(data);
					var jsonArray = [];
					$.each(data,function(index, content){
						
						var a = {
		                    'bussinessId' : businessId,
							'month' : content.month,
		                    'ip' : ip,
		                    'beginTime' : content.beginTime,
		                    'endTime' : content.endTime,
		                    'time' : content.time,
		                    'cost' : content.cost,
		                    'payType' : content.payType,
		                };
						jsonArray.push(a);
					});
					$('#daycost').datagrid("loadData", jsonArray);
				}
			});
			var pager = $('#daycost').datagrid().datagrid('getPager');
			$(pager).datagrid({
				pagination:true,
				pageSize:4,
				pageList: [4,8,10,20],
				beforePageText: '第',// 页数文本框前显示的汉字
	    		afterPageText: '页    共 {pages} 页',  
	    		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
				
			});
		}
	}

</script>

</body>
</html>