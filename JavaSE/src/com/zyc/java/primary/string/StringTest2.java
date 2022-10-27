package com.zyc.java.primary.string;

public class StringTest2 {
	public static void main(String[] args) {
		char[] chs = {'h','e','l','l','o'};
		String s1 = new String(chs);
		String s2 = new String(chs);
		String s3 = "hello";
		String s4 = "hello";
		//1
		System.out.println((s1==s2)+","+(s1==s3)+","+(s3==s4));//fft
		//2
		System.out.println((s1.equals(s2))+","+(s1.equals(s3))+","+(s3.equals(s4)));//ttt
		//反转字符串，并判断是否是回文字符串
		String s = "ABCBA";
		String ss = "";
		for (int i = s.length()-1; i >= 0; i--) {
			ss+= s.charAt(i);
		}
//		s = ss;
		System.out.println(s.equals(ss));
	}
}
