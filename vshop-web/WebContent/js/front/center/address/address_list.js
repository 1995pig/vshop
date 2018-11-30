$(function() {
	$("#delBtn").on("click",function(){
		id   = $("#aid:checked").val();
 		console.log(id + "===========");
 		$.post("pages/front/center/address/MemberAddressActionFront!editFlag.action",{adid:id},function(data){
  			operateAlert(data.trim() == "true","默认配送地址修改成功！","默认配送地址修改失败");
		},"text")
	});
	$("#selectAll").on("click",function(){
		checkboxSelectAll('aid',this.checked) ;
	}) ;
	$("#delBtn").on("click",function(){	// 绑定用户锁定操作
		operateChecked("确定要删除这些地址吗？","address.aid",'pages/jsp/admin/UserActionBack!lock.action?p=p') ;
	}) ;
	 
})