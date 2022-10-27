package com.zyc.java.senior.reflection;

import com.zyc.java.senior.reflection.po.Computer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class newInstance {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, 
														NoSuchMethodException, SecurityException, 
														IllegalArgumentException, InvocationTargetException {
		/**
		 * ʹ��Class��������������
		 */
		Class<Computer> clazz = Computer.class;
		/*
		 * ����Ĭ�ϵĹ��췽�������ι��츲��ʱ,�׳�InstantiationException�쳣
		 * ��Ĭ���޲ι�������˽�л�ʱ���׳�IllegalAccessException�쳣
		 */
		//��������
		/*Computer computer = clazz.newInstance();
		computer.start();
		computer.shut();*/
		
		//������ʽ���Ƽ����������·�ʽ
		Constructor<Computer> constructor = clazz.getConstructor(String.class, Double.class);
		Computer computer = constructor.newInstance("MSI",5500.0);
		computer.start();
		computer.shut();
		System.out.println(computer.toString());
		
		/**
		 * �����췽������Ȩ�޲���ʱ��ʹ��`getDeclaredConstructor()`���������ҵ����еķ�public���췽����
		 * ������ʹ��֮ǰ��������Ҫ���޸ķ���Ȩ�ޣ����޸ķ���Ȩ��֮�󣬾Ϳ���ʹ�÷�public�����ˣ�����ζ�ţ������������Ȩ�����η�����������ݣ�
		 */
		
	}

}
