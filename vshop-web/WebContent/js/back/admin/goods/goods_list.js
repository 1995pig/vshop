$(function(){
	$("#createData").on("click",function(){
		console.log(11);
		$.post("pages/back/admin/goods/GoodsActionBack!listDetails.action",{},function(data){
			operateAlert(data.trim()=="true","商品展示数据创建成功!","商品展示数据创建失败!");
		},"text");
	});
	$("#selectAll").on("click",function(){
		checkboxSelectAll('gid',this.checked) ;
		
	}) ;
	
	
	$("#rmBtn").on("click",function(){	// 绑定用户锁定操作	
		if(window.confirm("确定要删除这些商品信息吗？")){
			deleteGids = "";
			gids = new Array();		//建立一个数组
			foot = 0;
			$("#gid:checked").each(function(){
				deleteGids+=this.value + ",";
				gids[foot++] = this.value;
			});
			if(deleteGids ==""){
				operateAlert(false,"商品删除成功!","商品删除失败!");
			}else{
				$.post("pages/back/admin/goods/GoodsActionBack!delete.action",{gids:deleteGids},function(data){
					if(data.trim() == "true"){
						operateAlert(data.trim() == "true", "商品删除成功！","商品删除失败！");
 						for(x=0;x<gids.length;x++){
 							console.log(gids[x]);
							$("#goods-"+gids[x]).remove();
						}
 					}
		 		},"text"); 
			} 
		}  
	}) ;
	
	
	$("a[id*=showBtn-]").each(function(){
		// 拆分id数据
		var gid = this.id.split("-")[1] ;
		$(this).on("click",function(){ 
 			// 将异步加载信息填充到模态窗口的组件之中
   			$.post("pages/back/admin/goods/GoodsActionBack!show.action",{gid:gid},function(data){
    				$("#modal-photo").attr("src","upload/goods/" + data.goods.photo);
   				$("#modal-title").text(data.goods.title);
   				$("#modal-item").text(data.item.title);
   				$("#modal-subitem").text(data.subitem.title);
   				$("#modal-price").text(data.goods.price);
   				$("#modal-mid").text(data.goods.mid);
    			$("#modal-pubdate").text(new Date(data.goods.pubdate.time).format("yyyy-MM-dd hh:mm:ss"));
   				$("#modal-note").html(data.goods.note); 
 			},"json");
			$("#goodsInfo").modal("toggle") ;	// 显示模态窗口
		})
	}) ;
}) ;