package cn.mldn.vshop.action.back;

import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.vshop.service.back.ISubItemServiceBack;
import cn.mldn.vshop.util.action.AbstractBaseAction;
import cn.mldn.vshop.vo.SubItem;
import net.sf.json.JSONObject;

public class SubItemActionBack extends AbstractBaseAction{
	ISubItemServiceBack subItem = Factory.getServiceInstance("subitem.service.back");
	public ModelAndView listByItemId(Integer iid) throws Exception{
  		if(super.isRoleAndAction("goods", "goods:item")){
  			try{
  				ModelAndView mav = new ModelAndView(super.getUrl("subitem.list.page"));
				mav.add("allSubItems",subItem.listByItemId(iid));;
  				return mav;
			}catch(Exception e){
  				e.printStackTrace();
			}
		}else{
  			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
			super.setUrlAndMsg("index.back.page", "unaction.msg");
			return mav;
		}
		return null;
	}
	public void edit(SubItem vo) throws Exception{
 		if(super.isRoleAndAction("goods", "goods:edit")){
			try{
 				super.print(subItem.edit(vo));
			}catch(Exception e){
 				super.print(false);
			}
		}else{
 			super.print(false);
		}
	}
	/**
	 * 这个方法是商品添加展示页面，二级分类级联更新用的
	 * @param iid
	 */
	public void listAjax(Integer iid) throws Exception{
  		if(super.isRoleAndAction("goods", "goods:add")){
 			try{
				JSONObject obj = new JSONObject();
 				obj.put("allSubItems", subItem.listByItemId(iid));
 				super.print(obj);
			}catch(Exception e){
 				e.printStackTrace();
			}
		}else{
 			super.print("{\"error\" ,\"unauth\"}");
		}
	}
}
