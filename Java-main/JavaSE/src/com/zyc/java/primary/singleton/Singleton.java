package com.zyc.java.primary.singleton;

/**
 * 单例设计模式的两种方式
 * 
 * @author Kidz
 *
 */

// 饿汉式实现
public class Singleton {
	public static void main(String[] args) {
		Bank bank1 = Bank.Instance();
		Bank bank2 = Bank.Instance();
		System.out.println(bank1 == bank2);
	}

	static class Bank {
		// 单例设计模式，即只允许一个类有一个实例
		// 属性1，属性2，属性3....
		private static final Bank instance;

		// 1、私有化构造器
		private Bank() {

		}

		static {
			// 2、内部创建类的对象
			instance = new Bank();
		}

		// 3、提供公共的方法，返回类的实例
		public static Bank Instance() {
			return instance;
		}
	}

}