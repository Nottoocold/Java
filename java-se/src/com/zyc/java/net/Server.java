package com.zyc.java.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private final int port;
	private final String hostName;
	private final int backlog;
	private ServerSocket serverSocket = null;

	public Server(String hostName, int port, int backlog) {
		this.port = port;
		this.hostName = hostName;
		this.backlog = backlog;
		init();
	}

	private void init() {
		try {
			serverSocket = new ServerSocket(port, backlog, InetAddress.getByName(hostName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		String serverName = Thread.currentThread().getName();
		System.out.println(serverName + ",等待客户端连接...端口为：" + serverSocket.getLocalPort());
		try (Socket socket = serverSocket.accept();
				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();
				DataInputStream dis = new DataInputStream(in);) {
			System.out.println("客户端地址是：" + socket.getRemoteSocketAddress());
			System.out.println("客户端发的数据是：" + dis.readUTF());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF("OK!,你连接成功了,GoodBye!");
			dos.close();
			System.out.println(serverName + ",一次套接字数据通信连接结束.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
