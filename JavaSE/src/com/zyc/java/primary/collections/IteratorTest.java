package com.zyc.java.primary.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * iterator�������ӿ����ڱ������ϵ�Ԫ��
 * 
 * @author modua
 *
 */
public class IteratorTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Collection collection = new ArrayList();
		collection.add("zhao");
		collection.add("yong");
		collection.add("chao");
		collection.add(1999);
		collection.add(99);

		collection.removeIf(object -> Integer.valueOf(99).equals(object));

		for (Object o : collection) {
			System.out.println(o);

		}
		//remove()�������ڱ����Ĺ�����ɾ��ĳԪ��
	}
}
