package com.zyc.ss.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyc
 */
@Configuration
@MapperScan(basePackages = "com.zyc.ss.mapper")
public class WebConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor
                .setDbType(DbType.MYSQL);
        return paginationInterceptor;
    }

}
