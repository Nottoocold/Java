package com.zyc.java.senior.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@MyCustom
public class First {
	/**
	 * 注解可以被标注在任意地方，包括方法上、类名上、参数上、成员属性上、注解定义上等，就像注释一样，它相当于我们对某样东西的一个标记。
	 * 而与注释不同的是，注解可以通过反射在运行时获取，注解也可以选择是否保留到运行时。
	 * 
	 * Java预设注解：
	 * 	- @Override - 检查（仅仅是检查，不保留到运行时）该方法是否是重写方法。如果发现其父类，或者是引用的接口中并没有该方法时，会报编译错误。
		- @Deprecated - 标记过时方法。如果使用该方法，会报编译警告。
		- @SuppressWarnings - 指示编译器去忽略注解中声明的警告（仅仅编译器阶段，不保留到运行时）
		- @FunctionalInterface - Java 8 开始支持，标识一个匿名函数或函数式接口。
		- @SafeVarargs - Java 7 开始支持，忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告。
	 *
	 *元注解：元注解是作用于注解上的注解，用于我们编写自定义的注解
	 *	- @Retention - 标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问。
		- @Documented - 标记这些注解是否包含在用户文档中。
		- @Target - 标记这个注解应该是哪种 Java 成员。
		- @Inherited - 标记这个注解是继承于哪个注解类(默认 注解并没有继承于任何子类)
		- @Repeatable - Java 8 开始支持，标识某注解可以在同一个声明上使用多次。
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 *
	 */
	/*
	 *	@Override 注解的定义。
	 *  @Target(ElementType.METHOD)
		@Retention(RetentionPolicy.SOURCE)
		public @interface Override {
			}
		ElementType是枚举类，含有指明注解可以作用的目标
		RetentionPolicy是枚举类，指明了注解的生命周期  SOURCE CLASS RUNTIME
		
	 */
	
	@MyCustom("aaa")
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName("com.zyc.java.senior.annotation.Student");
		Annotation[] annotations = clazz.getAnnotations();
		for(Annotation a: annotations) {
			System.out.println(a.annotationType());   //获取类型
	        System.out.println(a instanceof MyCustom);   //直接判断是否为MyCustom
	        MyCustom my = (MyCustom) a;
	        System.out.println(Arrays.toString(my.value()));
		}
		
		Class<?> c = First.class;
		Annotation[] annotations2 = c.getAnnotations();
		for(Annotation a1 : annotations2) {
			System.out.println(Arrays.toString(((MyCustom)a1).value()));
		}
		
		//获取方法的注解
		Annotation[] annotations3 = clazz.getMethod("name").getAnnotations();
		for(Annotation mAnnotation : annotations3) {
			System.out.println(mAnnotation.annotationType());
			System.out.println(mAnnotation instanceof MyCustom);
			System.out.println(Arrays.toString(((MyCustom)mAnnotation).value()));
		}
	}
}
