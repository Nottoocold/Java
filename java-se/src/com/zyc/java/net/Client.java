package com.zyc.java.net;

import java.io.*;
import java.net.Socket;

public class Client {
	private final String hostName;
	private final int port;
	private Socket clientsSocket;

	public Client(String hostName, int port) {
		this.hostName = hostName;
		this.port = port;
	}

	public void start() {
		String threadName = Thread.currentThread().getName();
		System.out.println(
				threadName + ",连接服务器：" + hostName + ":" + port);
		try {
			clientsSocket = new Socket(hostName, port);
			System.out.println("连接服务器成功!");
			OutputStream out = clientsSocket.getOutputStream();
			DataOutputStream ds = new DataOutputStream(out);
			ds.writeUTF("hello server is from client " + clientsSocket.getLocalAddress());

			InputStream in = clientsSocket.getInputStream();
			DataInputStream di = new DataInputStream(in);
			String resp = di.readUTF();
			System.out.println("服务器响应数据：" + resp);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				clientsSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + ", 通信结束");
		}
	}
}
