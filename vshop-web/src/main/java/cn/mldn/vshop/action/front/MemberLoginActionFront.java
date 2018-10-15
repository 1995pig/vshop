package cn.mldn.vshop.action.front;

import java.util.Map;

import cn.mldn.util.enctype.PasswordUtil;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.vshop.service.front.IMemberServiceFront; 
import cn.mldn.vshop.util.action.AbstractBaseAction;
import cn.mldn.vshop.util.cookie.RememberMeUtil;
import cn.mldn.vshop.vo.Member;

public class MemberLoginActionFront extends AbstractBaseAction {

	public ModelAndView add(Member member) {
		ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
		IMemberServiceFront memberService = Factory.getServiceInstance("member.service.front");
		try {
			member.setPassword(PasswordUtil.getPassword(member.getPassword()));
			if(memberService.addMember(member)) {	// 注册成功
				super.setUrlAndMsg("login.page", "regist.success");
			} else {
				super.setUrlAndMsg("regist.page", "regist.failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	public void checkMid(String mid) {
		IMemberServiceFront memberService = Factory.getServiceInstance("member.service.front");
		try {
			super.print(memberService.checkMid(mid));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String logout() {
		RememberMeUtil rmu = new RememberMeUtil(ServletObjectUtil.getRequest(), ServletObjectUtil.getResponse());
		rmu.clear();
		ServletObjectUtil.getSession().invalidate();
		super.setUrlAndMsg("index.page", "logout.success");
		return super.getUrl("forward.front.page");
	}

	public ModelAndView login(Member member) {
		ModelAndView mav = new ModelAndView(super.getUrl("forward.front.page"));
		IMemberServiceFront memberService = Factory.getServiceInstance("member.service.front");
		try {
			Map<String, Object> map = memberService.login(member.getMid(),
					PasswordUtil.getPassword(member.getPassword()));
			int result = (Integer) map.get("status"); // 取得登录状态
			if (result == 1) { // 登录成功状态
				ServletObjectUtil.getSession().setAttribute("mid", member.getMid()); // 在session中保存登录的标记数据
				ServletObjectUtil.getSession().setAttribute("name", map.get("name"));
				ServletObjectUtil.getSession().setAttribute("lastdate", map.get("lastdate"));
				ServletObjectUtil.getSession().setAttribute("allRoles", map.get("allRoles"));
				ServletObjectUtil.getSession().setAttribute("allActions", map.get("allActions"));
				String rememberme = ServletObjectUtil.getRequest().getParameter("rememberme");
				if (rememberme != null || "true".equals(rememberme)) { // 选中了复选框
					// 当用户登录成功之后需要进行Cookie信息的保存处理
					RememberMeUtil rmu = new RememberMeUtil(ServletObjectUtil.getRequest(),
							ServletObjectUtil.getResponse());
					rmu.saveRemeber(member.getMid(), PasswordUtil.getPassword(member.getPassword())); // 进行加密处理操作
				}
				super.setUrlAndMsg("index.page", "login.success");
				// msg = "登录成功，欢迎光临！" ;
			} else if (result == 2) {
				// msg = "该用户已经被锁定，请与管理员联系！" ;
				super.setUrlAndMsg("login.page", "login.locked");
			} else {
				super.setUrlAndMsg("login.page", "login.failure");
				// msg = "用户登录失败，错误的用户名或者是密码！" ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
