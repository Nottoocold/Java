package com.zyc.filter;

import com.zyc.code.CharEncoder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @Description 过滤器作用于 客户端和服务端之间  常用来处理 冗余代码 登录验证等问题
 * @Author zyc
 * @Date 2022/8/4 下午5:25
 */
@WebFilter(value = "/fil")
public class FilterTest extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("request..");
        request.setCharacterEncoding(CharEncoder.UTF_8);
        chain.doFilter(request, response);
        System.out.println("response...");
    }
}
