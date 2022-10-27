package com.zyc.java.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class NetU {

	public static void getIPByName(String name) {
		InetAddress ipAddress = null;
		try {
			ipAddress = InetAddress.getByName(name);
			System.out.println(ipAddress);
			System.out.println("HostName " + ipAddress.getHostName() + " HostAddress " + ipAddress.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println("未知的 " + name);
		}
	}

	public static boolean isSocketAlive(String hostname, int port) {
		boolean isAlive = false;
		SocketAddress stk = new InetSocketAddress(hostname, port);
		Socket socket = new Socket();
		int timeout = 2000;
		try {
			log("hostname:" + hostname + " , port:s" + port);
			socket.connect(stk, timeout);
			socket.close();
			isAlive = true;
		} catch (IOException e) {
			System.out.println("IOException Cannot connect to " + hostname + " : " + port + ". " + e.getMessage());
		}
		return isAlive;
	}

	private static void log(String s) {
		System.out.println(s);
	}
	

}
