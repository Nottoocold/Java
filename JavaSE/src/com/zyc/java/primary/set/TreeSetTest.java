package com.zyc.java.primary.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import com.zyc.java.primary.collections.PersonBean;

/**
 * set�ӿ�ʵ����֮��treeSet���ײ�ʵ�ֺ����
 * 				���԰�����Ӷ����ָ�����ԣ���������
 * @author zyc
 *
 * 2022��5��5������8:38:49
 */

public class TreeSetTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		/*
		 * ��treeSet��ӵ����ݱ�������ͬ���͵�
		 * 
		 */
//		Set treeSet = new TreeSet();
//		treeSet.add(new PersonBean("tom", 10));
//		treeSet.add(new PersonBean("ja", 13));
//		treeSet.add(new PersonBean("m", 40));
//		treeSet.add(new PersonBean("om", 30));
//		treeSet.add(new PersonBean("a", 20));
//		treeSet.add(new PersonBean("a", 50));
//		/*
//		 * Java���ֱȽϷ�������Ȼ����Ͷ�������
//		 * ��Ȼ�����У��Ƚ��������Ƿ���ͬ�ı�׼�ǣ�compareTo()���� 0��������equals����
//		 */
//		Iterator iterator = treeSet.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
		
		//�������򣬰�����������,������һ������������
		Comparator comparator = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof PersonBean && o2 instanceof PersonBean) {
					PersonBean p1 = (PersonBean)o1;
					PersonBean p2 = (PersonBean)o2;
					return Integer.compare(p1.getAge(), p2.getAge());
				}else {
					throw new RuntimeException("....");
				}
			}
		};
		
		TreeSet treeSet = new TreeSet(comparator);
		treeSet.add(new PersonBean("tom", 10));
		treeSet.add(new PersonBean("zyc", 13));
		treeSet.add(new PersonBean("mm", 10));//������
		treeSet.add(new PersonBean("jack", 30));
		treeSet.add(new PersonBean("aim", 20));
		treeSet.add(new PersonBean("aak", 50));
		
		Iterator iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
