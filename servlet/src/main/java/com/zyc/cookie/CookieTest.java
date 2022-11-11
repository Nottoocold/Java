package com.zyc.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http是无状态协议 因而无法保存每一次的响应数据 而实际应用需求又需要这些数据
 *
 * @Description 状态管理之Cookie技术  保存在客户端  当客户端访问服务器时 服务器会将某些数据存入响应response头中
 * 待再次访问此服务器时会在request中携带cookie给服务器
 * 当Cookie的path和name都相同时会覆盖原有value
 * @Author zyc
 * @Date 2022/8/4 下午3:25
 */
@WebServlet("/cookie")
public class CookieTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie);
            }
        }
        Cookie C = new Cookie("name", "213");
        C.setPath("/projectName/xxxServlet");//设置哪些资源可以访问此cookie
        C.setMaxAge(60 * 60);//cookie有效期 [>0单位秒, =0失效, (<0 default-1 关闭浏览器失效)]
        resp.addCookie(C);

        //Cookie不支持中文 解决方法
        //URLEncoder 编码
        //URLDecoder 解码
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
