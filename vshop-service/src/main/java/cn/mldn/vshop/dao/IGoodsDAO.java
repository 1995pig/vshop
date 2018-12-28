package cn.mldn.vshop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vshop.vo.Goods;

public interface IGoodsDAO extends IBaseDAO<Integer,Goods> { 
	/**
	 * 商品的逻辑删除操作<br>
	 * @param gid 商品id Set集合<br>
	 * @param delflag  实现逻辑删除就需要将delflag等于1即可<br>
	 * @return
	 * @throws SQLException
	 */
	public boolean doUpdateDelflag(Set<Integer> gids,Integer delflag) throws SQLException;
	/**
	 * 根据子分类进行分页查询<br>
	 * @param sid 子分类id<br>
	 * @param currentPage 当前页<br>
	 * @param lineSize 每页显示的行数
	 * @return
	 * @throws Exception
	 */
	public List<Goods> findAllSplitBySubitem(Integer sid,Integer currentPage,Integer lineSize) throws Exception;
	/**
	 * 查询该子分类下的所有商品数量<br> 
	 * @param sid 子分类id<br>
	 * @return
	 * @throws Exception
	 */
	public Integer getAllCountBySubitem(Integer sid) throws Exception;
	/**
	 * 根据指定的编号取出购物车中所有商品<br>
	 * @param gids 
	 * @return
	 * @throws SQLException
	 */
	public List<Goods> listByGids(Set<Long> gids) throws SQLException;
	
	
	
 
}
