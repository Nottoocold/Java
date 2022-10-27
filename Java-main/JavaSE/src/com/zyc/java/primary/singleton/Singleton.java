package com.zyc.java.primary.singleton;

/**
 * �������ģʽ�����ַ�ʽ
 * 
 * @author Kidz
 *
 */

// ����ʽʵ��
public class Singleton {
	public static void main(String[] args) {
		Bank bank1 = Bank.Instance();
		Bank bank2 = Bank.Instance();
		System.out.println(bank1 == bank2);
	}

	static class Bank {
		// �������ģʽ����ֻ����һ������һ��ʵ��
		// ����1������2������3....
		private static final Bank instance;

		// 1��˽�л�������
		private Bank() {

		}

		static {
			// 2���ڲ�������Ķ���
			instance = new Bank();
		}

		// 3���ṩ�����ķ������������ʵ��
		public static Bank Instance() {
			return instance;
		}
	}

}