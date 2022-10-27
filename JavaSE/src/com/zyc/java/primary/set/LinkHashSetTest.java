package com.zyc.java.primary.set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.zyc.java.primary.collections.PersonBean;

/**
 * set�ӿڵ�ʵ����֮��Linkedhashset,��hashset�����࣬�ײ�ԭ����hashsetֻ����Ԫ����Ԫ��֮�����߼��������Ա�˫������
 * 
 * @author zyc
 *
 * 2022��5��5������8:28:58
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
		linkhashSet.add(new PersonBean("��", 20));
		linkhashSet.add(new PersonBean("��", 20));
		
		Iterator iterator = linkhashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
