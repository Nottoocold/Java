package com.zyc.java.senior.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {
	/**
	 * Ϊ�˼�����ͼ��ϵ�API
	 * 1.��ȡstream�� ����Collection �ṩ��Ĭ��stream()������Arrays�������ṩ���� stream(T[] arr) �� Stream�ӿ� of(T...elements)
	 * 2.�м�������������ϵ����ݽ��в�����֧����ʽ���
	 * 3.�ս᷽������������
	 */
	public static void main(String[] args) {
		//
		List<String> names = new ArrayList<>();
		Collections.addAll(names, "Tom", "Mary", "Toms", "Tkhkljlf", "Mdsah", "Tjn");
		// ����T��ͷ�����������¼���
		List<String> tList = new ArrayList<>();
		names.forEach(s -> {
			if (s.startsWith("T"))
				tList.add(s);
		});

		// ����T��ͷ�ҳ���Ϊ3������������һ����
		List<String> three = new ArrayList<>();
		tList.forEach(s -> {
			if (s.length() == 3)
				three.add(s);
		});

//		System.out.println(tList);
//		System.out.println(three);

		// ʹ��stream ������
		Stream<String> filter = names.stream().filter(s -> s.startsWith("T") && s.length() == 3);
		filter.forEach(s->{
			System.out.println(s);
		});
	}
}
