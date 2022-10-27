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
 * Servlet implementation class getAllEmpInfos
 */
@WebServlet("/getAllEmpInfos")
public class GetAllEmpInfos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EmpService service = new EmpService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllEmpInfos() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Emp> emps = service.selectAllEmps();
		List<String> dnames = service.getDnames();
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
