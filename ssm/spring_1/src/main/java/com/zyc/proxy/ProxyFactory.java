package com.zyc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * jdk动态代理
     * cglib动态代理
     *
     * @return 代理对象
     */
    public Object getProxyInstance() {
        /** jdk动态代理
         * ClassLoader loader,
         * Class<?>[] interfaces,
         * InvocationHandler h,如何实现代理类中的方法
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler handler = (proxy, method, args) -> {
            System.out.println("代理对象的名称是" + proxy.getClass().getName());
            System.out.println("开始执行之前,执行的方法名是" + method.getName());
            System.out.println("执行的方法参数数组为" + Arrays.toString(args));
            System.out.println("被代理的对象是" + target);
            Object ret = method.invoke(target, args);
            System.out.println("代理对象执行代理目标的方法结束，返回值已经返回.");
            return ret;
        };
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
