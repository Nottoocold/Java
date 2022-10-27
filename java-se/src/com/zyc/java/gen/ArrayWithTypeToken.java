package com.zyc.java.gen;

import java.lang.reflect.Array;

/**
 * 优雅地初始化一个泛型数组
 * @author zyc
 * @date 2022/10/15
 */
public class ArrayWithTypeToken<E> {
    private E[] arr;

    @SuppressWarnings("unchecked")
    public ArrayWithTypeToken(Class<E> type, int size) {
         arr = (E[]) Array.newInstance(type, size);
    }

    public E[] create() {
        return arr;
    }
}
