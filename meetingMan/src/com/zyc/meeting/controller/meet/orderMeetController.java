package com.zyc.meeting.controller.meet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyc.meeting.entity.OrderMeet;
import com.zyc.meeting.service.MeetingService;

/**
 * Servlet implementation class orderMeetController
 */
@WebServlet("/orderMeetController")
public class orderMeetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MeetingService service = new MeetingService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderMeetController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		String eid = request.getParameter("eid");
		String mtitle = request.getParameter("mtitle");
		String mdate = request.getParameter("mdate");
		String mtime = request.getParameter("mtime");
		OrderMeet orderMeet = new OrderMeet(rid, eid, mtitle, mdate, mtime);
		int flag = service.orderMeeting(orderMeet);
		if (flag == -1) {
			request.setAttribute("msg", "权限不够，宁只是普通员工...");
			request.getRequestDispatcher("/jsp/room/ordermeet.jsp").forward(request, response);
		}else if (flag == 0) {
			request.setAttribute("msg", "宁输入的员工编号有问题呢...");
			request.getRequestDispatcher("/jsp/room/ordermeet.jsp").forward(request, response);
		}else if (flag == 9999){
			request.setAttribute("msg", "Unknown error...");
			request.getRequestDispatcher("/jsp/room/ordermeet.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "Booking successful!");
			request.getRequestDispatcher("/jsp/room/ordermeet.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
