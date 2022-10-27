package com.zyc.java.senior.basicstructures.linearlist.arraylist;

import java.util.Arrays;

import com.zyc.java.senior.basicstructures.linearlist.abstractlist.AbstractList;

public class ArrayList<E> extends AbstractList<E>{
	private Object[] local= {};//�ڲ�����
	
	private final int DEFAULTSIZE = 10;//��ʼ����
	private final int INCREATEMENTSIZE = 4;//��������
	private int size;//Ԫ�ظ���
	
	public ArrayList() {
		local = new Object[DEFAULTSIZE];
		size = 0;
	}
	
	/**
	 * ����Ƿ���Ҫ����
	 */
	private void ensureCapacity() {
		if(size >= local.length)
			local = Arrays.copyOf(local, local.length + INCREATEMENTSIZE);
	}
	
	/**
	 * �����±��Ϸ��׳���ʾ��Ϣ
	 * @param index �����±�����
	 * @return
	 */
    private String outOfBoundsMsg(int index) {
        return "Param index is: "+index+",but List.size is: "+size;
    }
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(E e) {
		ensureCapacity();
		local[size++] = e;
	}

	@Override
	public void add(E e, int index) {
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
		ensureCapacity();
		int lastIndex = size - 1;
		while(lastIndex >= index) {
			local[lastIndex + 1] = local[lastIndex];
			--lastIndex;
		}
		local[index] = e;
		++size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if(index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		if(index == size - 1)
			return remove();
		E e = (E)local[index];
		int i = index;
		while(i < size - 1) {
			local[i] = local[i + 1];
			++i;
		}
		size--;
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove() {
		if(size == 0)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(size));
		E e = (E)local[size - 1];
		--size;
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		return (E)local[index];
	}
	
	@Override
	public String toString() {
		if (size == 0)
			return "[]";
		int last = size - 1;
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for (int i = 0; i < size; i++) {
			buffer.append(String.valueOf(local[i]));
			if(i == last){
				buffer.append("]");
				break;
			}
			buffer.append(",");
		}
		return buffer.toString();
	}
}
