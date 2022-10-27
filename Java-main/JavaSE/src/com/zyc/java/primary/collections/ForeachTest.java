package com.zyc.java.primary.collections;

import java.util.ArrayList;
import java.util.Collection;
/**
 * foreach 遍历集合元素的方法
 * 
* @Description
* @author zyc 
* @version
* @date 2022年5月5日上午11:30:13
 */
public class ForeachTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Collection collection = new ArrayList();
		collection.add("zhao");
		collection.add("yong");
		collection.add("chao");
		collection.add(1999);
		collection.add(99);
		
		//for(集合元素类型  局部变量 :  集合对象)
		for (Object object : collection) {
			System.out.println(object);
		}
	}
}
