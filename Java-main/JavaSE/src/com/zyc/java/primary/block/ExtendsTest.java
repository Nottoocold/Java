package com.zyc.java.primary.block;

/**
 * 多态是一种行为特征
 * 多态中成员访问特点:
 * 	1.方法： 编译看左边，运行看右边
 * 	2.变量： 编译看左边，运行也看左边	(侧重行为多态)
 * @author zyc
 *
 */
public class ExtendsTest {

	public static void main(String[] args) {
		A a = new B(12);//多态
		a.test();//test方法的是共有的方法，调用子类的
		//a.name();//子类特有的功能，不可以使用
		a.a();//可以直接使用父类中特有的方法
		B b = (B)a;
		b.name();
		System.out.println(a.toString());
	}
}

class A {
	int a;
	int b;
	
	public A() {
		System.out.println("A Construct..");
	}
	
	public A(int b) {
		a = 20;
		this.b = b;
	}
	
	public void a() {
		System.out.println("A 特有...");
	}
	
	void test() {
		System.out.println("A test method...");
	}

	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}
}

class B extends A{
	
	public B() {
		System.out.println("B Construct..");
	}
	
	public B(int b){
		super(b);
	}
	
	void test() {
		System.out.println("B test method...");
	}

	void name() {
		System.out.println("B 特有...");
	}

	@Override
	public String toString() {
		return "B 中 A 的成员 [a=" + a + ", b=" + b + "]";
	}
	
}