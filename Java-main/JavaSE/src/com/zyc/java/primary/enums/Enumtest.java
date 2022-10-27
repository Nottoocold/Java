package com.zyc.java.primary.enums;

/*
 * ö������Ҫ������
 * values()����ö�����͵Ķ������飬�����������ö��ֵ
 * valueOf(String str)���԰�һ���ַ���תΪ��Ӧ��ö�������Ҫ���ַ���������ö�����������֡��粻������׳��쳣
 * toString()���ص�ǰö������������
 * 
 */
public class Enumtest {
	public static void main(String[] args) {
		for (int i = 0; i < Sea.values().length; i++) {
			System.out.println(Sea.values()[i]);
		}
		System.out.println();
	}
}

enum Sea{
	a("̫ƽ��"),
	b("ӡ����"),
	c("������");
	
	private final String name;
	
	private Sea(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
}