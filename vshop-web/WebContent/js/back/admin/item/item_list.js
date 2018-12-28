$(function() {
	$(createData).on("click",function(){
		$.post("pages/back/admin/item/ItemActionBack!listDetails.action",{},function(data){
			operateAlert(data.trim()=="true","栏目数据创建成功!","栏目数据创建失败!");
			console.log(data.trim());
		});
		
	});
	$("button[id*='updateBtn-']").each(function(){
		$(this).on("click",function(){
			id = this.id.split("-")[1];
			tit =  $("#title-"+id).val();
 			$.post("pages/back/admin/item/ItemActionBack!edit.action",{iid:id,title:tit},function(data){
 				operateAlert(data.trim() =="true","栏目信息修改成功！！","栏目信息修改失败");
			},"text");
		});
		
		
	});
})

















