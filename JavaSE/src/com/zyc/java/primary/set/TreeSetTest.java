package com.zyc.java.primary.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import com.zyc.java.primary.collections.PersonBean;

/**
 * set接口实现类之三treeSet，底层实现红黑树
 * 				可以按照添加对象的指定属性，进行排序
 * @author zyc
 *
 * 2022年5月5日下午8:38:49
 */

public class TreeSetTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		/*
		 * 向treeSet添加的数据必须是相同类型的
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
//		 * Java两种比较方法：自然排序和定制排序
//		 * 自然排序中，比较两对象是否相同的标准是：compareTo()返回 0，不再是equals方法
//		 */
//		Iterator iterator = treeSet.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
		
		//定制排序，按照年龄排序,若年龄一样，丢弃后者
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
		treeSet.add(new PersonBean("mm", 10));//被丢弃
		treeSet.add(new PersonBean("jack", 30));
		treeSet.add(new PersonBean("aim", 20));
		treeSet.add(new PersonBean("aak", 50));
		
		Iterator iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
