package com.zyc.java.senior.reflection;

import java.lang.reflect.Type;

public class Three {
	/**
	 * instanceof �ؼ��֣��ж�ʵ�������Ƿ���ͬһ������
	 */
	public static void main(String[] args) {
		//
		String string = new String("12");
		System.out.println(string instanceof java.lang.String);
		System.out.println(string.getClass() == String.class);
		
		//�ж��Ƿ��������ӿڣ��������ʵ����
		Integer a = 1;
		System.out.println(a.getClass().asSubclass(Number.class));//class java.lang.Integer
		
		//��ȡ�����Class����
		System.out.println(a.getClass().getSuperclass());//class java.lang.Number
		
		//��ȡ�����ԭʼ���͵�Type
		Type genericSuperclass = a.getClass().getGenericSuperclass();
		System.out.println(genericSuperclass);//class java.lang.Number
		/*
		 * public final class Class<T> implements java.io.Serializable,
                              GenericDeclaration,
                              Type,
                              AnnotatedElement
		 */
		System.out.println(genericSuperclass instanceof Class);//true
		
		/*
		 * ��ȡ���ӿ�
		 */
		Integer i = 10;
	    for (Class<?> anInterface : i.getClass().getInterfaces()) {
	        System.out.println(anInterface.getName());
	    }
	  
	  	for (Type genericInterface : i.getClass().getGenericInterfaces()) {
	        System.out.println(genericInterface.getTypeName());
	    }
	  	
	}
}
