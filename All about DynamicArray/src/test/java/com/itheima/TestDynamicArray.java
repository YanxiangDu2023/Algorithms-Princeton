package com.itheima;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

public class TestDynamicArray {
    @Test
    @DisplayName("测试添加")
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);


        dynamicArray.add(2, 5);

        int i;
        for (i = 0; i < 5; i++) {
            System.out.println(dynamicArray.get(i));
        }

    }

    @Test
    @DisplayName("测试遍历1")
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);


        dynamicArray.forEach(element -> System.out.println(element));
        // 执行的是 DynamicArray里面public void foreEach(Consumer<Integer> consumer)的方法

    }

    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        for (Integer element : dynamicArray) {
            // 这里是一个for-each循环，
//            for-each 循环的核心是 Iterator 接口。它通过调用 iterator() 方法获取一个 Iterator 对象，然后通过以下两个方法遍历集合：
//
//            hasNext()：判断是否有更多元素。
//            next()：获取下一个元素并移动指针到下一个位置。


            //          for-each循环等同于：
//            Iterator<Integer> iterator = dynamicArray.iterator();
//            while (iterator.hasNext()) {
//                Integer element = iterator.next();
//                System.out.println(element);
//            }

//            在 for-each 循环中：
//
//            Integer 是类型，指定了循环变量的类型。在这个例子中，Integer 表示集合中元素的类型。
//            element 是变量名，在每次循环迭代时，它会被赋值为集合中的下一个元素
           // for-each 循环 通过反复调用 iterator 的 next() 方法来逐个获取元素，并处理这些元素。每次迭代时，element 的值是从 next() 方法中取得的。


            // Java 编译器会自动查找你遍历的对象是否实现了 Iterable 接口，从而调用 iterator() 方法进行遍历。
            // 这就是为什么 DynamicArray 类中的 for-each 循环会调用 iterator() 方法。
//           implements Iterable<Integer>：告诉编译器这个类实现了 Iterable，所以必须定义 iterator() 方法。
//           iterator()：返回一个 Iterator 对象，它提供 hasNext() 和 next() 两个方法来遍历数组。
//           for-each 循环：当你执行 for (Integer element : dynamicArray) 时，编译器自动调用 iterator() 方法，获取迭代器，接着在循环体中调用 hasNext() 和 next()。


//            工作流程
//           1. 初始化: 循环开始时，element 会被赋值为 dynamicArray 中的第一个元素。
//           2. 循环体执行: 循环体中的代码使用当前的 element。
//           3. 下一个元素: 循环继续，element 会被赋值为 dynamicArray 中的下一个元素，直到所有元素都被遍历完。
//           4. 结束循环: 当没有更多的元素时，循环结束。



            System.out.println(element);
        }
    }

        public void test4() {
            DynamicArray dynamicArray = new DynamicArray();
            dynamicArray.addLast(1);
            dynamicArray.addLast(2);
            dynamicArray.addLast(3);
            dynamicArray.addLast(4);
            dynamicArray.addLast(5);

            dynamicArray.stream().forEach(element -> System.out.println(element));



        }


    @Test
    @DisplayName("测试删除")
    public void test5() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        System.out.println("...............................");

        int removed = dynamicArray.remove(2);
        System.out.println(removed);
        System.out.println("...............................");
        dynamicArray.stream().forEach(element -> System.out.println(element));

        System.out.println("...............................");
        assertEquals(3,removed);
//        This is a method provided by testing frameworks like JUnit to assert that the expected value matches the actual value.
//        expected: 3 – This is the value you expect removed to be.
//        actual: removed – This is the value you are testing.



        assertIterableEquals(List.of(1,2,4,5),dynamicArray);

//        assertIterableEquals(expectedIterable, actualIterable): This is a method provided by JUnit to assert that two Iterable instances (like lists) are equal, meaning they contain the same elements in the same order.
//        expectedIterable: List.of(1, 2, 4, 5) – This is the list you expect dynamicArray to be.
//        actualIterable: dynamicArray – This is the list that is being tested.






    }

    public void test6(){
        DynamicArray dynamicArray = new DynamicArray();
        int i;
        for (i=0; i<9; i = i+1){
            dynamicArray.addLast(i+1);

        }

        }
    }




}




