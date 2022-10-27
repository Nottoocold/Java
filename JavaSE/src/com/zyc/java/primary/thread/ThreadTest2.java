package com.zyc.java.primary.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * �����̵߳ĵ����ַ��� ��ʵ��callable�ӿ� 
 * 			�����ַ����� ʹ���̳߳� executor��  executorService���̳߳ص���ڴ�
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
		NumThread thread = new NumThread();// new ʵ����callable�ӿڵ�ʵ�������

		FutureTask<?> futureTask = new FutureTask<Object>(thread);// ʹ��futureTask�� ����ʵ��callable�ӿڵ������
		new Thread(futureTask).start();//�����߳�
		//���²��Ǳ����
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
