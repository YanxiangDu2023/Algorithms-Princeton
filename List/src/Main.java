import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        System.out.println(list.contains(10)); // 输出 true
        System.out.println(list.indexOf(10)); // 输出 3 (第一个 10 的索引)

        Object[] array = list.toArray();
//        toArray() 是 java.util.Collection 接口中的方法，返回值类型是 Object[]。
//        因为 LinkedList 实现了 Collection 接口，调用 toArray() 默认会返回一个 Object[] 数组。
        System.out.println(Arrays.toString(array)); // 输出 [30, 20, 10, 10, 20, 30]

        var list1 = new LinkedList();
        list1.addLast(10);
        list1.addLast(20);
        list1.addLast(30);
        list1.removeFirst();
        list.removeLast();
        System.out.println(list1.size());
        System.out.println(list1.indexOf(10));
        System.out.println(list1.contains (10));

        list1.reversed();
        System.out.println(Arrays.toString(list1.toArray()));
        // [10









    }
}
