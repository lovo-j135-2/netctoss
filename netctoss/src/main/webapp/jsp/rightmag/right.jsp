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
	<meta charset="UTF-8">
	<title>权限管理</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/demo.css">
	<script type="text/javascript" src="<%=basePath %>static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript"	src="<%=basePath%>static/easy_ui-1.5.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>static/js/jquery.json-2.4.js"></script>
</head>
<body>
	
	<div style="margin:20px 0;"></div>
	<table id="dg" title="权限管理" style="width:700px;height:450px"
			data-options="
			rownumbers:true,
			singleSelect:true,
			pagination:true,
			url:'datagrid_data1.json',
			method:'get',
			toolbar:'#tool'
			">
		<thead>
			<tr>
				<th field="name" width="320" align="center">权限名称</th>
				<th field="discription" width="320" align="center">权限描述</th>
				
			</tr>
		</thead>
	</table>
	
	<div id="tool">
			
			<div style="height:40px;margin-top:10px">
					<span style="margin-left:20px"><input type="button" value="添加权限" onclick="$('#w').window('open')"></span>
					<span style="margin-left:120px"><input type="button" value="修改权限" onclick="getRowIdToUpdate()"></span>
					<span style="margin-left:120px"><input type="button" value="删除权限" onclick="getRowIdToDelete()"></span>
			</div>
	</div>
	
	<div id="w" closed="true" class="easyui-window" title="添加权限" data-options="iconCls:'icon-save'" style="width:300px;height:200px;padding:10px;">
			<form id="ff" method="post" >
					<div style="margin-bottom:20px">
							<input id="rightName" class="easyui-textbox" name="name" style="width:100%" data-options="label:'权限名称：',required:true">
					</div>
					<div style="margin-bottom:20px">
							<input id="rightDiscription" class="easyui-textbox" name="discription" style="width:100%" data-options="label:'权限描述：',required:true">
					</div>
			</form>
			<div style="text-align:center;padding:5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveRight()" style="width:80px">确定</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')" style="width:80px">取消</a>
			</div>
	</div>
	<div id="u" closed="true" class="easyui-window" title="修改权限" data-options="iconCls:'icon-save'" style="width:300px;height:200px;padding:10px;">
			<form id="ff" method="post" >
					<div style="margin-bottom:20px">
							<input id="rightNameUpdate" class="easyui-textbox" name="name" style="width:100%" data-options="label:'权限名称：',required:true">
					</div>
					<div style="margin-bottom:20px">
							<input id="rightDiscriptionUpdate" class="easyui-textbox" name="discription" style="width:100%" data-options="label:'权限描述：',required:true">
					</div>
			</form>
			<div style="text-align:center;padding:5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateRight()" style="width:80px">确定</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#u').window('close')" style="width:80px">取消</a>
			</div>
	</div>
	<div id="d" closed="true" class="easyui-window" title="删除权限" data-options="iconCls:'icon-save'" style="width:300px;height:120px;padding:10px;">
			<div style="text-align:center;padding:5px 0">
					<label>确定删除该权限吗？</label><br><br>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="deleteRight()" style="width:80px">确定</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#d').window('close')" style="width:80px">取消</a>
			</div>
	</div>
	
	<script type="text/javascript">
		var rid;
		
		function getRowIdToUpdate(){
			var row=$('#dg').datagrid('getSelected');//获取选中行在mysql数据库中的id，Amazing！！！
			if(row==null||row==""){
				alert("请选中一行数据");
			}else{
				rid=row.id;
				console.info(rid);
				$('#u').window('open');
			}
		}
		
		function getRowIdToDelete(){
			var row=$('#dg').datagrid('getSelected');//获取选中行在mysql数据库中的id，Amazing！！！
			if(row==null||row==""){
				alert("请选中一行数据");
			}else{
				rid=row.id;
				//console.info(rid);
				$('#d').window('open');
			}
		}
		
		function deleteRight(){
			console.info("delete");
			var right={"id":rid};
			//var json=$.toJSON(right);
			console.info(right);
			$.ajax({
				type:"POST",
				url:"right/delete",
				data:right,
				dataType:"text",
				async:true,
				 success:function(data){
					alert("删除成功");
					show();
				}
				/* error:function(){
					alert("error");
				} */
			})
			$('#d').window('close');		
		}
		
		function updateRight(){
			if($("#rightNameUpdate").val()==""||$("#rightDiscriptionUpdate").val()==""){	//非空判断
				alert("选项不能为空");
			}else{
				//$('#ff').form('submit');
				var rname=$("#rightNameUpdate").val();
				var rdiscription=$("#rightDiscriptionUpdate").val();
				var right={id:rid,name:rname,discription:rdiscription};
				var json=$.toJSON(right);
				$.ajax({
					type:"POST",
					url:"right/update",
					data:json,
					contentType:"application/json",
					async:true,
					success:function(data){
						alert("修改成功");
						show();
					}
				})
				$('#u').window('close');		
				}
		}
		show = function(){
			$('#dg').datagrid({
				url:"right/show",
			});
		}
		window.onload=show();
		
		function saveRight(){
			if($("#rightName").val()==""||$("#rightDiscription").val()==""){	//非空判断
				alert("请耐心填完每个选项");
			}else{
				//$('#ff').form('submit');
				var rname=$("#rightName").val();
				var rdiscription=$("#rightDiscription").val();
				var right={name:rname,discription:rdiscription};
				var json=$.toJSON(right);
				$.ajax({
					type:"POST",
					url:"right/save",
					data:json,
					contentType:"application/json",
					async:true,
					success:function(data){
						alert("添加成功");
						show();
					}
				})
				$('#w').window('close');		
				}
			}
		
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					handler:function(){
						alert('search');
					}
				},{
					handler:function(){
						alert('add');
					}
				},{
					handler:function(){
						alert('edit');
					}
				}]
			});			
		})
		
		
	</script>

</body>
</html>