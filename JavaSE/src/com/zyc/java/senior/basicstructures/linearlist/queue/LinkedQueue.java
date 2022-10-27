package com.zyc.java.senior.basicstructures.linearlist.queue;

import com.zyc.java.senior.basicstructures.linearlist.linklist.LinkedList;

/**
 * ��ͷ������ʽ����
 * @author zyc
 * @param <E> ������Ԫ������
 */
public class LinkedQueue<E> extends LinkedList<E> implements Queue<E>{
	
	public LinkedQueue() {
		super();
	}

	@Override
	public void offer(E e) {
		add(e);
	}

	@Override
	public E poll() {
		return remove(0);
	}

	@Override
	public E front() {
		return get(0);
	}

	@Override
	public E back() {
		return get(size() - 1);
	}

}
