package cn.mldn.vshop.service.back;

import java.util.Map;
import java.util.Set;

public interface IMemberServiceBack {
	/**
	 * 查询所有的用户信息<br>
	 * @param column 查询列<br>
	 * @param keyWord 查询关键字<br>
	 * @param currentPage 当前页<br>
	 * @param lineSize 每页显示的行数<br>
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object > list(String column,String keyWord,
				Integer currentPage,Integer lineSize) throws Exception;
	/**
	 * 管理员 更新用户的密码<br>
	 * @param mid 要被更新密码的用户id<br>
	 * @param password 新密码<br>
	 * 
	 * 1、IMemberDAO.findById()更新前先判断该用户是否存在<br>
	 * 2、IMemberDAO.doUpdatePassword()更新用户密码<br>
	 * @return 修改成功返回true<br>
	 * @throws Exception
	 */
	public boolean edit(String mid,String password) throws Exception;
	/**
	 * 更改用户的状态<br>
	 * @param mid 用户id<br>
	 * @return
	 * @throws Exception
	 */
	public boolean editLocked(Set<String> mid,Integer locked) throws Exception;
	/**
	 * 异步加载用户信息
	 * @param mid 用户id<br>
	 * @return
	 * 1、key=member、value=用户信息对象<br>
	 * 2、key=allAddress、value=要查询的用户的所有地址信息<br>
	 * @throws Exception
	 */
	public Map<String,Object> listMemberInfo(String mid) throws Exception;
}
