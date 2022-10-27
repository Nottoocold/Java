package com.zyc.java.senior.basicstructures.linearlist.abstractlist;

/**
 * ���Ա������
 * @author zyc
 */
public abstract class AbstractList<E>{
	/**
	 * �������Ա���Ԫ�ظ���
	 * @return
	 */
	public abstract int size();
	
	/**
	 * ���Ԫ�أ�Ĭ�ϱ�β���
	 * @param e E����Ԫ��
	 */
	public abstract void add(E e);
	
	/**
	 * ָ��λ�����
	 * @param e
	 * @param index
	 */
	public abstract void add(E e,int index);
	
	/**
	 * �Ƴ�ָ��λ�õ�Ԫ��
	 * @param index
	 * @return �Ƴ���Ԫ��
	 */
	public abstract E remove(int index);
	
	/**
	 * �Ƴ���β��Ԫ��
	 * @return
	 */
	public abstract E remove();
	
	/**
	 * ��ȡָ��λ�õ�Ԫ��
	 * @param index
	 * @return
	 */
	public abstract E get(int index);

}
