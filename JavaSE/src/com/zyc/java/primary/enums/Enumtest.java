package com.zyc.java.primary.enums;

/*
 * 枚举类主要方法：
 * values()返回枚举类型的对象数组，方便遍历所有枚举值
 * valueOf(String str)可以把一个字符串转为对应的枚举类对象，要求字符串必须是枚举类对象的名字。如不是则会抛出异常
 * toString()返回当前枚举类对象的名称
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
	a("太平洋"),
	b("印度洋"),
	c("大西洋");
	
	private final String name;
	
	private Sea(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
}