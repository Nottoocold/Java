package com.zyc.java.primary.map;

import java.util.TreeMap;

import com.zyc.java.primary.collections.PersonBean;;

/**
 * ��TreeMap��������ݣ�Ҫ��k������ͬһ���ഴ���Ķ�����ΪҪ��k������������ʽ����Ȼ���򣻶�������
* @Description
* @author zyc 
* @version
* @date 2022��5��8������6:57:38
 */
public class TreeMapTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		TreeMap treeMap = new TreeMap();
		treeMap.put(new PersonBean("zyc",30), 22);
		treeMap.put(new PersonBean("zyc",22), 23);
		treeMap.put(new PersonBean("zycq"),87);
		/*
		 * Set keySet = treeMap.keySet();//��������k���ɵ�set���� Iterator iterator =
		 * keySet.iterator(); while (iterator.hasNext()) { Object next =
		 * iterator.next();//�õ�k Object object = treeMap.get(next);//����k�õ�v
		 * System.out.println(next+"---->"+object); }
		 */
		
		treeMap.forEach((k,v)->{
			System.out.println(k+"--->"+v);
		});
	}
}
