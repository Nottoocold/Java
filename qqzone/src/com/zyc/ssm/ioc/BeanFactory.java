package com.zyc.ssm.ioc;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/8 17:26
 */
public interface BeanFactory {

    Object getBean(String id);
}
