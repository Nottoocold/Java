package com.zyc.java.senior.API.Arrays;

import java.util.Arrays;

public class TestArrays {

	public static void main(String[] args) {
		String[] arr = { "dada", "gda", "d", "fg", "gg", "vb" };
		Arrays.sort(arr);//Ĭ������
		System.out.println(Arrays.toString(arr));
		System.out.println("low is " + (-Arrays.binarySearch(arr, "ddad") - 1));//���ص���Ӧ����λ�õ��෴��
	}
}
