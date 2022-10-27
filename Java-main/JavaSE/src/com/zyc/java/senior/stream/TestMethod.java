package com.zyc.java.senior.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMethod {

	public static void main(String[] args) {
		/**
		 * Stream流常用API，流不能修改集合或数组中的数据
		 * 1.forEach 遍历 （终结方法)
		 * 2.count 计数
		 * 3.filter 过滤
		 * 4.distinct 过滤重复元素
		 * 4.limit 取前几个
		 * 5.skip 跳过前几个
		 * 6.map 加工方法
		 * 7.concat 合并流
		 * 
		 * 流的收集，将加工完成的数据重新装入集合或数组
		 * API：R collect(Collector c)指定收集器
		 * 具体的收集方式：
		 * 		<T> Collector toList()
		 * 		<T> Collector toSet()
		 * 		<T> Collector toMap(Function keyMapper, Function valueMapper)
		 */
		
		List<String> names = new ArrayList<>();
		Collections.addAll(names, "Tom", "Mary", "Toms", "Tkhkljlf", "Mdsah", "Tjn");
		Stream<String> filter = names.stream().filter(s -> s.startsWith("T") && s.length() == 3);
		List<String> list = filter.collect(Collectors.toList());//
//		filter.collect(Collectors.toSet());//流只能使用一次
		System.out.println(list);
	}

}
