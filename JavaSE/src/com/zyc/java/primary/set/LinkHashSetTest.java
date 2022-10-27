package com.zyc.java.primary.set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.zyc.java.primary.collections.PersonBean;

/**
 * set接口的实现类之二Linkedhashset,是hashset的子类，底层原理还是hashset只不过元素与元素之间在逻辑上是线性表（双向链表）
 * 
 * @author zyc
 *
 * 2022年5月5日下午8:28:58
 */
public class LinkHashSetTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Set linkhashSet = new LinkedHashSet();
		linkhashSet.add(1);
		linkhashSet.add(2);
		linkhashSet.add(3);
		linkhashSet.add("z");
		linkhashSet.add("y");
		linkhashSet.add("c");
		linkhashSet.add(new PersonBean("赵", 20));
		linkhashSet.add(new PersonBean("赵", 20));
		
		Iterator iterator = linkhashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
