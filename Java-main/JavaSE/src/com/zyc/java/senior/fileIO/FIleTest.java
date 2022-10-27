package com.zyc.java.senior.fileIO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FIleTest {
	/**
	 * �ļ���File,ר��������ʾһ���ļ����ļ��У�ֻ������ֻ������ļ��Ĵ�����������ļ�����ͨ��File������ԣ����Ը��õع���Ͳ���Ӳ���ϵ��ļ�
	 * ͨ��File�������Ǿ��ܿ��ٵõ��ļ���������Ϣ��������ļ��У������Ի�ȡ�ļ����ڲ����ļ��б������
	 * �������ϣ����ȡĳ���ļ������ݣ�����ֱ�ӽ�File��Ϊ���������ֽ��������ַ���
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("./src");
		System.out.println(file.exists()); // ���ļ��Ƿ����
		System.out.println(file.length()); // ��ȡ�ļ��Ĵ�С
		System.out.println(file.isDirectory()); // �Ƿ�Ϊһ���ļ���
		System.out.println(file.canRead()); // �Ƿ�ɶ�
		System.out.println(file.canWrite()); // �Ƿ��д
		System.out.println(file.canExecute()); // �Ƿ��ִ��
		System.out.println(file.getAbsolutePath()); // ����·��
		System.out.println(file.getCanonicalPath()); // ��׼·��
		System.out.println(file.getName()); // �ļ���
		System.out.println(System.getProperty("user.dir")); // ��ȡ��ǰ�����Ŀ¼

		try {
			printAllFiles(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printAllFiles(File file) throws IOException {
		List<String> list = new ArrayList<String>();
		if (file != null) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files) {
					if (f.isDirectory()) {
						printAllFiles(f);
					} else if (f.isFile()) {
						list.add(f.getName());
					}
				}
				FileOutputStream fos = new FileOutputStream("IO.txt", true);
				BufferedOutputStream bfos = new BufferedOutputStream(fos);
				list.forEach(s -> {
					try {
						bfos.write(s.getBytes());
						bfos.write("\n".getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				list.clear();
				try {
					bfos.close();
					fos.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}