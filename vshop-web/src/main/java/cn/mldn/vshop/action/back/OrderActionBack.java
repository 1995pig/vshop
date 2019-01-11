package cn.mldn.vshop.action.back;

import java.util.Iterator;
import java.util.Map;

import cn.mldn.util.action.ActionSplitPageUtil;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.vshop.service.back.IMemberServiceBack;
import cn.mldn.vshop.service.back.IOrderServiceBack;
import cn.mldn.vshop.util.action.AbstractBaseAction;
import net.sf.json.JSONObject;

public class OrderActionBack extends AbstractBaseAction {
	
	public ModelAndView list() throws Exception{	//后台管理员查询所有的订单信息
		if(super.isRoleAndAction("orders","orders:list")){
			try{
				ModelAndView mav = new ModelAndView(super.getUrl("orders.list.page.back"));
				IOrderServiceBack service = Factory.getServiceInstance("orders.service.back");
				ActionSplitPageUtil aspu = 
						new ActionSplitPageUtil("地址:address|价格:price|备注:note|用户id:mid","orders.list.action.back");
				Map<String,Object> map = service.list(aspu.getColumn(), aspu.getKeyWord(),
						aspu.getCurrentPage(),aspu.getLineSize());
				mav.add(map);
				return mav;
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			ModelAndView mav = new ModelAndView("forward.front.page");
			super.setUrlAndMsg("index.back.page", "unaction");
			return mav;
		}
		return null;
	}
	
	public ModelAndView show(Integer oid) throws Exception{	//后台管理员 查询订单详情
		if(super.isRoleAndAction("orders","orders:list")){
			 try{
				 ModelAndView mav = new ModelAndView(super.getUrl("orders.details.show.page.back"));
				 IOrderServiceBack service = Factory.getServiceInstance("orders.service.back");
				 mav.add(service.get(oid));
				 
				 return mav;
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		}else{
			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
			super.setUrlAndMsg("index.page.back", "unaction");
			return mav;
		}
		return null;
	}
	
	
}
