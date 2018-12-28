package cn.mldn.vshop.service.front.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.dao.IGoodsDAO;
import cn.mldn.vshop.dao.IShopcarDAO;
import cn.mldn.vshop.service.front.IShopcarServiceFront;
import cn.mldn.vshop.vo.Goods;
import cn.mldn.vshop.vo.Shopcar;

public class ShopcarServiceFrontImpl implements IShopcarServiceFront {

	@Override
	public boolean add(String mid, Long gid) throws Exception {
		IShopcarDAO dao = Factory.getDAOInstance("shopcar.dao");
		Shopcar sc = dao.findByMemberAndGoods(mid, gid);
		if(sc != null){	//购物车有该商品，再次添加只需要修改购物车中该商品的数量即可
  			return dao.doUpdateIncreamentById(mid, gid, sc.getAmount() +1);
		}else{	//购物车中没有该商品，需要创建该购物车
			Shopcar vo = new Shopcar();
 			vo.setMid(mid);
			vo.setGid(gid);
			vo.setAmount(1);
			return dao.doCreate(vo);
		} 
	}

	@Override
	public Map<String, Object> list(String mid) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		IGoodsDAO goodDAO = Factory.getDAOInstance("goods.dao");
		IShopcarDAO shopcarDAO = Factory.getDAOInstance("shopcar.dao");
 		Map<Long,Integer> shopcar = shopcarDAO.findAllByMember(mid);
  		if(shopcar.size() > 0){
 			List<Goods> all = goodDAO.listByGids(shopcar.keySet());
 			map.put("allGoods", all);
		}
		map.put("allShopcars", shopcar);
 		return map;
	}

}
