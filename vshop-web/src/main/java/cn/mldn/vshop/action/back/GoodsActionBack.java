package cn.mldn.vshop.action.back;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.action.ActionSplitPageUtil;
import cn.mldn.util.action.ActionUploadUtil;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.vshop.service.back.IGoodsServiceBack;
import cn.mldn.vshop.util.action.AbstractBaseAction;
import cn.mldn.vshop.vo.Goods;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
 
public class GoodsActionBack extends AbstractBaseAction {
	IGoodsServiceBack goodService = Factory.getServiceInstance("goods.service.back");
	public ModelAndView getAddPre(){
		if(super.isRoleAndAction("goods", "goods:add")){
			try{
				ModelAndView mav = new ModelAndView(super.getUrl("goods.add.page"));
				mav.add(goodService.getAddPre());
 				return mav;
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			ModelAndView mav = new ModelAndView(super.getUrl("farward.front.page"));
			super.setUrlAndMsg("index.back.page","unaction.msg");
			return mav;
		}
		return null;
	}
	public ModelAndView add(Goods vo) throws Exception{
 		ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
		if(super.isRoleAndAction("goods", "goods:add")){
  			try{
		  		vo.setMid(super.getMid());
 				ActionUploadUtil auu = new ActionUploadUtil("upload/goods");	//设置保存图片的路径
				vo.setPhoto(auu.createSingleFileName());
   				if(goodService.add(vo)){
  					auu.saveSingleFile();    //如果添加成功就将图片保存在/upload/goods目录下
					super.setUrlAndMsg("goods.addPre.action", "goods.back.add.success");
 				}else{
 					super.setUrlAndMsg("index.back.page", "goods.back.add.failure");
				}
			}catch(Exception e){
  				e.printStackTrace();
			}
		}else{
  			super.setUrlAndMsg("index.back.page","unaction.msg");
 		}
		 
  		return mav;
	}
	public ModelAndView list() throws Exception{
 		if(super.isRoleAndAction("goods", "goods:list")){
 			ActionSplitPageUtil aspu = new ActionSplitPageUtil("商品名称:title|商品描述:note","goods.list.action");
			ModelAndView mav = new ModelAndView(super.getUrl("goods.list.page"));
 			try{ 
				mav.add(goodService.list(aspu.getCurrentPage(), aspu.getLineSize(), aspu.getColumn(),aspu.getKeyWord()));
			}catch(Exception e){	
				e.printStackTrace();
			}
			return mav;
		}else{
			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
			super.setUrlAndMsg("index.back.page", "unaction.msg");
			return mav;
		}
 		
	}
 	public void show(Integer gid) throws Exception{	//展示单个商品信息
 		if(super.isRoleAndAction("goods", "goods:list")){ 
 			JSONObject obj = new JSONObject();
  			try{
 				Map<String,Object> map = goodService.show(gid);	
	 			Set<Map.Entry<String,Object>> set = map.entrySet();	//将Map变成Set集合
	 			Iterator<Map.Entry<String,Object>> iter = set.iterator();
	 			while(iter.hasNext()){
 	 				Map.Entry<String,Object> entry = iter.next();
 	 				obj.put(entry.getKey(),entry.getValue());
 	 			}
 	 			super.print(obj);
 			}catch(Exception e){
 				e.printStackTrace();
 			}
 		}else{
			super.print("{\"error\",\"unauth\"}");
		}
	}
 	public ModelAndView editPre(Integer gid) throws Exception{	//商品编辑前的查询操作
 		if(super.isRoleAndAction("goods", "goods:edit")){
 			ModelAndView mav = new ModelAndView(super.getUrl("goods.edit.page"));
 			try{
 				Map<String,Object> map = goodService.editPre(gid);
 				if(map.get("goods") == null){	//当前数据没有查到。
 					super.setUrlAndMsg("goods.list.action", "action.edit.notfound");
 					mav.setUrl("forward.front.page");
  				}else{
  					mav.add(map);
 				}
 				return mav;
 			}catch(Exception e){
 				e.printStackTrace();
 			}
 		}else{
 			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
 			super.setUrlAndMsg("index.back.page", "unaction");
 			return mav;
 		}
 		return null;
 	}
 	public ModelAndView edit(Goods vo) throws Exception{
 		if(super.isRoleAndAction("goods", "goods:edit")){
  			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page") );
 			vo.setMid(super.getMid());
  			ActionUploadUtil auu = new ActionUploadUtil("upload/goods");	//设置图片保存路径
 			vo.setPhoto(auu.createSingleFileName());
  			try{
  				if(goodService.edit(vo)){
  					auu.saveSingleFile();   //如果修改成功，则保存图片
 					super.setUrlAndMsg("goods.list.action", "goods.back.edit.success");
 				}else{
  					super.setUrlAndMsg("goods.list.action", "goods.back.edit.failure");
 				}
 				return mav;
 			}catch(Exception e){
  				e.printStackTrace();
 			}
 		}else{
  			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
 			super.setUrlAndMsg("goods.list.action", "unaction");
 			return mav;
 		} 
  		return null;
 	}
 	public void delete(int[] gids) throws Exception{	//实现商品的逻辑删除
  		if(super.isRoleAndAction("goods","goods:delete")){
 			try{
 				Set<Integer> set = new HashSet<Integer>();	//不允许重复，无序储存
 				for(int x: gids){
 					set.add(x);
 				}
 				super.print(goodService.delete(set));
 			}catch(Exception e){
 				e.printStackTrace();
 			}
 		}else{
 			super.print("{\"error\",\"unauth \"}");
 		}
 	}
 	public void listDetails() throws Exception{
 		if(super.isRoleAndAction("goods", "goods:list")){
 			try{
 				List<Goods> all = goodService.listDetails();
  				JSONObject obj = new JSONObject();
 				JSONArray goodArray = new JSONArray();
  				Iterator<Goods> iter = all.iterator();
 				while(iter.hasNext()){
  					goodArray.add(iter.next());
 				}
 				obj.put("allGoods", goodArray);
  				File file = new File(ServletObjectUtil.getServletContext().getRealPath("goods.json"));
 				PrintWriter out = new PrintWriter(new FileOutputStream(file));
  				out.println(obj);
 				out.close();
 				super.print(true);
  			}catch(Exception e){
  				e.printStackTrace();
  				super.print(false);
 			}
 		}else{
  			super.print(false);
 		}
 	}
 	 
}













