package com.zyc.java.senior.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class CallFiles {
	/**
	 * �޸��������
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
		 * ���ǻ�����ͨ���������һ�����ж���ĳ�Ա�ֶ�Ҳ�����޸�һ����Ķ����еĳ�Ա�ֶ�ֵ��ͨ��`getField()`��������ȡһ���ඨ���ָ���ֶΣ�
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
		 * ���伸�����԰�һ������ϵ׶����ǳ������κ����ԣ��κ����ݣ������Ա������޸ģ�����Ȩ�����η���ʲô����ô������ҵ��ֶα����Ϊfinal�أ�
		 * ��ʱ�����ֶ�Ϊfinalʱ�����޸�ʧ���ˣ���Ȼ��ͨ���������ֱ�ӽ�final���η�ֱ��ȥ����ȥ���󣬾Ϳ��������޸�������
		 */
		Integer i = 10;//private final int value = 10; [-128,127]

	    Field field = Integer.class.getDeclaredField("value");

	    Field modifiersField = Field.class.getDeclaredField("modifiers");  //����Ҫ��ȡField���modifiers�ֶν����޸�
	    modifiersField.setAccessible(true);
	    modifiersField.setInt(field,field.getModifiers()&~Modifier.FINAL);  //ȥ��final���

	    field.setAccessible(true);
	    field.set(i, 100);   //ǿ������ֵ cache[138] = 100;

	    System.out.println(i);
		
	    /*
	     * �޸���������
	     */
		List<String> list = new ArrayList<String>();
		Field listField = ArrayList.class.getDeclaredField("size");
		listField.setAccessible(true);
		listField.set(list, 10);//return cache[138];
		list.add("wow");
		System.out.println(list.size());//101
	}
}
