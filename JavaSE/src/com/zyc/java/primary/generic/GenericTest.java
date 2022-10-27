package com.zyc.java.primary.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Generic���͵ĸ��� <E> E��ʾ���Ͳ�������ʾһ���ࡢ�ӿڵ����ͣ����嵽��һ�����ӿ��еķ�������ֵ���ͣ�������Ͳ�����ʹ��ʱȷ����
 * 
 * ͨ�����?,������ͨ�����εļ��ϣ�����������ݣ��������null����;�����ȡ���ݣ���ȡ������ΪObject
 * 
 * ������������ͨ�����1�� ? extends ĳ����---> ?��ൽ�Ǹ��� <=
 * 				  2�� ? super ĳ����---> ?�������Ǹ���   >=
 * 				  3��   
 * 
* @Description
* @author zyc 
* @version
* @date 2022��5��8������9:28:29
 */
public class GenericTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		stringList.add("������");
		stringList.add("����");
		stringList.add("�����");
		stringList.add("���ľ�");
//		stringList.add(123);//���벻ͨ��
		for (String string : stringList) {
			System.out.println(string);
		}
		
		Map<String,Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("������", 99);
		hashMap.put("������", 98);
		hashMap.put("������", 60);
		hashMap.put("������", 95);
		//���͵�Ƕ��
		Set<Entry<String, Integer>> enteySet = hashMap.entrySet();//�õ�һ��entey���͵�set����
		Iterator<Entry<String, Integer>> iterator = enteySet.iterator();//����������
		while(iterator.hasNext())
		{
			Entry<String, Integer> next = iterator.next();
			String key = next.getKey();
			Integer value = next.getValue();
			System.out.println(key+"--->"+value);//���ս����������--->95
		}
		
		List<Integer> list1 =null;
		List<String> list2 = null;
		List<?> list = null;//ͨ���,string��integer�ǲ��й�ϵ��������?
		list = list1;
		list = list2;
		
	}
}
