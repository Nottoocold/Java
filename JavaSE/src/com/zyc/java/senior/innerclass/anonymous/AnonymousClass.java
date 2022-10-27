package com.zyc.java.senior.innerclass.anonymous;

/**
 * 匿名内部类,本质上一个没有名字的局部内部类，定义在方法、代码块中等..
 * 作用：方便创建子类对象，就是为了简化书写
 * @author zyc
 */
public class AnonymousClass {
	
	public static void run(match m) {
		System.out.println("....");
		m.start();
		System.out.println("....");
	}
	
	public static void main(String[] args) {
		Test test = new Test() {
			
			@Override
			void show() {
				System.out.println("匿名内部类...");
			}
		};
		test.show();
		
//		match m = new match() {
//			
//			@Override
//			public void start() {
//				System.out.println("start.......");
//			}
//		};
//		run(m);
		
		run(new match() {
			
			@Override
			public void start() {
				System.out.println("start.......");
			}
		});
		
		run(() -> System.out.println("别说话，用心体会."));
		
		
	}
}

abstract class Test {
	abstract void show();
}

interface match{
	void start();
}