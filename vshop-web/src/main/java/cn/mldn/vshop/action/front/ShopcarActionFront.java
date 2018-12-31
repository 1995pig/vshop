package cn.mldn.vshop.action.front;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.vshop.service.front.IShopcarServiceFront;
import cn.mldn.vshop.util.action.AbstractBaseAction;

public class ShopcarActionFront extends AbstractBaseAction {
	
	public void add(Long gid) throws Exception{
		if(super.isRoleAndAction("shopcar","shopcar:add")){
			try{
				IShopcarServiceFront service = Factory.getServiceInstance("shopcar.service.front");
				super.print(service.add(super.getMid(), gid));
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			 super.print(false);
 		} 
	}
	public ModelAndView list() throws Exception{		//查看购物车
		if(super.isRoleAndAction("shopcar", "shopcar:add")){
			try{
				IShopcarServiceFront service = Factory.getServiceInstance("shopcar.service.front");
				ModelAndView mav = new ModelAndView(super.getUrl("shopcar.list.page.front"));
 				mav.add(service.list(super.getMid()));
				return mav;
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
			super.setUrlAndMsg("index.page","unaction");
			return mav;
		}
		return null;
	}
	
	public void edit(Long gid,Integer amount) throws Exception {
		if(super.isRoleAndAction("shopcar","shopcar:edit")){
			try{
				IShopcarServiceFront service = Factory.getServiceInstance("shopcar.service.front");
				super.print(service.edit(super.getMid(), amount, gid));
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			super.print(false);
		}
	}
	
	public void editAmount(String sc) throws Exception{		//修改购物车中多个商品数量
  		if(super.isRoleAndAction("shopcar","shopcar:edit")){
			try{
				IShopcarServiceFront service = Factory.getServiceInstance("shopcar.service.front");
				Map<Long,Integer> map = new HashMap<Long,Integer>();
				String result[] = sc.split(",");
				for(int x=0;x<result.length;x++){
					String temp[] = result[x].split(":");
					if(Integer.parseInt(temp[1])==0) {	//商品数量为0，不用修改，直接删除即可。
						service.delete(super.getMid(),Long.parseLong(temp[0]));
					}else{ 
						map.put(Long.parseLong(temp[0]),Integer.parseInt(temp[1]));
					}
				}
				boolean flag = service.editAmountBattch(super.getMid(), map);
 				super.print(flag);
				
			}catch(Exception e){
 				e.printStackTrace();
			}
		}else{
			super.print(false);
		}
	}
	
	public void delete(String sc) throws Exception{		//批量删除购物车中的商品
 		if(super.isRoleAndAction("shopcar","shopcar:delete")){
			try{
				IShopcarServiceFront service =Factory.getServiceInstance("shopcar.service.front");
				String result[]=sc.split(",");
				Set<Long> gids = new HashSet<Long>();
 				for(int x=0;x<result.length;x++){
					gids.add(Long.parseLong(result[x]));
				}
  				super.print (service.deleteByMemberAndGids(super.getMid(), gids));
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			super.print(false);
		}
	
	}
}



















