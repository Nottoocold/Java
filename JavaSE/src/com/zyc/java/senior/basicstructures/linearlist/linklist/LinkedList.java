package com.zyc.java.senior.basicstructures.linearlist.linklist;

import com.zyc.java.senior.basicstructures.linearlist.abstractlist.AbstractList;

/**
 * 带头节点的单链表
 * @author zyc
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public LinkedList() {
		head = tail = new Node<>(null);
		size = 0;
	}
	
	/**
	 * 获取指定下标节点的直接前驱节点的引用
	 * @param index
	 * @return
	 */
	public Node<E> getPreNode(int index){
		if(head.next == null)
			return null;
		Node<E> node = head;
		int i = 0;
		while(i < index) {
			node = node.next;
			i++;
		}
		return node;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(E e) {
		Node<E> node = new Node<>(e);
		tail.next = node;
		tail = node;
		size++;
	}

	@Override
	public void add(E e, int index) {
		if(index < 0 || index > size)
			throw new IllegalArgumentException("插入位置不合法.");
		if(index == size)
			add(e);
		else {
			Node<E> pre = getPreNode(index);
			Node<E> next = pre.next;
			Node<E> node = new Node<>(e);
			pre.next = node;
			node.next = next;
			size++;
		}
	}

	@Override
	public E remove(int index) {
		if(index < 0 || index > size - 1)
			throw new IllegalArgumentException("index 不合法...");
		if(index == size - 1)
			return remove();
		Node<E> node  = getPreNode(index);
		node.next = node.next.next;
		size--;
		return node.next.e;
	}

	@Override
	public E remove() {
		if(head == tail)
			return null;
		E e = tail.e;
		Node<E> node = getPreNode(size - 1);
		node.next = null;
		tail = node;
		size--;
		return e;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index > size - 1)
			throw new IllegalArgumentException("index 不合法...");
		if(head == tail) {
			System.out.println("空链表");
			return null;
		}
		Node<E> pre = getPreNode(index);
		return pre.next.e;
	}
	
	public void printLinkedList() {
		if(head == tail) {
			System.out.println("空链表！");
		}else {
			Node<E> pNode = this.head.next;
			int i = 0;
			while(i < this.size) {
				System.out.print(pNode.e + " ->");
				pNode = pNode.next;
				++i;
			}
			System.out.println("NULL");
		}
	}
	
	static class Node<E>{
		private E e;
		private Node<E> next;
		public Node(E e) {
			this.e = e;
			next = null;
		}
	}

}
