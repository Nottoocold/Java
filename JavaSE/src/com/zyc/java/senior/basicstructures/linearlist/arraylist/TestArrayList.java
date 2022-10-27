package com.zyc.java.senior.basicstructures.linearlist.arraylist;

import com.zyc.java.senior.basicstructures.linearlist.abstractlist.AbstractList;

public class TestArrayList {

	public static void main(String[] args) {
		AbstractList<Character> list = new ArrayList<>();
		for(int c = 'A'; c <= 'Z'; ++c) {
			list.add((char) c);
		}
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.get(23));
		list.remove();
		list.remove(3);
		System.out.println(list);
		System.out.println(list.size());
	}
}
