$(function() {
	$("#selectAll").on("click",function(){
		checkboxSelectAll('aid',this.checked) ;
	}) ;
	$("#delBtn").on("click",function(){	// 绑定用户锁定操作
		operateChecked("确定要删除这些地址吗？","address.aid",'pages/jsp/admin/UserActionBack!lock.action?p=p') ;
	}) ;
})