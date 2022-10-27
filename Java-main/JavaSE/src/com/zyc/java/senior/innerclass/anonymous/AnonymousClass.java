package com.zyc.java.senior.innerclass.anonymous;

/**
 * �����ڲ���,������һ��û�����ֵľֲ��ڲ��࣬�����ڷ�����������е�..
 * ���ã����㴴��������󣬾���Ϊ�˼���д
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
				System.out.println("�����ڲ���...");
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
		
		run(() -> System.out.println("��˵�����������."));
		
		
	}
}

abstract class Test {
	abstract void show();
}

interface match{
	void start();
}