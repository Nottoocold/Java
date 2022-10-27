package com.zyc.java.senior.reflection;

import com.zyc.java.senior.reflection.po.Computer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class newInstance {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, 
														NoSuchMethodException, SecurityException, 
														IllegalArgumentException, InvocationTargetException {
		/**
		 * 使用Class对象来创建对象
		 */
		Class<Computer> clazz = Computer.class;
		/*
		 * 当类默认的构造方法被带参构造覆盖时,抛出InstantiationException异常
		 * 当默认无参构造器被私有化时，抛出IllegalAccessException异常
		 */
		//创建对象
		/*Computer computer = clazz.newInstance();
		computer.start();
		computer.shut();*/
		
		//上述方式不推荐，而是以下方式
		Constructor<Computer> constructor = clazz.getConstructor(String.class, Double.class);
		Computer computer = constructor.newInstance("MSI",5500.0);
		computer.start();
		computer.shut();
		System.out.println(computer.toString());
		
		/**
		 * 当构造方法访问权限不足时，使用`getDeclaredConstructor()`方法可以找到类中的非public构造方法，
		 * 但是在使用之前，我们需要先修改访问权限，在修改访问权限之后，就可以使用非public方法了（这意味着，反射可以无视权限修饰符访问类的内容）
		 */
		
	}

}
