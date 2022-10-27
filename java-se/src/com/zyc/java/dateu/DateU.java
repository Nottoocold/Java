package com.zyc.java.dateu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateU {
	private final SimpleDateFormat sdFormat = new SimpleDateFormat();
	private final String p1 = "yyyy-MM-dd HH:mm:ss";
	private final String p2 = "yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒";
	
	public void format(Date date) {
		sdFormat.applyPattern(p1);
		System.out.println(sdFormat.format(date));
	}
	
	public void toDate() {
		sdFormat.applyLocalizedPattern(p2);
		long c1 = System.currentTimeMillis();
		String sd = sdFormat.format(new Date(Long.parseLong(String.valueOf(c1))));
		System.out.println("格式化结果 " + sd);
	}
}
