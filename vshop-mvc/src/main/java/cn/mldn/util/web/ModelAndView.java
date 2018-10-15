package cn.mldn.util.web;

import java.util.Map;

public class ModelAndView {
	private String url ;
	public ModelAndView() {}
	public ModelAndView(String url) {
		this.url = url ;
	}
	/**
	 * 设置request属性
	 * @param name 属性名称
	 * @param value 属性内容
	 */
	public void add(String name,Object value) {
		ServletObjectUtil.getRequest().setAttribute(name, value);
	}
	/**
	 * 将Map集合转变为Request属性范围中的内容保存
	 * @param map 设置一组属性，可以用于查询列表全部数据使用
	 */
	public void add(Map<String,Object> map) { 
		for (Map.Entry<String, Object> me : map.entrySet()) {
			ServletObjectUtil.getRequest().setAttribute(me.getKey(), me.getValue());
		}
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
}
