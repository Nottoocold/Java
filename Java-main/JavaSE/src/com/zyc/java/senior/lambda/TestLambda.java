package com.zyc.java.senior.lambda;

public class TestLambda {
	
	public static void Lambda(This m) {
		System.out.println("Lambda表达式......");
		m.Mymethod();
		System.out.println("Lambda表达式。。。。");
	}
	
	public static void main(String[] args) {
		/**
		 * lambda 表达式为了简化代码书写，用法格式：
		 * 					(匿名内部类被重写方法的形参列表) -> {被重写方法的方法体}
		 * 注意：lambda表达式只能简化函数式接口的匿名内部类的写法形式
		 */
		//通常情况
		This m = new This() {
			
			@Override
			public void Mymethod() {
				System.out.println("通常情况");
			}
		};
		Lambda(m);
		
		System.out.println();
		
		//进一步简化
		This m1 = ()->{
			System.out.println("进一步简化");
		};
		Lambda(m1);
		
		System.out.println();
		
		//直接作为入参
		Lambda(new This() {
			@Override
			public void Mymethod() {
				System.out.println("直接作为方法的入参");
			}
		});
		
		System.out.println();
		
		//最终版本
		Lambda(()->{
			System.out.println("最终简化的形式");
		});
	}
}

@FunctionalInterface //使用此注解则接口必须是函数式接口
interface This{
	void Mymethod();
}