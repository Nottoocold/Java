package com.zyc.java.senior.lambda;

public class TestLambda {
	
	public static void Lambda(This m) {
		System.out.println("Lambda���ʽ......");
		m.Mymethod();
		System.out.println("Lambda���ʽ��������");
	}
	
	public static void main(String[] args) {
		/**
		 * lambda ���ʽΪ�˼򻯴�����д���÷���ʽ��
		 * 					(�����ڲ��౻��д�������β��б�) -> {����д�����ķ�����}
		 * ע�⣺lambda���ʽֻ�ܼ򻯺���ʽ�ӿڵ������ڲ����д����ʽ
		 */
		//ͨ�����
		This m = new This() {
			
			@Override
			public void Mymethod() {
				System.out.println("ͨ�����");
			}
		};
		Lambda(m);
		
		System.out.println();
		
		//��һ����
		This m1 = ()->{
			System.out.println("��һ����");
		};
		Lambda(m1);
		
		System.out.println();
		
		//ֱ����Ϊ���
		Lambda(new This() {
			@Override
			public void Mymethod() {
				System.out.println("ֱ����Ϊ���������");
			}
		});
		
		System.out.println();
		
		//���հ汾
		Lambda(()->{
			System.out.println("���ռ򻯵���ʽ");
		});
	}
}

@FunctionalInterface //ʹ�ô�ע����ӿڱ����Ǻ���ʽ�ӿ�
interface This{
	void Mymethod();
}