package cn.mldn.vshop.service.back.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.dao.IItemDAO;
import cn.mldn.vshop.dao.ISubItemDAO;
import cn.mldn.vshop.service.abs.AbstractService;
import cn.mldn.vshop.service.back.IItemServiceBack;
import cn.mldn.vshop.vo.Item;
import cn.mldn.vshop.vo.SubItem;

public class ItemServiceBackImpl extends AbstractService implements IItemServiceBack {
 	@Override
	public List<Item> list() throws Exception {
		 IItemDAO itemDao = Factory.getDAOInstance("item.dao");
		 return itemDao.findAll();
	}

	@Override
	public boolean edit(Item vo) throws Exception {
		IItemDAO itemDAO = Factory.getDAOInstance("item.dao");
		return itemDAO.doUpdate(vo);
	}
	@Override
	public Map<Item, List<SubItem>> listDetails() throws Exception {
		 IItemDAO itemDAO = Factory.getDAOInstance("item.dao");
		 ISubItemDAO subItemDAO = Factory.getDAOInstance("subitem.dao");
		 Map<Item,List<SubItem>> map = new HashMap<Item,List<SubItem>>();
		 List<Item> all = itemDAO.findAll();
		 Iterator<Item> iter = all.iterator();
		 while(iter.hasNext()){
			 Item item = iter.next();
			 map.put(item, subItemDAO.findByItemId(item.getIid()));
		 } 
		 return map;
	} 

 }
