package org.springframework.stu.dao.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;
import org.springframework.stu.dao.UserDao;
import org.springframework.stu.pojo.User;

import java.util.Collections;
import java.util.List;

/**
 * @author zyc
 * @date 2022/10/24
 */
@Repository
public class UserDaoImpl implements UserDao, BeanFactoryAware, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private DefaultListableBeanFactory beanFactory;
    private ApplicationContext applicationContext;
    private String beanName;

    public UserDaoImpl(){
        System.out.println("无参构造");
    }

    @Override
    public List<User> selectUsers() {
        return Collections.singletonList(new User("赵永超", 23));
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
        System.out.println("setBeanFactory method called");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("setBeanName method called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet Method called");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("setApplicationContext method called");
    }

    @Override
    public String toString() {
        return "beanFactory=" + beanFactory +
                ", applicationContext=" + applicationContext +
                ", beanName='" + beanName + '\'' +
                '}';
    }
}
