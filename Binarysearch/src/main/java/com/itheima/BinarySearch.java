package com.itheima;

public class BinarySearch {



    /**
     * <h3>二分查找基础版</h3>
     *
     * <ol>
     *     <li>i, j, m 指针都可能是查找目标</li>
     *     <li>因为 1. i > j 时表示区域内没有要找的了</li>
     *     <li>每次改变 i, j 边界时, m 已经比较过不是目标, 因此分别 m+1 m-1</li>
     *     <li>向左查找, 比较次数少, 向右查找, 比较次数多</li>
     * </ol>
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return <p>找到则返回索引</p>
     * <p>找不到返回 -1</p>
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;    // 设置指针和初值
        // L 次  元素在最左边要查找 L 次，  元素在最右边要查找 2*L 次
        while (i <= j) {                // i~j 范围内有东西
//            i=j要保证它们相等时也要参与比较
            int m = (i + j) / 2;

//            具体解释：
//            右移运算符 >>> 1：这是一个无符号右移操作符。对于一个整数 n，n >>> 1 将 n 的二进制表示向右移动一位，并在最高位补 0。这相当于将 n 除以 2，并丢弃除法后的余数。
//            在 binarySearchBasic 中的作用：
//            当你写 int m = (i + j) >>> 1; 时，实际上是将 i 和 j 的和 (i + j) 的二进制表示右移一位。这相当于计算 (i + j) / 2，但有一些区别和优势：
//
//            无符号右移：>>> 1 是无符号的，即使是负数也会在右移时在左边补 0。这保证了在计算过程中不会因为溢出而得到负数的结果。
//
//            效率：>>> 是位运算，通常比算术除法 / 更快。虽然在现代处理器上差别可能很小，但在高性能场景下，这种优化是有意义的。
//
//            避免溢出：如果 i 和 j 都是正数并且非常大，i + j 可能会超出 int 的最大值而导致溢出。使用 (i + j) >>> 1 可以避免这个问题，因为 >>> 右移操作不会引发溢出。
//
//
//


            if (target < a[m]) {         // 目标在左边
                j = m - 1;
            } else if (a[m] < target) { // 目标在右边
                i = m + 1;
                // 找到了

            } else {

                return m;
            }
        }
        return -1;
        // 找不到return -1

    }







    /*
        1 [2,3,4,5] 5  右侧没找到更差
        int i = 0, j = a.length - 1;    2
        return -1;                      1
        元素个数                循环次数
        4-7                    3        floor(log_2(4)) = 2+1
        8-15                   4        floor(log_2(8)) = 3+1
        16-31                  5        floor(log_2(16)) = 4+1
        32-63                  6        floor(log_2(32)) = 5+1
        ...                    ...

        循环次数L  = floor(log_2(n)) + 1

        i <= j                   L+1
        int m = (i + j) >>> 1;   L
        target < a[m]            L
        a[m] < target            L
        i = m + 1;               L

        (floor(log_2(n)) + 1) * 5 + 4

        (3) * 5 + 4 = 19*t
        (10 + 1) * 5 + 4 = 59*t
     */

    /*
        问题1: 为什么是 i<=j 意味着区间内有未比较的元素, 而不是 i<j ?
           i==j 意味着 i,j 它们指向的元素也会参与比较
           i<j 只意味着 m 指向的元素参与比较
        问题2: (i + j) / 2 有没有问题?
        问题3: 都写成小于号有啥好处?
     */

/**
 * <h3>二分查找改动版</h3>
 *
 * <ol>
 *     <li>i, m 指针可能是查找目标</li>
 *     <li>j 指针不可能是查找目标</li>
 *     <li>因为 1. 2. i >= j 时表示区域内没有要找的了</li>
 *     <li>改变 i 边界时, m 已经比较过不是目标, 因此需要 i=m+1</li>
 *     <li>改变 j 边界时, m 已经比较过不是目标, 同时因为 2. 所以 j=m</li>
 * </ol>
 *
 * @param a      待查找的升序数组
 * @param target 待查找的目标值
 * @return <p>找到则返回索引</p>
 * <p>找不到返回 -1</p>
 */

}


public static int binarySearchAlternative(int[] a, int target) {
    int i = 0, j = a.length;     // 第一处
    while (i < j) {              // 第二处
        // 如果i=j=m,可能会死循环
        int m = (i + j) >>> 1;
        if (target < a[m]) {
            j = m;               // 第三处
        } else if (a[m] < target) {
            i = m + 1;
        } else {
            return m;
        }
    }
    return -1;
}


/**
 * <h3>二分查找平衡版</h3>
 *
 * <ol>
 *     <li>不奢望循环内通过 m 找出目标, 缩小区间直至剩 1 个, 剩下的这个可能就是要找的(通过 i)</li>
 *     <li>i 指针可能是查找目标</li>
 *     <li>j 指针不可能是查找目标</li>
 *     <li>因为 1. 2. 3. 当区域内还剩一个元素时, 表示为 j - i == 1</li>
 *     <li>改变 i 边界时, m 可能就是目标, 同时因为 2. 所以有 i=m</li>
 *     <li>改变 j 边界时, m 已经比较过不是目标, 同时因为 3. 所以有 j=m</li>
 *     <li>三分支改为二分支, 循环内比较次数减少</li>
 * </ol>
 *
 * @param a      待查找的升序数组
 * @param target 待查找的目标值
 * @return <p>找到则返回索引</p>
 * <p>找不到返回 -1</p>
 */


public static int binarySearchBalance(int[] a, int target) {
    int i = 0, j = a.length;
    while (1 < j - i) {         // 范围内待查找的元素个数 > 1 时
        int m = (i + j) >>> 1;
        if (target < a[m]) {    // 目标在左边
            j = m;
        } else {                // 目标在 m 或右边
            i = m;
        }
    }

    // 等范围内只剩下i，退出循环，在循环外比较a[i]和target
    // 循环内平均比较次数变少



    return (target == a[i]) ? i : -1;
}









/**
 * <h3>二分查找 Leftmost </h3>
 *
 * @param a      待查找的升序数组
 * @param target 待查找的目标值
 * @return <p>找到则返回最靠左索引</p>
 * <p>找不到返回 -1</p>
 */
public static int binarySearchLeftmost1(int[] a, int target) {
    int i = 0, j = a.length - 1;
    int candidate = -1;
    while (i <= j) {
        int m = (i + j) >>> 1;
        if (target < a[m]) {
            j = m - 1;
        } else if (a[m] < target) {
            i = m + 1;
        } else {
            // 记录候选位置
            candidate = m;
            j = m - 1;
        }
    }
    return candidate;
}