package com.zyc.java.senior.basicstructures.linearlist.queue;

public interface Queue<E> {

	//入队
	void offer(E e);
	
	//出队
	E poll();
	
	//返回队头元素
	E front();
	
	//返回队尾元素
	E back();
}
