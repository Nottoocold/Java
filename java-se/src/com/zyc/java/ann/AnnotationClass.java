package com.zyc.java.ann;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyc
 * @date 2022/10/15
 */
@Log(title = "--", desc = "++")
public class AnnotationClass {

    @Log(title = "old static method", desc = "deprecated old static method")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @Log(title = "test method", desc = "suppress warning static method")
    public static void genericsTest() throws FileNotFoundException {
        List<String> l = new ArrayList<>();
        l.add("abc");
        oldMethod();
    }

    @Override
    @Log(title = "toString", desc = "重写Object toString方法")
    public String toString() {
        return "Annotation Class ";
    }
}
