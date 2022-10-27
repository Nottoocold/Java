package com.zyc.ssm.filter;

import com.zyc.ssm.transaction.TransActionManage;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 10:34
 */
public class OpenTransactionManageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            TransActionManage.begin();
//            System.out.println("begin trans");
            filterChain.doFilter(servletRequest, servletResponse);
            TransActionManage.commit();
//            System.out.println("commit trans");
        } catch (Exception e) {
            try {
                TransActionManage.rollback();
//                System.out.println("rollback trans");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
