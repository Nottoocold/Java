package com.zyc.java.primary.collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * collection�ӿڷ���
 * @author Kidz
 *
 */
public class Collectiontest2 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Collection collection = new ArrayList();//����
		collection.add(99);
		collection.add("zhao");
		collection.add(false);
		collection.add("yong");
		collection.add("chao");
		collection.add(1999);
		collection.add(new PersonBean("tom"));
		collection.add(new PersonBean("������", 22));
		
		//contains(Object obj)�ж�obj�Ƿ��ڼ�����
		System.out.println(collection.contains("chao"));
		System.out.println(collection.contains(new PersonBean("tom")));//false--��Ҫ��дobject���е�equal����-->true
		//containAll(Collrction coll) �ж�coll������Ԫ���Ƿ񶼴����ڵ�ǰ������
		
		
		//remove(Object obj) �Ƴ�ĳ��Ԫ��
		collection.remove("zhao");
		collection.remove(99);
		System.out.println(collection.contains("zhao"));//false
		
		//removeAll(Collection coll)�ӵ�ǰ�������Ƴ�coll�е�Ԫ��
		
		//retainAll(Collection coll)��ǰ������coll�Ľ���,�����ṹ���ظ���ǰ����
		
		//equals(Objeect obj)�Ƚ���������
		
		
	}
}
