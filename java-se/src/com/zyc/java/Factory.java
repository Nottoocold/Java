package com.zyc.java;

/**
 * @author zyc
 * @date 2022/10/23
 */
public abstract class Factory<T> {

    public T newInstance() {
        System.out.println("---");
        T t = get();
        System.out.println("+++");
        return t;
    }

    abstract T get();
}
