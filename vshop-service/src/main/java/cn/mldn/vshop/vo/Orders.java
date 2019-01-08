package cn.mldn.vshop.vo;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
	private Integer oid;
	private String mid;
	private Date subdate;
	private Double price;
	private String note;
	private String address;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Date getSubdate() {
		return subdate;
	}
	public void setSubdate(Date subdate) {
		this.subdate = subdate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", mid=" + mid + ", subdate=" + subdate + ", price=" + price + ", note=" + note
				+ ", address=" + address + "]";
	}
	
}
