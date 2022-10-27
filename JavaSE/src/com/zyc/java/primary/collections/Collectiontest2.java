package com.zyc.java.primary.collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * collection接口方法
 * @author Kidz
 *
 */
public class Collectiontest2 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Collection collection = new ArrayList();//有序
		collection.add(99);
		collection.add("zhao");
		collection.add(false);
		collection.add("yong");
		collection.add("chao");
		collection.add(1999);
		collection.add(new PersonBean("tom"));
		collection.add(new PersonBean("赵永超", 22));
		
		//contains(Object obj)判断obj是否在集合中
		System.out.println(collection.contains("chao"));
		System.out.println(collection.contains(new PersonBean("tom")));//false--需要重写object类中的equal方法-->true
		//containAll(Collrction coll) 判断coll中所有元素是否都存在于当前集合中
		
		
		//remove(Object obj) 移除某个元素
		collection.remove("zhao");
		collection.remove(99);
		System.out.println(collection.contains("zhao"));//false
		
		//removeAll(Collection coll)从当前集合中移除coll中的元素
		
		//retainAll(Collection coll)求当前集合与coll的交集,并将结构返回给当前集合
		
		//equals(Objeect obj)比较两个集合
		
		
	}
}
