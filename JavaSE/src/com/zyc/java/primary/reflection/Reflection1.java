package com.zyc.java.primary.reflection;
/**
 * 反射的应用：动态代理
 * 
 *@author zyc
 *com.zyc.java12
 *JavaSE
 *2022年5月14日下午10:48:43
 */

interface clothFactory{
	void producecloth();
}

//代理类
class Proxy implements clothFactory{
	private clothFactory clothfac;//用被代理类对象进行初始化
	
	public Proxy(clothFactory clothfac) {
		this.clothfac = clothfac;
	}

	@Override
	public void producecloth() {
		System.out.println("代理类初始化");
		clothfac.producecloth();
		System.out.println("代理类做其他事情");
	}
}
//被代理类
class antaCloth implements clothFactory{
	@Override
	public void producecloth() {
		System.out.println("安踏工厂生产鞋子");
	}
}

public class Reflection1 {
	//静态代理举例
	public static void main(String[] args) {
		clothFactory antaCloth = new antaCloth();//创建被代理类对象
		clothFactory proxy = new Proxy(antaCloth);//创建代理类对象
		proxy.producecloth();
	}
}
