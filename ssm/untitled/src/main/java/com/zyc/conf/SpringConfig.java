package com.zyc.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.zyc.service"})
@PropertySource("classpath:jdbc.properties")
@Import({JDBConfig.class, MybatisConfig.class}) // 整合jdbc和mybatis配置类
@EnableTransactionManagement // 开启注解驱动事务
public class SpringConfig {

}
