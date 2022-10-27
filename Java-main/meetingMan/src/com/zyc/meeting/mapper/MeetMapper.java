package com.zyc.meeting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zyc.meeting.entity.OrderMeet;
import com.zyc.meeting.utils.BaseDao;

public class MeetMapper {
	private static BaseDao dao = new BaseDao();

	/*
	 * 根据员工id查数据,返回员工职位类型
	 */
	public String selectById(String id) {
		ResultSet row = dao.query("select estatus from meeting_emp where eid = ? and delflag = '0'", id);
		String estatus = null;
		try {
			if (row.next()) {
				estatus = row.getString(1);
			}
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estatus;
	}
	
	/*
	 * 更新会议表
	 */
	public int orderMeeting(OrderMeet order) {
		String sql = "insert into meeting_info(eid,mdate,rid,mtitle,mtime) values(?,?,?,?,?)";
		int m = dao.update(sql, order.getEid(), order.getMdate(), order.getRid(), order.getMtitle(), order.getMtime());
		dao.close();
		return m ;
	}
	
	/*
	 * 更新会议室状态
	 */
	public int updateRoomStatus(OrderMeet order) {
		int n = dao.update("update meeting_room set rstatus = 1 where rid = ?", order.getRid());
		dao.close();
		return n;
	}
}
