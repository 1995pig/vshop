$(function() {
	/*
	$("button[id*='updateBtn-']").each(function(){
		var iid = this.id.split("-")[1];	// 分离出id信息
		var sid = this.id.split("-")[2];	// 分离出id信息
		$(this).on("click",function(){
			var title = $("#title-" + sid).val() ;
			console.log("iid = " + iid + "，sid = " + sid + "，title = " + title) ;
			// 编写Ajax异步更新操作
			operateAlert(true,"子栏目信息修改成功！","子栏目信息修改失败！") ;
		}) ;
	}) ;
	*/
	$("button[id*='updateBtn-']").each(function(){
		var iid = this.id.split("-")[1];
		var sid = this.id.split("-")[2];
 
		$(this).on("click",function(){ 
 			var title = $("#title-"+sid).val();
 			$.post("pages/back/admin/item/SubItemActionBack!edit.action",{iid:iid,sid:sid,title:title},function(data){
				operateAlert(data.trim()=="true","子栏目信息修改成功!!","子栏目信息修改失败!!");
			})
		});
	});
})