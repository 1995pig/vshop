package cn.mldn.vshop.dao;

import java.sql.SQLException;
import java.util.Set;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vshop.vo.Action;

public interface IActionDAO extends IBaseDAO<Integer, Action> {
	/**
	 * 根据指定的用户名称判断其是否拥有指定的权限信息
	 * @param mid 用户名
	 * @param actionFlag 权限标记
	 * @return 如果该用户具备有指定的权限，那么返回true，否则返回false
	 * @throws SQLException 通过PreparedStatement执行操作返回的是SQL异常，看见SQL异常就查数据层代码
	 */
	public boolean findActionByMember(String mid,String actionFlag) throws SQLException ;
	/**
	 * 根据用户的编号，列出该用户对应的所有的权限标记信息 
	 * @param mid 用户ID
	 * @return 返回该用户对应的所有权限标记
	 * @throws SQLException 通过PreparedStatement执行操作返回的是SQL异常，看见SQL异常就查数据层代码
	 */
	public Set<String> findAllByMember(String mid) throws SQLException ;
}
