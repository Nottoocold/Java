package com.zyc.java.senior.logback;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	/**
	 * 日志技术：帮助记录系统的运行信息到指定位置中(数据库,文件等)，可随时开启和关闭，性能也比较好，多线程
	 * 常见规范：
	 * 	commons logging 
	 * 	simple logging facade for java
	 * 实现类：
	 * 	log4j
	 * 	logback
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger("LogTest.class");
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("输入字符串之包含字母: ");
			String string = sc.nextLine();
			if(string.matches("^[A-Za-z]+$"))
				LOGGER.info("匹配成功");
			else {
				LOGGER.error("匹配不成功");
				break;
			}
		}
		sc.close();
	}
}
