package cn.mldn.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vshop.dao.IGoodsDAO;
import cn.mldn.vshop.vo.Goods;
import cn.mldn.vshop.vo.Shopcar;

public class GoodsDAOImpl extends AbstractDAO implements IGoodsDAO {

 

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
	public List<Goods> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	//========================================================
	@Override
	public boolean doCreate(Goods vo) throws SQLException {
 		String sql = "INSERT INTO goods(iid,sid,mid,title,price,pubdate,note,delflag,photo) "
				+ " VALUES(?,?,?,?,?,?,?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, vo.getIid());
		super.pstmt.setInt(2, vo.getSid());
		super.pstmt.setString(3, vo.getMid());
		super.pstmt.setString(4, vo.getTitle());
		super.pstmt.setDouble(5, vo.getPrice());
		super.pstmt.setDate(6, new java.sql.Date(vo.getPubdate().getTime()));
		super.pstmt.setString(7, vo.getNote());
		super.pstmt.setInt(8, vo.getDelflag());
		super.pstmt.setString(9, vo.getPhoto());
		return super.pstmt.executeUpdate() > 0; 
 	}	
	@Override
	public List<Goods> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		List<Goods> all = new ArrayList<Goods>();
		String sql = " SELECT gid,iid,sid,mid,title,price,pubdate,note,delflag,photo "
				+ " FROM goods WHERE delflag =0 ORDER BY pubdate DESC LIMIT ?,? ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, (currentPage-1)*lineSize);
		super.pstmt.setInt(2, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Goods vo = new Goods();
			vo.setGid(rs.getLong(1));
			vo.setIid(rs.getInt(2));
			vo.setSid(rs.getInt(3));
			vo.setMid(rs.getString(4));
			vo.setTitle(rs.getString(5));
			vo.setPrice(rs.getDouble(6));
			//vo.setPubdate(new java.sql.Date(rs.getDate(7).getTime()));
			vo.setPubdate(rs.getTimestamp(7));
			vo.setNote(rs.getString(8));
			vo.setDelflag(rs.getInt(9));
			vo.setPhoto(rs.getString(10));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Goods> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		List<Goods> all = new ArrayList<Goods>(); 
		String sql = " SELECT gid,iid,sid,mid,title,price,pubdate,note,delflag,photo  "
				+ " FROM goods WHERE delflag = 0 AND "+column +" LIKE ? ORDER BY pubdate DESC LIMIT ?,? "; 
		super.pstmt=super.conn.prepareStatement(sql);
   		super.pstmt.setString(1,"%" + keyWord + "%");
		super.pstmt.setInt(2,(currentPage-1)*lineSize);
		super.pstmt.setInt(3, lineSize);
 		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
 			Goods vo = new Goods();
			vo.setGid(rs.getLong(1));
			vo.setIid(rs.getInt(2));
			vo.setSid(rs.getInt(3));
			vo.setMid(rs.getString(4));
			vo.setTitle(rs.getString(5));
			vo.setPrice(rs.getDouble(6));
			vo.setPubdate(new java.sql.Date(rs.getDate(7).getTime()));
			vo.setNote(rs.getString(8));
			vo.setDelflag(rs.getInt(9));
			vo.setPhoto(rs.getString(10));
			all.add(vo);
		}
 		return all;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		return super.handleCount("goods");
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return super.handleCount("goods", keyWord, column);
	}

	@Override
	public Goods findById(Integer gid) throws SQLException {
		Goods vo = null;
		String sql = " SELECT gid,iid,sid,mid,title,price,pubdate,note,delflag,photo  "
				+ " FROM goods WHERE delflag = 0 AND gid = ? " ; 
		super.pstmt=super.conn.prepareStatement(sql);
   		super.pstmt.setInt(1,gid); 
 		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
 			vo = new Goods();
			vo.setGid(rs.getLong(1));
			vo.setIid(rs.getInt(2));
			vo.setSid(rs.getInt(3));
			vo.setMid(rs.getString(4));
			vo.setTitle(rs.getString(5));
			vo.setPrice(rs.getDouble(6));
			//vo.setPubdate(new java.sql.Date(rs.getDate(7).getTime()));
			vo.setPubdate(rs.getTimestamp(7));
			vo.setNote(rs.getString(8));
			vo.setDelflag(rs.getInt(9));
			vo.setPhoto(rs.getString(10)); 
		} 
		return vo;
	}

	@Override
	public boolean doUpdate(Goods vo) throws SQLException {
		String sql = "UPDATE goods SET title = ?,iid = ?,sid = ?,price=?,photo=?,note=?"
				+ " WHERE gid = ? AND mid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getTitle());
		super.pstmt.setInt(2, vo.getIid());
		super.pstmt.setInt(3, vo.getSid());
		super.pstmt.setDouble(4, vo.getPrice());
		super.pstmt.setString(5, vo.getPhoto());
		super.pstmt.setString(6, vo.getNote());
		super.pstmt.setLong(7, vo.getGid());
		super.pstmt.setString(8, vo.getMid());
		return super.pstmt.executeUpdate()>0;
 	}

	@Override
	public boolean doUpdateDelflag(Set<Integer> gids, Integer delflag) throws SQLException {
		StringBuffer buf = new StringBuffer("UPDATE goods SET delflag = ? WHERE gid IN(");
		Iterator<Integer> iter =gids.iterator();
		while(iter.hasNext()){
			buf.append(iter.next()).append(",");
		}
		buf.delete(buf.length()-1, buf.length()).append(")");
 		super.pstmt = super.conn.prepareStatement(buf.toString());
		super.pstmt.setInt(1, delflag);
		return super.pstmt.executeUpdate() > 0 ;
	}

	@Override
	public List<Goods> findAllSplitBySubitem(Integer sid, Integer currentPage, Integer lineSize) throws Exception {
 		List<Goods> all = new ArrayList<Goods>();
		String sql = 
				" SELECT gid,iid,sid,mid,title,price,pubdate,note,delflag,photo FROM goods "
				+ "  WHERE delflag = 0 AND sid = ? ORDER BY pubdate DESC LIMIT ?,? " ;
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1,sid);
		super.pstmt.setInt(2, (currentPage - 1)*lineSize);
		super.pstmt.setInt(3, lineSize); 
 		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			Goods vo = new Goods();
			vo.setGid(rs.getLong(1));
			vo.setIid(rs.getInt(2));
			vo.setSid(rs.getInt(3));
			vo.setMid(rs.getString(4));
			vo.setTitle(rs.getString(5));
			vo.setPrice(rs.getDouble(6));
			vo.setPubdate(new java.sql.Date(rs.getDate(7).getTime()));
			vo.setNote(rs.getString(8));
			vo.setDelflag(rs.getInt(9));
			vo.setPhoto(rs.getString(10));
			all.add(vo); 
 		}
 		return all; 
 	}

	@Override
	public Integer getAllCountBySubitem(Integer sid) throws Exception {
		String sql = " SELECT COUNT(*) FROM goods WHERE delflag = 0 AND sid = ? ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, sid);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}

	@Override
	public List<Goods> listByGids(Set<Long> gids) throws SQLException {
		List<Goods> all = new ArrayList<Goods>();
		StringBuffer buf = new StringBuffer("SELECT gid,iid,sid,mid,title,price,pubdate,note,delflag,photo FROM goods WHERE gid in ( ");
 		Iterator<Long> iter = gids.iterator();
		while(iter.hasNext()){
			buf.append(iter.next()).append(",");
		}
 		buf.delete(buf.length()-1,buf.length()).append(")");
 		super.pstmt = super.conn.prepareStatement(buf.toString());
 		ResultSet rs = super.pstmt.executeQuery();
 		while(rs.next()){
 			Goods vo = new Goods();
			vo.setGid(rs.getLong(1));
			vo.setIid(rs.getInt(2));
			vo.setSid(rs.getInt(3));
			vo.setMid(rs.getString(4));
			vo.setTitle(rs.getString(5));
			vo.setPrice(rs.getDouble(6));
			vo.setPubdate(new java.sql.Date(rs.getDate(7).getTime()));
			vo.setNote(rs.getString(8));
			vo.setDelflag(rs.getInt(9));
			vo.setPhoto(rs.getString(10));
			all.add(vo);
		}
		return all;
	}

	 
	 

	
}







