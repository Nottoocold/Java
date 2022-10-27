package com.zyc.java.senior.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMethod {

	public static void main(String[] args) {
		/**
		 * Stream������API���������޸ļ��ϻ������е�����
		 * 1.forEach ���� ���ս᷽��)
		 * 2.count ����
		 * 3.filter ����
		 * 4.distinct �����ظ�Ԫ��
		 * 4.limit ȡǰ����
		 * 5.skip ����ǰ����
		 * 6.map �ӹ�����
		 * 7.concat �ϲ���
		 * 
		 * �����ռ������ӹ���ɵ���������װ�뼯�ϻ�����
		 * API��R collect(Collector c)ָ���ռ���
		 * ������ռ���ʽ��
		 * 		<T> Collector toList()
		 * 		<T> Collector toSet()
		 * 		<T> Collector toMap(Function keyMapper, Function valueMapper)
		 */
		
		List<String> names = new ArrayList<>();
		Collections.addAll(names, "Tom", "Mary", "Toms", "Tkhkljlf", "Mdsah", "Tjn");
		Stream<String> filter = names.stream().filter(s -> s.startsWith("T") && s.length() == 3);
		List<String> list = filter.collect(Collectors.toList());//
//		filter.collect(Collectors.toSet());//��ֻ��ʹ��һ��
		System.out.println(list);
	}

}
