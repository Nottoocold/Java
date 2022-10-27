package com.zyc.java.senior.basicstructures.linearlist.linklist;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList<String> link = new LinkedList<>();
		link.add("zhao");
		link.add("yong");
		link.add("chao");
		link.add("qqq",0);
		link.add("ppp",4);
		link.printLinkedList();
		link.remove();
		link.remove(2);
		link.printLinkedList();
		System.out.println(link.get(1));
		LinkedList<String> link1 = new LinkedList<>();
		link1.printLinkedList();
	}
}
