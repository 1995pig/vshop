package cn.mldn.vshop.dao;

import java.sql.SQLException;
import java.util.Set;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vshop.vo.Role;

public interface IRoleDAO extends IBaseDAO<Integer, Role> {
	/**
	 * 进行member_role数据关系的保存
	 * @param mid 用户ID
	 * @param rids 角色编号
	 * @return 创建关系成功返回true，否则返回false
	 * @throws SQLException 通过PreparedStatement执行操作返回的是SQL异常，看见SQL异常就查数据层代码
	 */
	public boolean doCreateMemberRole(String mid,Set<Integer> rids) throws SQLException ;
	/**
	 * 当用户更新角色的时候先将所有的已有的角色关系删除干净，而后重新增加
	 * @param mid 用户编号
	 * @return 删除角色成功返回true，否则返回false
	 * @throws SQLException 通过PreparedStatement执行操作返回的是SQL异常，看见SQL异常就查数据层代码
	 */
	public boolean doRemoveMemberRole(String mid) throws SQLException ;
	
	/**
	 * 根据用户的编号，列出该用户对应的所有的角色标记信息
	 * @param mid 用户ID
	 * @return 返回该用户对应的所有角色标记
	 * @throws SQLException 通过PreparedStatement执行操作返回的是SQL异常，看见SQL异常就查数据层代码
	 */
	public Set<String> findAllByMember(String mid) throws SQLException ;
}
