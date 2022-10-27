package com.zyc.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/3 下午11:25
 */
public class MyServlet implements Servlet {
    /**
     * 实例化，接下来才会初始化
     */
    public MyServlet(){
        System.out.println("1.实例化Servlet.");
    }

    /**
     * 当用户第一次访问时 初始化Servlet对象 且只初始化一次
     * @param config ServletConfig 配置
     * @throws ServletException 异常
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("2.初始化.");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("3.服务.");
        System.out.println(req.getParameter("name"));
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        writer.printf("%s\n", "response...");
        writer.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * Tomcat 服务器停止 则会销毁Servlet容器
     */
    @Override
    public void destroy() {
        System.out.println("4.Servlet is dead.");
    }
}
