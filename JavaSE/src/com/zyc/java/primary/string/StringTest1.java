package com.zyc.java.primary.string;

/*
 * String�ַ�������Ĵ��������в���API
 * 
 */
public class StringTest1 {
	public static void main(String[] args) {
//		String s1="JavaEE";//���ַ�����������
//		String s2=new String("JavaEE");
//		String s3=new String("JavaEE");
//		System.out.println(s1==s2);//false
//		System.out.println(s2==s3);//false

		String s1 = "java";
		String s2 = "zyc";

		String s3 = "javazyc";
		String s4 = "java" + "zyc";

		String s5 = "java" + s2;
		String s6 = s1 + "zyc";

		String s7 = s1 + s2;

		String s8 = s5.intern();

		/*
		 * �����볣����ƴ�ӽ���ڳ����� 
		 * ֻҪ������һ����������������ڶ��� 
		 * ���ƴ�ӵĽ������intern()�������򷵻صĽ���ڳ�������
		 */
		System.out.println(s3 == s4);// true
		System.out.println(s3 == s5);// false
		System.out.println(s3 == s6);// false
		System.out.println(s3 == s7);// false
		System.out.println(s5 == s6);// false
		System.out.println(s5 == s7);// false
		System.out.println(s6 == s7);// false

		System.out.println(s3 == s8);//true
	}
}
