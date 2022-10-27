package org.springframework.stu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stu.config.SpringConfig;
import org.springframework.stu.dao.UserDao;
import org.springframework.stu.service.UserService;

import java.util.Arrays;

/**
 * @author zyc
 * @date 2022/10/24
 */
public class Spring {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserService userService = context.getBean(UserService.class);

        userService.listUser().forEach(System.out::println);

        UserDao userDao = context.getBean(UserDao.class);

        System.out.println(userDao);


        /*Arrays.stream(context.getBeanDefinitionNames()).iterator().forEachRemaining(System.out::println);

        AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) autowireCapableBeanFactory;

        Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();

        List<BeanDefinition> beanDefinitions = new ArrayList<>();

        while (beanNamesIterator.hasNext()) {
            try {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanNamesIterator.next());
                beanDefinitions.add(beanDefinition);
            } catch (NoSuchBeanDefinitionException e) {
                System.out.println(e.getMessage());
            }
        }

        beanDefinitions.forEach(System.out::println);*/

    }

    public static void annotationApp() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.registerShutdownHook();

        context.register(SpringConfig.class);

        context.refresh();

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(s -> System.out.println("beanName:" + s));

        UserService userService = context.getBean(UserService.class);

        userService.listUser().forEach(System.out::println);

        context.close();
    }
}
