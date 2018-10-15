package cn.mldn.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vshop.dao.IActionDAO;
import cn.mldn.vshop.vo.Action;

public class ActionDAOImpl extends AbstractDAO implements IActionDAO {
	@Override
	public boolean findActionByMember(String mid, String actionFlag)
			throws SQLException {
		String sql = "SELECT flag FROM action "
				+ " WHERE rid IN ( "
				+ "		SELECT rid FROM member_role WHERE mid=?) AND flag=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, mid);
		super.pstmt.setString(2, actionFlag);
		ResultSet rs = super.pstmt.executeQuery() ;
		if (rs.next()) {	// 具备有此权限
			return true ;
		}
		return false;
	}
	
	@Override
	public Set<String> findAllByMember(String mid) throws SQLException {
		Set<String> set = new HashSet<String>() ;
		String sql = "SELECT flag FROM action "
				+ " WHERE rid IN ( "
				+ "		SELECT rid FROM member_role WHERE mid=?)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, mid);
		ResultSet rs = super.pstmt.executeQuery() ;
		while (rs.next()) {
			set.add(rs.getString(1)) ;
		}
		return set;
	}
	@Override
	public boolean doCreate(Action vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Action vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Action findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Action> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Action> findAllSplit(Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Action> findAllSplit(Integer currentPage, Integer lineSize,
			String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
