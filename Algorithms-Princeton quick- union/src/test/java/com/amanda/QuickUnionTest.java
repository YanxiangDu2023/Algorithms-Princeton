package com.amanda;


/**
 * 测试 QuickUnion 类的功能
 */
public class QuickUnionTest {
    public static void main(String[] args) {
        // 创建一个有10个节点的QuickUnion对象
        QuickUnion qu = new QuickUnion(10);

        // 进行一些union操作，连接不同的元素
        qu.union(3, 4);
        qu.union(4, 9);
        qu.union(8, 0);
        qu.union(2, 3);
        qu.union(5, 6);

        // 检查元素间的连通性并输出结果
        System.out.println("3 and 9 connected: " + qu.connected(3, 9)); // 应该输出 true
        System.out.println("5 and 0 connected: " + qu.connected(5, 0)); // 应该输出 false

        // 进行更多union操作
        qu.union(5, 0);
        qu.union(7, 2);

        // 再次检查元素间的连通性并输出结果
        System.out.println("5 and 0 connected: " + qu.connected(5, 0)); // 应该输出 true
        System.out.println("7 and 9 connected: " + qu.connected(7, 9)); // 应该输出 true
    }
}
