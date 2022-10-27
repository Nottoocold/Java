package com.zyc.meeting.controller.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyc.meeting.service.DeptService;

/**
 * Servlet implementation class delDeptController
 */
@WebServlet("/delDeptController")
public class delDeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DeptService service = new DeptService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delDeptController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String did = request.getParameter("did");
		int row = service.delDept(Integer.valueOf(did));
		if (row > 0) {
			response.sendRedirect("/day0608_02/getAllDeptController");
		}else {
			request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
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
