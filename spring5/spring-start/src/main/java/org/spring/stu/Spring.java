package org.spring.stu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.spring.stu.service.UserService;

/**
 * @author zyc
 * @date 2022/10/24
 */
public class Spring {
    private static final Logger log = LoggerFactory.getLogger(Spring.class);
    private static final String pre = "classpath:";

    public static void main(String[] args) {
        String[] path = {pre + "applicationContext.xml", pre + "aop.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        UserService service = (UserService) context.getBean("userService");
        log.info("{}", service.listUser());
    }

}
