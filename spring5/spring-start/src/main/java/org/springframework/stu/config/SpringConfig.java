package org.springframework.stu.config;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author zyc
 * @date 2022/10/24
 */
@Configuration(proxyBeanMethods = false)
public class SpringConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(org.apache.ibatis.session.Configuration configuration) {
        SqlSessionFactory factory;
        factory = new SqlSessionFactoryBuilder().build(configuration);
        return factory;
    }

    @Bean
    public org.apache.ibatis.session.Configuration configuration() {
        XMLConfigBuilder xmlConfigBuilder;
        try {
            xmlConfigBuilder = new XMLConfigBuilder(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return xmlConfigBuilder.parse();
    }
}
