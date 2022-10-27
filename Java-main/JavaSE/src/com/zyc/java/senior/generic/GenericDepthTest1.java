package com.zyc.java.senior.generic;

public class GenericDepthTest1 {
	public static void main(String[] args) {
		/**
		 * ��������:	? �ڷ�������һ�� ͨ��� �ĺ��壬������ʾ,���������������͵�ScoreS������
		 */
		ScoreS<?> score1 = new ScoreS<String>("������", "youxiu");
		ScoreS<?> score2 = new ScoreS<Integer>("hahaha", 1000);
		System.out.println(score1.getScore());//score1.getScore����ֵ������Object
		System.out.println(score2.getScore());
		
		/**
		 * ��������: ���͵Ľ���(�Ͻ�)���涨�˷��Ͳ�����ȡֵ���ͷ�Χ����һ��Լ��,ͬ�� ? Ҳ����Լ��ƥ������ͽ���
		 */
		ScoreT<? extends Number> score3 = new ScoreT<Double>("st123", 1.0);
		System.out.println(score3.getScore());//����ֵ����Number
		
		/**
		 * ��������: ���͵Ľ���(�½�)
		 */
		ScoreE<? super String> score4 = new ScoreE<String>("std1232", "youxiu");
		System.out.println(score4.getScore());//����ֵ����Object
	}
}

class ScoreS<T> {
	String name;
	T score;
	public ScoreS(String name, T score) {
		this.name = name;
		this.score = score;
	}
	public T getScore() {
		return score;
	}
}

class ScoreT<T extends Number> {//�涨��T����ֻ����Number���Լ��������࣬�涨�˷��͵��Ͻ�
	String id;
	T score;
	public ScoreT(String id, T score) {
		this.id = id;
		this.score = score;
	}
	public T getScore() {
		return score;
	}
}

class ScoreE<T> {
	String id;
	T score;
	public ScoreE(String id, T score) {
		this.id = id;
		this.score = score;
	}
	public T getScore() {
		return score;
	}
}
