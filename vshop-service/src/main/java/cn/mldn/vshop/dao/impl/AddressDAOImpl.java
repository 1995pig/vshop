package cn.mldn.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vshop.dao.IAddressDAO;
import cn.mldn.vshop.vo.Address;

public class AddressDAOImpl extends AbstractDAO implements IAddressDAO {
 	
 	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
 		return false;
	}
 	@Override
	public List<Address> findAll() throws SQLException {
 		return null;
	}
 	@Override
	public List<Address> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
 		return null;
	}
	@Override
	public boolean doUpdate(Address vo) throws SQLException {
 		return false;
	}

	@Override
	public Address findById(Integer id) throws SQLException {
 		return null;
	}
	@Override
	public List<Address> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
 		return null;
	}
 	@Override
	public Integer getAllCount() throws SQLException {
 		return null;
	}
 	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
 		return null;
	}
	
	
	//======================================================
	@Override
	public int getAddressCount(String mid) throws SQLException {
		String sql = "SELECT COUNT(*) FROM address WHERE mid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, mid); 
		ResultSet rs = super.pstmt.executeQuery() ;
		while(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	@Override
	public boolean doCreate(Address vo) throws SQLException {
		String sql = "INSERT INTO address(mid,cid,pid,addr,receiver,phone,deflag)  VALUE(?,?,?,?,?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getMid());
		super.pstmt.setInt(2,vo.getCid());
		super.pstmt.setInt(3, vo.getPid());
		super.pstmt.setString(4,vo.getAddr());
		super.pstmt.setString(5, vo.getReceiver());
		super.pstmt.setString(6, vo.getPhone());
		super.pstmt.setInt(7, vo.getDeflag());
		return super.pstmt.executeUpdate() > 0 ;
	}

	@Override
	public List<Address> findAllByMember(String mid) throws SQLException {
		List<Address> all = new ArrayList<Address>();
		String sql = "SELECT adid,mid,cid,pid,addr,receiver,phone,deflag FROM address WHERE mid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, mid);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
 			Address vo = new Address();
			vo.setAdid(rs.getInt(1));
			vo.setMid(rs.getString(2));
			vo.setCid(rs.getInt(3));
			vo.setPid(rs.getInt(4));
			vo.setAddr(rs.getString(5));
			vo.setReceiver(rs.getString(6));
			vo.setPhone(rs.getString(7));
			vo.setDeflag(rs.getInt(8));
			all.add(vo);
		}
		return all;
	}

	@Override
	public boolean duUpdateFlag(String mid, Integer adid, Integer deflag) throws SQLException {

		String sql = "UPDATE address SET deflag = ? WHERE mid = ? AND adid = ? ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, deflag);
		super.pstmt.setString(2, mid);
		super.pstmt.setInt(3, adid);
		return super.pstmt.executeUpdate() > 0;
	}
	@Override
	public boolean duUpdateFlag(String mid, Integer deflag) throws SQLException {
		
   		String sql = "UPDATE address SET deflag=? WHERE mid=?" ;
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, deflag);
 		super.pstmt.setString(2, mid);
 		return super.pstmt.executeUpdate() > 0;
	}
	
	@Override
	public Address findByIdAndMember(Integer id,String mid) throws SQLException {
		Address vo = null;
		String sql = "SELECT adid,mid,cid,pid,addr,receiver,phone FROM address WHERE adid = ? AND mid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, id);
		super.pstmt.setString(2, mid);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			vo = new Address();
  			vo.setAdid(rs.getInt(1));
  			vo.setMid(rs.getString(2));
  			vo.setCid(rs.getInt(3));
  			vo.setPid(rs.getInt(4));
  			vo.setAddr(rs.getString(5));
  			vo.setReceiver(rs.getString(6));
  			vo.setPhone(rs.getString(7));
 		}
		return vo;
	}
	@Override
	public boolean doUpdateAndMember(Address vo ) throws SQLException {
     	String sql = "UPDATE address SET receiver=?,phone=?,pid=?,cid=?,addr=? WHERE adid=? AND mid = ? ";
  		super.pstmt = super.conn.prepareStatement(sql);
  		super.pstmt.setString(1, vo.getReceiver());
 		super.pstmt.setString(2, vo.getPhone());
		super.pstmt.setInt(3, vo.getPid());
		super.pstmt.setInt(4, vo.getCid());
		super.pstmt.setString(5, vo.getAddr());
		super.pstmt.setInt(6, vo.getAdid());
		super.pstmt.setString(7, vo.getMid());
		return super.pstmt.executeUpdate() > 0 ;
	}

	@Override
	public boolean doRemove(Integer id) throws SQLException {
 		 String sql = "DELETE FROM address WHERE adid = ?";
 		 super.pstmt = super.conn.prepareStatement(sql);
 		 super.pstmt.setInt(1, id);
 		 return pstmt.executeUpdate() > 0;
	}
}
