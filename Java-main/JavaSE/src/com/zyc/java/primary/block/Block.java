package com.zyc.java.primary.block;

/**
 * ��ĳ�Ա---����� ----���ã� 
 * 1��������ʼ���ࡢ���� 
 * 2��ֻ��ʹ��static ���� Ĭ��
 * 
 * 3����̬����飺�ڲ������������䣻������ļ��ض�ִ�У���ִֻ��һ�� ----���ã���ʼ���������
 * 4���Ǿ�̬����飺�ڲ������������䣻���Ŷ���Ĵ�����ִ�У�ÿ����һ�������ִ��һ�� ----���ã������ڴ�������ʱ����ʵ�������Խ��г�ʼ��
 * 
 * @author Kidz
 *
 */

public class Block {
	public static void main(String[] args) {
//		String string = Person.descString;
		Person person = new Person();
		Person preson1 = new Person();
		person.info();
		preson1.info();
		System.out.println(person.toString());
		System.out.println(preson1.toString());

	}
}

class Person {
	private String name;
	private int age;
	static String descString;

	// ������
	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// �Ǿ�̬�����
	{
		this.setName("zyc");
		this.setAge(21);
	}

	static // ��̬�����
	{
		descString = "I am happy.";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// ����
	public void eat() {
		System.out.println("�ɷ�");
	}

	public void info() {
		System.out.println(descString);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}