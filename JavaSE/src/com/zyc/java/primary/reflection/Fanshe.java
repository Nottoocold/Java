package com.zyc.java.primary.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Java�������
 * 
 * ͨ��ֱ��new�ķ�ʽ������ƶ����Ե��ù��������ԣ�Ӧ�����ĸ���
 * ������new�ķ�ʽ
 * 
 * ʲôʱ���÷��䣿
 * ��̬�ԣ�������ʱ����ȷ����Ҫ�ĸ�����ʱ���Ϳ����÷���
 * 
 * ���˷�����ƺ���ǰ��ķ�װ���ǲ���ì�ܣ���ο���������������
 * ��ì�ܡ���װ���ǽ������ô���õ����⣬�������ǽ���ܲ��ܵ������⡣
 * 
 * Class������
 * �����Դͷ��
 * 1�������ھ���javac�����������ֽ����ļ�(.class)��
 * Ȼ��ʹ��java��ĳ���ֽ����ļ����н������У��൱�ڽ�ĳ���ֽ����ļ����ص��ڴ��У�
 * �˹��̾ͳ�����ļ��أ����ص��ڴ��е��࣬�ͳ�Ϊ����ʱ�࣬������ʱ�࣬����ΪClass��һ��ʵ����
 * 2��Class��ʵ���Ͷ�Ӧ��һ������ʱ�࣬����ʱ��Ỻ��һ��ʱ�䣬�ڴ�ʱ���ڿ���ͨ����ͬ��ʽ��ȡ������ʱ��
 * 3����λ�ȡClass��ʵ������ʽ��4�֡�
 * ��1��Class<T> p = Person.class
 * ��2��ͨ������ʱ��Ķ���Class class1 = p.getClass();
 * ��3������Class�ľ�̬������Class.forName(String classpath);���·������+������ --->����
 * ��4��ʹ����ļ�����:Classloader,
 * 		Classloader loader = Person.class.getClassLoader();
 * 		Class c = loader.loadClass(String classpath);
 * 
 * @author zyc
 *com.zyc.java12
 *JavaSE
 * 2022��5��13������10:24:02
 */
public class Fanshe {
	public static void main(String[] args) throws Exception {
		//������Ƶ���ʾ
		//�������֮ǰ�����ܵ������ڲ���˽�г�Ա
//		Person p = new Person("������",20);
//		p.setAge(22);
//		p.show();
//		System.out.println(p.toString());
		
		ClassLoader classLoader = Fanshe.class.getClassLoader();//��ȡ��ļ�����,ϵͳ�������
		System.out.println(classLoader);
		ClassLoader parent = classLoader.getParent();//��ȡ��һ�������������չ�������
		System.out.println(parent);
		ClassLoader parent2 = parent.getParent();
		System.out.println(parent2);//null����ȡ���������������
		//�������֮��
		Class<Person> class1 =  Person.class;
		//����public��Ĭ�����ԣ�������������
		//ͨ�����䣬����person��Ķ���
		Constructor<Person> perConstructor = class1.getConstructor(String.class,int.class);//��ȡָ�������б�Ĺ�����
		Person p1 =  perConstructor.newInstance("������",21);//��������
		System.out.println(p1.toString());//���ö���ķ���
		//ͨ�����䣬���ö���ָ�������Ժͷ���
		Field age = class1.getDeclaredField("age");//��ȡ������
		age.set(p1, 22);//��������
		System.out.println(p1.toString());//���÷���
		
		Method show = class1.getDeclaredMethod("show");//��ȡ��ĳ�Ա����
		show.invoke(p1);//����ָ����ķ���
		
		System.out.println("----------");
		
		//ͨ�����䣬���Ե������ڲ���˽�г�Ա
		Constructor<Person> nameconstructor = class1.getDeclaredConstructor(String.class);//����˽�еĹ�����
		nameconstructor.setAccessible(true);
		Person p2 = nameconstructor.newInstance("Tom");//�����
		p2.setAge(20);
		System.out.println(p2);
		
		Field nameField = class1.getDeclaredField("name");//����˽�еĳ�Ա����
		nameField.setAccessible(true);
		nameField.set(p2, "Tomcat");//�޸�˽�еĳ�Ա����
		System.out.println(p2);
		
		Method shownation = class1.getDeclaredMethod("shownation",String.class);//��ȡ˽�еķ���
		shownation.setAccessible(true);
		String nation = (String)shownation.invoke(p2, "�й���");//����˽�еķ�����invoke()�����ķ���ֵ���ǵ�ǰ���õķ����ķ���ֵ
		System.out.println(nation);
		
		//��������ľ�̬������ֻ����invoke()�������������뵱ǰ����ʱ�������,Person.class
	}
}
