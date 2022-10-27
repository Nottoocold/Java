package com.zyc.java.primary.collections;

import java.util.Collection;
import java.util.LinkedList;

/**
 * List接口：有序的、可重复元素--->动态数组
 * 			ArrayList	线程不安全的，底层使用object数组存储(动态的)
 * 
 * 			LinkedList	底层使用双向链表
 * 
 * 			Vector		很古老，线程安全的
 * 
 * 			相同点：三个类都实现了List接口，存储有序的，可重复元素
 * 			
 * collection子接口之一list
 * 
 * @author modua
 *
 */
public class ListTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Collection collection = new LinkedList();
		collection.add("y");
		
	}
}
