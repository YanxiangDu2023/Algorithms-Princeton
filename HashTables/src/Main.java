import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//import mypackage.HashTable;



import static java.util.Objects.hash;
//import static jdk.internal.classfile.impl.AbstractPoolEntry.hash1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Key: Employee Number (Integer)
        // Value: Name (String)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Mosh");
        map.put(2, "John");
        map.put(3, "Mary");
        map.put(4, "Marianne");
        map.put(null,null); // 可以
        map.remove(null);
        String value = map.get(3);

        map.containsKey(3); //0(1) return 布尔值
        map.containsValue("Mosh");//

        for (Integer item: map.keySet()){
            // 遍历所有键
            System.out.println(item);
        } //返回1234



        for (Map.Entry<Integer, String> item: map.entrySet()){
            // 遍历所有键值对
            System.out.println(item);
//            System.out.println(item.getValue());
        }

        System.out.println(map);
        System.out.println(value);

        // A Green Apple
        // a=2
        //  =2
        // g=1
        CharFinder finder = new CharFinder();
       var ch =  finder.findFirstNonRepeatingChar("a green apple");
       System.out.println(ch);


       // HashSet Function
        // 将一个数组 numbers 中的元素逐一添加到一个 HashSet 中。
        // HashSet 的特点是 不允许重复元素，所以会自动过滤掉数组中的重复值。
        // 最终打印出 不包含重复元素的集合。
       Set<Integer> set = new HashSet<>();
       int[] numbers = {1,2,3,3,2,1,4};
       for (var number : numbers){
           set.add(number);
       }
       System.out.println(set);


       CharFinder finderr = new CharFinder();
       var chr = finderr.findFirstRepeatedChar("green Apple");
       System.out.println(chr);


       Map<Integer, String> map2 = new HashMap<>();
       map2.put(123456, "Mosh");
       System.out.println(CharFinder.hash((123456)));
       // 调用CharFinder下的hash方法要加CharFinder


        Map<String, String> map3 = new HashMap<>();
        map3.put("123456-A", "Mosh");
        System.out.println(CharFinder.hash1(("123456-A")));
        // 调用CharFinder下的hash方法要加CharFinder


        HashTable table = new HashTable();
        table.put(6,"A");
        table.put(7,"B");
        table.put(8,"C");
        table.put(11,"D");
        System.out.println("Done");


    }








    public static int hash(int number){
        // 或者写成在main里
        return number % 100;
        // 返回 number 除以 100 的余数。
    }

}
