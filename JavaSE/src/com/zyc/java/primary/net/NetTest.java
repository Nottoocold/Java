package com.zyc.java.primary.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络编程：两个要素：1、IP和端口号  2、网络通信协议（OSI/TCP-IP）
 * 
 *IP地址的实例：InetAddress-->创建类对象，得到一个IP;
 *IP和端口号组成了一个套接字，socket
 *
 *网络协议：传输层：TCP  网络层：IP
 * 
 * UDP：不可靠的数据传输。
 * 
 * @author zyc
 *com.zyc.java11
 *JavaSE
 * 2022年5月12日下午2:52:48
 */
public class NetTest {
	public static void main(String[] args) {
		try {
			//本地回路地址，对应着localhost
			InetAddress byName = InetAddress.getByName("127.0.0.1");//私有化的构造器，getLocalHost()
			InetAddress byName1 = InetAddress.getByName("www.google.com");
			System.out.println(byName);
			System.out.println(byName1);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
