package cn.mldn.vshop.action.front;

import cn.mldn.util.action.ActionSplitPageUtil;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.vshop.service.front.IGoodServiceFront;
import cn.mldn.vshop.util.action.AbstractBaseAction;

public class GoodsActionFront extends AbstractBaseAction {
	IGoodServiceFront goodService = Factory.getServiceInstance("goods.service.front");
	public ModelAndView show(Integer gid) throws Exception{
 		if(super.isRoleAndAction("goods", "goods:list")){
 			try{
				ModelAndView mav = new ModelAndView(super.getUrl("goods_show.page"));
				mav.add("goods",goodService.get(gid));
				return mav;
			}catch(Exception e){
 				e.printStackTrace();
			}
		}else{
 			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
			super.setUrlAndMsg("index.page", "unaction.msg");
		}
 		return null;
	}
	
	public ModelAndView list(Integer sid) throws Exception{
		if(super.isRoleAndAction("goods", "goods:list")){
			try{
   				ActionSplitPageUtil asp = new ActionSplitPageUtil("","goods.list.subitem.action.front");
				ModelAndView mav = new ModelAndView(super.getUrl("goods.list.subitem.page.front"));
 				mav.add(goodService.listBySubitem(sid,asp.getCurrentPage(),asp.getLineSize()));
 				mav.add("paramName", "sid");
 				mav.add("paramValue",sid);
				return mav;
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
			super.setUrlAndMsg("index.page", "unaction");
			return mav;
		}
		return null;
	}
	
	public ModelAndView research() throws Exception{
		if(super.isRoleAndAction("goods", "goods:list")){
 			try{
				ModelAndView mav = new ModelAndView(super.getUrl("goods.list.page.front"));
			 	ActionSplitPageUtil aspu = new ActionSplitPageUtil("","goods.list.action.front");
				mav.add(goodService.list(aspu.getCurrentPage(), aspu.getLineSize(), aspu.getKeyWord()));
 				return mav;
			}catch(Exception e){
 				e.printStackTrace();
			}
		}else{
 			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
			super.setUrlAndMsg("index.page", "unaction");
			return mav;
		}
 		return null;
	}
}

