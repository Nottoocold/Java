package com.zyc.java;

/**
 * @author zyc
 * @date 2022/10/23
 */
public class SinglePattern {

    private SinglePattern() {
        super();
    }

    private static class SingleHolder {
        private static final SinglePattern SINGLE_PATTERN = new SinglePattern();
    }

    public static SinglePattern getInstance() {
        return SingleHolder.SINGLE_PATTERN;
    }

}
