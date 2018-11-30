package cn.mldn.vshop.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vshop.vo.Address;

public interface IAddressDAO extends IBaseDAO<Integer, Address> {
	/**
	 * 判断添加前是否有默认地址，返回大于0表示有地址，新增地址flag=0，表示非默认地。
	 * @param mid 新增地址的用户id
	 * @return 返回用户的地址数量
	 * @throws SQLException SQL异常
	 */
	public int getAddressCount(String mid) throws SQLException;
	/**
	 * 找到用户的所有地址
	 * @param mid 当前登录用户的id
	 * @return 返回地址的List集合
	 * @throws SQLException SQL异常
	 */
	public List<Address> findAllByMember(String mid) throws SQLException;
	/**
	 * 修改该当前用户的默认地址
	 * @param mid 当前用户id
	 * @param adid 要修改的默认地址的id编号
	 * @param deflag 默认状态
	 * @return 修改成功返回true，修改失败返回false
	 * @throws SQLException
	 */
	public boolean duUpdateFlag(String mid,Integer adid,Integer deflag) throws SQLException;
	/**
	 * 取消默认地址
	 * @param mid 用户编号
	 * @param deflag 默认状态
	 * @return 修改成功返回true，失败返回false
	 * @throws SQLException
	 */
	public boolean duUpdateFlag(String mid,Integer deflag) throws SQLException;
	/**
	 * 更改用户地址
	 * @param vo 要更改的地址信息
 	 * @return 更改成功返回true，失败返回false
	 * @throws SQLException
	 */
	public boolean doUpdateAndMember(Address vo ) throws SQLException ;
	/**
	 * 地址修改前的查找回填
	 * @param id 地址编号
	 * @param mid 用户编号
	 * @return 返回地址的VO类对象
	 * @throws SQLException
	 */
	public Address findByIdAndMember(Integer id,String mid) throws SQLException ;

}
