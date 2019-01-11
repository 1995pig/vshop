/*
 * 
$(function() {
	$("a[id*=userBtn-]").each(function(){
		// 拆分id数据
		var mid = this.id.split("-")[1] ;
		// console.log("用户ID：" + mid) ;
		$(this).on("click",function(){
			
			$("#userMid").text(mid) ;
			$("#userid").val(mid) ;
			$("#userInfo").modal("toggle") ;	// 显示模态窗口
		})
	}) ;
})
*/
  





$(function(){
	$("a[id*=userBtn]").each(function(){
		var mid = this.id.split("-")[1];
		 $(this).on("click",function(){
			// Ajax异步读取用户信息
			// 将异步加载信息填充到模态窗口的组件之中
			 $("#userMid").text(mid);
			 $("#userid").val(mid);	//这行源码本来就有，没找到用在什么地方。
 			 $.post("pages/back/admin/member/MemberActionBack!listMemberInfo.action",{mid:mid},function(data){
				 //1、用户个人信息的填充
 				 $("#modal-mid").text(data.member.mid);
				 $("#modal-name").text(data.member.name);
				 $("#modal-phone").text(data.member.phone);
				 $("#modal-email").text(data.member.email);
				 $("#modal-regdate").text(new Date(data.member.regdate.time).format("yyyy-MM-dd hh:mm:ss"));
 				//2、用户地址信息的填充
				 $("#memberAddressInfo tr:gt(0)").remove();	//填充地址信息之前先删除旧地址
				 for(x=0;x<data.allAddress.length;x++){
					 var address =
					"<tr> " +
						"<td class='text-center'>"+
							"<input type='radio' id='flag' name='flag' "+(data.allAddress[x].deflag==1?"checked":"")+" >"+
						"</td>"+
						"<td class='text-center'>"+data.allAddress[x].receiver+"</td>"+
						"<td class='text-center'>"+data.allAddress[x].phone+"</td>"+
						"<td class='text-center'>"+data.allAddress[x].addr+"</td>"+
					"</tr>";
					 $("#memberAddress").append(address);
				 } 
				 $("#userInfo").modal("toggle");
			 },"json"); 
		 });
	});
})








