package com.zyc.java.senior.basicstructures.linearlist.stack;

public interface Stack<E>{
	/**
	 * ѹջ
	 * @param e
	 * @return
	 */
	boolean push(E e);
	
	/**
	 * ��ջ
	 * @return ����ջ��Ԫ��
	 */
	E pop();
	
	/**
	 * ��ȡջ��Ԫ��
	 * @return
	 */
	E Peek();
}
