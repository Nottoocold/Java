package com.zyc.java.senior.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class CallFiles {
	/**
	 * 修改类的属性
	 * 
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		Class<?> clazz = Class.forName("com.zyc.java.senior.reflection.po.Computer");
		Constructor<?> constructor = clazz.getConstructor(String.class, Double.class);
		Object computer = constructor.newInstance("MSI", 6899.0);
		System.out.println(computer.toString());
		/*
		 * 我们还可以通过反射访问一个类中定义的成员字段也可以修改一个类的对象中的成员字段值，通过`getField()`方法来获取一个类定义的指定字段：
		 */
		Field[] fields = clazz.getDeclaredFields();
		for(Field f: fields) {
			f.setAccessible(true);
			if (f.getType() == String.class) {
				f.set(computer,"MAC BOOK");				
			}
			if (f.getType() == Double.class) {
				f.set(computer, 12333.0);
			}
		}
		System.out.println(computer.toString());
		
		/*
		 * 反射几乎可以把一个类的老底都给扒出来，任何属性，任何内容，都可以被反射修改，无论权限修饰符是什么，那么，如果我的字段被标记为final呢？
		 * 这时，当字段为final时，就修改失败了！当然，通过反射可以直接将final修饰符直接去除，去除后，就可以随意修改内容了
		 */
		Integer i = 10;//private final int value = 10; [-128,127]

	    Field field = Integer.class.getDeclaredField("value");

	    Field modifiersField = Field.class.getDeclaredField("modifiers");  //这里要获取Field类的modifiers字段进行修改
	    modifiersField.setAccessible(true);
	    modifiersField.setInt(field,field.getModifiers()&~Modifier.FINAL);  //去除final标记

	    field.setAccessible(true);
	    field.set(i, 100);   //强行设置值 cache[138] = 100;

	    System.out.println(i);
		
	    /*
	     * 修改其他类型
	     */
		List<String> list = new ArrayList<String>();
		Field listField = ArrayList.class.getDeclaredField("size");
		listField.setAccessible(true);
		listField.set(list, 10);//return cache[138];
		list.add("wow");
		System.out.println(list.size());//101
	}
}
