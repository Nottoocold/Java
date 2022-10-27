package com.zyc.servlet.controller;

import com.zyc.servlet.ioc.factory.BeanFactory;
import com.zyc.utils.StringUtil;
import com.zyc.view.ViewBaseServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description 中央控制器 负责解析URL 映射到不同Controller中不同的方法<br/>并根据放回置进行不同的响应处理
 * @Author zyc
 * @Date 2022/8/7 下午6:13
 */
@WebServlet(name = "CentralController", value = "*.do")
public class CentralController extends ViewBaseServlet {
    private static final String RESPONSETAG = "redirect:";
    private static BeanFactory beanFactory = null;

    /**
     * 初始化 中央控制器从上下文获取IOC容器
     *
     * @throws ServletException ..
     */
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = getServletContext();
        //从作用域中获取ioc容器
        Object beanFactoryOBJ = servletContext.getAttribute("beanFactory");
        if (beanFactoryOBJ != null) {
            beanFactory = (BeanFactory) beanFactoryOBJ;
        } else {
            throw new RuntimeException("从作用域中获取IOC容器失败!");
        }
    }

    /**
     * 根据请求中的操作符号,获取IOC容器中映射到的实例,通过反射调用指定的方法,并根据返回值进行不同的响应
     *
     * @param request  ..
     * @param response ..
     * @throws ServletException ..
     * @throws IOException      ..
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据请求路径创建分别映射到不同对象  /fruit.do
        String servletPath = request.getServletPath();
        int lastIndexOf = servletPath.lastIndexOf('.');
        servletPath = servletPath.substring(1, lastIndexOf);
        Object o = beanFactory.getBean(servletPath);
        //获取请求操作符(即Controller中对应的Method)
        String opt = request.getParameter("opt");
        if (StringUtil.isEmpty(opt))
            opt = "index";
        try {
            //利用反射获取指定的Controller实例中指定方法
            Method method = o.getClass().getDeclaredMethod(opt, HttpServletRequest.class);
            method.setAccessible(true);
            Object invoke = method.invoke(o, request);
            if (invoke != null) {
                String retStr = (String) invoke;
                if (StringUtil.isNotEmpty(retStr)) {
                    if (retStr.startsWith(RESPONSETAG)) {//根据返回标志 进行响应
                        retStr = retStr.substring(RESPONSETAG.length());// redirect:fruit
                        response.sendRedirect(retStr + ".do");
                    } else {
                        super.processTemplate(retStr, request, response);
                    }
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("opt :" + opt + " is illegal");
        }
    }
}
