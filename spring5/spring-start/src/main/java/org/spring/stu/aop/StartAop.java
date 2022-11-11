package org.spring.stu.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.stu.aop.demo.target.AopDemoClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zyc
 * @date 2022/11/3
 */
public class StartAop {

    private static final Logger log = LoggerFactory.getLogger(StartAop.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop/aopdemo.xml");
        AopDemoClass demoClass = context.getBean(AopDemoClass.class);
        demoClass.m1();
        log.info("{}",demoClass.m2());
        log.info("{}",demoClass.m3());
    }
}
