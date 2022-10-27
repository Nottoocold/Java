package com.zyc.java.primary.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端的实现
 * 
 *@author zyc
 *com.zyc.java11
 *JavaSE
 *2022年5月12日下午10:36:36
 */
public class ServerTest {
	public static void main(String[] args) {//服务端接受数据
		ServerSocket serverSocket = null;
		Socket acceptSocket = null;
		InputStream inputStream = null;
		
		ByteArrayOutputStream baos = null;
		try {
			serverSocket = new ServerSocket(8811);
			acceptSocket = serverSocket.accept();
			inputStream = acceptSocket.getInputStream();
			baos = new ByteArrayOutputStream();
			byte[] buff = new byte[5];
			int len;
			while ((len = inputStream.read(buff)) != -1) {
				baos.write(buff, 0, len);
			}
			System.out.println(baos.toString());
			System.out.println(acceptSocket.getInetAddress().getHostAddress());//获取客户端的IP
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (acceptSocket != null) {
				try {
					acceptSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
