package com.zyc.java.senior.generic;

/**
 * �����ڶ�̬�����Ͳ������������ࡢ��Ա�������ϣ����������ڽӿ��ϡ�
 */
public class GenericDepthTest2 {
	public static void main(String[] args) {
		Person<String> person1 = new Person<>("��ʼ��...");
		System.out.println(person1.getInfo());
	}
}


//��ʵ�ִ˽ӿ�ʱ�����ǿ���ѡ����ʵ������ȷ�������ͻ��Ǽ���ʹ�ô˷��ͣ��þ��崴���Ķ�����ȷ�����͡�����һ������ʵ�ֽӿ�ʱ��ָ������
class Person<T> implements MyInterface<T> {//��Scoreת��Ϊ������<T>
	/*
	 * ������T��������Object����
	 */
	
	T info;
	
	public Person(T info) {
		this.info = info;
	}
	@Override
	public void speak(T customInfo) {
		System.out.println("�Զ��� " + customInfo);
	}

	@Override
	public T getInfo() {
		return info;
	}
	
}

//ֱ����ʵ�ֽӿ�ʱ��ָ������
class Person1 implements MyInterface<String> {
	/*
	 * �����������ķ���ֵ�����Լ��������;��븸���ӿ��в�ͬ��Ϊʲô��������д����������
	 * ͨ�����������������������������ǰ����Ǵ�������������д������ӿ��еķ�����������ʾ
	 * public void speak(Object info){
	 * 		this.speak((String)info);//�����Լ���д���Ǹ�speak
	 * }
	 * public Object getInfo(){
	 * 		return this.getInfo();//�����Լ���д���Ǹ�getInfo
	 * }
	 * ���Ͽ����������ǲ��Ǻܴ�����
	 */
	
	@Override
	public void speak(String info) {
		System.out.println("ֱ��ָ�� " + info);
	}

	@Override
	public String getInfo() {
		return "ֱ��ָ������";
	}
	
}