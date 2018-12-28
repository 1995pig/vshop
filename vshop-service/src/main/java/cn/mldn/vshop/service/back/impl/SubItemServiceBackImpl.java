package cn.mldn.vshop.service.back.impl;

import java.util.List;

import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.dao.ISubItemDAO;
import cn.mldn.vshop.service.abs.AbstractService;
import cn.mldn.vshop.service.back.ISubItemServiceBack;
import cn.mldn.vshop.vo.SubItem;

public class SubItemServiceBackImpl extends AbstractService implements ISubItemServiceBack {
	@Override
	public List<SubItem> listByItemId(Integer iid) throws Exception {
		ISubItemDAO subItem = Factory.getDAOInstance("subitem.dao"); 
 		return subItem.findByItemId(iid);
	}

	@Override
	public boolean edit(SubItem vo) throws Exception {
		ISubItemDAO subItem = Factory.getDAOInstance("subitem.dao");
		return subItem.doUpdate(vo);
	}

}
