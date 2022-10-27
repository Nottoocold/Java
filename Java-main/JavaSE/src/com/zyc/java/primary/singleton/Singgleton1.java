package com.zyc.java.primary.singleton;

//懒汉式实现
public class Singgleton1 {
	public static void main(String[] args) {
		Order order1 = Order.getInstacne();
		Order order2 = Order.getInstacne();
		System.out.println(order1);
		System.out.println(order2);

	}
}

class Order {
	// 声明类的实例
	private static Order instance = null;

	private Order() {
	}

	// 公共的方法返回类的对象
	public static Order getInstacne() {
		if (instance == null) {
			synchronized (Order.class) {
				if (instance == null) {// 考虑线程的安全性，需要进行同步机制
					instance = new Order();
				}
			}
		}
		return instance;
	}
}
