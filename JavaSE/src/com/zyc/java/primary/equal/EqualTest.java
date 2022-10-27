package com.zyc.java.primary.equal;

public class EqualTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// equal方法
		String s1 = new String("hhh");
		String s2 = new String("hhh");
		EqualTest e1 = new EqualTest();
		EqualTest e2 = new EqualTest();
		System.out.println(s1.equals(s2));//重写了object类中的方法，也体现了多态性
		System.out.println(e1.equals(e2));//调用object类中的方法
	}

}
