package com.zyc.java.primary.fileio;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Thread;

/**
 * IO��ԭ�����ࣺ�������ݵ�λ���ֽ������ַ�������������������������������Ľ�ɫ���ڵ�����������
 * 
 * 4��������ࣺ InputStream OutputStream Reader Writer ������Ϊ�ڵ���(�ļ���) FileInputStream
 * FileOutputStream FileReader FileWriter ������(��������һ��) Buffered...
 * 
 * read()---read(char[] cbuf) ���ַ�����ʹ�úͲ�ͬ
 * 
 * �����ı��ļ���ʹ���ַ�������
 * ���ڷ��ı��ļ���ʹ���ֽ�������
 * 
 * @author zyc
 *
 *         2022��5��10������6:34:06
 */
public class FileReaderTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileReader fileReader = null;
		try {
			// 1.ʵ����File��Ķ���ָ��Ҫ�������ļ�
			File file = new File("JavaSE.iml");
			System.out.println(file.getAbsolutePath());
			// 2.�ṩ�������
			fileReader = new FileReader(file);
			int data = fileReader.read();// 3.���ض����һ���ַ�������ﵽ�ļ�ĩβ����-1
			while (data != -1) {
				System.out.print((char) data);
				Thread.sleep(50);
				data = fileReader.read();//-->read(char[] cbuf)ÿ�ζ���n���ȵ�char�����飬���ض��뵽�����е��ַ����������귵��-1
			}

		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if (fileReader != null) {
				fileReader.close();// 4.���Ĺر�
			} 
		}
	}
}
