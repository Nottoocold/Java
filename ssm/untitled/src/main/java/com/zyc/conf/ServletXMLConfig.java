package com.zyc.conf;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Tomcat Web.xml 配置
 */

public class ServletXMLConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 配置spring的IOC容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    // 当tomcat启动时加载 springmvc 配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVConfig.class};
    }

    // 配置管理的请求路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CharacterEncodingFilter("UTF-8", true)};
    }
}
