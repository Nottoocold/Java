package org.springframework.stu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zyc
 * @date 2022/10/24
 */
@Aspect
@Component
public class LogAop {
    private static final Logger log = Logger.getLogger(LogAop.class.getName());

    @Around("execution(* org.springframework.stu.service.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.log(Level.INFO, "execute:" + method.getName());
        return joinPoint.proceed();
    }
}
