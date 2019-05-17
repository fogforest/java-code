package com.ting.wong.java.code.practice.generic.vector;

/**
 * 密度字符向量
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/1/2
 **/
public class DenseStringVector extends StringVector<Integer> {

    @Override
    public void doSomeThing(String o, Integer o2) {
        System.out.println("DenseStringVector doSomeThing");
    }

    public static void main(String[] args) {
        DenseStringVector dsv = new DenseStringVector();
        dsv.doSomeThing("test", 0);
    }


}
