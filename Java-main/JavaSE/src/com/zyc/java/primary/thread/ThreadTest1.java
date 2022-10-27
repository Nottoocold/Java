package com.zyc.java.primary.thread;

import java.lang.Thread;
/*
 * 创建实现了runnable接口的类
 * 
 * 在此类中实现runnable接口中的run()方法
 * 创建实现类的对象
 * 创建thread类对象，将此对象作为参数传入thread方法构造器中，
 * 调用thread类中的start方法
 * 
 * 线程的安全问题，在Java中通过同步机制来解决线程的安全问题
 * 解决方法：
 * 			1、同步代码块  synchronized(同步监视器){ 需要被同步的代码(通常为操作共享资源的代码) } 
 * 									同步监视器(锁lock)任何一个类的对象都可以充当锁,要求多个线程必须共用同一把锁
 * 									可能会造成某个线程得不到处理
 * 			2、同步方法    若操作共享数据的的代码声明在一个方法中，则可以将此方法声明为同步的  synchronized
 * 			3、Lock锁方式  创建一个ReentrantLock 的对象 lock.lock();  lock.unlock()
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
					System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
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
		thread.setName("窗口1");
		Thread thread2 = new Thread(m);
		thread2.setName("窗口2");
		Thread thread3 = new Thread(m);
		thread3.setName("窗口3");
		thread.start();
		thread2.start();
		thread3.start();
	}
}
