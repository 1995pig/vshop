package cn.mldn.vshop.service.front;

import java.util.Map;

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
}
