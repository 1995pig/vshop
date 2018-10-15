package cn.mldn.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vshop.dao.IRoleDAO;
import cn.mldn.vshop.vo.Role;

public class RoleDAOImpl extends AbstractDAO implements IRoleDAO {
	@Override
	public boolean doRemoveMemberRole(String mid) throws SQLException {
		String sql = "DELETE FROM member_role WHERE mid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, mid);
		return super.pstmt.executeUpdate() >= 0 ;
	}
	@Override
	public boolean doCreateMemberRole(String mid,Set<Integer> rids)
			throws SQLException {
		String sql = "INSERT INTO member_role(mid,rid) VALUES (?,?)" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		Iterator<Integer> iter = rids.iterator() ;
		while (iter.hasNext()) {
			super.pstmt.setString(1, mid);
			super.pstmt.setInt(2, iter.next());
			super.pstmt.addBatch(); 	// 追加批处理
		} 
		super.pstmt.executeBatch() ;
		return true ; 
	}
	
	@Override
	public Set<String> findAllByMember(String mid) throws SQLException {
		Set<String> set = new HashSet<String>() ;
		String sql = "SELECT flag FROM role "
				+ " WHERE rid IN ( "
				+ "		SELECT rid FROM member_role WHERE mid=?) ";
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, mid);
		ResultSet rs = super.pstmt.executeQuery() ;
		while (rs.next()) {
			set.add(rs.getString(1)) ;
		}
		return set;
	}
	
	@Override
	public boolean doCreate(Role vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Role vo) throws SQLException {
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
	public Role findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() throws SQLException {
		List<Role> all = new ArrayList<Role>() ;
		String sql = "SELECT rid,title,flag FROM role" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		ResultSet rs = super.pstmt.executeQuery() ;
		while (rs.next()) {
			Role vo = new Role() ;
			vo.setRid(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setFlag(rs.getString(3));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public List<Role> findAllSplit(Integer currentPage, Integer lineSize)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllSplit(Integer currentPage, Integer lineSize,
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
