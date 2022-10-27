package com.zyc.meeting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zyc.meeting.entity.Emp;
import com.zyc.meeting.utils.BaseDao;

public class EmpMapper {
	private static BaseDao dao = new BaseDao();

	/*
	 * 根据电话查询,返回一个Emp实体对象,没有查询到返回null
	 */
	public Emp selectByTel(String tel) {
		Emp emp = new Emp();
		String sql = "select * from meeting_emp where etel = ?";
		ResultSet rs = dao.query(sql, tel);
		try {
			if (rs.next()) {
				try {
					emp.setEid(Integer.valueOf(rs.getString("eid")));
					emp.setEname(rs.getString("ename"));
					emp.setEpwd(rs.getString("epwd"));
					emp.setEstatus(Integer.valueOf(rs.getString("estatus")));
					emp.setDid(Integer.valueOf(rs.getString("did")));
					emp.setEdate(rs.getString("edate"));
					emp.setEtel(rs.getString("etel"));
					dao.close();
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("类型转换异常");
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql异常");
		}
		return emp;
	}

	/*
	 * 添加员工信息,添加成功返回1
	 */
	public int addEmp(Emp e) {
		String ename = e.getEname();
		String epwd = e.getEpwd();
		Integer estatus = e.getEstatus();
		Integer did = e.getDid();
		String etel = e.getEtel();
		String sql = "insert into meeting_emp(eid,ename,epwd,estatus,did,edate,etel) values(null,?,?,?,?,now(),?)";
		int row = dao.update(sql, ename, epwd, estatus, did, etel);
		dao.close();
		return row;
	}

	/*
	 * 查询所有员工信息,返回Emp集合
	 */
	public List<Emp> selectAllEmps() {
		ResultSet rSet = dao.query("select * from meeting_emp where delflag = '0' order by eid");
		List<Emp> emps = new ArrayList<Emp>();
		try {
			while (rSet.next()) {
				Emp emp = new Emp();
				emp.setEid(Integer.valueOf(rSet.getString("eid")));
				emp.setEpwd(rSet.getString("epwd"));
				emp.setEname(rSet.getString("ename"));
				emp.setEtel(rSet.getString("etel"));
				if(rSet.getString("did") !=null){
					emp.setDid(Integer.valueOf(rSet.getString("did")));
				}
				else {
					emp.setDid(null);
				}
				emp.setEstatus(Integer.valueOf(rSet.getString("estatus")));
				emp.setEdate(rSet.getString("edate"));
				emps.add(emp);
			}
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}
	/*
	 * 查询员工表中的部门信息，不去重
	 */
	public List<String> selectDname(){
		ResultSet set = dao.query("select dname from empinfo order by eid");
		List<String> dnames = new ArrayList<>();
		try {
			while(set.next()){
				String dname = set.getString("dname");
				dnames.add(dname);
			}
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dnames;
	}
	
	/*
	 * 条件查询
	 */
	public List<Emp> selectByCon(Map<String, String> map) {
		String _sql = "select * from meeting_emp where delflag = '0'";
		if (map.get("eid") != null) {
			_sql+=" and eid = "+map.get("eid");
		}
		if (map.get("estatus") != null) {
			_sql+=" and estatus = "+map.get("estatus");
		}
		if (map.get("edate") != null) {
			String date = "'%"+map.get("edate")+"%'";
			_sql+=" and edate like "+date;
		}
		_sql+=" order by eid";
		ResultSet rSet = dao.query(_sql);
		List<Emp> emps = new ArrayList<Emp>();
		try {
			while (rSet.next()) {
				Emp emp = new Emp();
				emp.setEid(Integer.valueOf(rSet.getString("eid")));
				emp.setEpwd(rSet.getString("epwd"));
				emp.setEname(rSet.getString("ename"));
				emp.setEtel(rSet.getString("etel"));
				if(rSet.getString("did") !=null){
					emp.setDid(Integer.valueOf(rSet.getString("did")));
				}
				else {
					emp.setDid(null);
				}
				emp.setEstatus(Integer.valueOf(rSet.getString("estatus")));
				emp.setEdate(rSet.getString("edate"));
				emps.add(emp);
			}
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return emps;
	}
	
	public List<String> selectDname(Map<String, String> map) {
		String _sql = "select dname from empinfo where delflag ='0'";
		if (map.get("eid") != null) {
			_sql+=" and eid = "+map.get("eid");
		}
		if (map.get("estatus") != null) {
			_sql+=" and estatus = "+map.get("estatus");
		}
		if (map.get("edate") != null) {
			String date = "'%"+map.get("edate")+"%'";
			_sql+=" and edate like "+date;
		}
		_sql+=" order by eid";
		ResultSet set = dao.query(_sql);
		List<String> dnames = new ArrayList<String>();
		try {
			while(set.next()){
				String dname = set.getString("dname");
				dnames.add(dname);
			}
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dnames;
	}
	
	
	/*
	 * 简单查询
	 */
	public Map<String, String> selectEmp(Integer id) {
		ResultSet set = dao.query("select * from empinfo where eid = ?", id);
		Map<String, String> empMap = new HashMap<>();
		try {
			while(set.next()){
				empMap.put("eid", set.getString(1));
				empMap.put("ename", set.getString(2));
				String status = set.getString(3);
				if (status.equals("0")) {
					empMap.put("estatus", "普通员工");
				}else if (status.equals("1")) {
					empMap.put("estatus", "部门经理");
				}else {
					empMap.put("estatus", "经理助理");
				}
				empMap.put("edate", set.getString(4));
				empMap.put("etel", set.getString(5));
				empMap.put("dname", set.getString(6));
				empMap.put("epwd", set.getString(7));
			}
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empMap;
		
	}

	/*
	 * 删除员工,设置删除标志为1
	 */
	public int delById(Integer id) {
		int row = dao.update("update meeting_emp set delflag = '1' where eid =?", id);
		dao.close();
		return row;
	}
	
	/*
	 * 修改员工信息
	 */
	public int updateById(Emp emp) {
		String sql = "update meeting_emp set ename=?,estatus=?,etel=?,did=?,epwd=? where eid=?";
		int row = dao.update(sql, emp.getEname(),emp.getEstatus(),emp.getEtel(),emp.getDid(),emp.getEpwd(),emp.getEid());
		dao.close();
		return row;
	}
	
}
