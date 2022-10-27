package com.zyc.java.primary.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 
 * 网络编程：实现客户端发送信息给服务端
 * 
 *@author zyc
 *com.zyc.java11
 *JavaSE
 *2022年5月12日下午10:30:17
 */
public class ClientTest {//客户端发送数据
	public static void main(String[] args) {
		Socket socket = null;
		OutputStream outStream = null;
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			socket = new Socket(address, 8811);
			outStream = socket.getOutputStream();
			outStream.write("你好，我是客户端！".getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (outStream != null) {
				try {
					outStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
}
