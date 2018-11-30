package cn.mldn.vshop.action.front;

import cn.mldn.util.enctype.PasswordUtil;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.vshop.service.front.IMemberServiceFront;
import cn.mldn.vshop.util.action.AbstractBaseAction;
import cn.mldn.vshop.vo.Member;
//========================================
public class MemberCenterActionFront extends AbstractBaseAction {
	private static final String BASE_INFO = "用户信息";
	private IMemberServiceFront memberService = Factory.getServiceInstance("member.service.front");
	/**
	 * 进行用户基本信息的更新前的数据取得
	 * @return 包含有跳转路径以及信息
	 */
	public ModelAndView	editBasePre(){
		if(super.isRoleAndAction("info", "info:show")){
 			ModelAndView mav = new ModelAndView(super.getUrl("member.edit.base.page"));
			try {
				mav.add("memberBase", this.memberService.getEditBasePre(super.getMid()));
			} catch (Exception e) {
	 			e.printStackTrace();
			}
			return mav;
		}else{
			super.setUrlAndMsg("index.page", "unaction" );
 			ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
 			return mav;
		}
	
	}
	/**
	 * 信息修改操作，修改操作之后需要将修改信息提示给用户，所有一定要找到forward.jsp
	 * @param vo 所有的提交自动转换为VO类对象
	 * @return 更改后跳转路径信息
	 */
	public String editBase(Member vo){
		if(super.isRoleAndAction("info","info:edit")){
			vo.setMid(super.getMid());	//如果要想修改数据，则将用户编号传递过去
			try{ 
				if(this.memberService.editBase(vo)){	//编辑完后还跳转到编辑页面
					super.setUrlAndMsg("member.edit.base.action", "action.edit.success",BASE_INFO);
				}else{
					super.setUrlAndMsg("member.edit.base.action", "action.edit.failure",BASE_INFO);
				}
			}catch(Exception e){
				super.setUrlAndMsg("member.edit.base.action", "action.edit.failure",BASE_INFO);
			}
		}else{
			super.setUrlAndMsg("index.page", "unaction" );
 		}
		return super.getUrl("forward.front.page");
	}
	/**
	 * 用户密码修改操作
	 * @param oldpassword 原始密码
	 * @param newpassword 新密码
	 * @return 更改后跳转路径信息
	 * @throws Exception 
	 */
	public String editPassword(String oldpassword, String newpassword) throws Exception{
		if(super.isRoleAndAction("info", "info:password")){
			oldpassword = PasswordUtil.getPassword(oldpassword);
			newpassword = PasswordUtil.getPassword(newpassword);
			try{
				if(this.memberService.editPassword(super.getMid(), oldpassword, newpassword)){
					super.setUrlAndMsg("logout.action", "member.password.edit.success" );
				}else{
					super.setUrlAndMsg("logout.action", "member.password.edit.failure" );
				}
			}catch(Exception e){
				super.setUrlAndMsg("logout.action", "member.password.edit.failure" );
	 		}
		}else{
			super.setUrlAndMsg("index.page", "unaction.msg");
		}
	 
		return super.getUrl("forward.front.page");
	}
}
