package org.spring.stu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author zyc
 * @date 2022/10/24
 */
@Aspect
public class LogAop {
    private static final Logger log = LoggerFactory.getLogger(LogAop.class);

    @Around("execution(* org.spring.stu.service.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("execute {}", method);
        return joinPoint.proceed();
    }
}
