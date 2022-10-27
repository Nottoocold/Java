package com.zyc.java.primary.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * hashtable�����ࣺproperties�����������������ļ���k��v����string����
 * 
 * collections : ����list��set��map�Ĺ����ࡣ���÷�����reverse(list)��ת---shuffle(list)�������---sort(list)---sort(list,comparator)
 * 												swap(list,i,j)
 * 												Object max(collection)---Object max(collection,comparator)
 * 												Object min(collection)---Object min(collection,comparator)
 * 												
 * 												int frequency(collection,object)����ָ��������ָ��Ԫ�س��ֵ�Ƶ��
 * 												void copy(list dest,list src)��src���Ƶ�dest��
 * 												boolean replaceAll(List list, Object oldvalue, Object newlavue)
 * 
 * collections �ṩ�˶���߳��߳�ͬ�����������̲߳���ȫ�ļ���ת�����̰߳�ȫ��
 * 
* @Description
* @author zyc 
* @version
* @date 2022��5��8������7:59:59
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
