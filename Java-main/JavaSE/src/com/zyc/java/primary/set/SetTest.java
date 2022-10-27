package com.zyc.java.primary.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.zyc.java.primary.collections.PersonBean;
/**
 * Collecction�е��ӽӿ�֮��set�ӿڵ�ʹ��,����hashset����Ҫʵ����
 * 
 * һ��set�洢����ġ������ظ�������
 * 
 * 1�������ԣ�����������ԣ��洢�������ڵײ������а���hashֵ�����洢λ��
 * 
 * 2�������ظ��ԣ���֤��ӵ�Ԫ�ذ���equals�����ж�ʱ�����ܷ���true������ͬ��Ԫ��ֻ����һ��
 * 
 * �������Ԫ�صĹ��̣���hashsetΪ����hashset�ײ������飬��ʼ������16�������Ԫ��ʱ�����ȼ���Ԫ��hashֵ�����㷽ʽ�ǵ���Ԫ���������hashcode��������
 * 					  hashֵ����hashֵͨ��ĳ�ַ����õ����λ�ã�
 * 					  �жϴ�λ���Ƿ��Ѿ���Ԫ�أ������λ����û��Ԫ�أ������a�ɹ���
 * 					  ���������Ԫ��b������Ԫ�أ�����Ƚ�a��b��hashֵ�����a��b��hashֵ��ͬ�������a�ɹ���
 * 					  ���hashֵ��ͬ�������a���������equals������������false������ӳɹ���
 * 
 * 
 * @author zyc
 *
 * 2022��5��5������7:28:58
 */
public class SetTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Set hashSet = new HashSet();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add("z");
		hashSet.add("y");
		hashSet.add("c");
		hashSet.add(new PersonBean("��", 20));
		hashSet.add(new PersonBean("��", 20));
		
		Iterator iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
