package com.zyc.meeting.entity;

public class OrderMeet {
	private String rid;
	private String eid;
	private String mtitle;
	private String mdate;
	private String mtime;
	public OrderMeet() {
		super();
	}
	public OrderMeet(String rid, String eid, String mtitle, String mdate, String mtime) {
		super();
		this.rid = rid;
		this.eid = eid;
		this.mtitle = mtitle;
		this.mdate = mdate;
		this.mtime = mtime;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	@Override
	public String toString() {
		return "OrderMeet [rid=" + rid + ", eid=" + eid + ", mtitle=" + mtitle + ", mdate=" + mdate + ", mtime=" + mtime
				+ "]";
	}
	
}
