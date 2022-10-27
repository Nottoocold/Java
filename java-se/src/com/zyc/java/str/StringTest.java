package com.zyc.java.str;

import java.util.Arrays;

public class StringTest {
	private static final Main MAIN = new Main();
	
	public static void main(String[] args) {
		String string = MAIN.removeCharAt("Google", 3);
		System.out.println(string);
		String[] strings = MAIN.spliceString("l-1", "-");
		System.out.println(Arrays.toString(strings));
		MAIN.token();
		System.out.println("+++++++++");
		MAIN.match();
		System.out.println("+++++++++");
		MAIN.stringOptimization();
		System.out.println("++++++++++");
		MAIN.concat();
	}

}
