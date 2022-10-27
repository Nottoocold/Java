package com.zyc.java.senior.fileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ×Ö·ûÊäÈëÊä³öÁ÷
 * @author zyc
 *
 */
public class FIleRWTest {
	public static void main(String[] args) {
		try (FileReader fReader = new FileReader("io.txt");
				FileWriter fWriter =  new FileWriter("io.txt.bk")){
			int len ;
			char[] ch =new char[16];
			while((len = fReader.read(ch)) != -1) {
				fWriter.write(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
