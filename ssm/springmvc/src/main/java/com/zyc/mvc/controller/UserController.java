package com.zyc.mvc.controller;

import com.zyc.mvc.controller.dao.UserDao;
import com.zyc.mvc.controller.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class UserController {
    @Autowired
    private  UserDao userDao ;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getEmployeeList(Model model){
        Collection<Employee> employeeList = userDao.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model){
        Employee employee = userDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String add(Employee employee){
        userDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        userDao.delete(id);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        userDao.save(employee);
        return "redirect:/employee";
    }

}
