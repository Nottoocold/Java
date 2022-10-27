package com.zyc.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/*
    此接口中的两个方法 可以在初始化之前对bean进行处理 BeanPostProcessor管理的是整个IOC容器
 */
public class BeanProcess implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("Before Init," + "beanName is " + beanName + ",bean is " + bean);
        if (bean instanceof My) {
            ((My) bean).setName("初始化之前修改Name");
            System.out.println(bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("After Init," + "beanName is " + beanName + ",bean is " + bean);
        if (bean instanceof My) {
            ((My) bean).setName("初始化之后修改Name");
        }
        return bean;
    }
}
