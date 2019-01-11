package cn.mldn.vshop.service.back;

import java.util.Map;

public interface IOrderServiceBack {
	/**
	 * 后台管理员查询所有的订单信息<br>
	 * @param column 查询关键列<br>
	 * @param keyWord 查询关键字<br>
	 * @param currentPage 当前页<br>
	 * @param lineSize 每页显示的行数<br>
	 * @return
	 * key=allRecorders、value=订单数量<br>
	 * key=allOrders、value=所有的订单信息<br>
	 * @throws Exception
	 */
	public Map<String,Object> list(String column,String keyWord,
			Integer currentPage,Integer lineSize) throws Exception;
	/**
	 * 查询订单详情<br>
	 * @param oid 订单编号<br>
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> get(Integer oid) throws Exception;
}
