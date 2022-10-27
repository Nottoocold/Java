package com.zyc.java.senior.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallMethod {
	/**
	 * 使用Class对象获取类的实例对象，调用方法,
	 * 
	 * 反射非常强大，尤其是我们提到的越权访问，但是请一定谨慎使用，别人将某个方法设置为private一定有他的理由，
	 * 如果实在是需要使用别人定义为private的方法，就必须确保这样做是安全的，在没有了解别人代码的整个过程就强行越权访问，可能会出现无法预知的错误。 
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
		 * 通过调用`getMethod()`方法，我们可以获取到类中所有声明为public的方法(非public方法可通过getDeclaredMethod()获取，同事修改访问权限)，得到一个Method对象，
		 * 我们可以通过Method对象的`invoke()`方法（返回值就是方法的返回值，因为这里是void，返回值为null）来调用已经获取到的方法，注意传参。
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
