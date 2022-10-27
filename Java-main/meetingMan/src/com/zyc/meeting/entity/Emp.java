package com.zyc.meeting.entity;

public class Emp {
	private Integer eid;
	private String ename;
	private String epwd;
	private Integer estatus;//员工类型：普通员工/部门经理/经理助理
	private Integer did;//部门id
	private String edate;//入职日期
	private String etel;//手机号，用作登录
	
	public Emp() {
		super();
	}
	
	public Emp(Integer eid, String ename, String epwd, Integer estatus, Integer did, String edate, String etel) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.epwd = epwd;
		this.estatus = estatus;
		this.did = did;
		this.edate = edate;
		this.etel = etel;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpwd() {
		return epwd;
	}
	public void setEpwd(String epwd) {
		this.epwd = epwd;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getEtel() {
		return etel;
	}
	public void setEtel(String etel) {
		this.etel = etel;
	}
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", epwd=" + epwd + ", estatus=" + estatus + ", did=" + did
				+ ", edate=" + edate + ", etel=" + etel + "]";
	}
}
