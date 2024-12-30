import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Queue<Integer> queue = new ArrayDeque<>();
        // 声明队列变量，使用 ArrayDeque 实现类初始化


//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
////        Integer front = queue.remove();
////        System.out.println(front);
//        System.out.println("Original queue: " + queue); // 输出: [10, 20, 30]
//        reverse(queue);
//        System.out.println("Reversed queue: " + queue); // 输出: [30, 20, 10]

//        队列的头部在左边：
//        每次出队（remove 或 poll），元素从头部（左边）移除。
//        队列的尾部在右边：
//        每次入队（add 或 offer），元素从尾部（右边）加入。
//        队列的特点：FIFO：
//        先进先出，最早加入队列的元素最先被移除

        ArrayQueue arrayQueuequeue = new ArrayQueue(5);
        arrayQueuequeue.enqueue(10);
        arrayQueuequeue.enqueue(20);
        arrayQueuequeue.enqueue(30);
        arrayQueuequeue.enqueue(40);
        arrayQueuequeue.dequeue();
        arrayQueuequeue.enqueue(50);
        arrayQueuequeue.dequeue();
        arrayQueuequeue.enqueue(60);
        arrayQueuequeue.enqueue(70);


//        arrayQueuequeue.dequeue();
        int front = arrayQueuequeue.dequeue();
        System.out.println("Front queue: " + front);
        System.out.println(arrayQueuequeue);

        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.dequeue();
        queue.dequeue();

        int first = queue.dequeue();


        PriorityQueue priorityQueuequeue = new PriorityQueue();
        priorityQueuequeue.add(5);
        priorityQueuequeue.add(3);
        System.out.println(priorityQueuequeue);






    }





    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.push(queue.remove());
//            queue.remove()：从队列的头部移除元素。10 20 30
//            stack.push(...)：将移除的元素压入栈中。10 20 30

            while (!stack.isEmpty()){
                queue.add(stack.pop());
//              stack.pop()：弹出栈顶元素（后进先出）。30 20 10
//              queue.add(...)：将弹出的元素添加到队列尾部。30 20 10
            }
        }


    }







    }