package com.zyc.java.primary.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型(类、接口和方法);子类在继承时也会继承泛型，除非在子类实例化时就指定类型,子类也可以在继承的同时自定义自己的泛型，也可以部分继承父类的泛型
 * 
 * 泛型方法：在方法中出现了泛型结构，泛型参数与类的泛型参数没有任何关系，即泛型方法与所属的类是不是泛型类并没有关系;泛型方法可以声明为静态的，因为泛型参数是在调用时确定的，并非在实例化
 * 			类时确定的
 * 
 * 泛型在继承方面的体现：
 * 
* @Description
* @author zyc 
* @version
* @date 2022年5月8日下午10:06:17
 */
public class CustGenericTest {

	public <E> List<E> getArraytoList(E[] arr){//自定义泛型方法，指的是方法的返回值是泛型的
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