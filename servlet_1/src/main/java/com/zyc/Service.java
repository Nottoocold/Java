package com.zyc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/4 下午2:46
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    /**
     * 每个Servlet能完成的业务的注解数组
     * @return 业务名数组
     */
    String[] value() default {};
}
