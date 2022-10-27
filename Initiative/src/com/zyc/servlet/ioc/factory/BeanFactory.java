package com.zyc.servlet.ioc.factory;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/8 17:26
 */
public interface BeanFactory {

    Object getBean(String id);
}
