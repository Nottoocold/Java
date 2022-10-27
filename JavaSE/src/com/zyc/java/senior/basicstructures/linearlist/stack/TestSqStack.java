package com.zyc.java.senior.basicstructures.linearlist.stack;

public class TestSqStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new SqStack<>();
		for(int i = 1; i <= 20; ++i) {
			stack.push(i);
		}
		for(int j = 1; j <= 20; ++j) {
			System.out.println("Õ»¶¥ÔªËØÊÇ: " + stack.Peek());
			System.out.println("µ¯Õ»....");
			stack.pop();
		}
	}
}
