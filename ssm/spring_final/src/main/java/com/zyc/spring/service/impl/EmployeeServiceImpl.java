package com.zyc.spring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyc.spring.mapper.EmployeeMapper;
import com.zyc.spring.pojo.Employee;
import com.zyc.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<Employee> getAllByPage(Integer pageNum) {
        //分页插件 本质就是一个拦截器
        PageHelper.startPage(pageNum,5);
        List<Employee> list = employeeMapper.getAllEmpList();
        //搜集查询数据
        return new PageInfo<>(list, 5);
    }
}

