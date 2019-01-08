package cn.mldn.vshop.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vshop.vo.Orders;

public interface IOrdersDAO extends IBaseDAO<Integer,Orders> {
	/**
	 * 取得增长后的id数据信息<br>
	 * @return 增长后的id内容<br>
	 * @throws SQLException 
	 */
	public Integer findCreateId() throws SQLException;
	/**
	 * 进行订单的分页查询<br>
	 * @param currentPage 当前页<br>
	 * @param lineSize 每页显示的行数<br>
	 * @param mid 当前用户id<br>
	 * @return 订单信息<br>
	 * @throws SQLException
	 */
	List<Orders> findAllSplit(Integer currentPage, Integer lineSize, String mid) throws SQLException;
	 /**
	  * 查询当前用户的所有订单<br>
	  * @param mid
	  * @return
	  * @throws SQLException
	  */
	List<Orders> findAll(String mid) throws SQLException;
	/**
	 * 查询当前用户的订单数量<br>
	 * @param mid
	 * @return
	 * @throws SQLException
	 */
	Integer getAllCount(String mid) throws SQLException;
}
