package com.zyc.an_servlet;

import com.zyc.Service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import static com.zyc.code.CharEncoder.*;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/4 下午12:23
 */
@Service(value = {"login","register","selectOne"})
@WebServlet(urlPatterns = {"/user/*"})
public class UserServlet extends BasicServlet {

    @Service(value = "login")
    public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
            当以get方式请求时, 对中文乱码可采取如下方法
         */
/*        byte[] users = request.getParameter("user").getBytes(ISO8859_1);
        String username = new String(users, UTF_8);*/
        try {
            request.setCharacterEncoding(UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.getParameterMap().forEach((k, v) -> {
            System.out.println(k + "\t" + Arrays.toString(v));
        });

        //1.
//        response.setCharacterEncoding(UTF_8);//设置服务端响应的编码格式
//        response.setHeader("Content-Type","text/html;charset=UTF-8");//设置客户端的响应编码格式

        //2.一次设置
        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.println("响应 success.");
        writer.flush();
        writer.close();
    }

    public void test2(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("test2 method.");
    }
}
