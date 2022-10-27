package com.zyc.java.primary.thread;

/**
 * �������̵߳ķ��� ͨ����ʹ�ô��ַ�ʽ����Ϊ�̳�ֻ�ܵ��̳�
 * 
 * currentThread()��̬���������ص�ǰ������߳�
 * getName()  setName() ��õ�ǰ�߳�/���õ�ǰ�߳� ������
 * yield() �ͷŵ�ǰcpu��ʹ��Ȩ
 * join() �߳�a�����߳�b��join()������a��������״̬֪��b�߳�ִ�н���
 * stop() �ѹ�ʱ��ǿ�ƽ�����ǰ�߳�
 * sleep(long millitime) ��λms��ָ����ǰ�̡߳�˯�ߡ�millitime��ʱ��
 * isAlive()�жϵ�ǰ�߳��Ƿ񻹴���
 * 
 * �̵߳����ȼ�
 * max 10
 * min 1 
 * normal 5
 * gettPriority()
 * setPriority(int newPriority) ����������ȼ��������Ͽ�����ߵ�
 * 
 * @author Kidz
 *
 */

class MyTest extends Thread {
	@Override
	public void run() {// ��дrun����
		for (int i = 0; i < 50; i++) {
			if (i % 2 != 0) {
				System.out.println("subThread=" + i);
			}
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		MyTest name = new MyTest();// �����������
		name.start();// ����start����,һ��ʵ��ֻ�ܵ���һ��start����
		for (int i = 1; i < 50; i++) {
			if (i % 2 != 0) {
				System.out.println("mainThread=" + i);// ÿ�����ж��᲻һ��
			}
		}

	}

}
