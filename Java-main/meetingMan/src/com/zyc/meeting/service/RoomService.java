package com.zyc.meeting.service;

import java.util.List;

import com.zyc.meeting.entity.Room;
import com.zyc.meeting.mapper.RoomMapper;

public class RoomService {
	private static RoomMapper mapper = new RoomMapper();
	
	public List<Room> getAllRoom() {
		return mapper.selectAll();
	}
	
}
