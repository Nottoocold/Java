package com.zyc.java.primary.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.zyc.java.primary.collections.PersonBean;
/**
 * Collecction中的子接口之二set接口的使用,其中hashset是主要实现类
 * 
 * 一、set存储无序的、不可重复的数据
 * 
 * 1、无序性：不等于随机性，存储的数据在底层数组中按照hash值决定存储位置
 * 
 * 2、不可重复性：保证添加的元素按照equals方法判断时，不能返回true，即相同的元素只能有一个
 * 
 * 二、添加元素的过程：以hashset为例，hashset底层是数组，初始长度是16，在添加元素时，首先计算元素hash值，计算方式是调用元素所属类的hashcode方法计算
 * 					  hash值，此hash值通过某种方法得到存放位置，
 * 					  判断此位置是否已经有元素，如果此位置上没有元素，则添加a成功；
 * 					  如果有其他元素b（或多个元素），则比较a与b的hash值，如果a与b的hash值不同，则添加a成功；
 * 					  如果hash值相同，则调用a的所属类的equals方法，若返回false，则添加成功。
 * 
 * 
 * @author zyc
 *
 * 2022年5月5日下午7:28:58
 */
public class SetTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Set hashSet = new HashSet();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add("z");
		hashSet.add("y");
		hashSet.add("c");
		hashSet.add(new PersonBean("赵", 20));
		hashSet.add(new PersonBean("赵", 20));
		
		Iterator iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
