package cn.mldn.vshop.service.back.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.enctype.PasswordUtil;
import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.dao.IAddressDAO;
import cn.mldn.vshop.dao.IMemberDAO;
import cn.mldn.vshop.service.abs.AbstractService;
import cn.mldn.vshop.service.back.IMemberServiceBack;
import cn.mldn.vshop.vo.Member;

public class MemberServiceBackImpl extends AbstractService implements IMemberServiceBack {

	@Override
	public Map<String, Object> list(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception {
		 IMemberDAO memberDAO = Factory.getDAOInstance("member.dao");
		 Map<String,Object> map = new HashMap<String,Object>();
 		 if(column==null||keyWord==null||"".equals(keyWord)||"".equals(column)){
 			 map.put("allRecorders",memberDAO.getAllCount());
   			 map.put("allMembers", memberDAO.findAllSplit(currentPage, lineSize));
  		 }else{
			 map.put("allRecorders",memberDAO.getAllCount(column, keyWord));
			 map.put("allMembers", memberDAO.findAllSplit(currentPage, lineSize, column, keyWord));
		 }
		 return map;
		 
	}

	@Override
	public boolean edit(String mid, String password) throws Exception {
		IMemberDAO memberDAO = Factory.getDAOInstance("member.dao");
		if(memberDAO.findById(mid) !=null){	//该用户存在才可以进行修改
			return memberDAO.doUpdatePassword(mid,PasswordUtil.getPassword(password));	//加密后的密码进行修改
		}else{
			return false;
		} 
	}

	@Override
	public boolean editLocked(Set<String> mid,Integer locked) throws Exception {
 		IMemberDAO memberDAO = Factory.getDAOInstance("member.dao");
		if(mid.size()>0){
			return memberDAO.doUpdateLocked(mid, locked);
		} 
 		return false;
	}
	

	@Override
	public Map<String, Object> listMemberInfo(String mid) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		IMemberDAO memberDAO = Factory.getDAOInstance("member.dao");
		IAddressDAO addressDAO = Factory.getDAOInstance("address.dao");
		Member vo = memberDAO.findById(mid);
		if(vo !=null){
			map.put("member", vo);
			map.put("allAddress", addressDAO.findAllByMember(mid));
		}
		return map ;
	}
	
 
}
