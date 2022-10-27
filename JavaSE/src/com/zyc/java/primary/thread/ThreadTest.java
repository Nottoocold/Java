package com.zyc.java.primary.thread;

/**
 * 创建多线程的方法 通常不使用此种方式，因为继承只能单继承
 * 
 * currentThread()静态方法，返回当前代码的线程
 * getName()  setName() 获得当前线程/设置当前线程 的名称
 * yield() 释放当前cpu的使用权
 * join() 线程a调用线程b的join()方法，a进入阻塞状态知道b线程执行结束
 * stop() 已过时，强制结束当前线程
 * sleep(long millitime) 单位ms，指定当前线程“睡眠”millitime的时间
 * isAlive()判断当前线程是否还存在
 * 
 * 线程的优先级
 * max 10
 * min 1 
 * normal 5
 * gettPriority()
 * setPriority(int newPriority) 概率提高优先级，整体上看是提高的
 * 
 * @author Kidz
 *
 */

class MyTest extends Thread {
	@Override
	public void run() {// 重写run方法
		for (int i = 0; i < 50; i++) {
			if (i % 2 != 0) {
				System.out.println("subThread=" + i);
			}
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		MyTest name = new MyTest();// 创建子类对象
		name.start();// 调用start方法,一个实例只能调用一次start方法
		for (int i = 1; i < 50; i++) {
			if (i % 2 != 0) {
				System.out.println("mainThread=" + i);// 每次运行都会不一样
			}
		}

	}

}
