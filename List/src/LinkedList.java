import javax.management.loading.ClassLoaderRepository;
import java.util.NoSuchElementException;

public class LinkedList {
//    Node 类： 定义节点的基本属性（value 和 next）。
//    LinkedList 类： 定义链表的管理逻辑（如 first、last 和操作方法）。
// Node 类确实是嵌套在 LinkedList 类里面的，这是 Java 中内部类的设计，其目的是为了限制 Node 的使用范围，使其仅为 LinkedList 服务。虽然 Node 是嵌套的，
// 但它的职责仍然是独立的，它的存在仅仅是为了辅助 LinkedList 实现链表功能

    private class Node {
        private int value; // 节点存储的值
        private Node next; //指向下一个节点的引用

        public Node(int value) {
            this.value = value; // // 初始化节点的值
        }
//        每个 Node 包含两个属性：
//        value：存储的实际数据（这里是整数 int）。
//        next：指向链表中下一个节点的引用。如果当前节点是最后一个节点，则 next 为 null。


        public void setValue(int value) {
            this.value = value;
        }

    }

    private Node first;
    private Node last;
    private int size;

//    private Node first; // 链表的头节点
//    private Node last;  // 链表的尾节点
    // addLast

    public void addLast(int item) {
        var node = new Node(item); // // 创建一个新节点

        if (isEmpty()) {

            first = last = node;
        }
//        如果 first == null，表示链表为空：
//        将 first 和 last 都指向新节点。

        else {
            last.next = node;
            last = last.next;

        }
//        将当前尾节点的 next 引用指向新节点。
//        更新 last 为新节点。
        size++;

    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (first == null) {
            first = last = node;
        } else {
            node.next = first;
            first = node;

        }
        size++;
    }

    private boolean isEmpty() {
        return first == null;
//           如果链表中没有任何节点（first 为 null），则链表被认为是空的，返回 true。
//           如果链表中至少有一个节点（first 不为 null），则返回 false。

    }


    public int indexof(int item) {
        int index = 0;            // 初始化索引为 0
        var current = first;      // 从链表的第一个节点开始遍历
        while (current != null) { // 遍历链表直到尾节点
            if (current.value == item) { // 如果找到匹配值
                return index;     // 返回当前索引
            }
            current = current.next; // 移动到下一个节点
            index++;              // 索引递增
        }
        return -1;                // 遍历完成未找到，返回 -1
    }

    public boolean contanins(int items) {
        return indexof(items) == -1;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }

        // [10-20-30]
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }
    // 1. 节点（Node）
    //节点是链表的实际数据结构，它包含存储的值（如 10）和指向下一个节点的引用（如 next）。
    //例子：[10] -> [20] -> [30] -> null
    //2. 引用（first、last、next 等）
    //引用是指向某个对象（如节点）的变量，它本身并不是对象，而是一个指针或地址。
    //例子：
    //first 是一个引用，它指向链表的头节点 [10]。
    //first.next 是另一个引用，它指向链表的第二个节点 [20]

    // first -> [20] -> [30] -> null
    //second -> [20] -> [30] -> null

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }
        // [10->20->30]
        // previous -> 20
        // last -> 20
        var previous = getPrevious(last);
        last = previous;
        last.next = null;
        size--;

    }

    private Node getPrevious(Node node) {

        var current = first;
        while (current.next != null) {
            if (current.next == node) {
                return current;

            }
            current = current.next;
        }
        return null;

    }

    public int size() {
        return size;


    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;

        }
        return array;

    }

    public void reverse() {

        var previous = first;
        // previous：初始化为链表的头节点 first，用于保存当前节点的前一个节点。
        var current = first.next;
        // current：初始化为头节点的下一个节点 first.next，用于遍历链表

        while (current != null) {
            var next = current.next; // 保存当前节点的下一个节点
            current.next = previous; // 反转当前节点的 next 指针，指向前一个节点
            previous = current;      // 移动 previous 指针，指向当前节点
            current = next;          // 移动 current 指针，指向下一个节点
        }


        last = first;    // 原头节点变成尾节点
        last.next = null; // 原头节点的 next 设置为 null，作为新的尾节点
        first = previous; // 最后的 previous 是新的头节点


        // first second
    }

    public int getKthFromTheEnd(int k) {
        // 找到单向链表中倒数第 k 个节点，并返回该节点的值。

        if (isEmpty())
            throw new NoSuchElementException();

        var a = first;
        var b = first;

        // 1. 让指针 b 先向前移动 k 步
        for (int i = 0; i < k; i++) {
            if (b == null) // 如果 k 超过了链表的长度
                throw new IllegalArgumentException("k is greater than the length of the list");
            b = b.next;
        }

        // 2. 同时移动 a 和 b，直到 b 到达 null
        while (b != null) {
            a = a.next;
            b = b.next;
        }

        // 3. 此时 a 指向倒数第 k 个节点
        return a.value;
    }




}
