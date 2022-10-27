package com.zyc.meeting.controller.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyc.meeting.entity.Emp;
import com.zyc.meeting.service.EmpService;

/**
 * Servlet implementation class selectByCondition
 */
@WebServlet("/selectByCondition")
public class selectByCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static EmpService service = new EmpService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectByCondition() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = request.getParameter("eidcon");
		String edate = request.getParameter("edatecon");
		String estatus = request.getParameter("estatuscon");
		List<Emp> emps = service.selectByCon(eid,estatus,edate);
		List<String> dnames = service.getDnames(eid, estatus, edate);
		request.setAttribute("emps", emps);
		request.setAttribute("dnames", dnames);
		request.getRequestDispatcher("/jsp/emp/allEmp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
