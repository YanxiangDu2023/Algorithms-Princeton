


import java.util.LinkedList;

public class HashTable {
    private class Entry {


        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[10];
    //是的，数组中的每个链表（LinkedList<Entry>）存储多个 Entry 对象（>=1)，这些 Entry 对象共同组成一个 bucket（桶）。

//    代码的应用场景
//    实现简单的键值存储：
//    存储键值对并能快速查找。
//    解决哈希冲突：
//    通过 链地址法 解决冲突，保证哈希表的性能。
//    模拟 HashMap 工作原理：
//    这段代码是 Java HashMap 工作机制的简单版本

    public void put(int key, String value) {

       var entry = getEntry(key);
       if (entry != null) {
           entry.value = value;
           return;

       }

//       var bucket = getorcreateBucket(key);
//       bucket.add(new Entry(key, value));
        getorcreateBucket(key).add(new Entry(key, value));



//        var index = hash(key); // 计算哈希值，确定存储位置
//        if (entries[index] == null) {
//            entries[index] = new LinkedList<>(); // 如果槽位为空，初始化一个空的 LinkedList
//
//        } else {
////            var entry = new Entry(index, value);  // 创建键值对
////            entries[index].addLast(entry);  // 将键值对添加到槽位对应的 LinkedList 中
//            var bucket = entries[index]; // 获取槽位中的链表
//            for (var entry : bucket) { // 遍历链表
//                if (entry.key == key) { // 如果找到相同的键
//                    entry.value = value; // 更新值
//                    return; // 提前返回，不再插入新键值对
//                }
//            }
//
//            bucket.addLast(new Entry(key, value)); // 如果没有找到相同的键，添加新的键值对
//
//
//        }

    }

    public String get(int key) {
//        var index = hash(key);
//        var bucket = entries[index];
//        for (var entry : bucket) {
//            if (entry.key == key) {
//                return entry.value;
//
//            }
//        }
//        return null;
        var entry = getEntry(key);
        return (entry == null) ? null: entry.value;

    }

    public void remove(int key) {
        var entry = getBucket(key);
        if (entry == null) {
            throw new IllegalStateException();

        }else{
            getBucket(key).remove(entry);
        }
//        var index = hash(key);
//        var bucket = entries[index];
//        if (bucket != null) {
//            throw new IllegalStateException();
//        }
//        for (var entry : bucket) {
//            if (entry.key == key) {
//                bucket.remove(entry.key);
//                return;
//            }
//        }
//        throw new IllegalStateException();

    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getorcreateBucket(int key) {
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null) {
            bucket = new LinkedList<>(); // 创建新的 LinkedList
            entries[index] = bucket;     // 更新 entries[index] 为新链表

        }
        return bucket; // 已经有LinkedList了就直接返回

    }


    private Entry getEntry(int key) {
//        var index = hash(key);
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key) {
                    return entry;
                }
            }
        }
        return null;
    }



    public int hash(int key) {
        return key % entries.length;
    }



    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        table.put(6, "D");
        table.remove(8);
//        System.out.println(table);

        System.out.println(table.get(6));

    }
}