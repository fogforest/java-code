package com.ting.wong.code.javacore.test;

/**
 * 测试接口和继承
 *
 * @author Ting Wong
 * @version 1.0
 * 2019/2/27
 **/
public class extendsTest {

    public static void main(String[] args) {
        Interf interf = new Interf() {
            @Override
            public void interfMethod() {
                System.out.println("run anonymous Class interf method ");
            }
        };
        AbstractBase base =new AbstractBase() {
            @Override
            public void baseMethod() {
                System.out.println("run anonymous Class AbstractBase method ");
            }
        };
    }
}
