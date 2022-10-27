package com.zyc.java.str;

import java.util.Optional;
import java.util.StringTokenizer;

public class Main {

	public String removeCharAt(String str, int pos) {
		if (str == null) {
			return null;
		}
		return str.substring(0, pos) + str.substring(pos + 1);
	}

	public String[] spliceString(String str, String delimeter) {
		Optional<String> optional = Optional.ofNullable(str);
		return optional.orElse("null").split(delimeter);
	}

	public void token() {
		String str = "This is String, split by StringTokenizer, created by runoob";
		StringTokenizer st = new StringTokenizer(str);

		System.out.println("----- 通过空格分隔 ------");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}

		System.out.println("----- 通过逗号分隔 ------");
		StringTokenizer st2 = new StringTokenizer(str, ",");

		while (st2.hasMoreElements()) {
			Object object = st2.nextElement();
			System.out.println(((String) object).trim());
		}
	}

	public void match() {
		String first_str = "Welcome to Microsoft";
		String second_str = "I work with microsoft";
		boolean match1 = first_str.regionMatches(11, second_str, 12, 9);
		boolean match2 = first_str.regionMatches(true, 11, second_str, 12, 9); // 第一个参数 true 表示忽略大小写区别
		System.out.println("区分大小写返回值：" + match1);
		System.out.println("不区分大小写返回值：" + match2);
	}

	public void stringOptimization() {
		String variables[] = new String[50000];
		for (int i = 0; i < 50000; i++) {
			variables[i] = "s" + i;
		}
		long startTime0 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			variables[i] = "hello";
		}
		long endTime0 = System.currentTimeMillis();
		System.out.println("直接使用字符串： " + (endTime0 - startTime0) + " ms");
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			variables[i] = new String("hello");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("使用 new 关键字：" + (endTime1 - startTime1) + " ms");
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			variables[i] = new String("hello");
			variables[i] = variables[i].intern();
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println("使用字符串对象的 intern() 方法: " + (endTime2 - startTime2) + " ms");
	}

	public void concat() {
		long startTime = System.currentTimeMillis();
		@SuppressWarnings("unused")
		String s1 = "";
		for (int i = 0; i < 5000; i++) {
			s1 = "This is" + i + " ," + "testing the" + "difference" + "between" + "String" + "and" + "StringBuffer" + i;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("字符串连接" + " - 使用 + 操作符 : " + (endTime - startTime) + " ms");
		long startTime1 = System.currentTimeMillis();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 5000; i++) {
			result.append("This is");
			result.append("testing the");
			result.append("difference");
			result.append(i);
			result.append("between");
			result.append("String");
			result.append("and");
			result.append("StringBuffer");
			result.append(i);
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("字符串连接" + " - 使用 StringBuilder : " + (endTime1 - startTime1) + " ms");
	}
}
