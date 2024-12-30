import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int rear;
    private int count;
    private int front;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (count == items.length) {
            throw new IllegalStateException("Queue is full");
        }
        items[rear] = item;
        rear = (rear + 1) % items.length;

        count++;
    }
    public int dequeue() {
        int item = items[front]; // 1. 获取队列头部元素
        items[front] = 0;        // 2. 将头部元素设置为 0，表示清除
        front = (front + 1) % items.length;
//        front = front + 1;       // 3. 前移队列头部指针
        count--;
        return item;             // 4. 返回移除的元素
    }


    // Shows element at the front of the queue.
    public int peek(){
        return items[front];
    }

    // if count == 0 return True, else Return false;
    public boolean isEmpty(){
        return count == 0;
    }

    // if rear == length of back store (n) then rear is out of bounds-- meaning there's no room to enqueue.
    public boolean isFull(){
       return rear == (rear + 1) % items.length;

    }





    public String toString() {
       return Arrays.toString(items);

    }


}
