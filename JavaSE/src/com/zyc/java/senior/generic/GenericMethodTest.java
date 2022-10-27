package com.zyc.java.senior.generic;

public class GenericMethodTest {
	/**
	 * 自定义泛型方法。
	 * 如何在静态方法中使用泛型？之前的泛型是定义在类上的，只有在实例化类时才可以确定泛型，
	 * 但是静态方法不需要依赖于对象，那么只能在使用时来确定了，所以静态方法可以使用泛型，但是需要单独定义，如下所示
	 */
	public static <E> void method(E e) {//在方法定义前声明泛型
		System.out.println("静态成员方法 " + e);
	}
	
	public <E> void menthod1(E e) {
		System.out.println("成员方法 " + e);
	}
	
	public static void main(String[] args) {
		GenericMethodTest.method(1000);
		GenericMethodTest.method("String");
		new GenericMethodTest().menthod1(1000);
	}
}
