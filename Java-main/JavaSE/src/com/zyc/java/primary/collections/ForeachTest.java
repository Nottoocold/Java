package com.zyc.java.primary.collections;

import java.util.ArrayList;
import java.util.Collection;
/**
 * foreach ��������Ԫ�صķ���
 * 
* @Description
* @author zyc 
* @version
* @date 2022��5��5������11:30:13
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
		
		//for(����Ԫ������  �ֲ����� :  ���϶���)
		for (Object object : collection) {
			System.out.println(object);
		}
	}
}
