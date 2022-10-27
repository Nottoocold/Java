package com.zyc.spring.service;

import com.github.pagehelper.PageInfo;
import com.zyc.spring.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    PageInfo<Employee> getAllByPage(Integer pageNum);

}
