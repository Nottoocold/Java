package com.zyc.java.primary.collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection接口方法
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
		collection.add(new PersonBean("赵永超", 22));
		
		//hashcode()计算hash值
		System.out.println(collection.hashCode());
		
		//toArray()集合转换为数组
		Object arr[] = collection.toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//数组转变为集合，调研arrays类中的静态方法asList()
		
		
		
		
	}
}
