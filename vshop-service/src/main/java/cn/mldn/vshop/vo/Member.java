package cn.mldn.vshop.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Member implements Serializable {
	private String mid ;
	private String name ;
	private String email ;
	private String password ;
	private String phone ;
	private Date regdate ;
	private Date lastdate ;
	private Integer locked ;
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public Date getRegdate() {
		return regdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", email=" + email + ", password=" + password + ", phone="
				+ phone + ", regdate=" + regdate + ", lastdate=" + lastdate + ", locked=" + locked + "]";
	}
}
