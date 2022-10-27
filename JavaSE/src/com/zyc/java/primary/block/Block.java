package com.zyc.java.primary.block;

/**
 * 类的成员---代码块 ----作用： 
 * 1、用来初始化类、对象 
 * 2、只能使用static 或者 默认
 * 
 * 3、静态代码块：内部可以有输出语句；随着类的加载而执行，且只执行一次 ----作用：初始化类的属性
 * 4、非静态代码块：内部可以有输出语句；随着对象的创建而执行，每创建一个对象就执行一次 ----作用：可以在创建对象时，对实例的属性进行初始化
 * 
 * @author Kidz
 *
 */

public class Block {
	public static void main(String[] args) {
//		String string = Person.descString;
		Person person = new Person();
		Person preson1 = new Person();
		person.info();
		preson1.info();
		System.out.println(person.toString());
		System.out.println(preson1.toString());

	}
}

class Person {
	private String name;
	private int age;
	static String descString;

	// 构造器
	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 非静态代码块
	{
		this.setName("zyc");
		this.setAge(21);
	}

	static // 静态代码块
	{
		descString = "I am happy.";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 方法
	public void eat() {
		System.out.println("干饭");
	}

	public void info() {
		System.out.println(descString);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}