package com.zyc.java.senior.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallMethod {
	/**
	 * ʹ��Class�����ȡ���ʵ�����󣬵��÷���,
	 * 
	 * ����ǳ�ǿ�������������ᵽ��ԽȨ���ʣ�������һ������ʹ�ã����˽�ĳ����������Ϊprivateһ�����������ɣ�
	 * ���ʵ������Ҫʹ�ñ��˶���Ϊprivate�ķ������ͱ���ȷ���������ǰ�ȫ�ģ���û���˽���˴�����������̾�ǿ��ԽȨ���ʣ����ܻ�����޷�Ԥ֪�Ĵ��� 
	 * 
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		/*
		 * ͨ������`getMethod()`���������ǿ��Ի�ȡ��������������Ϊpublic�ķ���(��public������ͨ��getDeclaredMethod()��ȡ��ͬ���޸ķ���Ȩ��)���õ�һ��Method����
		 * ���ǿ���ͨ��Method�����`invoke()`����������ֵ���Ƿ����ķ���ֵ����Ϊ������void������ֵΪnull���������Ѿ���ȡ���ķ�����ע�⴫�Ρ�
		 */
		Class<?> clazz = Class.forName("com.zyc.java.senior.reflection.po.Computer");
		Object instance = clazz.newInstance();
		Method m1 = clazz.getMethod("start");
		Method m2 = clazz.getMethod("shut");
		m1.invoke(instance);
		m2.invoke(instance);
		System.out.println(m1.getName());
		System.out.println(m1.getReturnType());
		
		
		
		
	}

}
