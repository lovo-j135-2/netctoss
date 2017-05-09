function onClickCell(index, field) {
	
	if (editIndex != index) {
		if (endEditing()) {
			$('#dg').datagrid('selectRow', index).datagrid('beginEdit', index);
			var ed = $('#dg').datagrid('getEditor', {
				index : index,
				field : field
			});
			if (ed) {
				($(ed.target).data('textbox') ? $(ed.target).textbox('textbox')
						: $(ed.target)).focus();
			}
			editIndex = index;
		} else {
			setTimeout(function() {
				$('#dg').datagrid('selectRow', editIndex);
			}, 0);
		}
	}
}