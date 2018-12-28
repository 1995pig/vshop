package cn.mldn.vshop.service.back;

import java.util.List;
import java.util.Map;

import cn.mldn.vshop.vo.Item;
import cn.mldn.vshop.vo.SubItem;

public interface IItemServiceBack {
	/**
	 * 查询出所有的一级分类
	 * @return 返回一级分类的List集合
	 * @throws Exception
	 */
	public List<Item> list() throws Exception;
	/**
	 * 将一级分类进行修改
	 * @param vo 要修改的一级分类VO类对象
	 * @return 修改成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean edit(Item vo) throws Exception;
	/**
	 * 要返回所有的一级栏目和所对应的二级栏目<br>
	 * 1、使用IItemDAO.findAll() 查询所有的一级栏目<br>
	 * 2、使用ISubItemDAO.findByItemId,查询到一级栏目所对应的二级栏目信息<br>
 	 * @return Map集合的key为一级栏目，value为二级栏目<br>
	 * @throws Exception
	 */
	public Map<Item,List<SubItem>> listDetails() throws Exception;
}
