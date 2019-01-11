package cn.mldn.vshop.action.back;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import cn.mldn.util.action.ActionSplitPageUtil;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.vshop.service.back.IMemberServiceBack;
import cn.mldn.vshop.util.action.AbstractBaseAction;
import net.sf.json.JSONObject;

public class MemberActionBack extends AbstractBaseAction {
	IMemberServiceBack service = Factory.getServiceInstance("member.service.back");
 	public ModelAndView list() throws Exception{	//查询所有的用户信息
 		
 		if(super.isRoleAndAction("member","member:list")){
  			try{
 				ModelAndView mav = new ModelAndView(super.getUrl("member.list.page.back"));
 				ActionSplitPageUtil aspu = new ActionSplitPageUtil("用户名:mid|姓名:name|联系电话:phone|邮箱:email",
 								"member.list.action.back");
  				Map<String,Object> map = service.list(aspu.getColumn(), aspu.getKeyWord(), aspu.getCurrentPage(), aspu.getLineSize());
 				mav.add(map);
 				return mav;
  			}catch(Exception e){
 				e.printStackTrace();
 			}
 		}else{
 			ModelAndView mav= new ModelAndView(super.getUrl("forward.front.page"));
 			super.setUrlAndMsg("index.back.page", "unaction");
 			return mav;
 		}
 		return null;
 	}
 	
 	public void editPassword(String mid,String password)throws Exception{	//管理员 更新用户的密码
 		if(super.isRoleAndAction("member","member:edit")){
 			try{
 				IMemberServiceBack service = Factory.getServiceInstance("member.service.back");
 				super.print(service.edit(mid, password));
 			}catch(Exception e){
 				e.printStackTrace();
 			}
 		}else{
 			super.print(false);
 		} 
 	}
 	
 	public void editLocked(String[] mid,Integer locked) throws Exception{		//进行用户锁定
 		if(super.isRoleAndAction("member","member:lock" )){
  			try{
 				Set<String> ids = new HashSet<String>();
 				CollectionUtils.addAll(ids,mid);	//直接将接收到的数组转换为Set集合 
 				IMemberServiceBack service = Factory.getServiceInstance("member.service.back");
 				super.print(service.editLocked(ids, locked)); 	//locked==1表示锁定用户
 			}catch(Exception e){
 				e.printStackTrace();
 			}
 		}else{
 			super.print(false);
 		}
 	
 	}
 	public void listMemberInfo(String mid) throws Exception{		//异步加载用户信息
		if(super.isRoleAndAction("info", "info:show")){
			try{
 				IMemberServiceBack service = Factory.getServiceInstance("member.service.back");
 				Iterator<Map.Entry<String,Object>> iter = service.listMemberInfo(mid).entrySet().iterator();
 				JSONObject jsonObj = new JSONObject();
  				while(iter.hasNext()){
 					Map.Entry<String,Object> me = iter.next();
   					jsonObj.put(me.getKey(), me.getValue());
 				}
 				super.print(jsonObj);
 			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
 			super.print("{\"error\":\"unauth\"}");
		}
 	}
}
