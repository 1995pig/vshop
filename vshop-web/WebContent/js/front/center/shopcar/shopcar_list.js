$(function() {
	$("#selectAll").on("click",function(){
		checkboxSelectAll('gid',this.checked) ;
	}) ;
	$("#rmBtn").on("click",function(){	// 绑定用户锁定操作
		operateChecked("确定要删除这些商品吗？","gid",'pages/back/admin/goods/GoodsActionBack!rm.action?p=p') ;
	}) ;
})