package com.zyc.java.senior.generic;

public interface MyInterface<T> {
	/**
	 * �����ڶ�̬�����Ͳ������������ࡢ��Ա�������ϣ����������ڽӿ��ϡ�
	 */
	void speak(T info);
	T getInfo();
}
