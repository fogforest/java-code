package com.ting.wong.javacode.algorithms.bag;

import java.util.Iterator;

/**
 * @author Ting Wong
 * @version 1.0
 * @date 2018/11/24
 * @description 背包
 **/
public class Bag<T> implements Iterable<T> {

    private class BagNode<T> {
        T item;
        BagNode next;
    }

    BagNode head;
    int size;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            BagNode node = head;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                T item = (T) node.item;
                node = node.next;
                return item;
            }
        };
    }

    public Bag() {
        head = new BagNode();
        size = 0;
    }

    /**
     * 往前插入
     *
     * @param item
     */
    public void add(T item) {
        BagNode temp = new BagNode();
        // 以下两行代码一定要声明，不可直接使用temp = head，那样temp赋值的是head的引用，对head的所有修改会直接同步到temp，temp就不具备缓存的功能，引发bug。。
        temp.next = head.next;
        temp.item = head.item;
        head.item = item;
        head.next = temp;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        Bag<String> bags = new Bag();
        bags.add("hello");
        bags.add("yeah");
        bags.add("liu wen bin");
        bags.add("seminar");
        bags.add("1243");
        System.out.println(bags.size);

        for (Iterator i = bags.iterator(); i.hasNext(); ) {
            System.out.println(i.next());
        }

        // 由于Bag实现了Iterable接口，所以支持以下方式遍历
        for (String a : bags) {
            System.out.println(a);
        }
    }

}
