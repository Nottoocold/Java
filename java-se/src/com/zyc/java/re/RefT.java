package com.zyc.java.re;

/**
 * @author zyc
 * @date 2022/10/15
 */
public class RefT {
    private final String name;

    public String age;
    Integer iage;

    public RefT() {
        this.name = null;
    }

    public RefT(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int inc() {
        return iage + 1;
    }

}
