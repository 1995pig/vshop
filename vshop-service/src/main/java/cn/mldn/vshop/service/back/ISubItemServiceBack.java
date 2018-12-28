package cn.mldn.vshop.service.back;

import java.util.List;

import cn.mldn.vshop.vo.SubItem;

public interface ISubItemServiceBack {
	/**
	 * 找到一级分类所对应的所有二级分类
	 * @param iid 一级分类id
	 * @return 返回一级分类所包含的所有二级分类的list集合
	 * @throws Exception
	 */
	public List<SubItem> listByItemId(Integer iid) throws Exception;
	/**
	 * 编辑二级分类
	 * @param vo 要修改二级分类的数据
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean edit(SubItem vo) throws Exception;
}
