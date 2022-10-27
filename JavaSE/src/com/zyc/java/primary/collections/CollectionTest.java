package com.zyc.java.primary.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * collection�ӿ��еķ���
 * 
 * @author Kidz
 *
 */
public class CollectionTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Collection collection = new ArrayList();
		//add(Object e)
		collection.add(12);
		collection.add("zhao");
		collection.add(new Date());
		//
		//size
		System.out.println(collection.size());//3
		System.out.println(collection);
		//addAll()
		@SuppressWarnings("rawtypes")
		Collection collection2 = new ArrayList();
		collection2.add("chao");
		collection2.add(121);
		collection2.addAll(collection);
		System.out.println(collection2.size());//5
		System.out.println(collection2);
		
		//isEmpty()�жϼ������Ƿ���Ԫ��
		System.out.println(collection2.isEmpty());
		
		//clear��������е�Ԫ��
		collection2.clear();
		System.out.println(collection2);
		
	}
}
