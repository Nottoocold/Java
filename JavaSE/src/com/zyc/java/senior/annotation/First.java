package com.zyc.java.senior.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@MyCustom
public class First {
	/**
	 * ע����Ա���ע������ط������������ϡ������ϡ������ϡ���Ա�����ϡ�ע�ⶨ���ϵȣ�����ע��һ�������൱�����Ƕ�ĳ��������һ����ǡ�
	 * ����ע�Ͳ�ͬ���ǣ�ע�����ͨ������������ʱ��ȡ��ע��Ҳ����ѡ���Ƿ���������ʱ��
	 * 
	 * JavaԤ��ע�⣺
	 * 	- @Override - ��飨�����Ǽ�飬������������ʱ���÷����Ƿ�����д��������������丸�࣬���������õĽӿ��в�û�и÷���ʱ���ᱨ�������
		- @Deprecated - ��ǹ�ʱ���������ʹ�ø÷������ᱨ���뾯�档
		- @SuppressWarnings - ָʾ������ȥ����ע���������ľ��棨�����������׶Σ�������������ʱ��
		- @FunctionalInterface - Java 8 ��ʼ֧�֣���ʶһ��������������ʽ�ӿڡ�
		- @SafeVarargs - Java 7 ��ʼ֧�֣������κ�ʹ�ò���Ϊ���ͱ����ķ������캯�����ò����ľ��档
	 *
	 *Ԫע�⣺Ԫע����������ע���ϵ�ע�⣬�������Ǳ�д�Զ����ע��
	 *	- @Retention - ��ʶ���ע����ô���棬��ֻ�ڴ����У����Ǳ���class�ļ��У�������������ʱ����ͨ��������ʡ�
		- @Documented - �����Щע���Ƿ�������û��ĵ��С�
		- @Target - ������ע��Ӧ�������� Java ��Ա��
		- @Inherited - ������ע���Ǽ̳����ĸ�ע����(Ĭ�� ע�Ⲣû�м̳����κ�����)
		- @Repeatable - Java 8 ��ʼ֧�֣���ʶĳע�������ͬһ��������ʹ�ö�Ρ�
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 *
	 */
	/*
	 *	@Override ע��Ķ��塣
	 *  @Target(ElementType.METHOD)
		@Retention(RetentionPolicy.SOURCE)
		public @interface Override {
			}
		ElementType��ö���࣬����ָ��ע��������õ�Ŀ��
		RetentionPolicy��ö���ָ࣬����ע�����������  SOURCE CLASS RUNTIME
		
	 */
	
	@MyCustom("aaa")
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName("com.zyc.java.senior.annotation.Student");
		Annotation[] annotations = clazz.getAnnotations();
		for(Annotation a: annotations) {
			System.out.println(a.annotationType());   //��ȡ����
	        System.out.println(a instanceof MyCustom);   //ֱ���ж��Ƿ�ΪMyCustom
	        MyCustom my = (MyCustom) a;
	        System.out.println(Arrays.toString(my.value()));
		}
		
		Class<?> c = First.class;
		Annotation[] annotations2 = c.getAnnotations();
		for(Annotation a1 : annotations2) {
			System.out.println(Arrays.toString(((MyCustom)a1).value()));
		}
		
		//��ȡ������ע��
		Annotation[] annotations3 = clazz.getMethod("name").getAnnotations();
		for(Annotation mAnnotation : annotations3) {
			System.out.println(mAnnotation.annotationType());
			System.out.println(mAnnotation instanceof MyCustom);
			System.out.println(Arrays.toString(((MyCustom)mAnnotation).value()));
		}
	}
}
