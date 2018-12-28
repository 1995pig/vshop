package cn.mldn.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vshop.dao.ISubItemDAO;
import cn.mldn.vshop.vo.SubItem;

public class SubItemDAOImpl extends AbstractDAO implements ISubItemDAO {

	@Override
	public boolean doCreate(SubItem vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean doRemove(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	} 

	@Override
	public List<SubItem> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubItem> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubItem> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	//=======================================
	@Override
	public List<SubItem> findByItemId(Integer iid) throws SQLException {
 		List<SubItem> all = new ArrayList<SubItem>();
   		String sql = "SELECT sid,iid,title FROM subitem WHERE iid = ?";
   		super.pstmt = super.conn.prepareStatement(sql);
  		super.pstmt.setInt(1, iid);
  		ResultSet rs = super.pstmt.executeQuery();
 		while(rs.next()){
			SubItem vo = new SubItem();
			vo.setSid(rs.getInt(1));
			vo.setIid(rs.getInt(2));
			vo.setTitle(rs.getString(3));
			all.add(vo);
		}
		return all;
 	}

	@Override
	public boolean doUpdate(SubItem vo) throws SQLException {
 		String sql = "UPDATE subitem SET title = ? WHERE iid = ? AND sid = ?";
 		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1,vo.getTitle());
 		super.pstmt.setInt(2, vo.getIid());
 		super.pstmt.setInt(3, vo.getSid());
 		return super.pstmt.executeUpdate() > 0;
	}



	@Override
	public SubItem findById(Integer id) throws SQLException {
		SubItem vo = null;
		String sql = "SELECT sid,iid,title FROM subitem WHERE sid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			vo = new SubItem();
			vo.setSid(rs.getInt(1));
			vo.setIid(rs.getInt(2));
			vo.setTitle(rs.getString(3));
		}
		return vo;
	}
	
}
