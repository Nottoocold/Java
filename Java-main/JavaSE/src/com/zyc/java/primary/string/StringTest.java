package com.zyc.java.primary.string;

/*
 * String �� , ���ǻ����������ͣ�final���ε���
 * String����Ϊfinal����final  char����洢�������ǳ���
 * �ַ��������ز���洢��ͬ������
 */

public class StringTest {
	public static void main(String[] args) {
		String s1="zyc";//������
		String s2="zyc";
		s1="abc";//����newһ������
		System.out.println(s1==s2);//true||false
		String s3="wsad";
		String s4= s3.replace('w', 'q');
		System.out.println(s3);//wsad
		System.out.println(s4);//qsad
	}
}
