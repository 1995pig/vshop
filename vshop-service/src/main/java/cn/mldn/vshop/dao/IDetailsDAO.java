package cn.mldn.vshop.dao;

 
import java.sql.SQLException;
import java.util.Map;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vshop.vo.Details;

public interface IDetailsDAO extends IBaseDAO<Integer,Details> {
	/**
	 * 找到订单中，商品 与 数量 对应的关系<br>
	 * @param oid 订单id<br>
	 * @return
	 * @throws SQLException
	 */
	public Map<Long,Object> findAllByOrders(Integer oid) throws SQLException;

}
