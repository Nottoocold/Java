package com.zyc.java.senior.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		/**
		 * List接口集成Collection接口
		 * List支持索引,常用两个实现类ArrayList，LinkedList
		 */
		List<String> list = new ArrayList<>();
		list.add("dadad");
		list.add("dad");
		list.add("fkgd");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String ret = it.next();
			if("dad".equals(ret))
				it.remove();
		}
		System.out.println(list);
	}
}
