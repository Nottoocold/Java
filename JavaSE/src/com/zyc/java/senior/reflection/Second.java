package com.zyc.java.senior.reflection;

public class Second {
	/**
	 * Class���󣬵��������ɺ󣬾ͻ���ȡ�����������Ϣ���ڴ�������һ��Class���󣬴�Class�����뱻���ص���Ψһ��Ӧ����ֻ��һ��
	 * 
	 * ��ȡClass����ķ�ʽ����������
	 */
	public static void main(String[] args) {
		//1.ͨ��class�ؼ���
		Class<Integer> iClass =  Integer.class;
		System.out.println(iClass);
		
		//2.ʹ��Class�ྲ̬����forName()
		try {
			Class<?> name = Class.forName("com.zyc.java.senior.reflection.First");
			System.out.println(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//3.ͨ��ʵ��������
		System.out.println(new Integer(12).getClass());
		
		//һ����ֻ��Ψһһ��Class����
		System.out.println(iClass == (new Integer("123").getClass()));//true
		
		//public static final Class<Integer>  TYPE = (Class<Integer>) Class.getPrimitiveClass("int");
		//����������ȡ����ԭʼ�������ͣ����͵ľ��ǰ�װ��
		System.out.println(int.class);//int
		System.out.println(Integer.TYPE);//ԭʼ�������ͣ�int 
		System.out.println(Integer.class);//��װ���ͣ�class java.lang.Integer
		
		System.out.println(Integer.TYPE == int.class);//true
		System.out.println(Integer.TYPE == Integer.class);//false
		
		System.out.println("-------------------");
		//����Ҳ��һ������
		Class<String[]> clazz = String[].class;
	    System.out.println(clazz.getName());  //��ȡ�����ƣ��õ����ǰ���+�������������ƣ�
	    System.out.println(clazz.getSimpleName());
	    System.out.println(clazz.getTypeName());
	    System.out.println(clazz.getClassLoader());   //��ȡ�����������
	    System.out.println(clazz.cast(new Integer("10")));   //ǿ������ת�� ClassCastException
	}
}
