package com.zyc.java.primary.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Generic泛型的概念 <E> E表示类型参数，表示一个类、接口的类型，具体到到一个类或接口中的方法返回值类型，这个类型参数在使用时确定。
 * 
 * 通配符：?,对于用通配修饰的集合，不能添加数据，除了添加null除外;允许读取数据，读取的数据为Object
 * 
 * 有限制条件的通配符：1、 ? extends 某个类---> ?最多到那个类 <=
 * 				  2、 ? super 某个类---> ?最少是那个类   >=
 * 				  3、   
 * 
* @Description
* @author zyc 
* @version
* @date 2022年5月8日下午9:28:29
 */
public class GenericTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		stringList.add("赵永超");
		stringList.add("范靖");
		stringList.add("郝培辉");
		stringList.add("张文静");
//		stringList.add(123);//编译不通过
		for (String string : stringList) {
			System.out.println(string);
		}
		
		Map<String,Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("赵永超", 99);
		hashMap.put("赵永超", 98);
		hashMap.put("赵永超", 60);
		hashMap.put("赵永超", 95);
		//泛型的嵌套
		Set<Entry<String, Integer>> enteySet = hashMap.entrySet();//得到一个entey类型的set集合
		Iterator<Entry<String, Integer>> iterator = enteySet.iterator();//迭代器遍历
		while(iterator.hasNext())
		{
			Entry<String, Integer> next = iterator.next();
			String key = next.getKey();
			Integer value = next.getValue();
			System.out.println(key+"--->"+value);//最终结果：赵永超--->95
		}
		
		List<Integer> list1 =null;
		List<String> list2 = null;
		List<?> list = null;//通配符,string和integer是并列关系，父类是?
		list = list1;
		list = list2;
		
	}
}
