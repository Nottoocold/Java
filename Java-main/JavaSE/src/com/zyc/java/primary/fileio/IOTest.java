package com.zyc.java.primary.fileio;

import java.io.File;
import java.io.IOException;

/**
 * IO����	File��Ķ�����Ա�ʾ�ļ����ļ�Ŀ¼���ļ��У����ṩ�ĸ�������
 * 			���÷�������ȡ���ܣ� renameTo(File dest)--�磺file1.renameTo(file2),��Ҫfile1���ڣ�file2������
 * 					�жϹ��ܣ�
 * 
 * @author zyc
 *
 * 2022��5��9������10:04:48
 */
public class IOTest {
	public static void main(String[] args) throws IOException {
		File file = new File("~/Documents");//��ûִ��ǰ���ļ��ǲ����ڵģ���ʱ���ļ���Ĳ����ڣ�Ҳ��ִ����һ��
		File file1 = new File(file.getParent(),"/ceshi.txt");
		System.out.println(file);
		System.out.println(file1);
	}
}
