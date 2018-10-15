$(function() {
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
})