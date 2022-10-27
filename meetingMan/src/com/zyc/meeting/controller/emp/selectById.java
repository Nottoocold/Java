package com.zyc.meeting.controller.emp;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyc.meeting.service.EmpService;

/**
 * Servlet implementation class selectById
 */
@WebServlet("/selectById")
public class selectById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EmpService service = new EmpService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _eid = request.getParameter("eid");
		Integer eid = Integer.valueOf(_eid);
		Map<String, String> eMap = service.selectById(eid);
		request.setAttribute("emp", eMap);
		request.getRequestDispatcher("/jsp/emp/upEmp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
