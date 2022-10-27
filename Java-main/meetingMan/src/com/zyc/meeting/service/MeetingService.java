package com.zyc.meeting.service;

import com.zyc.meeting.entity.OrderMeet;
import com.zyc.meeting.mapper.MeetMapper;

public class MeetingService {
	private static final Integer PermissionsErr = -1;// 权限不够，只有经理和助理可预定
	private static final Integer NONEEMP = 0;// 没有此人，员工编号有误
	private static final Integer GET = 1;// 预定成功
	private static final Integer Unknown = 9999;//预定不成功，暂时不知道啥原因
	private static MeetMapper mapper = new MeetMapper();

	public static void main(String[] args) {
		new MeetingService();
	}

	/*
	 * 预定会议
	 */
	public int orderMeeting(OrderMeet oMeet) {
		String estatus = mapper.selectById(oMeet.getEid());
		if (estatus == null) {
			return NONEEMP;
		}
		if (estatus.equals("0")) {
			return PermissionsErr;
		}
		int row = mapper.orderMeeting(oMeet) + mapper.updateRoomStatus(oMeet);
		return row == 2 ? GET : Unknown;
	}
}
