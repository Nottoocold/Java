package com.zyc.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Description Session 作用在服务端 用于记录客户状态 指在一定时间段内 单个客户与服务器的一连串的交互过程
 *  同一浏览器的发起的多次请求 属于同一会话
 *  首次使用Session时 服务器会自动创建Session 并创建Cookie存储SessionId发送回客户端 所以Session技术是基于Cookie技术的
 *
 *  Session 和 Request 区别
 *  1.Session 数据一次会话有效 浏览器不关闭 数据一直可访问
 *  2.Request 每次请求的数据间不能共享
 * @Author zyc
 * @Date 2022/8/4 下午3:56
 */
@WebServlet("/session")
public class SessionTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        session.setAttribute("a","1");
//        session.getAttribute("a");
//        session.removeAttribute("a");
        session.setMaxInactiveInterval(60);//设置Session有效时间 超时失效
//        session.invalidate();//设置失效 手动失效

        //当客户端禁用了cookie时 可使用如下方法解决不是同一个会话的问题
        String newUrl = resp.encodeRedirectURL("/servlet_1_war_exploded/session1");
        resp.sendRedirect(newUrl);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
