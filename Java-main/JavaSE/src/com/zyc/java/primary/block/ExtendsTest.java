package com.zyc.java.primary.block;

/**
 * ��̬��һ����Ϊ����
 * ��̬�г�Ա�����ص�:
 * 	1.������ ���뿴��ߣ����п��ұ�
 * 	2.������ ���뿴��ߣ�����Ҳ�����	(������Ϊ��̬)
 * @author zyc
 *
 */
public class ExtendsTest {

	public static void main(String[] args) {
		A a = new B(12);//��̬
		a.test();//test�������ǹ��еķ��������������
		//a.name();//�������еĹ��ܣ�������ʹ��
		a.a();//����ֱ��ʹ�ø��������еķ���
		B b = (B)a;
		b.name();
		System.out.println(a.toString());
	}
}

class A {
	int a;
	int b;
	
	public A() {
		System.out.println("A Construct..");
	}
	
	public A(int b) {
		a = 20;
		this.b = b;
	}
	
	public void a() {
		System.out.println("A ����...");
	}
	
	void test() {
		System.out.println("A test method...");
	}

	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}
}

class B extends A{
	
	public B() {
		System.out.println("B Construct..");
	}
	
	public B(int b){
		super(b);
	}
	
	void test() {
		System.out.println("B test method...");
	}

	void name() {
		System.out.println("B ����...");
	}

	@Override
	public String toString() {
		return "B �� A �ĳ�Ա [a=" + a + ", b=" + b + "]";
	}
	
}