package com.zyc.java.senior.innerclass;

import com.zyc.java.senior.innerclass.InnerClass.fileClass;
import com.zyc.java.senior.innerclass.InnerClass.staticClass;

public class TestClass {

	public static void main(String[] args) {
		staticClass inClass = new InnerClass.staticClass();//创建静态内部类对象
		System.out.println(inClass.in);
		
		fileClass fileClass = new InnerClass().new fileClass();//成员内部类
		fileClass.show();
		fileClass.test();
		
	}
}
