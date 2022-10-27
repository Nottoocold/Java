package com.zyc.java.senior.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {
	/**
	 * 为了简化数组和集合的API
	 * 1.获取stream流 集合Collection 提供了默认stream()方法，Arrays工具类提供方法 stream(T[] arr) 和 Stream接口 of(T...elements)
	 * 2.中间操作，即对流上的数据进行操作，支持链式编程
	 * 3.终结方法，结束操作
	 */
	public static void main(String[] args) {
		//
		List<String> names = new ArrayList<>();
		Collections.addAll(names, "Tom", "Mary", "Toms", "Tkhkljlf", "Mdsah", "Tjn");
		// 将以T开头的姓名加入新集合
		List<String> tList = new ArrayList<>();
		names.forEach(s -> {
			if (s.startsWith("T"))
				tList.add(s);
		});

		// 将以T开头且长度为3的姓名加入另一集合
		List<String> three = new ArrayList<>();
		tList.forEach(s -> {
			if (s.length() == 3)
				three.add(s);
		});

//		System.out.println(tList);
//		System.out.println(three);

		// 使用stream 流处理
		Stream<String> filter = names.stream().filter(s -> s.startsWith("T") && s.length() == 3);
		filter.forEach(s->{
			System.out.println(s);
		});
	}
}
