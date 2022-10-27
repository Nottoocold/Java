package com.zyc.meeting.controller.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyc.meeting.service.EmpService;

/**
 * Servlet implementation class delEmpController
 */
@WebServlet("/delEmpController")
public class delEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service = new EmpService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delEmpController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = request.getParameter("eid");
		int row = service.delEmpById(Integer.valueOf(eid));
		if (row > 0) {
			request.getRequestDispatcher("/getAllEmpInfos").forward(request, response);
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
