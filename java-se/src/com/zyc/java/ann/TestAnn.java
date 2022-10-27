package com.zyc.java.ann;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author zyc
 * @date 2022/10/15
 */
@Log(title = "-----", desc = "++++++")
public class TestAnn {

    public static void main(String[] args) throws Exception {
        Log declaredAnnotation = TestAnn.class.getDeclaredAnnotation(Log.class);
        System.out.println(declaredAnnotation);
        Method[] methods = AnnotationClass.class.getClassLoader()
                .loadClass("com.zyc.java.ann.AnnotationClass")
                .getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Log.class)) {
                for (Annotation annotation : m.getAnnotations()) {
                    System.out.println("Annotation in method " + m.getName() + ": " + annotation);
                }
                Log log = m.getAnnotation(Log.class);
                System.out.println(log.title() + ": " + log.desc());
            }
        }
    }
}
