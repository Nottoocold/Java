package com.zyc.java.primary.reflection;

import java.util.Random;

/**
 * 
 * forName(String classPath)方法创建对象
 * 
 *@author zyc
 *com.zyc.java12
 *JavaSE
 *2022年5月14日上午9:53:12
 */
public class ForNameTest {
	
	public static Object getInstance(String classPath) throws Exception {
		Class objClass = Class.forName(classPath);
		return objClass.newInstance();
	}
	public static void main(String[] args) {
		for(int n = 0;n < 10;n++)
		{
			int i = new Random().nextInt(3);
			String classPath = "";
			switch (i) {
			case 0:
				classPath = "java.util.Date";
				break;
			case 1:
				classPath = "java.lang.Object";
				break;
			case 2:
				classPath = "com.zyc.java12.Person";
				break;
			}
			try {
				Object object = getInstance(classPath);
				System.out.println(object);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
