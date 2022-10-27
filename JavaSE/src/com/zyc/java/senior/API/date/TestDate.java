package com.zyc.java.senior.API.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * jdk8 新日期API java.time包下
 * @author zyc
 *
 */
public class TestDate {

	public static void main(String[] args) {
		/**
		 * Date class Date() getTime()
		 */
//		Date date = new Date();
//		System.out.println(date); // Fri Jul 29 22:10:32 GMT+08:00 2022

		System.out.println(new Date());
		long millis = System.currentTimeMillis();
		millis += (60 * 60 + 120) * 1000;// 1h120s
		Date date2 = new Date();//new Date(millis)
		date2.setTime(millis);
		System.out.println(date2);
		
		
		System.out.println(LocalDateTime.now());		
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
	}

}
