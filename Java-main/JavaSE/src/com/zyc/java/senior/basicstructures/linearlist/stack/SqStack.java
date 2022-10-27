package com.zyc.java.senior.basicstructures.linearlist.stack;

import com.zyc.java.senior.basicstructures.linearlist.arraylist.ArrayList;

public class SqStack<E> extends ArrayList<E> implements Stack<E>{

	public SqStack() {
		super();
	}
	
	@Override
	public boolean push(E e) {
		add(e);
		return true;
	}

	@Override
	public E pop() {
		return remove();
	}

	@Override
	public E Peek() {
		return get(this.size() - 1);
	}
	
}
