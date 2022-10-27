package com.zyc.java.senior.basicstructures.linearlist.queue;

public class TestLinkedQueue {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedQueue<>();
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		queue.offer("E");
		System.out.println(queue.front());
		System.out.println(queue.back());
		queue.poll();
		System.out.println(queue.front());
		System.out.println(queue.back());
	}
}
