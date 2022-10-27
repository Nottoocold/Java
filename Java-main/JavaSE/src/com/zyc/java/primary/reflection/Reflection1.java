package com.zyc.java.primary.reflection;
/**
 * �����Ӧ�ã���̬����
 * 
 *@author zyc
 *com.zyc.java12
 *JavaSE
 *2022��5��14������10:48:43
 */

interface clothFactory{
	void producecloth();
}

//������
class Proxy implements clothFactory{
	private clothFactory clothfac;//�ñ������������г�ʼ��
	
	public Proxy(clothFactory clothfac) {
		this.clothfac = clothfac;
	}

	@Override
	public void producecloth() {
		System.out.println("�������ʼ��");
		clothfac.producecloth();
		System.out.println("����������������");
	}
}
//��������
class antaCloth implements clothFactory{
	@Override
	public void producecloth() {
		System.out.println("��̤��������Ь��");
	}
}

public class Reflection1 {
	//��̬�������
	public static void main(String[] args) {
		clothFactory antaCloth = new antaCloth();//���������������
		clothFactory proxy = new Proxy(antaCloth);//�������������
		proxy.producecloth();
	}
}
