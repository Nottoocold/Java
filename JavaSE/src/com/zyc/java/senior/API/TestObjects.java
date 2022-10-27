package com.zyc.java.senior.API;

import java.util.ArrayList;
import java.util.List;

public class TestObjects {

	/**
	 * 1.Objects 2.StringBuilder 3.Math 4.System 5.BigDecimal
	 */

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int count = 0;
		int n = Integer.MAX_VALUE >> 4;
		long start = System.currentTimeMillis();
		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * 7 + 3);// [0, 1) * 7 + 3 -> [3,10)
			if (a == 9) {
				count++;
				list.add(a);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms.");
		System.out.println("Total loop is " + n + ",Num 9 count is " + count);
		double ration = Double.valueOf(String.valueOf(count)) / Double.valueOf(String.valueOf(n));
		System.out.println("Ratio count/n is " + ration);

		/*
		 * public static native void arraycopy(Object src, int srcPos, Object dest, int
		 * destPos,int length); System类提供的数组的拷贝，底层使用C++实现，效率高,工具类Arrays中的copyof都是使用此方法
		 */
		Integer[] src = list.toArray(new Integer[0]);
		list = null;
		Integer[] dest = new Integer[count + 1];
		long s = System.currentTimeMillis();
		System.arraycopy(src, 0, dest, 0, src.length);
		long e = System.currentTimeMillis();
		System.out.println("copy time is " + (e - s) + " ms.");
	}
}
