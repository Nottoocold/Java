package com.zyc.meeting.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zyc.meeting.entity.Emp;
import com.zyc.meeting.mapper.EmpMapper;

public class EmpService {
	private EmpMapper mapper = new EmpMapper();
	
	/*
	 * 注册员工,成功返回true，失败返回false
	 */
	public Boolean register(Emp e) {
		if (mapper.selectByTel(e.getEtel()) == null) {
			return mapper.addEmp(e) == 1;
		}
		return false;
	}
	
	/*
	 * 简单查询
	 */
	public Map<String, String> selectById(Integer id) {
		return mapper.selectEmp(id);
	}
	
	/*
	 * 查询所有员工信息
	 */
	public List<Emp> selectAllEmps() {
		ArrayList<Emp> emps = new ArrayList<>();
		emps = (ArrayList<Emp>) mapper.selectAllEmps();
		return emps;
	}
	
	/*
	 * 获取员工信息表中的部门信息
	 */
	public List<String> getDnames() {
		ArrayList<String> dnames = new ArrayList<>();
		dnames = (ArrayList<String>) mapper.selectDname();
		return dnames;
	}
	
	/*
	 * 条件查询
	 */
	public List<Emp> selectByCon(String eid,String estatus,String edate) {
		Map<String, String> map = new HashMap<>();
		map.put("eid", eid.isEmpty()?null:eid);
		map.put("edate", edate.isEmpty()?null:edate);
		map.put("estatus", estatus.equals("-1")?null:estatus);
		List<Emp> emps = mapper.selectByCon(map);
		return emps;
	}
	
	public List<String> getDnames(String eid,String estatus,String edate) {
		Map<String, String> map = new HashMap<>();
		map.put("eid", eid.isEmpty()?null:eid);
		map.put("edate", edate.isEmpty()?null:edate);
		map.put("estatus", estatus.equals("-1")?null:estatus);
		List<String> dnames = mapper.selectDname(map);
		return dnames;
	}
	
	/*
	 * 删除员工
	 */
	public int delEmpById(int id) {
		return mapper.delById(id);
	}
	
	/*
	 * 修改
	 */
	public int update(Emp emp) {
		return mapper.updateById(emp);
	}
}
