package com.zyc.java.senior.generic;

public class GenericMethodTest {
	/**
	 * �Զ��巺�ͷ�����
	 * ����ھ�̬������ʹ�÷��ͣ�֮ǰ�ķ����Ƕ��������ϵģ�ֻ����ʵ������ʱ�ſ���ȷ�����ͣ�
	 * ���Ǿ�̬��������Ҫ�����ڶ�����ôֻ����ʹ��ʱ��ȷ���ˣ����Ծ�̬��������ʹ�÷��ͣ�������Ҫ�������壬������ʾ
	 */
	public static <E> void method(E e) {//�ڷ�������ǰ��������
		System.out.println("��̬��Ա���� " + e);
	}
	
	public <E> void menthod1(E e) {
		System.out.println("��Ա���� " + e);
	}
	
	public static void main(String[] args) {
		GenericMethodTest.method(1000);
		GenericMethodTest.method("String");
		new GenericMethodTest().menthod1(1000);
	}
}
