package com.ting.wong.code.java.core.utils.collections;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;

/**
 * 测试类
 *
 * @author Ting Wong
 * @version 1.0
 **/
public class UtilsTest {

    public static void main(String[] args) {
        ArrayList<String> strings = Lists.newArrayList();
        if(CollectionUtils.isEmpty(strings)){
            System.out.println("empty");
        }
    }

}
