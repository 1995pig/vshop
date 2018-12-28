package cn.mldn.vshop.service.front;

import java.util.Map;

import cn.mldn.vshop.vo.Goods;

public interface IGoodServiceFront {
	/**
	 * 进行商品的查看操作<br>
	 * @param gid 商品id<br>
	 * @return
	 * @throws Exception
	 */
	public Goods get(Integer gid) throws Exception;
	/**
	 * 查看每个子分类下的所拥有的商品<br>
	 * @param sid
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> listBySubitem(Integer sid,Integer currentPage,Integer lineSize) throws Exception;
	/**
	 * 进行商品的展示，进行分页查询<br>
	 * @param currentPage 当前页<br>
	 * @param lineSize 每页显示的数量<br>
	 * @param keyWord 查询关键字<br>
	 * @return 返回的数据有如下内容<br>
	 * 1、key=goods、value=IGoodDAO.findAllSplit()<br>
	 * 2、key=allRecorders、value=IGoodDAO.getAllCount()<br>
 	 * @throws Exception
	 */
	public Map<String,Object> list(Integer currentPage,Integer lineSize,String keyWord) throws Exception;
}
