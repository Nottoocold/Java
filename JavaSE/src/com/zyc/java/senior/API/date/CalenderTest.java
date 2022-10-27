package com.zyc.java.senior.API.date;

import java.util.Calendar;

public class CalenderTest {

	public static void main(String[] args) {
		/*
		 * Calendar 是一个抽象类,不能直接创建实例，但是getInstance(); 
		 * 			代表系统此刻日期对应的日历对象，
		 * 
		 */
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
	}

}
