package com.zyc.java.senior.API.regex;

public class TestRegex {

	/**
	 * 案例:校验QQ号是否合法,长度 2-20,不包含字符,只能是数字
	 */
	public static boolean check0(String QQ) {
		if (QQ == null || QQ.length() < 6 || QQ.length() > 20) {
			return false;
		}
		for (int i = 0; i < QQ.length(); ++i) {
			char c = QQ.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Regex check
	 * @param QQ
	 * @return
	 */
	public static boolean checkQQByRegex(String QQ) {
		return QQ != null && QQ.matches("\\d{6,20}");
	}

	public static void main(String[] args) {
		String qq = "2468746360";
		System.out.println(check0(qq));
		System.out.println(checkQQByRegex(qq));
	}
}
