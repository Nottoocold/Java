package com.zyc.java.senior.basicstructures.linearlist.queue;

public interface Queue<E> {

	//���
	void offer(E e);
	
	//����
	E poll();
	
	//���ض�ͷԪ��
	E front();
	
	//���ض�βԪ��
	E back();
}
