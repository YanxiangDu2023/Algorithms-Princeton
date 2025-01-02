import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char findFirstNonRepeatingChar(String str) {
//
//        1. 方法名称
//        findFirstNonRepeatingChar：
//        意思是“查找第一个非重复字符”。
//        方法名清晰表达了它的功能。
//        2. 方法修饰符
//        public：
//        该方法是公开的，可以被其他类调用。
//        char：
//        返回值的类型是 char，表示方法会返回一个字符。
//        3. 方法参数
//        String str：
//        方法需要一个输入参数 str，类型是 String。
//        表示方法会对传入的字符串 str 进行处理。

        Map<Character, Integer> map = new HashMap<>();
//        map 用于存储字符和它们的出现次数。
//        键：字符（Character 类型）。
//        值：字符出现的次数（Integer 类型）。
        var chars = str.toCharArray();

//        将字符串 str 转换为字符数组 chars。
//        方便后续的遍历操作。


        // 1. 记录每个字符的出现次数
        for (char ch : str.toCharArray()) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

//        遍历字符串中的每个字符 ch。
//        检查字符是否已存在于 map 中：
//        如果已存在，获取当前计数 count = map.get(ch)。
//        如果不存在，默认计数为 0。
//        更新计数：count + 1。
//        将更新后的计数存入 map：map.put(ch, count + 1)。

        for (var ch : chars) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

//        遍历字符数组中的每个字符 ch。
//        对于每个字符，从 map 中获取它的计数：map.get(ch)。
//        如果计数为 1，说明该字符是第一个不重复字符，直接返回。
        return Character.MIN_VALUE;
    }

    public char findFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();

        for (var ch : str.toCharArray()) {
            if (set.contains(ch)) {
                // 将字符串 "green Apple" 转换为字符数组，然后逐一遍历每个字符
                return ch;
                // 代码会在找到第一个重复字符时立即返回，不会继续遍历后续字符。

            }
            set.add(ch);
        }
        return Character.MIN_VALUE;
//        如果遍历完整个字符串后没有找到重复字符，返回 Character.MIN_VALUE。
//        Character.MIN_VALUE 是 Java 中字符的最小值，等价于 '\u0000'，表示空字符。
    }

    public static int hash(int number){
        return number % 100;
        // 返回 number 除以 100 的余数。
    }

    public static int hash1 (String key){
        int hash1 = 0; // 初始化哈希值为0
        for (var ch : key.toCharArray()) { // 遍历字符串的每个字符
            hash1 +=ch; // 累加字符的 ASCII 值
        }
        return hash1; // 返回计算得到的哈希值
    }


    }