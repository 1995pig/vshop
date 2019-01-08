package cn.mldn.vshop.service.front;

import java.util.Map;
import java.util.Set;

public interface IOrderServiceFront {
	/**
	 * 进行订单确认页的信息提示，该确认页需要具备有如下的信息内容<br>
	 * 1、通过传递的商品编号来找到所有对应的商品信息<br>
	 * 2、既然要进行展示，则将商品的数量也显示出来<br>
	 * 3、取得用户的所有配送地址，肯定也有默认地址<br>
	 * @param mid 用户id<br>
	 * @param gids 下要订单的商品id<br>
	 * @return
	 * 1、key=allShopcars、value=购买的商品编号和数量<br>
	 * 2、key=allGoods、value=商品的信息<br>
	 * 3、key=allAddress、value=所有的配送地址信息<br>
	 * @throws Exception
	 */
	public Map<String,Object> getAddpre(String mid,Set<Long> ids) throws Exception;
	/**
	 * 进行订单的创建处理,该处理包括如下内容<br>
	 * 1、需要根据传入的用户配送地址的id编号取得一个配送地址的详细信息，保存在Orders类中<br>
	 * 2、需要根据用户传入的购买商品的编号查询出所有的商品数据，因为需要进行价格计算<br>
	 * 3、需要根据用户传入的购买商品的编号查询出购物车中对应数据<br>
	 * 4、进行总价的计算，并且将这个计算的结果保存在Orders类之中<br>
	 * 5、订单创建完成之后需要进行订单详情的编号，但是订单详情处理的时候一定要知道编号<br>	
	 * 6、订单创建完成之后一定要删除购物车中对应的商品信息<br>
	 * @param mid 用户编号<br>
	 * @param gid 要购买的商品编号<br>
	 * @param adid 配送地址编号<br>
	 * @return 创建成功返回true,否则返回false<br>
	 * @throws Exception
	 */
	public boolean add(String mid,Set<Long> gids,Integer adid,String note) throws Exception;
	/**
	 * 订单信息的查询<br>
	 * @param mid 当前用户id<br>
	 * @param currentPage 查询当前页<br>
	 * @param lineSize 每页显示的行数<br>
	 * @return 订单信息<br>
	 * key = allCount、value=所有订单的数量<br>
	 * key = allOrders、value=所有订单List信息<br>
	 * @throws Exception
	 */
	public Map<String,Object> list(String mid,Integer currentPage,Integer lineSize) throws Exception;
	/**
	 * 查看订单详情<br>
	 * @param mid 用户id<br>
	 * @param oid 订单id<br>
	 * @return 返回Map集合<br>
	 * @throws Exception
	 */
	public Map<String,Object> get(String mid,Integer oid) throws Exception;
}
