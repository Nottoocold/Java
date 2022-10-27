package com.zyc.java.senior.fileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输入输出流,
 * @author zyc
 *
 */
public class FIleIOStreamTest {
	public static void main(String[] args) {
		//会自动关闭流
		try (FileInputStream iStream = new FileInputStream("io.txt");
				FileOutputStream oStream = new FileOutputStream("io.txt.bak",true)){
			int len = 0;
			byte[] bf = new byte[16];
			while((len = iStream.read(bf)) != -1) {
				oStream.write(bf,0,len);
			}
		} catch (IOException e) {
			System.out.println("No such a file.");
		}
	}
}
