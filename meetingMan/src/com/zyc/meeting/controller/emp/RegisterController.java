package com.zyc.meeting.controller.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyc.meeting.entity.Emp;
import com.zyc.meeting.service.EmpService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/registerController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EmpService service = new EmpService();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename = request.getParameter("ename");
		String epwd = request.getParameter("epwd");
		Integer estatus = Integer.valueOf(request.getParameter("estatus"));
		Integer did = Integer.valueOf(request.getParameter("did"));
		String etel = request.getParameter("etel");
		Emp emp = new Emp();
		emp.setEname(ename);
		emp.setEpwd(epwd);
		emp.setEstatus(estatus);
		emp.setDid(did);
		emp.setEtel(etel);
		if(service.register(emp)){
			//成功
			response.sendRedirect("/day0608_02/getAllEmpInfos");
		}else {
			//失败
			request.getRequestDispatcher("/jsp/emp/addemp.jsp").forward(request, response);
		}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
