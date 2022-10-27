package com.zyc.java.primary.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * 创建线程的第三种方法 ：实现callable接口 
 * 			第四种方法： 使用线程池 executor类  executorService是线程池的入口处
 */

class NumThread implements Callable<Object> {

	@Override
	public Object call() throws Exception {
		int sum = 0;
		for (int i = 0; i <= 50; i++) {
			sum += i;
		}
		return sum;
	}

}

public class ThreadTest2 {
	public static void main(String[] args) {
		NumThread thread = new NumThread();// new 实现了callable接口的实现类对象

		FutureTask<?> futureTask = new FutureTask<Object>(thread);// 使用futureTask类 传入实现callable接口的类对象
		new Thread(futureTask).start();//启动线程
		//以下不是必须的
		try {
			Object object = futureTask.get();
			System.out.println(object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
