package com.zyc.java.primary.thread;

class Windows extends Thread {
	private static int ticket = 100;

	public Windows() {
		super();
	}

	public Windows(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (true) {
			if (ticket > 0) {
				System.out.println(getName() + " :: " + ticket);
				ticket--;
			} else {
				break;
			}
		}
	}
}

public class TicketTest {
	public static void main(String[] args) {
		Windows w1 = new Windows("����1");
		Windows w2 = new Windows("����2");
		Windows w3 = new Windows("����3");
		w1.start();
		w2.start();
		w3.start();
	}
}
