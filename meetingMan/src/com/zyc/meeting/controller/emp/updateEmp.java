package com.zyc.meeting.controller.emp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyc.meeting.entity.Dept;
import com.zyc.meeting.entity.Emp;
import com.zyc.meeting.service.DeptService;
import com.zyc.meeting.service.EmpService;

/**
 * Servlet implementation class updateEmp
 */
@WebServlet("/updateEmp")
public class updateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpService service = new EmpService();
    private DeptService dService = new DeptService();
    static HashMap<String,String> map = new HashMap<>();
    
    static{
    	map.put("普通员工", "0");
    	map.put("部门经理", "1");
    	map.put("经理助理", "2");
    }
    
    protected Map<String, String> getMap() {
		return map;
	}
    public updateEmp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer estatus = null ;
		Integer did = null;
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String etel = request.getParameter("etel");
		String epwd = request.getParameter("epwd");
		String _estatus = request.getParameter("estatus");//部门经理
		if (map.containsKey(_estatus)) {
			String value = map.get(_estatus);
			estatus = Integer.valueOf(value);//0,1,2
		}
		String _dname = request.getParameter("dname");//技术部
		List<Dept> depts = dService.getAllDept();
		for(Dept dept : depts){
			if (dept.getDname().equals(_dname)) {
				did = dept.getDid();
				break;
			}
		}
		Emp emp = new Emp();
		emp.setEid(Integer.valueOf(eid));
		emp.setEname(ename);
		emp.setEpwd(epwd);
		emp.setEstatus(estatus);
		emp.setDid(did);
		emp.setEtel(etel);
		int i = service.update(emp);
		if (i > 0) {
			request.getRequestDispatcher("/getAllEmpInfos").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
