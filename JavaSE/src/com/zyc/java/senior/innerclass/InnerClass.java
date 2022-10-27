package com.zyc.java.senior.innerclass;

public class InnerClass {
	static String name = "�ⲿ��ľ�̬��Ա";
	String string = "�ⲿ���ʵ����Ա";
	int a = 14;
	/**
	 * ��̬�ڲ���
	 * ʹ�÷�ʽ 		�ⲿ����.�ڲ����� ������ = new �ⲿ��.�ڲ�����();
	 * 1.��̬�ڲ������ֱ�ӷ����ⲿ��ľ�̬��Ա
	 * 2.��̬�ڲ��಻����ֱ�ӷ����ⲿ���ʵ����Ա
	 * @author zyc
	 */
	static class staticClass {
		String in = InnerClass.name;//
		String self = "��̬�ڲ����Լ��ĳ�Ա";
		public staticClass() {
			System.out.println("���Ǿ�̬�ڲ���");
			//System.out.println(new InnerClass().string);
			System.out.println(self);
		}
		
	}
	
	/**
	 * ��Ա�ڲ���,����Ϊ�ⲿ��ĳ�Ա��������static����
	 * ʹ�÷�ʽ��		�ⲿ����.�ڲ�����  ������ = new �ⲿ����().new �ڲ�����();
	 * 1.��Ա�ڲ������ֱ�ӷ����ⲿ��ľ�̬��Ա
	 * 2.��Ա�ڲ�����Է����ⲿ���ʵ����Ա
	 * @author zyc
	 */
	public class fileClass {
		int a  = 13;
		public fileClass() {
			System.out.println("���ǳ�Ա�ڲ���");
		}
		
		void show() {
			System.out.println("�����ⲿ�ྲ̬��Ա��" + name);
			System.out.println("�����ⲿ��ʵ����Ա��" + string);
		}
		
		void test() {
			int a = 12;
			System.out.println(a);//�ֲ�����a 12
			System.out.println(this.a);//��Ա�ڲ����Աa 13 
			System.out.println(InnerClass.this.a);//�ⲿ���Ա 14
		}
	}
}
