import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {

        if (input == null){
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();
        // Stack<Character>：栈中存储的是字符类型。

        // 将输入字符串的字符逐个压入栈中
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // 将字符串 input 转换成一个字符数组。
        //例如：输入 "hello"，toCharArray() 变为 ['h', 'e', 'l', 'l', 'o']。

        // 从栈中依次弹出字符，拼接成反转后的字符串
        StringBuilder reversed = new StringBuilder();

//        StringBuilder 是一个可变字符串类，提供高效的字符串拼接、插入、删除等操作。
//        相比 String，StringBuilder 避免了频繁创建新对象，提高了性能。
//        常用方法包括 append()、insert()、delete() 和 reverse()。
//        最终可以通过 toString() 方法将结果转换为不可变的 String。


        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

//    public static void main(String[] args) {
//        StringReverser reverser = new StringReverser();
//        String result = reverser.reverse("hello");
//        System.out.println(result); // 输出: "olleh"
//    }
}
