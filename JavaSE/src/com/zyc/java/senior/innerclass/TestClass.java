package com.zyc.java.senior.innerclass;

import com.zyc.java.senior.innerclass.InnerClass.fileClass;
import com.zyc.java.senior.innerclass.InnerClass.staticClass;

public class TestClass {

	public static void main(String[] args) {
		staticClass inClass = new InnerClass.staticClass();//������̬�ڲ������
		System.out.println(inClass.in);
		
		fileClass fileClass = new InnerClass().new fileClass();//��Ա�ڲ���
		fileClass.show();
		fileClass.test();
		
	}
}
