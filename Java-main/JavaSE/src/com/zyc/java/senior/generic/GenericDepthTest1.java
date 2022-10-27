package com.zyc.java.senior.generic;

public class GenericDepthTest1 {
	public static void main(String[] args) {
		/**
		 * 泛型深入:	? 在泛型中是一种 通配符 的含义，如下所示,可以引用任意类型的ScoreS对象了
		 */
		ScoreS<?> score1 = new ScoreS<String>("赵永超", "youxiu");
		ScoreS<?> score2 = new ScoreS<Integer>("hahaha", 1000);
		System.out.println(score1.getScore());//score1.getScore返回值类型是Object
		System.out.println(score2.getScore());
		
		/**
		 * 泛型深入: 泛型的界限(上界)，规定了泛型参数的取值类型范围，是一种约束,同样 ? 也可以约束匹配的类型界限
		 */
		ScoreT<? extends Number> score3 = new ScoreT<Double>("st123", 1.0);
		System.out.println(score3.getScore());//返回值类型Number
		
		/**
		 * 泛型深入: 泛型的界限(下界)
		 */
		ScoreE<? super String> score4 = new ScoreE<String>("std1232", "youxiu");
		System.out.println(score4.getScore());//返回值类型Object
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

class ScoreT<T extends Number> {//规定了T类型只能是Number类自己及其子类，规定了泛型的上界
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
