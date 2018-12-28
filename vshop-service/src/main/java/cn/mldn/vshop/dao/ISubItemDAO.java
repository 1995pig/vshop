package cn.mldn.vshop.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vshop.vo.SubItem;

public interface ISubItemDAO extends IBaseDAO<Integer,SubItem> {
	/**
	 * 通过一级分类找到对应的二级分类
	 * @param iid 一级分类id
	 * @return 返回二级分类的List集合
	 * @throws SQLException
	 */
	public List<SubItem> findByItemId(Integer iid) throws SQLException;
}
