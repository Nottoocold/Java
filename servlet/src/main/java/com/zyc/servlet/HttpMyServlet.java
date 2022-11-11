package com.zyc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/4 上午10:42
 */
public class HttpMyServlet extends HttpServlet {

/*    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(this.getClass());//class com.zyc.servlet.HttpMyServlet
        if (req.getMethod().equals("GET"))
            this.doGet(req, resp);
    }*/

   /* @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        int i = uri.lastIndexOf('/');
        System.out.println(uri);
        System.out.println(i);
        System.out.println(uri.substring(i + 1));
        Method method = null;
        HttpMyServlet instance = null;
        try {
            method = MyServlet.class.getMethod(uri.substring(i + 1), HttpServletRequest.class, HttpServletResponse.class);
            instance = this.getClass().newInstance();
            method.invoke(instance, req, resp);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
    }
}
