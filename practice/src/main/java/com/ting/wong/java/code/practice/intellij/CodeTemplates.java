package com.ting.wong.java.code.practice.intellij;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ting
 * @version 1.0
 * @create 2018-11-04 20:07
 * @description 常用模板
 */
public class CodeTemplates {

    /**
     * prsf
     */
    private static final CodeTemplates CODE_TEMPLATES = new CodeTemplates();
    /**
     * psf
     */
    public static final CodeTemplates P_CODE_TEMPLATES = new CodeTemplates();
    /**
     * psfi
     */
    public static final int A = 0;

    /**
     * psfs
     */
    public static final String B = "b";

    /**
     *   pric
     *   带注释的私有变量
    */
    private int a;



    /**
     * psvm
     */
    public static void main(String[] args) {
        soutTest(args);
        forTest();
        listTest();
        nullTest();

    }

    /**
     * test 自己生成的模板
     */
    public void testTeplate () {

    }

    private static void nullTest() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //ifn
        if (list == null) {

        }
        //inn
        if (list != null) {

        }
        //XXX.nn /XXX.null
        if (list != null) {

        }
        if (list == null) {

        }
    }

    private static void listTest() {
        //List循环
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //list.for
        for (String s : list) {
            System.out.println(s);
        }
        //list.fori
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //list.forr
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    private static void forTest() {
        String[] arr = new String[]{"Tom", "Mikey", "Chars"};
        //for循环
        //fori
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //iter
        for (String s : arr) {
            System.out.println(s);
        }
        //itar
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            System.out.println(s);
        }
    }

    private static void soutTest(String[] args) {
        //System.out
        //sout
        System.out.println("Hello World!");
        int a = 0;
        //soutp
        System.out.println("args = [" + args + "]");
        //soutv
        System.out.println("a = " + a);
        //soutm
        System.out.println("CodeTemplates.main");
        //a.sout
        System.out.println(a);
    }


}
