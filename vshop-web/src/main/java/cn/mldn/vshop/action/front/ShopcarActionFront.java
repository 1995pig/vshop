package cn.mldn.vshop.action.front;

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
}
