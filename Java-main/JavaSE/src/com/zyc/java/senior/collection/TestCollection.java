package com.zyc.java.senior.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class TestCollection {

	public static void main(String[] args) {
		/**
		 * ���ϵ����ڽӿ�Collection
		 * �鿴API
		 */
		Collection<Integer> collection = new ArrayList<>();
		collection.add(12);
		collection.add(1);
		collection.add(10);
		System.out.println(collection.contains(2));
		Iterator<Integer> it = collection.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//lambda���ʽ
		collection.forEach( (t)->System.out.println(t) );
		
		Object[] array = collection.toArray();
		System.out.println(Arrays.toString(array));
	}
}
