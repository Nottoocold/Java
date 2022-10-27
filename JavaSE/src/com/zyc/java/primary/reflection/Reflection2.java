package com.zyc.java.primary.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *@author zyc
 *com.zyc.java12
 *JavaSE
 *2022年5月14日下午11:09:32
 */

interface Human{
	public String getBelieve();
	public void eat();
}

//被代理类
class superMan implements Human{
	@Override
	public void eat() {
		System.out.println("superMan喜欢吃苹果。");
	}
	
	@Override
	public String getBelieve() {
		return "superMan believe he can fly.";
	}
}

/*
 * 要想实现动态代理，需要解决的问题？
 * 一、如何根据加载到内存中的被代理类，来动态地创建一个代理类及其对象
 * 二、当通过代理类的对象调用方法时，如何动态的调用被代理类中的同名方法
 * 
 */

class ProxyFactory{
	//目的：通过调用此方法，获得代理类的对象
	public static Object getInstance(Object obj) {//obj是被代理类的对象
		/*
		 * 参数1、2解决了问题一，参数3解决了问题二
		 */
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.bind(obj);//
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
		
	}
}

class MyInvocationHandler implements InvocationHandler{
	private Object obj;//赋值时，也需要用被代理类的对象初始化
	
	public void bind(Object obj) {
		this.obj = obj;
	}
	
	//当通过代理类的对象调用方法a时，就会自动的调用下面的invoke方法
	//将被代理类要执行的方法a的功能声明在invoke方法中
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//参数1,代理类的对象；参数2代理类的对象要调用的方法，此方法也就作为了被代理类对象要调用的方法
		
		Object returnValue = method.invoke(obj, args);//obj被代理类的对象，
		return returnValue;//被代理类方法的返回值
	}
}

public class Reflection2 {
	public static void main(String[] args) {
		superMan superMan = new superMan();
		//通过被代理类对象获得代理类对象
		Human proxyinstance = (Human)ProxyFactory.getInstance(superMan);
		System.out.println(proxyinstance.getBelieve());
		proxyinstance.eat();
		
	}
}
