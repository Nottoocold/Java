package com.zyc.java.primary.fileio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 对于非文本文件，需要使用字节流处理
 * 
  * 缓冲流：处理流的一种。能提高流的处理速度和效率
 * 
 * 转换流：字节流与字符流的相互转换
 * 
 *@author zyc
 *com.zyc.java10
 *JavaSE
 *2022年5月11日下午11:06:12
 */
public class FileInputOutputStreamTest {
	public static void main(String[] args) {
		//实现非文本文件的复制，
		//创建文件
		//创建缓冲流(处理流)
		BufferedInputStream bif = null;
		BufferedOutputStream bof = null;
		long start = System.currentTimeMillis();
		try {
			File srcFile = new File("/home/zyc/Documents/jdk-8u121-docs-all.CHM");
			File destFile = new File("/home/zyc/Documents/jdk-8u121-docs-all.CHM.cp");
			//创建节点流
			FileInputStream inputStream = new FileInputStream(srcFile);
			FileOutputStream outputStream = new FileOutputStream(destFile);
			bif = new BufferedInputStream(inputStream);
			bof = new BufferedOutputStream(outputStream);
			//进行传输，即数据的读入和写出
			byte[] buffer = new byte[512];
			int len;
			while ((len = bif.read(buffer)) != -1) {
				bof.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (bif != null) {//流的关闭，当关闭外层流的同时会关闭内层流
				try {
					bif.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bof != null) {
				try {
					bof.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
