package com.zyc.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

//标识这是一个切面类
@Aspect
public class AOPClass {

    @Pointcut("execution(* com.zyc.proxy.ImplClass.*(..))")
    public void joinCut() {
    }

    //切入点表达式
    //@Before("execution(public String com.zyc.proxy.ImplClass.getMsg(String))")
//    @Before("execution(* com.zyc.proxy.ImplClass.*(..))")
    // JoinPoint 接口  封装了切入点的方法的信息
    @Before("joinCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("执行之前..");
        System.out.println(joinPoint.getStaticPart());
        System.out.println(joinPoint.toShortString());
        System.out.println(joinPoint.toLongString());
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getSourceLocation());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println(joinPoint.getTarget());
        System.out.println(joinPoint.getThis());
    }
}
