package com.zyc.meeting.controller.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyc.meeting.entity.Dept;
import com.zyc.meeting.service.DeptService;

/**
 * Servlet implementation class selectDidAndDname
 */
@WebServlet("/selectDidAndDname")
public class selectDidAndDname extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static DeptService service = new DeptService(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectDidAndDname() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dept> depts = service.getAllDept();
		request.setAttribute("depts", depts);
		request.getRequestDispatcher("/jsp/emp/addemp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
