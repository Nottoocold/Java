package com.zyc.java.primary.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Java反射机制
 * 
 * 通过直接new的方式或反射机制都可以调用公共的属性？应该用哪个？
 * 建议用new的方式
 * 
 * 什么时候用反射？
 * 动态性，当编译时不能确定需要哪个对象时，就可以用反射
 * 
 * 有了反射机制后与前面的封装性是不是矛盾？如何看待这两个技术？
 * 不矛盾。封装性是建议改怎么调用的问题，而反射是解决能不能调的问题。
 * 
 * Class类的理解
 * 反射的源头，
 * 1、程序在经过javac编译后会生成字节码文件(.class)，
 * 然后使用java对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中，
 * 此过程就称作类的加载，加载到内存中的类，就称为运行时类，此运行时类，就作为Class的一个实例。
 * 2、Class的实例就对应着一个运行时类，运行时类会缓存一端时间，在此时间内可以通过不同方式获取此运行时类
 * 3、如何获取Class的实例。方式有4种。
 * （1）Class<T> p = Person.class
 * （2）通过运行时类的对象，Class class1 = p.getClass();
 * （3）调用Class的静态方法，Class.forName(String classpath);类的路径，包+类名。 --->常用
 * （4）使用类的加载器:Classloader,
 * 		Classloader loader = Person.class.getClassLoader();
 * 		Class c = loader.loadClass(String classpath);
 * 
 * @author zyc
 *com.zyc.java12
 *JavaSE
 * 2022年5月13日上午10:24:02
 */
public class Fanshe {
	public static void main(String[] args) throws Exception {
		//反射机制的演示
		//反射机制之前，不能调用类内部的私有成员
//		Person p = new Person("赵永超",20);
//		p.setAge(22);
//		p.show();
//		System.out.println(p.toString());
		
		ClassLoader classLoader = Fanshe.class.getClassLoader();//获取类的加载器,系统类加载器
		System.out.println(classLoader);
		ClassLoader parent = classLoader.getParent();//获取上一层类加载器，扩展类加载器
		System.out.println(parent);
		ClassLoader parent2 = parent.getParent();
		System.out.println(parent2);//null，获取不到引导类加载器
		//反射机制之后
		Class<Person> class1 =  Person.class;
		//调用public或默认属性，方法，构造器
		//通过反射，创建person类的对象
		Constructor<Person> perConstructor = class1.getConstructor(String.class,int.class);//获取指定参数列表的构造器
		Person p1 =  perConstructor.newInstance("赵永超",21);//创建对象
		System.out.println(p1.toString());//调用对象的方法
		//通过反射，调用对象指定的属性和方法
		Field age = class1.getDeclaredField("age");//获取类属性
		age.set(p1, 22);//设置属性
		System.out.println(p1.toString());//调用方法
		
		Method show = class1.getDeclaredMethod("show");//获取类的成员方法
		show.invoke(p1);//调用指定类的方法
		
		System.out.println("----------");
		
		//通过反射，可以调用类内部的私有成员
		Constructor<Person> nameconstructor = class1.getDeclaredConstructor(String.class);//调用私有的构造器
		nameconstructor.setAccessible(true);
		Person p2 = nameconstructor.newInstance("Tom");//造对象
		p2.setAge(20);
		System.out.println(p2);
		
		Field nameField = class1.getDeclaredField("name");//调用私有的成员变量
		nameField.setAccessible(true);
		nameField.set(p2, "Tomcat");//修改私有的成员属性
		System.out.println(p2);
		
		Method shownation = class1.getDeclaredMethod("shownation",String.class);//获取私有的方法
		shownation.setAccessible(true);
		String nation = (String)shownation.invoke(p2, "中国人");//调用私有的方法，invoke()方法的返回值就是当前调用的方法的返回值
		System.out.println(nation);
		
		//若调用类的静态方法，只需在invoke()方法参数中填入当前运行时类的类名,Person.class
	}
}
