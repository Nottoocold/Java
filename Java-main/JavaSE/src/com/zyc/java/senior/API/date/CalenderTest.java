package com.zyc.java.senior.API.date;

import java.util.Calendar;

public class CalenderTest {

	public static void main(String[] args) {
		/*
		 * Calendar ��һ��������,����ֱ�Ӵ���ʵ��������getInstance(); 
		 * 			����ϵͳ�˿����ڶ�Ӧ����������
		 * 
		 */
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
	}

}
