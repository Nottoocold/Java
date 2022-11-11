package com.zyc.an_servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/4 下午12:35
 */
@WebServlet(urlPatterns = {"/book/*"})
public class BookServlet extends BasicServlet {

    public void book1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("book1 method.");
    }

    public void book2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("book2 method.");
    }
}
