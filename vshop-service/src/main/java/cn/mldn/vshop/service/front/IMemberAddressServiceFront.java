package cn.mldn.vshop.service.front;

import java.util.List;
import java.util.Map;

import cn.mldn.vshop.vo.Address;
import cn.mldn.vshop.vo.Member;

public interface IMemberAddressServiceFront {
	/**
	 * 在用户进行地址信息添加前的数据查询工作
	 * @return	
	 * 1、需要查询所有的省份信息<br/>
	 * 2、allProvince = IProvinceDAO.findAll(),返回所有的省份信息<br/>
	 * @throws Exception
	 */
	public Map<String,Object> getAddPre() throws Exception;
	/**
	 * 进行用户地址的添加操作
	 * 1、用户增加地址前，调用IAddress.getAddressCount()，判断该用户是否默认地址<br/>
	 * 2、没有默认地址则将新地址设置为默认地址vo.setDeFlag(1)、反之vo.setDeflag(0);
	 * @return 添加成功返回true
	 * @throws Exception
	 */
	public boolean AddressAdd(Address vo) throws Exception;
	/**
	 * 查找当前用户的所有地址信息
	 * @param mid 当前用户id
	 * @return 返回包含所有地址信息的List集合
	 * @throws Exception 
	 */
	public List<Address> listByMember(String mid) throws Exception;
	/**
	 * 修改用户的默认地址
	 * 1、IAddressDAO.doUpdateFlag(mid,deflag),取消默认地址
	 * 2、IAddressDAO.doUpdateFlag(mid,adid,deflag)，增加默认地址
	 * @param mid 用户编号
	 * @param adid 地址编号id
	 * @return 修改成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean editFlag(String mid,Integer adid) throws Exception;
	/**
	 * 进行地址修改前的数据查询操作，要执行如下的步骤<br>
	 * 1、使用IAddressDAO.findByIdAndMember(Integer id,String mid)方法查询出一个地址的详细内容
	 * 2、使用IProvinceDAO.findAll()方法，查询出所有的省份信息（表单回填）
	 * 3、使用ICityDAO.findAllByProvince(Integer pid)方法，查询出城市信息
	 * @param mid 用户编号
	 * @param adid 地址编号
	 * @return 返回包含有地址、省份、城市信息的map集合
	 * @throws Exception
	 */
	public Map<String,Object> getEditPre(String mid,int adid) throws Exception;
	/**
	 * 进行某一个用户的地址信息的变更处理，调用IAddressDAO.doUpdateAndMember(Address vo,String mid)方法
	 * @param vo 要更改的地址信息
	 * @return 更改成功返回true，失败返回false	
	 * @throws Exception
	 */
	public boolean edit(Address vo) throws Exception;
	/**
	 * 删除用户地址操作
	 * @param adid 地址编号
	 * @return 删除成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean delete(Integer adid) throws Exception;
}
