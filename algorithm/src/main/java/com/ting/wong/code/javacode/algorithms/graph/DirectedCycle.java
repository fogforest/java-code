package com.ting.wong.code.javacode.algorithms.graph;

import java.util.Stack;

/**
 * @author Ting Wong
 * @version 1.0
 * @date 2018/11/24
 * @description 有向无环图
 **/
public class DirectedCycle {
    /**
     * 以顶点为索引，值代表了该顶点是否标记过（是否可达）
     */
    private boolean[] marked;
    /**
     * 用来存储有向环顶点。
     */
    private Stack<Integer> cycle;
    // *****重点理解这里start****
    /**
     * edgeTo[0]=1代表顶点1->0, to 0的顶点为1。
     */
    private int[] edgeTo;
    // *****重点理解这里end****
    /**
     * 顶点为索引，值为该顶点是否参与dfs递归，参与为true
     */
    private boolean[] onStack;

    public DirectedCycle(Digraph digraph) {
        // 初始化成员变量
        marked = new boolean[digraph.getTopSize()];
        onStack = new boolean[digraph.getTopSize()];
        edgeTo = new int[digraph.getTopSize()];
        cycle = null;
        // 检查是否有环
        for (int v = 0; v < digraph.getTopSize(); v++) {
            dfs(digraph, v);
        }
    }

    private void dfs(Digraph digraph, int v) {
        // 递归开始，顶点上栈
        onStack[v] = true;
        marked[v] = true;
        // 遍历一条边，v-> w
        for (int w : digraph.adj(v)) {
            // 终止条件：找到有向环
            // 使用onStack标志位来记录有效路径上的点，如果w在栈上，说明w在前面当了出发点，
            if (hasCycle()) {
                return;
            }

            if (!marked[w]) {
                // to w的顶点为v
                edgeTo[w] = v;
                dfs(digraph, w);
                // 如果指到了已标记的顶点，且该顶点递归栈上。（栈上都是出发点，而找到了已标记的顶点是终点，说明出发点和终点相同了。）
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                //起点在第一次循环中已经push了，不要重复
                for (int x = v; x != w; x = edgeTo[x]) {
                    // 将由v出发，w结束的环上中间的结点遍历push到cycle中。
                    cycle.push(x);
                }
                // push终点
                cycle.push(w);
            }
        }
        // 当递归开始结算退出时，顶点下栈。
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        Digraph d = new Digraph(6);
        d.addEdge(0, 1);
        d.addEdge(1, 2);
        d.addEdge(2, 3);
        d.addEdge(3, 0);
        DirectedCycle directedCycle = new DirectedCycle(d);
        if (directedCycle.hasCycle()) {
            for (int a : directedCycle.cycle()) {
                System.out.println(a);
            }
        } else {
            System.out.println("DAG");
        }
    }

}
