package com.zyc.meeting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyc.meeting.entity.Dept;
import com.zyc.meeting.utils.BaseDao;


public class DeptMapper {

	private static BaseDao dao = new BaseDao();

	/*
	 * 查询所有部门
	 */
	public List<Dept> getAllDept(){
		String sql = "select * from dept order by did";
		ResultSet rs = dao.query(sql);
		List<Dept> list = new ArrayList<>();			
		try {
			while(rs.next()){
				Dept m = new Dept();
				m.setDid(rs.getInt("did"));
				m.setDname(rs.getString("dname"));
				list.add(m);
			}
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * 添加部门
	 */
	public int addDept(String name) {
		String sql = "insert into dept(dname) value(?)";
		int row = dao.update(sql, name);
		dao.close();
		return row;
		
	}
	
	/*
	 * 删除部门
	 */
	public int delDeptById(int id) {
		String sql = "delete from dept where did = ?";
		int row = dao.update(sql, id);
		dao.close();
		return row;
	}
	
	/*
	 * 修改部门信息
	 */
	public int updateDept(String did,String dname){
		String sql = "update dept set dname = ? where did = ?";
		int row = dao.update(sql, dname,did);
		dao.close();
		return row;
	}
	
}
