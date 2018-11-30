package cn.mldn.vshop.util.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import cn.mldn.util.action.ActionMessageUtil;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.vshop.vo.Action;
import cn.mldn.vshop.vo.Role;

public abstract class AbstractBaseAction {
	/**
	 * 进行是否具备有指定角色的检测，所有的角色保存在session范围中的allRoles.
	 * @param role 角色标记
	 * @return 具备指定角色返回true
	 */
	public boolean isRole(String role){
 		Set<Role> allRoles = (Set<Role>)ServletObjectUtil.getSession().getAttribute("allRoles");
  		return allRoles.contains(role);
	}
	/**
	 * 进行是否具备有指定权限的检测，所有的权限保存在session范围中的allActions
	 * @param action 权限标记
	 * @return 具备有指定权限返回false
	 */
	public boolean isAction(String action){
   		Set<Action> allActions = (Set<Action>) ServletObjectUtil.getSession().getAttribute("allActions");
 		return allActions.contains(action);
	}
	/**
	 * 进行角色和权限的双重认证，调用isRole()和isAction()方法
	 * @param role 角色标记
	 * @param action 权限标记
	 * @return 具备有指定的角色和权限返回true
	 */
	public boolean isRoleAndAction(String role,String action){ 
		return this.isRole(role) && this.isAction(action);
	}
	
	/**
	 * 取得路径信息，通过ActionMessageUtil.getUrl()方法获得
	 * 
	 * @param key 资源文件key
	 * @return 取得资源对应的内容
	 */
	public String getUrl(String key) {
		return ActionMessageUtil.getUrl(key);
	}
	/**
	 * 通过Request属性范围设置msg与url两个参数的内容
	 * @param urlKey url参数的key
	 * @param msgKey msg参数的key
	 */
	public void setUrlAndMsg(String urlKey,String msgKey,Object...param) {
		ServletObjectUtil.getRequest().setAttribute("url", this.getUrl(urlKey));
		ServletObjectUtil.getRequest().setAttribute("msg", this.getMsg(msgKey,param));
		
	}

	/**
	 * 取得提示文字信息，通过ActionMessageUtil.getMsg()方法获得
	 * 
	 * @param key 资源文件key
	 * @param param 占位符数据
	 * @return 取得资源对应的内容
	 */
	public String getMsg(String key, Object... param) {
		return ActionMessageUtil.getMsg(key, param);
	}

	/**
	 * 进行信息打印输出操作，主要为ajax异步处理操作提供支持
	 * 
	 * @param value 要打印的对象内容
	 * @throws UnsupportedEncodingException 
	 */
	public void print(Object value) throws UnsupportedEncodingException {
 		ServletObjectUtil.getRequest().setCharacterEncoding("UTF-8");
 		ServletObjectUtil.getResponse().setCharacterEncoding("UTF-8");
		try {
			ServletObjectUtil.getResponse().getWriter().print(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//===================================================
	/**
	 * 根据当前登录的session取得该用户的编号信息
	 * @return 用户编号，如果没有登陆过返回null
	 */
	public String getMid(){
		return (String)ServletObjectUtil.getSession().getAttribute("mid");
	}
	
}












