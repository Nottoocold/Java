package com.zyc.springmvc.controller;

import com.github.pagehelper.PageInfo;
import com.zyc.spring.pojo.Employee;
import com.zyc.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/page/{pageNum}", method = RequestMethod.GET)
    public String getAll(@PathVariable("pageNum") Integer pageNum, Model model) {
        PageInfo<Employee> employees = employeeService.getAllByPage(pageNum);
        model.addAttribute("emps", employees);
        return "result";
    }
}
