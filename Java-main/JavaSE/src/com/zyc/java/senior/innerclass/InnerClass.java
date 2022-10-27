package com.zyc.java.senior.innerclass;

public class InnerClass {
	static String name = "外部类的静态成员";
	String string = "外部类的实例成员";
	int a = 14;
	/**
	 * 静态内部类
	 * 使用方式 		外部类名.内部类名 变量名 = new 外部类.内部类名();
	 * 1.静态内部类可以直接访问外部类的静态成员
	 * 2.静态内部类不可以直接访问外部类的实例成员
	 * @author zyc
	 */
	static class staticClass {
		String in = InnerClass.name;//
		String self = "静态内部类自己的成员";
		public staticClass() {
			System.out.println("我是静态内部类");
			//System.out.println(new InnerClass().string);
			System.out.println(self);
		}
		
	}
	
	/**
	 * 成员内部类,是作为外部类的成员，不能用static修饰
	 * 使用方式：		外部类名.内部类名  变量名 = new 外部类名().new 内部类名();
	 * 1.成员内部类可以直接访问外部类的静态成员
	 * 2.成员内部类可以访问外部类的实例成员
	 * @author zyc
	 */
	public class fileClass {
		int a  = 13;
		public fileClass() {
			System.out.println("我是成员内部类");
		}
		
		void show() {
			System.out.println("访问外部类静态成员：" + name);
			System.out.println("访问外部类实例成员：" + string);
		}
		
		void test() {
			int a = 12;
			System.out.println(a);//局部变量a 12
			System.out.println(this.a);//成员内部类成员a 13 
			System.out.println(InnerClass.this.a);//外部类成员 14
		}
	}
}
