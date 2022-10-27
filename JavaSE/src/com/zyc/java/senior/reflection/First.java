package com.zyc.java.senior.reflection;

public class First {
	/**
	 * 在Java程序启动时，JVM会将一部分类（class文件）先加载（并不是所有的类都会在一开始加载），
	 * 通过ClassLoader将类加载，在加载过程中，会将类的信息提取出来（存放在元空间中，JDK1.8之前存放在永久代），
	 * 同时也会生成一个Class对象存放在内存（堆内存），注意此Class对象只会存在一个，与加载的类唯一对应！
	 * 
	 * 类加载器：
	 * 			AppClassLoader  ExtClassLoader  BootstarpClassLoader
	 * jdk自己提供的类都是由Bootstarp加载，用户自己定义的类由AppClassloader加载，
	 * 加载类的过程都是一级一级向上传递，当确定加载的类不是jdk自己提供的类时，方可再逐层返回到AppClassloader
	 */
	public static void main(String[] args) {
		System.out.println(First.class.getClassLoader());//App
		System.out.println(First.class.getClassLoader().getParent());//Ext
		System.out.println(First.class.getClassLoader().getParent().getParent());//null BootstarpClassLoader由C++编写，所以在Java中获取不到
	}
}
