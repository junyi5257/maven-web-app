package cn.junyi.mavenWeb.bean;

import java.util.Arrays;

/**
 * Created by goujy on 11/30/16.
 */
public class Chap5 {
    static void printArr(Object[] args) {
        for (Object obj : args) {
            System.out.print(obj + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //printArr(new Object[]{new Integer(23), new Float(3.14), new Double(6.98)});
        printArr(new Object[]{"one", "two", "three"});
        //printArr(new Object[]{new A(), new A(), "444", 565});

        newPrintArr(23, 543, 675);
        newPrintArr("AAA", "BBB", "CCC");
        newPrintArr(new A(), new A());
        newPrintArr((Object[]) new Integer[]{231, 5454, 767});
        newPrintArr();
        newPrintArr("2342");
        System.out.println("-----------------");
        intArr(242, 535, 53, 555, 64);
    }

    /**
     * 可变参数数组 Object
     *
     * @param args 数组
     */
    private static void newPrintArr(Object... args) {
        for (Object obj : args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    /**
     * int 可变参数
     * @param args int数组
     */
    private static void intArr(int... args) {
        System.out.println(args.getClass());
        System.out.println(args.length);
        for (int j : args) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    /**
     * 测试方法
     * @param arg1 字符串
     * @param args int 数组
     */
    static void strAndIntArr(String arg1, int... args) {
        System.out.println(arg1 + "===" + Arrays.toString(args));
    }

}

class A {
    public static void main(String[] args) {

        System.out.println("==========Class===A===start");
       // Chap5.main(args);
       // Chap7.main(args);
        //System.out.println("==========Class===A====end");
        //Chap6 c6 = null;
        System.out.println(((Chap6)null).PROTECTED);

        System.out.println((Chap6.PROTECTED));
    }

}