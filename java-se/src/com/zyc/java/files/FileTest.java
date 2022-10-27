package com.zyc.java.files;

public class FileTest {

	public static void main(String[] args) {
		FilesU filesU = new FilesU();
/*		filesU.fw();
		filesU.fr();
		filesU.deleteFile();
		System.out.println("++++++++");
		filesU.transfer("shut.txt", "bak.txt");
		filesU.createTempFile("zzz", ".md");*/
		filesU.fastCopy("src/shut.txt", "src/bak.txt");
	}

}
