package com.zyc.java.primary.string;

/*
 * String字符串对象的创建，自行查阅API
 * 
 */
public class StringTest1 {
	public static void main(String[] args) {
//		String s1="JavaEE";//在字符串常量池中
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
		 * 常量与常量的拼接结果在常量池 
		 * 只要其中有一个变量，结果就是在堆中 
		 * 如果拼接的结果调用intern()方法，则返回的结果在常量池中
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
