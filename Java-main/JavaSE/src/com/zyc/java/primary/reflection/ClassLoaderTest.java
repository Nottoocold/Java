package com.zyc.java.primary.reflection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 使用类的加载器(ClassLoader)加载配置文件
 * 
 *@author zyc
 *com.zyc.java12
 *JavaSE
 *2022年5月14日上午12:01:05
 */
public class ClassLoaderTest {
	public static void main(String[] args) throws Exception {
		//方式一：
		Properties properties = new Properties();
//		FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
//		properties.load(fileInputStream);
//		String userString = properties.getProperty("user");
//		String passwordString = properties.getProperty("password");
//		System.out.println(userString+"---"+passwordString);
		
		//方拾二：
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		InputStream is = loader.getResourceAsStream("jdbc.properties");//搜索路径在src下
		properties.load(is);
		String userString = properties.getProperty("user");
		String passwordString = properties.getProperty("password");
		System.out.println(userString+"---"+passwordString);
		
	}
}
