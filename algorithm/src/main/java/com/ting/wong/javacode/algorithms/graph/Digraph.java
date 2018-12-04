package com.ting.wong.javacode.algorithms.graph;

import com.ting.wong.javacode.algorithms.bag.Bag;

/**
 * @author Ting Wong
 * @version 1.0
 * @date 2018/11/24
 * @description 图
 **/
public class Digraph {

    /**
     * 顶点总数，定义final，第一次初始化以后不可更改。
     */
    private int topSize = 10;
    /**
     * 边总数
     */
    private int sideSize;
    /**
     * {邻接表}顶点为数组下标，值为当前下标为顶点值所连通的顶点个数。
     */
    private Bag<Integer>[] adj;

    public Digraph(int v) {
        this.topSize = v;
        this.sideSize = 0;
        adj = new Bag[this.topSize];
        for (int i = 0; i < this.topSize; i++) {
            adj[i] = new Bag<>();
        }
    }


    public int getTopSize() {
        return this.topSize;
    }

    public int getSideSize() {
        return this.sideSize;
    }

    /**
     * v和w是两个顶点，中间加一条边，增加稠密度。
     *
     * @param v 大V是顶点总数，v是顶点值，所以并v不存在大小限制
     * @param w 同上。
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        sideSize++;
    }

    /**
     * 返回一个顶点的连通顶点集合的迭代器
     *
     * @param v
     * @return Bag本身就是迭代器，所以返回该顶点的连通顶点集合Bag即可。
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 将图中所有方向反转
     *
     * @return 返回一个图将所有方向反转后的副本
     */
    public Digraph reverse() {
        Digraph R = new Digraph(topSize);
        for (int v = 0; v < this.topSize; v++) {
            // 遍历原图中跟v顶点连通的顶点w。
            for (int w : adj[v]) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    /**
     * 按照邻接表数组结构输出有向图内容
     *
     * @return
     */
    @Override
    public String toString() {
        String s = topSize + " vertices, " + sideSize + " edges\n";
        for (int v = 0; v < this.topSize; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Digraph d = new Digraph(5);
        d.addEdge(0, 1);
        d.addEdge(1, 0);
        d.addEdge(2, 3);
        d.addEdge(0, 4);
        System.out.println(d);
        /**
         输出：
         5 vertices, 3 edges
         0: 4 1
         1: 0
         2:
         3:
         4:
         */
    }

}
