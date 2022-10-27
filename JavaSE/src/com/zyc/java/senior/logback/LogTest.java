package com.zyc.java.senior.logback;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	/**
	 * ��־������������¼ϵͳ��������Ϣ��ָ��λ����(���ݿ�,�ļ���)������ʱ�����͹رգ�����Ҳ�ȽϺã����߳�
	 * �����淶��
	 * 	commons logging 
	 * 	simple logging facade for java
	 * ʵ���ࣺ
	 * 	log4j
	 * 	logback
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger("LogTest.class");
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("�����ַ���֮������ĸ: ");
			String string = sc.nextLine();
			if(string.matches("^[A-Za-z]+$"))
				LOGGER.info("ƥ��ɹ�");
			else {
				LOGGER.error("ƥ�䲻�ɹ�");
				break;
			}
		}
		sc.close();
	}
}
