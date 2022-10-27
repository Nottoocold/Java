package com.zyc.meeting.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.zyc.meeting.entity.Room;
import com.zyc.meeting.utils.BaseDao;

public class RoomMapper {
	private static BaseDao dao = new BaseDao();
	
	/*
	 * 初始化会议室界面
	 */
	public List<Room> selectAll() {
		ResultSet rooms = dao.query("select * from meeting_room");
		List<Room> set = new ArrayList<>();
		try {
			while(rooms.next()){
				Room room = new Room();
				room.setRid(rooms.getString("rid"));
				room.setRname(rooms.getString("rname"));
				room.setRdesc(rooms.getString("rdesc"));
				room.setRstatus(rooms.getString("rstatus"));
				room.setRnum(rooms.getString("rnum"));
				set.add(room);
			}
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;
	}
	
	/*
	 * 
	 */
	
	
}
