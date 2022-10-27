package com.zyc.java.senior.generic;

public class GenericClassTest {

	/**
	 * Java泛型是一种语法糖，是让编译器帮我们做类型转换，避免了自己操作时会排除类型转换异常的困扰，减少了代码书写量，优雅！
	 */
	public static void main(String[] args) {
		Score<Integer> score1 = new Score<Integer>("zhao", "EP12331", 100);//泛型不可以使用基本数据类型
		Score<String> score2 = new Score<String>("zhao永", "EP1231", "youxiu");
		Score<Double> score3 = new Score<Double>("zhao永超", "EP13131", 85.5);
		System.out.println(score1);
		System.out.println(score2);
		System.out.println(score3);
	}
}

class Score<T> {//定义泛型类
	String name;
	String id;
	private T score;//泛型成员，泛型成员不能使用static修饰，因为static属性属于类自己，而泛型的类型只能在实例化后才能确定
	public Score(String name, String id, T score) {
		super();
		this.name = name;
		this.id = id;
		this.score = score;
	}
	public T getScore() {//类的泛型方法
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