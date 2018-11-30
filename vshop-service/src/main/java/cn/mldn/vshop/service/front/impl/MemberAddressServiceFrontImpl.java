package cn.mldn	.vshop.service.front.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.dao.IAddressDAO;
import cn.mldn.vshop.dao.ICityDAO;
import cn.mldn.vshop.dao.IProvinceDAO;
import cn.mldn.vshop.service.abs.AbstractService;
import cn.mldn.vshop.service.front.IMemberAddressServiceFront;
import cn.mldn.vshop.vo.Address;
import cn.mldn.vshop.vo.Member;

public class MemberAddressServiceFrontImpl extends AbstractService implements IMemberAddressServiceFront {
	 IAddressDAO address = Factory.getDAOInstance("address.dao");

	@Override
	public Map<String, Object> getAddPre() throws Exception {
 		Map<String,Object> map = new HashMap<String,Object>();
  		IProvinceDAO province = Factory.getDAOInstance("province.dao");
   		map.put("allProvinces",province.findAll());
  		return map;
	}

	@Override
	public boolean AddressAdd(Address vo) throws Exception {
		 if(address.getAddressCount(vo.getMid()) >0){	//该用户添加前有默认地址
			 vo.setDeflag(0);
 		 }else{
			 vo.setDeflag(1);		//该用户添加前没有默认地址，新增地址设置为默认地址
		 }
		 return address.doCreate(vo);
	}

	@Override
	public List<Address> listByMember(String mid) throws Exception {
  		 return address.findAllByMember(mid);
	}

	@Override
	public boolean editFlag(String mid, Integer adid) throws Exception {
  		if(address.duUpdateFlag(mid, 0)){
 			return address.duUpdateFlag(mid, adid, 1);
		}
 		return false;
	}

	@Override
	public Map<String, Object> getEditPre(String mid, int adid) throws Exception {
 		 Map<String,Object> map = new HashMap<String,Object>();
 		 Address vo = address.findByIdAndMember(adid, mid);
 		 if(vo != null){
 			 IProvinceDAO provinceDAO = Factory.getDAOInstance("province.dao");
 			 map.put("allProvinces",provinceDAO.findAll());
 			 ICityDAO cityDAO = Factory.getDAOInstance("city.dao");
 			 map.put("allCitys", cityDAO.findAllByProvince(vo.getPid()));
  		 }
 		 map.put("address", vo);
 		 return map;
	}

	@Override
	public boolean edit(Address vo) throws Exception {
 		return address.doUpdateAndMember(vo);
	}

	@Override
	public boolean delete(Integer adid) throws Exception {
		return address.doRemove(adid);
	}

}
