package com.zyc.java.senior.basicstructures.linearlist.abstractlist;

/**
 * 线性表抽象类
 * @author zyc
 */
public abstract class AbstractList<E>{
	/**
	 * 返回线性表中元素个数
	 * @return
	 */
	public abstract int size();
	
	/**
	 * 添加元素，默认表尾添加
	 * @param e E类型元素
	 */
	public abstract void add(E e);
	
	/**
	 * 指定位置添加
	 * @param e
	 * @param index
	 */
	public abstract void add(E e,int index);
	
	/**
	 * 移除指定位置的元素
	 * @param index
	 * @return 移除的元素
	 */
	public abstract E remove(int index);
	
	/**
	 * 移除表尾的元素
	 * @return
	 */
	public abstract E remove();
	
	/**
	 * 获取指定位置的元素
	 * @param index
	 * @return
	 */
	public abstract E get(int index);

}
