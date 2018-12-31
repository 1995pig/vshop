function callAllPrice(){
	allPrice = 0.0;
	$("span[id^=price-]").each(function(){
 		id = this.id.split("-")[1];
		amount = $("#amount-"+id).val();;
		price = parseFloat($(this).text());
  		allPrice += price * amount;
	});
	$("#allPrice").text(allPrice);
}
$(function() {
	callAllPrice();
	$("button[id*=sub-]").each(function(){
		$(this).on("click",function(){
 			gid = this.id.split("-")[1];
 			amount = parseInt($("#amount-" + gid).val());
 			if(amount < 1){
 				
 			}else{
 				$("#amount-"+gid).val(amount-1);
  				$("#updateBtn-"+gid).attr("class","btn btn-warning");
 			}
 			callAllPrice();	
		});
		
	});
	$("button[id*=add-]").each(function(){
 		$(this).on("click",function(){
 			gid = this.id.split("-")[1];
 			amount = parseInt($("#amount-" + gid).val());
 			$("#amount-"+gid).val(amount+1);
 			$("#updateBtn-"+gid).attr("class","btn btn-warning");
 		 	callAllPrice();
 		});
	
	});
	$("button[id*=updateBtn-]").each(function(){		//修改购物车中单个商品数量
		$(this).on("click",function(){
 			gid = this.id.split("-")[1];
 			amount = parseInt($("#amount-"+gid).val());
 			$.post("pages/front/center/shopcar/ShopcarActionFront!edit.action",{gid:gid,amount:amount},function(data){
 				if(data.trim()=="true"){
					if(amount == 0){
 						$("#shopcar-" + gid).remove();
 						operateAlert(data.trim()=="true","商品删除成功！","商品删除失败！");
					}else if(amount > 0){
						operateAlert(data.trim()=="true","商品数量修改成功！","商品数量修改失败！");
					}
				}
				$("#updateBtn-"+gid).attr("class","btn btn-primary");
			},"text");
			
		});
		
	});
	
	
	$(editBtn).on("click",function(){		//修改购物车中多个商品数量
		var sc = "";
		$(".btn-warning").each(function(){
			gid=this.id.split("-")[1];
			amount=$("#amount-"+gid).val();
			sc+=gid+":"+amount+",";
		});
		$.post("pages/front/center/shopcar/ShopcarActionFront!editAmount.action",{sc:sc},function(data){
			 if(data.trim() =="true"){
				 $(".btn-warning").each(function(){
					gid = this.id.split("-")[1]; 
					amount= parseInt($("#amount-"+gid).val());
  					if(amount == 0){
 						$("#shopcar-"+gid).remove();
					}else{
						$("#updateBtn-"+gid).attr("class","btn btn-primary");
					}
				 });
				 operateAlert(true,"商品更新成功！！！","商品更新失败！！！"); 
			 }
			
			 
		},"text");
		
	});
	
	$(rmBtn).on("click",function(){		//删除购物车中多个商品
		
		var gids = "";
		$("#gid:checked").each(function(){
			gids += $(this).val()+",";
		});	
		if(gids != ""){ 
			if(window.confirm("确认删除要删除这些商品!!")){
	 	 		$.post("pages/front/center/shopcar/ShopcarActionFront!delete.action",{sc:gids},function(data){
					if(data.trim()=="true"){
						$("#gid:checked").each(function(){
							gid = $(this).val();
							$("#shopcar-"+gid).remove();
						});
						callAllPrice();
						operateAlert(true,"商品删除成功！！！","商品删除失败！！！");
					}else{
						operateAlert(false,"商品删除成功！！！","商品删除失败！！！");
					}
					
				},"text");
			}
		}
	});
	
	
	
	
	
	
	$("#selectAll").on("click",function(){
		checkboxSelectAll('gid',this.checked) ;
	}) ;
//	$("#rmBtn").on("click",function(){	// 绑定用户锁定操作
//		operateChecked("确定要删除这些商品吗？","gid",'pages/back/admin/goods/GoodsActionBack!rm.action?p=p') ;
//	}) ;
	
	
	
	
	
	
	
	
	
	
})