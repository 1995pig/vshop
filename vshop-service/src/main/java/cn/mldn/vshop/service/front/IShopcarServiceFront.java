package cn.mldn.vshop.service.front;

import java.util.Map;
import java.util.Set;

public interface IShopcarServiceFront {
	/**
	 * 将商品添加到购物车<br>
	 * @param mid 用户id<br>
	 * @param gid 商品id<br>
	 * @return 添加成功返回true,失败返回false<br>
	 * @throws Exception
	 */
	public boolean add(String mid,Long gid) throws Exception;
	/**
	 * 取得当前用户购物车中所有的商品<br>
	 * @param mid 用户id<br>
	 * 1、key=allShopcars,value=商品的编号和数量<br>
	 * 2、key=allGoods,value=商品的信息<br>
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> list(String mid) throws Exception;
	/**
	 * 修改购物车中单个商品的数量<br>
	 * @param mid 用户id<br>
	 * @param amount 单个商品数量<br>
	 * @param gid 商品id<br>
	 * 1、商品数量（amount=0，表示购物车将该商品删除），IShopcarDAO.doRemoveByMemberAndGid()<br>
	 * 2、商品数量（amount>0,只做数量的修改）,IShopcarDAO.doUpdateByMemberAndGid()<br>
	 * @return
	 * @throws Exception
	 */
	public boolean edit(String mid,Integer amount,Long gid) throws Exception;
	/**
	 * 修改购物车中多个商品数量<br>
	 * @param mid 用户id<br>
	 * @param map key=商品id，value=商品数量<br>
	 * @return
	 * @throws Exception
	 */
	public boolean editAmountBattch(String mid,Map<Long,Integer> map) throws Exception;
	/**
	 * 删除购物车中的商品<br>
	 * @param mid
	 * @param gid
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String mid, Long gid) throws Exception;
	/**
	 * 删除购物车中的多个商品<br>
	 * @param mid 用户id<br>
	 * @param gids 包含有多个商品的id<br>
	 * @return
	 * @throws Exception
	 */
	public boolean deleteByMemberAndGids(String mid,Set<Long> gids) throws Exception;
 }
