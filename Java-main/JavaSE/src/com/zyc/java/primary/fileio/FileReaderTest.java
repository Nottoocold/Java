package com.zyc.java.primary.fileio;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Thread;

/**
 * IO流原理及分类：操作数据单位：字节流、字符流；数据流向：输入流、输出流；流的角色：节点流、处理流
 * 
 * 4个抽象基类： InputStream OutputStream Reader Writer 此四种为节点流(文件流) FileInputStream
 * FileOutputStream FileReader FileWriter 缓冲流(处理流的一种) Buffered...
 * 
 * read()---read(char[] cbuf) 两种方法的使用和不同
 * 
 * 对于文本文件：使用字符流处理
 * 对于非文本文件：使用字节流处理
 * 
 * @author zyc
 *
 *         2022年5月10日下午6:34:06
 */
public class FileReaderTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileReader fileReader = null;
		try {
			// 1.实例化File类的对象，指明要操作的文件
			File file = new File("JavaSE.iml");
			System.out.println(file.getAbsolutePath());
			// 2.提供具体的流
			fileReader = new FileReader(file);
			int data = fileReader.read();// 3.返回读入的一个字符，如果达到文件末尾返回-1
			while (data != -1) {
				System.out.print((char) data);
				Thread.sleep(50);
				data = fileReader.read();//-->read(char[] cbuf)每次读入n长度的char型数组，返回读入到数组中的字符个数，读完返回-1
			}

		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if (fileReader != null) {
				fileReader.close();// 4.流的关闭
			} 
		}
	}
}
