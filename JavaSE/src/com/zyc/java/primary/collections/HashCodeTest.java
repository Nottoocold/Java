package com.zyc.java.primary.collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection�ӿڷ���
 * @author Kidz
 *
 */
public class HashCodeTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Collection collection = new ArrayList();
		collection.add("zhao");
		collection.add(false);
		collection.add("yong");
		collection.add("chao");
		collection.add(1999);
		collection.add(new PersonBean("tom"));
		collection.add(new PersonBean("������", 22));
		
		//hashcode()����hashֵ
		System.out.println(collection.hashCode());
		
		//toArray()����ת��Ϊ����
		Object arr[] = collection.toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//����ת��Ϊ���ϣ�����arrays���еľ�̬����asList()
		
		
		
		
	}
}
