package com.ting.wong.java.code.practice.generic.vector;

/**
 * 字符串向量
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/1/2
 **/
public abstract class StringVector <V> implements BaseVector <String,V> {

    @Override
    public void doSomeThing(String o, V o2) {
        System.out.println("StringVector doSomeThing");
    }
}
