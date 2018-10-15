$(function(){
	$("#selectAll").on("click",function(){
		checkboxSelectAll('goods.gid',this.checked) ;
	}) ;
	$("#rmBtn").on("click",function(){	// 绑定用户锁定操作
		operateChecked("确定要删除这些商品吗？","goods.gid",'pages/back/admin/goods/GoodsActionBack!rm.action?p=p') ;
	}) ;
	$("a[id*=showBtn-]").each(function(){
		// 拆分id数据
		var gid = this.id.split("-")[1] ;
		$(this).on("click",function(){
			console.log("商品ID：" + gid) ;
			// Ajax异步读取用户信息
			// 将异步加载信息填充到模态窗口的组件之中
			$("#goodsInfo").modal("toggle") ;	// 显示模态窗口
		})
	}) ;
}) ;