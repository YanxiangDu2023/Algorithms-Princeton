// PriorityQueue
// insert(2)
//[1,3,5,7]
// 0 1 2 3
// items[i+1] = items[i]
//  优先队列 插入方法实现
import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[5];
    private int count;

    public void add(int item) {
        if (count == items.length) {
            throw new IllegalStateException();

        }

        int i = shiftItemstoInsert(item);

        items[i + 1] = item;
        count++;

    }

    public int shiftItemstoInsert(int item){
        int i;
        for (i = count - 1; i >= 0; i--){
            // 当队列为空时，没有有效元素，count =0, i = 0-1= -1; 因此 i = -1，插入的位置是 i + 1 = 0。
            if (items[i] > item) {
                // 在 优先队列 中的插入逻辑中，每次比较的范围 只包括已经被填充过的有效部分，
                // 不会和后面的 0（未被填充的地方）进行比较。
                items[i + 1] = items[i]; // 将比新元素大的有效元素向后移动
            } else {
                break;
            }
        }
//        items[i + 1] = item;
//        count++;

        return i;// [15,30,40，0，0，0] add.(20）返回的是15的位置 15后面的位置已经被空出来了，因为30和40都后移了
    }


    public boolean isFull(){
        return count == items.length;
    }




    public int remove(){
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        count = count -1;
        int item = items[count];
        return item;

    }

    public boolean isEmpty(){
        return count ==0;
    }



    public String toString() {
        return Arrays.toString(items);



    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.add(30);
        queue.add(10);
        queue.add(20);
        queue.add(25);
//        queue.add(100);
        queue.add(25);
        System.out.println(queue); // 输出: [10, 20, 25, 30]

//        System.out.println("Removed: " + queue.remove()); // 输出: Removed: 30
//        System.out.println(queue); // 输出: [10, 20, 25]

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }





}
