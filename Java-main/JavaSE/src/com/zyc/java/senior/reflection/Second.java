package com.zyc.java.senior.reflection;

public class Second {
	/**
	 * Class对象，当类加载完成后，就会提取此类的所有信息在内存中生成一个Class对象，此Class对象与被加载的类唯一对应，且只有一个
	 * 
	 * 获取Class对象的方式有如下三种
	 */
	public static void main(String[] args) {
		//1.通过class关键字
		Class<Integer> iClass =  Integer.class;
		System.out.println(iClass);
		
		//2.使用Class类静态方法forName()
		try {
			Class<?> name = Class.forName("com.zyc.java.senior.reflection.First");
			System.out.println(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//3.通过实例对象获得
		System.out.println(new Integer(12).getClass());
		
		//一个类只有唯一一个Class对象
		System.out.println(iClass == (new Integer("123").getClass()));//true
		
		//public static final Class<Integer>  TYPE = (Class<Integer>) Class.getPrimitiveClass("int");
		//上述方法获取的是原始数据类型，典型的就是包装类
		System.out.println(int.class);//int
		System.out.println(Integer.TYPE);//原始数据类型，int 
		System.out.println(Integer.class);//包装类型，class java.lang.Integer
		
		System.out.println(Integer.TYPE == int.class);//true
		System.out.println(Integer.TYPE == Integer.class);//false
		
		System.out.println("-------------------");
		//数组也是一种类型
		Class<String[]> clazz = String[].class;
	    System.out.println(clazz.getName());  //获取类名称（得到的是包名+类名的完整名称）
	    System.out.println(clazz.getSimpleName());
	    System.out.println(clazz.getTypeName());
	    System.out.println(clazz.getClassLoader());   //获取它的类加载器
	    System.out.println(clazz.cast(new Integer("10")));   //强制类型转换 ClassCastException
	}
}
