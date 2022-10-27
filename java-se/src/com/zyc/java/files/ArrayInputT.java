package com.zyc.java.files;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/**
 * @author zyc
 * @date 2022/10/16
 */
public class ArrayInputT {

    public static void main(String[] args) {
        String name = "QWERTY";
        ByteArrayInputStream bais = new ByteArrayInputStream(name.getBytes());
        System.out.println("name字符串转为字节数组是：" + Arrays.toString(name.getBytes()));
        byte[] ret = new byte[20];
        int i = bais.read(ret, 1, ret.length - 1);
        System.out.println("读取到的字节数： " + i);
        System.out.println("字节数组ret的内容是：" + Arrays.toString(ret));
    }
}

