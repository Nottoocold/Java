package com.zyc.java.senior.API.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

	public static void test() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start = "2022-7-29 23:00:00";
		String end = "2022-7-29 23:05:00";

		String user1 = "2022-7-29 23:02:40";
		String user2 = "2022-7-29 23:05:01";

		Date st = format.parse(start);
		Date ed = format.parse(end);

		Date date1 = format.parse(user1);
		if (date1.after(st) && date1.before(ed))
			System.out.println("User1 OK.");
		Date date2 = format.parse(user2);
		if (date2.after(st) && date2.before(ed))
			System.out.println("User2 OK.");

	}

	public static void main(String[] args) {
		/**
		 * 1.���԰�Date�����ʱ�����ֵ�Զ����ʽ�� 2.���Խ��ַ�����ʽ��ʱ��(2022��7��29�� 22:25:49)���������ڶ���
		 */
		Date date = new Date();
		System.out.println(date);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��-MM��-dd�� ��ǰʱ��: HH:mm:ss EEE a");
		// format(Date);
		String stringdate = sdf.format(date);
		System.out.println(stringdate);

		// format(long millis);
		String string = sdf.format(System.currentTimeMillis() + 120 * 1000);
		System.out.println(string);

		System.out.println("------");
		// �����ַ���ʱ��
		// Date parse(String source);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		try {
			Date parse = sdf1.parse("2022��07��29�� 22:45:43");
			long temp = parse.getTime() + (2L * 24 * 60 * 60 + 16 * 60 * 60 + 20 * 60 + 30) * 1000;
			String after = sdf1.format(temp);
			System.out.println(after);
		} catch (ParseException e) {
			System.out.println("������ʽ��ƥ��!");
		}
		
		try {
			test();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
