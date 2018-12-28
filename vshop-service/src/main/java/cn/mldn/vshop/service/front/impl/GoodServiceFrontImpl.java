package cn.mldn.vshop.service.front.impl;

import java.util.HashMap;
import java.util.Map;

import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.dao.IGoodsDAO;
import cn.mldn.vshop.service.abs.AbstractService;
import cn.mldn.vshop.service.front.IGoodServiceFront;
import cn.mldn.vshop.vo.Goods;

public class GoodServiceFrontImpl extends AbstractService implements IGoodServiceFront {

	@Override
	public Goods get(Integer gid) throws Exception {
		IGoodsDAO goodDAO = Factory.getDAOInstance("goods.dao");
		return goodDAO.findById(gid);
	}

	@Override
	public Map<String, Object> listBySubitem(Integer sid, Integer currentPage, Integer lineSize) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		IGoodsDAO goodDAO = Factory.getDAOInstance("goods.dao");
		map.put("goods", goodDAO.findAllSplitBySubitem(sid, currentPage, lineSize));
		map.put("allRecorders", goodDAO.getAllCountBySubitem(sid));
		return map;
	}

	@Override
	public Map<String, Object> list(Integer currentPage, Integer lineSize, String keyWord) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		IGoodsDAO dao = Factory.getDAOInstance("goods.dao");
		map.put("goods", dao.findAllSplit(currentPage,lineSize,"title",keyWord)) ;
		map.put("allRecorders", dao.getAllCount("title", keyWord));
		return map;
	}

}
