package com.zyc.java.primary.string;

public class StringMethodTest {
	
	void Test() {
		//1.
		String name  = "dad9A.Bg/j";	//  "dad9A.Bg/j"
		System.out.println(name);
		
		//2.
		char[] array = name.toCharArray();
		System.out.println(array);
		
		//3.
		CharSequence sub = name.subSequence(1, 6);	// [1,6)
		System.out.println(sub);
		
		//4.
		String replace = name.replace(".","^^");
		System.out.println(replace);
		
		//5.
		boolean flag = replace.contains("^^");
		System.out.println(flag);
		
		//6.
		String string = "abc,bce,da,lp,";
		String[] split = string.split(",");
		for (String string2 : split) {
			System.out.print(string2 + " ");
		}
	}
	
	public static void main(String[] args) {
		new StringMethodTest().Test();
	}
}
