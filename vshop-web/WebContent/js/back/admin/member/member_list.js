$(function(){
	var editMid = null;
	$("#selectAll").on("click",function(){
		checkboxSelectAll('mid',this.checked) ;
	}) ;
	$("#lockBtn").on("click",function(){	// 绑定用户锁定操作
		var mid="";
		$("#mid:checked").each(function(){
			mid+=$(this).val()+",";
 		});
		if(mid == ""){
			operateAlert(true,"您还未选择要锁定的数据！！！","")
		}else{
			if(window.confirm('确定要锁定该用户吗') == true){  
				$.post("pages/back/admin/member/MemberActionBack!editLocked.action",
						{mid:mid,locked:1},function(data){
	 				operateAlert(data.trim()=="true","用户锁定成功!!!","用户锁定失败!!!");	
	 				$("#mid:checked").each(function(){
	 					$("#lock-"+$(this).val()).text("锁定");
	 				});
				},"text");
			}
		}
		
	}) ;
	$("#unlockBtn").on("click",function(){	// 绑定用户锁定操作
		var mid="";
		$("#mid:checked").each(function(){
			mid+=$(this).val()+",";
 		});
		if(mid == ""){
			operateAlert(true,"您还未选择要解锁的数据！！！","")
		}else{
			if(window.confirm('确定要解锁该用户吗') == true){  
				$.post("pages/back/admin/member/MemberActionBack!editLocked.action",
						{mid:mid,locked:0},function(data){
	 				operateAlert(data.trim()=="true","用户解锁成功!!!","用户解锁失败!!!");	
	 				$("#mid:checked").each(function(){
	 					$("#lock-"+$(this).val()).text("活跃");
	 				});
				},"text");
			}
		}
		
	}) ;
	$("a[id*=userBtn-]").each(function(){
		// 拆分id数据
		var mid = this.id.split("-")[1] ;
		// console.log("用户ID：" + mid) ;
		$(this).on("click",function(){
			// Ajax异步读取用户信息
			// 将异步加载信息填充到模态窗口的组件之中
			$("#userMid").text(mid) ;
			$("#userid").val(mid) ;
			$("#userInfo").modal("toggle") ;	// 显示模态窗口
		})
	}) ;
	 
 	
 	$("a[id*=editBtn-]").each(function(){		//管理员 修改用户密码,第一步显示修改密码的模态窗口
  		//拆分id数据
 		var mid = this.id.split("-")[1];
 		$(this).on("click",function(){
  			//Ajax异步读取管理员信息
 			//将异步加载信息填充到模态窗口的组件之中
 			$(userMid2).text(mid);
 			editMid = mid;
 			$(userPassword).modal("toggle");		//显示模态窗口
  		});
 		
 		
 	});
  	
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
 	  		var password = $("#password").val();
	 		$.post("pages/back/admin/member/MemberActionBack!editPassword.action",
	 				{password:password,mid:editMid},function(data){
	 			operateAlert(data.trim()=="true","用户密码修改成功！！！","用户密码修改失败！！！");
	 		},"text"); 
	 	 	$(userPassword).modal("hide"); 	//关闭模态窗口
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"password" : {
				required : true
			}
		}
	});
})

