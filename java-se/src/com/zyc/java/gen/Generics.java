package com.zyc.java.gen;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyc
 * @date 2022/10/15
 */
@SuppressWarnings("unchecked")
public class Generics {

    public static void main(String[] args) throws Exception {
//        List<String>[] list11 = new ArrayList<String>[10]; //编译错误，非法创建
//        List<String>[] list12 = new ArrayList<?>[10]; //编译错误，需要强转类型
        List<String>[] list13 = (List<String>[]) new ArrayList<?>[10]; //OK，但是会有警告
//        List<?>[] list14 = new ArrayList<String>[10]; //编译错误，非法创建
        List<?>[] list15 = new ArrayList<?>[10]; //OK
        List<String>[] list6 = new ArrayList[10]; //OK，但是会有警告
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add("dsa");
        l2.add(2);
        System.out.println(l1.getClass());
        System.out.println(l1.getClass() == l2.getClass());

        /* 通过反射加入不同类型 说明泛型确实在编译后就被擦除了 */
        Method addMethod = l1.getClass().getMethod("add", Object.class);
        addMethod.invoke(l1, 31);

        System.out.println(l1);


        /*不指定泛型的时候*/
        int i = Generics.add(1, 2); //这两个参数都是Integer，所以T为Integer类型
        Number f = Generics.add(1, 1.2); //这两个参数一个是Integer，一个是Float，所以取同一父类的最小级，为Number
        Object o = Generics.add(1, "asd"); //这两个参数一个是Integer，一个是String，所以取同一父类的最小级，为Object

        /*指定泛型的时候*/
        int a = Generics.<Integer>add(1, 2); //指定了Integer，所以只能为Integer类型或者其子类
//        int b = Generics.<Integer>add(1,  2.2); //编译错误，指定了Integer，不能为Float
        Number c = Generics.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float

        ArrayList l = new ArrayList<String>(); // Object

//        test1();
        test2();

        ArrayWithTypeToken<String> arrayWithTypeToken = new ArrayWithTypeToken<>(String.class,10);
        String[] arr = arrayWithTypeToken.create();
        System.out.println(Arrays.toString(arr));
    }

    /*
        Java泛型擦除的原则：
            1.消除类型参数声明，即删除<>及其包围的部分。
            2.根据类型参数的上下界推断并替换所有的类型参数为原生态类型：如果类型参数是无限制通配符或没有上下界限定则替换为Object，
                如果存在上下界限定则根据子类替换原则取类型参数的最左边限定类型（即父类）。
            3.为了保证类型安全，必要时插入强制类型转换代码。
            4.自动产生“桥接方法”以保证擦除类型后的代码仍然具有泛型的“多态性”。
        原始类型的理解：
            就是擦除去了泛型信息，最后在字节码中的类型变量的真正类型，
            无论何时定义一个泛型，相应的原始类型都会被自动提供，类型变量擦除，
            并使用其限定类型（无限定的变量用Object）替换。
        泛型的编译期检查：
            Java编译器是通过先检查代码中泛型的类型，然后在进行类型擦除，再进行编译
            ---类型检查就是针对引用的，谁是一个引用，用这个引用调用泛型方法，就会对这个引用调用的方法进行类型检测，而无关它真正引用的对象
             ArrayList<String> list1 = new ArrayList<>(); 1
             ArrayList list2 = new ArrayList<String>(); 2
            因为类型检查就是编译时完成的，new ArrayList()只是在内存中开辟了一个存储空间，
            可以存储任何类型对象，而真正涉及类型检查的是它的引用，
            因为我们是使用它引用list1来调用它的方法，比如说调用add方法，
            所以list1引用能完成泛型类型的检查。而引用list2没有使用泛型，所以不行。
     */

    public <T> T[] ArrayWithTypeToken(Class<T> type, int size) {
        return (T[]) Array.newInstance(type, size);
    }

    public <T> T newTClass(Class<T> tClass) {
        try {
            Constructor<T> constructor = tClass.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException("实例化泛型类型失败", e);
        }
    }

    public static <T> T show(T arg) {
        return arg;
    }

    //这是一个简单的泛型方法
    public static <T> T add(T x, T y) {
        return y;
    }

    public static void test1() {
        List<String>[] lsa = new List[10]; // Not really allowed.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<>();
        li.add(3);
        oa[1] = li; // Unsound, but passes run time store check
        String s = lsa[1].get(0);// ClassCastException
    }

    /**
     * 采用通配符的方式初始化泛型数组是允许的，
     * 因为对于通配符的方式最后取出数据是要做显式类型转换的，符合预期逻辑。
     * 综述就是说Java 的泛型数组初始化时数组类型不能是具体的泛型类型，
     * 只能是通配符的形式，因为具体类型会导致可存入任意类型对象，在取出时会发生类型转换异常，
     * 会与泛型的设计思想冲突，而通配符形式本来就需要自己强转，符合预期
     */
    public static void test2() {
        List<?>[] lsa = new List<?>[10];
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(3);
        oa[1] = li; // Correct.
        Integer i = (Integer) lsa[1].get(0);
    }

}
