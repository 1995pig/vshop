package cn.mldn.vshop.service.front.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.dao.IAddressDAO;
import cn.mldn.vshop.dao.IDetailsDAO;
import cn.mldn.vshop.dao.IGoodsDAO;
import cn.mldn.vshop.dao.IOrdersDAO;
import cn.mldn.vshop.dao.IShopcarDAO;
import cn.mldn.vshop.service.abs.AbstractService;
import cn.mldn.vshop.service.front.IOrderServiceFront;
import cn.mldn.vshop.vo.Address;
import cn.mldn.vshop.vo.Details;
import cn.mldn.vshop.vo.Goods;
import cn.mldn.vshop.vo.Orders;

public class OrderServiceFrontImpl extends AbstractService implements IOrderServiceFront {

	@Override
	public Map<String, Object> getAddpre(String mid, Set<Long> ids) throws Exception {
		 Map<String,Object> map = new HashMap<String,Object>();
		 IAddressDAO address = Factory.getDAOInstance("address.dao");
		 IShopcarDAO shopcar = Factory.getDAOInstance("shopcar.dao");
		 IGoodsDAO good = Factory.getDAOInstance("goods.dao");
		 map.put("allAddress", address.findAllByMember(mid));	//取得所有的配送地址
 		 map.put("allShopcars", shopcar.findAllByMember(mid));	//map集合 key=商品id,value=商品数量	
 		 map.put("allGoods", good.listByGids(ids));			//所有的商品信息
  		 return map;
	}

	@Override
	public boolean add(String mid, Set<Long> gids, Integer adid,String note) throws Exception {
		//1、如果要想进行订单的创建，那么首先必须知道所购买的商品有哪些
		IGoodsDAO goodDAO = Factory.getDAOInstance("goods.dao");
 		List<Goods> allGoods = goodDAO.listByGids(gids);	//要购买的所有商品信息<br>
		//2、如果要想计算出商品的总价，那么还需要获取商品的数量信息
 		IShopcarDAO shopcarDAO = Factory.getDAOInstance("shopcar.dao");
		Map<Long,Integer> shopcarMap = shopcarDAO.findAllByMember(mid);  //key=商品id,value=商品数量
		//3、有了商品的信息和购买数量信息就可以进行总价的计算
 		double allPrice = 0.0;	//保存总价信息
		Iterator<Goods> iter = allGoods.iterator();
		while(iter.hasNext()){
 			Goods vo= iter.next();
			allPrice += vo.getPrice() * shopcarMap.get(vo.getGid());	//每个商品单价*数量 累加起来就是商品数量<br>
		}	
 		//4、根据用户传入的地址编号取得地址的详细信息<br>
		IAddressDAO addressDAO = Factory.getDAOInstance("address.dao");
		Address address = addressDAO.findByIdAndMember(adid, mid);
		//5、订单的信息已经准备到位，如果要想进行订单创建那么就必须使用IOrderDAO.doCreate()方法
  		Orders order = new Orders(); 
 		order.setMid(mid);
		order.setSubdate(new Date());
		order.setPrice(allPrice);
		order.setNote(note);
		order.setAddress(address.getReceiver() + "、" + address.getPhone() + "、" + address.getAddr());
 
		//6、创建订单信息 
		IOrdersDAO orderDAO = Factory.getDAOInstance("orders.dao");
		IDetailsDAO detailsDAO = Factory.getDAOInstance("details.dao");
		if(orderDAO.doCreate(order)){	//创建订单成功,则创建订单详情
  			//7、取得当前的信息项
			Integer oid = orderDAO.findCreateId() ;	 //取得最后一个订单id
			Iterator<Goods> detailsIter = allGoods.iterator();
  			while(detailsIter.hasNext()){	//每个订单需要给每个商品都要创建订单详情
  				Goods vo = detailsIter.next();
 				Details details = new Details();
				details.setOid(oid);
 				details.setGid(vo.getGid());
 				details.setAmount(shopcarMap.get(vo.getGid()));
 				detailsDAO.doCreate(details);	//创建订单详情
 			}
 			//9、订单详情信息保存完成之后随后就需要进行购物车记录的删除
			return shopcarDAO.doRemoveByMemberAndGoods(mid, gids);
 		}
 		return false;
	}

	@Override
	public Map<String, Object> list(String mid, Integer currentPage, Integer lineSize) throws Exception {
		IOrdersDAO dao = Factory.getDAOInstance("orders.dao");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("allRecorders", dao.getAllCount(mid));
		map.put("allOrders", dao.findAllSplit(currentPage, lineSize,mid)) ; 
 		return map;
	}

	@Override
	public Map<String, Object> get(String mid, Integer oid) throws Exception {
 		Map<String,Object> map = new HashMap<String,Object>();
		IOrdersDAO ordersDao = Factory.getDAOInstance("orders.dao");
 		Orders orders = ordersDao.findById(oid); 
		map.put("orders", orders);		//所有的订单信息<br>
		
		IDetailsDAO detailsDAO = Factory.getDAOInstance("details.dao");
		Map<Long,Object> allDetails = detailsDAO.findAllByOrders(oid);
		map.put("allDetails",allDetails);	//商品 与 数量的对应关系
 		
		IGoodsDAO goodsDAO = Factory.getDAOInstance("goods.dao");
		List<Goods> allGoods = goodsDAO.listByGids(allDetails.keySet());
 		map.put("allGoods", allGoods);		//所有的商品信息<br>
 		return map; 
	}

 }
