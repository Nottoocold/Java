package com.zyc.java.primary.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * hashtable的子类：properties，常用来处理配置文件，k和v都是string类型
 * 
 * collections : 操作list、set和map的工具类。常用方法：reverse(list)反转---shuffle(list)随机排序---sort(list)---sort(list,comparator)
 * 												swap(list,i,j)
 * 												Object max(collection)---Object max(collection,comparator)
 * 												Object min(collection)---Object min(collection,comparator)
 * 												
 * 												int frequency(collection,object)返回指定集合中指定元素出现的频率
 * 												void copy(list dest,list src)将src复制到dest中
 * 												boolean replaceAll(List list, Object oldvalue, Object newlavue)
 * 
 * collections 提供了多个线程线程同步方法，将线程不安全的集合转换成线程安全的
 * 
* @Description
* @author zyc 
* @version
* @date 2022年5月8日下午7:59:59
 */
public class PropertiesTest {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List srcList = new ArrayList();
		srcList.add(123);
		srcList.add(1);
		srcList.add(2);
		srcList.add(9);
		
		//Source does not fit in dest
//		List destList = new ArrayList();
//		Collections.copy(destList, srcList);
		List destList = Arrays.asList(new Object[srcList.size()]);
		Collections.copy(destList, srcList);
		System.out.println(destList);
		
		
	}
}
