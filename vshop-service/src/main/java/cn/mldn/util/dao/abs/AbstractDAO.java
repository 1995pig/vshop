package cn.mldn.util.dao.abs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.mldn.util.dbc.DatabaseConnection;

public abstract class AbstractDAO {
	protected PreparedStatement pstmt ;
	protected Connection conn ;
	public AbstractDAO() {
		this.conn = DatabaseConnection.getConnection() ;
	}
	public Integer handleCount(String table) throws SQLException{
		String sql = "SELECT COUNT(*) FROM " + table;
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	public Integer handleCount(String table,String keyWord,String column) throws SQLException{
		String sql = "SELECT COUNT(*) FROM " + table +" WHERE " + column +" LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
  			return rs.getInt(1);
		}
 		return 0;
	}
}
