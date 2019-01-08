package cn.mldn.vshop.action.front;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.action.ActionSplitPageUtil;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ParameterValueUtil;
import cn.mldn.vshop.service.front.IOrderServiceFront;
import cn.mldn.vshop.util.action.AbstractBaseAction;

public class OrderActionFront extends AbstractBaseAction {
 	public ModelAndView getAddPre(int[] gids) throws Exception{	//进行订单的创建处理操作,即订单确认页的信息提示
   		if(super.isRoleAndAction("orders", "orders:add")){
			try{
				ModelAndView mav = new ModelAndView(super.getUrl("order.add.page.front"));
				IOrderServiceFront service = Factory.getServiceInstance("order.service.front");
				Set<Long> ids = new HashSet<Long>();
 				for(int x=0;x<gids.length;x++){
 					ids.add((long)gids[x]);
				}
  				mav.add(service.getAddpre(super.getMid(), ids));
 				return mav;
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
			super.setUrlAndMsg("index.page","unaction" );
			return mav;
		}
		return null;
	}
	public ModelAndView add( String note,Integer adid) throws Exception{	//购物车下单
 		ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
  		if(super.isRoleAndAction("orders","orders:add")){
			IOrderServiceFront service = Factory.getServiceInstance("order.service.front");
 			try{
 				String gid[] = ParameterValueUtil.getParameterValues("gid");
				Set<Long> gids = new HashSet<Long>();
				for(String x: gid){
					gids.add(Long.parseLong(x));
				}
 				if(service.add(super.getMid(), gids, adid, note)){
 					super.setUrlAndMsg("shopcar.list.action.front", "order.add.success",super.getMid());
 				}else{
 					super.setUrlAndMsg("shopcar.list.action.front", "order.add.failure",super.getMid());
				}
 			}catch(Exception e){
 				e.printStackTrace();
			}
		}else{
 			super.setUrlAndMsg("index.page", "unaction.msg");
 		}
		return mav;
 	}
	
	public ModelAndView list() throws Exception{
		IOrderServiceFront service = Factory.getServiceInstance("order.service.front");
		ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
		if(super.isRoleAndAction("orders","orders:list")){
			try{
				ActionSplitPageUtil aspu = new ActionSplitPageUtil("","order.list.action.front");
 				Map<String,Object> map = service.list(super.getMid(), aspu.getCurrentPage(),aspu.getLineSize());
				mav.add(map);
				mav.setUrl(super.getUrl("order.list.page.front"));
 			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			super.setUrlAndMsg("index.page", "unaction" );
		}
		return mav;
	}
	
	public ModelAndView details(Integer oid) throws Exception{
 		ModelAndView mav = new ModelAndView(super.getUrl("order.details.page.front"));
		if(super.isRoleAndAction("orders", "orders:show")){
			try{
 				IOrderServiceFront service = Factory.getServiceInstance("order.service.front");
				Map<String,Object> map = service.get(super.getMid(), oid);
 				mav.add(map);
 			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			super.setUrlAndMsg("index.page", "unaction");
		}
		return mav;
	}
}
