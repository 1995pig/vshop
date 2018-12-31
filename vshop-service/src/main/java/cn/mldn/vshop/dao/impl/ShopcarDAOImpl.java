package cn.mldn.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vshop.dao.IShopcarDAO;
import cn.mldn.vshop.vo.Shopcar;

public class ShopcarDAOImpl extends AbstractDAO implements IShopcarDAO { 

	@Override
	public boolean doUpdate(Shopcar vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Shopcar findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shopcar> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shopcar> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shopcar> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
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
	//=========================================================================
	@Override
	public boolean doCreate(Shopcar vo) throws SQLException {
		String sql = " INSERT INTO shopcar (mid,gid,amount) VALUE (?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getMid());
		super.pstmt.setLong(2, vo.getGid());
		super.pstmt.setInt(3, vo.getAmount());
		return super.pstmt.executeUpdate()>0; 
	}

	@Override
	public Shopcar findByMemberAndGoods(String mid, Long gid) throws SQLException {
		Shopcar sc =null;
		String sql = "SELECT scid,mid,gid,amount FROM shopcar WHERE mid = ? AND gid = ? ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, mid);
		super.pstmt.setLong(2, gid);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
			sc = new Shopcar();
			sc.setScid(rs.getInt(1));
			sc.setMid(rs.getString(2));
			sc.setGid(rs.getLong(3));
			sc.setAmount(rs.getInt(4));
		}
		return sc; 
	}

	@Override
	public boolean doUpdateIncreamentById(String mid,Long gid, Integer amount) throws SQLException {
		String sql = " UPDATE shopcar SET amount = ? WHERE mid = ? AND gid = ? ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, amount);
		super.pstmt.setString(2, mid);
		super.pstmt.setLong(3, gid);
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public Map<Long, Integer> findAllByMember(String mid) throws SQLException {
		Map<Long,Integer> map = new HashMap<Long,Integer> ();
		String sql = " SELECT gid,amount FROM shopcar WHERE mid = ? ";
 		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, mid);
 		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()){
 			map.put(rs.getLong(1), rs.getInt(2));
		}
		return map;
	}

	@Override
	public boolean doRemoveByMemberAndGid(String mid, Long gid) throws SQLException {
		String sql = " DELETE FROM shopcar WHERE mid = ? AND gid = ? ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, mid);
		super.pstmt.setLong(2, gid);
		return super.pstmt.executeUpdate() > 0;
 	}

	@Override
	public boolean doUpdateAmountBattch(String mid, Map<Long, Integer> sc) throws SQLException {
		String sql = "UPDATE shopcar SET amount = ? WHERE mid = ? AND gid = ? ";
		super.pstmt = super.conn.prepareStatement(sql);
		Iterator<Map.Entry<Long, Integer>> iter = sc.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<Long,Integer> me = iter.next();
			super.pstmt.setInt(1, me.getValue());
			super.pstmt.setString(2, mid);
			super.pstmt.setLong(3, me.getKey());
			super.pstmt.addBatch();   //加入批处理
		}
		int result[] = super.pstmt.executeBatch();	
		for(int x=0;x<result.length;x++){
			if(result[x] == 0){
				return false;
			}
		}
		return true;
		
	}

	@Override
	public boolean doRemoveByMemberAndGoods(String mid, Set<Long> gids) throws SQLException {
 		StringBuffer buf = new StringBuffer(" DELETE FROM shopcar WHERE mid = ? AND gid IN (");
		Iterator<Long> iter = gids.iterator();
		while(iter.hasNext()){
			buf.append(iter.next()).append(",");
		}
		buf.delete(buf.length()-1, buf.length()).append(")");
 		super.pstmt = super.conn.prepareStatement(buf.toString());
		super.pstmt.setString(1, mid);
		return super.pstmt.executeUpdate() > 0;
		
// 		下面是批处理，同样可以实现该操作。		
//		String sql = "DELETE FROM shopcar WHERE mid = ? AND gid = ? ";
//		super.pstmt = super.conn.prepareStatement(sql);
//		Iterator<Long> iter = gids.iterator();
//		while(iter.hasNext()){
//			super.pstmt.setString(1, mid);
//			super.pstmt.setLong(2, iter.next());
//			super.pstmt.addBatch();
//		}
//		int result[] =super.pstmt.executeBatch();
//		for(int x=0;x<result.length;x++){
//			if(result[x] < 0){
//				return false;
//			}
//		}
//		return true;
	}
 
}
