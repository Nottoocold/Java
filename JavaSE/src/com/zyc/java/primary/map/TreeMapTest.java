package com.zyc.java.primary.map;

import java.util.TreeMap;

import com.zyc.java.primary.collections.PersonBean;;

/**
 * 想TreeMap中添加数据，要求k必须是同一个类创建的对象，因为要对k进行排序，排序方式：自然排序；定制排序。
* @Description
* @author zyc 
* @version
* @date 2022年5月8日下午6:57:38
 */
public class TreeMapTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		TreeMap treeMap = new TreeMap();
		treeMap.put(new PersonBean("zyc",30), 22);
		treeMap.put(new PersonBean("zyc",22), 23);
		treeMap.put(new PersonBean("zycq"),87);
		/*
		 * Set keySet = treeMap.keySet();//返回所有k构成的set集合 Iterator iterator =
		 * keySet.iterator(); while (iterator.hasNext()) { Object next =
		 * iterator.next();//得到k Object object = treeMap.get(next);//根据k得到v
		 * System.out.println(next+"---->"+object); }
		 */
		
		treeMap.forEach((k,v)->{
			System.out.println(k+"--->"+v);
		});
	}
}
