window.onload=function(){
	loadIP();
	function loadIP() {
		$.ajax({
			type:"post",
			url:"dmsmag/loadIP",
			async:true,
			dataType:'json',
			success:function(mes){
				for (var i = 0; i < mes.length; i++) {
					$("<option></option>").attr("id",i).text(mes[i].ip_num).appendTo($("#ip"));
				}
			}
		})
	}

	$("#login").on({
		"click":function(){
			if($("#businessName").val()!="" && $("#password").val()!=""){
				$.ajax({
					type:"post",
					url:"dmsmag/loginIP",
					async:true,
					data:{'id':$("#businessName").val(),'password':$("#password").val(),'ip':$("#ip").val()},
					dataType:'json',
					success:function(mes){
						console.info(mes);
						if(mes.flag==true){
							console.info(111);
							window.location.href="http://localhost:8080/netctoss/jsp/dmsmag/main.jsp";
						}else{
							$("#notice").text("登录失败").attr("color","red");
						}
					}
				})
			}
		}
	})
}
