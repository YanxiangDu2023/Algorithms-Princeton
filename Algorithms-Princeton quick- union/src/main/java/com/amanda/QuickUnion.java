package com.amanda;


/**
 * @author : Catherine
 */
public class QuickUnion implements UF {
    private final int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * Chase parent pointers until reach root.
     * Deep of i array accesses.
     *
     * @param i the element to find the root for
     * @return the root of the element
     */
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

//    private int root(int i) {
//        while (i != id[i]) {
//            id[i] = id[id[i]]
//            i = id[i];
//        }
//        return i;
//    }







//    调用 root(3) 时，执行的步骤如下：
//
//    第一次迭代：i = 3，id[3] = 4，所以 i 更新为 4。
//    第二次迭代：i = 4，id[4] = 9，所以 i 更新为 9。
//    第三次迭代：i = 9，id[9] = 9，此时 i 和 id[i] 相等，说明找到了根节点，循环结束。
//    最终，root(3) 返回 9，表示元素 3 所在的树的根节点是 9。








    /**
     * Change the root of p to the root of q.
     *
     * @param p one element
     * @param q another element
     */
    @Override
    public void union(int p, int q) {
        int rootP = root(p);
//       调用 root(3) 返回 3（因为 id[3] = 3，3 是它自己的根）。

        int rootQ = root(q);
//       调用 root(4) 返回 4（因为 id[4] = 4，4 是它自己的根）。

        id[rootP] = rootQ;
    //    id[rootP]就是元素p，也就是3所在的根节点
        // 因为 第三次迭代：i = 9，id[9] = 9，此时 i 和 id[i] 相等，说明找到了根节点，循环结束。
//       这表示元素 3 和 4 已经通过将 3 的根连接到 4 的根而连通了。

    }

    /**
     * Check if p and q have the same root.
     * Deep of p and q array accesses.
     *
     * @param p one element
     * @param q another element
     * @return true if p and q are connected, false otherwise
     */
    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
