package com.zyc.java.primary.thread;

import java.lang.Thread;
/*
 * ����ʵ����runnable�ӿڵ���
 * 
 * �ڴ�����ʵ��runnable�ӿ��е�run()����
 * ����ʵ����Ķ���
 * ����thread����󣬽��˶�����Ϊ��������thread�����������У�
 * ����thread���е�start����
 * 
 * �̵߳İ�ȫ���⣬��Java��ͨ��ͬ������������̵߳İ�ȫ����
 * ���������
 * 			1��ͬ�������  synchronized(ͬ��������){ ��Ҫ��ͬ���Ĵ���(ͨ��Ϊ����������Դ�Ĵ���) } 
 * 									ͬ��������(��lock)�κ�һ����Ķ��󶼿��Գ䵱��,Ҫ�����̱߳��빲��ͬһ����
 * 									���ܻ����ĳ���̵߳ò�������
 * 			2��ͬ������    �������������ݵĵĴ���������һ�������У�����Խ��˷�������Ϊͬ����  synchronized
 * 			3��Lock����ʽ  ����һ��ReentrantLock �Ķ��� lock.lock();  lock.unlock()
 */

class Mythread implements Runnable {
	private int ticket = 200;
	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if (ticket > 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "Ʊ��Ϊ��" + ticket);
					ticket--;
				} else {
					break;
				}
			}
		}
	}
}

public class ThreadTest1 {
	public static void main(String[] args) {
		Mythread m = new Mythread();
		Thread thread = new Thread(m);
		thread.setName("����1");
		Thread thread2 = new Thread(m);
		thread2.setName("����2");
		Thread thread3 = new Thread(m);
		thread3.setName("����3");
		thread.start();
		thread2.start();
		thread3.start();
	}
}
