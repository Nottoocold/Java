package com.zyc.java.primary.string;

/*
 * String 类 , 不是基本数据类型，final修饰的类
 * String声明为final，用final  char数组存储，代表是常量
 * 字符串常量池不会存储相同的内容
 */

public class StringTest {
	public static void main(String[] args) {
		String s1="zyc";//字面量
		String s2="zyc";
		s1="abc";//重新new一个对象
		System.out.println(s1==s2);//true||false
		String s3="wsad";
		String s4= s3.replace('w', 'q');
		System.out.println(s3);//wsad
		System.out.println(s4);//qsad
	}
}
