package cn.mldn.vshop.service.back.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.dao.IDetailsDAO;
import cn.mldn.vshop.dao.IGoodsDAO;
import cn.mldn.vshop.dao.IOrdersDAO;
import cn.mldn.vshop.service.abs.AbstractService;
import cn.mldn.vshop.service.back.IOrderServiceBack;
import cn.mldn.vshop.vo.Goods;
import cn.mldn.vshop.vo.Orders;

public class OrderServiceBackImpl extends AbstractService implements IOrderServiceBack {

	@Override
	public Map<String, Object> list(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		IOrdersDAO dao = Factory.getDAOInstance("orders.dao"); 
		if(column == null || keyWord == null ||"".equals(column) ||"".equals(keyWord)){
			map.put("allRecorders",dao.getAllCount());
			map.put("allOrders", dao.findAllSplit(currentPage, lineSize));
		}else{
			map.put("allRecorders", dao.getAllCount(column, keyWord));
 			map.put("allOrders", dao.findAllSplit(currentPage, lineSize, column, keyWord));
 		}
		return map;
 	}

	@Override
	public Map<String, Object> get(Integer oid) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		IOrdersDAO ordersDAO = Factory.getDAOInstance("orders.dao");
		IDetailsDAO detailsDAO = Factory.getDAOInstance("details.dao");
		IGoodsDAO goodsDAO = Factory.getDAOInstance("goods.dao");
		//1、查询出订单信息 
		Orders order = ordersDAO.findById(oid);
		map.put("order", order);
		//2、查询订单中 商品对应的数量
		Map<Long,Object> details  = detailsDAO.findAllByOrders(oid);
		map.put("details", details);
		//3、查询该订单中所有的的商品信息
		List<Goods> allGoods = goodsDAO.listByGids(details.keySet());
		map.put("allGoods", allGoods); 
		return map;
	}

	
	
 }
