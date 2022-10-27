package com.zyc.an_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description 根据请求路径匹配业务规则
 * @Author zyc
 * @Date 2022/8/4 下午12:22
 */
public class BasicServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
        String uri = req.getRequestURI();
        int i = uri.lastIndexOf('/');
        try {
            Method method = this.getClass().getMethod(uri.substring(i + 1), HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
