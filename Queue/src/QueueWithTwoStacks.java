
import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return stack2.pop();
        // 调用 stack2.pop() 移除并返回 10 栈顶元素被从栈中移除，栈的大小减少1。
        // pop()是移除，peek()才是查看顶部

//        检查队列是否为空：
//        如果 stack1 和 stack2 都为空，则队列为空，抛出异常。
//        将 stack1 转移到 stack2：
//        调用 moveStack1ToStack2()，将 stack1 的元素转移到 stack2。
//        从 stack2 弹出队列头部元素：
//        从 stack2 弹出栈顶元素，返回它。

    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return stack2.peek();

//        与 dequeue 类似，检查队列是否为空。
//        调用 moveStack1ToStack2()，确保 stack2 中包含队列的头部。
//        返回 stack2.peek()，但不移除栈顶元素。
    }

    private void moveStack1ToStack2() {
        if (stack2.empty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

//            什么时候转移：
//            只有当 stack2 为空时才会将 stack1 的元素转移到 stack2。
//            避免重复转移，保持效率。
//            转移过程：
//            将 stack1 中的所有元素依次弹出，并压入 stack2。
//            这样，stack2 的栈顶就变成了队列的头部。
        }
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        return stack2.toString();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
//        queue.dequeue();
//        int first = queue.dequeue();
//        System.out.println(first);
//        System.out.println(first);
        String queue2 = queue.toString();
        System.out.println(queue2);


    }
}