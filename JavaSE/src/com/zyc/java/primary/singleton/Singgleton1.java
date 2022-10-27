package com.zyc.java.primary.singleton;

//����ʽʵ��
public class Singgleton1 {
	public static void main(String[] args) {
		Order order1 = Order.getInstacne();
		Order order2 = Order.getInstacne();
		System.out.println(order1);
		System.out.println(order2);

	}
}

class Order {
	// �������ʵ��
	private static Order instance = null;

	private Order() {
	}

	// �����ķ���������Ķ���
	public static Order getInstacne() {
		if (instance == null) {
			synchronized (Order.class) {
				if (instance == null) {// �����̵߳İ�ȫ�ԣ���Ҫ����ͬ������
					instance = new Order();
				}
			}
		}
		return instance;
	}
}
