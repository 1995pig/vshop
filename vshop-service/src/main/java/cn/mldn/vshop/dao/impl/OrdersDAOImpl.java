package cn.mldn.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vshop.dao.IOrdersDAO;
import cn.mldn.vshop.vo.Orders;

public class OrdersDAOImpl extends AbstractDAO implements IOrdersDAO {

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	 
	@Override
	public boolean doUpdate(Orders vo) throws SQLException {
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
	public List<Orders> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

 	@Override
	public List<Orders> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	 
 	@Override
	public List<Orders> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

 
	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	//========================================================================
	@Override
	public Integer findCreateId() throws SQLException {
		 String sql = " SELECT LAST_INSERT_ID() ";
		 super.pstmt = super.conn.prepareStatement(sql);
		 ResultSet rs = super.pstmt.executeQuery();
		 while(rs.next()){
			 return rs.getInt(1);
		 } 
		 return null;
	}

	@Override
	public boolean doCreate(Orders vo) throws SQLException {
		String sql = "INSERT INTO orders (mid,subdate,price,note,address) VALUES (?,?,?,?,?) ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getMid());
		super.pstmt.setDate(2, new java.sql.Date(vo.getSubdate().getTime()));
		//super.pstmt.setTimestamp(2, new java.sql.Timestamp(vo.getSubdate().getTime()));
		super.pstmt.setDouble(3, vo.getPrice());
		super.pstmt.setString(4, vo.getNote());
		super.pstmt.setString(5, vo.getAddress());
 		return super.pstmt.executeUpdate() > 0;
	}

	

	@Override
	
	public Integer getAllCount(String mid) throws SQLException {
  		String sql = "SELECT COUNT(*) FROM orders WHERE mid = ?" ;
		super.pstmt = super.conn.prepareStatement(sql);
 		super.pstmt.setString(1, mid);
		ResultSet rs = super.pstmt.executeQuery();
 		if(rs.next()){
 			return rs.getInt(1);
		}
 		return 0;
	}
	@Override
	public List<Orders> findAllSplit(Integer currentPage, Integer lineSize,String mid) throws SQLException {
 		List<Orders> all = new ArrayList<Orders>();
		String sql = "SELECT oid,mid,subdate,price,note,address FROM orders WHERE mid=? LIMIT ?,?  ";
 		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, mid);
		super.pstmt.setInt(2, (currentPage - 1) * lineSize);
		super.pstmt.setInt(3, lineSize);
 		ResultSet rs = super.pstmt.executeQuery();
 		while(rs.next()){
 			Orders vo = new Orders();
			vo.setOid(rs.getInt(1));
			vo.setMid(rs.getString(2));
			//vo.setSubdate(rs.getTimestamp(3));
			vo.setSubdate(new java.sql.Date(rs.getDate(3).getTime()));
			vo.setPrice(rs.getDouble(4));
			vo.setNote(rs.getString(5));
			vo.setAddress(rs.getString(6));
			all.add(vo);
		}
 		return all;		
	}
	@Override
	public List<Orders> findAll(String mid) throws SQLException {
		List<Orders> all = new ArrayList<Orders>();
		String sql = "SELECT oid,mid,subdate,price,note,address FROM orders WHERE mid = " + mid;
		super.pstmt = super.conn.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Orders vo = new Orders();
			vo.setOid(rs.getInt(1));
			vo.setMid(rs.getString(2));
			//vo.setSubdate(rs.getTimestamp(3));
			vo.setSubdate(new java.sql.Date(rs.getDate(3).getTime()));
			vo.setPrice(rs.getDouble(4));
			vo.setNote(rs.getString(5));
			vo.setAddress(rs.getString(6));
			all.add(vo);
		}
		return all;
	}


	@Override
	public Orders findById(Integer id) throws SQLException {
		Orders vo = null;
		String sql = "SELECT oid,mid,address,subdate,price,note FROM orders WHERE oid = ? ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			vo = new Orders();
			vo.setOid(rs.getInt(1));
			vo.setMid(rs.getString(2));
			vo.setAddress(rs.getString(3));
			vo.setSubdate(new java.sql.Date(rs.getDate(4).getTime()));
			vo.setPrice(rs.getDouble(5));
			vo.setNote(rs.getString(6));
		}
		return vo;
	}

	
}
