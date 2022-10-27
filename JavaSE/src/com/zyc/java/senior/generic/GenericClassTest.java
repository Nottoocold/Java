package com.zyc.java.senior.generic;

public class GenericClassTest {

	/**
	 * Java������һ���﷨�ǣ����ñ�����������������ת�����������Լ�����ʱ���ų�����ת���쳣�����ţ������˴�����д�������ţ�
	 */
	public static void main(String[] args) {
		Score<Integer> score1 = new Score<Integer>("zhao", "EP12331", 100);//���Ͳ�����ʹ�û�����������
		Score<String> score2 = new Score<String>("zhao��", "EP1231", "youxiu");
		Score<Double> score3 = new Score<Double>("zhao����", "EP13131", 85.5);
		System.out.println(score1);
		System.out.println(score2);
		System.out.println(score3);
	}
}

class Score<T> {//���巺����
	String name;
	String id;
	private T score;//���ͳ�Ա�����ͳ�Ա����ʹ��static���Σ���Ϊstatic�����������Լ��������͵�����ֻ����ʵ���������ȷ��
	public Score(String name, String id, T score) {
		super();
		this.name = name;
		this.id = id;
		this.score = score;
	}
	public T getScore() {//��ķ��ͷ���
		return score;
	}
	public void setScore(T score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Score [name=" + name + ", id=" + id + ", score=" + score + "]";
	}
	
}