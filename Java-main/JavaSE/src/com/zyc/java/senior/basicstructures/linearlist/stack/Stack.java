package com.zyc.java.senior.basicstructures.linearlist.stack;

public interface Stack<E>{
	/**
	 * Ñ¹Õ»
	 * @param e
	 * @return
	 */
	boolean push(E e);
	
	/**
	 * µ¯Õ»
	 * @return µ¯³öÕ»¶¥ÔªËØ
	 */
	E pop();
	
	/**
	 * »ñÈ¡Õ»¶¥ÔªËØ
	 * @return
	 */
	E Peek();
}
