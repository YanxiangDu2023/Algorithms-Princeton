package com.itheima;

import javax.swing.text.html.HTMLDocument;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.stream.IntStream;
// 这是一个内置接口

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DynamicArray implements Iterable<Integer> {

    // implements Iterable<Integer>：告诉编译器这个类实现了 Iterable，所以必须定义 iterator() 方法。

    private int size = 0; // 逻辑大小
    private int capacity = 8; // 容量
    private int[] array = {};
    ;


    /**
     * 向最后位置 [size] 添加元素
     *
     * @param element 待添加元素
     */
    public void addLast(int element) {
//        array[size] = element;
//        size++;

        add(size, element);
        // 等于在最后加一个


    }


    public void add(int index, int element) {
        checkandgrown ();

        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;

        }
        array[index] = element;
        size++;

    }

    public void checkandgrown() {
        // 容量检查
        if (size == 0) {
            array = new int[capacity]; // 初始值为8


        } else if (size == capacity) {
            // 扩容1.5 1.618 2倍
            capacity = capacity + capacity >> 1;
            int[] newArray = new int[capacity];
            // 把旧数组的元素复制到新数组
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;


        }


    }




    public int get(int index) { // [0,size]
        return array[index];

    }

    public void foreEach(Consumer<Integer> consumer) {
        // 在 Java 中，你可以将接口作为参数传递给方法。这种方式允许你通过不同的实现方式调用方法，尤其在使用函数式接口（如 Consumer<T>）时，这个特性非常有用
        // 当你使用 Consumer<Integer> 时，你正在告诉编译器，T 这个泛型类型应该被替换为 Integer，因此，accept(T t) 方法的参数类型就会变成 Integer
        // Consumer<Integer> 代表的是一个专门用于处理 Integer 类型的 Consumer。
        for (int i = 0; i < size; i++) {
//            System.out.print(array[i]);
            // 提供array[i]
            consumer.accept(array[i]);
        }

    }


    @Override
    public Iterator<Integer> iterator() {

        // 方法 iterator() 实现了 Iterable 接口的 iterator() 方法，返回一个能够遍历 DynamicArray 中元素的 Iterator 对象。
//            iterator(): 方法名。
//            Iterator<Integer>: 返回类型。
//
// Iterator<Integer> 是 iterator() 方法的返回类型。它表示返回的对象是一个 Iterator，并且这个 Iterator 处理的是 Integer 类型的元素。


        return new Iterator<Integer>() {
            // return new Iterator<Integer>() { ... } 是一个匿名类的创建方式。匿名类是没有名字的内联类，通常用于实现接口或者扩展类
            // 这个代码行创建并返回了一个实现了 Iterator<Integer> 接口的匿名类实例。这里的 Iterator<Integer> 是接口
            // 而 { ... } 包含了实现该接口的具体代码，{...}里是对接口里面提供的方法的扩展对吗

            //                重要：Iterator<Integer> 是一个接口，定义了 hasNext() 和 next() 方法。接口仅提供方法的签名，而不提供实现。
//
//
//               2. 匿名内部类实例:
//
//                        new Iterator<Integer>() { ... } 这一部分创建了一个 Iterator<Integer> 接口的匿名内部类实例。这个匿名内部类实现了 Iterator<Integer> 接口，并提供了具体的方法实现。
//               3. 方法实现:
//
//                在 { ... } 大括号内，你提供了 Iterator<Integer> 接口中所有抽象方法的实现。这里有两个方法：
//
//                hasNext(): 检查是否还有剩余的元素。
//                next(): 返回当前的元素，并将指针移动到下一个位置。
//                这些方法是对接口中定义的方法的实际实现。也就是说，你在匿名内部类中扩展了接口提供的方法，使其能够在实际代码中执行特定的功能。
            int i = 0;

            @Override
            public boolean hasNext() {
                // 检查是否有剩余的元素
                return i < size;
            }


            @Override
            public Integer next() {
                // 检查是否有剩余元素，如果没有则抛出异常
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[i++];
            }
            //for-each 循环 通过反复调用 iterator 的 next() 方法来逐个获取元素，并处理这些元素。每次迭代时，element 的值是从 next() 方法中取得的。

        };
    }

    public IntStream stream() {
        return IntStream.of(array);
    }

    // stream() 方法通过 IntStream.of(array) 将内部 int 数组转换为一个 IntStream。

    public int remove(int index) {  //[0,size]

        int removed = array[index];

        if (index < size - 1) {
//            如果是删除最后一个，那也不用复制了
            System.arraycopy(array, index + 1, array, index, size - index - 1);
//        System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
//
//        src: 源数组，表示你想从哪个数组复制元素。在这里是 array。
//        srcPos: 源数组中开始复制的起始位置。在这里是 index + 1，即从需要删除的元素的下一个位置开始复制。
//        dest: 目标数组，表示你想把元素复制到哪个数组。在这里同样是 array，表示数组内自己移动元素。
//        destPos: 目标数组中的起始位置。在这里是 index，表示从删除元素的位置开始填充新数据。
//        length: 需要复制的元素个数。在这里是 size - index - 1，表示从 index + 1 开始的所有剩余元素。
        }

        size--;
        return removed;

//动态数组的扩容


//        public void checkandgrown() {
//            // 容量检查
//            if (size == 0) {
//                array = new int[capacity]; // 初始值为8
//
//
//            } else if (size == capacity) {
//                // 扩容1.5 1.618 2倍
//                capacity = capacity + capacity >> 1;
//                int[] newArray = new int[capacity];
//                // 把旧数组的元素复制到新数组
//                System.arraycopy(array, 0, newArray, 0, size);
//                array = newArray;
//
//
//            }
//
//
//        }


    }
}



























