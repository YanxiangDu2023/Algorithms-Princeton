package com.ithema;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestBinarySearch {

    @Test
    @DisplayName("测试 binarySearchBasic")
    public void test1() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchBasic(a, 7));
        assertEquals(1, binarySearchBasic(a, 13));
        assertEquals(2, binarySearchBasic(a, 21));
        assertEquals(3, binarySearchBasic(a, 30));
        assertEquals(4, binarySearchBasic(a, 38));
        assertEquals(5, binarySearchBasic(a, 44));
        assertEquals(6, binarySearchBasic(a, 52));
        assertEquals(7, binarySearchBasic(a, 53));

        assertEquals(-1, binarySearchBasic(a, 0));
        assertEquals(-1, binarySearchBasic(a, 15));
        assertEquals(-1, binarySearchBasic(a, 60));
    }

    private int binarySearchBasic(int[] a, int i) {


        @Test
        @DisplayName("测试右移运算")
        public void test2 () {
            int i = 0;
            int j = Integer.MAX_VALUE - 1;
            // 模拟第一次求中间索引
            int m = (i + j) / 2;
            // 模拟第二次求中间索引, target 在右侧
            i = m + 1;
            assertEquals(1073741824, i);
            assertEquals(2147483646, j);
            assertEquals(-1073741826, i + j);
            m = (i + j) / 2; // 有问题的情况
            assertEquals(-536870913, m);
            m = (i + j) >>> 1; // 改正后的情况
            assertEquals(1610612735, m);
        /*
            同一个二进制数
            1011_1111_1111_1111_1111_1111_1111_1110

            不把最高位视为符号位, 代表 3221225470
            把最高位视为符号位, 代表 -1073741826
         */
        }

    }
}


@Test
@DisplayName("测试 binarySearch java 版")


//方法名和测试描述: 尽管你可以给测试方法取任意名称，JUnit 实际上不依赖方法名来识别测试方法，
//而是依赖于 @Test 注解。你使用的 @DisplayName 注解可以为测试提供一个描述性名称，
//但它并不影响测试方法的执行，而是帮助在测试报告中显示更友好的名字。


public void test5() {
        /*
                ⬇
            [2, 5, 8]       a
            [2, 0, 0, 0]    b
            [2, 4, 0, 0]    b
            [2, 4, 5, 8]    b
         */
    int[] a = {2, 5, 8};
    int target = 4;
    int i = Arrays.binarySearch(a, target);
    assertTrue(i < 0);
    // i = -插入点 - 1  因此有 插入点 = abs(i+1)
    int insertIndex = Math.abs(i + 1); // 插入点索引
    int[] b = new int[a.length + 1];
    System.arraycopy(a, 0, b, 0, insertIndex);
    b[insertIndex] = target;
    System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
    assertArrayEquals(new int[]{2, 4, 5, 8}, b);
}





