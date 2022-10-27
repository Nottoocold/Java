package com.zyc.java.senior.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMap {
	/**
	 * Map集合
	 * Node<K,V>,不可重复(K)，无索引,常用实现类，HashMap，LinkedHashMap(HashMap的子类)，TreeMap，Hashtable,Properties(Hashtable的子类)
	 * K 决定了是不是重复元素，K相同的情况下，V会替换原来的V
	 * 
	 * 遍历： 
	 * 1.KetSet(),Key of Set,then V get(K) 
	 * 2.EntrySet(),Map.Entry<K,V> of Set,then loop the Set,get Key and Value.
	 */
	public static void main(String[] args) {
		// 1.HashMap
		Map<String, Integer> map = new HashMap<>();
		map.put("wsad", 22213);
		map.put("nkhd", 922);
		map.put("wsad", 23);
		map.put("ool", 952);
		map.put(null, null);
		// (1)first method
		Set<String> keySet = map.keySet();
		keySet.forEach((s) -> {
			System.out.println("K is " + s + ",V is " + map.get(s));
		});
		// (2)second method
		Set<Entry<String, Integer>> entries = map.entrySet();
		entries.forEach((entry) -> {
			System.out.println("K is " + entry.getKey() + ",V is " + entry.getValue());
		});
		// 2.LinedHashMap
		Map<String, Integer> link = new LinkedHashMap<>();
		link.put("sdl", 322);
		link.put("dl", 322);
		link.put("sdl", 2);
		link.put("sdlewa", 322);

	}
}
