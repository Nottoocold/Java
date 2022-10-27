package com.zyc.java.primary.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ��̬�������
 *@author zyc
 *com.zyc.java12
 *JavaSE
 *2022��5��14������11:09:32
 */

interface Human{
	public String getBelieve();
	public void eat();
}

//��������
class superMan implements Human{
	@Override
	public void eat() {
		System.out.println("superManϲ����ƻ����");
	}
	
	@Override
	public String getBelieve() {
		return "superMan believe he can fly.";
	}
}

/*
 * Ҫ��ʵ�ֶ�̬������Ҫ��������⣿
 * һ����θ��ݼ��ص��ڴ��еı������࣬����̬�ش���һ�������༰�����
 * ������ͨ��������Ķ�����÷���ʱ����ζ�̬�ĵ��ñ��������е�ͬ������
 * 
 */

class ProxyFactory{
	//Ŀ�ģ�ͨ�����ô˷�������ô�����Ķ���
	public static Object getInstance(Object obj) {//obj�Ǳ�������Ķ���
		/*
		 * ����1��2���������һ������3����������
		 */
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.bind(obj);//
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
		
	}
}

class MyInvocationHandler implements InvocationHandler{
	private Object obj;//��ֵʱ��Ҳ��Ҫ�ñ�������Ķ����ʼ��
	
	public void bind(Object obj) {
		this.obj = obj;
	}
	
	//��ͨ��������Ķ�����÷���aʱ���ͻ��Զ��ĵ��������invoke����
	//����������Ҫִ�еķ���a�Ĺ���������invoke������
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//����1,������Ķ��󣻲���2������Ķ���Ҫ���õķ������˷���Ҳ����Ϊ�˱����������Ҫ���õķ���
		
		Object returnValue = method.invoke(obj, args);//obj��������Ķ���
		return returnValue;//�������෽���ķ���ֵ
	}
}

public class Reflection2 {
	public static void main(String[] args) {
		superMan superMan = new superMan();
		//ͨ��������������ô��������
		Human proxyinstance = (Human)ProxyFactory.getInstance(superMan);
		System.out.println(proxyinstance.getBelieve());
		proxyinstance.eat();
		
	}
}
