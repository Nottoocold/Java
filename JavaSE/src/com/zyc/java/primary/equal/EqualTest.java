package com.zyc.java.primary.equal;

public class EqualTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// equal����
		String s1 = new String("hhh");
		String s2 = new String("hhh");
		EqualTest e1 = new EqualTest();
		EqualTest e2 = new EqualTest();
		System.out.println(s1.equals(s2));//��д��object���еķ�����Ҳ�����˶�̬��
		System.out.println(e1.equals(e2));//����object���еķ���
	}

}
