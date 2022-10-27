package com.zyc.java.files.dir;

import java.io.File;

public class DirTest {
	public static final String PATH_STRING = "D:\\a\\b\\c\\d";

	public static void main(String[] args) {
		DirU dirU = new DirU();
		dirU.mkdirs(PATH_STRING);
		File dirs = new File(PATH_STRING);
		boolean flag = dirU.deleteDir(dirs);
		System.out.println(flag);
		dirU.list("./bin");
	}

}
