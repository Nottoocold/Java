package com.zyc.java.primary.reflection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * ʹ����ļ�����(ClassLoader)���������ļ�
 * 
 *@author zyc
 *com.zyc.java12
 *JavaSE
 *2022��5��14������12:01:05
 */
public class ClassLoaderTest {
	public static void main(String[] args) throws Exception {
		//��ʽһ��
		Properties properties = new Properties();
//		FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
//		properties.load(fileInputStream);
//		String userString = properties.getProperty("user");
//		String passwordString = properties.getProperty("password");
//		System.out.println(userString+"---"+passwordString);
		
		//��ʰ����
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		InputStream is = loader.getResourceAsStream("jdbc.properties");//����·����src��
		properties.load(is);
		String userString = properties.getProperty("user");
		String passwordString = properties.getProperty("password");
		System.out.println(userString+"---"+passwordString);
		
	}
}
