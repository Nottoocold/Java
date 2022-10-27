package com.zyc.java.primary.fileio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���ڷ��ı��ļ�����Ҫʹ���ֽ�������
 * 
  * ����������������һ�֡���������Ĵ����ٶȺ�Ч��
 * 
 * ת�������ֽ������ַ������໥ת��
 * 
 *@author zyc
 *com.zyc.java10
 *JavaSE
 *2022��5��11������11:06:12
 */
public class FileInputOutputStreamTest {
	public static void main(String[] args) {
		//ʵ�ַ��ı��ļ��ĸ��ƣ�
		//�����ļ�
		//����������(������)
		BufferedInputStream bif = null;
		BufferedOutputStream bof = null;
		long start = System.currentTimeMillis();
		try {
			File srcFile = new File("/home/zyc/Documents/jdk-8u121-docs-all.CHM");
			File destFile = new File("/home/zyc/Documents/jdk-8u121-docs-all.CHM.cp");
			//�����ڵ���
			FileInputStream inputStream = new FileInputStream(srcFile);
			FileOutputStream outputStream = new FileOutputStream(destFile);
			bif = new BufferedInputStream(inputStream);
			bof = new BufferedOutputStream(outputStream);
			//���д��䣬�����ݵĶ����д��
			byte[] buffer = new byte[512];
			int len;
			while ((len = bif.read(buffer)) != -1) {
				bof.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (bif != null) {//���Ĺرգ����ر��������ͬʱ��ر��ڲ���
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
