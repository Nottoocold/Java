package com.zyc.meeting.service;

import java.util.List;

import com.zyc.meeting.entity.Dept;
import com.zyc.meeting.mapper.DeptMapper;


public class DeptService {

	private DeptMapper dm = new DeptMapper();
	
	/*
	 *	查询所有部门
	 */
	public List<Dept> getAllDept(){
		return dm.getAllDept();
	}
	
	/*
	 * 添加部门
	 */
	public int addDept(String dname) {
		return dm.addDept(dname);
	}
	
	
	/*
	 * 删除部门
	 */
	
	public int delDept(int id) {
		return dm.delDeptById(id);
	}
	
	/*
	 * 修改部门信息
	 */
	public int updateDept(String did,String name){
		return dm.updateDept(did, name);
	}
	
}
