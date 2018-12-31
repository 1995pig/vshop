package cn.mldn.vshop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vshop.vo.Goods;
import cn.mldn.vshop.vo.Shopcar;

public interface IShopcarDAO extends IBaseDAO<String,Shopcar> {
	/**
	 * 根据用户的编号和商品编号查询购物车的商品数据<br>
	 * @param mid 用户id<br>
	 * @param gid 商品id<br>
	 * @return 如果发现返回对象，没有返回null<br>
	 * @throws SQLException
	 */
	public Shopcar findByMemberAndGoods(String mid,Long gid) throws SQLException;
	/**
	 * 更新购物车中已有商品的数量<br>
	 * @param mid 用户id<br>
	 * @param gid 商品id<br>
	 * @param amount 购物车中要更新的商品数量<br>
	 * @return 更新成功返回true,失败返回false<br>
	 * @throws SQLException
	 */
	public boolean doUpdateIncreamentById(String mid,Long gid,Integer amount) throws SQLException;
	/**
	 * 找到购物车中的所有商品<br>
	 * @param mid 当前登录用户id<br>
	 * @return 
	 * key = 商品id,value = 商品数量<br>
	 * @throws SQLException
	 */
	public Map<Long,Integer> findAllByMember(String mid) throws SQLException;
	/**
	 * 删除购物车中的商品<br>
	 * @param mid 用户id<br>
	 * @param gid 商品id<br>
	 * @return
	 * @throws SQLException
	 */
	public boolean doRemoveByMemberAndGid(String mid,Long gid) throws SQLException;
	/**
	 * 修改购物车多个商品数量，进行批量修改<br>
	 * @param mid 用户id<br>
	 * @param sc key=商品id,value=商品数量<br>
	 * @return 修改成功返回true，否则返回false<br>
	 * @throws SQLException
	 */
	public  boolean doUpdateAmountBattch(String mid, Map<Long, Integer> sc) throws SQLException;
	/**
	 * 批量删除购物车中的商品<br>
	 * @param mid 用户id<br>
	 * @param gids 商品id的Set集合<br>
	 * @return
	 * @throws SQLException
	 */
	public boolean doRemoveByMemberAndGoods(String mid,Set<Long> gids) throws SQLException;
	
}
