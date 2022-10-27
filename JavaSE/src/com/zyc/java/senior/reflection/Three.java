package com.zyc.java.senior.reflection;

import java.lang.reflect.Type;

public class Three {
	/**
	 * instanceof 关键字，判断实例或类是否是同一个类型
	 */
	public static void main(String[] args) {
		//
		String string = new String("12");
		System.out.println(string instanceof java.lang.String);
		System.out.println(string.getClass() == String.class);
		
		//判读是否是子类或接口，抽象类的实现类
		Integer a = 1;
		System.out.println(a.getClass().asSubclass(Number.class));//class java.lang.Integer
		
		//获取父类的Class对象
		System.out.println(a.getClass().getSuperclass());//class java.lang.Number
		
		//获取父类的原始类型的Type
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
		 * 获取父接口
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
