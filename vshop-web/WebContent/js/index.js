
function bindAddCar(){
	$("button[id*=addCar-]").each(function(){
		var gid = $(this).attr("id").split("-")[1] ;
		$(this).on("click",function(){
			$.post("pages/front/center/shopcar/ShopcarActionFront!add.action",{gid,gid},function(data){
 				operateAlert(data.trim()=="true","购物车添加成功!!!","购物车添加失败!!!") ;
			},"text");
		}) ;
	}) ; 
}

$(function() {				//商品展示页面，取出最后上架的16款产品。
	$.get("goods.json",{},function(data){    //在index.jsp中
		for(x=0;x<data.allGoods.length;x++){
			dataStr = 
			"<div class='col-md-3 text-center'> " +
			"	<p> "+
			"		<a href='pages/front/admin/goods/GoodsActionFront!show.action?gid="+data.allGoods[x].gid+"'> "+
			"			<img src='upload/goods/"+data.allGoods[x].photo+"' style='width:140px;height:100px;'></a></p> "+
			"	<span class='text-warning h4'><strong>￥"+data.allGoods[x].price+"</strong></span> "+
			"	<p><a href='pages/front/admin/goods/GoodsActionFront!show.action?gid="+data.allGoods[x].gid+"'>"+data.allGoods[x].title+"</a></p> "+
			"	<button id='addCar-"+data.allGoods[x].gid+"' class='btn btn-primary btn-xs'> "+
			"	<span class='glyphicon glyphicon-shopping-cart'></span>&nbsp;加入购物车</button> "+
			"</div> " ;
			$(goodDiv).append(dataStr);
		}
		bindAddCar();	//调用事件绑定处理函数,添加购物车功能
	},"json");
	
	
	
	 
	
	$.get("item.json",{},function(data){		//进行首页商品分类的展示    添加到include_memu_item.jsp
		for(x=0;x<data.items.length;x++){
			itemStr = 
 				"<div class='panel panel-primary'>" +
				"	<div class='panel-heading'>" +
				"		<h4 class='panel-title'>" +
				"			<a data-toggle='collapse' data-parent='#item' href='#content-"+data.items[x].item.iid+"'>" +
				"				" +data.items[x].item.title +
				"			</a>" +
				"		</h4>"+
				"	</div>" +
  				"	<div id='content-"+data.items[x].item.iid+"' class='panel-collapse collapse "+(x == 0 ? "in":"")+"'>	 " +
				"		<div class='panel-body'>" +
				"			<div class='row'>";
  			for(y=0;y<data.items[x].subitems.length;y++){
 				itemStr+= 
				"				<div class='col-md-4'><a href='pages/front/admin/goods/GoodsActionFront!list.action?sid="+data.items[x].subitems[y].sid+"'>"+data.items[x].subitems[y].title+"</a></div>" ; 

			}
			
			
			itemStr += 
				"			</div>" +
				"		</div>" +
				"	</div>" +
				"</div>"; 
 
			$(item).append(itemStr);
		}
 	},"json");
	$("button[id*=addCar-]").each(function(){
		var gid = $(this).attr("id").split("-")[1] ;
		$(this).on("click",function(){
			console.log("*** gid = " + gid) ;
			operateAlert(true,"购物车添加成功！","购物车添加失败！") ;
		}) ;
	}) ; 
}) 