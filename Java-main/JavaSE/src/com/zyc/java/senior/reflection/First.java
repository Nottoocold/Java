package com.zyc.java.senior.reflection;

public class First {
	/**
	 * ��Java��������ʱ��JVM�Ὣһ�����ࣨclass�ļ����ȼ��أ����������е��඼����һ��ʼ���أ���
	 * ͨ��ClassLoader������أ��ڼ��ع����У��Ὣ�����Ϣ��ȡ�����������Ԫ�ռ��У�JDK1.8֮ǰ��������ô�����
	 * ͬʱҲ������һ��Class���������ڴ棨���ڴ棩��ע���Class����ֻ�����һ��������ص���Ψһ��Ӧ��
	 * 
	 * ���������
	 * 			AppClassLoader  ExtClassLoader  BootstarpClassLoader
	 * jdk�Լ��ṩ���඼����Bootstarp���أ��û��Լ����������AppClassloader���أ�
	 * ������Ĺ��̶���һ��һ�����ϴ��ݣ���ȷ�����ص��಻��jdk�Լ��ṩ����ʱ����������㷵�ص�AppClassloader
	 */
	public static void main(String[] args) {
		System.out.println(First.class.getClassLoader());//App
		System.out.println(First.class.getClassLoader().getParent());//Ext
		System.out.println(First.class.getClassLoader().getParent().getParent());//null BootstarpClassLoader��C++��д��������Java�л�ȡ����
	}
}
