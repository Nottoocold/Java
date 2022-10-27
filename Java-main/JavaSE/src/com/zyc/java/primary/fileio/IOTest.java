package com.zyc.java.primary.fileio;

import java.io.File;
import java.io.IOException;

/**
 * IO流：	File类的对象可以表示文件或文件目录（文件夹），提供四个构造器
 * 			常用方法：获取功能； renameTo(File dest)--如：file1.renameTo(file2),需要file1存在，file2不存在
 * 					判断功能；
 * 
 * @author zyc
 *
 * 2022年5月9日下午10:04:48
 */
public class IOTest {
	public static void main(String[] args) throws IOException {
		File file = new File("~/Documents");//在没执行前，文件是不存在的，及时此文件真的不存在，也会执行下一条
		File file1 = new File(file.getParent(),"/ceshi.txt");
		System.out.println(file);
		System.out.println(file1);
	}
}
