package com.ting.wong.code.javacode.algorithms.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Ting Wong
 * @version 1.0
 * @date 2018/11/24
 * @description 栈
 **/
public class Stack<T> implements Iterable<T> {
    private int SIZE;
    /**
     * 栈顶
     */
    private Node first;

    /**
     * 初始化成员变量
     */
    public Stack() {
        SIZE = 0;
        first = null;
    }

    private class Node {
        private T item;
        private Node next;
    }

    /**
     * 栈：往first位置插入新元素
     *
     * @param item
     */
    public void push(T item) {
        Node temp = first;
        first = new Node();
        first.item = item;
        first.next = temp;
        SIZE++;
    }

    /**
     * 栈：从first位置取出新元素，满足LIFO，后进先出。
     *
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        T item = first.item;
        first = first.next;
        SIZE--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return this.SIZE;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node node = first;

            @Override
            public boolean hasNext() {
                return first != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = node.item;
                node = node.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("heyheyhey");
        stack.push("howau");
        stack.push("231");
        System.out.println(stack.SIZE);
        System.out.println(stack.pop());
    }
}
