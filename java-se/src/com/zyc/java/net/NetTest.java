package com.zyc.java.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zyc
 * @date 2022年10月14日
 */
public class NetTest {
	
	public static void main(String[] args) {
		/*
		 * NetU.getIPByName("www.google.com"); NetU.getIPByName("www.baidu.com");
		 * NetU.getIPByName("www.zyc.com"); boolean isAlive =
		 * NetU.isSocketAlive("www.google.com", 8080); System.out.println(isAlive);
		 * isAlive = NetU.isSocketAlive("www.baidu.com", 8080);
		 * System.out.println(isAlive); getLocal();
		 */
		getLocal();
		getCon();
		url();
		urlHead();
		resolveURL();
	}

	public static void getLocal() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("HostAddress :" + address.getHostAddress());
			System.out.println("HostName :" + address.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static void getCon() {
		try {
			InetAddress addr;
			Socket sock = new Socket("www.runoob.com", 80);
			addr = sock.getInetAddress();
			System.out.println("连接到 " + addr);
			sock.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * 连接url
	 */
	public static void url() {
		try {
			URL url = new URL("http://www.runoob.com");
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				writer.write(line);
				writer.newLine();
			}
			reader.close();
			writer.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取资源的响应头信息
	 */
	public static void urlHead() {
		try {
			URL url = new URL("http://www.runoob.com");
			URLConnection conn = url.openConnection();

			Map<String, List<String>> headers = conn.getHeaderFields();
			Set<String> keys = headers.keySet();
			for (String key : keys) {
				String val = conn.getHeaderField(key);
				System.out.println(key + "    " + val);
			}
			System.out.println(conn.getLastModified());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 解析url
	 */
	public static void resolveURL() {
		URL url = null;
		try {
			url = new URL("http://www.runoob.com/html/html-tutorial.html");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("URL 是 " + url.toString());
		System.out.println("协议是 " + url.getProtocol());
		System.out.println("文件名是 " + url.getFile());
		System.out.println("主机是 " + url.getHost());
		System.out.println("路径是 " + url.getPath());
		System.out.println("端口号是 " + url.getPort());
		System.out.println("默认端口号是 " + url.getDefaultPort());
	}
}
