package cn.mldn.vshop.action.front;

import java.util.Map;

import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.vshop.service.front.IMemberAddressServiceFront;
import cn.mldn.vshop.util.action.AbstractBaseAction;
import cn.mldn.vshop.vo.Address;

public class MemberAddressActionFront extends AbstractBaseAction {
	private static final String USER = "用户"  ;
   	private IMemberAddressServiceFront address = Factory.getServiceInstance("member.address.service.front");
 	public ModelAndView addPre() throws Exception{
   		 if(super.isRoleAndAction("address", "address:add")){
   			 ModelAndView mav = new ModelAndView(super.getUrl("member.address.add.page"));
   			 mav.add(this.address.getAddPre());	//添加所有的省份
   			 return mav;
		 }else{		//不具备地址权限 和 地址管理角色,直接返回主页
			 ModelAndView mav =new ModelAndView(super.getUrl("forward.front.page"));
			 super.setUrlAndMsg("index.page", "unaction.msg");
 			 return mav;
		 }
	}
 	public ModelAndView add(Address vo) throws Exception{
 		ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
 		if(super.isRoleAndAction("address", "address:add")){	
 			vo.setMid(super.getMid());
 			if(address.AddressAdd(vo)){
 				super.setUrlAndMsg("member.address.list.action", "address.add.success", USER);
 			}else{
 				super.setUrlAndMsg("member.address.list.action", "action.add.failure", USER);
 			}
 		}else{
			super.setUrlAndMsg("member.address.list.action", "action.add.failure", USER);
  		}
 		return mav;
 	}
 	public String list() throws Exception{
  		if(super.isRoleAndAction("address", "address:list")){
   			ServletObjectUtil.getRequest().setAttribute("allAddress", address.listByMember(super.getMid()));
   			return super.getUrl("member.address.list.page");
 		}else{
 			return super.getUrl("index.page");
 		}
 	}
 	public void editFlag(Integer adid) throws Exception{
  		if(super.isRoleAndAction("address", "address:edit")){
  			try{
  	 			super.print(address.editFlag(super.getMid(), adid));
   			}catch(Exception e){
  	 			super.print(false);
  			}
 		}else{
  			super.print(false);
 		}
 	}
 	
 	public  ModelAndView editPre(Integer adid) throws Exception{
   		if(super.isRoleAndAction("address", "address:edit")){
 	 		ModelAndView mav = new ModelAndView(super.getUrl("member.address.edit.page"));
  			try{
 				Map<String,Object> map =address.getEditPre(super.getMid(), adid);
 				if(map.get("address") == null){		//该信息没有查询到
 					super.setUrlAndMsg("member.address.list.action", "action.edit.notfound" );	
 					mav.setUrl(super.getUrl("forward.front.page"));
 				}else{	//地址信息存在
 					mav.add(map);	//将Map集合中的数据保存到request范围之中
 				} 				
 				return mav;
  			}catch(Exception e){
  				super.setUrlAndMsg("index.page", "address.edit.failure" );
  				mav.setUrl(super.getUrl("forward.front.page"));
  	 	 		return mav;
  			}
 		}else{
 			super.setUrlAndMsg("index.page", "unaction.msg" );
 	 		ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
 	 		return mav;
 		} 
 	}
 	
 	public String edit(Address vo) throws Exception{
   		if(super.isRoleAndAction("address", "address:edit") ){
 			vo.setMid(super.getMid());
 			try{
 				if(address.edit(vo)){
  	 				super.setUrlAndMsg("member.address.list.action", "address.edit.success", super.getMid());
  	 			}else{
  	 				super.setUrlAndMsg("member.address.list.action", "address.edit.failure", super.getMid());
  	 			}	
 			}catch(Exception e){
   				super.setUrlAndMsg("index.page", "address.edit.failure" );
  			}
  		}else{
   			super.setUrlAndMsg("index.page", "unaction.msg");
   		}
 		return super.getUrl("forward.front.page");
 	}
 	
 	public ModelAndView delete(Integer adid) throws Exception{
 		ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
 		if(super.isRoleAndAction("address", "address:delete")){
 			try{
 				if(address.delete(adid)){
 	 				super.setUrlAndMsg("member.address.list.action", "address.delete.success", super.getMid());
  				}else{
  	 				super.setUrlAndMsg("member.address.list.action", "address.delete.failure", super.getMid());
   				}
 			}catch(Exception e){
 	   			super.setUrlAndMsg("index.page", "unaction.msg");
   			}
 		}else{
   			super.setUrlAndMsg("index.page", "unaction.msg");
  		} 
 		return mav;
 	}
}
