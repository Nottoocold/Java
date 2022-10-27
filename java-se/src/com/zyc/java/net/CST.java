package com.zyc.java.net;

import java.util.concurrent.TimeUnit;

public class CST {
	
	public static void main(String[] args) throws InterruptedException {
		Server server = new Server("localhost", 9090, 50);
		Client client = new Client("localhost", 9090);
		Thread serverThread = new Thread(server::start, "服务器线程");
		serverThread.start();
		TimeUnit.SECONDS.sleep(2);
		Thread clienThread = new Thread(client::start, "客户端线程");
		clienThread.start();
	}
}
