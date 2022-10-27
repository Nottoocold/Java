package com.zyc.meeting.entity;

public class Room {
	private String rid;
	private String rname;
	private String rdesc;
	private String rstatus;//0-可用，1-已预约，2-维修中
	private String rnum;//可容纳人数
	public Room() {
		super();
	}
	public Room(String rid, String rname, String rdesc, String rstatus, String rnum) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.rdesc = rdesc;
		this.rstatus = rstatus;
		this.rnum = rnum;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRdesc() {
		return rdesc;
	}
	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}
	public String getRstatus() {
		return rstatus;
	}
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "Room [rid=" + rid + ", rname=" + rname + ", rdesc=" + rdesc + ", rstatus=" + rstatus + ", rnum=" + rnum
				+ "]";
	}
	
}
