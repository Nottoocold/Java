package com.zyc.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description  ServletContext作用域
 *                  全局对象 对应于一个Web应用 当服务器启动时创建 停止时销毁
 *
 * @Author zyc
 * @Date 2022/8/4 下午4:56
 */
@WebServlet("/test")
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //1.方法一 GenericServlet 提供的方法
//        System.out.println(this.getServletContext());
        //2.方法二 httpServletRequest extend ServletRequest 父类中有此方法
//        System.out.println(req.getServletContext());
        //3.方法三 httpSession 中有此方法
//        System.out.println(req.getSession().getServletContext());

        /*
         * ServletContext 作用
         * 1.可以获取项目的真实路径
         * 2.全局容器
         */
        //当前项目所在主机物理路径
        System.out.println(servletContext.getRealPath("/"));// /home/zyc/git_repo/IdeaJavaproject/servlet_1/target/servlet_1-1.0-SNAPSHOT/
        //当前项目的根路径(项目名称)
        System.out.println(servletContext.getContextPath());// /servlet_1_war_exploded

        servletContext.setAttribute("", "");
        servletContext.getAttribute("");
        servletContext.removeAttribute("");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
