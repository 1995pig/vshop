package cn.mldn.vshop.vo;

import java.io.Serializable;

public class Item implements Serializable {
	private Integer iid;
	private String title;
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", title=" + title + "]";
	}
	
}
