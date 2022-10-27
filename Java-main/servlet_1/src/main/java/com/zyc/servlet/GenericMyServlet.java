package com.zyc.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/4 上午10:36
 */
public class GenericMyServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println(new Date());
    }
}
