package com.zyc.java.primary.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * �����̣�����Ҫ�أ�1��IP�Ͷ˿ں�  2������ͨ��Э�飨OSI/TCP-IP��
 * 
 *IP��ַ��ʵ����InetAddress-->��������󣬵õ�һ��IP;
 *IP�Ͷ˿ں������һ���׽��֣�socket
 *
 *����Э�飺����㣺TCP  ����㣺IP
 * 
 * UDP�����ɿ������ݴ��䡣
 * 
 * @author zyc
 *com.zyc.java11
 *JavaSE
 * 2022��5��12������2:52:48
 */
public class NetTest {
	public static void main(String[] args) {
		try {
			//���ػ�·��ַ����Ӧ��localhost
			InetAddress byName = InetAddress.getByName("127.0.0.1");//˽�л��Ĺ�������getLocalHost()
			InetAddress byName1 = InetAddress.getByName("www.google.com");
			System.out.println(byName);
			System.out.println(byName1);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
