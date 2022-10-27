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
		
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			if (new Integer(99).equals(object)) {
				iterator.remove();
			}
		}
		
		Iterator iterator1 = collection.iterator();
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
			
		}
		//remove()�������ڱ����Ĺ�����ɾ��ĳԪ��
	}
}
