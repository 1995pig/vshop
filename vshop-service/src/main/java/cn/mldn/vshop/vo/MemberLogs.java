package cn.mldn.vshop.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class MemberLogs implements Serializable {
	private Integer mlid ;
	private String mid ;
	private Date logindate ;
	public Integer getMlid() {
		return mlid;
	}
	public void setMlid(Integer mlid) {
		this.mlid = mlid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Date getLogindate() {
		return logindate;
	}
	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
}
