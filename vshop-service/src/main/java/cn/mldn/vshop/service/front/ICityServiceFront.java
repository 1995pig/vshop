package cn.mldn.vshop.service.front;

import java.util.List;

import cn.mldn.vshop.vo.City;

public interface ICityServiceFront {
	/**
	 * 根据省份编号查找出所有的城市信息
	 * @param pid 省份编号
	 * @return
	 */
	public List<City> listByProvince(int pid) throws Exception;
	
}
