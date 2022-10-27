package com.zyc.meeting.entity;


public class Dept {
	private int did;
	private String dname;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Dept(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	public Dept() {
		super();
	}
	@Override
	public String toString() {
		return "meeting_dept [did=" + did + ", dname=" + dname + "]";
	}
		
}
