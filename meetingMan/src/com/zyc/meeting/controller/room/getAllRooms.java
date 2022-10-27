package com.zyc.meeting.controller.room;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyc.meeting.entity.Room;
import com.zyc.meeting.service.RoomService;


@WebServlet("/getAllRooms")
public class getAllRooms extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static RoomService service = new RoomService();   

    public getAllRooms() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Room> rooms = service.getAllRoom();
		request.setAttribute("rooms", rooms);
		request.getRequestDispatcher("/jsp/room/allroom.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
