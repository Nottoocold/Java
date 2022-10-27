package com.zyc.java.senior.finalcollection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestFC {
	/**
	 * 不可变集合,不可被修改的集合
	 */
	@SafeVarargs
	public static <T> List<T> createUnModifyList(T...elements){
		return Collections.unmodifiableList(Arrays.asList(elements));
	}
	
	@SafeVarargs
	public static <T> Set<T> createUnModifySet(T...elements){
		return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(elements)));
	}
	
	public static void main(String[] args) {
		List<Integer> list = createUnModifyList(2,314,31,45,123,454);
		System.out.println(list);
		//list.add(2);	//UnsupportedOperationException
	}
}
