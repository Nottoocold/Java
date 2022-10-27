package com.zyc.servlet.lister;

import com.zyc.servlet.ioc.factory.BeanFactory;
import com.zyc.servlet.ioc.factory.iml.BeanFactoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description 监听servlet上下文启动事件 初始化ioc容器 并将其存入application作用域
 * @Author zyc
 * @Date 2022/8/9 13:36
 */
@WebListener
public class ContextLister implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();//servletContext上下文
        String path = application.getInitParameter("IOCConfigPath");//获取IOC容器路径
        BeanFactory beanFactory = new BeanFactoryImpl(path);
        application.setAttribute("beanFactory", beanFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
