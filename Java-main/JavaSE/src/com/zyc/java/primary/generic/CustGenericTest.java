package com.zyc.java.primary.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * �Զ��巺��(�ࡢ�ӿںͷ���);�����ڼ̳�ʱҲ��̳з��ͣ�����������ʵ����ʱ��ָ������,����Ҳ�����ڼ̳е�ͬʱ�Զ����Լ��ķ��ͣ�Ҳ���Բ��ּ̳и���ķ���
 * 
 * ���ͷ������ڷ����г����˷��ͽṹ�����Ͳ�������ķ��Ͳ���û���κι�ϵ�������ͷ��������������ǲ��Ƿ����ಢû�й�ϵ;���ͷ�����������Ϊ��̬�ģ���Ϊ���Ͳ������ڵ���ʱȷ���ģ�������ʵ����
 * 			��ʱȷ����
 * 
 * �����ڼ̳з�������֣�
 * 
* @Description
* @author zyc 
* @version
* @date 2022��5��8������10:06:17
 */
public class CustGenericTest {

	public <E> List<E> getArraytoList(E[] arr){//�Զ��巺�ͷ�����ָ���Ƿ����ķ���ֵ�Ƿ��͵�
		List<E> list = new ArrayList<>();
		for (E e : arr) {
			list.add(e);
		}
		return list;
}
	public static void main(String[] args) {
		Order<Integer> order = new Order<Integer>("zyc", 10, Integer.valueOf(20));
		System.out.println(order.getOrderT());
		Order<String> order2 = new Order<String>("qwe", 12, "zyc");
		System.out.println(order2.getOrderT());
		CustGenericTest custGenericTest = new CustGenericTest();
		String[] arr = new String[] {"dasfasdasda"};
		List<String> list = custGenericTest.getArraytoList(arr);
		System.out.println(list);
		
	}
}

class Order<T> {
		
	private String name;
	private int id;
	private T orderT;
	
	public Order() {
		super();
	}

	public Order(String name, int id, T orderT) {
		super();
		this.name = name;
		this.id = id;
		this.orderT = orderT;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public T getOrderT() {
		return orderT;
	}

	public void setOrderT(T orderT) {
		this.orderT = orderT;
	}
	
}


class subOrder extends Order<Integer> {
	public subOrder() {
		super();
	}
}