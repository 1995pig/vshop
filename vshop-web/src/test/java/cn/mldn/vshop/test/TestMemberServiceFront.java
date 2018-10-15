package cn.mldn.vshop.test;

import org.junit.Test;

import cn.mldn.util.enctype.PasswordUtil;
import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.service.front.IMemberServiceFront;
import cn.mldn.vshop.vo.Member;

public class TestMemberServiceFront {
	//@Test
	public void testLogin() {
		try {
			IMemberServiceFront memberServiceFront = Factory.getServiceInstance("member.service.front");
			System.out.println(memberServiceFront);
			System.out.println(memberServiceFront.login("vadmin", PasswordUtil.getPassword("hello")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	@Test
	public void testAdd() {
		try {
			Member vo = new Member() ;
			vo.setMid("abc");
			vo.setPassword(PasswordUtil.getPassword("hello"));
			IMemberServiceFront memberServiceFront = Factory.getServiceInstance("member.service.front");
			System.out.println(memberServiceFront.addMember(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
