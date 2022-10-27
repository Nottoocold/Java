package com.zyc.java.senior.generic;

public interface MyInterface<T> {
	/**
	 * 泛型于多态，泛型不仅可以用在类、成员，方法上，还可以用在接口上。
	 */
	void speak(T info);
	T getInfo();
}
