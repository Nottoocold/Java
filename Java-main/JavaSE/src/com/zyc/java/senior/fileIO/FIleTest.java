package com.zyc.java.senior.fileIO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FIleTest {
	/**
	 * 文件类File,专门用来表示一个文件或文件夹，只不过它只是这个文件的代表，不是这个文件本身，通过File对象可以，可以更好地管理和操作硬盘上的文件
	 * 通过File对象，我们就能快速得到文件的所有信息，如果是文件夹，还可以获取文件夹内部的文件列表等内容
	 * 如果我们希望读取某个文件的内容，可以直接将File作为参数传入字节流或是字符流
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("./src");
		System.out.println(file.exists()); // 此文件是否存在
		System.out.println(file.length()); // 获取文件的大小
		System.out.println(file.isDirectory()); // 是否为一个文件夹
		System.out.println(file.canRead()); // 是否可读
		System.out.println(file.canWrite()); // 是否可写
		System.out.println(file.canExecute()); // 是否可执行
		System.out.println(file.getAbsolutePath()); // 绝对路径
		System.out.println(file.getCanonicalPath()); // 标准路径
		System.out.println(file.getName()); // 文件名
		System.out.println(System.getProperty("user.dir")); // 获取当前程序根目录

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