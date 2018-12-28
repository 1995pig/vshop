package cn.mldn.vshop.service.back.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.dao.IGoodsDAO;
import cn.mldn.vshop.dao.IItemDAO;
import cn.mldn.vshop.dao.ISubItemDAO;
import cn.mldn.vshop.service.abs.AbstractService;
import cn.mldn.vshop.service.back.IGoodsServiceBack;
import cn.mldn.vshop.vo.Goods;
import cn.mldn.vshop.vo.Item;
import cn.mldn.vshop.vo.SubItem;

public class GoodsServiceBackImpl extends AbstractService implements IGoodsServiceBack {

	@Override
	public Map<String, Object> getAddPre() throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		IItemDAO itemDAO = Factory.getDAOInstance("item.dao");
		map.put("allItems", itemDAO.findAll());
		return map;
	}

	@Override
	public boolean add(Goods vo) throws Exception {
 		IGoodsDAO goodsDAO = Factory.getDAOInstance("goods.dao");
		vo.setPubdate(new Date());
		vo.setDelflag(0);
		return goodsDAO.doCreate(vo);
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
 		IGoodsDAO goodsDAO = Factory.getDAOInstance("goods.dao");
		if(column == null || keyWord == null || "".equals(column) || "".equals(keyWord)){
			map.put("allGoods",goodsDAO.findAllSplit(currentPage, lineSize));
			map.put("allRecorders", goodsDAO.getAllCount());
		}else{
			map.put("allGoods", goodsDAO.findAllSplit(currentPage, lineSize, column, keyWord));
			map.put("allRecorders", goodsDAO.getAllCount(column, keyWord));
		}
 		return map;
	}

	@Override
	public Map<String, Object> show(Integer gid) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		IGoodsDAO goodsDAO = Factory.getDAOInstance("goods.dao");
		IItemDAO itemDAO = Factory.getDAOInstance("item.dao");
		ISubItemDAO subItemDAO = Factory.getDAOInstance("subitem.dao");
		Goods vo = goodsDAO.findById(gid);
		map.put("goods",vo);
		map.put("item", itemDAO.findById(vo.getIid()));
		map.put("subitem",subItemDAO.findById(vo.getSid()));
 		return map;
	}

	@Override
	public Map<String, Object> editPre(Integer gid) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		IGoodsDAO goodsDAO = Factory.getDAOInstance("goods.dao");
		IItemDAO itemDAO = Factory.getDAOInstance("item.dao");
		map.put("goods", goodsDAO.findById(gid));
		map.put("allItems",itemDAO.findAll());
		return map;
	}

	@Override
	public boolean edit(Goods vo) throws Exception {
		 IGoodsDAO goodsDAO = Factory.getDAOInstance("goods.dao");
		 return goodsDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(Set<Integer> gids) throws Exception {
 		if(gids.size() == 0 || gids == null){
 			return false;
		}
 		IGoodsDAO goodsDAO = Factory.getDAOInstance("goods.dao");
		return goodsDAO.doUpdateDelflag(gids, 1);
	}

	@Override
	public List<Goods> listDetails() throws Exception {
		IGoodsDAO goodDAO = Factory.getDAOInstance("goods.dao");
		return goodDAO.findAllSplit(1, 16);
	}


	 
}
