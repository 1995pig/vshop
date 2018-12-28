package cn.mldn.vshop.action.back;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.vshop.service.back.IItemServiceBack;
import cn.mldn.vshop.util.action.AbstractBaseAction;
import cn.mldn.vshop.vo.Item;
import cn.mldn.vshop.vo.SubItem;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ItemActionBack extends AbstractBaseAction {
	IItemServiceBack itemServiceBack = Factory.getServiceInstance("item.service.back");
	public  ModelAndView list() throws Exception{
   		if(super.isRoleAndAction("goods", "goods:item")){
  			ModelAndView mav = new ModelAndView(super.getUrl("item.list.page"));
			try{
 				mav.add("allItems", itemServiceBack.list());
				return mav;
 			}catch(Exception e){
   				e.printStackTrace();
 			}
 		}else{
 			 ModelAndView mav = new ModelAndView("forward.front.page");
			 super.setUrlAndMsg("index.back.page", "unaction.msg");
			 return mav;
		}
  		return null;
 	}
	public void edit(Item vo) throws Exception{
 		if(super.isRoleAndAction("goods", "goods:edit")){
 			try{
 				super.print(itemServiceBack.edit(vo));
			}catch(Exception e){
 				super.print(false);
			}
		}else{
 			super.print(false);
		}
 	}
	public void listDetails() throws Exception{
		if(super.isRoleAndAction("goods", "goods:item")){
			JSONObject all = new JSONObject();
			JSONArray itemArray = new JSONArray();
			Map<Item,List<SubItem>> map = itemServiceBack.listDetails();
			Iterator<Map.Entry<Item,List<SubItem>>> iter = map.entrySet().iterator();
			while(iter.hasNext()){
				JSONObject itemObj = new JSONObject();
				JSONArray subitem = new JSONArray();
				Map.Entry<Item,List<SubItem>> entry = iter.next();
				itemObj.put("item", entry.getKey());
				Iterator<SubItem> subIter  = entry.getValue().iterator();
				while(subIter.hasNext()){
 					subitem.add(subIter.next());
				}
				itemObj.put("subitems", subitem);
				itemArray.add(itemObj);
			}
			all.put("items", itemArray);
			File file = new File(ServletObjectUtil.getServletContext().getRealPath("/item.json"));
			PrintWriter out = new PrintWriter(new FileWriter(file));	//向item.json输出文件
			out.print(all);			//向item.json输出JSON数据
			out.close();
			super.print(true);
		}else{
			super.print(false);
		}
	}
}
