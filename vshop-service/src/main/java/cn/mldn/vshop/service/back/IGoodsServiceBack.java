package cn.mldn.vshop.service.back;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.vshop.vo.Goods;
import cn.mldn.vshop.vo.Item;
import cn.mldn.vshop.vo.SubItem;

public interface IGoodsServiceBack {
	/**
	 * 进行商品添加的展示信息，调用如下操作：<br>
	 * 1、调用ItemDAO.findAll()方法取得所有产品的分类信息<br>
	 * @return
	 * 2、key=allItems、value=全部的产品分类信息
	 * @throws Exception
	 */
	public Map<String,Object> getAddPre() throws Exception;
	/**
	 * 商品上架功能实现，进行商品的添加。
	 * @param vo 要上架的商品信息
	 * @return 添加成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean add(Goods vo) throws Exception;
	/**
	 * 进行信息列表的显示，如果现在没有模糊查询关键字或列，则表示查询全部数据
	 * @param currentPage 当前页
	 * @param lineSize 每页行
	 * @param column 关键列
	 * @param keyWord 关键字
	 * @return 返回的数据有如下两个内容:<br>
	 * 1、key = allGoods、value=所有的商品数据<br>
	 * 2、key = allRecorders、value = 所有商品数量
	 * @throws Exception
	 */
	public Map<String,Object> list(int currentPage,int lineSize,String column,String keyWord) throws Exception;
	/**
	 * 
	 * 实现单个商品的信息显示<br>
	 * 1、key=item、value=商品分类数据<br>
	 * 2、key=subItem、value=商品子分类数据<br>
	 * 3、key=goods、value=商品数据<br>
	 * @param gid 商品id
	 * @return 包含单个商品信息的Map集合
	 * @throws Exception
	 */
	public Map<String,Object> show(Integer gid) throws Exception;
	/**
	 * 商品信息编辑前的查询操作<br>
	 * 1、key=goods、value=商品数据<br>
	 * 2、key=allItems、value=所有的一级分类<br>
	 * @param gid 商品id<br>
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> editPre(Integer gid) throws Exception;
	/**
	 * 进行商品编辑操作<br> 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean edit(Goods vo) throws Exception;
	/**
	 * 进行商品的逻辑删除<br>
	 * @param gid
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Set<Integer> gids) throws Exception;
	/**
	 * 进行最新商品的信息展示<br>
	 * @return 商品数据<br>
	 * @throws Exception
	 */
	public List<Goods> listDetails() throws Exception;
} 
